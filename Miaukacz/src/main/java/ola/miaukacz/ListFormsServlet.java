/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ola.miaukacz;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;


@WebServlet(name = "ListFormsServlet", urlPatterns = {"/ListForms"})

public class ListFormsServlet extends HttpServlet {
    private BazaDAO bazaDAO;

    
    @Override
    public void init() throws ServletException {
        try {
            bazaDAO = new BazaDAO();
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Form> forms = bazaDAO.getForms();
            request.setAttribute("forms", forms);
            RequestDispatcher dispatcher = request.getRequestDispatcher("listForms.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}