<%-- 
    Document   : viewCart
    Created on : Mar 2, 2022, 2:22:36 PM
    Author     : admin
--%>

<%@page import="DAO.PlantDAO"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Cart</title>
        <link rel="stylesheet" href="mycss.css" type="text/css" />
    </head>
    <body>
        <header>

            <c:import url="header.jsp"/>
        </header>
        <section>

            <h3>Welcome back ${name}</h3>
            <a style=" background-color: #e1f5eb; margin-right: 20px;" href="mainController?action=logout">logout </a>
            <a style=" background-color: #e1f5eb;" href="personalPage.jsp">personal page </a>

            <font style="color:red">${WARNING}</font>
            <table width="100%" class = "shopping">
                <tr><td>ProductID</td><td>Quantity</td><td>Price</td><td>Image</td><td>Action</td></tr>
                <c:set var="total" value="0"/>
                <c:choose> 
                    <c:when test="${cart != null}">
                        <c:forEach var="cartID" items="${sessionScope.cart.keySet()}">   
                                
                            <form action = "mainController" method="post" >
                                <tr>
                                    <td><input type="hidden" value="${cartID}" name ="pid"><a href="getPlantServlet?pid=${cartID}"/>${cartID}</td>
                                    <td><input type="number" value="${sessionScope.cart.get(cartID)}" name ="quantity"></td>
                                    <td>${PlantDAO.getPlant(cartID).getPrice()}</td>
                                    <td><img style="width: 200px; height:200px;"src="${PlantDAO.getPlant(cartID).getImgpath()}" alt="alt"/></td>
                                    <td><input type="submit" value="update" name="action">
                                        <input type="submit" value="delete" name="action"></td>
                                </tr>
                            </form>
                            <c:set var="total" value="${total +( PlantDAO.getPlant(cartID).getPrice() * sessionScope.cart.get(cartID))}"/>   
                        </c:forEach>           
                    </c:when>
                    <c:otherwise>
                        <tr><td>your cart is empty</td></tr>
                    </c:otherwise>

                </c:choose>
                <tr><td>Total money: ${total}</td></tr>
            </table>
        </section>
        <section>
            <form action = "mainController" method = "post" >
                <input type="submit" value="saveOrder" name="action" class="submitorder">

            </form>
        </section>
        <footer>
            <%@include file = "footer.jsp" %>
        </footer>
    </body>
</html>
