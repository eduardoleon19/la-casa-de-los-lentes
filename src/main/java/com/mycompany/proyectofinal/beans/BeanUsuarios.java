package com.mycompany.proyectofinal.beans;

import com.mycompany.proyectofinal.constructor.constructorUsuario;
import com.mycompany.proyectofinal.dao.UsuarioDAO;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;

@Named 
@SessionScoped
public class BeanUsuarios implements Serializable {
    private constructorUsuario usuario;
    private UsuarioDAO usuarioDAO;
    
    public BeanUsuarios() {
        usuarioDAO = new UsuarioDAO();
        usuario = new constructorUsuario("", "", "", "");
    }
    
    // REGISTRAR/AGREGAR USUARIO
    public String registrarUsuario() {
        boolean registrado = usuarioDAO.agregarUsuario(usuario);
        if (registrado) {
            limpiarFormulario();
            return "registroExitoso";
        } else {
            return "errorRegistro";
        }
    }
    
    // LOGIN
    public String login() {
        constructorUsuario usuarioValidado = usuarioDAO.validarUsuario(usuario.getCorreo(), usuario.getContrasena());
        if (usuarioValidado != null) {
            usuario = usuarioValidado;
            return "inicioExitoso";
        } else {
            return "errorLogin";
        }
    }
    
    public void limpiarFormulario() {
        this.usuario = new constructorUsuario("", "", "", "");
    }
    
    public constructorUsuario getUsuario() {
        return usuario;
    }
    
    public void setUsuario(constructorUsuario usuario) {
        this.usuario = usuario;
    }
}