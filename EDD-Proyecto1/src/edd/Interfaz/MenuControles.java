/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package edd.Interfaz;
import EstructurasDeDatos.Busquedas;
import EstructurasDeDatos.Grafo;
import EstructurasDeDatos.Lista;
import EstructurasDeDatos.LecturaJson;
import org.graphstream.graph.*;
import java.io.IOException;
import javax.swing.JOptionPane;
/**
 *
 * @author Luigi Lauricella
 */
public class MenuControles extends javax.swing.JFrame {
    private GraphStream graphstream;
    public Grafo grafo;
    public Lista lista;
    public int t;
    
    /**
     * Creates new form MenuControles
     */
    public MenuControles() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        JSONButton = new javax.swing.JButton();
        JSONLabel = new javax.swing.JLabel();
        GrafoLabel = new javax.swing.JLabel();
        GrafoButton = new javax.swing.JButton();
        tButton = new javax.swing.JButton();
        tField = new javax.swing.JTextField();
        tLabel = new javax.swing.JLabel();
        MenuLabel = new javax.swing.JLabel();
        SucursalField = new javax.swing.JTextField();
        SucursalLabel = new javax.swing.JLabel();
        SucursalButton = new javax.swing.JButton();
        CoberturaLabel = new javax.swing.JLabel();
        DFSButton = new javax.swing.JButton();
        BFSButton = new javax.swing.JButton();
        LineaButton = new javax.swing.JButton();
        LineaLabel = new javax.swing.JLabel();
        CoberturaField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        ResultadosBusquedaArea = new javax.swing.JTextArea();
        ResultadosBusquedaLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        CoberturaArea = new javax.swing.JTextArea();
        CoverturaLabel = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menú de Controles");
        setBackground(new java.awt.Color(255, 255, 255));

        JSONButton.setText("Cargar");
        JSONButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JSONButtonActionPerformed(evt);
            }
        });

        JSONLabel.setText("Cargar JSON");

        GrafoLabel.setText("Mostrar Grafo");

        GrafoButton.setText("Mostrar");
        GrafoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GrafoButtonActionPerformed(evt);
            }
        });

        tButton.setText("Cambiar");
        tButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tButtonActionPerformed(evt);
            }
        });

        tField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tFieldActionPerformed(evt);
            }
        });

        tLabel.setText("Establecer T");

        MenuLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        MenuLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MenuLabel.setText("Menú de Controles");

        SucursalField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SucursalFieldActionPerformed(evt);
            }
        });

        SucursalLabel.setText("Colocar o eliminar sucursal por nombre");

        SucursalButton.setText("Cambiar");
        SucursalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SucursalButtonActionPerformed(evt);
            }
        });

        CoberturaLabel.setText("Seleccionar sucursal para búsqueda");

        DFSButton.setText("DFS");
        DFSButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DFSButtonActionPerformed(evt);
            }
        });

        BFSButton.setText("BFS");
        BFSButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BFSButtonActionPerformed(evt);
            }
        });

        LineaButton.setText("Agregar");

        LineaLabel.setText("Agregar linea de paradas");

        ResultadosBusquedaArea.setColumns(20);
        ResultadosBusquedaArea.setRows(5);
        jScrollPane1.setViewportView(ResultadosBusquedaArea);

        ResultadosBusquedaLabel.setText("Resultados de la búsqueda");

        CoberturaArea.setColumns(20);
        CoberturaArea.setRows(5);
        jScrollPane2.setViewportView(CoberturaArea);

        CoverturaLabel.setText("Sucursales recomendados para obtener la covertura total");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(98, 647, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(LineaButton)
                        .addGap(26, 26, 26))
                    .addComponent(LineaLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(108, 108, 108))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(CoberturaField, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(DFSButton)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(BFSButton))
                                .addComponent(CoberturaLabel))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JSONLabel)
                            .addComponent(JSONButton))))
                .addGap(81, 81, 81)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tField, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(tButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                        .addComponent(SucursalField, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(SucursalButton)
                        .addGap(45, 45, 45))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(GrafoLabel)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(GrafoButton)
                                    .addComponent(tLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(SucursalLabel)
                                .addGap(72, 72, 72))))))
            .addGroup(layout.createSequentialGroup()
                .addGap(328, 328, 328)
                .addComponent(MenuLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(ResultadosBusquedaLabel)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(CoverturaLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(222, 222, 222)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)))
                .addGap(45, 45, 45))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MenuLabel)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JSONLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JSONButton))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(LineaLabel)
                                    .addComponent(GrafoLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(LineaButton)
                                    .addComponent(GrafoButton)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CoberturaLabel)
                            .addComponent(tLabel)
                            .addComponent(SucursalLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tButton)
                            .addComponent(SucursalField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SucursalButton)
                            .addComponent(CoberturaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DFSButton)
                    .addComponent(BFSButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CoverturaLabel)
                    .addComponent(ResultadosBusquedaLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GrafoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GrafoButtonActionPerformed

        if (grafo != null) {
            GraphStream grafo1= new GraphStream(grafo);
            grafo1.show();
        } else {
            JOptionPane.showMessageDialog(null, "ERROR, no cargaste un JSON antes.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_GrafoButtonActionPerformed

    private void tFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tFieldActionPerformed
        
    }//GEN-LAST:event_tFieldActionPerformed

    private void SucursalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SucursalButtonActionPerformed
        if (grafo != null) {
            var red = graphstream.getGraphstream();
            String SucursalNombre = SucursalField.getText();
            if (grafo.SelecionarParada(SucursalNombre) != null) {
                Node node = red.getNode(SucursalNombre);
                if (grafo.SelecionarParada(SucursalNombre).getInfo().isSucursal() == false) {
                    node.setAttribute("ui.style", "fill-color: red;");
                    grafo.SelecionarParada(SucursalNombre).getInfo().setSucursal(true);
                    JOptionPane.showMessageDialog(null, "La sucursal ha sido colocada exitosamente!", "Información", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    node.setAttribute("ui.style", "fill-color: grey;");
                    grafo.SelecionarParada(SucursalNombre).getInfo().setSucursal(false);
                    JOptionPane.showMessageDialog(null, "La sucursal ha sido eliminada exitosamente!", "Información", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "ERROR, la parada seleccionada es invalida.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "ERROR, no cargaste un JSON antes.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_SucursalButtonActionPerformed

    private void JSONButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JSONButtonActionPerformed
        try {
            grafo = new LecturaJson().LecturaJson();
        } catch(IOException e) {
            JOptionPane.showMessageDialog(null, "ERROR, tipo de dato invalido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_JSONButtonActionPerformed

    private void tButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tButtonActionPerformed
        if (grafo != null) {
            try {
                int t = Integer.parseInt(tField.getText());
                grafo.setT(t);
                JOptionPane.showMessageDialog(null, "T ha sido cambiado a " + t + " exitosamente!", "Información", JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "ERROR, coloca un número entero.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "ERROR, no cargaste un JSON antes.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_tButtonActionPerformed

    private void DFSButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DFSButtonActionPerformed
        ResultadosBusquedaArea.removeAll();
        if (grafo != null) {
            String SucursalNombre = SucursalField.getText();
            var NodoSeleccionado = grafo.SelecionarParada(SucursalNombre);
            System.out.println(NodoSeleccionado.getInfo().getName());
            if (NodoSeleccionado != null) {
                Lista resultados = Busquedas.DFS(NodoSeleccionado, t);                
                ResultadosBusquedaArea.append(resultados.printList());
            } else {
                JOptionPane.showMessageDialog(null, "ERROR, la parada seleccionada es invalida.", "Error", JOptionPane.ERROR_MESSAGE);
            }    
        } else {
            JOptionPane.showMessageDialog(null, "ERROR, no cargaste un JSON antes.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_DFSButtonActionPerformed

    private void BFSButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BFSButtonActionPerformed
        ResultadosBusquedaArea.removeAll();
        if (grafo != null) {
            String SucursalNombre = SucursalField.getText();
            var NodoSeleccionado = grafo.SelecionarParada(SucursalNombre);
            if (NodoSeleccionado != null) {
                Lista resultados = Busquedas.BFS(NodoSeleccionado, t);                
                ResultadosBusquedaArea.append(resultados.printList());
            } else {
                JOptionPane.showMessageDialog(null, "ERROR, la parada seleccionada es invalida.", "Error", JOptionPane.ERROR_MESSAGE);
            }    
        } else {
            JOptionPane.showMessageDialog(null, "ERROR, no cargaste un JSON antes.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BFSButtonActionPerformed

    private void SucursalFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SucursalFieldActionPerformed

    }//GEN-LAST:event_SucursalFieldActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuControles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuControles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuControles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuControles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuControles().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BFSButton;
    private javax.swing.JTextArea CoberturaArea;
    private javax.swing.JTextField CoberturaField;
    private javax.swing.JLabel CoberturaLabel;
    private javax.swing.JLabel CoverturaLabel;
    private javax.swing.JButton DFSButton;
    private javax.swing.JButton GrafoButton;
    private javax.swing.JLabel GrafoLabel;
    private javax.swing.JButton JSONButton;
    private javax.swing.JLabel JSONLabel;
    private javax.swing.JButton LineaButton;
    private javax.swing.JLabel LineaLabel;
    private javax.swing.JLabel MenuLabel;
    private javax.swing.JTextArea ResultadosBusquedaArea;
    private javax.swing.JLabel ResultadosBusquedaLabel;
    private javax.swing.JButton SucursalButton;
    private javax.swing.JTextField SucursalField;
    private javax.swing.JLabel SucursalLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton tButton;
    private javax.swing.JTextField tField;
    private javax.swing.JLabel tLabel;
    // End of variables declaration//GEN-END:variables
}
