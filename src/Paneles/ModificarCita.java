/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Paneles;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import mysql.Conexion_BD;
import mysql.Metodos_mysql;

/**
 *
 * @author Gibran Ramses
 */
public final class ModificarCita extends javax.swing.JPanel {

    private static Connection conexion;
    private static PreparedStatement sentencia_preparada;
    private static ResultSet resultado;
    private static PreparedStatement sentencia_preparada2;
    private static ResultSet resultado2;
    private static PreparedStatement sentencia_preparada3;
    private static ResultSet resultado3;
    private static PreparedStatement sentencia_preparada4;
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
    public ModificarCita() {
        initComponents();
        imagen_png_modificar();
        bloquear();
    }

    public void imagen_gif_modificar() {
        ImageIcon check_gif;
        check_gif = new ImageIcon(getClass().getResource("/Imagenes/VENTANAS/UPDATE.gif"));
        Icon gif = new ImageIcon(check_gif.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        botonActualizar.setIcon(gif);
    }
    
    public void imagen_png_modificar() {
        ImageIcon check_png;
        check_png = new ImageIcon(getClass().getResource("/Imagenes/VENTANAS/UPPDATE.png"));
        Icon png = new ImageIcon(check_png.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        botonActualizar.setIcon(png);
    }
    
    public void validacion(){
        String campo= txtid.getText();
        boolean isNumeric =  campo.matches("[+-]?\\d*(\\\\d+)?"); 
        
        if(isNumeric==false){
            txtvalidar.setText("El ID solo puede contener numeros enteros");
            txtvalidar.setForeground(new Color(102,0,0));
            limpiar();
            bloquear();
        }
        
        if(campo != "" && isNumeric == true){
            String mensaje=metodos.buscar_idCita(txtid.getText());
        
            if(mensaje.equals("Existe ID")){
                txtvalidar.setText("Se encontro el ID");
                txtvalidar.setForeground(Color.BLACK);
                desbloquear();
                recuperar_datos(txtid.getText());
            }
        
            if(mensaje.equals("No Existe ID")){
            txtvalidar.setText("Sin resultados en la busqueda");
            txtvalidar.setForeground(new Color(102,0,0));
            limpiar();
            bloquear();
            }
        }
        
        if("".equals(campo)){
            txtvalidar.setText("");
            limpiar();
            bloquear();
        }
    }
    
    public void desbloquear(){
        txtFecha.setEnabled(true);
        txtFecha.setForeground(Color.BLACK);
        txtHora.setEnabled(true);
        txtHora.setForeground(Color.BLACK);
        txtMotivo.setEnabled(true);
        txtMotivo.setForeground(Color.BLACK);
        txtidPaciente.setEnabled(true);
        txtidPaciente.setForeground(Color.BLACK);
        txtidEspecialista.setEnabled(true);
        txtidEspecialista.setForeground(Color.BLACK);
        txtPrecio.setEnabled(true);
        txtPrecio.setForeground(Color.BLACK);
        botonActualizar.setEnabled(true);
        botonBorrar.setEnabled(true);
    }
    
    public void bloquear(){
        txtFecha.setEnabled(false);
        txtHora.setEnabled(false);
        txtMotivo.setEnabled(false);
        txtidPaciente.setEnabled(false);
        txtidEspecialista.setEnabled(false);
        txtPrecio.setEnabled(false);
        botonActualizar.setEnabled(false);
        botonBorrar.setEnabled(false);
    }
    
    public void limpiar(){
        txtFecha.setText("Ingrese la Fecha");
        txtFecha.setForeground(new Color(153,153,153));
        txtHora.setText("Ingrese la Hora");
        txtHora.setForeground(new Color(153,153,153));
        txtMotivo.setText("Ingrese el Motivo");
        txtMotivo.setForeground(new Color(153,153,153));
        txtidPaciente.setText("Ingrese el Paciente");
        txtidPaciente.setForeground(new Color(153,153,153));
        txtidEspecialista.setText("Ingrese el Especialista");
        txtidEspecialista.setForeground(new Color(153,153,153));
        txtPrecio.setText("Ingrese el Precio");
        txtPrecio.setForeground(new Color(153,153,153));
        validaridP.setText("");
        validaridE.setText("");
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
                txtFecha.setText(resultado.getString("fecha"));
                txtHora.setText(resultado.getString("hora"));
                txtMotivo.setText(resultado.getString("motivo"));
                txtidPaciente.setText(resultado2.getString("idPaciente"));
                txtidEspecialista.setText(resultado3.getString("idEspecialista"));
                txtPrecio.setText(resultado4.getString("precio"));
                desbloquear();
            }else{
                bloquear();
            }
            conexion.close();
        }catch(SQLException e){
            System.out.println("Error: "+e);
        }finally{
            try {
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(EliminarEspecialista.class.getName()).log(Level.SEVERE, null, ex);
            }
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

        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        panelModificar = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtHora = new javax.swing.JTextField();
        txtMotivo = new javax.swing.JTextField();
        txtidPaciente = new javax.swing.JTextField();
        txtidEspecialista = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        valiidarnombre = new javax.swing.JLabel();
        validarapePa = new javax.swing.JLabel();
        validarapeMa = new javax.swing.JLabel();
        validaridP = new javax.swing.JLabel();
        validarCa = new javax.swing.JLabel();
        validaridE = new javax.swing.JLabel();
        panelOpciones = new javax.swing.JPanel();
        botonActualizar = new javax.swing.JButton();
        botonBorrar = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
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
        jLabel3.setText("Modificar");
        jLabel3.setToolTipText("");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel4.setText("Ingrese los datos de la Cita");
        jLabel4.setToolTipText("");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        panelModificar.setBackground(new java.awt.Color(177, 182, 198));
        panelModificar.setForeground(new java.awt.Color(153, 153, 153));
        panelModificar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel2.setText("Fecha : ");
        panelModificar.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 21, -1, 46));

        txtFecha.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtFecha.setForeground(new java.awt.Color(153, 153, 153));
        txtFecha.setText("Ingresa la Fecha");
        txtFecha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtFechaMousePressed(evt);
            }
        });
        panelModificar.add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(222, 24, 294, 46));

        jLabel6.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel6.setText("Hora : ");
        panelModificar.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 198, 46));

        jLabel7.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel7.setText("Motivo : ");
        panelModificar.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, 46));

        jLabel9.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel9.setText("idPaciente : ");
        panelModificar.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, 46));

        jLabel10.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel10.setText("idEspecialista : ");
        panelModificar.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, -1, 46));

        txtHora.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtHora.setForeground(new java.awt.Color(153, 153, 153));
        txtHora.setText("Ingrese la Hora");
        txtHora.setToolTipText("");
        txtHora.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtHoraMousePressed(evt);
            }
        });
        panelModificar.add(txtHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, 294, 46));

        txtMotivo.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtMotivo.setForeground(new java.awt.Color(153, 153, 153));
        txtMotivo.setText("Ingresa el Motivo");
        txtMotivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtMotivoMousePressed(evt);
            }
        });
        panelModificar.add(txtMotivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, 294, 46));

        txtidPaciente.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtidPaciente.setForeground(new java.awt.Color(153, 153, 153));
        txtidPaciente.setText("Ingrese el idPaciente");
        txtidPaciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtidPacienteMousePressed(evt);
            }
        });
        txtidPaciente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtidPacienteKeyReleased(evt);
            }
        });
        panelModificar.add(txtidPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 270, 294, 46));

        txtidEspecialista.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtidEspecialista.setForeground(new java.awt.Color(153, 153, 153));
        txtidEspecialista.setText("Ingrese el idEspecialista");
        txtidEspecialista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtidEspecialistaMousePressed(evt);
            }
        });
        panelModificar.add(txtidEspecialista, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 350, 294, 46));

        txtPrecio.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtPrecio.setForeground(new java.awt.Color(153, 153, 153));
        txtPrecio.setText("Ingresa el Precio");
        txtPrecio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtPrecioMousePressed(evt);
            }
        });
        panelModificar.add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(712, 24, 294, 46));

        jLabel12.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel12.setText("Precio : ");
        panelModificar.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(534, 24, -1, 46));

        valiidarnombre.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        valiidarnombre.setForeground(new java.awt.Color(102, 0, 0));
        panelModificar.add(valiidarnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 290, 30));

        validarapePa.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        validarapePa.setForeground(new java.awt.Color(102, 0, 0));
        panelModificar.add(validarapePa, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 160, 290, 30));

        validarapeMa.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        validarapeMa.setForeground(new java.awt.Color(102, 0, 0));
        panelModificar.add(validarapeMa, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 240, 290, 30));

        validaridP.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        validaridP.setForeground(new java.awt.Color(102, 0, 0));
        panelModificar.add(validaridP, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 320, 290, 30));

        validarCa.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        validarCa.setForeground(new java.awt.Color(102, 0, 0));
        panelModificar.add(validarCa, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 70, 290, 30));

        validaridE.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        validaridE.setForeground(new java.awt.Color(102, 0, 0));
        panelModificar.add(validaridE, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 400, 290, 30));

        add(panelModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 1041, 497));

        panelOpciones.setBackground(new java.awt.Color(177, 182, 198));

        botonActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonActualizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonActualizarMouseExited(evt);
            }
        });
        botonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarActionPerformed(evt);
            }
        });

        botonBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/VENTANAS/BORRAR.png"))); // NOI18N
        botonBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBorrarActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel17.setText("Actualizar");
        jLabel17.setToolTipText("");

        jLabel18.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel18.setText("Borrar");
        jLabel18.setToolTipText("");

        javax.swing.GroupLayout panelOpcionesLayout = new javax.swing.GroupLayout(panelOpciones);
        panelOpciones.setLayout(panelOpcionesLayout);
        panelOpcionesLayout.setHorizontalGroup(
            panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOpcionesLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(botonBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelOpcionesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelOpcionesLayout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(jLabel18)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelOpcionesLayout.setVerticalGroup(
            panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOpcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botonActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel18)
                .addContainerGap(150, Short.MAX_VALUE))
        );

        add(panelOpciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(1087, 225, -1, -1));

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel5.setText("Opciones");
        jLabel5.setToolTipText("");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1087, 178, -1, -1));

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel1.setText("Ingrese ID  para actualizar datos: ");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, 46));

        txtid.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtid.setForeground(new java.awt.Color(153, 153, 153));
        txtid.setText("Ingresa el ID");
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
        add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, 294, 46));

        txtvalidar.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        add(txtvalidar, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 100, 450, 49));
    }// </editor-fold>//GEN-END:initComponents

    private void botonActualizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonActualizarMouseEntered
        // TODO add your handling code here:
        imagen_gif_modificar();
    }//GEN-LAST:event_botonActualizarMouseEntered

    private void botonActualizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonActualizarMouseExited
        // TODO add your handling code here:
        imagen_png_modificar();
    }//GEN-LAST:event_botonActualizarMouseExited

    private void botonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarActionPerformed
        // TODO add your handling code here:
        idCita=Integer.parseInt(txtid.getText().trim());
        fecha=txtFecha.getText();
        hora=txtHora.getText();
        motivo=txtMotivo.getText();
        idPaciente=txtidPaciente.getText();
        idEspecialista=txtidEspecialista.getText();
        precio=txtPrecio.getText();
        metodos.modificar_cita(fecha, hora, motivo,
                               idPaciente,idEspecialista,precio,idCita);
        txtid.setText("Ingrese el ID");
        txtid.setForeground(new Color(153,153,153));
        txtvalidar.setText("");
        limpiar();
        bloquear();
    }//GEN-LAST:event_botonActualizarActionPerformed

    private void botonBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBorrarActionPerformed
        // TODO add your handling code here:
        limpiar();
    }//GEN-LAST:event_botonBorrarActionPerformed

    private void txtidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtidKeyReleased
        // TODO add your handling code here:
        validacion();
    }//GEN-LAST:event_txtidKeyReleased

    private void txtidMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtidMousePressed
        // TODO add your handling code here:
        if (txtid.getText().equals("Ingresa el ID")) {
            txtid.setText("");
            txtid.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtidMousePressed

    private void txtMotivoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMotivoMousePressed
        // TODO add your handling code here:
        if (txtMotivo.getText().equals("Ingrese el Motivo")) {
            txtMotivo.setText("");
            txtMotivo.setForeground(Color.black);
        }               
    }//GEN-LAST:event_txtMotivoMousePressed

    private void txtidPacienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtidPacienteMousePressed
        // TODO add your handling code here:
        if (txtidPaciente.getText().equals("Ingrese el idPaciente")) {
            txtidPaciente.setText("");
            txtidPaciente.setForeground(Color.black);
        }          
    }//GEN-LAST:event_txtidPacienteMousePressed

    private void txtidEspecialistaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtidEspecialistaMousePressed
        // TODO add your handling code here:
        if (txtidEspecialista.getText().equals("Ingrese el idEspecialista")) {
            txtidEspecialista.setText("");
            txtidEspecialista.setForeground(Color.black);
        }                
    }//GEN-LAST:event_txtidEspecialistaMousePressed

    private void txtPrecioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPrecioMousePressed
        // TODO add your handling code here:
        if (txtPrecio.getText().equals("Ingrese el Precio")) {
            txtPrecio.setText("");
            txtPrecio.setForeground(Color.black);
        }            
    }//GEN-LAST:event_txtPrecioMousePressed

    private void txtidPacienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtidPacienteKeyReleased
        // TODO add your handling code here:
        if(txtidPaciente.getText() != ""){
            String campo=txtidPaciente.getText();
            boolean isNumeric =  campo.matches("[+-]?\\d*(\\\\d+)?"); 
        
            if(isNumeric == false){
                validaridP.setText("Solo numeros enteros");
            }
        }
        
        if(txtidPaciente.getText().equals("")){
            validaridP.setText("");
        }
    }//GEN-LAST:event_txtidPacienteKeyReleased

    private void txtHoraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtHoraMousePressed
        // TODO add your handling code here:
        if (txtHora.getText().equals("Ingrese la Hora")) {
            txtHora.setText("");
            txtHora.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtHoraMousePressed

    private void txtFechaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFechaMousePressed
        // TODO add your handling code here:
        if (txtFecha.getText().equals("Ingrese la Fecha")) {
            txtFecha.setText("");
            txtFecha.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtFechaMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonActualizar;
    private javax.swing.JButton botonBorrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel panelModificar;
    private javax.swing.JPanel panelOpciones;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtMotivo;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtidEspecialista;
    private javax.swing.JTextField txtidPaciente;
    private javax.swing.JLabel txtvalidar;
    private javax.swing.JLabel validarCa;
    private javax.swing.JLabel validarapeMa;
    private javax.swing.JLabel validarapePa;
    private javax.swing.JLabel validaridE;
    private javax.swing.JLabel validaridP;
    private javax.swing.JLabel valiidarnombre;
    // End of variables declaration//GEN-END:variables
}
