/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.DatabaseController.ControllerDosen;

import controller.DatabaseHandler;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.matakuliah.Kehadiran;

/**
 *
 * @author ASUS
 */
public class RosterController {
    static DatabaseHandler conn = new DatabaseHandler();
    public static ArrayList getArrayDaftarHadirMhs(String idMK){
        conn.connect();
        String query = "SELECT * FROM daftar_hadir_mahasiswa WHERE ID_MK='" + idMK + "'";
                
        ArrayList<Kehadiran> arrDetailKehadiran = new ArrayList<>();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Kehadiran kehadiran = new Kehadiran();
                kehadiran.setNIM(rs.getString("NIM")); 
                kehadiran.setKeterangan(rs.getString("Status"));
                arrDetailKehadiran.add(kehadiran);
            }
            System.out.println("Log DB Get RKehadiran MHS : Success");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arrDetailKehadiran;
    }
    
}
