/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructurasDeDatos;

/**
 * Esta clase define un objeto grafo que contenga una lista de paradas y un
 * entero para indicar el rango de búsqueda actual
 *
 * @version 24/10/2024
 * @author Michelle García
 */

public class Grafo {
    /**
     * Esta clase define un objeto de tipo grafo. Contiene una lista de todos los nodos existentes.
     */
    private Lista nodos;

    /***
     * Constructor de la clase Grafo. Inicializa la lista de nodos en vacío.
     */
    public Grafo() {
        nodos = new Lista();
    }

    /***
     * Procedimiento para agregar un nodo a la lista de nodos.
     * @param data Objeto de tipo parada
     */
    public void addNode(Parada data) {
        Nodo n = new Nodo(data);
        nodos.Add(n);
    }

    /***
     * Procedimiento para crear una arista entre dos nodos. Los nodos deben de haber sido creados previamente para poder ejecutar
     * el método.
     * 
     * @param Origen Nodo de partida.
     * @param Destino Nodo de llegada.
     */
    public void addEdge(Parada Origen, Parada Destino) {
        Nodo n1 = null;
        Nodo n2 = null;
        for (int x = 0; x < nodos.Count(); x++) {
            Nodo n = (Nodo) nodos.get(x);
            if (n.info.getName().equals(Origen.getName())) {
                n1 = n;
            }
            if (n.info.getName().equals(Destino.getName())) {
                n2 = n;
            }
        }
        if (n1 != null && n2 != null) {
            n1.children.Add(n2);
            n2.parent = n1;
        }
    }

    /***
     * Función para obtener un nodo en función de su objeto parada.
     * 
     * @param data Objeto parada del nodo a buscar.
     * @return Nodo encontrado según la Parada introducida.
     */
    public Nodo getNode(Parada data) {
        for (int x = 0; x < nodos.Count(); x++) {
            Nodo n = (Nodo) nodos.get(x);
            if (n.info.getName().equals(data.getName())) {
                return n;
            }
        }
        return null;
    }

    /**
     * Procedimiento para imprimir los elementos de la lista de nodos.
     */
    public void printGrafo() {
        for (int x = 0; x < nodos.Count(); x++) {
            Nodo n = (Nodo) nodos.get(x);
            System.out.print(n.info.getName() + ": ");

            for (int k = 0; k < n.children.Count(); k++) {
                Nodo c = (Nodo) n.children.get(k);
                if (c != null){
                    System.out.print(c.info.getName() + " ");
                }
            }
            System.out.println();
        }
    }

}
