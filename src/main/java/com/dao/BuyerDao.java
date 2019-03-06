/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.conexion.Conexion;
import com.models.Buyer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *Clase
 * @author Hely Mendez
 * @version 1.0
 * @since salesBook 1.0
 */
public class BuyerDao {
    
    public static boolean add(Buyer buyer){
        Connection con;
        PreparedStatement ps;
        String sql = "insert into buyer values(null,?,?)";
        
        try{
            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, buyer.getFullName());
            ps.setString(2, buyer.getNit());
            ps.executeUpdate();
            con.close();
            ps.close();
            return true;
            
        }catch(SQLException e){
            System.out.println("Error de insert "+e);
            return false;
        }
    }
}
