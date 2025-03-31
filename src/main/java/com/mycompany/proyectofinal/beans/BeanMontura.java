package com.mycompany.proyectofinal.beans;

import com.mycompany.proyectofinal.constructor.constructorMontura;
import com.mycompany.proyectofinal.dao.MonturaDAO;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named 
@SessionScoped
public class BeanMontura implements Serializable {
    private List<constructorMontura> listaMonturas;
    private constructorMontura montura;
    private MonturaDAO monturaDAO;
    
    public BeanMontura() {
        monturaDAO = new MonturaDAO();
        montura = new constructorMontura(0, "", 0.0, 0.0, 0.0, 0.0, 0.0, "");
        cargarMonturas();
    }
    
    // CARGAR LISTA DE MONTURAS
    public void cargarMonturas() {
        listaMonturas = monturaDAO.getAllMonturas();
    }
    
    // AGREGAR MONTURA
    public String agregarMontura() {
        monturaDAO.insertMontura(montura);
        cargarMonturas();
        limpiarFormulario();
        return "monturasLista";
    }

    public void limpiarFormulario() {
        this.montura = new constructorMontura(0, "", 0.0, 0.0, 0.0, 0.0, 0.0, "");
    }
    
    public List<constructorMontura> getListaMonturas() {
        return listaMonturas;
    }
    
    public constructorMontura getMontura() {
        return montura;
    }
    
    public void setMontura(constructorMontura montura) {
        this.montura = montura;
    }
}
