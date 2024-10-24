/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructurasDeDatos;

/**
 * @version 15/10/2024
 * @author Michelle García
 */
public class Cola {
    
    private Lista queue = new Lista();

    public void enqueue(Object j) {
        queue.Add(j);
    }

    public Object dequeue() {
        if (queue.Count() > 0) {
            Object value = queue.Get(0);
            queue.Remove(0);
            return value;
        }
        return null;
    }

    public int getCount() {
        return queue.Count();
    }

    public Object get(int index) {
        return queue.Get(index);
    }

}
