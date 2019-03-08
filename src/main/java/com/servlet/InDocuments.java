/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.models.Documents;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hely
 */
@WebServlet(name = "Documents", urlPatterns = {"/InDoc"})
public class InDocuments extends HttpServlet {


    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    String date = (request.getParameter("date"));
        System.out.println("fecha"+date);
        
        
        
       String serial = request.getParameter("serial");
       
       
       
    String[] a = request.getParameterValues("exem");
    
        for(String boo : a){
            response.getWriter().print(boo+"<br>");
        }
    
        LocalDate localDate = LocalDate.parse(date);
   // DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("YYYY-MM-dd");
  
   // LocalDate localDate = LocalDate.parse(date, DATE_FORMAT);   
    
    
    
    
       double total = Integer.parseInt(request.getParameter("total"));
       double iva = Integer.parseInt(request.getParameter("iv"));
       int buyer = Integer.parseInt(request.getParameter("buyer"));
       int docType = Integer.parseInt(request.getParameter("docType"));
       int userId = 1;
       com.dao.DocumentDao.add(new Documents(
       Date.valueOf(localDate), serial, total, iva, userId , buyer, docType));
       
       /*boolean isExempt = request.getParameter("buyer);*/
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
