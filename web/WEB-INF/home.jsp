<%-- 
    Document   : home.jsp
    Created on : 12-Feb-2023, 6:26:44 PM
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
            <h1>Home Page</h1>
            <h2>Hello ${showUsername}</h2>


            <a href="login?invalidate=yes">Log out</a>

            <label>${message}</label>
        </div>
    </body>
</html>
