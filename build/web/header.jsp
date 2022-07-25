<%-- 
    Document   : header
    Created on : Feb 25, 2022, 11:23:29 PM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Header</title>
        <link rel="stylesheet" href="mycss.css" type="text/css" />
    </head>
    <body>
        <header>
            <nav>
                <ul>
                    <li><a href=""><img src="images/logo.jpg" width="100" height="100"></a> </li>
                    <li><a href="index.jsp">Home</a></li>
                    <li><a id="step1" href="registration.jsp">Register</a></li>
                    <li><a href="login.jsp" >Login</a></li>
                    <li><a href="mainController?action=viewcart" >View cart</a></li>
                    <li><a href="personalPage.jsp">Personal Page</a></li>
                    <li><form action="mainController" method = "post" class="form">
                            <input type="text" name="txtsearch" value="<%= (request.getParameter("txtsearch") == null) ? "" : request.getParameter("txtsearch")%>">
                            <select name="searchby"><option value="byname">By name</option>
                                <option value="bycate">By category</option>
                            </select>
                            <input type="submit" value="search" name="">
                        </form></li>

                </ul> 
            </nav>
        </header>
    </body>
</html>
