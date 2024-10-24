/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructurasDeDatos;

/**
 * @version 24/10/2024
 * @author Michelle García
 */
public class Cola {
    /**
     * Esta clase define un objeto de tipo cola. Contiene una lista de los elementos encolados.
     *
     */
    private Lista queue = new Lista();

    /**
     *  Procedimiento para encolar un objeto
     * 
     * @param j Objeto a encolar
     */
    public void enqueue(Object j) {
        getQueue().Add(j);
    }

    
    /**
     * Procedimiento para desencolar el primer elemento de la cola
     * 
     * @return Primer elemento de la cola
     */
    public Object dequeue() {
        if (getQueue().Count() > 0) {
            Object value = getQueue().get(0);
            getQueue().Remove(0);
            return value;
        }
        return null;
    }

    /**
     *  Función para obtener la cantidad de elementos encolados en una cola
     * 
     * @return Cantidad de elementos encolados en la cola actual
     */
    public int getCount() {
        return getQueue().Count();
    }

    /**
     * Función para obtener un objeto según su posición
     * 
     * @param index Posición del objeto dentro de la cola
     * @return Objeto según la posición
     */
    public Object get(int index) {
        return getQueue().get(index);
    }
    
    /**
     * Procedimiento para imprimir los elementos de la cola.
     */
    public void printQueue() {
        for (int i = 0; i < getCount(); i++) {
            System.out.println(getQueue().get(i));
        }
    }

    /**
     * @return the queue
     */
    public Lista getQueue() {
        return queue;
    }
    
    

}
