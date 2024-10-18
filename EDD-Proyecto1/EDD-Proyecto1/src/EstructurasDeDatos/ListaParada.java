/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructurasDeDatos;

/**
 * 
 * @version 13/10/2024
 * @author Michelle García
 */
public class ListaParada {
    
    private NodoParada pFirst;
    private NodoParada pLast;
    private int size;
    
    /**
     * Constructor de la clase
     */
    public ListaParada() {
        this.pFirst = null;
        this.pLast = null;
        this.size = 0;
    }

    /**
     * @return the pFirst
     */
    public NodoParada getpFirst() {
        return pFirst;
    }

    /**
     * @param pFirst the pFirst to set
     */
    public void setpFirst(NodoParada pFirst) {
        this.pFirst = pFirst;
    }

    /**
     * @return the pLast
     */
    public NodoParada getpLast() {
        return pLast;
    }

    /**
     * @param pLast the pLast to set
     */
    public void setpLast(NodoParada pLast) {
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
    public NodoParada buscar_parada (String name){
        NodoParada aux = this.getpFirst();
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
    public void insertar_final (NodoParada nodo){
        if (!this.es_vacio()){
            this.setpFirst(nodo);
            nodo.setpNext(pLast);
        }
        else {
            NodoParada aux = this.getpFirst();
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
}
