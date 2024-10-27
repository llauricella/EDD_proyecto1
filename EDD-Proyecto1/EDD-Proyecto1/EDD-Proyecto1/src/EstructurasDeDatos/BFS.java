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

    /**
     *
     */
    private Lista cola;
    private int limite = 0;
    private Lista encontrados;
    private Lista visitados;

    /**
     *
     */
    public BFS() {
        this.cola = new Lista();
        this.encontrados = new Lista();
        this.visitados = new Lista();
    }

    /**
     * @return the cola
     */
    public Lista getCola() {
        return cola;
    }

    /**
     * @param cola the cola to set
     */
    public void setCola(Lista cola) {
        this.cola = cola;
    }

    /**
     * @return the encontrados
     */
    public Lista getEncontrados() {
        return encontrados;
    }

    /**
     * @param encontrados the encontrados to set
     */
    public void setEncontrados(Lista encontrados) {
        this.encontrados = encontrados;
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
     *
     * @param nuevo
     */
    public void encolar(Nodo nuevo) {
        nuevo.setpNext(null);

        if (getCola().getpFirst() == null) {
            getCola().setpFirst(nuevo);
        } else {
            getCola().getpLast().setpNext(nuevo);
        }
        getCola().setpLast(nuevo);
        getCola().setSize(getCola().getSize() + 1);
    }

    /**
     *
     */
    public void desencolar() {
        Nodo temp = getCola().getpFirst();
        getCola().setpFirst(temp.getpNext());
        getCola().setSize(getCola().getSize() - 1);

        if (getCola().getpFirst() == null) {
            getCola().setpLast(null);
        }
    }

    /**
     *
     * @return
     */
    public boolean es_vacio() {
        return getCola().getpFirst() == null;
    }

    /**
     * @param origen
     * @param t
     * @param objetivo
     * @return
     */
    public Lista buscar_adyacentes(Nodo origen, int t, Nodo objetivo) {
        encolar(origen);

        if (!getCola().es_vacio()) {
            if (origen.getInfo().getName().equals(objetivo.getInfo().getName())) {
                for (int i = 1; i <= t; i++) {
                    if (origen.getpNext() != null){
                        getEncontrados().insertar_final(origen.getpNext());
                        origen = origen.getpNext();
                    }
                }
            } else {
                setLimite(getLimite() + 1);
                if (getVisitados().encontrar(origen.getInfo().getName())) {
                    if (origen.getpNext() != null) {
                        origen = origen.getpNext();
                    } else {
                        origen = origen.getInfo().getAdyacentes().getpFirst();
                    }

                    if (origen != null) {
                        buscar_adyacentes(origen, t, objetivo);
                        getVisitados().insertar_final(origen);
                        getCola().eliminar(origen);
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

        encolar(first);
        int count = 0;

        if (first.getInfo().isSucursal() == true) {
            count++;
            getVisitados().insertar_final(first);
        }

        if (getVisitados().encontrar(first.getInfo().getName()) == true) {
            if (first.getpNext() == null) {
                first = first.getInfo().getAdyacentes().getpFirst();
            } else {
                first = first.getpNext();
            }

            if (first != null) {
                obtener_cobertura(first);
                getVisitados().insertar_final(first);
                getEncontrados().eliminar(first);
            }
        } else {
            getEncontrados().insertar_final(first);
        }

        return getEncontrados();
    }

    
}
