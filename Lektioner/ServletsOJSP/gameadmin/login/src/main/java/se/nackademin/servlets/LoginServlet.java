/**
 * Created by carl on 04/04/17.
 */
package se.nackademin.servlets;

import se.nackademin.backend.FakeDB;
import se.nackademin.domain.User;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        PrintWriter writer = response.getWriter();
        writer.println("Från GET :");
        String message = "Username is : " + username + "<br/> Password is :" + password;
        writer.println(message);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        handlePOST(request, response);
    }

    private void handlePOST(HttpServletRequest request, HttpServletResponse response) throws IOException {

// Prepare any variables to use in this function
        String username = request.getParameter("username");
        String password = request.getParameter("password");

// prepare headers
        response.setContentType("text/html");

        PrintWriter writer = response.getWriter();

        // Check if the session already is active
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(username);
        if (user != null && !user.isSessionTimedOut()) {
            writer.println(
                    "<p style=\"color:red;\">Du är redan inloggad som : "
                    + username + "!!!</p>");
        } else {
// Othervise check login details
            user = FakeDB.login(username, password);
            if (user != null && user.getPassword().equals(password)) {
                writer.println("<p style=\"color:blue;\">Välkommen du är nu inloggad :<br/>");
                writer.println("Användarnamn : " + username + "</p>");
                session.setAttribute(username, user);
            } else {
                writer.println("<p style=\"color:red;\">Fel användarnamn / lösenord</p>");
            }
        }

// In any case present an option to orientatte out from the display page.
// Here we just go to the previous page
        writer.println("<p><button onclick=\"goBack()\">Go Back</button>\n"
                + "\n"
                + "<script>\n"
                + "function goBack() {\n"
                + "    window.history.back();\n"
                + "}\n"
                + "</script></p>");
// response.sendRedirect("/loggedin"); 
    }
}
