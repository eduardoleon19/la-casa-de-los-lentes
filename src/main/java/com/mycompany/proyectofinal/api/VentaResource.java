package com.mycompany.proyectofinal.api;


import com.mycompany.proyectofinal.beans.BeanVentas;
import com.mycompany.proyectofinal.constructor.constructorVenta;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import jakarta.ws.rs.Path;

@Path("/ventas")
@RequestScoped
public class VentaResource {
    
    @Inject
    private BeanVentas beanVentas;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response obtenerVentas() {
        List<constructorVenta> ventas = beanVentas.getListaVentas();
        return Response.ok(ventas).build();
    }
    
    @POST
    @Path("/agregar")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response agregarVenta(constructorVenta venta) {
        if (venta == null || venta.getCodigoBoleta() == 0 || venta.getDniPaciente() == 0 || venta.getCostoTotal() <= 0) {
            return Response.status(Response.Status.BAD_REQUEST)
                .entity("{\"message\": \"Datos de la venta inválidos o incompletos\"}")
                .build();
        }
        
        beanVentas.setVenta(venta);
        String resultado = beanVentas.agregarVenta();
        
        if ("ventasLista".equals(resultado)) {
            return Response.status(Response.Status.CREATED)
                .entity("{\"message\": \"Venta agregada correctamente\"}")
                .build();
        } else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity("{\"message\": \"Error al agregar la venta\"}")
                .build();
        }
    }
    
    @GET
    @Path("/{codigoBoleta}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response obtenerVentaPorCodigo(@PathParam("codigoBoleta") int codigoBoleta) {
        constructorVenta venta = beanVentas.getVentasDAO().getVentaByCodigo(codigoBoleta);
        if (venta != null) {
            return Response.ok(venta).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                .entity("{\"message\": \"Venta no encontrada\"}")
                .build();
        }
    }
    
    @PUT
    @Path("/actualizar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response actualizarVenta(constructorVenta venta) {
        boolean actualizado = beanVentas.actualizarVenta(venta);

        if (actualizado) {
            return Response.ok("{\"message\": \"Venta actualizada correctamente\"}").build();
        } else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity("{\"message\": \"Error al actualizar la venta\"}")
                .build();
        }
    }

    @DELETE
    @Path("/eliminar/{codigoBoleta}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response eliminarVenta(@PathParam("codigoBoleta") int codigoBoleta) {
        boolean eliminado = beanVentas.eliminarVenta(codigoBoleta);

        if (eliminado) {
            return Response.ok("{\"message\": \"Venta eliminada correctamente\"}").build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                .entity("{\"message\": \"Venta no encontrada\"}")
                .build();
        }
    }

}