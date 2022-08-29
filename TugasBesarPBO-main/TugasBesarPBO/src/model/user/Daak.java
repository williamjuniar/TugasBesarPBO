/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.user;

import java.util.Date;

/**
 * @author 1119002 Albertus Angkuw
 * @author 1119006 William Juniar
 * @author 1119038 Elangel Neilea Shaday
 * 
 * 
*/
public class Daak extends User{

    private String NIK;
    private String jabatan;
    private boolean hakAksesKeuangan;
    private boolean hakAksesMatakuliah;
    private boolean hakAksesJadwalPerkuliahan;
    private boolean hakAksesRencanaStudi;
    private boolean hakAksesUser;
    private boolean statusKontrak;


    public Daak(String NIK, String jabatan, boolean hakAksesKeuangan, boolean hakAksesKemahasiswaan, boolean hakAksesPerkuliahan, boolean hakAksesDosen, boolean hakAksesAdmin, boolean statusKontrak, String idUser, String namaLengkap, String email, String password, Date tanggalLahir, String jenisKelamin, String nomorTelepon) {
        super(idUser, namaLengkap, email, password, tanggalLahir, jenisKelamin, nomorTelepon);
        this.NIK = NIK;
        this.jabatan = jabatan;
        this.hakAksesKeuangan = hakAksesKeuangan;
        this.hakAksesMatakuliah = hakAksesMatakuliah;
        this.hakAksesJadwalPerkuliahan = hakAksesJadwalPerkuliahan;
        this.hakAksesRencanaStudi = hakAksesRencanaStudi;
        this.hakAksesUser = hakAksesUser;
        this.statusKontrak = statusKontrak;
    }

    public Daak() {
        super();
    }

    public String getNIK() {
        return NIK;
    }

    public void setNIK(String NIK) {
        this.NIK = NIK;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public boolean isHakAksesKeuangan() {
        return hakAksesKeuangan;
    }

    public void setHakAksesKeuangan(boolean hakAksesKeuangan) {
        this.hakAksesKeuangan = hakAksesKeuangan;
    }

    public boolean isHakAksesMatakuliah() {
        return hakAksesMatakuliah;
    }

    public void setHakAksesMatakuliah(boolean hakAksesMatakuliah) {
        this.hakAksesMatakuliah = hakAksesMatakuliah;
    }

    public boolean isHakAksesJadwalPerkuliahan() {
        return hakAksesJadwalPerkuliahan;
    }

    public void setHakAksesJadwalPerkuliahan(boolean hakAksesJadwalPerkuliahan) {
        this.hakAksesJadwalPerkuliahan = hakAksesJadwalPerkuliahan;

    }

    public boolean isHakAksesRencanaStudi() {
        return hakAksesRencanaStudi;
    }

    public void setHakAksesRencanaStudi(boolean hakAksesRencanaStudi) {
        this.hakAksesRencanaStudi = hakAksesRencanaStudi;
    }

    public boolean isHakAksesUser() {
        return hakAksesUser;
    }

    public void setHakAksesUser(boolean hakAksesUser) {
        this.hakAksesUser = hakAksesUser;
    }

    public boolean isStatusKontrak() {
        return statusKontrak;
    }

    public void setStatusKontrak(boolean statusKontrak) {
        this.statusKontrak = statusKontrak;
    }

    @Override
    public String toString() {

        return super.toString() +  "\n" + "Daak{" + "NIK=" + NIK + ", jabatan=" + jabatan + ", hakAksesKeuangan=" + hakAksesKeuangan + ", hakAksesMatakuliah=" + hakAksesMatakuliah + ", hakAksesJadwalPerkuliahan=" + hakAksesJadwalPerkuliahan + ", hakAksesRencanaStudi=" + hakAksesRencanaStudi + ", hakAksesUser=" + hakAksesUser + ", statusKontrak=" + statusKontrak + '}';
    }
    
    
}

