/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nackademin.servlets.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import se.nackademin.backend.UserHandler;
import se.nackademin.domain.User;
import se.nackademin.settings.Constants;

/**
 *
 * @author carl
 */
@WebServlet(name = "DoLogout", urlPatterns = {"/logout"})
public class DoLogout extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter writer = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        String logoutState = "" + request.getParameter("logoutState");
        String applicationPath = request.getRequestURL().substring(0, request.getRequestURL().length()-request.getServletPath().length());
        switch (logoutState) {
            case "confirmLogout":
                
                String confirmLogoutForm = Constants._DO_LOGOUT_FORM.replace(Constants._REPLACER_PATH, applicationPath);
                String confirmLogoutPage = Constants._HTML_PAGE_TEMPLATE.replace(Constants._REPLACER_BODY_CONTENT, confirmLogoutForm);
                writer.println(confirmLogoutPage);
                break;
            case "doLogout":
                String answear = request.getParameter("answear");
                if (answear != null && "JA".equals(answear)) {
                    response.setContentType("text/html");
                    HttpSession session = request.getSession();
                    User loggedinUser = (User) session.getAttribute(Constants._LOGGEDIN_USER);
                    UserHandler.doLogout(loggedinUser);
                    session.removeAttribute(Constants._LOGGEDIN_USER);
                    response.sendRedirect(request.getContextPath() + "/index.html");
                }

                break;
            default:
                String initLogoutForm = Constants._INIT_LOGOUT_FORM.replace(Constants._REPLACER_PATH, applicationPath);
                writer.println(initLogoutForm);
        }
    }

}
