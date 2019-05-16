/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.models.Documents;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hely
 */
@WebServlet(name = "DoctConsolida", urlPatterns = {"/DoctCons"})
public class DoctListCons extends HttpServlet {
int numberOne, numberTwo;
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
               String[] anio = request.getParameterValues("year");
       for(String anios:anio){
           numberOne = Integer.parseInt(anios);
           System.out.println("anio "+numberOne);
       }
      
       String[] mes = request.getParameterValues("month");
       for(String meses:mes){
           numberTwo = Integer.parseInt(meses);
           System.out.println("mes "+numberTwo);
       }
      List<Documents> list = com.dao.DocumentDao.foundAll(numberTwo, numberOne);

        
       request.setAttribute("lis", list);
       request.getRequestDispatcher("consBook.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
