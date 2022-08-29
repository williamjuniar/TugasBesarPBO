/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.matakuliah;

import java.util.Date;

/**
 * @author 1119002 Albertus Angkuw
 * @author 1119006 William Juniar
 * @author 1119038 Elangel Neilea Shaday
 */

public class Kehadiran extends Roster{
    private String NIM;
    private String keterangan;

    public Kehadiran(){
        super();
    }

    public Kehadiran(String NIM, String keterangan) {
        this.NIM = NIM;
        this.keterangan = keterangan;
    }

    public Kehadiran(String NIM, String keterangan, int ID_Roster, Date tanggal, String jamMulai, String jamSelesai, String ruangan, boolean statusDosen) {
        super(ID_Roster, tanggal, jamMulai, jamSelesai, ruangan, statusDosen);
        this.NIM = NIM;
        this.keterangan = keterangan;
    }
   

    public String getNIM() {
        return NIM;
    }

    public void setNIM(String NIM) {
        this.NIM = NIM;
    }

    
    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    @Override
    public String toString() {
        return "Kehadiran{" + "NIM=" + NIM + ", keterangan=" + keterangan + '}';
    }

    
        
        
    
}
