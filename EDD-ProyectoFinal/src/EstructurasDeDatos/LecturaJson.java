/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructurasDeDatos;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * Esta clase contiene la funcion que carga del archivo json con la red de transporte del grafo
 * 
 * @version 27/10/2024
 * @author Santiago Castro
 */
public class LecturaJson {
    public Grafo grafo;
    private int t;
     
    /**
     * Funcion encargada de la carga del archivo Json.
     * El usuario elije un archivo Json para cargar y la
     * funcion lee todo el archivo para convertirlo en 
     * un objeto de tipo grafo
     * 
     * @return Grafo guardado con los datos del archivo Json
     * @throws java.io.IOException
     */
    public Grafo LecturaJson() throws IOException {
        var chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        var file = chooser.getSelectedFile();
        Lista listaPrimeros = new Lista();
        setT(0);
        if ("Caracas.json".equals(file.getName())) {
            setT(3);
        } else if ("Bogota.json".equals(file.getName())) {
            setT(10);
        }
        grafo = new Grafo(getT());
        try {
            if (file != null) {

                FileReader lector = new FileReader(file);

                JsonParser parser = new JsonParser();

                JsonElement raiz = parser.parse(lector);

                if (raiz.isJsonObject()) {
                    JsonObject redObject = raiz.getAsJsonObject();
                    var redEntrySet = redObject.entrySet();

                    if (redEntrySet.size() != 1) {
                        JOptionPane.showMessageDialog(null, "ERROR, No es un dato válido", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                    var redEntry = redEntrySet.iterator().next();
                    JsonElement lineasElementos = redEntry.getValue();
                    if (lineasElementos.isJsonArray()) {
                        JsonArray lineas = lineasElementos.getAsJsonArray();

                        for (JsonElement lineaElemento : lineas) {
                            if (lineaElemento.isJsonObject()) {
                                var lineaObjeto = lineaElemento.getAsJsonObject();
                                var lineasEntrySet = lineaObjeto.entrySet();
                                if (lineasEntrySet.size() != 1) {
                                    JOptionPane.showMessageDialog(null, "ERROR, No es un dato válido", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                                var lineaEntry = lineasEntrySet.iterator().next();
                                JsonElement estacionesElement = lineaEntry.getValue();

                                if (estacionesElement.isJsonArray()) {
                                    JsonArray estaciones = estacionesElement.getAsJsonArray();

                                    Parada ultimaParadaVisitada = null;
                                    for (JsonElement estacionElement : estaciones) {
                                        if (estacionElement.isJsonPrimitive()) {
                                            if (estacionElement.getAsJsonPrimitive().isString()) {
                                                String nombreDeEstacion = estacionElement.getAsString();
                                                if (ultimaParadaVisitada == null) {
                                                    ultimaParadaVisitada = new Parada(nombreDeEstacion, false);
                                                    listaPrimeros.add(ultimaParadaVisitada);
                                                    Nodo Parada1 = new Nodo(ultimaParadaVisitada);
                                                    if (!grafo.getNodos().contains(Parada1)) {
                                                        grafo.addNode(ultimaParadaVisitada);
                                                    }
                                                } else {
                                                    Parada nuevaParada = new Parada(nombreDeEstacion, false);
                                                    Nodo Parada1 = new Nodo(nuevaParada);
                                                    if (!grafo.getNodos().contains(Parada1)) {
                                                        grafo.addNode(nuevaParada);
                                                        grafo.addEdge(ultimaParadaVisitada, nuevaParada);
                                                    }
                                                    ultimaParadaVisitada = nuevaParada;
                                                }
                                            } else {
                                                throw new Error("No es un dato válido");
                                            }
                                        } else if (estacionElement.isJsonObject()) {
                                            var estacionEntrySet = estacionElement.getAsJsonObject().entrySet();
                                            if (estacionEntrySet.size() != 1) {
                                                throw new Error("No es un dato válido");
                                            }
                                            var transferenciaEntry = estacionEntrySet.iterator().next();
                                            var nombreEstacion1 = transferenciaEntry.getKey();
                                            if (transferenciaEntry.getValue().isJsonPrimitive()) {
                                                if (transferenciaEntry.getValue().getAsJsonPrimitive().isString()) {
                                                    var nombreEstacion2 = transferenciaEntry.getValue().getAsString();
                                                    Parada nuevaParada = new Parada(nombreEstacion1, false);
                                                    Parada nuevaParada2 = new Parada(nombreEstacion2, false);
                                                    if (!grafo.getNodos().contains(nuevaParada)) {
                                                        grafo.addNode(nuevaParada);
                                                        grafo.addEdge(nuevaParada2, nuevaParada);
                                                    }
                                                    if (ultimaParadaVisitada != null) {
                                                        grafo.addEdge(ultimaParadaVisitada, nuevaParada);
                                                    }
                                                    ultimaParadaVisitada = nuevaParada;                                                   
                                                } else {
                                                    JOptionPane.showMessageDialog(null, "ERROR, No es un tipo de dato válido", "Error", JOptionPane.ERROR_MESSAGE);
                                                }
                                            } else {
                                                JOptionPane.showMessageDialog(null, "ERROR, No es un tipo de dato válido", "Error", JOptionPane.ERROR_MESSAGE);
                                            }
                                        } else {
                                            JOptionPane.showMessageDialog(null, "ERROR, No es un tipo de dato válido", "Error", JOptionPane.ERROR_MESSAGE);
                                        }
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "ERROR, No es un tipo de dato válido", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "ERROR, No es un tipo de dato válido", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "ERROR, No es un tipo de dato válido", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "ERROR, No es un tipo de dato válido", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR, No es un tipo de dato válido", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return grafo;

    }

    /**
     * Función que retorna el atributo t
     * 
     * @return El valor de t
     */
    public int getT() {
        return t;
    }

    /**
     * Procedimiento que cambia el valor de t
     * 
     * @param t El nuevo valor de t
     */
    public void setT(int t) {
        this.t = t;
    }
    

}
