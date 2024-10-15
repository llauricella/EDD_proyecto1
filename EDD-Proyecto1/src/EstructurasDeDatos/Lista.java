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
    
    private Nodo pFirst;
    private Nodo pLast;
    private int size;
    
    /**
     * Constructor de la clase
     */
    public Lista() {
        this.pFirst = null;
        this.pLast = null;
        this.size = 0;
    }

    /**
     * @return the pFirst
     */
    public Nodo getpFirst() {
        return pFirst;
    }

    /**
     * @param pFirst the pFirst to set
     */
    public void setpFirst(Nodo pFirst) {
        this.pFirst = pFirst;
    }

    /**
     * @return the pLast
     */
    public Nodo getpLast() {
        return pLast;
    }

    /**
     * @param pLast the pLast to set
     */
    public void setpLast(Nodo pLast) {
        this.pLast = pLast;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }
    
    
    public boolean es_vacio(){
        return pFirst == null;
    }
    
    // Función para buscar una parada por su nombre
    public Nodo buscar (String name){
        Nodo aux = this.getpFirst();
        while (aux != null){
            if (aux.getInfo().getName().equals(name)){
                break;
            }
            else {
                aux = aux.getpNext();
            }
        }
        return aux;
    }
    
    // Función para insertar una parada al final
    public void insertar_final (Nodo nodo){
        if (!this.es_vacio()){
            this.setpFirst(nodo);
            nodo.setpNext(pLast);
        }
        else {
            Nodo aux = this.getpFirst();
            while (aux.getpNext() != null){
                aux = aux.getpNext();
            }
            aux.setpNext(nodo);
            nodo.setpNext(null);
        }
    }
    
    // Función para ver el contenido de la lista
    public void leer (){
    
    
    }
    
    // Función para eliminar un elemento de la lista
    public void eliminar (Nodo out){
    
        if (getpFirst() == out){
            setpFirst(getpFirst().getpNext());
        }
        else {
            Nodo aux = getpFirst();
            while (aux != out){
                aux = aux.getpNext();
            }
            Nodo next = aux.getpNext().getpNext();
            aux.setpNext(next);
            setSize(getSize()-1);
        }
    
    }
    
    // Funcion para vaciar la lista
    public void vaciar (){
        this.pFirst = this.pLast = null;
        this.setSize(0);
    }
    
}
