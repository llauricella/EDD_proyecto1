/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package edd.proyecto1;
// Imports
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import org.graphstream.ui.view.Viewer;
import org.graphstream.ui.view.ViewerListener;
import org.graphstream.ui.view.ViewerPipe;

/**
 *
 * @author Luigi Lauricella
 */

public class EDDProyecto1 implements ViewerListener {
    protected boolean loop = true;
    private Graph graph;
    private Viewer viewer; // Objecto Viewer

    public static void main(String args[]) {
        System.setProperty("org.graphstream.ui", "swing");

        EDDProyecto1 proyecto = new EDDProyecto1();
        proyecto.initGraph();
        proyecto.run();
    }

    // Initialize the graph
    public void initGraph() {
        graph = new SingleGraph("Tutorial 1");

        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        // addEdge(Nombre del edge, nombre primer nodo, nombre segundo nodo)
        graph.addEdge("AB", "A", "B");
        graph.addEdge("BC", "B", "C");
        graph.addEdge("CA", "C", "A");

        // Nombrando los nodos
        for (Node node : graph) {
            node.setAttribute("ui.label", node.getId());
        }

        // Color de nodo default
        graph.setAttribute("ui.stylesheet", "node { fill-color: grey; }");

        // Mostrar gráfico y guardar viewer
        viewer = graph.display();
    }

    // Ciclo while para deceteción de clicks
    public void run() {
        viewer.setCloseFramePolicy(Viewer.CloseFramePolicy.EXIT);

        // Evento si hay click
        ViewerPipe fromViewer = viewer.newViewerPipe();
        fromViewer.addViewerListener(this);
        fromViewer.addSink(graph);

        while (loop) {
            fromViewer.pump(); // Procesamiento de datos
        }
    }

    @Override
    public void viewClosed(String id) {
        loop = false;
    }

    @Override
    public void buttonPushed(String id) {
        // Procedimiento si se hace click a un nodo
        toggleNodeColor(id); // Toggle the color of the clicked node
    }

    // Metodos requeridos por el sistema ViewerListener
    @Override
    public void buttonReleased(String id) {
    }

    @Override
    public void mouseLeft(String id) {
    }

    @Override
    public void mouseOver(String id) {
    }

    // Procedimiento si el nodo es presionado (varia entre gris y rojo)
    private void toggleNodeColor(String nodeId) {
        Node node = graph.getNode(nodeId);
        if (node != null) {
            // Color actual del nodo
            String currentStyle = String.valueOf(node.getAttribute("ui.style"));

            // Si es rojo cambia a gris y viceversa
            if (currentStyle.contains("red")) {
                node.setAttribute("ui.style", "fill-color: grey;");
            } else {
                node.setAttribute("ui.style", "fill-color: red;");
            }
        } else {
            System.out.println("Nodo " + nodeId + " no existe.");
        }
    }
}