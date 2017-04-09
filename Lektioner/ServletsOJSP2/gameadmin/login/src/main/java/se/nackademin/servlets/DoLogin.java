/**
 * Created by carl on 04/04/17.
 */
package se.nackademin.servlets;

import se.nackademin.backend.FakeDB;
import se.nackademin.domain.User;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import se.nackademin.settings.Constants;

public class DoLogin extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        handlePOST(request, response);
    }

    private void handlePOST(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

// Prepare any variables to use in this function
        String username = request.getParameter("username");
        String password = request.getParameter("password");

// prepare headers
        response.setContentType("text/html");

        PrintWriter writer = response.getWriter();

        // Check if the session already is active
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(Constants._LOGGEDIN_USER);
        if (user != null && !user.sessionIsTimedOut()) {
            writer.println(
                    "<p style=\"color:red;\">Du är redan inloggad som : "
                    + username + "!!!</p>");

            addLogoutForm(request, response);
        } else {
// Othervise check login details
            user = FakeDB.login(username, password);
            if (user != null && user.getPassword().equals(password)) {

                session.setAttribute(Constants._LOGGEDIN_USER, user);
                // create an object of RequestDispatcher
                RequestDispatcher dispatcher = request.getRequestDispatcher("/loggedin");
                // view is the alias name of second Servlet, Billing

                // send the client data available with req of the controller (Accounts) to req of view (Billing) with include()
                dispatcher.include(request, response);

                addLogoutForm(request, response);
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
        writer.close();
    }

    private void addLogoutForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/logout");
        dispatcher.include(request, response);
    }
}
