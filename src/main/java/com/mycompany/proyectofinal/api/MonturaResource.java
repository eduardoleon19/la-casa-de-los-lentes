package com.mycompany.proyectofinal.api;

import com.mycompany.proyectofinal.beans.BeanMontura;
import com.mycompany.proyectofinal.constructor.constructorMontura;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/monturas")
public class MonturaResource {

    @Inject
    private BeanMontura beanMontura;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response obtenerMonturas() {
        List<constructorMontura> monturas = beanMontura.getListaMonturas();
        return Response.ok(monturas).build();
    }
    
    @POST
    @Path("/agregar")
    public Response agregarMontura(constructorMontura montura) {
        if (montura == null || montura.getCodigoMontura() == 0 || montura.getTipoMontura() == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                .entity("{\"message\": \"Datos de la montura inválidos o incompletos\"}")
                .build();
        }

        beanMontura.setMontura(montura);
        String resultado = beanMontura.agregarMontura();

        if ("monturasLista".equals(resultado)) {
            return Response.status(Response.Status.CREATED)
                .entity("{\"message\": \"Montura agregada correctamente\"}")
                .build();
        } else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity("{\"message\": \"Error al agregar montura\"}")
                .build();
        }
    }
}
