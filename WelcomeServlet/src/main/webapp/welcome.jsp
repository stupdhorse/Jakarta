<%-- 
    Document   : welcome
    Created on : 4 lut 2025, 21:24:31
    Author     : olaba
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="Welcome" method="post">
            <label for="name">podaj imie miauuuu </label>
            <input type="text" id="name" name="name" required>
            <button type="submit">CHCE ZEBYS MNIE POZDROWIL</button>
        </form>
        <% if(request.getAttribute("name")!=null){ %>
            <h1>CZESC!!!! <%= request.getAttribute("name")%>!</h1> <% } %>
    </body>
</html>
