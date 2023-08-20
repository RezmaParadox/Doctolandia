/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Paneles;

import Alertas.Advertencia;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import mysql.Conexion_BD;
import mysql.Metodos_mysql;

/**
 *
 * @author Gibran Ramses
 */
public final class EliminarCita extends javax.swing.JPanel {

    private static Connection conexion;
    private static PreparedStatement sentencia_preparada;
    private static PreparedStatement sentencia_preparada2;
    private static PreparedStatement sentencia_preparada3;
    private static PreparedStatement sentencia_preparada4;
    private static ResultSet resultado;
    private static ResultSet resultado2;
    private static ResultSet resultado3;
    private static ResultSet resultado4;
    
    Metodos_mysql metodos=new Metodos_mysql();
    int idCita;
    String fecha;
    String hora;
    String motivo;
    String idPaciente;
    String idEspecialista;
    String precio;

    /**
     * Creates new form ConsultaEspecialista
     */
    public EliminarCita() {
        initComponents();
        imagen_png_eliminar();
        bloquear();
    }

    public void imagen_gif_eliminar() {
        ImageIcon check_gif;
        check_gif = new ImageIcon(getClass().getResource("/Imagenes/VENTANAS/DELETE.gif"));
        Icon gif = new ImageIcon(check_gif.getImage().getScaledInstance(115, 100, Image.SCALE_DEFAULT));
        botonEliminar.setIcon(gif);
    }
    
    public void imagen_png_eliminar() {
        ImageIcon check_png;
        check_png = new ImageIcon(getClass().getResource("/Imagenes/VENTANAS/DELETEE.png"));
        Icon png = new ImageIcon(check_png.getImage().getScaledInstance(115, 100, Image.SCALE_DEFAULT));
        botonEliminar.setIcon(png);
    }
    
    public void desbloquear(){
        txtfecha.setEnabled(true);
        txthora.setEnabled(true);
        txtmotivo.setEnabled(true);
        txtidP.setEnabled(true);
        txtidE.setEnabled(true);
        txtprecio.setEnabled(true);
        botonEliminar.setEnabled(true);
    }
    
    public void bloquear(){
        txtfecha.setEnabled(false);
        txthora.setEnabled(false);
        txtmotivo.setEnabled(false);
        txtidP.setEnabled(false);
        txtidE.setEnabled(false);
        txtprecio.setEnabled(false);
        botonEliminar.setEnabled(false);
    }
    
    public void recuperar_datos(String idCita){
        try{
            conexion=Conexion_BD.conectar();
            String sql_busqueda="Select * FROM cita WHERE idCita=?";
            sentencia_preparada=conexion.prepareStatement(sql_busqueda);
            sentencia_preparada.setString(1,idCita);
            resultado=sentencia_preparada.executeQuery();
            
            String sql_busqueda2="Select * FROM paciente_cita WHERE idCita=?";
            sentencia_preparada2=conexion.prepareStatement(sql_busqueda2);
            sentencia_preparada2.setString(1,idCita);
            resultado2=sentencia_preparada2.executeQuery();
            
            String sql_busqueda3="Select * FROM especialista_cita WHERE idCita=?";
            sentencia_preparada3=conexion.prepareStatement(sql_busqueda3);
            sentencia_preparada3.setString(1,idCita);
            resultado3=sentencia_preparada3.executeQuery();
            
            String sql_busqueda4="Select * FROM cita_precio WHERE idCita=?";
            sentencia_preparada4=conexion.prepareStatement(sql_busqueda4);
            sentencia_preparada4.setString(1,idCita);
            resultado4=sentencia_preparada4.executeQuery();
            
            if(resultado.next()&&resultado2.next()&&resultado3.next()&&resultado4.next()){
                txtvalidar.setText("ID registrado");
                txtvalidar.setForeground(Color.BLACK);
                txtfecha.setText(resultado.getString("fecha"));
                txthora.setText(resultado.getString("hora"));
                txtmotivo.setText(resultado.getString("motivo"));
                txtidP.setText(resultado2.getString("idPaciente"));
                txtidE.setText(resultado3.getString("idEspecialista"));
                txtprecio.setText(resultado4.getString("precio"));
                desbloquear();
            }else{
                txtvalidar.setText("Sin resultados en la busqueda");
                txtvalidar.setForeground(new Color(102,0,0));
                limpiar();
                bloquear();
            }
            conexion.close();
        }catch(SQLException e){
            System.out.println("Error: "+e);
        }finally{
            try {
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(EliminarCita.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void preguntaEliminar(){
        Advertencia a = new Advertencia(null, true);
        String id= txtid.getText();
        a.ms.setText("¿Desea eliminar la Cita?");
        a.id.setText(id);
        a.setVisible(true);
    }
    
    public void limpiar(){
        txtfecha.setText("--");
        txthora.setText("--");
        txtmotivo.setText("--");;
        txtidP.setText("--");
        txtidE.setText("--");
        txtprecio.setText("--");
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        panelEliminacion = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtidP = new javax.swing.JLabel();
        txtfecha = new javax.swing.JLabel();
        txthora = new javax.swing.JLabel();
        txtmotivo = new javax.swing.JLabel();
        txtidE = new javax.swing.JLabel();
        txtprecio = new javax.swing.JLabel();
        panelOpciones = new javax.swing.JPanel();
        botonEliminar = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        txtvalidar = new javax.swing.JLabel();

        setBackground(new java.awt.Color(169, 195, 212));
        setMaximumSize(new java.awt.Dimension(1284, 720));
        setMinimumSize(new java.awt.Dimension(1284, 720));
        setPreferredSize(new java.awt.Dimension(1284, 720));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 48)); // NOI18N
        jLabel3.setText("Eliminar");
        jLabel3.setToolTipText("");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 23, -1, -1));

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel4.setText("Datos de la Cita");
        jLabel4.setToolTipText("");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 178, -1, -1));

        panelEliminacion.setBackground(new java.awt.Color(177, 182, 198));
        panelEliminacion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel2.setText("Fecha : ");
        panelEliminacion.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 29, -1, 46));

        jLabel6.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel6.setText("Hora : ");
        panelEliminacion.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 198, 46));

        jLabel7.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel7.setText("Motivo : ");
        panelEliminacion.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, 46));

        jLabel9.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel9.setText("idPaciente : ");
        panelEliminacion.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, 46));

        jLabel10.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel10.setText("idEspecialista : ");
        panelEliminacion.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, -1, 46));

        jLabel12.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel12.setText("Precio : ");
        panelEliminacion.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(529, 23, -1, 46));

        txtidP.setBackground(new java.awt.Color(255, 255, 255));
        txtidP.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtidP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtidP.setText("---");
        txtidP.setToolTipText("");
        txtidP.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtidP.setOpaque(true);
        panelEliminacion.add(txtidP, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 270, 294, 46));

        txtfecha.setBackground(new java.awt.Color(255, 255, 255));
        txtfecha.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtfecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtfecha.setText("---");
        txtfecha.setToolTipText("");
        txtfecha.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtfecha.setOpaque(true);
        panelEliminacion.add(txtfecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, 294, 46));

        txthora.setBackground(new java.awt.Color(255, 255, 255));
        txthora.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txthora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txthora.setText("---");
        txthora.setToolTipText("");
        txthora.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txthora.setOpaque(true);
        panelEliminacion.add(txthora, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, 294, 46));

        txtmotivo.setBackground(new java.awt.Color(255, 255, 255));
        txtmotivo.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtmotivo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtmotivo.setText("---");
        txtmotivo.setToolTipText("");
        txtmotivo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtmotivo.setOpaque(true);
        panelEliminacion.add(txtmotivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, 294, 46));

        txtidE.setBackground(new java.awt.Color(255, 255, 255));
        txtidE.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtidE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtidE.setText("---");
        txtidE.setToolTipText("");
        txtidE.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtidE.setOpaque(true);
        panelEliminacion.add(txtidE, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 350, 294, 46));

        txtprecio.setBackground(new java.awt.Color(255, 255, 255));
        txtprecio.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtprecio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtprecio.setText("---");
        txtprecio.setToolTipText("");
        txtprecio.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtprecio.setOpaque(true);
        panelEliminacion.add(txtprecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(713, 26, 295, 46));

        add(panelEliminacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 1050, 510));

        panelOpciones.setBackground(new java.awt.Color(177, 182, 198));

        botonEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonEliminarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonEliminarMouseExited(evt);
            }
        });
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel17.setText("Eliminar");
        jLabel17.setToolTipText("");

        javax.swing.GroupLayout panelOpcionesLayout = new javax.swing.GroupLayout(panelOpciones);
        panelOpciones.setLayout(panelOpcionesLayout);
        panelOpcionesLayout.setHorizontalGroup(
            panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOpcionesLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(botonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelOpcionesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelOpcionesLayout.setVerticalGroup(
            panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOpcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel17)
                .addContainerGap(277, Short.MAX_VALUE))
        );

        add(panelOpciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 230, -1, 425));

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel5.setText("Opciones");
        jLabel5.setToolTipText("");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 180, -1, -1));

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel1.setText("Ingrese ID  para eliminar datos: ");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 100, 340, 46));

        txtid.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtid.setForeground(new java.awt.Color(153, 153, 153));
        txtid.setText("Ingrese el ID");
        txtid.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtidMousePressed(evt);
            }
        });
        txtid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtidKeyReleased(evt);
            }
        });
        add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 100, 294, 46));

        txtvalidar.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        add(txtvalidar, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 100, 400, 49));
    }// </editor-fold>//GEN-END:initComponents

    private void botonEliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonEliminarMouseEntered
        // TODO add your handling code here:
        imagen_gif_eliminar();
    }//GEN-LAST:event_botonEliminarMouseEntered

    private void botonEliminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonEliminarMouseExited
        // TODO add your handling code here:
        imagen_png_eliminar();
    }//GEN-LAST:event_botonEliminarMouseExited

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        // TODO add your handling code here:
        preguntaEliminar();
        txtid.setText("Ingrese el ID");
        txtid.setForeground(new Color(153,153,153));
        txtvalidar.setText("");
        limpiar();
        bloquear();
    }//GEN-LAST:event_botonEliminarActionPerformed

    private void txtidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtidKeyReleased
        // TODO add your handling code here:
        recuperar_datos(txtid.getText());
    }//GEN-LAST:event_txtidKeyReleased

    private void txtidMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtidMousePressed
        // TODO add your handling code here:
        if (txtid.getText().equals("Ingrese el ID")) {
            txtid.setText("");
            txtid.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtidMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel panelEliminacion;
    private javax.swing.JPanel panelOpciones;
    private javax.swing.JLabel txtfecha;
    private javax.swing.JLabel txthora;
    private javax.swing.JTextField txtid;
    private javax.swing.JLabel txtidE;
    private javax.swing.JLabel txtidP;
    private javax.swing.JLabel txtmotivo;
    private javax.swing.JLabel txtprecio;
    private javax.swing.JLabel txtvalidar;
    // End of variables declaration//GEN-END:variables
}
