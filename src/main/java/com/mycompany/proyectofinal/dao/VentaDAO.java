/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal.dao;

import com.mycompany.proyectofinal.constructor.constructorVenta;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VentaDAO {
    private final String URL = "jdbc:mysql://localhost:3306/la_casa_de_los_lentes";
    private final String USUARIO = "root";
    private final String CONTRASEÑA = "root";
    
    //INSERTAR VENTA
    public void insertVenta(constructorVenta venta) {
        String query = "INSERT INTO registroventa (codigoBoleta, fechaCreacion, dniPaciente, esferaIzq, cilindroIzq, gradoIzq, distanciaIzq, esferaDer, cilindroDer, gradoDer, distanciaDer, codigoMontura, tipoLuna, costoTotal, fechaEntrega) "
                     + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, venta.getCodigoBoleta());
            stmt.setString(2, venta.getFechaCreacion());
            stmt.setInt(3, venta.getDniPaciente());
            stmt.setDouble(4, venta.getEsferaIzq());
            stmt.setDouble(5, venta.getCilindroIzq());
            stmt.setDouble(6, venta.getGradoIzq());
            stmt.setDouble(7, venta.getDistanciaIzq());
            stmt.setDouble(8, venta.getEsferaDer());
            stmt.setDouble(9, venta.getCilindroDer());
            stmt.setDouble(10, venta.getGradoDer());
            stmt.setDouble(11, venta.getDistanciaDer());
            stmt.setInt(12, venta.getCodigoMontura());
            stmt.setString(13, venta.getTipoLuna());
            stmt.setDouble(14, venta.getCostoTotal());
            stmt.setString(15, venta.getFechaEntrega());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<constructorVenta> getAllVentas() {
        List<constructorVenta> ventas = new ArrayList<>();
        String query = "SELECT * FROM registroventa";

        try (Connection conn = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                constructorVenta venta = new constructorVenta(
                        rs.getInt("codigoBoleta"),
                        rs.getString("fechaCreacion"),
                        rs.getInt("dniPaciente"),
                        rs.getDouble("esferaIzq"),
                        rs.getDouble("cilindroIzq"),
                        rs.getDouble("gradoIzq"),
                        rs.getDouble("distanciaIzq"),
                        rs.getDouble("esferaDer"),
                        rs.getDouble("cilindroDer"),
                        rs.getDouble("gradoDer"),
                        rs.getDouble("distanciaDer"),
                        rs.getInt("codigoMontura"),
                        rs.getString("tipoLuna"),
                        rs.getDouble("costoTotal"),
                        rs.getString("fechaEntrega")
                );
                ventas.add(venta);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ventas;
    }
    
    // OBTENER VENTA POR CODIGOBOLETA
    public constructorVenta getVentaByCodigo(int codigoBoleta) {
        String sql = "SELECT * FROM registroventa WHERE codigoBoleta = ?";
        try (Connection con = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, codigoBoleta);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new constructorVenta(
                    rs.getInt("codigoBoleta"),
                    rs.getString("fechaCreacion"),
                    rs.getInt("dniPaciente"),
                    rs.getDouble("esferaIzq"),
                    rs.getDouble("cilindroIzq"),
                    rs.getDouble("gradoIzq"),
                    rs.getDouble("distanciaIzq"),
                    rs.getDouble("esferaDer"),
                    rs.getDouble("cilindroDer"),
                    rs.getDouble("gradoDer"),
                    rs.getDouble("distanciaDer"),
                    rs.getInt("codigoMontura"),
                    rs.getString("tipoLuna"),
                    rs.getDouble("costoTotal"),
                    rs.getString("fechaEntrega")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // ACTUALIZAR VENTA
    public boolean updateVenta(constructorVenta venta) {
        String sql = "UPDATE registroventa SET fechaCreacion=?, dniPaciente=?, esferaIzq=?, cilindroIzq=?, gradoIzq=?, distanciaIzq=?, esferaDer=?, cilindroDer=?, gradoDer=?, distanciaDer=?, codigoMontura=?, tipoLuna=?, costoTotal=?, fechaEntrega=? WHERE codigoBoleta=?";
        try (Connection con = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, venta.getFechaCreacion());
            pstmt.setInt(2, venta.getDniPaciente());
            pstmt.setDouble(3, venta.getEsferaIzq());
            pstmt.setDouble(4, venta.getCilindroIzq());
            pstmt.setDouble(5, venta.getGradoIzq());
            pstmt.setDouble(6, venta.getDistanciaIzq());
            pstmt.setDouble(7, venta.getEsferaDer());
            pstmt.setDouble(8, venta.getCilindroDer());
            pstmt.setDouble(9, venta.getGradoDer());
            pstmt.setDouble(10, venta.getDistanciaDer());
            pstmt.setInt(11, venta.getCodigoMontura());
            pstmt.setString(12, venta.getTipoLuna());
            pstmt.setDouble(13, venta.getCostoTotal());
            pstmt.setString(14, venta.getFechaEntrega());
            pstmt.setInt(15, venta.getCodigoBoleta());

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // ELIMINAR VENTA
    public boolean deleteVenta(int codigoBoleta) {
        String sql = "DELETE FROM registroventa WHERE codigoBoleta=?";
        try (Connection con = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, codigoBoleta);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
