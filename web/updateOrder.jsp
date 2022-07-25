<%-- 
    Document   : updateOrder
    Created on : Mar 12, 2022, 3:45:37 PM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <p>updating order id ${order.getOrderID()}</p>
        <form action="mainController" method="post" class="form">
            <input type="hidden" name="txtOrderID" value="${order.getOrderID()}" />
            <table>
                <tr><td>Order Date</td><td><input type="text" name="txtOrdDate" required="" value="${order.getOrderDate()}" /></td></tr>
                <tr><td>Ship Date</td><td><input type="text" name="txtShipDate" required="" value="${order.getShipDate()}" /></td></tr>
                <tr><td>Status</td><td><input type="text" name="txtStatus" required="" value="${order.getStatus()}" /></td></tr>
                <td colspan = "2"> <input type = "submit" value = "updateOrderInfo" name="action"> </td>
            </table>
        </form>
    </body>
</html>
