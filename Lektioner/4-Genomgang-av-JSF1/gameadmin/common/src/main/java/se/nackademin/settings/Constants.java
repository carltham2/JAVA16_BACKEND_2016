package se.nackademin.settings;

/**
 * Created by carl on 04/04/17.
 */
public class Constants {

    public static final Long _TIME_TO_LIVE_IN_MILLISECONDS = 600000L;
    public static final String _LOGGEDIN_USER = "loggedinUser";
    public static final String _REPLACER_BODY_CONTENT = "{bodContent}";
    public static final String _HTML_PAGE_TEMPLATE
            = "<!DOCTYPE html>\n"
            + "<html>\n"
            + "    <head>\n"
            + "        <meta charset=\"windows-1252\" />\n"
            + "        <title>Servlet Login vs. JSP Login</title>\n"
            + "        <link rel=\"stylesheet\"  type=\"text/css\" href=\"css/default.css\" />\n"
            + "    </head>\n"
            + "    <body>\n"
            + "\n"
            + "        <h2>Servlet Login vs. JSP Login</h2>\n"
            + "        <ul>\n"
            + "            <li><a class=\"active\" href=\"index.html\">Home</a></li>\n"
            + "            <li><a href=\"servletLogin.html\">Servlet Login</a></li>\n"
            + "            <li><a href=\"JSP/jspLogin.jsp\">JSP Login</a></li>\n"
            + "        </ul>\n"
            + "\n"
            + "\n"
            + "        <div class=\"rcorners dottedBorders\">\n"
            + "\n" + _REPLACER_BODY_CONTENT
            + "        </div> \n"
            + "    </body>\n"
            + "</html>";
    public static final String _REPLACER_PATH = "{path}";
    public static final String _INIT_LOGOUT_FORM
            = "\t\t<form name=\"logoutform\" action=\"" + _REPLACER_PATH + "/logout\" method=\"POST\" >\n"
            + "\t\t\t<input type=\"submit\" value=\"Logout\"/>\n"
            + "\t\t\t<input type=\"hidden\" name=\"logoutState\" value=\"confirmLogout\"/>\n"
            + "\t\t</form>\n";
    public static final String _DO_LOGOUT_FORM = "\t\t<form name=\"logoutform\" action=\"" + _REPLACER_PATH + "/logout\"  method=\"POST\">\n"
            + "\t\t\t<Label>ÄR DU VERKLIGEN SÄKER ?</Label>\n"
            + "\t\t\t<input name=\"answear\" type=\"submit\" value=\"JA\"/>\n"
            + "\t\t\t<input name=\"answear\" type=\"button\" onclick=\"window.history.back();\" value=\"NEJ\"/>\n"
            + "\t\t\t<input type=\"hidden\" name=\"logoutState\" value=\"doLogout\"/>\n"
            + "\t\t</form>\n";

    public static final String _CONTENTTYPE_TETXT = "text/html";
}
