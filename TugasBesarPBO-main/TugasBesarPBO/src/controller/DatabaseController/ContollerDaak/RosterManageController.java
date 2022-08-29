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
import model.matakuliah.Roster;

/**
 *
 * @author 1119002 Albertus Angkuw
 */
public class RosterManageController {
    static DatabaseHandler conn = new DatabaseHandler();
    public static boolean insertRoster(Roster data,String idMK) {
        conn.connect();
        String query = "INSERT INTO daftar_roster_matakuliah(ID_MK,Tanggal,Ruangan,Jam_Dimulai,Jam_Berakhir,statusDosen)  VALUES(?,?,?,?,?,?);";
        
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            java.sql.Date sqlDate;
            stmt.setInt(1, Integer.valueOf(idMK));
            sqlDate = new java.sql.Date(data.getTanggal().getTime());
            stmt.setDate(2, sqlDate);
            stmt.setString(3, data.getRuangan() );
            stmt.setString(4, data.getJamMulai());
            stmt.setString(5, data.getJamSelesai());
            stmt.setBoolean(6, data.isStatusDosen());
            stmt.executeUpdate();
            ArrayList<String> nim = getArrayNimByIdMK(idMK);
            
            if(!insertDaftarHadirMhs(data,idMK, nim)){
                return false;
            }
            System.out.println("Log DB Insert Roster : Success");
        } catch (SQLException e) {
            System.out.println("Error  Insert  Roster : " + e.getMessage());
            return false;
        }
        return true;
    }
    private static boolean insertDaftarHadirMhs(Roster data,String idMK,ArrayList<String> nim) {
        conn.connect();
        String query = "INSERT INTO daftar_hadir_mahasiswa(NIM,ID_MK,ID_Roster)  VALUES(?,?,?);";
        
        try {
            for(int i=0; i<nim.size(); i++){
                PreparedStatement stmt = conn.con.prepareStatement(query);
                stmt.setString(1, nim.get(i));
                stmt.setInt(2, Integer.valueOf(idMK));
                stmt.setInt(3, getRoster(data,idMK));
                stmt.executeUpdate();
            }
            System.out.println("Log DB Insert Daftar Hadir Mhs : Success");
        } catch (SQLException e) {
            System.out.println("Error  Insert  Daftar Hadir Mhs: " + e.getMessage());
            return false;
        }
        return true;
    }
    
    public static ArrayList getArrayRoster(String idMK){
        conn.connect();
        String query = "SELECT * FROM daftar_roster_matakuliah WHERE ID_MK='" + idMK + "'";
                
        ArrayList<Roster> arrRoster = new ArrayList<>();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Roster roster = new Roster();
                roster.setID_Roster(rs.getInt(1)); 
                roster.setTanggal(rs.getDate(3));
                roster.setRuangan(rs.getString(4));
                roster.setJamMulai(rs.getString(5));
                roster.setJamSelesai(rs.getString(6));
                roster.setStatusDosen(rs.getBoolean(7));
                arrRoster.add(roster);
            }
            System.out.println("Log DB Get Array Roster : Success");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arrRoster;
    }
    public static int getRoster(Roster data,String idMK){
        conn.connect();
        java.sql.Date sqlDate = new java.sql.Date(data.getTanggal().getTime());
        String query = "SELECT ID_Roster FROM daftar_roster_matakuliah WHERE ID_MK='" + idMK + "'"
                + " && Tanggal='" + sqlDate + "' "
                + " && Ruangan='" + data.getRuangan() + "' "
                + " && Jam_Dimulai='" + data.getJamMulai() + "' "
                + " && Jam_Berakhir='" + data.getJamSelesai() + "' ";
                
         try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                return rs.getInt(1);
            }
            System.out.println("Log DB Get ID Roster  : Success");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public static ArrayList getArrayNimByIdMK(String idMK){
        conn.connect();
        String query = "SELECT rencana_studi_mahasiswa.NIM , detail_rencana_studi_mahasiswa.ID_MK from detail_rencana_studi_mahasiswa JOIN rencana_studi_mahasiswa ON rencana_studi_mahasiswa.ID_RSM = detail_rencana_studi_mahasiswa.ID_RSM "
                        + " WHERE detail_rencana_studi_mahasiswa.ID_MK ='" + idMK + "'";
                
        ArrayList<String> arrNim = new ArrayList<>();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                arrNim.add(rs.getString("NIM"));
            }
            System.out.println("Log DB Get Array NIM : Success");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arrNim;
    }
    
    public static boolean updateRoster(Roster data,String idMK,int idRoster) {
        conn.connect();
        java.sql.Date sqlDate = new java.sql.Date(data.getTanggal().getTime());
        String query = "UPDATE `daftar_roster_matakuliah` SET `ID_MK` = '" + idMK + "', "
                + "`Tanggal` = '" + sqlDate + "', "
                + "`Ruangan` = '" + data.getRuangan() + "', "
                + "`Jam_Dimulai` = '" + data.getJamMulai() + "', "
                + "`Jam_Berakhir` = '" + data.getJamSelesai() + "', "
                + "`statusDosen` = '" + boolToInt(data.isStatusDosen()) + "' WHERE `ID_Roster` = '" +  idRoster + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            System.out.println("Log DB Update Roster : Success");
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error Update Roster : " + e.getMessage());
            return (false);
        }     
    }
    
    public static boolean deleteRoster(int idRoster) {
        conn.connect();
        String query = "DELETE FROM daftar_roster_matakuliah WHERE ID_Roster='" + idRoster + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            if(!deleteDaftarHadirRoster(idRoster)){
                return false;
            }
            System.out.println("Log DB Delete Roster : Success");
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
    private static boolean deleteDaftarHadirRoster(int idRoster) {
        conn.connect();
        String query = "DELETE FROM daftar_hadir_mahasiswa WHERE ID_Roster='" + idRoster + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            System.out.println("Log DB Delete Daftar hadir Mahasiswa : Success");
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
