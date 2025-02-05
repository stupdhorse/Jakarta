/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ola.licznikzalogowan;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author olaba
 */
@WebServlet(name = "licznikzalogowan", urlPatterns = {"/licznikzalogowan"})
public class licznikzalogowan extends HttpServlet {

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "1234";
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            
            HttpSession session = request.getSession();
            Integer loginCount = (Integer) session.getAttribute("loginCount");
            
            if(USERNAME.equals(username)&&PASSWORD.equals(password)){
                if(loginCount==null){
                    loginCount=1;
                }
                else{
                    loginCount++;
                }
                session.setAttribute("loginCount",loginCount);
                session.setAttribute("username",username);
                response.sendRedirect("welcome.jsp");
            }
            else{
                    request.setAttribute("errorMessage", "Błędny login lub hasło!");
                    request.getRequestDispatcher("index.jsp").forward(request,response);
                }
            
    }
    @Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    // Jeśli ktoś przejdzie na stronę bez danych formularza, przekieruj na stronę logowania
    response.sendRedirect("index.jsp");
}
}
