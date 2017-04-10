/**
 * Created by carl on 04/04/17.
 */
package se.nackademin.servlets.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import se.nackademin.response.Decorator;
import se.nackademin.backend.UserHandler;
import se.nackademin.domain.IUser;
import se.nackademin.settings.Constants;

public class DoLogin extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String applicationPath = request.getRequestURL().substring(0, request.getRequestURL().length()-request.getServletPath().length());

// prepare headers
        response.setContentType("text/html");

        PrintWriter writer = handleLogin(response, request, applicationPath);
        writer.close();
    }

    public PrintWriter handleLogin(HttpServletResponse response,
            HttpServletRequest request, String applicationPath)
            throws ServletException, IOException {

        String bodyContent = ""; 

// Prepare any variables to use in this function
        String username = request.getParameter("userName");
        String password = request.getParameter("password");

        PrintWriter writer = response.getWriter();
        // Check if the session already is active
        HttpSession session = request.getSession();
        IUser user = (IUser) session.getAttribute(Constants._LOGGEDIN_USER);
        if (user != null && !user.sessionIsTimedOut()) {
            bodyContent
                    += "<p style=\"color:red;\">Du är redan inloggad som : "
                    + user.getName() + "!!!</p>"; 

            bodyContent = addLogoutForm(bodyContent, applicationPath);
        } else {
// Othervise check login details
            user = UserHandler.doLogin(username, password);
            if (user != null && user.getPassword().equals(password)) {

                session.setAttribute(Constants._LOGGEDIN_USER, user);

                URL loggedinPath = new URL(applicationPath + "/loggedin");
                bodyContent += UserHandler.performRequest(loggedinPath,user);

                bodyContent = addLogoutForm(bodyContent, applicationPath);
            } else {
                bodyContent += "<p style=\"color:red;\">Fel användarnamn / lösenord</p>" +Decorator._BACK_BUTTON;
            }
        }
//        Decorator.addBackButtons(writer);
        String responseString = Constants._HTML_PAGE_TEMPLATE.replace(Constants._REPLACER_BODY_CONTENT, bodyContent);
        writer.println(responseString);
        return writer;
    }

    private String addLogoutForm(String bodyContent, String path) {
        bodyContent
                += Constants._INIT_LOGOUT_FORM.replace(Constants._REPLACER_PATH, path);
        return bodyContent;
    }

}
