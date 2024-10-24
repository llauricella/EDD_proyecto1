/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructurasDeDatos;

/**
 * @version 24/10/2024
 * @author Michelle García
 */
public class Lista {

    /**
     * Esta clase define un objeto de tipo lista. Contiene un contador de su cantidad de elementos, una lista donde se almacenan
     * los objetos siguienres y un elemento de tipo ElementoLista.
     */
    private int count = 0;
    private Lista next;
    private ElementoLista value;

    /**
     * Procedimiento para agregar un objeto en la lista
     * @param j
     */
    public void Add(Object j) {
        if (j != null) {
            ElementoLista newValue = new ElementoLista();
            newValue.value = j;
            newValue.index = count;

            if (this.value == null) {
                this.value = newValue;
            } else {
                Lista actual = this;
                while (actual.next != null) {
                    actual = actual.next;
                }
                actual.next = new Lista();
                actual.next.value = newValue;
            }

            count++;
        }
    }

    /**
     * Función para obtener un elemento según su índice dentro de la lista
     * 
     * @param index Índice del elemento a retornar
     * @return Elemento encontrado según su índice
     */
    public Object get(int index) {
        if (index == 0) {
            if (this.value != null) {
                return this.value.value;
            } else {
                return null;
            }
        } else {
            index--;
            return this.next.get(index);
        }
    }

    /**
     * Procedimiento para eliminar un elemento de la lista según su índice
     * 
     * @param index Indice del elemento a eliminar
     */
    public void Remove(int index) {
        if (index >= 0 && index < count) {
            if (index == 0) {
                // Si el elemento a eliminar es el primero de la lista
                if (this.next == null) {
                    this.value = null;
                } else {
                    this.value = this.next.value;
                    this.next = this.next.next;
                }
            } else {
                Lista actual = this;
                for (int i = 0; i < index - 1; i++) {
                    actual = actual.next;
                }

                // Elimina el elemento de la lista
                actual.next = actual.next.next;
            }

            // Actualiza los indices del siguiente elemento
            Lista temp = this;
            int indiceActual = 0;
            while (temp != null) {
                if (temp.value != null) {
                    temp.value.index = indiceActual;
                    indiceActual++;
                }
                temp = temp.next;
            }

            count--;
        }
    }

    /**
     * Función para contar los elementos dentro de la lista
     * 
     * @return Cantidad de elementos de la lista
     */
    public int Count() {
        if (this.next == null) {
            return 1;
        } else {
            return 1 + this.next.Count();
        }
    }

    /**
     * Procedimiento para agregar los elementos de una lista externa a la lista actual
     * 
     * @param h Lista externa
     */
    public void AddRange(Lista h) {
        if (this.count > 0) {
            Lista actual = this;
            while (actual.next != null) {
                actual = actual.next;
            }
            if (h.count > 0) {
                actual.next = h;
                count += h.Count();
            }
        } else {
            this.next = h.next;
            this.value = h.value;
            count += h.Count();
        }
    }
    
    /**
     * Procedimiento para imprimir los elementos de la lista.
     */
    public void printList() {
        for (int i = 0; i < Count(); i++) {
            System.out.println(get(i));
        }
    }
    
    public void findElement(Object root, Object element){
        
        boolean found = false;
        
        do {
            if (root == element){
                found = true;
            } else {
            
            }
        
        
        } while (found != true);
    
    }
}
