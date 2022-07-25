<%-- 
    Document   : viewPlant
    Created on : Mar 4, 2022, 5:11:53 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Plant</title>
    </head>
    <body>

        <jsp:useBean id="plantObj" class="DTO.Plant" scope="request" />
        <table>

            <tr><td rowspan ="8"><img src="${plantObj.imgpath}"></td></tr>
            <tr><td>id:${plantObj.id}</td></tr>
            <tr><td>product name:${plantObj.name}</td></tr>
            <tr><td>price:${plantObj.price}</td></tr>
            <tr><td>description:${plantObj.description}</td></tr>
            <tr><td>status:${plantObj.status}</td></tr>
            <tr><td>cate id:${plantObj.cateid}</td></tr>
            <tr><td>cate name:${plantObj.catename}</td></tr>

        </table>

    </body>
</html>
