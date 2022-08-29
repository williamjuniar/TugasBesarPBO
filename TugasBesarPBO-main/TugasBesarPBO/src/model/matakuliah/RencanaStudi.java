/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.matakuliah;

import model.matakuliah.DetailMatakuliah;
import java.util.ArrayList;

/**
 * @author 1119002 Albertus Angkuw
 * @author 1119006 William Juniar
 * @author 1119038 Elangel Neilea Shaday
 */

public class RencanaStudi {
    private String id_RSM;
    private String semesterAjaran;
    private int tahunAjaran;
    private ArrayList<String> id_Mk;

    public RencanaStudi(){
        
    }
    public RencanaStudi(String id_RSM, String semesterAjaran, int tahunAjaran, ArrayList<String> id_Mk) {
        this.id_RSM = id_RSM;
        this.semesterAjaran = semesterAjaran;
        this.tahunAjaran = tahunAjaran;
        this.id_Mk = id_Mk;
    }

    public String getId_RSM() {
        return id_RSM;
    }

    public void createId_RSM(String nim) {
        this.id_RSM = tahunAjaran + semesterAjaran.substring(0, 2).toUpperCase() + nim;
    }
    public void setId_RSM(String id_RSM) {
        this.id_RSM = id_RSM;
    }

    public String getSemesterAjaran() {
        return semesterAjaran;
    }

    public void setSemesterAjaran(String semesterAjaran) {
        this.semesterAjaran = semesterAjaran;
    }

    public int getTahunAjaran() {
        return tahunAjaran;
    }

    public void setTahunAjaran(int tahunAjaran) {
        this.tahunAjaran = tahunAjaran;
    }

    public ArrayList<String> getId_Mk() {
        return id_Mk;
    }

    public void setId_Mk(ArrayList<String> id_Mk) {
        this.id_Mk = id_Mk;
    }
    
    
   

}
