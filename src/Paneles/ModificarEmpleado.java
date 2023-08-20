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
public final class ModificarEmpleado extends javax.swing.JPanel {

    private static Connection conexion;
    private static PreparedStatement sentencia_preparada;
    private static ResultSet resultado;
    private static PreparedStatement sentencia_preparada2;
    private static ResultSet resultado2;
    private static PreparedStatement sentencia_preparada3;
    private static ResultSet resultado3;
    
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
    public ModificarEmpleado() {
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
            String mensaje=metodos.buscar_idEmpleado(txtid.getText());
        
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
        txtnombre.setEnabled(true);
        txtnombre.setForeground(Color.BLACK);
        txtapePa.setEnabled(true);
        txtapePa.setForeground(Color.BLACK);
        txtapeMa.setEnabled(true);
        txtapeMa.setForeground(Color.BLACK);
        txttelefono.setEnabled(true);
        txttelefono.setForeground(Color.BLACK);
        txtcorreo.setEnabled(true);
        txtcorreo.setForeground(Color.BLACK);
        txtcalle.setEnabled(true);
        txtcalle.setForeground(Color.BLACK);
        txtno.setEnabled(true);
        txtno.setForeground(Color.BLACK);
        txtcolonia.setEnabled(true);
        txtcolonia.setForeground(Color.BLACK);
        txtcp.setEnabled(true);
        txtcp.setForeground(Color.BLACK);
        txtciudad.setEnabled(true);
        txtciudad.setForeground(Color.BLACK);
        botonActualizar.setEnabled(true);
        botonBorrar.setEnabled(true);
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
        botonActualizar.setEnabled(false);
        botonBorrar.setEnabled(false);
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
    
      public void recuperar_datos(String idEmpleado){
        try{
            conexion=Conexion_BD.conectar();
            String sql_busqueda="Select * FROM empleado WHERE idEmpleado=?";
            sentencia_preparada=conexion.prepareStatement(sql_busqueda);
            sentencia_preparada.setString(1,idEmpleado);
            resultado=sentencia_preparada.executeQuery();

            String sql_busqueda2="Select * FROM empleado_telefono WHERE idEmpleado=?";
            sentencia_preparada2=conexion.prepareStatement(sql_busqueda2);
            sentencia_preparada2.setString(1,idEmpleado);
            resultado2=sentencia_preparada2.executeQuery();
            
            String sql_busqueda3="Select * FROM empleado_correo WHERE idEmpleado=?";
            sentencia_preparada3=conexion.prepareStatement(sql_busqueda3);
            sentencia_preparada3.setString(1,idEmpleado);
            resultado3=sentencia_preparada3.executeQuery();
            
            if(resultado.next()&&resultado2.next()&&resultado3.next()){
                txtnombre.setText(resultado.getString("nombre"));
                txtapePa.setText(resultado.getString("apePa"));
                txtapeMa.setText(resultado.getString("apeMa"));
                txttelefono.setText(resultado2.getString("telefono"));
                txtcorreo.setText(resultado3.getString("correo"));
                txtcalle.setText(resultado.getString("calle"));
                txtno.setText(resultado.getString("numero"));
                txtcolonia.setText(resultado.getString("colonia"));
                txtcp.setText(resultado.getString("cp"));
                txtciudad.setText(resultado.getString("ciudad"));
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
        valiidarnombre = new javax.swing.JLabel();
        validarapePa = new javax.swing.JLabel();
        validarapeMa = new javax.swing.JLabel();
        validarTe = new javax.swing.JLabel();
        validarCa = new javax.swing.JLabel();
        validarCo = new javax.swing.JLabel();
        validarNo = new javax.swing.JLabel();
        validarCol = new javax.swing.JLabel();
        validarCP = new javax.swing.JLabel();
        validarCi = new javax.swing.JLabel();
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
        jLabel4.setText("Ingrese los datos del Empleado");
        jLabel4.setToolTipText("");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        panelModificar.setBackground(new java.awt.Color(177, 182, 198));
        panelModificar.setForeground(new java.awt.Color(153, 153, 153));
        panelModificar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel2.setText("Nombre : ");
        panelModificar.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 21, -1, 46));

        txtnombre.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtnombre.setForeground(new java.awt.Color(153, 153, 153));
        txtnombre.setText("Ingresa el Nombre");
        txtnombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtnombreMousePressed(evt);
            }
        });
        panelModificar.add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(222, 24, 294, 46));

        jLabel6.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel6.setText("Apellido Paterno : ");
        panelModificar.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 198, 46));

        jLabel7.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel7.setText("Apellido Materno : ");
        panelModificar.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, 46));

        jLabel9.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel9.setText("Teléfono : ");
        panelModificar.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, 46));

        jLabel10.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel10.setText("Correo : ");
        panelModificar.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, -1, 46));

        txtapePa.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtapePa.setForeground(new java.awt.Color(153, 153, 153));
        txtapePa.setText("Ingresa el Apellido Paterno");
        txtapePa.setToolTipText("");
        txtapePa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtapePaMousePressed(evt);
            }
        });
        panelModificar.add(txtapePa, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, 294, 46));

        txtapeMa.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtapeMa.setForeground(new java.awt.Color(153, 153, 153));
        txtapeMa.setText("Ingresa el Apellido Materno");
        txtapeMa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtapeMaMousePressed(evt);
            }
        });
        panelModificar.add(txtapeMa, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, 294, 46));

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
        panelModificar.add(txttelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 270, 294, 46));

        txtcorreo.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtcorreo.setForeground(new java.awt.Color(153, 153, 153));
        txtcorreo.setText("Ingrese el Correo");
        txtcorreo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtcorreoMousePressed(evt);
            }
        });
        panelModificar.add(txtcorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 350, 294, 46));

        jLabel11.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel11.setText("No. Casa : ");
        panelModificar.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 110, -1, 46));

        txtcalle.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtcalle.setForeground(new java.awt.Color(153, 153, 153));
        txtcalle.setText("Ingresa la Calle");
        txtcalle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtcalleMousePressed(evt);
            }
        });
        panelModificar.add(txtcalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(712, 24, 294, 46));

        jLabel12.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel12.setText("Calle : ");
        panelModificar.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(534, 24, -1, 46));

        jLabel13.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel13.setText("Colonia : ");
        panelModificar.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 190, -1, 46));

        jLabel14.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel14.setText("Código Postal : ");
        panelModificar.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 270, -1, 46));

        jLabel15.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel15.setText("Ciudad : ");
        panelModificar.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 350, -1, 46));

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
        panelModificar.add(txtcp, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 270, 294, 46));

        txtno.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtno.setForeground(new java.awt.Color(153, 153, 153));
        txtno.setText("Ingresa el No. Casa");
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
        panelModificar.add(txtno, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 110, 294, 46));

        txtcolonia.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtcolonia.setForeground(new java.awt.Color(153, 153, 153));
        txtcolonia.setText("Ingresa la Colonia");
        txtcolonia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtcoloniaMousePressed(evt);
            }
        });
        panelModificar.add(txtcolonia, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 190, 294, 46));

        txtciudad.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtciudad.setForeground(new java.awt.Color(153, 153, 153));
        txtciudad.setText("Ingresa la Ciudad");
        txtciudad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtciudadMousePressed(evt);
            }
        });
        panelModificar.add(txtciudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 350, 294, 46));

        valiidarnombre.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        valiidarnombre.setForeground(new java.awt.Color(102, 0, 0));
        panelModificar.add(valiidarnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 290, 30));

        validarapePa.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        validarapePa.setForeground(new java.awt.Color(102, 0, 0));
        panelModificar.add(validarapePa, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 160, 290, 30));

        validarapeMa.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        validarapeMa.setForeground(new java.awt.Color(102, 0, 0));
        panelModificar.add(validarapeMa, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 240, 290, 30));

        validarTe.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        validarTe.setForeground(new java.awt.Color(102, 0, 0));
        panelModificar.add(validarTe, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 320, 290, 30));

        validarCa.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        validarCa.setForeground(new java.awt.Color(102, 0, 0));
        panelModificar.add(validarCa, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 70, 290, 30));

        validarCo.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        validarCo.setForeground(new java.awt.Color(102, 0, 0));
        panelModificar.add(validarCo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 400, 290, 30));

        validarNo.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        validarNo.setForeground(new java.awt.Color(102, 0, 0));
        panelModificar.add(validarNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 160, 290, 30));

        validarCol.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        validarCol.setForeground(new java.awt.Color(102, 0, 0));
        panelModificar.add(validarCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 240, 290, 30));

        validarCP.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        validarCP.setForeground(new java.awt.Color(102, 0, 0));
        panelModificar.add(validarCP, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 320, 290, 30));

        validarCi.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        validarCi.setForeground(new java.awt.Color(102, 0, 0));
        panelModificar.add(validarCi, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 400, 290, 30));

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
        metodos.modificar_empleado(nombre, apePa, apeMa,telefono,
                                       correo,calle,numero,colonia,cp,
                                       ciudad,idEmpleado);
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
    private javax.swing.JButton botonActualizar;
    private javax.swing.JButton botonBorrar;
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
    private javax.swing.JPanel panelModificar;
    private javax.swing.JPanel panelOpciones;
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
