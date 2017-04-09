package se.nackademin.settings;

/**
 * Created by carl on 04/04/17.
 */
public class Constants {

    public static final Long _TIME_TO_LIVE_IN_MILLISECONDS = 600000L;
    public static final String _LOGGEDIN_USER = "loggedinUser";
    public static final String _REPLACER_BODY_CONTENT = "{bodContent}";
    public static final String _HTML_PAGE_TEMPLATE = "<!DOCTYPE html>\n"
            + "<html>\n"
            + "\t<head>\n"
            + "\t\t<title>Servlet DoLogout</title>\n"
            + "<\t/head>\n"
            + "\t<body>\n"
            + _REPLACER_BODY_CONTENT
            + "\t</body>\n"
            + "</html>";
}
