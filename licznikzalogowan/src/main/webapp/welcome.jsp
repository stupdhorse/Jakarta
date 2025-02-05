<%-- 
    Document   : welcome
    Created on : 4 lut 2025, 22:55:05
    Author     : olaba
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Witaj</title>
</head>
<body>
    <% String username = (String) session.getAttribute("username"); %>
    <% Integer loginCount = (Integer) session.getAttribute("loginCount"); %>
    
    <% if (username != null) { %>
        <h2>Witaj, <%= username %>!</h2>
        <p>Liczba twoich logowań: <%= loginCount %></p>
    <% } else { %>
        <p>Nie jesteś zalogowany! <a href="index.jsp">Zaloguj się</a></p>
    <% } %>
</body>
</html>
