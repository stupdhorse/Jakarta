/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ola.miaukacz;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 *
 * @author olaba
 */
@WebServlet(name = "DeleteFormServlet", urlPatterns = {"/DeleteForm"})

public class DeleteFormServlet extends HttpServlet {
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String pesel = request.getParameter("pesel");
        
        try {
            bazaDAO.deleteForm(pesel);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        response.sendRedirect("ListForms");
    }
}
