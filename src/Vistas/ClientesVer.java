/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Controladores.OperacionesClientes;
import Modelos.Clientes;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Diego
 */
public class ClientesVer extends javax.swing.JFrame {
    
    OperacionesClientes operaciones = new OperacionesClientes();
    DefaultTableModel tabla = new DefaultTableModel();
    
    /**
     * Creates new form Almacen
     */
    public ClientesVer() {
        initComponents();
        cargarClientes();
        
        
    }

   public void cargarClientes(){
        
        List<Clientes> lista = operaciones.ListaClientes();
        
        tabla = (DefaultTableModel) jTableClientes.getModel();
        if(lista.size()>0){
            Iterator consulta = lista.iterator();
            while(consulta.hasNext()){
                Vector datos = new Vector();
                Clientes fila = (Clientes)consulta.next();
                datos.add(fila.getIdclientes());
                datos.add(fila.getNombre());
                datos.add(fila.getApellidos());
                datos.add(fila.getPoblacion());
                datos.add(fila.getIdentificacion());
                datos.add(fila.getTelefono());
                datos.add(fila.getTipoCliente());
                tabla.addRow(datos);
            }
        }
       
        
        jTableClientes.getColumnModel().getColumn(0).setMaxWidth(0);
        jTableClientes.getColumnModel().getColumn(0).setMinWidth(0);
        jTableClientes.getColumnModel().getColumn(0).setPreferredWidth(0);
        
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableClientes = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButtonBuscar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuInicio = new javax.swing.JMenu();
        jMenuAlmacen = new javax.swing.JMenu();
        jMenuItemProductos = new javax.swing.JMenuItem();
        jMenuItemCategorias = new javax.swing.JMenuItem();
        jMenuClientes = new javax.swing.JMenu();
        jMenuProveedores = new javax.swing.JMenu();
        jMenuFacturas = new javax.swing.JMenu();
        jMenuUsuarios = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Clientes");
        setResizable(false);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/añadir.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/IconoEliminar.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editar.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Filtrar por:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombre", "Identificacion", "Telefono", "Tipo de cliente" }));

        jTableClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Apellidos", "Población", "Identificación", "Teléfono", "Tipo de cliente"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTableClientes);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logoPequeño.png"))); // NOI18N

        jButtonBuscar.setText("Buscar");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        jMenuInicio.setText("Inicio");
        jMenuInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuInicioMouseClicked(evt);
            }
        });
        jMenuInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuInicioActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenuInicio);

        jMenuAlmacen.setText("Almacén");
        jMenuAlmacen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuAlmacenMouseClicked(evt);
            }
        });

        jMenuItemProductos.setText("Productos");
        jMenuItemProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItemProductosMouseClicked(evt);
            }
        });
        jMenuItemProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemProductosActionPerformed(evt);
            }
        });
        jMenuAlmacen.add(jMenuItemProductos);

        jMenuItemCategorias.setText("Categorias");
        jMenuItemCategorias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItemCategoriasMouseClicked(evt);
            }
        });
        jMenuItemCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCategoriasActionPerformed(evt);
            }
        });
        jMenuAlmacen.add(jMenuItemCategorias);

        jMenuBar1.add(jMenuAlmacen);

        jMenuClientes.setText("Clientes");
        jMenuClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuClientesMouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenuClientes);

        jMenuProveedores.setText("Proveedores");
        jMenuProveedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuProveedoresMouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenuProveedores);

        jMenuFacturas.setText("Facturas");
        jMenuBar1.add(jMenuFacturas);

        jMenuUsuarios.setText("Usuarios");
        jMenuUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuUsuariosMouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenuUsuarios);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane2)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(18, 18, 18)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButtonBuscar)
                            .addGap(215, 215, 215)
                            .addComponent(jButton3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton3)
                    .addComponent(jButton1)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonBuscar)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int fila;
        fila = (Integer)this.jTableClientes.getSelectedRow();
        int id = (Integer)this.jTableClientes.getValueAt(fila, 0);
        Clientes cliente = new Clientes();
        cliente.setIdclientes(id);
        operaciones.eliminaCliente(cliente);
        tabla.removeRow(fila);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int fila;
        fila = (Integer)this.jTableClientes.getSelectedRow();
        int id = (Integer)this.jTableClientes.getValueAt(fila, 0);
        Clientes clienteMod = new Clientes();
        clienteMod.setIdclientes(id);
        clienteMod = operaciones.seleccionaCliente(clienteMod);
        ClientesModificar clientesMod = new ClientesModificar();
        clientesMod.setVisible(true);
        clientesMod.jTextFieldNombre.setText(clienteMod.getNombre());
        clientesMod.jTextFieldApellidos.setText(clienteMod.getApellidos());
        clientesMod.jTextFieldIdentificacion.setText(clienteMod.getIdentificacion());
        clientesMod.jTextFieldDireccion.setText(clienteMod.getDireccion());
        clientesMod.jTextFieldPoblacion.setText(clienteMod.getPoblacion());
        clientesMod.jTextFieldCodPostal.setText(String.valueOf(clienteMod.getCodPostal()));
        clientesMod.jTextFieldTelefono.setText(String.valueOf(clienteMod.getTelefono()));
        clientesMod.jTextFieldEmail.setText(clienteMod.getEmail());
        clientesMod.jComboBoxTipo.setSelectedItem(clienteMod.getTipoCliente());
        clientesMod.id = id;
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        ClientesCrear cc = new ClientesCrear();
        cc.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jMenuInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuInicioMouseClicked
        // TODO add your handling code here:
        Principal principal = new Principal();
        principal.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuInicioMouseClicked

    private void jMenuInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuInicioActionPerformed
        // TODO add your handling code here
    }//GEN-LAST:event_jMenuInicioActionPerformed

    private void jMenuItemProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItemProductosMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jMenuItemProductosMouseClicked

    private void jMenuItemProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemProductosActionPerformed
        // TODO add your handling code here:
        ProductosVer prodV = new ProductosVer();
        prodV.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItemProductosActionPerformed

    private void jMenuItemCategoriasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItemCategoriasMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jMenuItemCategoriasMouseClicked

    private void jMenuItemCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCategoriasActionPerformed
        // TODO add your handling code here:
        CategoriasVer catV = new CategoriasVer();
        catV.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItemCategoriasActionPerformed

    private void jMenuAlmacenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuAlmacenMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jMenuAlmacenMouseClicked

    private void jMenuClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuClientesMouseClicked
        // TODO add your handling code here:
        ClientesVer cliVer = new ClientesVer();
        cliVer.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuClientesMouseClicked

    private void jMenuProveedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuProveedoresMouseClicked
        // TODO add your handling code here:
        ProveedoresVer proveedoresV = new ProveedoresVer();
        proveedoresV.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuProveedoresMouseClicked

    private void jMenuUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuUsuariosMouseClicked
        // TODO add your handling code here:
        UsuariosVer userV = new UsuariosVer();
        userV.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuUsuariosMouseClicked

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        // TODO add your handling code here:
        String buscar = jTextField1.getText();

        String campo = (String) jComboBox1.getSelectedItem();
        
        if(campo=="Tipo de cliente"){
            campo = "tipo_cliente";
             List<Clientes> lista = operaciones.ListaClientesBuscar(campo,buscar);
        
        tabla = (DefaultTableModel) jTableClientes.getModel();
        if(lista.size()>0){
            tabla.setRowCount(0);
            Iterator consulta = lista.iterator();
            while(consulta.hasNext()){
                Vector datos = new Vector();
                Clientes fila = (Clientes)consulta.next();
                datos.add(fila.getIdclientes());
                datos.add(fila.getNombre());
                datos.add(fila.getApellidos());
                datos.add(fila.getPoblacion());
                datos.add(fila.getIdentificacion());
                datos.add(fila.getTelefono());
                datos.add(fila.getTipoCliente());
                tabla.addRow(datos);
            }
        }else{
            JOptionPane.showMessageDialog(null, "El cliente no existe"); 
            }
       
        
        jTableClientes.getColumnModel().getColumn(0).setMaxWidth(0);
        jTableClientes.getColumnModel().getColumn(0).setMinWidth(0);
        jTableClientes.getColumnModel().getColumn(0).setPreferredWidth(0);
        }else{
            List<Clientes> lista = operaciones.ListaClientesBuscar(campo,buscar);
        
        tabla = (DefaultTableModel) jTableClientes.getModel();
        if(lista.size()>0){
            tabla.setRowCount(0);
            Iterator consulta = lista.iterator();
            while(consulta.hasNext()){
                Vector datos = new Vector();
                Clientes fila = (Clientes)consulta.next();
                datos.add(fila.getIdclientes());
                datos.add(fila.getNombre());
                datos.add(fila.getApellidos());
                datos.add(fila.getPoblacion());
                datos.add(fila.getIdentificacion());
                datos.add(fila.getTelefono());
                datos.add(fila.getTipoCliente());
                tabla.addRow(datos);
            }
        }else{
            JOptionPane.showMessageDialog(null, "El cliente no existe"); 
            }
        }
       
        
    }//GEN-LAST:event_jButtonBuscarActionPerformed

   
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
            java.util.logging.Logger.getLogger(ClientesVer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientesVer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientesVer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientesVer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientesVer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenuAlmacen;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuClientes;
    private javax.swing.JMenu jMenuFacturas;
    private javax.swing.JMenu jMenuInicio;
    private javax.swing.JMenuItem jMenuItemCategorias;
    private javax.swing.JMenuItem jMenuItemProductos;
    private javax.swing.JMenu jMenuProveedores;
    private javax.swing.JMenu jMenuUsuarios;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableClientes;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
