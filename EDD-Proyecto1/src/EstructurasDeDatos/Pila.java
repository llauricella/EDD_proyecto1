/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructurasDeDatos;

/**
 * @version 24/10/2024
 * @author Michelle García
 */
public class Pila {
    /**
     * Esta clase define un objeto de tipo stack. Contiene una lista de elementos.
     */
    
    private Lista stack = new Lista();

    /**
     * Procedimiento para apilar un elemento.
     * 
     * @param j Elemento a apilar.
     */
    public void Push(Object j) {
        stack.Add(j);
    }

    /**
     * Función para desapilar un elemento y devolver el elemento desapilado.
     * 
     * @return Objeto desapilado.
     */
    public Object Pop() {
        if (stack.Count() > 0) {
            Object value = stack.Get(stack.Count() - 1);
            stack.Remove(stack.Count() - 1);
            return value;
        }
        return null;
    }

    /**
     * Función para obtener la cantidad de elementos de la pila.
     * 
     * @return Cantidad de elementos de la pila.
     */
    public int getCount() {
        return stack.Count();
    }

    /**
     * Función para retornar un elemento de la lista de la pila según su índice.
     * 
     * @param index Indice de un elemento de la pila.
     * @return Elemento de la pila según el índice indicado.
     */
    public Object Get(int index) {
        return stack.Get(index);
    }

    /**
     * Procedimiento para eliminar un elemento de la pila según su índice.
     * 
     * @param index Indice de un elemento de la pila.
     */
    public void Remove(int index) {
        stack.Remove(index);
    }

    /**
     * Procedimiento para apilar un elemento.
     * 
     * @param j Elemento a apilar.
     */
    public void Add(Object j) {
        stack.Add(j);
    }

    /**
     * Función para obtener la posicion de un elemento dentro de la pila.
     * 
     * @param element Elemento a encontrar.
     * @return Posición del elemento.
     */
    public int GetStackPosition(Object element) {
        int c = stack.Count();
        for (int i = 0; i < c; i++) {
            Object elem = stack.Get(i);

            if (elem.equals(element)) {
                return i;
            }
        }
        return -1; // Element not found
    }
    
    /**
     * Procedimiento para limpiar la pila.
     */
    public void Clear() {
        stack = new Lista();
    }
    
    /**
     * Procedimiento para imprimir los elementos de la pila.
     */
    public void printStack() {
        for (int i = 0; i < getCount(); i++) {
            System.out.println(stack.Get(i));
        }
    }
}
