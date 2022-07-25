<%-- 
    Document   : addPlant
    Created on : Mar 21, 2022, 10:52:29 PM
    Author     : admin
--%>
<%@page import="DAO.CategoryDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Plant</title>
    </head>
    <body>
        <form action="mainController" method="post">
            <p>Plant Name:</p> <input type="text" value="" required="" name="txtName">
            <p>Price:</p><input type="number" value="" required="" name="txtPrice">
            <p>Image Path:</p> <input type="text" value="" required="" name="txtImg">
            <p>Description:</p> <input type="text" value="" required="" name="txtDescription">
            <p>Category</p> <select name="txtCate">
                <c:forEach var="cate" items="${CategoryDAO.getCategory()}">
                    <option value="${cate.getCateID()}">${cate.getCateName()}</option>
                </c:forEach>
            </select>
            <p><input type="submit" name="action" value="addPlant"></p>
            
            
        </form>
    </body>
</html>
