package com.docusoft.presentacion;

import com.docusoft.entidad.Documento;
import com.docusoft.repositorio.CatalogoDeDocumentos;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class VentanaVerDocumento extends javax.swing.JDialog {

    /**
     * Creates new form VentanaVerDocumento
     */
    public VentanaVerDocumento(java.awt.Frame parent, String codigoDocumento) {
        super(parent, true);
        initComponents();
        mostrarDocumnento(codigoDocumento);
    }

    private void mostrarDocumnento(String codigoDocumento) {
        CatalogoDeDocumentos catalogoDeDocumentos = CatalogoDeDocumentos.obtenerInstancia();
        Documento documento = catalogoDeDocumentos.buscar(codigoDocumento);
        DefaultTableModel modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("Atributo");
        modeloTabla.addColumn("Valor");
        for(String[] atributoValor : documento.obtenerListaAtributoValor()) {
            modeloTabla.addRow(atributoValor);
        }
        tablaDocumento.setModel(modeloTabla);
        configurarTablaDocumento();
    }

    private void configurarTablaDocumento() {
        TableColumn columnaAtributo = tablaDocumento.getColumnModel().getColumn(0);
        columnaAtributo.setPreferredWidth(150);
        columnaAtributo.setMaxWidth(300);
        columnaAtributo.setMinWidth(100);
        TableColumn columnaValor = tablaDocumento.getColumnModel().getColumn(1);
        columnaValor.setPreferredWidth(500);
        columnaValor.setMaxWidth(800);
        columnaValor.setMinWidth(100);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDocumento = new javax.swing.JTable();
        botonSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Datos del Documento");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Datos del Documento");

        tablaDocumento.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(tablaDocumento);

        botonSalir.setText("Salir");
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(botonSalir)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 655, Short.MAX_VALUE)))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(botonSalir)
                .addGap(30, 30, 30))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_botonSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaDocumento;
    // End of variables declaration//GEN-END:variables
}
