/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructurasDeDatos;

/**
 *
 * @version 15/10/2024
 * @author Michelle García
 */
public class DFS {

    /**
     */
    private Lista pila;
    private int limite = 0;
    private Lista encontrados;
    private Lista visitados;

    /**
     */
    public DFS() {
        this.pila = new Lista();
        this.encontrados = new Lista();
        this.visitados = new Lista();
    }

    /**
     * @param nuevo
     */
    public void apilar(Nodo nuevo) {

        nuevo.setpNext(getpCima());
        setpCima(nuevo);
        getPila().setSize(getPila().getSize() + 1);
    }

    /**
     */
    public void desapilar() {
        Nodo temp = getpCima();
        setpCima(temp.getpNext());
        getPila().setSize(getPila().getSize() - 1);
    }

    /**
     * @return
     */
    public boolean es_vacío() {
        return getpCima() == null;
    }

    /**
     * @return the pCima
     */
    public Nodo getpCima() {
        return getPila().getpFirst();
    }

    /**
     * @param pCima the pCima to set
     */
    public void setpCima(Nodo pCima) {
        this.getPila().setpFirst(pCima);
    }

    /**
     * @return the encontrados
     */
    public Lista getEncontrados() {
        return encontrados;
    }

    /**
     * @return the limite
     */
    public int getLimite() {
        return limite;
    }

    /**
     * @param limite the limite to set
     */
    public void setLimite(int limite) {
        this.limite = limite;
    }

    /**
     * @return the visitados
     */
    public Lista getVisitados() {
        return visitados;
    }

    /**
     * @param visitados the visitados to set
     */
    public void setVisitados(Lista visitados) {
        this.visitados = visitados;
    }

    /**
     * @return the pila
     */
    public Lista getPila() {
        return pila;
    }

    /**
     * @param pila the pila to set
     */
    public void setPila(Lista pila) {
        this.pila = pila;
    }

    /**
     * @param origen
     * @param t
     * @param objetivo
     * @return
     */
    public Lista buscar_adyacentes(Nodo origen, int t, Nodo objetivo) {
        //System.out.println("ejecutado");

        setpCima(origen);
        if (!getpCima().getInfo().getName().equals(objetivo.getInfo().getName())) {
            Nodo temp = getpCima();
            desapilar();
            getVisitados().insertar_final(temp);

            if (!temp.getInfo().getAdyacentes().es_vacio()) {
                for (Nodo i = temp.getInfo().getAdyacentes().getpFirst(); i != null; i = i.getpNext()) {
                    apilar(i);
                }
            }

            temp = getpCima();
            if (temp != null) {
                setLimite(getLimite() + 1);
                buscar_adyacentes(temp, t, objetivo);
            }

        } else {
            for (int i = 1; i <= t; i++) {
                if (origen != null) {
                    if (origen.getpNext() != null) {
                        origen = origen.getpNext();
                    } else {
                        origen = origen.getInfo().getAdyacentes().getpFirst();
                    }
                    
                    if (origen != null) {
                        getEncontrados().insertar_final(origen);
                    }
                }
            }
        }

        int count = getLimite();
        if (count != (getLimite() - t)) {
            count--;
            if (origen != null) {
                getEncontrados().insertar_final(origen);
            }
        }

        return getEncontrados();
    }

    /**
     * @param first
     * @return
     */
    public Lista obtener_cobertura(Nodo first) {

        if (first != null) {
            Nodo temp = this.getpCima();
            if (!this.es_vacío()) {
                desapilar();
                obtener_cobertura(temp);
            }
        } else {
            if (first.getpNext() != null) {
                first = first.getpNext();
                getEncontrados().insertar_final(first);
            }
        }

        return getEncontrados();
    }

}
