
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
        String sql = "insert into documents values(null,?,?,?,?,?,?,?,?)";
        
        try{
            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);
            ps.setDate(1, java.sql.Date.valueOf(document.getDocumentDate()));
            System.out.println(document.getDocumentDate());
            ps.setString(2, document.getSerialNumber());
            ps.setBoolean(3, document.isIsExempt());
            System.out.println("bool "+document.isIsExempt());
            ps.setDouble(4, document.getTotal());
            ps.setDouble(5, document.getIva());
            System.out.println(document.getIva());
            ps.setInt(6, document.getUserId());
            ps.setInt(7, document.getBuyerId());
            ps.setInt(8, document.getDocTypeId());
            ps.executeUpdate();
            System.out.println("Query ok");
            con.close();
            ps.close();
            return true;
            
        }catch(SQLException e){
            System.out.println("Error de insert "+e.getMessage());
            return false;
        }
    }
}
