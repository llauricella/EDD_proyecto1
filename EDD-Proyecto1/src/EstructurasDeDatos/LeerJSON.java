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

/**
 *
 * @author lalau
 */
public class LeerJSON {
    public LeerJSON () throws IOException {
        var chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        var file = chooser.getSelectedFile();
        Lista listaPrimeros = new Lista ();
        
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
                            JsonElement estacionesElement = lineaEntry.getValue();

                            if (estacionesElement.isJsonArray()) {
                                JsonArray estaciones = estacionesElement.getAsJsonArray();

                                Parada ultimaParadaVisitada = null;
                                for (JsonElement estacionElement : estaciones) {
                                    if (estacionElement.isJsonPrimitive()) {
                                        if (estacionElement.getAsJsonPrimitive().isString()) {
                                            String nombreDeEstacion = estacionElement.getAsString();
                                            if (ultimaParadaVisitada == null) {
                                                ultimaParadaVisitada = new Parada(nombreDeEstacion);
                                                Nodo primeraParada = new Nodo(ultimaParadaVisitada);
                                                listaPrimeros.insertar_final(primeraParada);
                                            } else {
                                                Parada nuevaParada = new Parada(nombreDeEstacion);
                                                Nodo paradaAdyacente1 = new Nodo (ultimaParadaVisitada);
                                                Nodo paradaAdyacente2 = new Nodo (nuevaParada);
                                                nuevaParada.getAdyacentes().insertar_final(paradaAdyacente1);
                                                ultimaParadaVisitada.getAdyacentes().insertar_final(paradaAdyacente2);

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
                                                    Parada nuevaParada = new Parada(nombreEstacion1);
                                                    Parada nuevaParada2 = new Parada(nombreEstacion2);
                                                    Nodo Adyacente1 = new Nodo (nuevaParada);
                                                    Nodo Adyacente3 = new Nodo (nuevaParada2);
                                                    nuevaParada.getAdyacentes().insertar_final(Adyacente3);
                                                    nuevaParada2.getAdyacentes().insertar_final(Adyacente1);
                                                if (ultimaParadaVisitada !=null) {
                                                    Nodo Adyacente2 = new Nodo (ultimaParadaVisitada);
                                                    nuevaParada.getAdyacentes().insertar_final(Adyacente2);
                                                    ultimaParadaVisitada.getAdyacentes().insertar_final(Adyacente1);
                                                } ultimaParadaVisitada = nuevaParada;
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
        // returns null;
        }
    }
}