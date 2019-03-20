/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.models.Documents;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hely
 */
@WebServlet(name = "Documents", urlPatterns = {"/InDoc"})
public class InDocuments extends HttpServlet {
          boolean state;
          double iv;
          BigDecimal impuesto;
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
        HttpSession session = request.getSession();
        
                 String date = (request.getParameter("date"));
                 LocalDate localDate = LocalDate.parse(date);
                 String serial = request.getParameter("serial");
                 int numero = Integer.parseInt(request.getParameter("numero"));
                 String nit = request.getParameter("nit");
                 String buyer = request.getParameter("buyer");

              try{
               String[] c = request.getParameterValues("iva");
                    //iv = Double.parseDouble(request.getParameter("iv"));
                    for(String iva: c){

                 iv = Double.parseDouble(iva);
                 impuesto = BigDecimal.valueOf(iv);
          
                    }
                    //} 
                   
              }catch(NullPointerException e){
                    System.out.println("Iva exepcion "+e.getMessage());
                }

                            System.out.println("BLABLA "+iv);
                            Double da = Double.parseDouble(request.getParameter("total"));
                            BigDecimal total = BigDecimal.valueOf(da);
                            Double net = Double.parseDouble(request.getParameter("neto"));
                            BigDecimal worth  = BigDecimal.valueOf(net);
                            int docType = Integer.parseInt(request.getParameter("item"));
                            System.out.println("DOCUMENTO TIP "+ request.getParameter("item"));
                            String user = (String.valueOf(session.getAttribute("id")));
                            int pk = Integer.parseInt(user);
                            
                           com.dao.DocumentDao.add(new Documents(
                            Date.valueOf(localDate), serial.toUpperCase(), numero, state,
                                   total, impuesto, worth, pk , nit, buyer.toUpperCase(), docType));
     
                            request.getRequestDispatcher("records.jsp").forward(request, response);
    }
    /**n
     * 
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
