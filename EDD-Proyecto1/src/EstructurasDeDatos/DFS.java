/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructurasDeDatos;

/**
 *
 * @author miche_ysmoa6e
 */
public class DFS {
    private ListaParada no_visitados;
    private ListaParada descubiertos;
    private ListaParada visitados;

    public DFS(ListaParada no_visitados) {
        this.no_visitados = no_visitados;
        this.descubiertos = new ListaParada();
        this.visitados = new ListaParada();
    }
    
    // Debe recibir cual es el nodo a buscar a través de la señal de un botón
    public ListaParada busqueda_profundidad (NodoParada origen, NodoParada objetivo){
        ListaParada encontrados = new ListaParada();
        
        if (!this.no_visitados.es_vacio()){
            this.descubiertos.insertar_final(origen);
            for (int i = origen.getInfo().getAdyacentes().getSize(); i >= 0; i--){
                
                NodoParada aux = origen.getInfo().getAdyacentes().getpFirst();
                if (aux.getInfo().getName().equals(objetivo.getInfo().getName())){
                    encontrados.insertar_final(aux);
                }
                busqueda_profundidad(aux, objetivo);
            } 
        }
        else {
            System.out.println("La lista esta vacía");
        }
    
        return encontrados;
    }
    
    
    
}
