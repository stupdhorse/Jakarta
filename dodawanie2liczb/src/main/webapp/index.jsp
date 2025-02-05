<%-- 
    Document   : index
    Created on : 4 lut 2025, 23:24:18
    Author     : olaba
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Kalkulator - Dodawanie</title>
</head>
<body>
    <h2>Prosty kalkulator</h2>
    <form action="kalkulator" method="post">
        <label for="number1">Liczba 1:</label>
        <input type="number" id="number1" name="number1" required>
        <br>
        <label for="number2">Liczba 2:</label>
        <input type="number" id="number2" name="number2" required>
        <br>
        <button type="submit">Dodaj</button>
    </form>
    
    <%-- Jeżeli wynik jest dostępny, wyświetlamy go --%>
    <% 
        String result = (String) request.getAttribute("result");
        if (result != null) { 
    %>
        <h3>Wynik: <%= result %></h3>
    <% 
        }
    %>
</body>
</html>