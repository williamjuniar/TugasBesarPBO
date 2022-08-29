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
import model.matakuliah.RencanaStudi;

/**
 *
 * @author 1119002 Albertus Angkuw
 */
public class RencanaStudiManageController {
    static DatabaseHandler conn = new DatabaseHandler();
    
    public static boolean insertRencanaStudi(RencanaStudi data,String nim) {
        conn.connect();
        String query = "INSERT INTO rencana_studi_mahasiswa  VALUES(?,?,?,?);";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, data.getId_RSM());
            stmt.setString(2, nim);
            stmt.setString(3, data.getSemesterAjaran() );
            stmt.setInt(4, data.getTahunAjaran());
            stmt.executeUpdate();
            if(!insertDetailRencanaStudi(data)){
                return false;
            }
            if(!insertHasilStudi(data,nim)){
                return false;
            }
            
            System.out.println("Log DB Insert Rencana Studi : Success");
        } catch (SQLException e) {
            System.out.println("Error  Insert  Matakuliah : " + e.getMessage());
            return false;
        }
        return true;
    }
    private static boolean insertDetailRencanaStudi(RencanaStudi data) {
        conn.connect();
        String query = "INSERT INTO  detail_rencana_studi_mahasiswa(ID_MK,ID_RSM)  VALUES(?,?)";
                             
        try {
            for(int i=0; i < data.getId_Mk().size(); i++){
                PreparedStatement stmt = conn.con.prepareStatement(query);
                stmt.setString(1, data.getId_Mk().get(i));
                stmt.setString(2, data.getId_RSM());
                stmt.executeUpdate();
            }
            System.out.println("Log DB Insert Detail Rencana Studi : Success");
        } catch (SQLException e) {
            System.out.println("Error  Insert  Matakuliah : " + e.getMessage());
            return false;
        }
        return true;
    }
    private static boolean insertHasilStudi(RencanaStudi data,String nim) {
        conn.connect();
        String query = "INSERT INTO  hasil_studi_mahasiswa(ID_MK,NIM)  VALUES(?,?)";
                             
        try {
            for(int i=0; i < data.getId_Mk().size(); i++){
                PreparedStatement stmt = conn.con.prepareStatement(query);
                stmt.setString(1, data.getId_Mk().get(i));
                stmt.setString(2, nim);
                stmt.executeUpdate();
            }
            System.out.println("Log DB Insert Hasil Studi : Success");
        } catch (SQLException e) {
            System.out.println("Error  Insert Hasil Studi : " + e.getMessage());
            return false;
        }
        return true;
    }
    
    
    public static boolean updateRencanaStudi(RencanaStudi data,String nim) {
        conn.connect();
        String query = "UPDATE `rencana_studi_mahasiswa` SET `ID_RSM` = '" + data.getId_RSM() + "', "
                + "`NIM` = '" + nim + "', "
                + "`Semester` = '" + data.getSemesterAjaran() + "', "
                + "`Tahun` = '" + data.getTahunAjaran() + "' WHERE `rencana_studi_mahasiswa`.`ID_RSM` = '" + data.getId_RSM() + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            System.out.println("Log DB Update Rencana Studi : Success");
            if(!updateDetailRencanaStudi(data)){
                return false;
            }
            if(!insertHasilStudi(data,nim)){
                return false;
            }
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error Update Matakuliah : " + e.getMessage());
            return (false);
        }     
    }
    private static boolean updateDetailRencanaStudi(RencanaStudi data) {
        if(!deleteDetailRencanaStudi(data.getId_RSM())){
                return false;
        }
        if(!insertDetailRencanaStudi(data)){
                return false;
        }
        System.out.println("Log DB Update Detail Rencana Studi : Success");
        return true;    
    }
 
    public static boolean deleteRencanaStudi(String idRSM) {
        conn.connect();
        String query = "DELETE FROM rencana_studi_mahasiswa WHERE ID_RSM='" + idRSM + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            if(!deleteDetailRencanaStudi(idRSM)){
                return false;
            }
            System.out.println("Log DB Delete Rencana Studi : Success");
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
    private static boolean deleteDetailRencanaStudi(String idRSM) {
        conn.connect();
        String query = "DELETE FROM detail_rencana_studi_mahasiswa WHERE ID_RSM='" + idRSM + "'";
        
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            System.out.println("Log DB Delete Detail Rencana Studi : Success");
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
    public static boolean deleteHasilStudi(RencanaStudi RSM,String nim) {
        conn.connect();
        String query = "DELETE FROM hasil_studi_mahasiswa WHERE NIM='" + nim + "'"
                + "&& ID_MK='" + RSM.getId_Mk()  +"'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            System.out.println("Log DB Delete Hasil Studi : Success");
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
    
    public static RencanaStudi getRencanastudi(String nim,int tahun,String semester){
        conn.connect();
        String query = "SELECT * FROM rencana_studi_mahasiswa WHERE NIM='" + nim + "'"
                + "&& Tahun='"+ tahun + "' && Semester='"+ semester + "'" ;
        RencanaStudi rsm = null;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                rsm = new RencanaStudi();
                rsm.setId_RSM(rs.getString(1)); 
                rsm.setSemesterAjaran(rs.getString(3));
                rsm.setTahunAjaran(rs.getInt(4));
                rsm.setId_Mk(getDetailRencanaStudi(rsm.getId_RSM()));
            }
            System.out.println("Log DB Get Detail Matakuliah : Success");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rsm;
    }
    private static ArrayList getDetailRencanaStudi(String idRSM){
        conn.connect();
        String query = "SELECT * FROM detail_rencana_studi_mahasiswa WHERE ID_RSM='" + idRSM + "'";
        ArrayList<String> idMK = new ArrayList<>();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                idMK.add(rs.getString("ID_MK"));
            }
            System.out.println("Log DB Get Detail Rencana Studi : Success");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idMK;
    }
    
    

}
