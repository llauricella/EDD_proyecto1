/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructurasDeDatos;

/**
 * @version 13/10/2024
 * @author Michelle García
 */
public class Parada {
    
    private String name;
    private boolean sucursal;
    private Lista adyacentes;

    public Parada(String name) {
        this.name = name;
        this.sucursal = false;
        this.adyacentes = new Lista();
    }

   
    /**
     * @return the sucursal
     */
    public boolean hasSucursal() {
        return isSucursal();
    }

    /**
     * @param sucursal the sucursal to set
     */
    public void setSucursal(boolean sucursal) {
        this.sucursal = sucursal;
    }

    /**
     * @return the adyacentes
     */
    public Lista getAdyacentes() {
        return adyacentes;
    }

    /**
     * @param adyacentes the adyacentes to set
     */
    public void setAdyacentes(Lista adyacentes) {
        this.adyacentes = adyacentes;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the sucursal
     */
    public boolean isSucursal() {
        return sucursal;
    }

    /**
     */
    public void seleccionar_sucursal() {
        this.setSucursal(true);
    }

    /**
     */
    public void quitar_sucursal() {
        this.setSucursal(false);
    }

    /**
     * @return
     */
    public String leer_info() {
        String txt = "";
        txt = txt + "\nNombre: " + getName();
        return txt;
    }

}
