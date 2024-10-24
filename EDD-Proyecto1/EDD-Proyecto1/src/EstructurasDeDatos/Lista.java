/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructurasDeDatos;

/**
 * @version 13/10/2024
 * @author Michelle García
 */
public class Lista {

    private int count = 0;
    private Lista next;
    private ElementoLista value;

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

    // Write a method that returns the value of the node at the given index
    public Object Get(int index) {
        if (index == 0) {
            if (this.value != null) {
                return this.value.value;
            } else {
                return null;
            }
        } else {
            index--;
            return this.next.Get(index);
        }
    }

    // Write a method that removes the node at the given index
    public void Remove(int index) {
        if (index >= 0 && index < count) {
            if (index == 0) {
                // If the element to be removed is the first element
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

                // Remove the element
                actual.next = actual.next.next;
            }

            // Update indices of subsequent elements
            Lista temp = this;
            int currentIndex = 0;
            while (temp != null) {
                if (temp.value != null) {
                    temp.value.index = currentIndex;
                    currentIndex++;
                }
                temp = temp.next;
            }

            count--;
        }
    }

    // Write a method to return the number of nodes in the list
    public int Count() {
        if (this.next == null) {
            return 1;
        } else {
            return 1 + this.next.Count();
        }
    }

    // Write a method that adds a range of nodes to the list
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
}
