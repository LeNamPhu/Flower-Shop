<%-- 
    Document   : manageOrder
    Created on : Mar 11, 2022, 5:13:22 PM
    Author     : admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Order</title>
        <link rel="stylesheet" href="mycss.css" type="text/css" />
    </head>
    <body>
    <body>
        <header>
            <c:import url="header-loginedAdmin.jsp"/>
        </header>
        <form action = "mainController" method = "post">
            <input type="number" name="txtSearch" value="input orderID">
            <input type="submit" value="searchOrder" name="action">
        </form>

        <table class="order">
            <tr><th> Order ID </th>
                <th> Order Date </th>
                <th> Ship Date </th> 
                <th> Status </th> 
                <th> Account ID </th> 
                <th> Complete/Cancel  </th> 
                <th> Update Order </th> 
            </tr>
            <c:forEach var="ord" items="${requestScope.orderList}">
                <tr>
                    <td><c:out value="${ord.getOrderID()}"></c:out></td>
                    <td><c:out value="${ord.getOrderDate()}"></c:out></td>
                    <td><c:out value="${ord.getShipDate()}"></c:out></td>
                    <td><c:choose>
                            <c:when test="${ord.getStatus() eq 1}"> processing </c:when>
                            <c:when test="${ord.getStatus() eq 2}"> completed </c:when>
                            <c:otherwise>cancelled</c:otherwise>
                        </c:choose>
                    </td>
                    <td><c:out value="${ord.getAccID()}"></c:out></td>
                        <td>
                        <c:url var="completeLink" value="mainController">
                            <c:param name="ordID" value="${ord.getOrderID()}"></c:param>
                            <c:param name="url" value="manageOrderServlet"></c:param>  
                            <c:param name="act" value="completeOrder"></c:param>
                            <c:param name="action" value="updateOrderStatus"></c:param>
                        </c:url>
                        <a href="${completeLink}">Complete Order </a>
                        | 
                        <c:url var="cancelLink" value="mainController">
                            <c:param name="ordID" value="${ord.getOrderID()}"></c:param>
                            <c:param name="url" value="manageOrderServlet"></c:param>          
                            <c:param name="act" value="cancelOrder"></c:param>
                            <c:param name="action" value="updateOrderStatus"></c:param>
                        </c:url>
                        <a href="${cancelLink}"> Cancel Order</a>
                    </td>
                    <td>
                        <c:url var="updateLink" value="mainController">
                            <c:param name="action" value="updateOrder"></c:param>
                            <c:param name="id" value="${ord.getOrderID()}"></c:param>

                        </c:url>
                        <a href="${updateLink}"> Update Order</a>
                    </td>
                </tr>
            </c:forEach>
        </table>

    </body>
</html>
