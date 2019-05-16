/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.models.Documents;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Hely Mendez
 */
@WebServlet(name = "Actualizar", urlPatterns = {"/Change"})
public class ChangeDoc extends HttpServlet {
 boolean state;

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
        int id = Integer.parseInt(request.getParameter("id"));
        String[] status = request.getParameterValues("status");
            
               try{   
                    for(String boo : status){ 
                        
                       if(boo == null){
                           state = false;
                           
                       }else{
                          state = true;
                          String buyer = "ANULADO";
                          String nit = "----";
                          double wot = 0;
                          BigDecimal net =BigDecimal.valueOf(wot);
                          BigDecimal total =BigDecimal.valueOf(wot);
                          BigDecimal iva =BigDecimal.valueOf(wot);
                           System.out.println("state "+state);
                         
                         Documents doc;
                         doc = new Documents(id,total, iva, net, nit, buyer);
                         com.dao.DocumentDao.changeStatus(doc);
                       }
                    }
               }catch(NullPointerException e){
                          state = false;
                         System.out.println("EXEPCION"+state);
                    }
               response.sendRedirect("Doctos?id="+id);
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
