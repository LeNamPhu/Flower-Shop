<%-- 
    Document   : header-loginedAdmin
    Created on : Mar 5, 2022, 10:59:29 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="mycss.css" type="text/css" />
    </head>
    <body>

        <nav>
            <ul>
                <li><a href="mainController?action=manageAccount">Manage Account</a></li>
                <li><a href="mainController?action=manageOrder">Manage Order</a></li>
                <li><a href="mainController?action=managePlant">Manage Plants</a></li>
                <li><a href="mainController?action=manageCate">Manage Categories</a></li>
                <li>Welcome ${sessionScope.name} | <a href="mainController?action=logout">log out</a></li>

            </ul>
        </nav>


    </body>
</html>
