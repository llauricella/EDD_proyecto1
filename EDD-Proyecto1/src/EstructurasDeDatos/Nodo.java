/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructurasDeDatos;

/**
 * @version 24/10/2024
 * @author Michelle García
 * 
 */
public class Nodo {
    /***
     * Esta clase define un objeto de tipo Nodo. Contiene una lista donde se almacenan los hijos del nodo, un Nodo donde se 
     * almacena el padre y un objeto de tipo Parada referente a la información que contiene el nodo.
     * 
     */
    public Lista children;
    public Parada info;
    public Nodo parent;
    
   
    /***
     * Constructor de la clase Nodo
     * 
     * @param info Objeto de tipo parada. Información que contiene el nodo.
     */
    public Nodo(Parada info) {
        this.info = info;
        this.children = new Lista();
    }
    
    

}
