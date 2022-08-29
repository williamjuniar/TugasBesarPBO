/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.DatabaseController.ControllerDosen;

import controller.DatabaseHandler;
import model.matakuliah.Nilai;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class NilaiController {
    static DatabaseHandler conn = new DatabaseHandler();
     public static ArrayList getNilaiMahasiswa(int idMk){
        conn.connect();
        String query = "SELECT * FROM hasil_studi_mahasiswa WHERE ID_MK='" + idMk +"'" ;
        ArrayList<Nilai> arrNilai = new ArrayList<>();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Nilai nilai = new Nilai();
                nilai.setNIM(rs.getString("NIM"));
                nilai.setNilai1(rs.getInt("N1"));
                nilai.setNilai2(rs.getInt("N2"));
                nilai.setNilai3(rs.getInt("N3"));
                nilai.setNilai4(rs.getInt("N4"));
                nilai.setNilai5(rs.getInt("N5"));
                nilai.setNilaiUAS(rs.getInt("N_UAS"));
                nilai.setNilaiAkhir(rs.getInt("NA"));
                nilai.setHurufMutu(rs.getString("Huruf"));
                arrNilai.add(nilai);
            }
            System.out.println("Log DB Get Nilai Matakuliah : Success");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arrNilai;
    }
    public static boolean updateNilaiMahasiswa(Nilai data,String idMK){
        conn.connect();
        String query = "UPDATE `hasil_studi_mahasiswa` SET " 
                + " `N1` = '" + data.getNilai1()+ "',"
                + " `N2` = '" + data.getNilai2() + "',"
                + " `N3` = '" + data.getNilai3() + "',"
                + " `N4` = '" + data.getNilai4() + "',"
                + " `N5` = '" + data.getNilai5() + "',"
                + " `N_UAS` = '" + data.getNilaiUAS() + "',"
                + "`NA` = '" +  data.getNilaiAkhir() + "',"
                + " `Huruf` = '" +  data.getHurufMutu() + "' WHERE `ID_MK` = '" + idMK + "' and `NIM`='" + data.getNIM() + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            System.out.println("Log DB Update Daak : Success " + query );
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
             System.out.println("Error Update Daak : " + e.getMessage());
            return (false);
        }     
       
    }
}
