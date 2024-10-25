/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package edd.Interfaz;
import EstructurasDeDatos.Grafo;
import EstructurasDeDatos.Lista;
import EstructurasDeDatos.Nodo;
import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.*;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import org.graphstream.ui.view.*;
import org.graphstream.ui.swing_viewer.SwingViewer;
import java.util.HashSet;
import java.util.Set;
/**
 * @version 23/10/2024
 * @author Luigi Lauricella
 */
public class GraphStream extends JFrame implements ViewerListener {
    private Graph graphstream;
    private Grafo grafo;

    public Grafo getGrafo() {
        return grafo;
    }

    public void setGrafo(Grafo grafo) {
        this.grafo = grafo;
    }
    private boolean loop = true;

    public GraphStream(Grafo grafo) {
        this.grafo = grafo;
        initComponents();
        initGraph(); // Inicializa el grafo
        run(); // Inicia el visualizador
    }

    // Método para inicializar el grafo
    private void initGraph() {
        graphstream = new SingleGraph("Tutorial 1");
        Set<String> nombresUnicos = new HashSet<>();
        Set<String> aristasUnicas = new HashSet<>();

        // Primero, agregar todos los nodos únicos
        for (int i = 0; i < getGrafo().getNodos().count(); i++) {
            Nodo aux = (Nodo) getGrafo().getNodos().get(i);
            String nombreNodo = aux.getInfo().getName();
    
        // Agregar nodo solo si su nombre no está en nombresUnicos
        if (!nombresUnicos.contains(nombreNodo)) {
            graphstream.addNode(nombreNodo);
            nombresUnicos.add(nombreNodo);
            }   
        }

        // Después, agregar todas las aristas únicas
        for (int i = 0; i < getGrafo().getNodos().count(); i++) {
            Nodo aux = (Nodo) getGrafo().getNodos().get(i);
            String nombreNodo = aux.getInfo().getName();

            // Agregar arista si el nodo tiene padre y la arista no está en aristasUnicas
            if (aux.getParent() != null) {
            String nombrePadre = aux.getParent().getInfo().getName();
        
            // Crear un identificador único sin importar la dirección
            String idArista = nombreNodo.compareTo(nombrePadre) < 0
                          ? nombreNodo + ":" + nombrePadre
                          : nombrePadre + ":" + nombreNodo;

            // Verificar si la arista ya fue añadida
            if (!aristasUnicas.contains(idArista)) {
                graphstream.addEdge(idArista, nombreNodo, nombrePadre, true);  // Último parámetro para arista no orientada
                    aristasUnicas.add(idArista);
                }
            }
        }

        // Añadir etiquetas para mejor visibilidad
        for (Node node : graphstream) {
            node.setAttribute("ui.label", node.getId());
        }

        // Estilo predeterminado para los nodos
        graphstream.setAttribute("ui.stylesheet", "node { fill-color: grey; }");
    }

    // Método para iniciar el bucle del visualizador
    private void run() {
        // Crear un visualizador para el grafo
        var viewer = new SwingViewer(graphstream, Viewer.ThreadingModel.GRAPH_IN_ANOTHER_THREAD);
        viewer.enableAutoLayout();

        // Añadir el panel del visualizador a jPanel1
        View view = viewer.addDefaultView(false); // Sin vista por defecto
        GraphStreamPanel.setLayout(new BorderLayout());
        GraphStreamPanel.add((Component)view, BorderLayout.CENTER); // Añadir view al jPanel1

        setVisible(true); // Hacer visible el JFrame
    }

    @Override
    public void viewClosed(String id) {
        loop = false;
    }

    @Override
    public void buttonPushed(String id) {}

    @Override
    public void buttonReleased(String id) {}
    
    @Override
    public void mouseOver(String id) {}

    @Override
    public void mouseLeft(String id) {}

    // Método para alternar el color del nodo clicado entre gris y rojo
    private void toggleNodeColor(String nodeName) {
        Node node = graphstream.getNode(nodeName);
        if (node != null) {
            String currentStyle = String.valueOf(node.getAttribute("ui.style"));
            if (currentStyle.contains("red")) {
                node.setAttribute("ui.style", "fill-color: grey;");
                System.out.println("Node " + nodeName + " color changed to grey.");
            } else {
                node.setAttribute("ui.style", "fill-color: red;");
                System.out.println("Node " + nodeName + " color changed to red.");
            }
        } else {
            System.out.println("Node " + nodeName + " does not exist.");
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
            .addGap(0, 627, Short.MAX_VALUE)
        );
        GraphStreamPanelLayout.setVerticalGroup(
            GraphStreamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 472, Short.MAX_VALUE)
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
        java.awt.EventQueue.invokeLater(() -> new GraphStream(grafo).setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel GraphStreamPanel;
    // End of variables declaration//GEN-END:variables


}