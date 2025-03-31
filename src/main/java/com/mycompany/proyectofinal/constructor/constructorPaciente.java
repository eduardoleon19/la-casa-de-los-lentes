/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal.constructor;

import java.util.Date;
import jakarta.json.bind.annotation.JsonbPropertyOrder;

@JsonbPropertyOrder({ 
    "dniPaciente", 
    "nombrePaciente", 
    "direccion", 
    "telefono", 
    "fechaVisita", 
    "razonVisita", 
    "enfermedades"
})

public class constructorPaciente {
    private int dniPaciente;
    private String nombrePaciente;
    private String direccion;
    private int telefono;
    private String fechaVisita;
    private String razonVisita;
    private String enfermedades;

    // Constructor completo
    public constructorPaciente(int dniPaciente, String nombrePaciente, String direccion, int telefono, String fechaVisita, String razonVisita, String enfermedades) {
        this.dniPaciente = dniPaciente;
        this.nombrePaciente = nombrePaciente;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fechaVisita = fechaVisita;
        this.razonVisita = razonVisita;
        this.enfermedades = enfermedades;
    }

    // Getters y Setters
    public int getDniPaciente() {
        return dniPaciente;
    }

    public void setDniPaciente(int dniPaciente) {
        this.dniPaciente = dniPaciente;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getFechaVisita() {
        return fechaVisita;
    }

    public void setFechaVisita(String fechaVisita) {
        this.fechaVisita = fechaVisita;
    }

    public String getRazonVisita() {
        return razonVisita;
    }

    public void setRazonVisita(String razonVisita) {
        this.razonVisita = razonVisita;
    }

    public String getEnfermedades() {
        return enfermedades;
    }

    public void setEnfermedades(String enfermedades) {
        this.enfermedades = enfermedades;
    }

    // Método para mostrar los datos del paciente
    @Override
    public String toString() {
        return "Paciente{" +
                "dniPaciente=" + dniPaciente +
                ", nombrePaciente='" + nombrePaciente + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono=" + telefono +
                ", fechaVisita=" + fechaVisita +
                ", razonVisita='" + razonVisita + '\'' +
                ", enfermedades='" + enfermedades + '\'' +
                '}';
    }
}