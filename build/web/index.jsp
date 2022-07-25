<%-- 
    Document   : index
    Created on : Feb 26, 2022, 12:15:57 AM
    Author     : admin
--%>

<%@page import="DAO.PlantDAO"%>
<%@page import="DTO.Plant"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index</title>
        <link rel="stylesheet" href="mycss.css" type="text/css" />
    </head>

    <body>
        <header>
            <%@include file = "header.jsp" %>
        </header>
        <div class="body">
            <section style="display: flex;
                     flex-direction: row;
                     flex-wrap: wrap;
                     justify-content: space-between;">
                <% String keyword = request.getParameter("txtsearch");
                    String searchby = request.getParameter("searchby");
                    ArrayList<Plant> list;
                    String[] tmp = {"out of stock", "available"};
                    if (keyword == null && searchby == null) {
                        list = DAO.PlantDAO.getPlants("", "");
                    } else {
                        list = DAO.PlantDAO.getPlants(keyword, searchby);
                    }
                    if (list != null && !list.isEmpty()) {

                        for (Plant p : list) {%>
                <table class ="product">
                    <tr>
                        <td><img src ="<%= p.getImgpath()%>" class="plantimg" /></td></tr>
                    <tr>   <td>Product ID: <%= p.getId()%></td></tr>
                    <tr>   <td>Product Name: <%= p.getName()%></td></tr>
                    <tr>    <td>Price: $<%= p.getPrice()%></td></tr>
                    <tr>   <td>Status: <%= p.getStatus()%></td></tr>
                    <tr>  <td>Category <%= p.getCatename()%></td> </tr>
                    <tr>  <td> <a href ="mainController?action=addtocart&pid=<%= p.getId()%>">Add to cart</a></td>

                    </tr>
                </table>
                <%
                        }
                    }
                %>


            </section>
        </div>

    </body>
</html>
