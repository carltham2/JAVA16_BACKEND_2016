<%-- 
    Document   : index
    Created on : 09-Apr-2017, 14:34:08
    Author     : carl
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>JSP Login Page Sample</title>
        <link rel="stylesheet"  type="text/css" href="../css/default.css" />
    </head>
    <body>
        <h2>JSP Login Page Sample</h2>
        <div class="rcorners">
            <form action="login.jsp" method="post"> 
                User Name: <input type="text" name="userName" value="carl"><br> 
                User Password: <input type="password" name="password" value="secret"><br> 
                <input type="submit" value="Login"> 
            </form>
        </div>
    </body>
</html>
