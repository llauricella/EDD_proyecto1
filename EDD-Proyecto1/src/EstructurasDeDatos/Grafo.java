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

    private Lista nodos;
    private int t;

    /**
     * *
     * Constructor de la clase Grafo. Inicializa la lista de nodos en vacío.
     *
     * @param t Valor del límite de búsqueda.
     */
    public Grafo(int t) {
        this.nodos = new Lista();
        this.t = t;
    }

    /**
     * *
     * Procedimiento para agregar un nodo a la lista de nodos.
     *
     * @param data Objeto de tipo parada
     */
    public void addNode(Parada data) {
        Nodo n = new Nodo(data);
        nodos.add(n);
    }

    /**
     * *
     * Procedimiento para crear una arista entre dos nodos. Los nodos deben de
     * haber sido creados previamente para poder ejecutar el método.
     *
     * @param Origen Nodo de partida.
     * @param Destino Nodo de llegada.
     */
    public void addEdge(Parada Origen, Parada Destino) {
        Nodo n1 = null;
        Nodo n2 = null;
        for (int x = 0; x < nodos.count(); x++) {
            Nodo n = (Nodo) nodos.get(x);
            if (n.getInfo().getName().equals(Origen.getName())) {
                n1 = n;
            }
            if (n.getInfo().getName().equals(Destino.getName())) {
                n2 = n;
            }
        }
        if (n1 != null && n2 != null) {
            n1.getChildren().add(n2);
            n2.setParent(n1);
        }
    }

    /**
     * *
     * Función para obtener un nodo en función de su objeto parada.
     *
     * @param data Objeto parada del nodo a buscar.
     * @return Nodo encontrado según la Parada introducida.
     */
    public Nodo getNode(Parada data) {
        for (int x = 0; x < nodos.count(); x++) {
            Nodo n = (Nodo) nodos.get(x);
            if (n.getInfo().getName().equals(data.getName())) {
                return n;
            }
        }
        return null;
    }

    /**
     * Procedimiento para imprimir los elementos de la lista de nodos.
     */
    public void printGrafo() {
        for (int x = 0; x < nodos.count(); x++) {
            Nodo n = (Nodo) nodos.get(x);
            System.out.print(n.getInfo().getName() + ": ");

            for (int k = 0; k < n.getChildren().count(); k++) {
                Nodo c = (Nodo) n.getChildren().get(k);
                if (c != null) {
                    System.out.print(c.getInfo().getName() + " ");
                }
            }
            System.out.println();
        }
    }
    
    /**
     * Procedimiento para imprimir los elementos de la lista de nodos.
     * @param name
     * @return 
     */
    public Nodo SelecionarParada(String name){
        for (int x = 0; x < nodos.count(); x++) {
            Nodo n = (Nodo) nodos.get(x);
            if (n.getInfo().getName().equals(name)) {
                System.out.print("La sucursal seleccionada es: " + name);
                return n;
            }
        }
        return null; 
    }
    

    /**
     * Función para obtener el valor del atributo t. Es el límite de búsqueda
     *
     * @return Devuelve el valor de t
     */
    public int getT() {
        return t;
    }

    /**
     * Proceso para cambiar el valor del atributo t
     *
     * @param t Valor nuevo de T
     */
    public void setT(int t) {
        this.t = t;
    }

    /**
     * @return the nodos
     */
    public Lista getNodos() {
        return nodos;
    }

}
