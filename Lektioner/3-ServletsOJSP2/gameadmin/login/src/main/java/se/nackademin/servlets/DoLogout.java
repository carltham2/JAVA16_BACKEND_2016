/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nackademin.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
        switch (logoutState) {
            case "initLogout":
                String doLogoutForm = "\t\t<form name=\"logoutform\" action=\"logout\"  method=\"POST\">\n"
                        + "\t\t\t<Label>ÄR DU VERKLIGEN SÄKER ?</Label>\n"
                        + "\t\t\t<input name=\"answear\" type=\"submit\" value=\"JA\"/>\n"
                        + "\t\t\t<input name=\"answear\" type=\"button\" onclick=\"window.history.back();\" value=\"NEJ\"/>\n"
                        + "\t\t\t<input type=\"hidden\" name=\"logoutState\" value=\"doLogout\"/>\n"
                        + "\t\t</form>\n";
                writer.println(doLogoutForm);
                break;
            case "doLogout":
                String answear = request.getParameter("answear");
                if (answear != null && "JA".equals(answear)) {
                    response.setContentType("text/html");
                    HttpSession session = request.getSession();
                    session.removeAttribute(Constants._LOGGEDIN_USER);
                    response.sendRedirect(request.getContextPath() + "/index.html");
                }

                break;
            default:
                String initLogoutForm = "\t\t<form name=\"logoutform\" action=\"logout\" method=\"POST\" >\n"
                        + "\t\t\t<input type=\"submit\" value=\"Logout\"/>\n"
                        + "\t\t\t<input type=\"hidden\" name=\"logoutState\" value=\"initLogout\"/>\n"
                        + "\t\t</form>\n";
                writer.println(initLogoutForm);
        }
    }

}
