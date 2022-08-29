/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.matakuliah;

import model.enums.JenisMatakuliah;
import model.enums.SifatMatakuliah;

/**
 * @author 1119002 Albertus Angkuw
 * @author 1119006 William Juniar
 * @author 1119038 Elangel Neilea Shaday
 */
public class Matakuliah {
    private String kode_MK;
    private String nama_MK;
    private JenisMatakuliah jenis_MK;
    private SifatMatakuliah sifat_MK;
    private int sks;

    public Matakuliah(String kode_MK, String nama_MK,JenisMatakuliah jenis_MK,SifatMatakuliah sifat_MK, int sks) {
        this.kode_MK = kode_MK;
        this.nama_MK = nama_MK;
        this.jenis_MK = jenis_MK;
        this.sifat_MK = sifat_MK;
        this.sks = sks;
    }

    public Matakuliah() {
        
    }

    public String getKode_MK() {
        return kode_MK;
    }

    public void setKode_MK(String kode_MK) {
        this.kode_MK = kode_MK;
    }

    public String getNama_MK() {
        return nama_MK;
    }

    public void setNama_MK(String nama_MK) {
        this.nama_MK = nama_MK;
    }

    public JenisMatakuliah getJenis_MK() {
        return jenis_MK;
    }

    public void setJenis_MK(JenisMatakuliah jenis_MK) {
        this.jenis_MK = jenis_MK;
    }
    
    public void dbJenis_MK(int jenis_MK) {
        this.jenis_MK = JenisMatakuliah.values[jenis_MK];
    }
    
    public SifatMatakuliah getSifat_MK() {
        return sifat_MK;
    }

    public void setSifat_MK(SifatMatakuliah sifat_MK) {
        this.sifat_MK = sifat_MK;
    }
    
    public void dbSifat_MK(int sifat_MK) {
        this.sifat_MK = SifatMatakuliah.values[sifat_MK];
    }

    public int getSks() {
        return sks;
    }

    public void setSks(int sks) {
        this.sks = sks;
    }

    @Override
    public String toString() {
        return "Matakuliah{" + "kode_MK=" + kode_MK + ", nama_MK=" + nama_MK + ", jenis_MK=" + jenis_MK + ", sifat_MK=" + sifat_MK + ", sks=" + sks + '}';
    }
}
