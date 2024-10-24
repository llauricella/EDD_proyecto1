/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructurasDeDatos;

/**
 *
 * @author miche_ysmoa6e
 */
public class Pila {
    
    private Lista stack = new Lista();

    public void Push(Object j) {
        stack.Add(j);
    }

    public Object Pop() {
        if (stack.Count() > 0) {
            Object value = stack.Get(stack.Count() - 1);
            stack.Remove(stack.Count() - 1);
            return value;
        }
        return null;
    }

    public int getCount() {
        return stack.Count();
    }

    public void Clear() {
        stack = new Lista();
    }

    public Object Get(int index) {
        return stack.Get(index);
    }

    public void Remove(int index) {
        stack.Remove(index);
    }

    public void Add(Object j) {
        stack.Add(j);
    }

    // New property to get the stack position of an element
    public int GetStackPosition(Object element) {
        int c = stack.Count();
        for (int i = 0; i < c; i++) {
            Object elem = stack.Get(i);

            if (elem.equals(element)) {
                return i;
            }
        }
        return -1; // El elemento no ha sido encontrado
    }
}
