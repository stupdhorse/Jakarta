<%-- 
    Document   : addForm
    Created on : 6 lis 2024, 01:00:42
    Author     : olaba
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>Formularz</title>
    <style>
        body {
            background-image: url('images/tlo.png'); /* Ścieżka do pliku PNG */
            background-size: cover; /* Dopasowanie obrazka do pełnej szerokości i wysokości ekranu */
            background-position: center; /* Ustawienie obrazka na środku strony */
            background-repeat: no-repeat; /* Zapobieganie powtarzaniu obrazka */
        }
        .form-group {
            display: flex;
            flex-direction: column;
            max-width: 300px; /* ustawia szerokość formularza */
            margin: 0 auto;   /* wyśrodkowuje formularz na stronie */
        }
        .form-group label {
            margin-top: 10px;
        }
        .form-group input[type="text"] {
            width: 100%;     /* ustawia szerokość pola na pełną szerokość kontenera */
            padding: 8px;    /* wewnętrzne odstępy dla lepszej czytelności */
            margin-top: 4px;
            box-sizing: border-box;
        }
        .form-group button {
            margin-top: 15px;
            padding: 10px;
            width: 100%;
        }
        .image-margin {
            margin-top: 310px; /* Przesunięcie obrazu w dół o 20px */
        }
    </style>
</head>
<body>

<form action="AddForm" method="post" class="form-group">
    <label for="pesel">PESEL:</label>
    <input type="text" name="pesel" id="pesel" required>

    <label for="answer1">Ulubiony film:</label>
    <input type="text" name="answer1" id="answer1" required>

    <label for="answer2">Ulubiona robótka ręczna:</label>
    <input type="text" name="answer2" id="answer2" required>

    <button type="submit">Dodaj</button>
</form>
<img src="images/misiek.jpg" alt="Przejdź do strony" onclick="window.location.href='ListForms';" class="image-margin" style="width: 250px; height: 400px; cursor: pointer;">

</body>
</html>
</html>
