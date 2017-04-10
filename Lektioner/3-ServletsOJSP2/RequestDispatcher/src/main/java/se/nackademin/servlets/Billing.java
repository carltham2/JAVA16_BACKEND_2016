/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nackademin.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author carl
 */
public class Billing extends HttpServlet {

    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        out.println("</br>view - BEGIN</br><div style=\"color:red;\">");

        // extract the client data from req object.  Infact, this is actually to be done by the controller 
        String latestReadingString = req.getParameter("latestReading");
        // for previous reading, above two steps in one step
        String previousReadingString = req.getParameter("previousReading");
        if (latestReadingString == null || previousReadingString == null || latestReadingString.isEmpty() || previousReadingString.isEmpty()) {
            out.println("<p style=\"color:red;\">The readings are not valid!!<p>");
        } else {
            // Integervalues for computing
            int latestReading = Integer.parseInt(latestReadingString);
            int previousReading = Integer.parseInt(previousReadingString);

            // read rate per unit from req object
            Object obj = req.getAttribute("unitRate");
            Double d1 = (Double) obj;
            double rate = d1.doubleValue();

            // now left is to prepare the bill
            int noOfUnits = latestReading - previousReading;
            double amountPayable = noOfUnits * rate;

            // prepare response.  This response is added to the controller response
            out.println("Previous reading: " + previousReading);
            out.println("<br>Current reading: " + latestReading);
            out.println("<br>Bill Amount Rs." + amountPayable);
            out.println("</div></br>view - END</br>");
        }
        // do not close out object 

    }
}
