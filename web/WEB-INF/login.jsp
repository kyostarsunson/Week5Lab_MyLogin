<%-- 
    Document   : login.jsp
    Created on : 12-Feb-2023, 6:25:33 PM
    Author     : 886152
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Week5Lab_MyLogin</title>
    </head>
    <body>
        <div style="margin-left: 100px;">
            <h1>Login</h1>
            <form method="post" >
                <table ><tr><td>Username: <input type="textbox" name="username"></td></tr>
                    <tr><td>Password: <input type="password" name="userpassword"></td></tr></table>

                <label>${message}</label><br>
                <input type="submit" value="Login">


            </form>
        </div>
    </body>
</html>
