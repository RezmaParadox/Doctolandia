/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Paneles;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import mysql.Conexion_BD;

/**
 *
 * @author Gibran Ramses
 */
public class ConsultaCita extends javax.swing.JPanel {
    private static Connection conexion;
    private static PreparedStatement sentencia_preparada1;
    private static ResultSet resultado1;
    private static PreparedStatement sentencia_preparada2;
    private static ResultSet resultado2;
    private static PreparedStatement sentencia_preparada3;
    private static ResultSet resultado3;
    private static PreparedStatement sentencia_preparada4;
    private static ResultSet resultado4;
    

    DefaultTableModel tabla;
    String [] columnas ={"idCita","Fecha","Hora","Motivo",
                          "idPaciente", "idEspecialista","Precio"};
    String filas[] =new String[7];
    /**
     * Creates new form ConsultaEspecialista
     */
    public ConsultaCita() {
        initComponents();
        cargarTabla();
    }
    
    public void cargarTabla(){
        tabla = new DefaultTableModel(null,columnas);
        
        try{
            conexion=Conexion_BD.conectar();
            String consulta1="SELECT * FROM cita";
            String consulta2="SELECT * FROM paciente_cita";
            String consulta3="SELECT * FROM especialista_cita";
            String consulta4="SELECT * FROM cita_precio";
            sentencia_preparada1=conexion.prepareStatement(consulta1);
            sentencia_preparada2=conexion.prepareStatement(consulta2);
            sentencia_preparada3=conexion.prepareStatement(consulta3);
            sentencia_preparada4=conexion.prepareStatement(consulta4);
            resultado1=sentencia_preparada1.executeQuery();
            resultado2=sentencia_preparada2.executeQuery();
            resultado3=sentencia_preparada3.executeQuery();
            resultado4=sentencia_preparada4.executeQuery();

            
            while(resultado1.next() && resultado2.next() && resultado3.next()&& resultado4.next()){
                filas[0]=resultado1.getString(1);
                filas[1]=resultado1.getString(2);
                filas[2]=resultado1.getString(3);
                filas[3]=resultado1.getString(4);
                filas[4]=resultado2.getString(1);
                filas[5]=resultado3.getString(1);
                filas[6]=resultado4.getString(2);
                tabla.addRow(filas);
            }
            
            datos.setModel(tabla);
            conexion.close();
        }catch(SQLException e){
            System.out.println("Error: "+e);
        }finally{
            try {
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConsultaCita.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Error: "+ex);
            }
        }
    }

     public void busquedaFiltrada(String tipo, String id){
        tabla = new DefaultTableModel(null,columnas);
        
        if(tipo.equals("idCita")){
            try{
                conexion=Conexion_BD.conectar();
                String consulta1="SELECT * FROM cita WHERE idCita LIKE " 
                              + '"' + id + "%" + '"';
                String consulta2="SELECT * FROM paciente_cita WHERE idCita LIKE " 
                              + '"' + id + "%" + '"';
                String consulta3="SELECT * FROM especialista_cita WHERE idCita LIKE " 
                              + '"' + id + "%" + '"';
                String consulta4="SELECT * FROM cita_precio WHERE idCita LIKE " 
                              + '"' + id + "%" + '"';
                sentencia_preparada1=conexion.prepareStatement(consulta1);
                sentencia_preparada2=conexion.prepareStatement(consulta2);
                sentencia_preparada3=conexion.prepareStatement(consulta3);
                sentencia_preparada4=conexion.prepareStatement(consulta4);
                resultado1=sentencia_preparada1.executeQuery();
                resultado2=sentencia_preparada2.executeQuery();
                resultado3=sentencia_preparada3.executeQuery();
                resultado4=sentencia_preparada4.executeQuery();

            
                while(resultado1.next() && resultado2.next() && resultado3.next() && resultado4.next()){
                    filas[0]=resultado1.getString(1);
                    filas[1]=resultado1.getString(2);
                    filas[2]=resultado1.getString(3);
                    filas[3]=resultado1.getString(4);
                    filas[4]=resultado2.getString(1);
                    filas[5]=resultado3.getString(1);
                    filas[6]=resultado4.getString(2);
                    tabla.addRow(filas);
                }
            
                datos.setModel(tabla);
                conexion.close();
            }catch(SQLException e){
                System.out.println("Error: "+e);
            }finally{
                try {
                    conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConsultaEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("Error: "+ex);
                }
            }
        }
        
        if(tipo.equals("Fecha")){
            try{
                conexion=Conexion_BD.conectar();
                String consulta1= "SELECT cita.idCita, cita.fecha, cita.hora, cita.motivo, paciente_cita.idPaciente,"
                                  + " especialista_cita.idEspecialista,cita_precio.precio FROM cita, paciente_cita, "
                                  + "especialista_cita, cita_precio "
                                  + "WHERE cita.fecha LIKE"
                                  + '"' + id + "%" + '"'
                                  + "AND paciente_cita.idCita = cita.idCita "
                                  + "AND especialista_cita.idCita = cita.idCita "
                                  + "AND cita_precio.idCita = cita.idCita";
      
                sentencia_preparada1=conexion.prepareStatement(consulta1);
                resultado1=sentencia_preparada1.executeQuery();

            
                while(resultado1.next()){
                    filas[0]=resultado1.getString(1);
                    filas[1]=resultado1.getString(2);
                    filas[2]=resultado1.getString(3);
                    filas[3]=resultado1.getString(4);
                    filas[4]=resultado1.getString(5);
                    filas[5]=resultado1.getString(6);
                    filas[6]=resultado1.getString(7);
                }
            
                datos.setModel(tabla);
                conexion.close();
            }catch(SQLException e){
                System.out.println("Error: "+e);
            }finally{
                try {
                    conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConsultaEspecialista.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("Error: "+ex);
                }
            }
        }
        
        if(tipo.equals("Hora")){
            try{
                conexion=Conexion_BD.conectar();
                String consulta1="SELECT cita.idCita, cita.fecha, cita.hora, cita.motivo, paciente_cita.idPaciente,"
                                  + "especialista_cita.idEspecialista,cita_precio.precio FROM cita, paciente_cita, "
                                  + "especialista_cita, cita_precio "
                                  + "WHERE cita.hora LIKE"
                                  + '"' + id + "%" + '"'
                                  + "AND paciente_cita.idCita = cita.idCita "
                                  + "AND especialista_cita.idCita = cita.idCita "
                                  + "AND cita_precio.idCita = cita.idCita";
                sentencia_preparada1=conexion.prepareStatement(consulta1);
                resultado1=sentencia_preparada1.executeQuery();

            
                while(resultado1.next()){
                    filas[0]=resultado1.getString(1);
                    filas[1]=resultado1.getString(2);
                    filas[2]=resultado1.getString(3);
                    filas[3]=resultado1.getString(4);
                    filas[4]=resultado1.getString(5);
                    filas[5]=resultado1.getString(6);
                    filas[6]=resultado1.getString(7);
                    tabla.addRow(filas);
                }
            
                datos.setModel(tabla);
                conexion.close();
            }catch(SQLException e){
                System.out.println("Error: "+e);
            }finally{
                try {
                    conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConsultaEspecialista.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("Error: "+ex);
                }
            }
        }
        
        if(tipo.equals("Motivo")){
            try{
                conexion=Conexion_BD.conectar();
                String consulta1="SELECT cita.idCita, cita.fecha, cita.hora, cita.motivo, paciente_cita.idPaciente,"
                                  + "especialista_cita.idEspecialista,cita_precio.precio FROM cita, paciente_cita, "
                                  + "especialista_cita, cita_precio "
                                  + "WHERE cita.motivo LIKE"
                                  + '"' + id + "%" + '"'
                                  + "AND paciente_cita.idCita = cita.idCita "
                                  + "AND especialista_cita.idCita = cita.idCita "
                                  + "AND cita_precio.idCita = cita.idCita";
                sentencia_preparada1=conexion.prepareStatement(consulta1);
                resultado1=sentencia_preparada1.executeQuery();

            
                while(resultado1.next()){
                    filas[0]=resultado1.getString(1);
                    filas[1]=resultado1.getString(2);
                    filas[2]=resultado1.getString(3);
                    filas[3]=resultado1.getString(4);
                    filas[4]=resultado1.getString(5);
                    filas[5]=resultado1.getString(6);
                    filas[6]=resultado1.getString(7);
                    tabla.addRow(filas);
                }
            
                datos.setModel(tabla);
                conexion.close();
            }catch(SQLException e){
                System.out.println("Error: "+e);
            }finally{
                try {
                    conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConsultaEspecialista.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("Error: "+ex);
                }
            }
        }
        
        if(tipo.equals("idPaciente")){
            try{
                conexion=Conexion_BD.conectar();
                String consulta1="SELECT cita.idCita, cita.fecha, cita.hora, cita.motivo, paciente_cita.idPaciente,"
                                  + "especialista_cita.idEspecialista,cita_precio.precio FROM cita, paciente_cita, "
                                  + "especialista_cita, cita_precio "
                                  + "WHERE paciente_cita.idPaciente LIKE"
                                  + '"' + id + "%" + '"'
                                  + "AND paciente_cita.idCita = cita.idCita "
                                  + "AND especialista_cita.idCita = cita.idCita "
                                  + "AND cita_precio.idCita = cita.idCita";
                sentencia_preparada1=conexion.prepareStatement(consulta1);
                resultado1=sentencia_preparada1.executeQuery();

            
                while(resultado1.next()){
                    filas[0]=resultado1.getString(1);
                    filas[1]=resultado1.getString(2);
                    filas[2]=resultado1.getString(3);
                    filas[3]=resultado1.getString(4);
                    filas[4]=resultado1.getString(5);
                    filas[5]=resultado1.getString(6);
                    filas[6]=resultado1.getString(7);
                    tabla.addRow(filas);
                }
            
                datos.setModel(tabla);
                conexion.close();
            }catch(SQLException e){
                System.out.println("Error: "+e);
            }finally{
                try {
                    conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConsultaEspecialista.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("Error: "+ex);
                }
            }
        }
        
        if(tipo.equals("idEspecialista")){
            try{
                conexion=Conexion_BD.conectar();
                String consulta1="SELECT cita.idCita, cita.fecha, cita.hora, cita.motivo, paciente_cita.idPaciente,"
                                  + "especialista_cita.idEspecialista,cita_precio.precio FROM cita, paciente_cita, "
                                  + "especialista_cita, cita_precio "
                                  + "WHERE especialista_cita.idEspecialista LIKE"
                                  + '"' + id + "%" + '"'
                                  + "AND paciente_cita.idCita = cita.idCita "
                                  + "AND especialista_cita.idCita = cita.idCita "
                                  + "AND cita_precio.idCita = cita.idCita";
                sentencia_preparada1=conexion.prepareStatement(consulta1);
                resultado1=sentencia_preparada1.executeQuery();

            
                while(resultado1.next()){
                    filas[0]=resultado1.getString(1);
                    filas[1]=resultado1.getString(2);
                    filas[2]=resultado1.getString(3);
                    filas[3]=resultado1.getString(4);
                    filas[4]=resultado1.getString(5);
                    filas[5]=resultado1.getString(6);
                    filas[6]=resultado1.getString(7);
                    tabla.addRow(filas);
                }
            
                datos.setModel(tabla);
                conexion.close();
            }catch(SQLException e){
                System.out.println("Error: "+e);
            }finally{
                try {
                    conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConsultaEspecialista.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("Error: "+ex);
                }
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
        txtBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        datos = new javax.swing.JTable();
        txtvalidar = new javax.swing.JLabel();
        txtTipo = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(169, 195, 212));
        setPreferredSize(new java.awt.Dimension(1284, 720));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 48)); // NOI18N
        jLabel3.setText("Buscar");
        jLabel3.setToolTipText("");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 23, -1, -1));

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel4.setText("Ingrese el id de la Cita");
        jLabel4.setToolTipText("");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 78, 288, -1));

        txtBuscar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtBuscar.setToolTipText("");
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });
        add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, 499, 52));

        datos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "idCita", "Fecha", "Hora", "Motivo", "idPaciente", "idEspecialista", "Precio"
            }
        ));
        jScrollPane1.setViewportView(datos);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 190, 1260, 559));

        txtvalidar.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        add(txtvalidar, new org.netbeans.lib.awtextra.AbsoluteConstraints(695, 125, 299, 52));

        txtTipo.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "idCita", "Fecha", "Hora", "idPaciente", "idEspecialista" }));
        add(txtTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, 50));
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        // TODO add your handling code here:
        String tipo=txtTipo.getSelectedItem().toString();
        String id=txtBuscar.getText();
        busquedaFiltrada(tipo, id);
    }//GEN-LAST:event_txtBuscarKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable datos;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JComboBox<String> txtTipo;
    private javax.swing.JLabel txtvalidar;
    // End of variables declaration//GEN-END:variables
}
