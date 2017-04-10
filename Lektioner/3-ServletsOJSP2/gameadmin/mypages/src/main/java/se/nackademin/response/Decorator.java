/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nackademin.response;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author carl
 */
public class Decorator {

    public static final String _BACK_BUTTON
            = "<p><button onclick=\"goBack();\">Go Back</button>\n"
            + "\n"
            + "<script>\n"
            + "function goBack() {\n"
            + "    window.history.back();\n"
            + "}\n"
            + "</script></p>";

    public static void addBackButtons(PrintWriter writer) {
        // In any case present an option to orientatte out from the display page.
// Here we just go to the previous page
        writer.println(_BACK_BUTTON);
    }

    public static void addLogoutForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/logout");
        dispatcher.include(request, response);
    }

    public static String getBackButton() {
        return _BACK_BUTTON; 
    }
    

}
