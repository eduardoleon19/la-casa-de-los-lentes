package com.mycompany.proyectofinal.dao;

import com.mycompany.proyectofinal.constructor.constructorMontura;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MonturaDAO {

    private final String URL = "jdbc:mysql://localhost:3306/la_casa_de_los_lentes";
    private final String USUARIO = "root";
    private final String CONTRASEÑA = "root";
    
    // AGREGAR MONTURA
    public void insertMontura(constructorMontura montura) {
        String query = "INSERT INTO montura (codigoMontura, tipoMontura, precio, longitudMontura, anchoPuente, longitudVarilla, longitudLente, linkFoto) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, montura.getCodigoMontura());
            stmt.setString(2, montura.getTipoMontura());
            stmt.setDouble(3, montura.getPrecio());
            stmt.setDouble(4, montura.getLongitudMontura());
            stmt.setDouble(5, montura.getAnchoPuente());
            stmt.setDouble(6, montura.getLongitudVarilla());
            stmt.setDouble(7, montura.getLongitudLente());
            stmt.setString(8, montura.getLinkFoto());

            stmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // LISTA DE MONTURAS
    public List<constructorMontura> getAllMonturas() {
        List<constructorMontura> monturas = new ArrayList<>();
        String query = "SELECT * FROM montura";

        try (Connection conn = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                constructorMontura montura = new constructorMontura(
                        rs.getInt("codigoMontura"),
                        rs.getString("tipoMontura"),
                        rs.getDouble("precio"),
                        rs.getDouble("longitudMontura"),
                        rs.getDouble("anchoPuente"),
                        rs.getDouble("longitudVarilla"),
                        rs.getDouble("longitudLente"),
                        rs.getString("linkFoto") // Obtener el link de la foto
                );
                monturas.add(montura);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return monturas;
    }
}
