/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nackademin.servlets.functions;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import se.nackademin.domain.IUser;
import se.nackademin.domain.User;
import se.nackademin.settings.Constants;

/**
 *
 * @author carl
 */
@WebServlet(name = "loggedin", urlPatterns = {"/loggedin"})
public class Loggedin extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType(Constants._CONTENTTYPE_TETXT);
        response.setCharacterEncoding(StandardCharsets.UTF_8.toString());

        String responseString = "";
        responseString += "<div style=\\\"color:red;\\\"></br>Loggedin servlet view - BEGIN</br>";
        HttpSession session = request.getSession();
        ObjectInputStream objectInputStream;
        IUser requestUser = (IUser) session.getAttribute(Constants._LOGGEDIN_USER);
        if (requestUser == null) {
            objectInputStream = new ObjectInputStream(request.getInputStream());
            try {
                requestUser = (IUser) objectInputStream.readObject();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Loggedin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (requestUser == null || requestUser.sessionIsTimedOut()) {
            responseString
                    += "<p style=\"color:red;\">Du är inte inloggad, logga in först !!!</p>";
        } else {

            String username = requestUser.getUserName();
            String name = requestUser.getName();
            responseString += "<p style=\"color:blue;\">Välkommen du är nu inloggad :<br/>";
            responseString += "Användarnamn : " + username + "<br/>";
            responseString += "Namn : " + name + "</p>";
            responseString += "</br>Loggedin servlet view - End</br></div>";
        }
        PrintWriter writer = response.getWriter();
        writer.println(responseString);
        writer.close();
    }
}
