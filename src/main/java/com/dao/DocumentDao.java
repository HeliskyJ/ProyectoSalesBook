
package com.dao;

import com.conexion.Conexion;
import com.models.Documents;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author hely
 */
public class DocumentDao {
    
    public static boolean add(Documents document){
        Connection con;
        PreparedStatement ps;
        String sql = "insert into documents values(null,?,?,?,?,?,?,?)";
        
        try{
            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);
            ps.setDate(1, java.sql.Date.valueOf(document.getDocumentDate()));
            System.out.println(document.getDocumentDate());
            ps.setString(2, document.getSerialNumber());
            ps.setDouble(3, document.getTotal());
            ps.setDouble(4, document.getIva());
            System.out.println(document.getIva());
            ps.setInt(5, document.getUserId());
            ps.setInt(6, document.getBuyerId());
            ps.setInt(7, document.getDocTypeId());
            con.close();
            ps.close();
            return true;
            
        }catch(SQLException e){
            System.out.println("Error de insert "+e.getMessage());
            return false;
        }
    }
}
