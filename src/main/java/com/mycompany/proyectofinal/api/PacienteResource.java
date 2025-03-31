package com.mycompany.proyectofinal.api;

import com.mycompany.proyectofinal.beans.BeanPacientes;
import com.mycompany.proyectofinal.constructor.constructorPaciente;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/pacientes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PacienteResource {

    @Inject
    private BeanPacientes beanPacientes;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response obtenerPacientes() {
        List<constructorPaciente> pacientes = beanPacientes.getListaPacientes();
        return Response.ok(pacientes).build();
    }
    
    @POST
    @Path("/agregar")
    public Response agregarPaciente(constructorPaciente paciente) {
        if (paciente == null || paciente.getDniPaciente() == 0 || paciente.getNombrePaciente() == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                .entity("{\"message\": \"Datos del paciente inválidos o incompletos\"}")
                .build();
        }

        beanPacientes.setPaciente(paciente);
        String resultado = beanPacientes.agregarPaciente();

        if ("pacientesLista".equals(resultado)) {
            return Response.status(Response.Status.CREATED)
                .entity("{\"message\": \"Paciente agregado correctamente\"}")
                .build();
        } else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity("{\"message\": \"Error al agregar paciente\"}")
                .build();
        }
    }


}
