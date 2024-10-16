/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructurasDeDatos;

/**
 * @version 13/10/2024
 * @author Michelle García
 */

public class Grafo {
    
    private Lista paradas; // Lista de la primera parada de cada línea
    private int t;

    /**
     * Constructor de la clase grafo
     * @param paradas
     * @param t
     */
    public Grafo(Lista paradas, int t) {
        this.paradas = paradas;
        this.t = t;
    }
    
    /**
     * @return the paradas
     */
    public Lista getParadas() {
        return paradas;
    }

    /**
     * @param paradas the paradas to set
     */
    public void setParadas(Lista paradas) {
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
    
    
    
    public void agregar_linea (Lista paradas){
    
    }
    
    public String cobertura_total (){
    
        return null;
    }
    
    public Lista cobertura_profundidad (Nodo origen, Nodo objetivo, int t){
        DFS dfs = new DFS(paradas);
        Lista encontrados = dfs.buscar_adyacentes(origen, t, objetivo);
        return encontrados;
    }
    
    public Lista cobertura_amplitud (Nodo origen, Nodo objetivo, int t){
        BFS bfs = new BFS();
        Lista encontrados = bfs.buscar_adyacentes(origen, t, objetivo);
        return encontrados;
    }
    
    public void seleccionar_paradas(){
    
    
    }
    
    public void cargar_API(){
    
    }
    
    public void guardar_API(){
    
    }

    
}
