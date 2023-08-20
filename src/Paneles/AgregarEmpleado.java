/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Paneles;

import java.awt.Color;
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
public final class AgregarEmpleado extends javax.swing.JPanel {

    private static Connection conexion;
    private static PreparedStatement sentencia_preparada;
    private static ResultSet resultado;
    
    Metodos_mysql metodos=new Metodos_mysql();
    int idEmpleado;
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
    public AgregarEmpleado() {
        initComponents();
        imagen_png_guardar();
        bloquear();
    }

    public void imagen_gif_guardar() {
        ImageIcon check_gif;
        check_gif = new ImageIcon(getClass().getResource("/Imagenes/VENTANAS/CHECK.gif"));
        Icon gif = new ImageIcon(check_gif.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        botonGuardar.setIcon(gif);
    }
    
    public void imagen_png_guardar() {
        ImageIcon check_png;
        check_png = new ImageIcon(getClass().getResource("/Imagenes/VENTANAS/CHECK.png"));
        Icon png = new ImageIcon(check_png.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        botonGuardar.setIcon(png);
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
            String mensaje=metodos.buscar_idEmpleado(txtid.getText());
        
            if(mensaje.equals("Existe ID")){
                txtvalidar.setText("El ID ya se encuentra registrado");
                txtvalidar.setForeground(new Color(102,0,0));
                limpiar();
                bloquear();  
            }
        
            if(mensaje.equals("No Existe ID")){
            txtvalidar.setText("El ID no esta registrado");
            txtvalidar.setForeground(Color.BLACK);
            desbloquear();
            }
        }
        
        if("".equals(campo)){
            txtvalidar.setText("");
            limpiar();
            bloquear();
        }
    }
    
    
        public void bloquear(){
        txtnombre.setEnabled(false);
        txtapePa.setEnabled(false);
        txtapeMa.setEnabled(false);
        txttelefono.setEnabled(false);
        txtcorreo.setEnabled(false);
        txtcalle.setEnabled(false);
        txtno.setEnabled(false);
        txtcolonia.setEnabled(false);
        txtcp.setEnabled(false);
        txtciudad.setEnabled(false);
        botonGuardar.setEnabled(false);
        jButton1.setEnabled(false);
    }
    
    public void desbloquear(){
        txtnombre.setEnabled(true);
        txtapePa.setEnabled(true);
        txtapeMa.setEnabled(true);
        txttelefono.setEnabled(true);
        txtcorreo.setEnabled(true);
        txtcalle.setEnabled(true);
        txtno.setEnabled(true);
        txtcolonia.setEnabled(true);
        txtcp.setEnabled(true);
        txtciudad.setEnabled(true);
        botonGuardar.setEnabled(true);
        jButton1.setEnabled(true);
    }
    
    
    public void limpiar(){
        txtnombre.setText("Ingrese el Nombre");
        txtnombre.setForeground(new Color(153,153,153));
        txtapePa.setText("Ingrese el Apellido Paterno");
        txtapePa.setForeground(new Color(153,153,153));
        txtapeMa.setText("Ingrese el Apellido Materno");
        txtapeMa.setForeground(new Color(153,153,153));
        txttelefono.setText("Ingrese el Teléfono");
        txttelefono.setForeground(new Color(153,153,153));
        txtcorreo.setText("Ingrese el Correo");
        txtcorreo.setForeground(new Color(153,153,153));
        txtcalle.setText("Ingrese la Calle");
        txtcalle.setForeground(new Color(153,153,153));
        txtno.setText("Ingrese el No. Casa");
        txtno.setForeground(new Color(153,153,153));
        txtcolonia.setText("Ingrese la Colonia");
        txtcolonia.setForeground(new Color(153,153,153));
        txtcp.setText("Ingrese el Código Postal");
        txtcp.setForeground(new Color(153,153,153));
        txtciudad.setText("Ingrese la Ciudad");
        txtciudad.setForeground(new Color(153,153,153));
        validarTe.setText("");
        validarNo.setText("");
        validarCP.setText("");
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
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtapePa = new javax.swing.JTextField();
        txtapeMa = new javax.swing.JTextField();
        txttelefono = new javax.swing.JTextField();
        txtcorreo = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtcalle = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtcp = new javax.swing.JTextField();
        txtno = new javax.swing.JTextField();
        txtcolonia = new javax.swing.JTextField();
        txtciudad = new javax.swing.JTextField();
        txtvalidar = new javax.swing.JLabel();
        valiidarnombre = new javax.swing.JLabel();
        validarCi = new javax.swing.JLabel();
        validarapePa = new javax.swing.JLabel();
        validarapeMa = new javax.swing.JLabel();
        validarTe = new javax.swing.JLabel();
        validarCo = new javax.swing.JLabel();
        validarCa = new javax.swing.JLabel();
        validarNo = new javax.swing.JLabel();
        validarCol = new javax.swing.JLabel();
        validarCP = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        botonGuardar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(169, 195, 212));
        setPreferredSize(new java.awt.Dimension(1284, 720));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 48)); // NOI18N
        jLabel3.setText("Agregar");
        jLabel3.setToolTipText("");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 23, -1, -1));

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel4.setText("Ingrese los datos del Empleado");
        jLabel4.setToolTipText("");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 78, -1, -1));

        jPanel1.setBackground(new java.awt.Color(177, 182, 198));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel1.setText("ID : ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 24, -1, 46));

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
        jPanel1.add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 27, 294, 46));

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel2.setText("Nombre : ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 137, -1, 46));

        txtnombre.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtnombre.setForeground(new java.awt.Color(153, 153, 153));
        txtnombre.setText("Ingrese el Nombre");
        txtnombre.setToolTipText("");
        txtnombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtnombreMousePressed(evt);
            }
        });
        jPanel1.add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(222, 140, 294, 46));

        jLabel6.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel6.setText("Apellido Paterno : ");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 198, 46));

        jLabel7.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel7.setText("Apellido Materno : ");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, 46));

        jLabel9.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel9.setText("Teléfono : ");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, -1, 46));

        jLabel10.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel10.setText("Correo : ");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, -1, 46));

        txtapePa.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtapePa.setForeground(new java.awt.Color(153, 153, 153));
        txtapePa.setText("Ingrese el Apellido Paterno");
        txtapePa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtapePaMousePressed(evt);
            }
        });
        jPanel1.add(txtapePa, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, 294, 46));

        txtapeMa.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtapeMa.setForeground(new java.awt.Color(153, 153, 153));
        txtapeMa.setText("Ingrese el Apellido Materno");
        txtapeMa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtapeMaMousePressed(evt);
            }
        });
        jPanel1.add(txtapeMa, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 300, 294, 46));

        txttelefono.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txttelefono.setForeground(new java.awt.Color(153, 153, 153));
        txttelefono.setText("Ingrese el Teléfono");
        txttelefono.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txttelefonoMousePressed(evt);
            }
        });
        txttelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txttelefonoKeyReleased(evt);
            }
        });
        jPanel1.add(txttelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 380, 294, 46));

        txtcorreo.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtcorreo.setForeground(new java.awt.Color(153, 153, 153));
        txtcorreo.setText("Ingrese el Correo");
        txtcorreo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtcorreoMousePressed(evt);
            }
        });
        jPanel1.add(txtcorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 460, 294, 46));

        jLabel11.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel11.setText("No. Casa : ");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 220, -1, 46));

        txtcalle.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtcalle.setForeground(new java.awt.Color(153, 153, 153));
        txtcalle.setText("Ingrese la Calle");
        txtcalle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtcalleMousePressed(evt);
            }
        });
        jPanel1.add(txtcalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 140, 294, 46));

        jLabel12.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel12.setText("Calle : ");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 140, -1, 46));

        jLabel13.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel13.setText("Colonia : ");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 300, -1, 46));

        jLabel14.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel14.setText("Código Postal : ");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 380, -1, 46));

        jLabel15.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel15.setText("Ciudad : ");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 460, -1, 46));

        txtcp.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtcp.setForeground(new java.awt.Color(153, 153, 153));
        txtcp.setText("Ingrese el Código Postal");
        txtcp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtcpMousePressed(evt);
            }
        });
        txtcp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcpKeyReleased(evt);
            }
        });
        jPanel1.add(txtcp, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 380, 294, 46));

        txtno.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtno.setForeground(new java.awt.Color(153, 153, 153));
        txtno.setText("Ingrese el No. Casa");
        txtno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtnoMousePressed(evt);
            }
        });
        txtno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtnoKeyReleased(evt);
            }
        });
        jPanel1.add(txtno, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 220, 294, 46));

        txtcolonia.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtcolonia.setForeground(new java.awt.Color(153, 153, 153));
        txtcolonia.setText("Ingrese la Colonia");
        txtcolonia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtcoloniaMousePressed(evt);
            }
        });
        jPanel1.add(txtcolonia, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 300, 294, 46));

        txtciudad.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtciudad.setForeground(new java.awt.Color(153, 153, 153));
        txtciudad.setText("Ingrese la Ciudad");
        txtciudad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtciudadMousePressed(evt);
            }
        });
        jPanel1.add(txtciudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 460, 294, 46));

        txtvalidar.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jPanel1.add(txtvalidar, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 91, 440, 33));

        valiidarnombre.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        valiidarnombre.setForeground(new java.awt.Color(102, 0, 0));
        jPanel1.add(valiidarnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, 290, 30));

        validarCi.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        validarCi.setForeground(new java.awt.Color(102, 0, 0));
        jPanel1.add(validarCi, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 510, 290, 30));

        validarapePa.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        validarapePa.setForeground(new java.awt.Color(102, 0, 0));
        jPanel1.add(validarapePa, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 270, 290, 30));

        validarapeMa.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        validarapeMa.setForeground(new java.awt.Color(102, 0, 0));
        jPanel1.add(validarapeMa, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 350, 290, 30));

        validarTe.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        validarTe.setForeground(new java.awt.Color(102, 0, 0));
        jPanel1.add(validarTe, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 430, 290, 30));

        validarCo.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        validarCo.setForeground(new java.awt.Color(102, 0, 0));
        jPanel1.add(validarCo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 510, 290, 30));

        validarCa.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        validarCa.setForeground(new java.awt.Color(102, 0, 0));
        jPanel1.add(validarCa, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 190, 290, 30));

        validarNo.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        validarNo.setForeground(new java.awt.Color(102, 0, 0));
        jPanel1.add(validarNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 270, 290, 30));

        validarCol.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        validarCol.setForeground(new java.awt.Color(102, 0, 0));
        jPanel1.add(validarCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 350, 290, 30));

        validarCP.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        validarCP.setForeground(new java.awt.Color(102, 0, 0));
        jPanel1.add(validarCP, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 430, 290, 30));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 114, 1036, 600));

        jPanel2.setBackground(new java.awt.Color(177, 182, 198));

        botonGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonGuardarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonGuardarMouseExited(evt);
            }
        });
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/VENTANAS/BORRAR.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel17.setText("Agregar");
        jLabel17.setToolTipText("");

        jLabel18.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel18.setText("Borrar");
        jLabel18.setToolTipText("");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jLabel18)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel17)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel18)
                .addContainerGap(129, Short.MAX_VALUE))
        );

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 110, -1, -1));

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel5.setText("Opciones");
        jLabel5.setToolTipText("");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1065, 78, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void botonGuardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonGuardarMouseEntered
        // TODO add your handling code here:
        imagen_gif_guardar();
    }//GEN-LAST:event_botonGuardarMouseEntered

    private void botonGuardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonGuardarMouseExited
        // TODO add your handling code here:
        imagen_png_guardar();
    }//GEN-LAST:event_botonGuardarMouseExited

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        // TODO add your handling code here:
        idEmpleado=Integer.parseInt(txtid.getText().trim());
        nombre=txtnombre.getText();
        apePa=txtapePa.getText();
        apeMa=txtapeMa.getText();
        telefono=txttelefono.getText();
        correo=txtcorreo.getText();
        calle=txtcalle.getText();
        numero=txtno.getText();
        colonia=txtcolonia.getText();
        cp=txtcp.getText();
        ciudad=txtciudad.getText();
        metodos.agregar_empleado(idEmpleado,nombre, apePa, apeMa,
                                      telefono,correo,calle,numero,colonia,cp,
                                      ciudad);
        txtid.setText("Ingrese el ID");
        txtid.setForeground(new Color(153,153,153));
        txtvalidar.setText("");
        limpiar();
        bloquear();
    }//GEN-LAST:event_botonGuardarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        limpiar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtidKeyReleased
        // TODO add your handling code here:
        validacion();
    }//GEN-LAST:event_txtidKeyReleased

    private void txtidMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtidMousePressed
        // TODO add your handling code here:
        if (txtid.getText().equals("Ingrese el ID")) {
            txtid.setText("");
            txtid.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtidMousePressed

    private void txtnombreMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtnombreMousePressed
        // TODO add your handling code here:
        if (txtnombre.getText().equals("Ingrese el Nombre")) {
            txtnombre.setText("");
            txtnombre.setForeground(Color.black);
        }        
    }//GEN-LAST:event_txtnombreMousePressed

    private void txtapePaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtapePaMousePressed
        // TODO add your handling code here:
        if (txtapePa.getText().equals("Ingrese el Apellido Paterno")) {
            txtapePa.setText("");
            txtapePa.setForeground(Color.black);
        }        
    }//GEN-LAST:event_txtapePaMousePressed

    private void txtapeMaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtapeMaMousePressed
        // TODO add your handling code here:
        if (txtapeMa.getText().equals("Ingrese el Apellido Materno")) {
            txtapeMa.setText("");
            txtapeMa.setForeground(Color.black);
        }        
    }//GEN-LAST:event_txtapeMaMousePressed

    private void txttelefonoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txttelefonoMousePressed
        // TODO add your handling code here:
        if (txttelefono.getText().equals("Ingrese el Teléfono")) {
            txttelefono.setText("");
            txttelefono.setForeground(Color.black);
        }        
    }//GEN-LAST:event_txttelefonoMousePressed

    private void txtcorreoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtcorreoMousePressed
        // TODO add your handling code here:
        if (txtcorreo.getText().equals("Ingrese el Correo")) {
            txtcorreo.setText("");
            txtcorreo.setForeground(Color.black);
        }        
    }//GEN-LAST:event_txtcorreoMousePressed

    private void txtcalleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtcalleMousePressed
        // TODO add your handling code here:
        if (txtcalle.getText().equals("Ingrese la Calle")) {
            txtcalle.setText("");
            txtcalle.setForeground(Color.black);
        }         
    }//GEN-LAST:event_txtcalleMousePressed

    private void txtnoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtnoMousePressed
        // TODO add your handling code here:
        if (txtno.getText().equals("Ingrese el No. Casa")) {
            txtno.setText("");
            txtno.setForeground(Color.black);
        }        
    }//GEN-LAST:event_txtnoMousePressed

    private void txtcoloniaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtcoloniaMousePressed
        // TODO add your handling code here:
        if (txtcolonia.getText().equals("Ingrese la Colonia")) {
            txtcolonia.setText("");
            txtcolonia.setForeground(Color.black);
        }        
    }//GEN-LAST:event_txtcoloniaMousePressed

    private void txtcpMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtcpMousePressed
        // TODO add your handling code here:
        if (txtcp.getText().equals("Ingrese el Código Postal")) {
            txtcp.setText("");
            txtcp.setForeground(Color.black);
        }        
    }//GEN-LAST:event_txtcpMousePressed

    private void txtciudadMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtciudadMousePressed
        // TODO add your handling code here:
        if (txtciudad.getText().equals("Ingrese la Ciudad")) {
            txtciudad.setText("");
            txtciudad.setForeground(Color.black);
        }        
    }//GEN-LAST:event_txtciudadMousePressed

    private void txttelefonoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttelefonoKeyReleased
        // TODO add your handling code here:
        if(txttelefono.getText() != ""){
            String campo=txttelefono.getText();
            boolean isNumeric =  campo.matches("[+-]?\\d*(\\\\d+)?"); 
        
            if(isNumeric == false){
                validarTe.setText("Solo numeros enteros");
            }
        }
        
        if(txttelefono.getText().equals("")){
            validarTe.setText("");
        }
    }//GEN-LAST:event_txttelefonoKeyReleased

    private void txtnoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnoKeyReleased
        // TODO add your handling code here:
        if(txtno.getText() != ""){
            String campo=txtno.getText();
            boolean isNumeric =  campo.matches("[+-]?\\d*(\\\\d+)?"); 
        
            if(isNumeric == false){
                validarNo.setText("Solo numeros enteros");
            }
        }
        
        if(txtno.getText().equals("")){
            validarNo.setText("");
        }
    }//GEN-LAST:event_txtnoKeyReleased

    private void txtcpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcpKeyReleased
        // TODO add your handling code here:
        if(txtcp.getText() != ""){
            String campo=txtcp.getText();
            boolean isNumeric =  campo.matches("[+-]?\\d*(\\\\d+)?"); 
        
            if(isNumeric == false){
                validarCP.setText("Solo numeros enteros");
            }
        }
        
        if(txtno.getText().equals("")){
            validarCP.setText("");
        }
    }//GEN-LAST:event_txtcpKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonGuardar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtapeMa;
    private javax.swing.JTextField txtapePa;
    private javax.swing.JTextField txtcalle;
    private javax.swing.JTextField txtciudad;
    private javax.swing.JTextField txtcolonia;
    private javax.swing.JTextField txtcorreo;
    private javax.swing.JTextField txtcp;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtno;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txttelefono;
    private javax.swing.JLabel txtvalidar;
    private javax.swing.JLabel validarCP;
    private javax.swing.JLabel validarCa;
    private javax.swing.JLabel validarCi;
    private javax.swing.JLabel validarCo;
    private javax.swing.JLabel validarCol;
    private javax.swing.JLabel validarNo;
    private javax.swing.JLabel validarTe;
    private javax.swing.JLabel validarapeMa;
    private javax.swing.JLabel validarapePa;
    private javax.swing.JLabel valiidarnombre;
    // End of variables declaration//GEN-END:variables
}
