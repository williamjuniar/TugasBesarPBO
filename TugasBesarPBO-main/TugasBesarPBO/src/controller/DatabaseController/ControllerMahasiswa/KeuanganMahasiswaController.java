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
import model.matakuliah.Kehadiran;
import model.transaksi.KategoriTransaksi;
import model.transaksi.Transaksi;
import model.user.Mahasiswa;

/**
 *
 * @author 1119038 Elangel Neilea Shaday
 */
public class KeuanganMahasiswaController {
    static DatabaseHandler conn = new DatabaseHandler();
    public static ArrayList getRosterMahasiswa(int idMk, String nim){
        conn.connect();
        String query = "SELECT * FROM daftar_hadir_mahasiswa WHERE ID_MK='" + idMk + "' and NIM ='" + nim + "'" ;
        ArrayList<Transaksi> transaction = new ArrayList<>();
        ArrayList<KategoriTransaksi> kategori = new ArrayList<>();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Mahasiswa mhs = new Mahasiswa();
                Transaksi bayar = new Transaksi();
                //bayar.setMhs(rs.getString(2));
                bayar.setTanggalTransaksi(rs.getString(4));
                bayar.setJumlahBayar(rs.getInt(5));
            }
            System.out.println("Log DB Get Matakuliah : Success");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
