/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysql;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Gibran Ramses
 */
public class Conexion_BD {
        private static String URL="jdbc:mysql://localhost:33065/doctolandia";
        private static String Usuario="root";
        private static String Contraseña="";
        
        public static Connection conectar(){
            Connection conexion=null;
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                conexion=DriverManager.getConnection(URL,Usuario,Contraseña);
                System.out.println("Conexion establecida");
            }catch(ClassNotFoundException | SQLException e){
                System.out.println("Error: "+e);
            }
            return conexion;
        }
}
