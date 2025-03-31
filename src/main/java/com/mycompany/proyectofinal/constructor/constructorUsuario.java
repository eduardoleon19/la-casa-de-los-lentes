
package com.mycompany.proyectofinal.constructor;

public class constructorUsuario {
    private String nombreUsuario;
    private String apellidoUsuario;
    private String correo;
    private String contrasena;

    public constructorUsuario(String nombreUsuario, String apellidoUsuario, String correo, String contrasena) {
        this.nombreUsuario = nombreUsuario;
        this.apellidoUsuario = apellidoUsuario;
        this.correo = correo;
        this.contrasena = contrasena;
    }
    
    
    public constructorUsuario() {}

    public String getNombre() {
        return nombreUsuario;
    }

    public void setNombre(String nombre) {
        this.nombreUsuario = nombre;
    }

    public String getApellido() {
        return apellidoUsuario;
    }

    public void setApellido(String apellido) {
        this.apellidoUsuario = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
