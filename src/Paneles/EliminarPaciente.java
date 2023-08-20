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
public final class EliminarPaciente extends javax.swing.JPanel {

    private static Connection conexion;
    private static PreparedStatement sentencia_preparada;
    private static PreparedStatement sentencia_preparada2;
    private static PreparedStatement sentencia_preparada3;
    private static ResultSet resultado;
    private static ResultSet resultado2;
    private static ResultSet resultado3;
    
    Metodos_mysql metodos=new Metodos_mysql();
    int idPaciente;
    String nombre;
    String apePa;
    String apeMa;
    String telefono;
    String correo;
    String calle;
    String numero;
    String colonia;
    String cp;
    String ciudad;

    /**
     * Creates new form ConsultaEspecialista
     */
    public EliminarPaciente() {
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
        txtnombre.setEnabled(true);
        txtapePa.setEnabled(true);
        txtapeMat.setEnabled(true);
        txttelefono.setEnabled(true);
        txtcorreo.setEnabled(true);
        txtcalle.setEnabled(true);
        txtno.setEnabled(true);
        txtcolonia.setEnabled(true);
        txtcp.setEnabled(true);
        txtciudad.setEnabled(true);
        botonEliminar.setEnabled(true);
    }
    
    public void bloquear(){
        txtnombre.setEnabled(false);
        txtapePa.setEnabled(false);
        txtapeMat.setEnabled(false);
        txttelefono.setEnabled(false);
        txtcorreo.setEnabled(false);
        txtcalle.setEnabled(false);
        txtno.setEnabled(false);
        txtcolonia.setEnabled(false);
        txtcp.setEnabled(false);
        txtciudad.setEnabled(false);
        botonEliminar.setEnabled(false);
    }
    
    public void recuperar_datos(String idPaciente){
        try{
            conexion=Conexion_BD.conectar();
            String sql_busqueda="Select * FROM paciente WHERE idPaciente=?";
            sentencia_preparada=conexion.prepareStatement(sql_busqueda);
            sentencia_preparada.setString(1,idPaciente);
            resultado=sentencia_preparada.executeQuery();
            
            String sql_busqueda2="Select * FROM paciente_telefono WHERE idPaciente=?";
            sentencia_preparada2=conexion.prepareStatement(sql_busqueda2);
            sentencia_preparada2.setString(1,idPaciente);
            resultado2=sentencia_preparada2.executeQuery();
            
            String sql_busqueda3="Select * FROM paciente_correo WHERE idPaciente=?";
            sentencia_preparada3=conexion.prepareStatement(sql_busqueda3);
            sentencia_preparada3.setString(1,idPaciente);
            resultado3=sentencia_preparada3.executeQuery();
            
            if(resultado.next()&&resultado2.next()&&resultado3.next()){
                txtvalidar.setText("ID registrado");
                txtvalidar.setForeground(Color.BLACK);
                txtnombre.setText(resultado.getString("nombre"));
                txtapePa.setText(resultado.getString("apePa"));
                txtapeMat.setText(resultado.getString("apeMa"));
                txttelefono.setText(resultado2.getString("telefono"));
                txtcorreo.setText(resultado3.getString("correo"));
                txtcalle.setText(resultado.getString("calle"));
                txtno.setText(resultado.getString("numero"));
                txtcolonia.setText(resultado.getString("colonia"));
                txtcp.setText(resultado.getString("cp"));
                txtciudad.setText(resultado.getString("ciudad"));
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
                Logger.getLogger(EliminarPaciente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void preguntaEliminar(){
        Advertencia a = new Advertencia(null, true);
        String id= txtid.getText();
        a.ms.setText("¿Desea eliminar el Paciente?");
        a.id.setText(id);
        a.setVisible(true);
    }
    
    public void limpiar(){
        txtnombre.setText("--");
        txtapePa.setText("--");
        txtapeMat.setText("--");;
        txttelefono.setText("--");
        txtcorreo.setText("--");
        txtcalle.setText("--");
        txtno.setText("--");
        txtcolonia.setText("--");
        txtcp.setText("--");
        txtciudad.setText("--");
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
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txttelefono = new javax.swing.JLabel();
        txtnombre = new javax.swing.JLabel();
        txtapePa = new javax.swing.JLabel();
        txtapeMat = new javax.swing.JLabel();
        txtcorreo = new javax.swing.JLabel();
        txtciudad = new javax.swing.JLabel();
        txtcalle = new javax.swing.JLabel();
        txtno = new javax.swing.JLabel();
        txtcolonia = new javax.swing.JLabel();
        txtcp = new javax.swing.JLabel();
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
        jLabel4.setText("Datos del Paciente");
        jLabel4.setToolTipText("");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 178, -1, -1));

        panelEliminacion.setBackground(new java.awt.Color(177, 182, 198));
        panelEliminacion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel2.setText("Nombre : ");
        panelEliminacion.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 29, -1, 46));

        jLabel6.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel6.setText("Apellido Paterno : ");
        panelEliminacion.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 198, 46));

        jLabel7.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel7.setText("Apellido Materno : ");
        panelEliminacion.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, 46));

        jLabel9.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel9.setText("Teléfono : ");
        panelEliminacion.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, 46));

        jLabel10.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel10.setText("Correo : ");
        panelEliminacion.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, -1, 46));

        jLabel11.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel11.setText("No. Casa : ");
        panelEliminacion.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 110, -1, 46));

        jLabel12.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel12.setText("Calle : ");
        panelEliminacion.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(529, 23, -1, 46));

        jLabel13.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel13.setText("Colonia : ");
        panelEliminacion.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 190, -1, 46));

        jLabel14.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel14.setText("Código Postal : ");
        panelEliminacion.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 270, -1, 46));

        jLabel15.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel15.setText("Ciudad : ");
        panelEliminacion.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 350, -1, 46));

        txttelefono.setBackground(new java.awt.Color(255, 255, 255));
        txttelefono.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txttelefono.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txttelefono.setText("---");
        txttelefono.setToolTipText("");
        txttelefono.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txttelefono.setOpaque(true);
        panelEliminacion.add(txttelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 270, 294, 46));

        txtnombre.setBackground(new java.awt.Color(255, 255, 255));
        txtnombre.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtnombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtnombre.setText("---");
        txtnombre.setToolTipText("");
        txtnombre.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtnombre.setOpaque(true);
        panelEliminacion.add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, 294, 46));

        txtapePa.setBackground(new java.awt.Color(255, 255, 255));
        txtapePa.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtapePa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtapePa.setText("---");
        txtapePa.setToolTipText("");
        txtapePa.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtapePa.setOpaque(true);
        panelEliminacion.add(txtapePa, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, 294, 46));

        txtapeMat.setBackground(new java.awt.Color(255, 255, 255));
        txtapeMat.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtapeMat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtapeMat.setText("---");
        txtapeMat.setToolTipText("");
        txtapeMat.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtapeMat.setOpaque(true);
        panelEliminacion.add(txtapeMat, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, 294, 46));

        txtcorreo.setBackground(new java.awt.Color(255, 255, 255));
        txtcorreo.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtcorreo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtcorreo.setText("---");
        txtcorreo.setToolTipText("");
        txtcorreo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtcorreo.setOpaque(true);
        panelEliminacion.add(txtcorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 350, 294, 46));

        txtciudad.setBackground(new java.awt.Color(255, 255, 255));
        txtciudad.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtciudad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtciudad.setText("---");
        txtciudad.setToolTipText("");
        txtciudad.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtciudad.setOpaque(true);
        panelEliminacion.add(txtciudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 350, 295, 46));

        txtcalle.setBackground(new java.awt.Color(255, 255, 255));
        txtcalle.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtcalle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtcalle.setText("---");
        txtcalle.setToolTipText("");
        txtcalle.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtcalle.setOpaque(true);
        panelEliminacion.add(txtcalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(713, 26, 295, 46));

        txtno.setBackground(new java.awt.Color(255, 255, 255));
        txtno.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtno.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtno.setText("---");
        txtno.setToolTipText("");
        txtno.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtno.setOpaque(true);
        panelEliminacion.add(txtno, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 110, 295, 46));

        txtcolonia.setBackground(new java.awt.Color(255, 255, 255));
        txtcolonia.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtcolonia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtcolonia.setText("---");
        txtcolonia.setToolTipText("");
        txtcolonia.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtcolonia.setOpaque(true);
        panelEliminacion.add(txtcolonia, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 190, 295, 46));

        txtcp.setBackground(new java.awt.Color(255, 255, 255));
        txtcp.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtcp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtcp.setText("---");
        txtcp.setToolTipText("");
        txtcp.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtcp.setOpaque(true);
        panelEliminacion.add(txtcp, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 270, 295, 46));

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
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
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
    private javax.swing.JLabel txtapeMat;
    private javax.swing.JLabel txtapePa;
    private javax.swing.JLabel txtcalle;
    private javax.swing.JLabel txtciudad;
    private javax.swing.JLabel txtcolonia;
    private javax.swing.JLabel txtcorreo;
    private javax.swing.JLabel txtcp;
    private javax.swing.JTextField txtid;
    private javax.swing.JLabel txtno;
    private javax.swing.JLabel txtnombre;
    private javax.swing.JLabel txttelefono;
    private javax.swing.JLabel txtvalidar;
    // End of variables declaration//GEN-END:variables
}
