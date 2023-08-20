package mysql;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Rojeru San
 */
public class BackupMy {

    private String obtenerFecha() {
        Calendar fecha = new GregorianCalendar();
        int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        String Fehca = dia + "-" + (mes + 1) + "-" + año;
        return Fehca;
    }

    int BUFFER = 10485760;

    public void exportDB(String nombreDB) {

        //nombre de usuario de la base de datos
        String mysqluser = "root";
        //password del usuario
        String mysqlpassword = "";
        //nombre de la base de datos
        String mysqldb = "doctolandia";
        //ruta donde se guardará el backup
        String path = "Respaldos/" + nombreDB + "_" + obtenerFecha() + ".sql";
        File existe = new File(path);
        RealizaBackup(path, mysqluser, mysqlpassword, mysqldb);
    }

    public void RealizaBackup(String path, String mysqluser, String mysqlpassword, String mysqldb) {
        String dumpCommand = "mysqldump -u" + mysqluser + " -p" + mysqlpassword + mysqldb;
        
        FileWriter fw = null;
        try {
            Runtime runtime = Runtime.getRuntime();
            File backupFile = new File(path);
            fw = new FileWriter(backupFile);
            Process child = runtime.exec(dumpCommand);
            InputStreamReader irs = new InputStreamReader(child.getInputStream());
            BufferedReader br = new BufferedReader(irs);
            String line;
            while ((line = br.readLine()) != null) {
                fw.write(line + "\n");
            }   fw.close();
            irs.close();
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(BackupMy.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(BackupMy.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
