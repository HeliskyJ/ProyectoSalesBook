/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.conexion.Conexion;
import com.models.DocumentType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hely
 */
public class DocumentTypeDao {
    
    public static boolean add(DocumentType type){
       Connection con;
       PreparedStatement ps;
       String sql = "insert into document_type values(null,?)";
       try{
           con = Conexion.getConexion();
           ps = con.prepareStatement(sql);
           ps.setString(1, type.getDocumentName());
           ps.executeUpdate();
           con.close();
           ps.close();
           return true;
           
           
       }catch(SQLException e){
           System.out.println("Error de insert "+e);
           return false;
       }
    }
    public static List<DocumentType> tipoDoc(){
        List<DocumentType> list = new ArrayList<>();
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        String sql = "Select *from tipo_telefono";
        
        try{
            con=Conexion.getConexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){
                list.add(new DocumentType(
                        rs.getInt("id"),
                        rs.getString("document_name")
                ));
            }
            ps.close();
            con.close();
        }catch(SQLException e){
            System.out.println("Error select DocType "+ e.getMessage());
            list.clear();
        }
        return list;
    }
}
