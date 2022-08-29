/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.DatabaseController;

import controller.DatabaseHandler;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.user.Daak;
import model.user.Dosen;
import model.user.Mahasiswa;
import model.user.User;

/**
 *
 * @author 1119038 Elangel Neilea Shaday
 */
public class LoginController {
    static DatabaseHandler conn = new DatabaseHandler();
    public static User searchUser(String email, String password){
        String pwd = User.getSHA(password);
        String idUser = getUser(email, pwd);
        
        if(getDaak(idUser) != null){
            Daak daak = getDaak(idUser);
            return getUser(daak);
        }else if(getMahasiswa(idUser) != null){
            Mahasiswa mhs = getMahasiswa(idUser);
            return getUser(mhs);
        }else if(getDosen(idUser) != null){
            Dosen dosen = getDosen(idUser);
            return getUser(dosen);
        }
        return null;
    }
    
    public static String getUser(String email, String password){
        conn.connect();
        String query = "SELECT * FROM user WHERE email='" + email + "' and password='" + password + "'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                return rs.getString("ID_User");
            }
            System.out.println("Log DB Get User : Success");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static Daak getDaak(String idUser){
        conn.connect();
        String query = "SELECT * FROM daak WHERE ID_User='" + idUser + "'";
        Daak daak = null;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                daak = new Daak();
                daak.setNIK(rs.getString(1));
                daak.setIdUser(rs.getString(2));
                daak.setJabatan(rs.getString(3));
                daak.setHakAksesKeuangan(rs.getBoolean(4));
                daak.setHakAksesMatakuliah(rs.getBoolean(5));
                daak.setHakAksesJadwalPerkuliahan(rs.getBoolean(6));
                daak.setHakAksesRencanaStudi(rs.getBoolean(7));
                daak.setHakAksesUser(rs.getBoolean(8));
            }
            System.out.println("Log DB Get Daak : Success");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return daak;
    }
    public static Mahasiswa getMahasiswa(String idUser){
        conn.connect();
        String query = "SELECT * FROM mahasiswa WHERE ID_User='" + idUser + "'";
        Mahasiswa mhs = null;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                mhs = new Mahasiswa();
                mhs.setNIM(rs.getString(1));
                mhs.setIdUser(rs.getString(2));
                mhs.setJurusan(rs.getString(3));
                mhs.setTahunMasuk(rs.getInt(4));
                mhs.setTahunLulus(rs.getInt(5));
                mhs.setIpk(rs.getFloat(6));
                mhs.setPredikat(rs.getString(7));
            }
            System.out.println("Log DB Get MHS : Success");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mhs;
    }
    public static Dosen getDosen(String idUser){
        conn.connect();
        String query = "SELECT * FROM dosen WHERE ID_User='" + idUser + "'";
        Dosen dosen = null;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                dosen = new Dosen();
                dosen.setNID(rs.getString(1));
                dosen.setIdUser(rs.getString(2));
                dosen.setProgramStudi(rs.getString(3));
                dosen.setBidangIlmu(rs.getString(4));
                dosen.setGelarAkademik(rs.getString(5));
                dosen.setStatusPegawai(rs.getString(6));
                dosen.setStatusIkatanKerja(rs.getString(7));
            }
            System.out.println("Log DB Get Dosen : Success");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dosen;
    }
    public static User getUser(User user){
        conn.connect();
        String query = "SELECT * FROM user WHERE ID_User='" +  user.getIdUser() + "'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                user.setNamaLengkap(rs.getString(2));
                user.setEmail(rs.getString(3));
                user.setPassword(rs.getString(4));
                user.setTanggalLahir(rs.getDate(5));
                user.setJenisKelamin(rs.getString(6));
                user.setNomorTelepon(rs.getString(7));
                user.setJenisUser(rs.getInt(8));
                user.setPathFoto(rs.getString(9));
            }
            System.out.println("Log DB Get User : Success");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
