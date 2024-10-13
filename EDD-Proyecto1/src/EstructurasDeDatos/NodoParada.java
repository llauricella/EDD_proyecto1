/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructurasDeDatos;

/**
 * @version 13/10/2024
 * @author Michelle García
 */
public class NodoParada {
    
    private NodoParada pNext;
    private Parada info;
    private boolean visitado;

    /**
     * Constructor de la clase Nodo
     * @param info
     */
    public NodoParada(Parada info) {
        this.pNext = null;
        this.info = info;
        this.visitado = false;
    }

    /**
     * @return the pNext
     */
    public NodoParada getpNext() {
        return pNext;
    }

    /**
     * @param pNext the pNext to set
     */
    public void setpNext(NodoParada pNext) {
        this.pNext = pNext;
    }

    /**
     * @return the info
     */
    public Parada getInfo() {
        return info;
    }

    /**
     * @param info the info to set
     */
    public void setInfo(Parada info) {
        this.info = info;
    }

    
    
    
}
