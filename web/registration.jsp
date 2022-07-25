<%-- 
    Document   : register
    Created on : Feb 26, 2022, 12:20:43 AM
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
            <section style="margin-left:40%; font-size: 30px;">
            <form action="mainController" method="post" class="formregister">
                <h1>Create a new account!</h1>
                <table>
                    <tr><td>Email</td><td><input style="height:50px; width:300px;" type="text" name="txtemail" required="" pattern="^(\\w)+@(a-zA-Z]+([.](\\w)+){1,2}" value="<%=(request.getAttribute("txtemail")==null)?"":request.getAttribute("txtemail")%>"></td></tr>
                    <tr><td>Full name</td><td><input style="height:50px; width:300px;" type="text" name="txtfullname" required=""  value="<%=(request.getAttribute("txtfullname")==null)?"":request.getAttribute("txtfullname")%>"></td></tr>
                    <tr><td>Password</td><td><input style="height:50px; width:300px;" type="password" name="txtpassword" required=""  value="<%=(request.getAttribute("txtpassword")==null)?"":request.getAttribute("txtpassword")%>"></td></tr>
                    <tr><td>Phone</td><td><input style="height:50px; width:300px;" type="text" name="txtphone" required="" value="<%=(request.getAttribute("txtphone")==null)?"":request.getAttribute("txtphone")%>">
                            <%=(request.getAttribute("ERROR")==null)?"":request.getAttribute("ERROR")%> </td>
                    </tr><td></td>
                    <td colspan = "2"> <input style="height:50px; width:200px; font-size:30px;" type = "submit" id="register"value = "Register" name="action"> </td>
                    </tr>
                </table>
            </form>

        </section>
        <footer>
            <%@include file = "footer.jsp" %>
        </footer>
    </body>
</html>
