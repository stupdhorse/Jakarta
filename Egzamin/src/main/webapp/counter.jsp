<%-- 
    Document   : counter
    Created on : 4 lut 2025, 19:13:36
    Author     : olaba
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Counter</title>
    </head>
    <body>
        <h1>POLICZ: <%= request.getAttribute("count")%></h1>
        <form action="counter" method="get">
            <button type="submit">KLIKNIJ MNIE!</button>
        </form>
    </body>
</html>
