/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.models.Documents;
import java.io.IOException;
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

/**
 *
 * @author hely
 */
@WebServlet(name = "Documents", urlPatterns = {"/InDoc"})
public class InDocuments extends HttpServlet {
          boolean state;
          double iv;
          NumberFormat formatter = new DecimalFormat("#0.00");   
       DecimalFormat formato = new DecimalFormat("#.00");
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
                 LocalDate localDate = LocalDate.parse(date);
                 String serial = request.getParameter("serial");
                 String[] a = request.getParameterValues("exem");
     
                 
               try{   
                    for(String boo : a){ 
                        
                       if(boo == null){
                           state = false;
                           System.out.println("state "+state);
                       }else{
                          state = true;
                           System.out.println("state "+state);
                       }
                    }
               }catch(NullPointerException e){
                          state = false;
                         System.out.println("EXEPCION"+state);
                    }
            /*
               
                    String a=comboBox.getSelectedItem().toString();
                    //Integer b=(comboBox_1.getSelectedIndex()+1);
                    int day=Integer.ParseInt(comboBox_2.getSelectedItem().toString());
                    double bo;
                    DecimalFormat df = new DecimalFormat("#.##");      
                    bo=  Double.parseDouble(df.format(day));
               */   
               
                
              try{
               String[] c = request.getParameterValues("iva");
                    //iv = Double.parseDouble(request.getParameter("iv"));
                    for(String iva: c){

                    String i = (formatter.format(iva));
                 iv = Double.parseDouble(i);
          
                    }
                    //} 
                   
              }catch(NullPointerException e){
                    System.out.println("Iva exepcion "+e.getMessage());
                }

                            
                            System.out.println("BLABLA "+iv);
                            String cd = request.getParameter("total");
                            String fo = (formatter.format(cd));
                            double total = Double.parseDouble(fo);
                            int buyer = Integer.parseInt(request.getParameter("buyer"));
                            int docType = Integer.parseInt(request.getParameter("docType"));
                            int userId = 1;
                            com.dao.DocumentDao.add(new Documents(
                            Date.valueOf(localDate), serial,state, total, iv, userId , buyer, docType));
     
                            request.getRequestDispatcher("records.jsp").forward(request, response);
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
