/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nackademin.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(Constants._LOGGEDIN_USER);

        if (user != null && user.sessionIsTimedOut()) {
            writer.println(
                    "<p style=\"color:red;\">Du är inte inloggad, logga in först !!!</p>");
            session.removeAttribute(Constants._LOGGEDIN_USER);
        } else {

            String username = user.getUserName();
            writer.println("</br>view - BEGIN</br><div style=\"color:red;\">");

            writer.println("<p style=\"color:blue;\">Välkommen du är nu inloggad :<br/>");
            writer.println("Användarnamn : " + username + "</p>");
        }
    }
}
