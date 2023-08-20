/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mysql;

import java.io.*;

/**
 *
 * @author Gibran Ramses
 */
public class BackupMySQL {
    
    private static BackupMySQL instancia;
    
    public void crearBackup() throws IOException{
        Process proceso = Runtime.getRuntime().exec("C:\\xampp\\mysql\\bin\\mysqldump -u root -p doctolandia");
        InputStream entrada = proceso.getInputStream();
        FileOutputStream archivo = new FileOutputStream("Prueba.sql");
        
        byte[] buffer = new byte[10000];
        int byteLeido = entrada.read(buffer);
        
        while(byteLeido > 0){
            archivo.write(buffer, 0, byteLeido);
            byteLeido = entrada.read(buffer);
        }
        archivo.close();
    }
    
    public static BackupMySQL getInstance(){
        if(instancia == null){
            instancia = new BackupMySQL();
        }
        return instancia;
    }
}
