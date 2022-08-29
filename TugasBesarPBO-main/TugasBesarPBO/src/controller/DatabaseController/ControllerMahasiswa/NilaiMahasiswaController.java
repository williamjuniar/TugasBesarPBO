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
import model.matakuliah.Nilai;

/**
 *
 * @author 1119038 Elangel Neilea Shaday
 */
public class NilaiMahasiswaController {
    static DatabaseHandler conn = new DatabaseHandler();
     public static Nilai getNilaiMahasiswa(int idMk, String nim){
        conn.connect();
        String query = "SELECT * FROM hasil_studi_mahasiswa WHERE ID_MK='" + idMk + "' and NIM ='" + nim + "'" ;
        Nilai nilai = null;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                nilai = new Nilai();
                nilai.setNIM(rs.getString("NIM"));
                nilai.setNilai1(rs.getInt("N1"));
                nilai.setNilai2(rs.getInt("N2"));
                nilai.setNilai3(rs.getInt("N3"));
                nilai.setNilai4(rs.getInt("N4"));
                nilai.setNilai5(rs.getInt("N5"));
                nilai.setNilaiUAS(rs.getInt("N_UAS"));
                nilai.setNilaiAkhir(rs.getInt("NA"));
                nilai.setHurufMutu(rs.getString("Huruf"));
             
            }
            System.out.println("Log DB Get Nilai Matakuliah : Success");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nilai;
    }
}
