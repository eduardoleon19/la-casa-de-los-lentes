package com.mycompany.proyectofinal.dao;

import com.mycompany.proyectofinal.constructor.constructorPaciente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PacienteDAO {
    
    private final String URL = "jdbc:mysql://localhost:3306/la_casa_de_los_lentes";
    private final String USUARIO = "root";
    private final String CONTRASEÑA = "root";

    // LISTA DE PACIENTES
    public List<constructorPaciente> obtenerPacientes() {
        List<constructorPaciente> lista = new ArrayList<>();
        
        String sql = "SELECT * FROM paciente";

        try (Connection con = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                constructorPaciente paciente = new constructorPaciente(
                    rs.getInt("dniPaciente"),
                    rs.getString("nombrePaciente"),
                    rs.getString("direccion"),
                    rs.getInt("telefono"),
                    rs.getString("fechaVisita"),
                    rs.getString("razonVisita"),
                    rs.getString("enfermedades")
                );
                lista.add(paciente);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return lista;
    }

    // AGREGAR PACIENTE
    public boolean agregarPaciente(constructorPaciente paciente) {
        String sql = "INSERT INTO paciente (dniPaciente, nombrePaciente, direccion, telefono, fechaVisita, razonVisita, enfermedades) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setInt(1, paciente.getDniPaciente());
            pstmt.setString(2, paciente.getNombrePaciente());
            pstmt.setString(3, paciente.getDireccion());
            pstmt.setInt(4, paciente.getTelefono());
            pstmt.setString(5, paciente.getFechaVisita());
            pstmt.setString(6, paciente.getRazonVisita());
            pstmt.setString(7, paciente.getEnfermedades());

            return pstmt.executeUpdate() > 0; // Devuelve true si se insertó correctamente

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
}
