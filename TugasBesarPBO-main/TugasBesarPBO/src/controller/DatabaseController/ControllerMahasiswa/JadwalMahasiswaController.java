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
import java.util.Date;
import model.matakuliah.Nilai;
import model.matakuliah.Roster;

/**
 *
 * @author 1119038 Elangel Neilea Shaday
 */
public class JadwalMahasiswaController {
    static DatabaseHandler conn = new DatabaseHandler();
      public static ArrayList<Roster> getJadwalMahasiswa(int idMk, Date TanggalAwal, Date TanggalAkhir){
        conn.connect();
        java.sql.Date sqlDatePertama = new java.sql.Date(TanggalAwal.getTime());
        java.sql.Date sqlDateAkhir = new java.sql.Date(TanggalAkhir.getTime());
        String query = "SELECT * FROM daftar_roster_matakuliah WHERE ID_MK='" + idMk + "' AND  Tanggal  BETWEEN '" + sqlDatePertama + "' AND '" + sqlDateAkhir + "'";
        ArrayList<Roster> roster = new ArrayList<>();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Roster tempRoster = new Roster();
                tempRoster.setTanggal(rs.getDate(3));
                tempRoster.setRuangan(rs.getString(4));
                tempRoster.setJamMulai(rs.getString(5));
                tempRoster.setJamSelesai(rs.getString(6));
                tempRoster.setStatusDosen(rs.getBoolean(7));
                roster.add(tempRoster);
            }
            System.out.println("Log DB Get Jadwal Matakuliah : Success");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Script" + query);
        }
        return roster;
    }
}
