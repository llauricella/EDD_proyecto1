/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructurasDeDatos;

/**
 * Esta clase define un objeto grafo que contenga una lista de paradas y un
 * entero para indicar el rango de búsqueda actual
 *
 * @author Michelle García
 * @version 13/10/2024
 */
public class Grafo {

    private Lista paradas;

    /**
     * Constructor de la clase grafo
     *
     * @param paradas Define la lista de paradas correspondientes al grafo
     */
    public Grafo(Lista paradas) {
        this.paradas = paradas;
    }

    /**
     * Método que devuelve la lista que contiene las paradas del grafo
     *
     * @return Lista actual de paradas
     */
    public Lista getParadas() {
        return paradas;
    }

    /**
     * Procedimiento que introduce una lista de paradas dentro del grafo dada
     * una lista nueva
     *
     * @param paradas Nueva lista de paradas
     */
    public void setParadas(Lista paradas) {
        this.paradas = paradas;
    }

    /**
     * Método para encontrar si las sucursales actuales del grafo cubren toda
     * una ciudad
     *
     * @return Un string donde se encuentre la información acorde a los
     * resultados
     */
    public String cobertura_total() {
        String txt = "";
        
        Nodo first = this.getParadas().getpFirst();
        DFS dfs = new DFS(getParadas());
        Lista pendientes = dfs.obtener_cobertura(first);
        

        if (pendientes == null) {
            txt = "Las sucursales cubren toda la ciudad";
        } else {
            txt = txt + "Sucursales recomendadas para lograr la cobertura total: \n"
                    + pendientes.leer();
        }
        Nodo inicio = this.getParadas().getpFirst();
        BFS bfs = new BFS ();
        Lista obtener = bfs.obtener_cobertura(inicio);

        if (pendientes == null) {
            txt = "Las sucursales cubren toda la ciudad";
        } else {
            txt = txt + "Sucursales recomendadas para lograr la cobertura total: \n"
                    + obtener.leer();
        }
        return txt;
    }

    /**
     * Método que devuelve una lista de las paradas más cercanas a una parada
     * específica según DFS
     *
     * @param origen Nodo desde el cual se empezará la búsqueda
     * @param objetivo Nodo a encontrar
     * @param t Rango de búsqueda
     * @return Lista que contenga las paradas más cercanas dentro del rango
     * indicado
     */
    public Lista cobertura_profundidad(Nodo origen, Nodo objetivo, int t) {
        DFS dfs = new DFS(getParadas());
        Lista encontrados = dfs.buscar_adyacentes(origen, t, objetivo);
        return encontrados;
    }

    /**
     * Método que devuelve una lista de las paradas más cercanas a una parada
     * específica según BFS
     *
     * @param origen Nodo desde el cual se empezará la búsqueda
     * @param objetivo Nodo a encontrar
     * @param t Rango de búsqueda
     * @return Lista que contenga las paradas más cercanas dentro del rango
     * indicado
     */
    public Lista cobertura_amplitud(Nodo origen, Nodo objetivo, int t) {
        BFS bfs = new BFS();
        Lista encontrados = bfs.buscar_adyacentes(origen, t, objetivo);
        return encontrados;
    }


}
