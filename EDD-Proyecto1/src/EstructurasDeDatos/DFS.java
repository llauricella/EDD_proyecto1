/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructurasDeDatos;

/**
 * @version 15/10/2024
 * @author Michelle García
 */
public class DFS {
    // Utiliza LIFO ---> last in, first out
    // Clase pila

    private Nodo pCima;
    private int size;
    private int limite = 0;
    private Lista encontrados;
    
    public DFS(Lista original) {
        this.pCima = original.getpFirst();
        this.size = 1;
    }
    
    public void apilar(Parada info){
        Nodo nuevo = new Nodo(info);
        nuevo.setpNext(getpCima());
        setpCima(nuevo);
        setSize(this.getSize()+1); 
    }
    
    public void desapilar(){
        Nodo temp = getpCima();
        setpCima(temp.getpNext());
        setSize(this.getSize()-1);
    }
    
    public boolean es_vacío(){
        return getpCima() == null;
    }

    /**
     * @return the pCima
     */
    public Nodo getpCima() {
        return pCima;
    }

    /**
     * @param pCima the pCima to set
     */
    public void setpCima(Nodo pCima) {
        this.pCima = pCima;
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

    // Se le deben pasar el pCima del DFS como origen
    public Lista buscar_adyacentes(Nodo origen, int t, Nodo objetivo){
        
        if (origen != objetivo){
            Nodo temp = this.getpCima();
            if (!this.es_vacío()){
                desapilar();
                limite++;
                buscar_adyacentes (temp, t, objetivo);
            }
        }
        else {
            for (int i = 0; i <= t; i++){
                encontrados.insertar_final(origen.getpNext());
                origen = origen.getpNext();
            }
        }
        
        if (limite != (limite-t)){
                limite--;
                encontrados.insertar_final(origen);
            }
        
        return encontrados;
    }
    
    
}
