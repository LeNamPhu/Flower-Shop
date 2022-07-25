<%-- 
    Document   : ManageAccount
    Created on : Mar 6, 2022, 4:49:40 PM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Account</title>
        <link rel="stylesheet" href="mycss.css" type="text/css" />
    </head>
    <body>
        <header>
            <c:import url="header-loginedAdmin.jsp"/>
        </header>
        <form action = "mainController" method = "post">
            <input type="text" name="txtSearch" value="input email">
            <input type="submit" value="searchAccount" name="action">
        </form>
        <table class="order">
            <tr><th> ID </th>
                <th> Email </th>
                <th> Full Name </th> 
                <th> Status </th> 
                <th> Phone </th> 
                <th> Role </th>
                <th> Action </th> 
            </tr>
            <c:forEach var="acc" items="${requestScope.accountList}">
                <tr><td><c:out value="${acc.getAccID()}"></c:out></td>
                    <td><c:out value="${acc.getEmail()}"></c:out></td>
                    <td><c:out value="${acc.getFullname()}"></c:out></td>
                    <td><c:choose>
                            <c:when test="${acc.getStatus() eq 1}"> active </c:when>
                            <c:otherwise>inActive</c:otherwise>
                        </c:choose>
                    </td>
                    <td><c:out value="${acc.getPhone()}"></c:out></td>
                    <td><c:choose>
                            <c:when test="${acc.getRole() eq 1}"> admin </c:when>
                            <c:otherwise>user</c:otherwise>
                        </c:choose>
                    </td>

                    <td>
                        <c:if test="${acc.getRole() eq 0}">
                            <c:url var="mylink" value="mainController">
                                <c:param name="email" value="${acc.getEmail()}"></c:param>
                                <c:param name="status" value="${acc.getStatus()}"></c:param>
                                <c:param name="action" value="updateStatusAccount"></c:param>
                            </c:url>
                            <a href="${mylink}">Block/Unblock</a>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
