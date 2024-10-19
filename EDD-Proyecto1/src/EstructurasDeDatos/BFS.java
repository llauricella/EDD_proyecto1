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
            getCola().setpLast(nuevo);
        } else {
            getCola().getpLast().setpNext(nuevo);
        }
        getCola().setSize(getCola().getSize() + 1);
    }

    /**
     *
     */
    public void desencolar() {

        if (!getCola().es_vacio()) {
            Nodo temp = getCola().getpFirst();
            getCola().setpFirst(temp.getpNext());
            getCola().setSize(getCola().getSize() - 1);

            if (getCola().getpFirst() == null) {
                getCola().setpLast(null);
            }
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

        if (getCola().encontrar(origen.getInfo().getName()) == false) {
            encolar(origen);
            getVisitados().insertar_final(origen);
        }

        if (origen != null) {
            if (!getCola().es_vacio()) {
                Nodo actual = getCola().getpFirst();
                desencolar();

                if (actual.getInfo().getName().equals(objetivo.getInfo().getName())) {
                    for (int i = 1; i <= t; i++) {
                        if (actual.getpNext() != null) {
                            actual = actual.getpNext();
                        } else {
                            if (!actual.getInfo().getAdyacentes().es_vacio()){
                                actual = actual.getInfo().getAdyacentes().getpFirst();
                            }
                        }

                        getEncontrados().insertar_final(actual);

                    }
                } else {
                    setLimite(getLimite() + 1);
                    if (!actual.getInfo().getAdyacentes().es_vacio()) {
                        for (Nodo i = actual.getInfo().getAdyacentes().getpFirst(); i != null; i = i.getpNext()) {
                            if (getVisitados().encontrar(i.getInfo().getName()) == false) {
                                getVisitados().insertar_final(i);
                                encolar(i);
                            }
                        }

                        actual = getCola().getpFirst();
                        if (!getCola().es_vacio()) {
                            buscar_adyacentes(actual, t, objetivo);
                        }
                    }
                }

                int count = getLimite();
                if (count != (getLimite() - t)) {
                    getEncontrados().insertar_final(origen);
                    count--;
                }
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
