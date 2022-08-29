/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.DatabaseController.ContollerDaak;

import controller.DatabaseHandler;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.user.*;

/**
 *
 * @author 1119002 Albertus Angkuw
 */
public class UserManageController {
    static DatabaseHandler conn = new DatabaseHandler();
    
    public static boolean insertNewUser(User data) {
        conn.connect();
        String query = "INSERT INTO user VALUES(?,?,?,?,?,?,?,?,?)";
                             
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            java.sql.Date sqlDate;
            stmt.setString(1, data.getIdUser());
            stmt.setString(2, data.getNamaLengkap());
            stmt.setString(3, data.getEmail() );
            
            stmt.setString(4, data.getPassword());
            sqlDate = new java.sql.Date(data.getTanggalLahir().getTime());
            stmt.setDate(5, sqlDate);
            stmt.setString(6, data.getJenisKelamin());
            stmt.setString(7, data.getNomorTelepon());
            stmt.setInt(8, data.getJenisUser());
            stmt.setString(9, data.getPathFoto());
                        
            stmt.executeUpdate();
            System.out.println("Log DB Insert User : Success");
            switch(data.getJenisUser()){
                case 1 : {
                    Daak daak = (Daak) data;
                    if(!insertDaak(daak)){
                        return false;
                    }
                    break;
                }
                case 2 : {
                    Dosen dosen = (Dosen) data;
                    if(!insertDosen(dosen)){
                        return false;
                    }
                    break;
                }
                case 3 : {
                    Mahasiswa mhs = (Mahasiswa) data;
                    if(!insertMahasiswa(mhs)){
                        return false;
                    }
                    break;
                }
            }        
        } catch (SQLException e) {
            System.out.println("Error  Insert User : " + e.getMessage());
            return false;
        }
        return true;
    }
    private static boolean insertDaak(Daak data){
        conn.connect();
        String query = "INSERT INTO daak VALUES(?,?,?,?,?,?,?,?)";
                             
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, data.getNIK());
            stmt.setString(2, data.getIdUser());
            stmt.setString(3, data.getJabatan() );
            stmt.setBoolean(4, data.isHakAksesKeuangan());
            stmt.setBoolean(5, data.isHakAksesMatakuliah());
            stmt.setBoolean(6, data.isHakAksesJadwalPerkuliahan());
            stmt.setBoolean(7, data.isHakAksesRencanaStudi());
            stmt.setBoolean(8, data.isHakAksesUser());
            
            stmt.executeUpdate();
            System.out.println("Log DB Insert Daak : Success");
            return true;
        } catch (SQLException e) {
            System.out.println("Error Insert Daak : " + e.getMessage());
            return false;
        }
    }
    private static boolean insertDosen(Dosen data){
        conn.connect();
        String query = "INSERT INTO dosen VALUES(?,?,?,?,?,?,?)";
                             
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, data.getNID());
            stmt.setString(2, data.getIdUser());
            stmt.setString(3, data.getProgramStudi());
            stmt.setString(4, data.getBidangIlmu());
            stmt.setString(5, data.getGelarAkademik());
            stmt.setString(6, data.getStatusPegawai());
            stmt.setString(7, data.getStatusIkatanKerja());
            
            stmt.executeUpdate();
            System.out.println("Log DB Insert Dosen : Success");
            return true;
        } catch (SQLException e) {
            System.out.println("Error Insert Dosen : " + e.getMessage());
            return false;
        }
    }
    private static boolean insertMahasiswa(Mahasiswa data){
        conn.connect();
        String query = "INSERT INTO mahasiswa VALUES(?,?,?,?,?,?,?)";
                             
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, data.getNIM() );
            stmt.setString(2, data.getIdUser());
            stmt.setString(3, data.getJurusan() );
            stmt.setInt(4, data.getTahunMasuk());
            stmt.setInt(5, data.getTahunLulus());
            stmt.setDouble(6, data.getIpk());
            stmt.setString(7, data.getPredikat());                        
            stmt.executeUpdate();
            System.out.println("Log DB Insert Mahasiswa : Success");
            return true;
        } catch (SQLException e) {
            System.out.println("Error DB Insert Mahasiswa : " + e.getMessage());
            return false;
        }
    }
    
    public static boolean updateUser(User data) {
        conn.connect();
        String query = "UPDATE `user` SET `ID_User` = '" + data.getIdUser() + "', "
                + "`Nama_Lengkap` = '" + data.getNamaLengkap() + "', "
                + "`Email` = '" + data.getEmail() + "', "
                + "`Password` = '" + data.getPassword() + "', "
                + "`Tanggal_Lahir` = '" + data.getTanggalLahir().getTime() + "', "
                + "`Jenis_Kelamin` = '" + data.getJenisKelamin() + "', "
                + "`No_Telp` = '" + data.getNomorTelepon() + "', "
                + "`jenisUser` = '" + data.getJenisUser() + "', "
                + "`pathFoto` = '" + data.getPathFoto() + "' WHERE `user`.`ID_User` = '" + data.getIdUser() + "'";
                            
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            System.out.println("Log DB Update User : Success");
            switch(data.getJenisUser()){
                case 1 : {
                    Daak daak = (Daak) data;
                    if(!updateDaak(daak)){
                        return false;
                    }
                }
                case 2 : {
                    Dosen dosen = (Dosen) data;
                    if(!updateDosen(dosen)){
                        return false;
                    }
                }
                case 3 : {
                    Mahasiswa mhs = (Mahasiswa) data;
                    if(!updateMahasiswa(mhs)){
                        return false;
                    }
                }
            }
            System.out.println("Log DB Update User : Success");
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error Update User : " + e.getMessage());
            return (false);
        }     
    }
    public static boolean updateDaak(Daak data){
        conn.connect();
        String query = "UPDATE `daak` SET `NIK` = '" + data.getNIK() + " ', `ID_User` = '" + data.getIdUser() + " ',"
                + " `Jabatan` = '" + data.getJabatan() + "',"
                + " `Hak_Akses_Keuangan` = '" + boolToInt(data.isHakAksesKeuangan()) + "',"
                + " `Hak_Akses_Matakuliah` = '" +  boolToInt(data.isHakAksesMatakuliah()) + "',"
                + " `Hak_Akses_JadwalPerkuliahan` = '" +  boolToInt(data.isHakAksesJadwalPerkuliahan()) + "',"
                + " `Hak_Akses_RencanaStudi` = '" +  boolToInt(data.isHakAksesRencanaStudi()) + "',"
                + " `Hak_Akses_User` = '" +  boolToInt(data.isHakAksesUser()) + "' WHERE `daak`.`NIK` = '" + data.getNIK() + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            System.out.println("Log DB Update Daak : Success");
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
             System.out.println("Error Update Daak : " + e.getMessage());
            return (false);
        }     
       
    }
    public static boolean updateDosen(Dosen data){
        conn.connect();
        String query = "UPDATE `dosen` SET `NID` = '" + data.getNID() + "', `ID_User` = '" + data.getIdUser() + " ',"
                + " `Program_Studi` = '" + data.getProgramStudi() + "',"
                + " `Bidang_Ilmu` = '" +  data.getBidangIlmu() + "',"
                + " `Gelar_Akademik` = '" + data.getGelarAkademik() + "',"
                + " `Status_Pegawai` = '" + data.getStatusPegawai() + "',"
                + " `Status_Ikatan_Kerja` = '" + data.getStatusIkatanKerja() + "'"
                + " WHERE `dosen`.`NID` = '" + data.getNID() + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            System.out.println("Log DB Update Dosen : Success");
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
             System.out.println("Error Update Dosen: " + e.getMessage());
            return (false);
        }     
       
    }
    public static boolean updateMahasiswa(Mahasiswa data){
        conn.connect();
        String query = "UPDATE `mahasiswa` SET `NIM` = '" + data.getNIM() + "', "
                + " `ID_User` = '" + data.getIdUser() + " ',"
                + " `Jurusan` = '" + data.getJurusan() + "',"
                + " `Tahun_Masuk` = '" +  data.getTahunMasuk() + "',"
                + " `Tahun_Lulus` = '" + data.getTahunLulus() + "',"
                + " `IPK` = '" + data.getIpk() + "',"
                + " `Predikat` = '" + data.getPredikat() + "'"
                + "WHERE `mahasiswa`.`NIM` = '" + data.getNIM() + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            System.out.println("Log DB Update Mahasiswa : Success");
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
             System.out.println("Error Update Mahasiswa : " + e.getMessage());
            return (false);
        }     
       
    }
    
    public static User getUser(String nomorInduk){
        if(getDaak(nomorInduk) != null){
            Daak  daak = getDaak(nomorInduk);
            return getUser(daak);
        }else if(getMahasiswa(nomorInduk) != null){
            Mahasiswa  mhs = getMahasiswa(nomorInduk);
            return getUser(mhs);
        }else if(getDosen(nomorInduk) != null){
            Dosen  dosen = getDosen(nomorInduk);
            return getUser(dosen);
        }
        return null;
    }
    public static Daak getDaak(String nomorInduk){
        conn.connect();
        String query = "SELECT * FROM daak WHERE NIK='" + nomorInduk + "'";
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
    public static Mahasiswa getMahasiswa(String nomorInduk){
        conn.connect();
        String query = "SELECT * FROM mahasiswa WHERE NIM='" + nomorInduk + "'";
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
    public static Dosen getDosen(String nomorInduk){
        conn.connect();
        String query = "SELECT * FROM dosen WHERE NID='" + nomorInduk + "'";
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
    
    public static boolean deleteUser(String nomorInduk) {
        conn.connect();
        String query = "DELETE FROM user WHERE ID_User='" + nomorInduk + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            System.out.println("Log DB Delete User : Success");
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
    public static boolean deleteDaak(String nomorInduk) {
        conn.connect();
        String query = "DELETE FROM daak WHERE ID_User='" + nomorInduk + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            deleteUser(nomorInduk);
            System.out.println("Log DB Delete Daak : Success");
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
    public static boolean deleteDosen(String nomorInduk) {
        conn.connect();
        String query = "DELETE FROM dosen WHERE ID_User='" + nomorInduk + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            deleteUser(nomorInduk);
            System.out.println("Log DB Delete Dosen : Success");
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
    public static boolean deleteMahasiswa(String nomorInduk) {
        conn.connect();
        String query = "DELETE FROM mahasiswa WHERE ID_User='" + nomorInduk + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            deleteUser(nomorInduk);
            System.out.println("Log DB Delete Mahasiswa : Success");
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
    
    private static int boolToInt(Boolean b) {
        return b.compareTo(false);
    }

}
