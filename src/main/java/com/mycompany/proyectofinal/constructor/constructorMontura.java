package com.mycompany.proyectofinal.constructor;
import jakarta.json.bind.annotation.JsonbPropertyOrder;

@JsonbPropertyOrder({ 
    "codigoMontura", 
    "tipoMontura", 
    "precio", 
    "longitudMontura", 
    "anchoPuente", 
    "longitudVarilla", 
    "longitudLente", 
    "linkFoto" 
})


public class constructorMontura {
    private int codigoMontura;
    private String tipoMontura;
    private double precio;
    private double longitudMontura;
    private double anchoPuente;
    private double longitudVarilla;
    private double longitudLente;
    private String linkFoto;

    // Constructor completo
    public constructorMontura(int codigoMontura, String tipoMontura, double precio, double longitudMontura, 
                   double anchoPuente, double longitudVarilla, double longitudLente, String linkFoto) {
        this.codigoMontura = codigoMontura;
        this.tipoMontura = tipoMontura;
        this.precio = precio;
        this.longitudMontura = longitudMontura;
        this.anchoPuente = anchoPuente;
        this.longitudVarilla = longitudVarilla;
        this.longitudLente = longitudLente;
        this.linkFoto=linkFoto;
    }
    
    public constructorMontura() {}

    // Getters y Setters
    public int getCodigoMontura() {
        return codigoMontura;
    }

    public void setCodigoMontura(int codigoMontura) {
        this.codigoMontura = codigoMontura;
    }

    public String getTipoMontura() {
        return tipoMontura;
    }

    public void setTipoMontura(String tipoMontura) {
        this.tipoMontura = tipoMontura;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getLongitudMontura() {
        return longitudMontura;
    }

    public void setLongitudMontura(double longitudMontura) {
        this.longitudMontura = longitudMontura;
    }

    public double getAnchoPuente() {
        return anchoPuente;
    }

    public void setAnchoPuente(double anchoPuente) {
        this.anchoPuente = anchoPuente;
    }

    public double getLongitudVarilla() {
        return longitudVarilla;
    }

    public void setLongitudVarilla(double longitudVarilla) {
        this.longitudVarilla = longitudVarilla;
    }

    public double getLongitudLente() {
        return longitudLente;
    }

    public void setLongitudLente(double longitudLente) {
        this.longitudLente = longitudLente;
    }
    
    public String getLinkFoto() {
        return linkFoto;
    }

    public void setLinkFoto(String linkFoto) {
        this.linkFoto = linkFoto;
    }

    // Método toString para visualizar los datos
    @Override
    public String toString() {
        return "Montura{" +
                "codigoMontura=" + codigoMontura +
                ", tipoMontura='" + tipoMontura + '\'' +
                ", precio=" + precio +
                ", longitudMontura=" + longitudMontura +
                ", anchoPuente=" + anchoPuente +
                ", longitudVarilla=" + longitudVarilla +
                ", longitudLente=" + longitudLente +
                ", linkFoto=" + linkFoto + '\'' +
                '}';
    }
}
