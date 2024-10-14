/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructurasDeDatos;

/**
 * 
 * @version 13/10/2024
 * @author Michelle García
 */

public class Grafo {
    
    private ListaParada paradas; // Lista de la primera parada de cada línea
    private DFS DFS;
    private BFS BFS;
    private int t;

    /**
     * Constructor de la clase grafo
     * @param paradas
     * @param t
     */
    public Grafo(ListaParada paradas, int t) {
        this.paradas = paradas;
        this.BFS = new BFS(paradas);
        this.DFS = new DFS(paradas);
        this.t = t;
    }
    
    /**
     * @return the paradas
     */
    public ListaParada getParadas() {
        return paradas;
    }

    /**
     * @param paradas the paradas to set
     */
    public void setParadas(ListaParada paradas) {
        this.paradas = paradas;
    }

    /**
     * @return the t
     */
    public int getT() {
        return t;
    }

    /**
     * @param t the t to set
     */
    public void setT(int t) {
        this.t = t;
    }
    
    
    
    public void agregar_linea (){
    
    }
    
    public String cobertura_total (){
    
        return null;
    }
    
    // Debe recibir cual es el nodo a buscar a través de la señal de un botón
    public void busqueda_profundidad (NodoParada origen, NodoParada objetivo, int t){
        this.DFS.busqueda_profundidad(origen, objetivo);
    }
    
    public void busqueda_amplitud (){
        
    }
    
    public void cargar_API(){
    
    }
    
    public void guardar_API(){
    
    }

    
}
