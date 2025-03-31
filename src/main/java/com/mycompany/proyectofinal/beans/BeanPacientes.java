
package com.mycompany.proyectofinal.beans;

import com.mycompany.proyectofinal.constructor.constructorPaciente;
import com.mycompany.proyectofinal.dao.PacienteDAO;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named 
@SessionScoped
public class BeanPacientes implements Serializable {
    private List<constructorPaciente> listaPacientes;
    private constructorPaciente paciente;
    private PacienteDAO pacienteDAO;
    
    public BeanPacientes() {
        pacienteDAO = new PacienteDAO();
        paciente = new constructorPaciente(0, "", "", 0, "", "", "");
        cargarPacientes();
    }
    
    // CARGAR LISTA DE PACIENTES
    public void cargarPacientes() {
        listaPacientes = pacienteDAO.obtenerPacientes();
    }
    
    // AGREGAR PACIENTE
    public String agregarPaciente() {
        boolean agregado = pacienteDAO.agregarPaciente(paciente);
        if (agregado) {
            cargarPacientes();
            limpiarFormulario();
            return "pacientesLista";
        } else {
            return null;
        }
    }

    public void limpiarFormulario() {
        this.paciente = new constructorPaciente(0, "", "", 0, "", "", "");
    }

    public List<constructorPaciente> getListaPacientes() {
        return listaPacientes;
    }
    
    public constructorPaciente getPaciente() {
        return paciente;
    }
    
    public void setPaciente(constructorPaciente paciente) {
        this.paciente = paciente;
    }
    

}
