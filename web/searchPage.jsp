<%-- 
    Document   : searchPage
    Created on : Mar 7, 2022, 11:12:30 PM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Page</title>
        <link rel="stylesheet" href="mycss.css" type="text/css" />
    </head>
    <body>

        <c:import url="header.jsp"/>
        <p> the website in deploying in ${tmp1} </p>
        <p> Language is used only in this page: ${tmp2}</p>
        <table class="order">
            <tr><th> ID </th>
                <th> Name </th>
                <th> Price </th> 
                <th> Image </th> 
                <th> Details </th> 
                <th> Action </th> 
            </tr>
            <c:forEach var="plant" items="${sessionScope.plantList}">
                <tr><td><c:out value="${plant.getId()}"></c:out></td>
                    <td><c:out value="${plant.getName()}"></c:out></td>
                    <td><c:out value="${plant.getPrice()}"></c:out></td>
                    <td><img src='<c:out value='${plant.getImgpath()}'></c:out>'/></td>
                        <td> <a href = '#' >view detail </a></td>   
                        <td> <a href = 'mainController?action=addToCartServlet&pid=${plant.getId()}' >add to cart </a></td>
                </tr>
            </c:forEach>

        </table>
    </body>
</html>
