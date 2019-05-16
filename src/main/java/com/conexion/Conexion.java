package com.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Crea y obtiene la conexión con la base de datos.
 *
 * @author Hely Mendez
 * @version 1.0
 * @since 1.0
 */
public class Conexion {

    private static Connection con;
    private static String stringConexion;
    private static boolean conected = false;

    /**
     * Metodo para establecer conexión con la base de datos.
     *
     * @return conexión.
     */
    public static Connection getConexion() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            stringConexion = "jdbc:mysql://localhost:3306/liven?SSL=false";
            con = DriverManager.getConnection(stringConexion, "root", "hely12345");
            conected = true;
            return con;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error DB " + ex.getMessage());
            return null;
        }
    }

    /**
     * Metodo para cerrar la conexion.
     *
     * @throws SQLException para manejar la excepcion.
     */
    public static void close() throws SQLException {
        if (conected == true) {
            con.close();
        }
    }
}
