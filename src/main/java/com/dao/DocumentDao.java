
package com.dao;

import com.conexion.Conexion;
import com.models.Documents;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hely
 */
public class DocumentDao {
    
    public static boolean add(Documents document){
        Connection con;
        PreparedStatement ps;
        String sql = "insert into documents values(null,?,?,?,?,?,?,?,?,?,?,?)";
        
        try{
            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);
            ps.setDate(1, java.sql.Date.valueOf(document.getDocumentDate()));
            System.out.println(document.getDocumentDate());
            ps.setString(2, document.getSerie());
            ps.setInt(3, document.getNo_doc());
            ps.setString(4, document.getBuyNit());
            ps.setString(5, document.getBuyer());
            ps.setBigDecimal(6, document.getExempt());
            ps.setBigDecimal(7, document.getNet());
            ps.setBigDecimal(8, document.getIva());
            ps.setBigDecimal(9, document.getTotal());
            ps.setInt(10, document.getUserId());
            ps.setInt(11, document.getDocTypeId());
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
 
    /*public static List<Documents> listDocuments(){
       List<Documents> listD = new ArrayList<>();
       Connection con;
       ResultSet rs;
       PreparedStatement ps;
       String sql = ""
    }*/
    
    
     /*   public static Documents getDoc() {
            Documents listBook = null;
            Connection con;
            PreparedStatement ps;
            ResultSet rs;
        String sql = " select u.business_name, u.nit, ds.serial_number, ds.document_date, dtt.document_name, ds.is_exempt, br.nit, br.full_name, ds.total, ds.iva "
                +" FROM user u, documents ds, buyer br, document_type dtt "
                +" WHERE u.id = ds.user_id "
                +" AND br.id = ds.buyer_id "
                +" AND dtt.id = ds.doc_type_id "
                +" AND document_date BETWEEN CAST('2010-03-03'AS DATE) "
                +" AND CAST('2010-06-03' AS DATE)'";
    
        try{
            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
              listBook = new Documents(
                  rs.getString("u.business_name"),
                  rs.getString("u.nit"),
                       rs.getString("ds.serial_number"),
                       rs.getDate("ds.documents_date"),
                       rs.getString("dtt.document_name"),
                       rs.getBoolean("ds.is_exempt"),
                       rs.getString("br.nit"),
                       rs.getString("br.full_name"),
                       rs.getDouble("ds.total"),
                       rs.getDouble("ds.iva")
               );
            }

            ps.close();
            con.close();
        }catch(SQLException e){
            System.out.println("Error al hacer el select " + e.getMessage());
            return null;
        }
       return listBook;
    }*/
    
    public static List<Documents> findAll(int uno, int dos){
        List<Documents> doctis= new ArrayList<>();
        Connection con;
        ResultSet rs;
        PreparedStatement ps;
        String sql = "SELECT ds.id, ds.serie, ds.no_document, ds.document_date, dtt.document_name, " +
"	 ds.nit, ds.buyer, ds.exempt, ds.iva, ds.total, ds.net_worth " +
"        FROM documents ds, document_type dtt " +
"        WHERE dtt.id = ds.doc_type_id " +
"        AND MONTH(document_date) = ? " +
"        AND YEAR(document_date) =?;";
       
        try{
          con = Conexion.getConexion();
          ps= con.prepareStatement(sql);
          ps.setInt(1, uno);
          ps.setInt(2, dos);
          rs=ps.executeQuery();
          
          while (rs.next()) { 
            doctis.add(new Documents(
                    rs.getInt("id"),
                    rs.getDate("document_date"),
                    rs.getString("serie"), 
                    rs.getInt("no_document"),
                    rs.getBigDecimal("exempt"),
                    rs.getBigDecimal("total"),
                    rs.getBigDecimal("iva"),
                    rs.getBigDecimal("net_worth"),     
                    rs.getString("nit"),
                    rs.getString("buyer"),
                    rs.getString("document_name")
                          
          ));
        }
        }catch(SQLException e){
            System.out.println("ERROR finAll "+ e);
            return null;
            
        }
        return doctis;
        
    }
    
    public static Documents getDocument(int id){
        Documents doc;
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        String sql = "Select ds.id, ds.document_date, ds.serie,"
                + " ds.no_document, ds.nit, ds.buyer, ds.exempt, "
                + " ds.iva, ds.net_worth, ds.total, dtt.document_name"
                + " from documents ds, document_type dtt "
                + " where ds.id=? "
                + " and dtt.id=ds.doc_type_id";
        
        try{
            con=Conexion.getConexion();
            ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            rs=ps.executeQuery();
            rs.first();
            doc = new Documents(
                    rs.getInt("id"),
                    rs.getDate("document_date"),
                    rs.getString("serie"), 
                    rs.getInt("no_document"),
                    rs.getBigDecimal("exempt"),
                    rs.getBigDecimal("total"),
                    rs.getBigDecimal("iva"),
                    rs.getBigDecimal("net_worth"),
                    rs.getString("nit"),
                    rs.getString("buyer"),                  
                    rs.getString("document_name")     
                                   
            );
            ps.close();
            rs.close();
            con.close();
        }catch(SQLException e){
            System.out.println("Error getDoc " + e);
            doc=null;
        }
        return doc;
    }
    
    public static boolean changeStatus(Documents doc){
        Connection con;
        PreparedStatement ps;
        String sql= "update documents set total=?, iva=?, net_worth=?, nit=?, buyer=? where id=?";
        int rowAffected;
        try{
            con=Conexion.getConexion();
            ps=con.prepareStatement(sql);
            ps.setInt(6, doc.getId());
            ps.setString(5, doc.getBuyer());
            ps.setString(4, doc.getBuyNit());
            ps.setBigDecimal(3, doc.getNet());
            ps.setBigDecimal(2, doc.getIva());
            ps.setBigDecimal(1, doc.getTotal());
            rowAffected = ps.executeUpdate();
            con.close();
            ps.close();
            return rowAffected ==1;
        }catch(SQLException e){
            System.out.println("Error changeStatus "+e);
            return false;
        }
    }
}
