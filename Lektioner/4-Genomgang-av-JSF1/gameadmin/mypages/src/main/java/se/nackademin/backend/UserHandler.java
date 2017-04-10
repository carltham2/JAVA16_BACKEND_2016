/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nackademin.backend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import se.nackademin.domain.IUser;
import se.nackademin.domain.User;
import se.nackademin.settings.Constants;

/**
 *
 * @author carl
 */
public class UserHandler {

    private static String _BACKEND_APPLICATION_PATH = "http://localhost:8080/backend/";

    public static IUser doLogin(String username, String password) {
        User user = new User(username, password);
        URL url = null;

        try {
            url = new URL(_BACKEND_APPLICATION_PATH + "login");
            user = (User) performRequest(url, user);
        } catch (MalformedURLException ex) {
            Logger.getLogger(UserHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    public static IUser doLogout(User user) {
        URL url = null;

        try {
            url = new URL(_BACKEND_APPLICATION_PATH + "logout");
            user = (User) performRequest(url, user);
        } catch (MalformedURLException ex) {
            Logger.getLogger(UserHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    public static Object performRequest(URL url, IUser requestUser) {
        ObjectOutputStream outputStream = null;
        ObjectInputStream objectInputStream = null;
        Object responseObject = null;
        try {
            HttpURLConnection uRLConnection = (HttpURLConnection) url.openConnection();
            uRLConnection.setDoOutput(true); // to be able to write.
            uRLConnection.setDoInput(true); // to be able to read.
            outputStream = new ObjectOutputStream(uRLConnection.getOutputStream());
            outputStream.writeObject(requestUser);

            String contentType = uRLConnection.getContentType();
            if (contentType != null && contentType.startsWith(Constants._CONTENTTYPE_TETXT)) {

                BufferedReader in = new BufferedReader(new InputStreamReader(
                        uRLConnection.getInputStream()));
                String inputLine;
                String responseString = "";
                while ((inputLine = in.readLine()) != null) {
                    responseString += inputLine;
                    System.out.println(inputLine);
                }
                in.close();
                responseObject = responseString;
            } else {
                objectInputStream = new ObjectInputStream(uRLConnection.getInputStream());
                responseObject = objectInputStream.readObject();
            }
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(UserHandler.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(UserHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return responseObject;
    }

}
