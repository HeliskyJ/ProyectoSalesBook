package com.dao;

import com.conexion.Conexion;
import com.models.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Class que contiene las operaciones CRUD de user.
 *
 * @author Hely Mendez
 * @version 1.0
 * @since salesBook 1.0
 */
public class UserDao {

    /**
     * Método para Crear un nuevo usuario.
     *
     * @param user
     * @return true si la operación es existosa.
     */
    public static boolean add(User user) {
        Connection con;
        PreparedStatement ps;
        String sql = "insert into user values(null,?,?,?,?,?)";

        try {
            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getFullName());
            ps.setString(2, user.getUserName());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getBusinessName());
            ps.setString(5, user.getNit());
            ps.executeUpdate();
            con.close();
            ps.close();
            return true;

        } catch (SQLException e) {
            System.out.println("Error al insertar " + e);
            return false;
        }
    }

    /**
     * Método para obtener un usuario.
     *
     * @param username String contiene el nombre del usuario a ser extraido.
     * @return un usuario.
     */
    public static User getUser(String username) {
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        String sql = "Select *from user where username='" + username + "'";

        try {
            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            rs.first();
            User usuario;
            usuario = new User(
                    rs.getInt("id"),
                    rs.getString("full_name"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("business_name"),
                    rs.getString("nit")
            );
            ps.close();
            con.close();
            return usuario;

        } catch (SQLException e) {
            System.out.println("Error getUser " + e);
            return null;

        }
    }
}
