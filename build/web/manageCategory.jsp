<%-- 
    Document   : manageCategory
    Created on : Mar 15, 2022, 2:50:41 PM
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
            <c:import url="header-loginedAdmin.jsp"/>
        </header>
        <a href="addCategory.jsp">Add Category</a>
        <table class="order">
            <tr><th> Category ID </th>
                <th> Category Name </th>
            </tr>
            <c:forEach var="cate" items="${requestScope.cateList}">
                <tr>
                    <td><c:out value="${cate.getCateID()}"></c:out></td>
                    <td><c:out value="${cate.getCateName()}"></c:out></td>
                    </tr>
            </c:forEach>
        </table>
    </body>
</html>
