package se.nackademin.servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author carl
 */
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Accounts extends HttpServlet {

    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        out.println("</br>controller - BEGIN</br><div style=\"color:blue;\">");

        out.println("<br/><u>Following are your Bill Particulars</u><br><br>");

        // attach rate per unit of power to req object
        req.setAttribute("unitRate", new Double(8.75));

        // create an object of RequestDispatcher
        RequestDispatcher dispatcher = req.getRequestDispatcher("/view");
        // view is the alias name of second Servlet, Billing

        // send the client data available with req of the controller (Accounts) to req of view (Billing) with include()
        dispatcher.include(req, res);
        // add extra information to req of the controller to be sent to client
        out.println("<br><br>Please pay the bill amount before 5th"
                + " of every month to avoid penalty and disconnection");

        out.println("</div></br>controller - END</br>");

// In any case present an option to orientatte out from the display page.
// Here we just go to the previous page
        out.println("<p><button onclick=\"goBack()\">Go Back</button>\n"
                + "\n"
                + "<script>\n"
                + "function goBack() {\n"
                + "    window.history.back();\n"
                + "}\n"
                + "</script></p>");
        out.close();
    }
}
