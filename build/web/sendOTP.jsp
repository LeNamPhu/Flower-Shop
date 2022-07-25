<%-- 
    Document   : sendOTP
    Created on : Mar 7, 2022, 7:35:38 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Send OTP</title>
        <link rel="stylesheet" href="mycss.css" type="text/css" />
    </head>
    <body>
        <header>
            <%@include file = "header.jsp" %>

        </header>
        <h1>Servlet send OTP at ${contextPath} </h1>
        <p>please check your email : ${email} a confirm code is sent to you </p>
        <a href="index.jsp"> Main Page</a>
    </body>
    <footer>
        <%@include file = "footer.jsp" %>
    </footer>
</html>
