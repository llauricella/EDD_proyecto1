/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructurasDeDatos;

/**
 * En esta clase se almacenan todos lo métodos de busca a ejecutar.
 *
 * @version 24/10/2024
 * @author Michelle García
 */
public class Busquedas {

    /**
     * Función de búsqueda por amplitud, utilizando un límite determinado.
     *
     * @param root Nodo donde se iniciará la búsqueda
     * @param heightLimit Altura máxima que podrá alcanzar la búsqueda.
     * @return Una lista que contenga a todos los nodos que se lograron visitar
     * dentro del rango de búsqueda.
     */
    public static Lista BFS(Nodo root, int heightLimit) {
        // Breadth-First Search from parent to children
        return getAllNodesByHeight(visitAllNodesBFS(root), heightLimit);
    }

    /**
     * Función de búsqueda por profundidad utilizando un límite determinado.
     *
     * @param root Nodo donde se iniciará la búsqueda
     * @param heightLimit Altura máxima que podrá alcanzar la búsqueda.
     * @return Una lista que contenga a todos los nodos que se lograron visitar
     * dentro del rango de búsqueda.
     */
    public static Lista DFS(Nodo root, int heightLimit) {
        return getAllNodesByHeight(visitAllNodesDFS(root), heightLimit);
    }

    /**
     * *
     *
     *
     * @param root
     * @param heightLimit
     * @return
     */
    public static Lista BFSSucursal(Nodo root, int heightLimit) {
        return getAllNodesByHeight(visitAllNodesBFSSucursal(root), heightLimit);
    }

    /**
     * Función que visita todos los nodos dentro del grafo utilizando la
     * búsqueda por amplitud.
     *
     * @param root Nodo donde se iniciará el recorrido.
     * @return Una lista con todos los nodos visitados.
     */
    private static Lista visitAllNodesBFS(Nodo root) {
        Lista visitedNodes = new Lista();
        Lista visited = new Lista();
        Cola queue = new Cola();

        queue.enqueue(root);
        root.setHeight(0);

        while (queue.getCount() > 0) {
            Nodo currentNode = (Nodo) queue.dequeue();

            if (currentNode == null) {
                break;
            }

            if (!visited.contains(currentNode)) {
                visited.add(currentNode);
                visitedNodes.add(currentNode);

                if (currentNode.getChildren() != null) {
                    for (int i = 0; i < currentNode.getChildren().count(); i++) {
                        Nodo child = (Nodo) currentNode.getChildren().get(i);
                        if (child != null && !visited.contains(child)) {
                            queue.enqueue(child);
                            child.setHeight(currentNode.getHeight() + 1);
                        }
                    }
                }
            }
        }
        return visitedNodes;
    }

    /**
     * Función que visita todos los nodos dentro del grafo utilizando la
     * búsqueda por amplitud. Su finalidad es encontrar todos los nodos que
     * no posean una sucursal.
     *
     * @param root Nodo donde se iniciará el recorrido.
     * @return Una lista con todos los nodos visitados sin sucursal.
     */
    private static Lista visitAllNodesBFSSucursal(Nodo root) {
        Lista visitedNodes = new Lista();
        Lista visited = new Lista();
        Cola queue = new Cola();

        queue.enqueue(root);
        root.setHeight(0);

        while (queue.getCount() > 0) {
            Nodo currentNode = (Nodo) queue.dequeue();

            if (currentNode == null) {
                break;
            }
            if (currentNode.getInfo().isSucursal() == false) {
                if (!visited.contains(currentNode)) {
                    visited.add(currentNode);
                    visitedNodes.add(currentNode);

                    if (currentNode.getChildren() != null) {
                        for (int i = 0; i < currentNode.getChildren().count(); i++) {
                            Nodo child = (Nodo) currentNode.getChildren().get(i);
                            if (child != null && !visited.contains(child)) {
                                queue.enqueue(child);
                                child.setHeight(currentNode.getHeight() + 1);
                            }
                        }
                    }
                }
            }
        }
        return visitedNodes;
    }

    /**
     * Función que visita todos los nodos dentro del grafo utilizando la
     * búsqueda por profundidad.
     *
     * @param root Nodo donde se iniciará el recorrido.
     * @return Una lista con todos los nodos visitados.
     */
    private static Lista visitAllNodesDFS(Nodo root) {
        Lista visitedNodes = new Lista();
        Lista visited = new Lista();
        Pila stack = new Pila();

        stack.push(root);
        root.setHeight(0);

        while (stack.getCount() > 0) {
            Nodo currentNode = (Nodo) stack.pop();

            if (currentNode == null) {
                break;
            }

            if (!visited.contains(currentNode)) {
                visited.add(currentNode);
                visitedNodes.add(currentNode);

                if (currentNode.getChildren() != null) {
                    for (int i = 0; i < currentNode.getChildren().count(); i++) {
                        Nodo child = (Nodo) currentNode.getChildren().get(i);
                        if (child != null && !visited.contains(child)) {
                            stack.push(child);
                            child.setHeight(currentNode.getHeight() + 1);
                        }
                    }
                }
            }
        }
        return visitedNodes;
    }

    /**
     * Función que filtra los nodos con base a una altura determinada.
     *
     * @param grafo Lista de nodos a filtrar.
     * @param heightLimit Límite de búsqueda.
     * @return Una lista de todos los nodos que se encuentren dentro del límite
     * específicado.
     */
    private static Lista getAllNodesByHeight(Lista grafo, int heightLimit) {
        Lista result = new Lista();
        for (int n = 0; n < grafo.count(); n++) {
            Nodo nodo = (Nodo) grafo.get(n);
            if (nodo != null){
                if (!result.contains(nodo)) {
                    if (nodo.getHeight() <= heightLimit) {
                        result.add(nodo);
                    }
                }
            }
        }
        return result;
    }
}
