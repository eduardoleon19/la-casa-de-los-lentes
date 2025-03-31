package com.mycompany.proyectofinal.api;

import com.mycompany.proyectofinal.beans.BeanUsuarios;
import com.mycompany.proyectofinal.constructor.constructorUsuario;
import com.mycompany.proyectofinal.dao.UsuarioDAO;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioResource {

    private UsuarioDAO usuarioDAO = new UsuarioDAO();
    
    @Inject
    private BeanUsuarios beanUsuarios;

    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registrarUsuario(constructorUsuario usuario) {
        if (usuario == null || 
            usuario.getNombre() == null || usuario.getNombre().trim().isEmpty() || 
            usuario.getApellido() == null || usuario.getApellido().trim().isEmpty() ||
            usuario.getCorreo() == null || usuario.getCorreo().trim().isEmpty() ||
            usuario.getContrasena() == null || usuario.getContrasena().trim().isEmpty()) {
            
            return Response.status(Response.Status.BAD_REQUEST)
                .entity("{\"mensaje\": \"Datos de usuario inválidos o incompletos\"}")
                .build();
        }

        beanUsuarios.setUsuario(usuario);
        String resultado = beanUsuarios.registrarUsuario();

        if ("registroExitoso".equals(resultado)) {
            return Response.status(Response.Status.CREATED)
                .entity("{\"mensaje\": \"Usuario registrado exitosamente\"}")
                .build();
        } else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity("{\"mensaje\": \"Error al registrar el usuario\"}")
                .build();
        }
    }

    @POST
    @Path("login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(constructorUsuario usuario) {
        constructorUsuario usuarioValidado = usuarioDAO.validarUsuario(usuario.getCorreo(), usuario.getContrasena());

        if (usuarioValidado != null) {
            return Response.ok("{\"mensaje\": \"Inicio de sesión correcto\"}").build();
        } else {
            return Response.status(Response.Status.UNAUTHORIZED)
                           .entity("{\"mensaje\": \"Correo o contraseña incorrectos\"}")
                           .build();
        }
    }


    @OPTIONS
    @Path("{path:.*}")
    public Response handlePreflight() {
        return Response.ok()
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "POST, GET, OPTIONS")
                .header("Access-Control-Allow-Headers", "Content-Type, Authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .build();
    }
}
