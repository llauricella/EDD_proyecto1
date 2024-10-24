/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructurasDeDatos;

/**
 * @version 24/10/2024
 * @author Michelle García
 */
public class Busquedas {

    public static Lista BFS(Nodo root, int heightLimit) {
        // Busqueda en anchura de padre a hijos
        Lista result1 = new Lista();

        if (root == null) {
            return result1;
        }

        Cola queue = new Cola();
        queue.enqueue(root);
        int currentHeight = 0;

        while (queue.getCount() > 0 && currentHeight <= heightLimit) {
            int levelSize = queue.getCount();
            for (int i = 0; i < levelSize; i++) {
                Nodo currentNode = (Nodo) queue.dequeue();
                result1.Add(currentNode);

                if (currentNode != null && currentNode.children != null) {
                    for (int x = 0; x < currentNode.children.Count(); x++) {
                        Nodo child = (Nodo) currentNode.children.get(x);
                        queue.enqueue(child);
                    }
                }
            }
            currentHeight++;
        }

        result1.Remove(0);

        // Busqueda en anchura de hijos a padre
        Lista result2 = new Lista();
        Cola queue2 = new Cola();
        queue2.enqueue(root);
        currentHeight = 0;

        while (queue2.getCount() > 0 && currentHeight <= heightLimit) {
            int levelSize = queue2.getCount();

            for (int i = 0; i < levelSize; i++) {
                Nodo currentNode = (Nodo) queue2.dequeue();
                result2.Add(currentNode);

                if (currentNode != null && currentNode.parent != null) {
                    queue2.enqueue(currentNode.parent);
                }
            }
            currentHeight++;
        }

        if (result2.Count() > 0) {
            result2.Remove(0);
            result1.AddRange(result2);
        }

        return result1;
    }

     public Lista BFSExtendido(Nodo input, int heightLimit){
    
        Nodo root = input;
        Lista bfsRamaIzquierda = BFS(root, heightLimit);
        Nodo parent = null;
        
        do {
            if (root.parent != null){
                parent = root.parent;
                root = parent;
            } else {
                break;
            }
        
        } while (parent != null);
        
        if (parent != null){
            Lista bfsRamaDerecha = DFS(parent,(heightLimit)-1);
            bfsRamaIzquierda.AddRange(bfsRamaDerecha);
            int i = bfsRamaIzquierda.indexOf(input);
            bfsRamaIzquierda.Remove(i);
        }
        return bfsRamaIzquierda;
    }
    
    /**
     * Implementa la busqueda en profundidad
     *
     * @param root
     * @param heightLimit
     * @return
     */
    public static Lista DFS(Nodo root, int heightLimit) {
        Lista result1 = new Lista();

        // Busqueda en anchura de padres a hijo
        if (root == null) {
            return result1;
        }

        Pila stack1 = new Pila();
        stack1.Push(root);

        while (stack1.getCount() > 0) {
            Nodo currentNode = (Nodo) stack1.Pop();
            int currentHeight = stack1.getCount();

            if (currentHeight > heightLimit) {
                continue;
            }

            if (currentNode == null) {
                break;
            }

            result1.Add(currentNode);

            for (int i = currentNode.children.Count() - 1; i >= 0; i--) {
                stack1.Push(currentNode.children.get(i));
            }
        }

        result1.Remove(0);

        // Busqueda en anchura de hijos a padre
        Lista result2 = new Lista();
        Pila stack2 = new Pila();
        stack2.Push(root);
        int stackSize = 0;

        while (stackSize <= heightLimit) {
            Nodo currentNode = (Nodo) stack2.Pop();

            if (currentNode == null) {
                break;
            }
            result2.Add(currentNode);
            
            if (currentNode.parent != null) {
                stack2.Push(currentNode.parent);
            } 
            stackSize = result2.Count();
        }

        if (result2.Count() > 0) {
            result2.Remove(0);
            result1.AddRange(result2);
        }
        
        

        return result1;
    }
    
    public Lista DFSExtendido(Nodo input, int heightLimit){
    
        Nodo root = input;
        Lista dfsRamaIzquierda = DFS(root, heightLimit);
        Nodo parent = null;
        
        do {
            if (root.parent != null){
                parent = root.parent;
                root = parent;
            } else {
                break;
            }
        
        } while (parent != null);
        
        if (parent != null){
            Lista dfsRamaDerecha = DFS(parent,(heightLimit)-1);
            dfsRamaIzquierda.AddRange(dfsRamaDerecha);
            int i = dfsRamaIzquierda.indexOf(input);
            dfsRamaIzquierda.Remove(i);
        }
        return dfsRamaIzquierda;
    }
    

    /**
     * Implementa la busqueda en profundidad de sucursales
     *
     * @param root
     * @param heightLimit
     * @return
     */
    public static Lista DFSBySucursal(Nodo root, int heightLimit) {
        Lista result = new Lista();

        Lista query = DFS(root, heightLimit);

        for (int i = 0; i < query.Count(); i++) {
            Nodo node = (Nodo) query.get(i);

            if (!node.info.isSucursal()) {
                result.Add(node);
            }
        }

        return result;
    }
    
    public Lista DFSbySucursalExtendido(Nodo input, int heightLimit){
    
        Nodo root = input;
        Lista dfsRamaIzquierda = DFS(root, heightLimit);
        Nodo parent = null;
        
        do {
            if (root.parent != null){
                parent = root.parent;
                root = parent;
            } else {
                break;
            }
        
        } while (parent != null);
        
        if (parent != null){
            Lista dfsRamaDerecha = DFS(parent,(heightLimit)-1);
            dfsRamaIzquierda.AddRange(dfsRamaDerecha);
            int i = dfsRamaIzquierda.indexOf(input);
            dfsRamaIzquierda.Remove(i);
        }
        return dfsRamaIzquierda;
    
    }
    
    
}
