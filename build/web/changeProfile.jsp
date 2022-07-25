<%-- 
    Document   : changeProfile
    Created on : Mar 20, 2022, 5:32:21 PM
    Author     : admin
--%>
<%@page import="DAO.AccountDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Profile</title>
    </head>
    <body>
        <header>
            <%@include file = "header-loginedUser.jsp" %>
        </header>
        
        <h1>Change Profile of Email: ${sessionScope.email}</h1>
        <form action="mainController" method="post" style="margin:auto;width:150px;">
            <p style="margin-bottom: 5px;">Fullname: </p><input style="width:200px; height: 30px;"type="text" name="txtFullname" value="${AccountDAO.takeAccount(sessionScope.email).getFullname()}" required="">
            <p style="margin-bottom: 5px;">Phone: </p><input style="width:200px; height: 30px;" type="text" name="txtPhone" value="${AccountDAO.takeAccount(sessionScope.email).getPhone()}" required="">
            <p style="margin-bottom: 5px;">Password: </p><input style="width:200px;height: 30px;"type="text" name="txtPassword" value="${AccountDAO.takeAccount(sessionScope.email).getPassword()}" required="">
            <input style="width:150px; height: 40px;font-size: 20px; margin:20px;" type="submit" name="action" value="editProfile">
        </form>
            <footer>
            <%@include file = "footer.jsp" %>
        </footer>
                
    </body>
</html>
