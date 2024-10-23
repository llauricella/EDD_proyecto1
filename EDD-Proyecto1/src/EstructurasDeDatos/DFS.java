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
    private Nodo pCima;
    private int size;
    private int limite = 0;
    private Lista encontrados;

    /**
     * @param original
     */
    public DFS(Lista original) {
        this.pCima = original.getpFirst();
        this.size = 1;
        this.encontrados = new Lista();
    }

    /**
     * @param info
     */
    public void apilar(Parada info) {
        Nodo nuevo = new Nodo(info);
        nuevo.setpNext(getpCima());
        setpCima(nuevo);
        setSize(this.getSize() + 1);
    }

    /**
     */
    public void desapilar() {
        Nodo temp = getpCima();
        setpCima(temp.getpNext());
        setSize(this.getSize() - 1);
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
     * @param origen
     * @param t
     * @param objetivo
     * @return
     */
    public Lista buscar_adyacentes(Nodo origen, int t, Nodo objetivo) {

        if (!origen.getInfo().getName().equals(objetivo.getInfo().getName())) {
            Nodo temp = getpCima();
            if (getpCima() != null) {
                desapilar();
                setLimite(getLimite() + 1);
                buscar_adyacentes(temp, t, objetivo);
            }
        } else {
            for (int i = 1; i <= t; i++) {
                if (origen.getpNext() != null) {
                    getEncontrados().insertar_final(origen.getpNext());
                    origen = origen.getpNext();
                }
            }
        }

        int count = getLimite();
        if (count != (getLimite() - t)) {
            count--;
            getEncontrados().insertar_final(origen);
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
