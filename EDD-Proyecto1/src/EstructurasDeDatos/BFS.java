/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructurasDeDatos;

/**
 *
 * @author miche_ysmoa6e
 */
public class BFS {
    
    private ListaParada no_visitados;
    private ListaParada descubiertos;
    private ListaParada visitados;

    public BFS(ListaParada no_visitados) {
        this.no_visitados = no_visitados;
        this.descubiertos = new ListaParada();
        this.visitados = new ListaParada();
    }
    
    
}
