<%-- 
    Document   : addCategory
    Created on : Mar 21, 2022, 10:18:07 PM
    Author     : admin
--%>
<%@page import="DAO.CategoryDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Category</title>
    </head>
    <body>
        <form action="mainController" method="post">
            <p>Category ID: </p><input type="text" name="txtCateID" value="${CategoryDAO.getNextCateID()}" readonly="" >
            <p>Category Name: </p><input type="text" name="txtCateName" value="" required="" >
            <p><input type="submit" name="action" value="addCategory"><p>
        </form>
    </body>
</html>
