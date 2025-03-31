package com.mycompany.proyectofinal.constructor;

import java.util.Date;
import jakarta.json.bind.annotation.JsonbPropertyOrder;

@JsonbPropertyOrder({ 
    "codigoBoleta", 
    "fechaCreacion", 
    "dniPaciente", 
    
    "esferaIzq",
    "cilindroIzq", 
    "gradoIzq", 
    "distanciaIzq", 
    
    "esferaDer",
    "cilindroDer", 
    "gradoDer", 
    "distanciaDer", 
    
    "codigoMontura", 
    "tipoLuna", 
    "costoTotal", 
    "fechaEntrega" 
})


public class constructorVenta {
    private int codigoBoleta;
    private String fechaCreacion;
    private int dniPaciente;

    private double esferaIzq;
    private double cilindroIzq;
    private double gradoIzq;
    private double distanciaIzq;

    private double esferaDer;
    private double cilindroDer;
    private double gradoDer;
    private double distanciaDer;

    private int codigoMontura;
    private String tipoLuna;
    private double costoTotal;
    private String fechaEntrega;

    // Constructor completo
    public constructorVenta(int codigoBoleta, String fechaCreacion, int dniPaciente, 
                          double esferaIzq, double cilindroIzq, double gradoIzq, double distanciaIzq, 
                          double esferaDer, double cilindroDer, double gradoDer, double distanciaDer, 
                          int codigoMontura, String tipoLuna, double costoTotal, String fechaEntrega) {
        this.codigoBoleta = codigoBoleta;
        this.fechaCreacion = fechaCreacion;
        this.dniPaciente = dniPaciente;
        this.esferaIzq = esferaIzq;
        this.cilindroIzq = cilindroIzq;
        this.gradoIzq = gradoIzq;
        this.distanciaIzq = distanciaIzq;
        this.esferaDer = esferaDer;
        this.cilindroDer = cilindroDer;
        this.gradoDer = gradoDer;
        this.distanciaDer = distanciaDer;
        this.codigoMontura = codigoMontura;
        this.tipoLuna = tipoLuna;
        this.costoTotal = costoTotal;
        this.fechaEntrega = fechaEntrega;
    }
    
    public constructorVenta() {}
    
    // Getters y Setters
    public int getCodigoBoleta() {
        return codigoBoleta;
    }

    public void setCodigoBoleta(int codigoBoleta) {
        this.codigoBoleta = codigoBoleta;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public int getDniPaciente() {
        return dniPaciente;
    }

    public void setDniPaciente(int dniPaciente) {
        this.dniPaciente = dniPaciente;
    }

    public double getEsferaIzq() {
        return esferaIzq;
    }

    public void setEsferaIzq(double esferaIzq) {
        this.esferaIzq = esferaIzq;
    }

    public double getCilindroIzq() {
        return cilindroIzq;
    }

    public void setCilindroIzq(double cilindroIzq) {
        this.cilindroIzq = cilindroIzq;
    }

    public double getGradoIzq() {
        return gradoIzq;
    }

    public void setGradoIzq(double gradoIzq) {
        this.gradoIzq = gradoIzq;
    }

    public double getDistanciaIzq() {
        return distanciaIzq;
    }

    public void setDistanciaIzq(double distanciaIzq) {
        this.distanciaIzq = distanciaIzq;
    }

    public double getEsferaDer() {
        return esferaDer;
    }

    public void setEsferaDer(double esferaDer) {
        this.esferaDer = esferaDer;
    }

    public double getCilindroDer() {
        return cilindroDer;
    }

    public void setCilindroDer(double cilindroDer) {
        this.cilindroDer = cilindroDer;
    }

    public double getGradoDer() {
        return gradoDer;
    }

    public void setGradoDer(double gradoDer) {
        this.gradoDer = gradoDer;
    }

    public double getDistanciaDer() {
        return distanciaDer;
    }

    public void setDistanciaDer(double distanciaDer) {
        this.distanciaDer = distanciaDer;
    }

    public int getCodigoMontura() {
        return codigoMontura;
    }

    public void setCodigoMontura(int codigoMontura) {
        this.codigoMontura = codigoMontura;
    }

    public String getTipoLuna() {
        return tipoLuna;
    }

    public void setTipoLuna(String tipoLuna) {
        this.tipoLuna = tipoLuna;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    // Método toString para mostrar datos de la venta
    @Override
    public String toString() {
        return "RegistroVenta{" +
                "codigoBoleta=" + codigoBoleta +
                ", fechaCreacion=" + fechaCreacion +
                ", dniPaciente=" + dniPaciente +
                ", esferaIzq=" + esferaIzq +
                ", cilindroIzq=" + cilindroIzq +
                ", gradoIzq=" + gradoIzq +
                ", distanciaIzq=" + distanciaIzq +
                ", esferaDer=" + esferaDer +
                ", cilindroDer=" + cilindroDer +
                ", gradoDer=" + gradoDer +
                ", distanciaDer=" + distanciaDer +
                ", codigoMontura=" + codigoMontura +
                ", tipoLuna='" + tipoLuna + '\'' +
                ", costoTotal=" + costoTotal +
                ", fechaEntrega=" + fechaEntrega +
                '}';
    }
}
