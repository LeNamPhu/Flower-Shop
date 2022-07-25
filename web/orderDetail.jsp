<%-- 
    Document   : orderDetail
    Created on : Feb 28, 2022, 4:03:57 PM
    Author     : admin
--%>

<%@page import="DAO.OrderDAO"%>
<%@page import="DTO.OrderDetail"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Detail</title>
        <link rel="stylesheet" href="mycss.css" type="text/css" />
    </head>
    <body>
        <header>
            <%@include file = "header-loginedUser.jsp" %>
        </header>
        <%String orderid = request.getParameter("orderid");
        %>
        <section>
            <h3>Viewing order number <%=orderid%>'s detail</h3>
            <a href="personalPage.jsp">view all orders</a>

        </section>
        <section>
            <table clas = "order">
                <tr><td>Order ID</td><td>plant ID</td><td>Plant Name</td><td>Image</td><td>price</td><td>quantity</td></tr>
                <%
                    if (orderid != null) {
                        int orderID = Integer.parseInt(orderid.trim());

                        ArrayList<OrderDetail> list = OrderDAO.getOrderDetails(orderID);
                        if (list != null && !list.isEmpty()) {
                            int money = 0;
                            for (OrderDetail detail : list) {%>

                <tr><td><%= detail.getOrderID()%></td>
                    <td><%= detail.getPlantName()%></td>
                    <td><%= detail.getPlantName()%></td>
                    <td><img src ='<%= detail.getImgPath()%>' class="plantimg" /> </td>
                    <td><%= detail.getPrice()%></td>
                    <td><%= detail.getQuantity()%></td>
                    <% money = money + detail.getPrice() * detail.getQuantity(); %>
                </tr>    

                <% } // end for%> 
            </table>
            <h3>total = <%=money%></h3>
            <% } // end if
            else {
            %>
            <p>you dont have any order</p>
            <%
                    }
                }
            %>   

        </section>
        <footer>
            <%@include file = "footer.jsp" %>
        </footer>

    </section>
</body>
</html>
