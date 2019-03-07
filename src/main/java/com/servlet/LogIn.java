
package com.servlet;

import com.dao.UserDao;
import com.models.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *Servlet que contiene la peticion de inicio de sesion.
 * @author Hely Mendez
 * @version 1.0
 * @since salesBook 1.0
 */
@WebServlet(name = "InicioSesion", urlPatterns = {"/log"})
public class LogIn extends HttpServlet {


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
        HttpSession sesion = request.getSession();
            
        String usuario = request.getParameter("user");
        String password = request.getParameter("password");
        
        User user = (User) UserDao.getUser(usuario);
        
        if(user == null){
            sesion.setAttribute("isReal", false);
            request.getRequestDispatcher("invalid.jsp").forward(request, response);
        }
        else if(password.equals(user.getPassword())){
            sesion.setAttribute("Nombrecompleto", user.getFirstName());
            sesion.setAttribute("Apellidoscompleto", user.getLastName());
            sesion.setAttribute("isReal", true);
            request.getRequestDispatcher("home.jsp").forward(request, response);
        }else{
            sesion.setAttribute("isReal", false);
            request.getRequestDispatcher("invalid.jsp").forward(request, response);
        }
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
