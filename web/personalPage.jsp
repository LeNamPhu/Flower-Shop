<%-- 
    Document   : PersonalPage
    Created on : Feb 26, 2022, 12:39:04 AM
    Author     : admin
--%>

<%@page import="DTO.Account"%>
<%@page import="DAO.AccountDAO"%>
<%@page import="DTO.Order"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.OrderDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Personal Page</title>
        <link rel="stylesheet" href="mycss.css" type="text/css" />
    </head>
    <body>
        <%
            String name = (String) session.getAttribute("name");
            String email = (String) session.getAttribute("email");
            Cookie[] c = request.getCookies();
            boolean login = false;
            if (name == null) {
                String token = "";
                for (Cookie aCookie : c) {
                    if (aCookie.getName().equals("selector")) {
                        token = aCookie.getValue();
                        Account acc = AccountDAO.getAccount(token);
                        if (acc != null) {
                            name = acc.getFullname();
                            email = acc.getEmail();
                            login = true;
                        }
                    }
                }
            } else {
                login = true;
            }
            if (login) {


        %>

        <header>
            <%@include file = "header-loginedUser.jsp" %>
        </header>
        <section>
            <h3>Welcome <%= name%> </h3>
            <a href="mainController?action=logout">logout </a>
        </section>
        <section>

            <%
                ArrayList<Order> list = OrderDAO.getOrders(email);
                String[] status = {"", "processing", "completed", "canceled"};
                if (list != null && !list.isEmpty()) {
                    for (Order order : list) {
            %>

            <table class = "order">
                <tr><td>Order ID </td><td>Order Date</td><td>Ship Date</td><td>Order Status</td><td>action</td></tr>
                <tr> <td> <%=order.getOrderID()%></td>
                    <td> <%= order.getOrderDate()%></td>
                    <td> <%= order.getShipDate()%></td>
                    <td> <%= status[order.getStatus()]%>
                        <br/><% if (order.getStatus() == 1) {%> <a href="mainController?action=updateOrderStatus&act=cancelOrder&ordID=<%=order.getOrderID()%>&url=personalPage.jsp"> cancel order</a>
                        <%} else if (order.getStatus() == 3) {%><a href="mainController?action=updateOrderStatus&act=replaceOrder&ordID=<%=order.getOrderID()%>&url=personalPage.jsp">  Reorder</a>
                        <%}%>
                    </td>
                    <td><a href="orderDetail.jsp?orderid=<%=order.getOrderID()%>">detail</a></td>
                </tr>
            </table>
            <%      }
            } else {
            %>

            <p>you dont have any order</p>
            <%}%>
        </section>
        <footer>
            <%@include file = "footer.jsp" %>
        </footer>
        <%
        } else {

        %>
        <h3>you must log in to view personal page</h3>
        <%}%>
    </body>
</html>
