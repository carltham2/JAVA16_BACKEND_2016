<%-- 
    Document   : userdetails
    Created on : 09-Apr-2017, 14:35:28
    Author     : carl
--%>

<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:useBean id="userinfo" class="se.nackademin.domain.Details"></jsp:useBean> 
        <jsp:setProperty property="*" name="userinfo"/> 
        You have enterted below details:<br> 
        <jsp:getProperty property="username" name="userinfo"/><br> 
        <jsp:getProperty property="password" name="userinfo"/><br> 
        <jsp:getProperty property="age" name="userinfo" /><br>
    </body>
</html>
