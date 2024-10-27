/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package edd.Interfaz;

import EstructurasDeDatos.Grafo;
import EstructurasDeDatos.Nodo;
import EstructurasDeDatos.Parada;
import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.*;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import org.graphstream.ui.view.*;
import org.graphstream.ui.swing_viewer.SwingViewer;

/**
 * @version 27/10/2024
 * @author Luigi Lauricella
 */
public class GraphStream extends JFrame implements ViewerListener {

    private Graph graphstream;
    private Grafo grafo;
    private boolean loop = true;

    public GraphStream(Grafo grafo) {
        this.grafo = grafo;
        initComponents();
        initGraph();
        run();
    }

    private void initGraph() {
        setGraphstream(new SingleGraph("Tutorial 1"));
        String[] nombresUnicos = new String[getGrafo().getNodos().count()];
        int nombreIndex = 0;

        String[] aristasUnicas = new String[getGrafo().getNodos().count() * getGrafo().getNodos().count()];
        int aristaIndex = 0;

        for (int i = 0; i < getGrafo().getNodos().count(); i++) {
            Nodo aux = (Nodo) getGrafo().getNodos().get(i);
            String nombreNodo = aux.getInfo().getName();

            boolean nodoExistente = false;
            for (int j = 0; j < nombreIndex; j++) {
                if (nombresUnicos[j].equals(nombreNodo)) {
                    nodoExistente = true;
                    break;
                }
            }

            if (!nodoExistente) {
                getGraphstream().addNode(nombreNodo);
                nombresUnicos[nombreIndex++] = nombreNodo;
            }
        }

        for (int i = 0; i < getGrafo().getNodos().count(); i++) {
            Nodo aux = (Nodo) getGrafo().getNodos().get(i);
            String nombreNodo = aux.getInfo().getName();

            if (aux.getParent() != null) {
                String nombrePadre = aux.getParent().getInfo().getName();

                String idArista = nombreNodo.compareTo(nombrePadre) < 0
                        ? nombreNodo + ":" + nombrePadre
                        : nombrePadre + ":" + nombreNodo;

                boolean aristaExistente = false;
                for (int j = 0; j < aristaIndex; j++) {
                    if (aristasUnicas[j].equals(idArista)) {
                        aristaExistente = true;
                        break;
                    }
                }

                if (!aristaExistente) {
                    getGraphstream().addEdge(idArista, nombreNodo, nombrePadre, false);
                    aristasUnicas[aristaIndex++] = idArista;
                }
            }
        }

        for (Node node : getGraphstream()) {
            node.setAttribute("ui.label", node.getId());
        }

        getGraphstream().setAttribute("ui.stylesheet", "node { fill-color: grey; }");
    }

    private void run() {
        var viewer = new SwingViewer(getGraphstream(), Viewer.ThreadingModel.GRAPH_IN_ANOTHER_THREAD);
        viewer.enableAutoLayout();

        View view = viewer.addDefaultView(false);
        GraphStreamPanel.setLayout(new BorderLayout());
        GraphStreamPanel.add((Component) view, BorderLayout.CENTER);

        setVisible(true);
    }

    @Override
    public void viewClosed(String id) {
        loop = false;
    }

    @Override
    public void buttonPushed(String id) {
    }

    @Override
    public void buttonReleased(String id) {
    }

    @Override
    public void mouseOver(String id) {
    }

    @Override
    public void mouseLeft(String id) {
    }

    /**
     * Procedimiento encargado de enlazar una secuencia de paradas
     *
     * @param nuevaLinea es una secuencia de paradas introducida por el usuario
     */
    public void agregarLinea(String[] nuevaLinea) {
        String name = "";
        for (int z = 0; z < grafo.getNodos().count(); z++) {
            Nodo n = (Nodo) grafo.getNodos().get(z);
            if (n.getInfo().getName().equalsIgnoreCase(nuevaLinea[0])) {
                name = nuevaLinea[0];
            }
        }
        if (!"".equals(name)) {
            for (int i = 1; i < nuevaLinea.length; i++) {
                Parada x = new Parada(nuevaLinea[i - 1], false);
                Parada y = new Parada(nuevaLinea[i], false);
                try {
                    grafo.addNode(y);
                    graphstream.addNode(y.getName());
                    Node nodo = graphstream.getNode(y.getName());
                    nodo.setAttribute("ui.label", y.getName());
                    grafo.addEdge(x, y);
                    graphstream.addEdge(x.getName() + ":" + y.getName(), x.getName(), y.getName());
                    Edge edge = graphstream.getEdge(x.getName() + ":" + y.getName());
                    edge.setAttribute("ui.style", "fill-color: yellow;");
                    
                } catch(IdAlreadyInUseException e) {
                    JOptionPane.showMessageDialog(null, "ERROR, una de las paradas ya existe", "Error", JOptionPane.ERROR_MESSAGE);
                }

            }
        } else {
            JOptionPane.showMessageDialog(null, "ERROR, la primera parada tiene que existir previamente.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GraphStreamPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GraphStream");

        javax.swing.GroupLayout GraphStreamPanelLayout = new javax.swing.GroupLayout(GraphStreamPanel);
        GraphStreamPanel.setLayout(GraphStreamPanelLayout);
        GraphStreamPanelLayout.setHorizontalGroup(
            GraphStreamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 981, Short.MAX_VALUE)
        );
        GraphStreamPanelLayout.setVerticalGroup(
            GraphStreamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 793, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(GraphStreamPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(GraphStreamPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public void main(String args[]) {
        /* Set the Nimbus look and feel */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GraphStream.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new GraphStream(getGrafo()).setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel GraphStreamPanel;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the graphstream
     */
    public Graph getGraphstream() {
        return graphstream;
    }

    /**
     * @param graphstream the graphstream to set
     */
    public void setGraphstream(Graph graphstream) {
        this.graphstream = graphstream;
    }

    /**
     * @return the grafo
     */
    public Grafo getGrafo() {
        return grafo;
    }

    /**
     * @param grafo the grafo to set
     */
    public void setGrafo(Grafo grafo) {
        this.grafo = grafo;
    }

}
