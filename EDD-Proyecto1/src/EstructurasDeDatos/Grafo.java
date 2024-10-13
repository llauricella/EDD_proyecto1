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
    private ListaParada DFS;
    private ListaParada BFS;
    private int t;

    /**
     * Constructor de la clase grafo
     * @param paradas
     * @param t
     */
    public Grafo(ListaParada paradas, int t) {
        this.paradas = paradas;
        this.BFS = null;
        this.DFS = null;
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
     * @return the BFS
     */
    public ListaParada getBFS() {
        return BFS;
    }

    /**
     * @param BFS the BFS to set
     */
    public void setBFS(ListaParada BFS) {
        this.BFS = BFS;
    }

    /**
     * @return the DFS
     */
    public ListaParada getDFS() {
        return DFS;
    }

    /**
     * @param DFS the DFS to set
     */
    public void setDFS(ListaParada DFS) {
        this.DFS = DFS;
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
    public void busqueda_profundidad (NodoParada origen, NodoParada objetivo, int t, ListaParada no_visitados){
        
        ListaParada encontrados = new ListaParada();
        
        if (!no_visitados.es_vacio()){
            NodoParada aux = no_visitados.getpFirst();
            
            while (origen != objetivo){
                if (aux.getpNext() != null){
                    if (aux == no_visitados.buscar_parada(objetivo.getInfo().getName())){
                        encontrados.insertar_final(aux);
                    }
                    busqueda_profundidad(aux, objetivo, t, aux.getInfo().getAdyacentes());
                }
            }
            
            origen.getpNext();
        
        }
        else {
            System.out.println("La lista esta vacía");
        }
    
    }
    
    public void busqueda_amplitud (){
        
    }
    
    public void cargar_API(){
    
    }
    
    public void guardar_API(){
    
    }

    
}
