<%-- 
    Document   : userdetails
    Created on : 09-Apr-2017, 14:35:28
    Author     : carl
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <script>
            function goBack() {
                window.history.back();
            }
        </script>
        <link rel="stylesheet"  type="text/css" href="../css/default.css" />
    </head>
    <body>
        <jsp:include page="header.jspf"/>
        <div class="rcorners">
            <c:set var="loggedinUser" value="${sessionScope.loggedinUser}"/>
            <c:if test="${not empty loggedinUser and not loggedinUser.sessionIsTimedOut()}">

                <p style="color:red;">Du är redan inloggad som : 
                    "${loggedinUser.name}" !!!</p>
                    <jsp:include page="/logout"/>

            </c:if>
            <c:if test="${empty loggedinUser || loggedinUser.sessionIsTimedOut()}">
                <jsp:useBean id="authenticator" class="se.nackademin.backend.UserHandler" scope="session"/>
                <c:set var="user" value="${authenticator.doLogin(param.userName, param.password)}"/>
                <c:if test="${not empty user && user.getPassword().equals(param.password)}">                
                    <c:set var="loggedinUser" value="${user}" scope="session"  />
                    <jsp:include page="/loggedin"/>
                    <jsp:include page="/logout"/>
                </c:if>
                <c:if test="${empty user || not user.getPassword().equals(param.password)}">
                    <p style="color:red;">Fel användarnamn / lösenord</p>
                    <p><button onclick="goBack();">Go Back</button></p>
                </c:if>
            </c:if>
        </div>
    </body>
</html>
