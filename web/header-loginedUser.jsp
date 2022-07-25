<%-- 
    Document   : header_loginedUser
    Created on : Feb 26, 2022, 12:34:28 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Header</title>
        <link rel="stylesheet" href="mycss.css" type="text/css" />
    </head>
    <body>
        <nav>
            <ul>

                <li><a href="index.jsp">Home</a></li>
                <li><a href="changeProfile.jsp">Change Profile</a></li>
                <li><a href="mainController?action=viewOrder&status=2" >Completed Orders</a></li>
                <li><a href="mainController?action=viewOrder&status=3" >Cancelled Orders</a></li>
                <li><a href="mainController?action=viewOrder&status=1" >Processing Orders</a></li>
                <li><a href="personalPage.jsp">Personal Page</a></li>
                <li>
                    <form action="mainController" method="post">
                        from<input type="date" name ="from" required=""> to <input type="date" name ="to" required="">
                    <input type ="submit" value = "searchDate" name="">
                    </form>
                </li>
            </ul> 
        </nav>
    </body>
</html>
