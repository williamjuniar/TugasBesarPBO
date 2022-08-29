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
public class Roster {
    private int ID_Roster;
    private Date tanggal;
    private String jamMulai;
    private String jamSelesai;
    private String ruangan;
    private boolean statusDosen;
    //True  -> hadir , False -> tidak hadir
    public Roster(){
        
    }

    public Roster(int ID_Roster, Date tanggal, String jamMulai, String jamSelesai, String ruangan, boolean statusDosen) {
        this.ID_Roster = ID_Roster;
        this.tanggal = tanggal;
        this.jamMulai = jamMulai;
        this.jamSelesai = jamSelesai;
        this.ruangan = ruangan;
        this.statusDosen = statusDosen;
    }

    public int getID_Roster() {
        return ID_Roster;
    }

    public void setID_Roster(int ID_Roster) {
        this.ID_Roster = ID_Roster;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public String getJamMulai() {
        return jamMulai;
    }

    public void setJamMulai(String jamMulai) {
        this.jamMulai = jamMulai;
    }

    public String getJamSelesai() {
        return jamSelesai;
    }

    public void setJamSelesai(String jamSelesai) {
        this.jamSelesai = jamSelesai;
    }

    public String getRuangan() {
        return ruangan;
    }

    public void setRuangan(String ruangan) {
        this.ruangan = ruangan;
    }

    public boolean isStatusDosen() {
        return statusDosen;
    }

    public void setStatusDosen(boolean statusDosen) {
        this.statusDosen = statusDosen;
    }

    @Override
    public String toString() {
        return "Roster{" + "ID_Roster=" + ID_Roster + ", tanggal=" + tanggal + ", jamMulai=" + jamMulai + ", jamSelesai=" + jamSelesai + ", ruangan=" + ruangan + ", statusDosen=" + statusDosen + '}';
    }
    
}
