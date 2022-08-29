/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.DatabaseController.ControllerMahasiswa;

import controller.DatabaseHandler;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.enums.JenisMatakuliah;
import model.enums.SifatMatakuliah;
import model.matakuliah.Kehadiran;
import model.matakuliah.Matakuliah;

/**
 *
 * @author 1119038 Elangel Neilea Shaday
 */
public class KehadiranMahasiswaController {
    static DatabaseHandler conn = new DatabaseHandler();
    public static ArrayList getRosterMahasiswa(int idMk, String nim){
        conn.connect();
        String query = "SELECT * FROM daftar_hadir_mahasiswa WHERE ID_MK='" + idMk + "' and NIM ='" + nim + "'" ;
        ArrayList<Kehadiran> arrKehadiran = new ArrayList<>();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Kehadiran kehadiran = new Kehadiran();
                kehadiran.setNIM(rs.getString("NIM"));
                kehadiran.setKeterangan(rs.getString("Status"));
                kehadiran.setID_Roster(rs.getInt("ID_Roster"));
                arrKehadiran.add(kehadiran);
            }
            System.out.println("Log DB Get Matakuliah : Success");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arrKehadiran;
    }
}
