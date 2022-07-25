<%-- 
    Document   : viewOrder
    Created on : Mar 21, 2022, 12:16:55 AM
    Author     : admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="mycss.css" type="text/css" />
    </head>
    <body>
        <header>
            <c:import url="header-loginedUser.jsp"/>
        </header>



        <c:forEach var="ord" items="${requestScope.orderList}">
            <table class="order">
                <tr><td> Order ID </td>
                    <td> Order Date </td>
                    <td> Ship Date </td> 
                    <td> Status </td> 


                </tr>
                <tr>
                    <td><c:out value="${ord.getOrderID()}"></c:out></td>
                    <td><c:out value="${ord.getOrderDate()}"></c:out></td>
                    <td><c:out value="${ord.getShipDate()}"></c:out></td>
                    <td><c:choose>
                            <c:when test="${ord.getStatus() eq 1}"> processing<br/><a href="mainController?action=updateOrderStatus&act=cancelOrder&ordID=${ord.getOrderID()}&url=personalPage.jsp"> cancel order</a> </c:when>
                            <c:when test="${ord.getStatus() eq 2}"> completed </c:when>
                            <c:otherwise>cancelled <a href="mainController?action=updateOrderStatus&act=replaceOrder&ordID=${ord.getOrderID()}&url=personalPage.jsp"> Reorder</a></c:otherwise>
                        </c:choose>
                    </td>


                </tr>
            </table>
        </c:forEach>

    </body>
</html>
