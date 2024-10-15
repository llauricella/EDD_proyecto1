/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructurasDeDatos;

/**
 * @version 15/10/2024
 * @author Michelle García
 */
public class BFS {
    // Utiliza FIFO ----> first in, first out
    // Clase cola
    
    private Lista cola;
    private int limite = 0;
    private Lista encontrados;
    
    public void encolar(Nodo nuevo){
        nuevo.setpNext(null);
        
        if (cola.getpFirst() == null){
            cola.setpFirst(nuevo);
        }
        else {
            cola.getpLast().setpNext(nuevo);
        }
        cola.setpLast(nuevo);
        cola.setSize(cola.getSize()+1);
    }
    
    public void desencolar(){
        Nodo temp = cola.getpFirst();
        cola.setpFirst(temp.getpNext());
        cola.setSize(cola.getSize()-1);
        
        if (cola.getpFirst() == null){
            cola.setpLast(null);
        }
    }
    
    public boolean es_vacio(){
        return cola.getpFirst() == null;
    }
    
    public Lista buscar_adyacentes(Nodo origen, int t, Nodo objetivo){
        encolar(origen);
        
        while (!cola.es_vacio()){
            Nodo actual = cola.getpFirst();
            cola.eliminar(actual);
            
            if (actual.getInfo().getName().equals(objetivo.getInfo().getName())){
                for (int i = 0; i <= t; i++){
                encontrados.insertar_final(actual.getpNext());
                actual = actual.getpNext();
                }
            }
            else {
                limite++;
                actual.setVisitado(true);
                actual = actual.getpNext();
                
                if (actual.isVisitado() == false){
                    encolar(actual);
                    buscar_adyacentes(origen, t, objetivo);
                }
            }
        }
        
        if (limite != (limite-t)){
                limite--;
                encontrados.insertar_final(origen);
            }
        
        return encontrados;
    }

    
    
    
}
