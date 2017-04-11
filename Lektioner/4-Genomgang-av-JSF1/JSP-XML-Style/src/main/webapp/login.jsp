<%-- 
    Document   : login
    Created on : 10-Apr-2017, 09:27:06
    Author     : carl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP login sample Page</title>
    </head>
    <body>
        <h1>JSP login sample Page</h1>
        <%@ include file="index.jsp" %>  
        <hr/>  

        <h3>Login Form</h3>  
        <%
            String profile_msg = (String) request.getAttribute("profile_msg");
            if (profile_msg != null) {
                out.print(profile_msg);
            }
            String login_msg = (String) request.getAttribute("login_msg");
            if (login_msg != null) {
                out.print(login_msg);
            }
        %>  
        <br/>  
        <form action="loginprocess.jsp" method="post">  
            Email:<input type="text" name="email"/><br/><br/>  
            Password:<input type="password" name="password"/><br/><br/>  
            <input type="submit" value="login"/>"  
        </form>  
    </body>
</html>

