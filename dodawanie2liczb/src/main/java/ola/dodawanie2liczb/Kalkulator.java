/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ola.dodawanie2liczb;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author olaba
 */
@WebServlet(name = "Kalkulator", urlPatterns = {"/kalkulator"})
public class Kalkulator extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Pobieramy liczby z formularza
        String number1Str = request.getParameter("number1");
        String number2Str = request.getParameter("number2");
        
        try {
            // Przekształcamy je na liczby
            double number1 = Double.parseDouble(number1Str);
            double number2 = Double.parseDouble(number2Str);
            
            // Wykonujemy dodawanie
            double sum = number1 + number2;
            
            // Przekazujemy wynik do strony JSP
            request.setAttribute("result", String.valueOf(sum));
        } catch (NumberFormatException e) {
            // Obsługuje błędy w przypadku niepoprawnych danych
            request.setAttribute("result", "Błąd: Proszę podać prawidłowe liczby.");
        }
        
        // Przekierowanie do formularza (np. index.jsp), by wyświetlić wynik
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
        @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Przekierowanie do formularza, aby obsłużyć GET
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}