
package com.mycompany.proyectofinal.dao;

import com.mycompany.proyectofinal.constructor.constructorUsuario;
import java.sql.*;

public class UsuarioDAO {

    private final String URL = "jdbc:mysql://localhost:3306/la_casa_de_los_lentes";
    private final String USUARIO = "root";
    private final String CONTRASEÑA = "root";

    // AGREGAR USUARIO
    public boolean agregarUsuario(constructorUsuario usuario) {
        String sql = "INSERT INTO usuario (nombreUsuario, apellidoUsuario, correo, contrasena) VALUES (?, ?, ?, ?)";

        try (Connection con = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setString(1, usuario.getNombre());
            pstmt.setString(2, usuario.getApellido());
            pstmt.setString(3, usuario.getCorreo());
            pstmt.setString(4, usuario.getContrasena());

            return pstmt.executeUpdate() > 0; // Devuelve true si la inserción fue exitosa

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // VALIDAR USUARIO (LOGIN)
    public constructorUsuario validarUsuario(String correo, String contrasena) {
        String sql = "SELECT * FROM usuario WHERE correo = ? AND contrasena = ?";

        try (Connection con = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setString(1, correo);
            pstmt.setString(2, contrasena);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new constructorUsuario(
                    rs.getString("nombreUsuario"),
                    rs.getString("apellidoUsuario"),
                    rs.getString("correo"),
                    rs.getString("contrasena")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Usuario no encontrado
    }
}
