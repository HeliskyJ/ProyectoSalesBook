package com.dao;

import com.conexion.Conexion;
import com.models.Documents;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Encargada de ejecutar las opeciones CRUD de las clases.
 *
 * @author Hely Méndez.
 */
public class DocumentDao {

    /**
     * Método que ejecuta la operación insertar.
     *
     * @param document
     * @return true si la operación es correcta.
     */
    public static boolean add(Documents document) {
        Connection con;
        PreparedStatement ps;
        String sql = "insert into documents values(null,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);
            ps.setDate(1, java.sql.Date.valueOf(document.getDocumentDate()));
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

        } catch (SQLException e) {
            System.out.println("Error de insert " + e.getMessage());
            return false;
        }
    }

    /**
     * Método encargado de operar una consulta.
     *
     * @param uno int que identifica el mes.
     * @param dos int representa el año.
     * @return lista de documentos.
     */
    public static List<Documents> findAll(int uno, int dos) {
        List<Documents> doctis = new ArrayList<>();
        Connection con;
        ResultSet rs;
        PreparedStatement ps;
        String sql = "SELECT ds.id, ds.serie, ds.no_document, ds.document_date, dtt.document_name, "
                + "	 ds.nit, ds.buyer, ds.exempt, ds.iva, ds.total, ds.net_worth "
                + "        FROM documents ds, document_type dtt "
                + "        WHERE dtt.id = ds.doc_type_id "
                + "        AND MONTH(document_date) = ? "
                + "        AND YEAR(document_date) =?;";

        try {
            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, uno);
            ps.setInt(2, dos);
            rs = ps.executeQuery();

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
        } catch (SQLException e) {
            System.out.println("ERROR finAll " + e);
            return null;

        }
        return doctis;

    }

    /**
     * Método para extraer un documento.
     *
     * @param id int identificador del documento.
     * @return un documento.
     */
    public static Documents getDocument(int id) {
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

        try {
            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
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
        } catch (SQLException e) {
            System.out.println("Error getDoc " + e);
            doc = null;
        }
        return doc;
    }

    /**
     * Método para actualizar el estado de un documento.
     *
     * @param doc Documento
     * @return true si la operación es correcta.
     */
    public static boolean changeStatus(Documents doc) {
        Connection con;
        PreparedStatement ps;
        String sql = "update documents set total=?, iva=?, net_worth=?, nit=?, buyer=? where id=?";
        int rowAffected;
        try {
            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(6, doc.getId());
            ps.setString(5, doc.getBuyer());
            ps.setString(4, doc.getBuyNit());
            ps.setBigDecimal(3, doc.getNet());
            ps.setBigDecimal(2, doc.getIva());
            ps.setBigDecimal(1, doc.getTotal());
            rowAffected = ps.executeUpdate();
            con.close();
            ps.close();
            return rowAffected == 1;
        } catch (SQLException e) {
            System.out.println("Error changeStatus " + e);
            return false;
        }
    }

    /**
     * Método para obtener una consulta.
     *
     * @param uno int representa el mes.
     * @param dos int representa el año.
     * @return Listado de documentos.
     */
    public static List<Documents> foundAll(int uno, int dos) {
        List<Documents> doctis = new ArrayList<>();
        Connection con;
        ResultSet rs;
        PreparedStatement ps;
        String sql = "SELECT MIN(no_document) AS del, MAX(no_document) AS al, document_date, document_name, SUM(exempt) AS Exenta, SUM(iva) AS IVA,  SUM(net_worth) AS valor_neto, SUM(total) AS Total "
                + "FROM documents AS dts, document_type AS dtt "
                + "WHERE MONTH(document_date) = ? "
                + "AND YEAR(document_date) =? "
                + "AND dts.doc_type_id = dtt.id "
                + "GROUP BY document_date, document_name;";

        try {
            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, uno);
            ps.setInt(2, dos);
            rs = ps.executeQuery();

            while (rs.next()) {
                doctis.add(new Documents(
                        rs.getDate("document_date"),
                        rs.getBigDecimal("Exenta"),
                        rs.getBigDecimal("Total"),
                        rs.getBigDecimal("IVA"),
                        rs.getBigDecimal("valor_neto"),
                        rs.getString("document_name"),
                        rs.getInt("del"),
                        rs.getInt("al")
                ));
            }
        } catch (SQLException e) {
            System.out.println("ERROR finAll " + e);
            return null;

        }
        return doctis;

    }
}
