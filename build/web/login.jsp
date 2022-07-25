<%-- 
    Document   : login
    Created on : Feb 26, 2022, 12:18:31 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="mycss.css" type="text/css" />
    </head>
    <body>
        <header>
            <%@include file = "header.jsp" %>

        </header>
        <section>
            <form style="margin-left:40%; font-size: 30px;" action="mainController" method = "post" class="form">
                <font style="color:red"><%=(request.getAttribute("WARNING") == null) ? "" : request.getAttribute("WARNING")%></font>
                <h1>Log in to your account</h1>
                <table>
                    
                    <tr>
                        <td>Email</td>
                        <td> <input  style="height:50px; width:300px;" type ="text" name ="txtemail"> </td>
                    </tr>

                    <tr>
                        <td>Password</td>
                        <td> <input  style="height:50px; width:300px;" type ="password" name ="txtpassword"> </td>
                    </tr>
<!--                    <tr>
                        <td colspan = "2"> <input type = "checkbox" value = "savelogin" name="savelogin">Stay signed in</td>
                    </tr>-->
                    <tr>
                        <td></td>
                        <td colspan = "2"> <input style="height:50px; width:200px; font-size:30px;"  id="login"type = "submit" value = "Login" name="action"> </td>
                    </tr>


                </table>
            </form>

        </section>
        <footer>
            <%@include file = "footer.jsp" %>
        </footer>
    </body>
</html>
