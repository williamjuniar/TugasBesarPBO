/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.DatabaseController.ControllerDosen;

import static controller.DatabaseController.ContollerDaak.MatakuliahManageController.getMatakuliah;
import controller.DatabaseHandler;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.matakuliah.DetailMatakuliah;
import model.matakuliah.Matakuliah;

/**
 *
 * @author ASUS
 */
public class MatakuliahController {
    static DatabaseHandler conn = new DatabaseHandler();
    public static ArrayList getArrayDetailMatakuliah(String NID,int tahun,String semester){
        conn.connect();
        String query = "SELECT * FROM detail_matakuliah WHERE NID='" + NID + "'"
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
            System.out.println("Log DB Get Rekap Data Mengajar : Success");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arrDetailMK;
    }
    
}
