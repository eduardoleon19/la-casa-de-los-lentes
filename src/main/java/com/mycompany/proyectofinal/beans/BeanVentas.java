package com.mycompany.proyectofinal.beans;

import com.mycompany.proyectofinal.constructor.constructorVenta;
import com.mycompany.proyectofinal.dao.VentaDAO;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named 
@SessionScoped
public class BeanVentas implements Serializable {
    private List<constructorVenta> listaVentas;
    private constructorVenta venta;
    private VentaDAO ventasDAO;
    
    public BeanVentas() {
        ventasDAO = new VentaDAO();
        venta = new constructorVenta(0, "", 0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0, "", 0.0, "");
        cargarVentas();
    }
    
    //CARGAR LISTA DE VENTAS
    public void cargarVentas() {
        listaVentas = ventasDAO.getAllVentas();
    }
    
    // AGREGAR VENTA
    public String agregarVenta() {
        ventasDAO.insertVenta(venta);
        cargarVentas();
        limpiarFormulario();
        return "ventasLista";
    }

    public void limpiarFormulario() {
        this.venta = new constructorVenta(0, "", 0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0, "", 0.0, "");
    }
    
    public List<constructorVenta> getListaVentas() {
        return listaVentas;
    }
    
    public constructorVenta getVenta() {
        return venta;
    }
    
    public void setVenta(constructorVenta venta) {
        this.venta = venta;
    }
    
    // SELECCIONAR VENTA POR CODIGOBOLETA
    public String seleccionarVenta(int codigoBoleta) {
        this.venta = ventasDAO.getVentaByCodigo(codigoBoleta);
        return "ventaDetalles?faces-redirect=true";
    }



    // ELIMINAR VENTA
    public boolean eliminarVenta(int codigoBoleta) {
        boolean eliminado = ventasDAO.deleteVenta(codigoBoleta);
        if (eliminado) {
            cargarVentas();
        }
        return eliminado;
    }

    // ACTUALIZAR VENTA
    public boolean actualizarVenta(constructorVenta venta) {
    boolean actualizado = ventasDAO.updateVenta(venta);
    if (actualizado) {
        cargarVentas();
    }
    return actualizado;
}

    
    public VentaDAO getVentasDAO() {
        return ventasDAO;
    }
    
}
