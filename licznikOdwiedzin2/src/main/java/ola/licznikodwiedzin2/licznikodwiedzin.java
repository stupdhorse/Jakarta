/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ola.licznikodwiedzin2;

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
@WebServlet(name = "licznikodwiedzin", urlPatterns = {"/licznikodwiedzin"})
public class licznikodwiedzin extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            HttpSession session = request.getSession();
            Integer visitCount = (Integer) session.getAttribute("visitCount");
            
            if(visitCount==null){
                visitCount=1;
            }
            else{
                visitCount++;
            }
            session.setAttribute("visitCount",visitCount);
            request.setAttribute("visitCount",visitCount);
            request.getRequestDispatcher("visitcounter.jsp").forward(request,response);
    }
}
