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
import java.util.ArrayList;
import model.enums.JenisMatakuliah;
import model.enums.SifatMatakuliah;
import model.matakuliah.DetailMatakuliah;
import model.matakuliah.Matakuliah;

/**
 *
 * @author 1119002 Albertus Angkuw
 */
public class MatakuliahManageController {
    static DatabaseHandler conn = new DatabaseHandler();
    
    public static boolean insertMatakuliah(Matakuliah data) {
        conn.connect();
        String query = "INSERT INTO matakuliah VALUES(?,?,?,?,?)";
                             
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, data.getKode_MK());
            stmt.setString(2, data.getNama_MK());
            stmt.setInt(3, data.getJenis_MK().ordinal() );
            stmt.setInt(4, data.getSifat_MK().ordinal());
            stmt.setInt(5, data.getSks());
            stmt.executeUpdate();
            System.out.println("Log DB Insert Matakuliah : Success");
        } catch (SQLException e) {
            System.out.println("Error  Insert  Matakuliah : " + e.getMessage());
            return false;
        }
        return true;
    }
    public static boolean insertDetailMatakuliah(DetailMatakuliah data){
        conn.connect();
        String query = "INSERT INTO detail_matakuliah(NID,Kode_MK,Kelas,Jumlah_Pertemuan,Tahun,Semester) VALUES(?,?,?,?,?,?)";
                             
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, data.getNid());
            stmt.setString(2, data.getKode_MK());
            stmt.setString(3,String.valueOf(data.getKelas()));
            stmt.setInt(4, data.getJumlahPertemuan());
            stmt.setInt(5, data.getTahun() );
            stmt.setString(6, data.getSemester());
            
            stmt.executeUpdate();
            System.out.println("Log DB Insert Detail Matakuliah : Success");
            return true;
        } catch (SQLException e) {
            System.out.println("Error Insert Detail Matakuliah : " + e.getMessage());
            return false;
        }
    }
    
    public static boolean updateMatakuliah(Matakuliah data) {
        conn.connect();
        String query = "UPDATE `matakuliah` SET `Kode` = '" + data.getKode_MK() + "', "
                + "`Nama_MK` = '" + data.getNama_MK() + "', "
                + "`Jenis_MK` = '" + data.getJenis_MK().ordinal() + "', "
                + "`Sifat_MK` = '" + data.getSifat_MK().ordinal() + "', "
                + "`SKS` = '" + data.getSks() + "' WHERE `matakuliah`.`Kode` = '" + data.getKode_MK() + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            System.out.println("Log DB Update Matakuliah : Success");
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error Update Matakuliah : " + e.getMessage());
            return (false);
        }     
    }
    public static boolean updateDetailMatakuliah(DetailMatakuliah data){
        conn.connect();
        String query =  "UPDATE `detail_matakuliah` SET `ID_MK` = '" + data.getId_MK() + "', "
                + "`NID` = '" + data.getNid() + "', "
                + "`Kode_MK` = '" + data.getKode_MK() + "', "
                + "`Kelas` = '" + data.getKelas() + "', "
                + "`Jumlah_Pertemuan` = '" + data.getJumlahPertemuan() + "', "
                + "`Tahun` = '" + data.getTahun() + "', "
                + "`Semester` = '" + data.getSemester() + "' WHERE `detail_matakuliah`.`ID_MK` = '" + data.getId_MK() + "'";;
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            System.out.println("Log DB Update Detail Matakuliah : Success");
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
             System.out.println("Error Update Detail Matakuliah : " + e.getMessage());
            return (false);
        }     
       
    }
    
    public static Matakuliah getMatakuliah(String kode){
        conn.connect();
        String query = "SELECT * FROM matakuliah WHERE Kode='" + kode + "'";
        Matakuliah matakuliah = null;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                matakuliah = new Matakuliah();
                matakuliah.setKode_MK(rs.getString(1));
                matakuliah.setNama_MK(rs.getString(2));
                matakuliah.setJenis_MK(JenisMatakuliah.values[rs.getInt(3)]);
                matakuliah.setSifat_MK(SifatMatakuliah.values[rs.getInt(4)]);
                matakuliah.setSks(rs.getInt(5));
            }
            System.out.println("Log DB Get Matakuliah : Success");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return matakuliah;
    }
    public static DetailMatakuliah getDetailMatakuliah(String kode,int tahun,String semester){
        conn.connect();
        String query = "SELECT * FROM detail_matakuliah WHERE Kode_MK='" + kode + "'"
                + "&& Tahun='"+ tahun + "' && Semester='"+ semester + "'" ;
        DetailMatakuliah detailMK = null;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                detailMK = new DetailMatakuliah();
                detailMK.setId_MK(rs.getString(1)); 
                detailMK.setNid(rs.getString(2));
                detailMK.setKode_MK(rs.getString(3));
                detailMK.setKelas(rs.getString(4).charAt(0));
                detailMK.setJumlahPertemuan(rs.getInt(5));
                detailMK.setTahun(rs.getInt(6));
                detailMK.setSemester(rs.getString(7));
            }
            System.out.println("Log DB Get Detail Matakuliah : Success");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return detailMK;
    }
    public static DetailMatakuliah getDetailMatakuliah(String kode,int tahun,String semester,char kelas){
        conn.connect();
        String query = "SELECT * FROM detail_matakuliah WHERE Kode_MK='" + kode + "'"
                + "&& Tahun='"+ tahun + "' && Semester='"+ semester + "'&& Kelas='"+ kelas + "'" ;
        DetailMatakuliah detailMK = null;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                detailMK = new DetailMatakuliah();
                detailMK.setId_MK(rs.getString(1)); 
                detailMK.setNid(rs.getString(2));
                detailMK.setKode_MK(rs.getString(3));
                detailMK.setKelas(rs.getString(4).charAt(0));
                detailMK.setJumlahPertemuan(rs.getInt(5));
                detailMK.setTahun(rs.getInt(6));
                detailMK.setSemester(rs.getString(7));
            }
            System.out.println("Log DB Get Detail Matakuliah : Success");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return detailMK;
    }
    public static DetailMatakuliah getDetailMatakuliah(String idMK){
        conn.connect();
        String query = "SELECT * FROM detail_matakuliah WHERE ID_MK='" + idMK + "'";
        DetailMatakuliah detailMK = null;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                detailMK = new DetailMatakuliah();
                detailMK.setId_MK(rs.getString(1)); 
                detailMK.setNid(rs.getString(2));
                detailMK.setKode_MK(rs.getString(3));
                detailMK.setKelas(rs.getString(4).charAt(0));
                detailMK.setJumlahPertemuan(rs.getInt(5));
                detailMK.setTahun(rs.getInt(6));
                detailMK.setSemester(rs.getString(7));
            }
            System.out.println("Log DB Get Detail Matakuliah : Success");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return detailMK;
    }
    public static ArrayList getArrayDetailMatakuliah(String kode,int tahun,String semester){
        conn.connect();
        String query = "SELECT * FROM detail_matakuliah WHERE Kode_MK='" + kode + "'"
                + "&& Tahun='"+ tahun + "' && Semester='"+ semester + "'" ;
        ArrayList<DetailMatakuliah> arrDetailMK = new ArrayList<>();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                DetailMatakuliah detailMK = new DetailMatakuliah();
                detailMK.setId_MK(rs.getString(1)); 
                detailMK.setNid(rs.getString(2));
                detailMK.setKode_MK(rs.getString(3));
                detailMK.setKelas(rs.getString(4).charAt(0));
                detailMK.setJumlahPertemuan(rs.getInt(5));
                detailMK.setTahun(rs.getInt(6));
                detailMK.setSemester(rs.getString(7));
                Matakuliah temp = getMatakuliah(detailMK.getKode_MK());
                detailMK.setSks(temp.getSks());
                detailMK.setNama_MK(temp.getNama_MK());
                arrDetailMK.add(detailMK);
            }
            System.out.println("Log DB Get Detail Matakuliah : Success");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arrDetailMK;
    }
    
    public static boolean deleteMatakuliah(String kodeMK) {
        conn.connect();
        String query = "DELETE FROM matakuliah WHERE Kode='" + kodeMK + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            System.out.println("Log DB Delete Matakuliah : Success");
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
    public static boolean deleteDetailMatakuliah(String kode,int tahun,String semester) {
        conn.connect();
        String query = "DELETE FROM detail_matakuliah WHERE Kode_MK='" + kode + "'"
                + "&& Tahun='"+ tahun + "' && Semester='"+ semester + "'" ;
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            System.out.println("Log DB Delete Detail Matakuliah : Success");
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
}
