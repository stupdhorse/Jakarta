/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ola.miaukacz;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
@WebServlet(name = "AddFormServlet", urlPatterns = {"/AddForm"})

public class AddFormServlet extends HttpServlet {
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
        String answer1 = request.getParameter("answer1");
        String answer2 = request.getParameter("answer2");
        
        Form form = new Form(pesel, answer1, answer2);
        try {
            bazaDAO.addForm(form);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        response.sendRedirect("addForm.jsp");
    }
}