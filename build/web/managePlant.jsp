<%-- 
    Document   : managePlant
    Created on : Mar 15, 2022, 3:10:54 PM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="mycss.css" type="text/css" />
    </head>
    <body>
        <header>
            <c:import url="header-loginedAdmin.jsp"/>
        </header>
        <a href="addPlant.jsp">Add Plant</a>
        <table class="order">
            <tr><th> Plant ID </th>
                <th> Plant Name </th>
                <th> Price </th> 
                <th> Image </th> 
                <th> Description </th> 
                <th> Status </th>
                <th> Cate Name </th> 
            </tr>
            <c:forEach var="plant" items="${requestScope.plantList}">
                <tr><td><c:out value="${plant.getId()}"></c:out></td>
                    <td><c:out value="${plant.getName()}"></c:out></td>
                    <td><c:out value="${plant.getPrice()}"></c:out></td>
                    <td><<img src="${plant.getImgpath()}" /></td>
                    <td><c:out value="${plant.getDescription()}"></c:out></td>
                    <td><c:out value="${plant.getStatus()}"></c:out></td>
                   <td><c:out value="${plant.getCatename()}"></c:out></td>
                </tr>
            </c:forEach>
        </table>



    </body>
</html>
