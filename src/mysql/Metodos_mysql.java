/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysql;

import Alertas.Exito;
import Alertas.Error;
import Interfaz.Menu;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Gibran Ramses
 */
public class Metodos_mysql {

    private static Connection conexion;
    private static PreparedStatement sentencia_preparada;
    private static ResultSet resultado;
    private static PreparedStatement sentencia_preparada2;
    private static PreparedStatement sentencia_preparada3;
    private static PreparedStatement sentencia_preparada4;
    Exito exito = new Exito(null, true);
    Error error = new Error(null, true);
  
    
    public void agregar_especialista(int idEspecialista, String nombre, String apePa, String apeMa,
                                     String especializacion, String telefono, String correo, String calle,
                                     String numero, String colonia, String cp, String ciudad ){
        
        try{
            conexion=Conexion_BD.conectar();
            String consulta1=("INSERT INTO especialista(idEspecialista,nombre,apePa,apeMa,calle,numero,"
                               + "colonia,cp,ciudad) VALUES(?,?,?,?,?,?,?,?,?)");
            sentencia_preparada=conexion.prepareStatement(consulta1);
            sentencia_preparada.setInt(1,idEspecialista);
            sentencia_preparada.setString(2,nombre);
            sentencia_preparada.setString(3,apePa);
            sentencia_preparada.setString(4,apeMa);
            sentencia_preparada.setString(5,calle);
            sentencia_preparada.setString(6,numero);
            sentencia_preparada.setString(7,colonia);
            sentencia_preparada.setString(8,cp);
            sentencia_preparada.setString(9,ciudad);
            int a= sentencia_preparada.executeUpdate();
                    
            String consulta2=("INSERT INTO especialista_especializacion (idEspecialista,especializacion) VALUES(?,?)");
            sentencia_preparada=conexion.prepareStatement(consulta2);
            sentencia_preparada.setInt(1,idEspecialista);
            sentencia_preparada.setString(2,especializacion);
            int b= sentencia_preparada.executeUpdate();
            
            String consulta3=("INSERT INTO especialista_telefono (idEspecialista,telefono) VALUES(?,?)");
            sentencia_preparada=conexion.prepareStatement(consulta3);
            sentencia_preparada.setInt(1,idEspecialista);
            sentencia_preparada.setString(2,telefono);
            int c= sentencia_preparada.executeUpdate();
            
            String consulta4=("INSERT INTO especialista_correo (idEspecialista,correo) VALUES(?,?)");
            sentencia_preparada=conexion.prepareStatement(consulta4);
            sentencia_preparada.setInt(1,idEspecialista);
            sentencia_preparada.setString(2,correo);
            int d= sentencia_preparada.executeUpdate();
            
            if(a>0&&b>0&c>0&&d>0){
                exito.ms.setText("Datos Guardados");
                exito.setVisible(true);         
            }
            
            conexion.close();
            
        }catch(HeadlessException | SQLException e){
                System.out.println("Error: "+e);
                error.ms.setText("Error al Guardar datos");
                error.setVisible(true); 
        } finally{
            try{
                conexion.close();
            }catch(SQLException e){
                System.out.println("Error: "+e);
            }
        }
    }
    
    public void agregar_empleado(int idEmpleado, String nombre, String apePa, String apeMa,
                                     String telefono, String correo, String calle,
                                     String numero, String colonia, String cp, String ciudad ){
        
        try{
            conexion=Conexion_BD.conectar();
            String consulta1=("INSERT INTO empleado(idEmpleado,nombre,apePa,apeMa,calle,numero,"
                               + "colonia,cp,ciudad) VALUES(?,?,?,?,?,?,?,?,?)");
            sentencia_preparada=conexion.prepareStatement(consulta1);
            sentencia_preparada.setInt(1,idEmpleado);
            sentencia_preparada.setString(2,nombre);
            sentencia_preparada.setString(3,apePa);
            sentencia_preparada.setString(4,apeMa);
            sentencia_preparada.setString(5,calle);
            sentencia_preparada.setString(6,numero);
            sentencia_preparada.setString(7,colonia);
            sentencia_preparada.setString(8,cp);
            sentencia_preparada.setString(9,ciudad);
            int a= sentencia_preparada.executeUpdate();
            
            String consulta2=("INSERT INTO empleado_telefono (idEmpleado,telefono) VALUES(?,?)");
            sentencia_preparada=conexion.prepareStatement(consulta2);
            sentencia_preparada.setInt(1,idEmpleado);
            sentencia_preparada.setString(2,telefono);
            int b= sentencia_preparada.executeUpdate();
            
            String consulta3=("INSERT INTO empleado_correo (idEmpleado,correo) VALUES(?,?)");
            sentencia_preparada=conexion.prepareStatement(consulta3);
            sentencia_preparada.setInt(1,idEmpleado);
            sentencia_preparada.setString(2,correo);
            int c= sentencia_preparada.executeUpdate();
            
            if(a>0&&b>0&&c>0){
                exito.ms.setText("Datos Guardados");
                exito.setVisible(true); 
                
            }
    
            conexion.close();
            
        }catch(HeadlessException | SQLException e){
                System.out.println("Error: "+e);
                error.ms.setText("Error al Guardar datos");
                error.setVisible(true); 
        } finally{
            try{
                conexion.close();
            }catch(SQLException e){
                System.out.println("Error: "+e);
            }
        }
    }
     
    public void agregar_paciente(int idPaciente, String nombre, String apePa, String apeMa,
                                     String telefono, String correo, String calle,
                                     String numero, String colonia, String cp, String ciudad ){
        
        try{
            conexion=Conexion_BD.conectar();
            String consulta1=("INSERT INTO paciente(idPaciente,nombre,apePa,apeMa,calle,numero,"
                               + "colonia,cp,ciudad) VALUES(?,?,?,?,?,?,?,?,?)");
            sentencia_preparada=conexion.prepareStatement(consulta1);
            sentencia_preparada.setInt(1,idPaciente);
            sentencia_preparada.setString(2,nombre);
            sentencia_preparada.setString(3,apePa);
            sentencia_preparada.setString(4,apeMa);
            sentencia_preparada.setString(5,calle);
            sentencia_preparada.setString(6,numero);
            sentencia_preparada.setString(7,colonia);
            sentencia_preparada.setString(8,cp);
            sentencia_preparada.setString(9,ciudad);
            int a= sentencia_preparada.executeUpdate();
            
            String consulta2=("INSERT INTO paciente_telefono (idPaciente,telefono) VALUES(?,?)");
            sentencia_preparada=conexion.prepareStatement(consulta2);
            sentencia_preparada.setInt(1,idPaciente);
            sentencia_preparada.setString(2,telefono);
            int b= sentencia_preparada.executeUpdate();
            
            String consulta3=("INSERT INTO paciente_correo (idPaciente,correo) VALUES(?,?)");
            sentencia_preparada=conexion.prepareStatement(consulta3);
            sentencia_preparada.setInt(1,idPaciente);
            sentencia_preparada.setString(2,correo);
            int c= sentencia_preparada.executeUpdate();
            
            if(a>0&&b>0&&c>0){
                exito.ms.setText("Datos Guardados");
                exito.setVisible(true); 
                
            }
    
            conexion.close();
            
        }catch(HeadlessException | SQLException e){
                System.out.println("Error: "+e);
                error.ms.setText("Error al Guardar datos");
                error.setVisible(true); 
        } finally{
            try{
                conexion.close();
            }catch(SQLException e){
                System.out.println("Error: "+e);
            }
        }
    }
    
    public void agregar_cita(int idCita, String fecha, String hora, String motivo,
                                     String idPaciente, String idEspecialista, String precio){
        
        try{
            conexion=Conexion_BD.conectar();
            String consulta1=("INSERT INTO cita(idCita,fecha,hora,motivo) VALUES(?,?,?,?)");
            sentencia_preparada=conexion.prepareStatement(consulta1);
            sentencia_preparada.setInt(1,idCita);
            sentencia_preparada.setString(2,fecha);
            sentencia_preparada.setString(3,hora);
            sentencia_preparada.setString(4,motivo);
            int a= sentencia_preparada.executeUpdate();
                    
            String consulta2=("INSERT INTO paciente_cita (idPaciente,idCita) VALUES(?,?)");
            sentencia_preparada=conexion.prepareStatement(consulta2);
            sentencia_preparada.setString(1,idPaciente);
            sentencia_preparada.setInt(2,idCita);
            int b= sentencia_preparada.executeUpdate();
            
            String consulta3=("INSERT INTO especialista_cita (idEspecialista,idCita) VALUES(?,?)");
            sentencia_preparada=conexion.prepareStatement(consulta3);
            sentencia_preparada.setString(1,idEspecialista);
            sentencia_preparada.setInt(2,idCita);
            int c= sentencia_preparada.executeUpdate();
            
            String consulta4=("INSERT INTO cita_precio (idCita,precio) VALUES(?,?)");
            sentencia_preparada=conexion.prepareStatement(consulta4);
            sentencia_preparada.setInt(1,idCita);
            sentencia_preparada.setString(2,precio);
            int d= sentencia_preparada.executeUpdate();
            
            if(a>0&&b>0&c>0&&d>0){
                exito.ms.setText("Datos Guardados");
                exito.setVisible(true);         
            }
            
            conexion.close();
            
        }catch(HeadlessException | SQLException e){
                System.out.println("Error: "+e);
                error.ms.setText("Error al Guardar datos");
                error.setVisible(true); 
        } finally{
            try{
                conexion.close();
            }catch(SQLException e){
                System.out.println("Error: "+e);
            }
        }
    }
    
    public static String buscar_idEspecialista(String idEspecialista){
        String mensaje=null;
        
        try{
            conexion= Conexion_BD.conectar();
            String consulta="SELECT idEspecialista FROM especialista WHERE idEspecialista=? ";
            sentencia_preparada=conexion.prepareStatement(consulta);
            sentencia_preparada.setString(1,idEspecialista);
            resultado=sentencia_preparada.executeQuery();
            
            if(resultado.next()){
                mensaje="Existe ID";
            }else{
                mensaje="No Existe ID";
            }
            conexion.close();
        }catch(SQLException e){
            System.out.println("Error: "+e);
        }finally{
            try{
                conexion.close();
            }catch(SQLException ex){
                Logger.getAnonymousLogger(Metodos_mysql.class.getName()).log(Level.SEVERE,null,ex);
            }
        }
        return mensaje;   
    }
    
    public static String buscar_idEmpleado(String idEmpleado){
        String mensaje=null;
        
        try{
            conexion= Conexion_BD.conectar();
            String consulta="SELECT idEmpleado FROM empleado WHERE idEmpleado=? ";
            sentencia_preparada=conexion.prepareStatement(consulta);
            sentencia_preparada.setString(1,idEmpleado);
            resultado=sentencia_preparada.executeQuery();
            
            if(resultado.next()){
                mensaje="Existe ID";
                
            }else{
                mensaje="No Existe ID";
            }
            conexion.close();
        }catch(SQLException e){
            System.out.println("Error: "+e);
        }finally{
            try{
                conexion.close();
            }catch(SQLException ex){
                Logger.getAnonymousLogger(Metodos_mysql.class.getName()).log(Level.SEVERE,null,ex);
            }
        }
        return mensaje;   
    }
    
    public static String buscar_idPaciente(String idPaciente){
        String mensaje=null;
        
        try{
            conexion= Conexion_BD.conectar();
            String consulta="SELECT idPaciente FROM paciente WHERE idPaciente=? ";
            sentencia_preparada=conexion.prepareStatement(consulta);
            sentencia_preparada.setString(1,idPaciente);
            resultado=sentencia_preparada.executeQuery();
            
            if(resultado.next()){
                mensaje="Existe ID";
            }else{
                mensaje="No Existe ID";
            }
            conexion.close();
        }catch(SQLException e){
            System.out.println("Error: "+e);
        }finally{
            try{
                conexion.close();
            }catch(SQLException ex){
                Logger.getAnonymousLogger(Metodos_mysql.class.getName()).log(Level.SEVERE,null,ex);
            }
        }
        return mensaje;   
    }
    
    public static String buscar_idCita(String idCita){
        String mensaje=null;
        
        try{
            conexion= Conexion_BD.conectar();
            String consulta="SELECT idCita FROM cita WHERE idCita=? ";
            sentencia_preparada=conexion.prepareStatement(consulta);
            sentencia_preparada.setString(1,idCita);
            resultado=sentencia_preparada.executeQuery();
            
            if(resultado.next()){
                mensaje="Existe ID";
            }else{
                mensaje="No Existe ID";
            }
            conexion.close();
        }catch(SQLException e){
            System.out.println("Error: "+e);
        }finally{
            try{
                conexion.close();
            }catch(SQLException ex){
                Logger.getAnonymousLogger(Metodos_mysql.class.getName()).log(Level.SEVERE,null,ex);
            }
        }
        return mensaje;   
    }
    
    public void modificar_especialista(String nombre, String apePa, String apeMa, String especializacion,
                          String telefono, String correo, String calle, String numero, String colonia, 
                          String cp, String ciudad,int idEspecialista ){
        try{
            conexion=Conexion_BD.conectar();
            String consulta1=("UPDATE especialista SET nombre=?,apePa=?,apeMa=?,calle=?,numero=?,"
                               + "colonia=?,cp=?,ciudad=? WHERE idEspecialista=?");
            sentencia_preparada=conexion.prepareStatement(consulta1);
            sentencia_preparada.setString(1,nombre);
            sentencia_preparada.setString(2,apePa);
            sentencia_preparada.setString(3,apeMa);
            sentencia_preparada.setString(4,calle);
            sentencia_preparada.setString(5,numero);
            sentencia_preparada.setString(6,colonia);
            sentencia_preparada.setString(7,cp);
            sentencia_preparada.setString(8,ciudad);
            sentencia_preparada.setInt(9,idEspecialista);
            int a= sentencia_preparada.executeUpdate();
                    
            String consulta2=("UPDATE especialista_especializacion SET especializacion=?"
                              + "WHERE idEspecialista=?");
            sentencia_preparada=conexion.prepareStatement(consulta2);
            sentencia_preparada.setString(1,especializacion);
            sentencia_preparada.setInt(2,idEspecialista);
            int b= sentencia_preparada.executeUpdate();
            
            String consulta3=("UPDATE especialista_telefono SET telefono=?"
                              + "WHERE idEspecialista=?");
            sentencia_preparada=conexion.prepareStatement(consulta3);
            sentencia_preparada.setString(1,telefono);
            sentencia_preparada.setInt(2,idEspecialista);
            int c= sentencia_preparada.executeUpdate();
            
            String consulta4=("UPDATE especialista_correo SET correo=?"
                              + "WHERE idEspecialista=?");
            sentencia_preparada=conexion.prepareStatement(consulta4);
            sentencia_preparada.setString(1,correo);
            sentencia_preparada.setInt(2,idEspecialista);
            int d= sentencia_preparada.executeUpdate();
                                
            if(a>0&&b>0&&c>0&&d>0){
                exito.ms.setText("Datos Modificados");
                exito.setVisible(true); 
                
            }
            
            conexion.close();
            
        }catch(HeadlessException | SQLException e){
                System.out.println("Error: "+e);
                error.ms.setText("Error al Modificar datos");
                error.setVisible(true); 
        } finally{
            try{
                conexion.close();
            }catch(SQLException e){
                System.out.println("Error: "+e);
            }
        }
    }
    
    public void modificar_empleado(String nombre, String apePa, String apeMa, String telefono, 
                                   String correo, String calle, String numero, String colonia, 
                                   String cp, String ciudad,int idEmpleado ){
        try{
            conexion=Conexion_BD.conectar();
            String consulta1=("UPDATE empleado SET nombre=?,apePa=?,apeMa=?,calle=?,numero=?,"
                               + "colonia=?,cp=?,ciudad=? WHERE idEmpleado=?");
            sentencia_preparada=conexion.prepareStatement(consulta1);
            sentencia_preparada.setString(1,nombre);
            sentencia_preparada.setString(2,apePa);
            sentencia_preparada.setString(3,apeMa);
            sentencia_preparada.setString(4,calle);
            sentencia_preparada.setString(5,numero);
            sentencia_preparada.setString(6,colonia);
            sentencia_preparada.setString(7,cp);
            sentencia_preparada.setString(8,ciudad);
            sentencia_preparada.setInt(9,idEmpleado);
            int a= sentencia_preparada.executeUpdate();
        
            String consulta2=("UPDATE empleado_telefono SET telefono=?"
                              + "WHERE idEmpleado=?");
            sentencia_preparada=conexion.prepareStatement(consulta2);
            sentencia_preparada.setString(1,telefono);
            sentencia_preparada.setInt(2,idEmpleado);
            int b= sentencia_preparada.executeUpdate();
            
            String consulta3=("UPDATE empleado_correo SET correo=?"
                              + "WHERE idEmpleado=?");
            sentencia_preparada=conexion.prepareStatement(consulta3);
            sentencia_preparada.setString(1,correo);
            sentencia_preparada.setInt(2,idEmpleado);
            int c= sentencia_preparada.executeUpdate();
                                
            if(a>0&&b>0&&c>0){
                exito.ms.setText("Datos Modificados");
                exito.setVisible(true); 
                
            }
            
            conexion.close();
            
        }catch(HeadlessException | SQLException e){
                System.out.println("Error: "+e);
                error.ms.setText("Error al Modificar datos");
                error.setVisible(true); 
        } finally{
            try{
                conexion.close();
            }catch(SQLException e){
                System.out.println("Error: "+e);
            }
        }
    }
    
        public void modificar_paciente(String nombre, String apePa, String apeMa, String telefono, 
                                   String correo, String calle, String numero, String colonia, 
                                   String cp, String ciudad,int idPaciente ){
        try{
            conexion=Conexion_BD.conectar();
            String consulta1=("UPDATE paciente SET nombre=?,apePa=?,apeMa=?,calle=?,numero=?,"
                               + "colonia=?,cp=?,ciudad=? WHERE idPaciente=?");
            sentencia_preparada=conexion.prepareStatement(consulta1);
            sentencia_preparada.setString(1,nombre);
            sentencia_preparada.setString(2,apePa);
            sentencia_preparada.setString(3,apeMa);
            sentencia_preparada.setString(4,calle);
            sentencia_preparada.setString(5,numero);
            sentencia_preparada.setString(6,colonia);
            sentencia_preparada.setString(7,cp);
            sentencia_preparada.setString(8,ciudad);
            sentencia_preparada.setInt(9,idPaciente);
            int a= sentencia_preparada.executeUpdate();
        
            String consulta2=("UPDATE paciente_telefono SET telefono=?"
                              + "WHERE idPaciente=?");
            sentencia_preparada=conexion.prepareStatement(consulta2);
            sentencia_preparada.setString(1,telefono);
            sentencia_preparada.setInt(2,idPaciente);
            int b= sentencia_preparada.executeUpdate();
            
            String consulta3=("UPDATE paciente_correo SET correo=?"
                              + "WHERE idPaciente=?");
            sentencia_preparada=conexion.prepareStatement(consulta3);
            sentencia_preparada.setString(1,correo);
            sentencia_preparada.setInt(2,idPaciente);
            int c= sentencia_preparada.executeUpdate();
                                
            if(a>0&&b>0&&c>0){
                exito.ms.setText("Datos Modificados");
                exito.setVisible(true); 
            }
            
            conexion.close();
            
        }catch(HeadlessException | SQLException e){
                System.out.println("Error: "+e);
                error.ms.setText("Error al Modificar datos");
                error.setVisible(true);
        } finally{
            try{
                conexion.close();
            }catch(SQLException e){
                System.out.println("Error: "+e);
            }
        }
    }
        
       public void modificar_cita(String hora, String fecha, String motivo, String idPaciente,
                          String idEspecialista, String precio, int idCita ){
        try{
            conexion=Conexion_BD.conectar();
            String consulta1=("UPDATE cita SET fecha=?, hora=?, motivo=?"
                               + "WHERE idCita=?");
            sentencia_preparada=conexion.prepareStatement(consulta1);
            sentencia_preparada.setString(1,hora);
            sentencia_preparada.setString(2,fecha);
            sentencia_preparada.setString(3,motivo);
            sentencia_preparada.setInt(4,idCita);
            int a= sentencia_preparada.executeUpdate();
                    
            String consulta2=("UPDATE paciente_cita SET idPaciente=?"
                              + "WHERE idCita=?");
            sentencia_preparada=conexion.prepareStatement(consulta2);
            sentencia_preparada.setString(1,idPaciente);
            sentencia_preparada.setInt(2,idCita);
            int b= sentencia_preparada.executeUpdate();
            
            String consulta3=("UPDATE especialista_cita SET idEspecialista=?"
                              + "WHERE idCita=?");
            sentencia_preparada=conexion.prepareStatement(consulta3);
            sentencia_preparada.setString(1,idEspecialista);
            sentencia_preparada.setInt(2,idCita);
            int c= sentencia_preparada.executeUpdate();
            
            String consulta4=("UPDATE cita_precio SET precio=?"
                              + "WHERE idCita=?");
            sentencia_preparada=conexion.prepareStatement(consulta4);
            sentencia_preparada.setString(1,precio);
            sentencia_preparada.setInt(2,idCita);
            int d= sentencia_preparada.executeUpdate();
                                
            if(a>0&&b>0&&c>0&&d>0){
                exito.ms.setText("Datos Modificados");
                exito.setVisible(true); 
                
            }
            
            conexion.close();
            
        }catch(HeadlessException | SQLException e){
                System.out.println("Error: "+e);
                error.ms.setText("Error al Modificar datos");
                error.setVisible(true); 
        } finally{
            try{
                conexion.close();
            }catch(SQLException e){
                System.out.println("Error: "+e);
            }
        }
    }
    
    public void eliminar_especialista(String idEspecialista){
        try{
            conexion= Conexion_BD.conectar();
            String consulta= "DELETE FROM especialista WHERE idEspecialista=?";
            sentencia_preparada=conexion.prepareStatement(consulta);
            sentencia_preparada.setString(1,idEspecialista);
            int r1=sentencia_preparada.executeUpdate();
            
            String consulta2= "DELETE FROM especialista_especializacion WHERE idEspecialista=?";
            sentencia_preparada2=conexion.prepareStatement(consulta2);
            sentencia_preparada2.setString(1,idEspecialista);
            int r2=sentencia_preparada2.executeUpdate();
            
            String consulta3= "DELETE FROM especialista_telefono WHERE idEspecialista=?";
            sentencia_preparada3=conexion.prepareStatement(consulta3);
            sentencia_preparada3.setString(1,idEspecialista);
            int r3=sentencia_preparada3.executeUpdate();
            
            String consulta4= "DELETE FROM especialista_correo WHERE idEspecialista=?";
            sentencia_preparada4=conexion.prepareStatement(consulta4);
            sentencia_preparada4.setString(1,idEspecialista);
            int r4=sentencia_preparada4.executeUpdate();
            
            if(r1>0&&r2>0&&r3>0&&r4>0){
                exito.ms.setText("Registro eliminado correctamente");
                exito.setVisible(true); 
            }   
            conexion.close();
            
        }catch(HeadlessException|SQLException e){
            System.out.println("Error: "+e);
             error.ms.setText("No se pudo eliminar el registro");
             error.setVisible(true); 
        }finally{
            try {
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(Metodos_mysql.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Error: "+ex);
            }
        }
    }
    
    public void eliminar_empleado(String idEmpleado){
        try{
            conexion= Conexion_BD.conectar();
            String consulta= "DELETE FROM empleado WHERE idEmpleado=?";
            sentencia_preparada=conexion.prepareStatement(consulta);
            sentencia_preparada.setString(1,idEmpleado);
            int r1=sentencia_preparada.executeUpdate();
            
            String consulta2= "DELETE FROM empleado_telefono WHERE idEmpleado=?";
            sentencia_preparada2=conexion.prepareStatement(consulta2);
            sentencia_preparada2.setString(1,idEmpleado);
            int r2=sentencia_preparada2.executeUpdate();
            
            String consulta3= "DELETE FROM empleado_correo WHERE idEmpleado=?";
            sentencia_preparada3=conexion.prepareStatement(consulta3);
            sentencia_preparada3.setString(1,idEmpleado);
            int r3=sentencia_preparada3.executeUpdate();
            
            if(r1>0&&r2>0&&r3>0){
                exito.ms.setText("Registro eliminado correctamente");
                exito.setVisible(true); 
            }
            
            conexion.close();
            
        }catch(HeadlessException|SQLException e){
            System.out.println("Error: "+e);
            error.ms.setText("No se pudo eliminar el registro");
            error.setVisible(true); 
        }finally{
            try {
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(Metodos_mysql.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Error: "+ex);
            }
        }
    }
    
    public void eliminar_paciente(String idPaciente){
        try{
            conexion= Conexion_BD.conectar();
            String consulta= "DELETE FROM paciente WHERE idPaciente=?";
            sentencia_preparada=conexion.prepareStatement(consulta);
            sentencia_preparada.setString(1,idPaciente);
            int r1=sentencia_preparada.executeUpdate();
            
            String consulta2= "DELETE FROM paciente_telefono WHERE idPaciente=?";
            sentencia_preparada2=conexion.prepareStatement(consulta2);
            sentencia_preparada2.setString(1,idPaciente);
            int r2=sentencia_preparada2.executeUpdate();
            
            String consulta3= "DELETE FROM paciente_correo WHERE idPaciente=?";
            sentencia_preparada3=conexion.prepareStatement(consulta3);
            sentencia_preparada3.setString(1,idPaciente);
            int r3=sentencia_preparada3.executeUpdate();
            
            if(r1>0&&r2>0&&r3>0){
                exito.ms.setText("Registro eliminado correctamente");
                exito.setVisible(true); 
            }
            
            conexion.close();
            
        }catch(HeadlessException|SQLException e){
            System.out.println("Error: "+e);
            error.ms.setText("No se pudo eliminar el registro");
            error.setVisible(true); 
        }finally{
            try {
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(Metodos_mysql.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Error: "+ex);
            }
        }
    }
    
     public void eliminar_cita(String idCita){
        try{
            conexion= Conexion_BD.conectar();
            String consulta= "DELETE FROM cita WHERE idCita=?";
            sentencia_preparada=conexion.prepareStatement(consulta);
            sentencia_preparada.setString(1,idCita);
            int r1=sentencia_preparada.executeUpdate();
            
            String consulta2= "DELETE FROM paciente_cita WHERE idCita=?";
            sentencia_preparada2=conexion.prepareStatement(consulta2);
            sentencia_preparada2.setString(1,idCita);
            int r2=sentencia_preparada2.executeUpdate();
            
            String consulta3= "DELETE FROM especialista_cita WHERE idCita=?";
            sentencia_preparada3=conexion.prepareStatement(consulta3);
            sentencia_preparada3.setString(1,idCita);
            int r3=sentencia_preparada3.executeUpdate();
            
            String consulta4= "DELETE FROM cita_precio WHERE idCita=?";
            sentencia_preparada4=conexion.prepareStatement(consulta4);
            sentencia_preparada4.setString(1,idCita);
            int r4=sentencia_preparada4.executeUpdate();
            
            if(r1>0&&r2>0&&r3>0&&r4>0){
                exito.ms.setText("Registro eliminado correctamente");
                exito.setVisible(true); 
            }   
            conexion.close();
            
        }catch(HeadlessException|SQLException e){
            System.out.println("Error: "+e);
             error.ms.setText("No se pudo eliminar el registro");
             error.setVisible(true); 
        }finally{
            try {
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(Metodos_mysql.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Error: "+ex);
            }
        }
    }
    
    public static String usuarioLogin(String usuario, String contraseña){
        String mensaje=null;
        try{
            conexion = Conexion_BD.conectar();
            String consulta = "SELECT usuario, contraseña FROM usuarios WHERE usuario=? AND contraseña=?";
            sentencia_preparada = conexion.prepareStatement(consulta);
            sentencia_preparada.setString(1,usuario);
            sentencia_preparada.setString(2,contraseña);
            resultado = sentencia_preparada.executeQuery();
            if(resultado.next()){
                mensaje="Correcto";
            }else{
                mensaje="Incorrecto";
            }
            
            conexion.close();
            
        }catch(Exception e){
            System.out.println("Error: " + e);
        }finally{
            try {
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(Metodos_mysql.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Error: " + ex);
            }
        }
        
        return mensaje;
    }
}
