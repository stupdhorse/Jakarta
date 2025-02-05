<%-- 
    Document   : listForms
    Created on : 6 lis 2024, 01:40:23
    Author     : olaba
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Lista Formularzy</title>
    <style>
        body {
            background-color: #ffe9f4; /* Jasnorozowy kolor tła */
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #ffc0cb;
        }
        .image-margin {
            margin-top: 350px; /* Przesunięcie obrazu w dół o 20px */
        }
    </style>
</head>
<body>
    <h2>Lista Formularzy</h2>
    <table>
    <table style="background-color: #e6e6fa;">
        <thead>
            <tr>
                <th>PESEL</th>
                <th>ulubiony film</th>
                <th>ulubiona robotka reczna</th>
                <th>Data dodania</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="form" items="${forms}">
                <tr>
                    <td>${form.pesel}</td>
                    <td>${form.answer1}</td>
                    <td>${form.answer2}</td>
                    <td>${form.createdTime}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <h3>Usuń formularz</h3>
    <form action="DeleteForm" method="post">
        PESEL: <input type="text" name="pesel" required>
        <button type="submit">Usuń</button>
    </form>
<img src="images/powrot.jpg" alt="Przejdź do strony" onclick="window.location.href='addForm.jsp';" class="image-margin" style="width: 250px; height: 400px; cursor: pointer;">
</body>
</html>