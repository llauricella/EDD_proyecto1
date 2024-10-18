/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CargaDescarga;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;

/**
 *
 * @author santi
 */
public class LecturaJson {
    
    public static void main(String[] args) throws IOException {
        var chooser = new JFileChooser();
        chooser.showOpenDialog(null);

        var file = chooser.getSelectedFile();

        if (file != null) {
            //file.getName() // retornara nombre.json, verificar con caracas.json y bogota.json
            FileReader lector = new FileReader(file);

            JsonParser parser = new JsonParser();

            JsonElement raiz = parser.parse(lector);

            if (raiz.isJsonObject()) {
                JsonObject redObject = raiz.getAsJsonObject();
                var redEntrySet = redObject.entrySet();

                if (redEntrySet.size() != 1) {
                    // retornar error
                }

                var redEntry = redEntrySet.iterator().next();

                var nombreDeRed = redEntry.getKey();

                JsonElement lineasElementos = redEntry.getValue();
                if (lineasElementos.isJsonArray()) {
                    JsonArray lineas = lineasElementos.getAsJsonArray();

                    for (JsonElement lineaElemento : lineas) {
                        if (lineaElemento.isJsonObject()) {
                            var lineaObjeto = lineaElemento.getAsJsonObject();
                            var lineasEntrySet = lineaObjeto.entrySet();
                            if (lineasEntrySet.size() != 1) {
                                // retornar error
                            }
                            var lineaEntry = lineasEntrySet.iterator().next();
                            String nombreDeLinea = lineaEntry.getKey();

                            JsonElement estacionesElement = lineaEntry.getValue();

                            if (estacionesElement.isJsonArray()) {
                                JsonArray estaciones = estacionesElement.getAsJsonArray();

                                Parada ultimaParadaVisitada = null;
                                for (JsonElement estacionElement : estaciones) {
                                    if (estacionElement.isJsonPrimitive()) {
                                        if (estacionElement.getAsJsonPrimitive().isString()) {
                                            String nombreDeEstacion = estacionElement.getAsString();
                                            if (ultimaParadaVisitada == null) {
                                                ultimaParadaVisitada = new Parada(false, new ArrayList<Parada>(), nombreDeLinea, nombreDeEstacion);

                                                // Iterar por los nodos dentro del grafo
                                                // buscar una parada con el mismo nombre y que la linea este vacia
                                                // en este caso se encontro una parada de un transferiancia y
                                                // hay que colocarle el nombe de la linea
                                                // ultimaParadaVisitada.setNombreDeLinea(nombreDeLinea)
                                                // agregar al grafo si no existia dentro del mismo
                                            } else {
                                                // Iterar por los nodos dentro del grafo
                                                // buscar una parada con el mismo nombre y que la linea este vacia
                                                // en este caso se encontro una parada de un transferiancia y
                                                // hay que colocarle el nombe de la linea
                                                // ultimaParadaVisitada.setNombreDeLinea(nombreDeLinea)

                                                // agregar al grafo si no existia dentro del mismo
                                                Parada nuevaParada = new Parada(false, new ArrayList<Parada>(), nombreDeLinea, nombreDeEstacion);
                                                nuevaParada.adyacentes.add(ultimaParadaVisitada);
                                                ultimaParadaVisitada.adyacentes.add(nuevaParada);

                                                ultimaParadaVisitada = nuevaParada;
                                            }
                                            System.err.println(nombreDeEstacion);
                                        } else {
                                            // retornar error tipo de dato
                                        }
                                    } else if (estacionElement.isJsonObject()) {
                                        var estacionEntrySet = estacionElement.getAsJsonObject().entrySet();
                                        if (estacionEntrySet.size() != 1) {
                                            // retornar error
                                        }
                                        var transferenciaEntry = estacionEntrySet.iterator().next();
                                        var nombreEstacion1 = transferenciaEntry.getKey();
                                        if (transferenciaEntry.getValue().isJsonPrimitive()) {
                                            if (transferenciaEntry.getValue().getAsJsonPrimitive().isString()) {
                                                var nombreEstacion2 = transferenciaEntry.getValue().getAsString();

                                                // transferencia valida agregarla
                                                Parada nuevaParada = new Parada(false, new ArrayList<Parada>(), nombreDeLinea, nombreEstacion1);
                                                nuevaParada.adyacentes.add(ultimaParadaVisitada);
                                                ultimaParadaVisitada.adyacentes.add(nuevaParada);

                                                Parada nuevaParada2 = new Parada(false, new ArrayList<Parada>(), "", nombreEstacion2);
                                                nuevaParada.adyacentes.add(nuevaParada2);

                                                ultimaParadaVisitada = nuevaParada;

                                                // Agregar al grafo las dos paradas
                                                // validar que no exista dentro del grafo una estacion con el mismo nombre;
                                            } else {
                                                // se espera un string
                                            }
                                        } else {
                                            // retornar error tipo de dato
                                        }
                                    } else {
                                        // error no se esepra ese tipo de lo que sea
                                    }
                                }
                            } else {
                                // error se esepra un array
                            }
                        } else {
                            // error se espera que la linea sea un objeto
                        }
                    }
                } else {
                    // error se espera un array
                }
            } else {
                // error se espera un objeto json
            }
        }
    }
}
