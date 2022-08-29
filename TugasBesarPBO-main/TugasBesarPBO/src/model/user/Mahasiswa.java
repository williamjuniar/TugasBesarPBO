/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.user;

import java.util.ArrayList;
import java.util.Date;
import model.matakuliah.RencanaStudi;
import model.transaksi.Transaksi;

/**
 * @author 1119002 Albertus Angkuw
 * @author 1119006 William Juniar
 * @author 1119038 Elangel Neilea Shaday
 */
public class Mahasiswa extends User {
    private String NIM;
    private String jurusan;
    private int tahunMasuk;
    private int tahunLulus;
    private float ipk;
    private String predikat;

    private ArrayList<RencanaStudi> rencanaStudi;
    private ArrayList<Transaksi> transaksiMahasiswa;
    
    public Mahasiswa(){
        super();
    }

    public Mahasiswa(String NIM, String jurusan, int tahunMasuk, int tahunLulus, float ipk, String predikat, ArrayList<RencanaStudi> rencanaStudi, ArrayList<Transaksi> transaksiMahasiswa, String idUser, String namaLengkap, String email, String password, Date tglLahir, String jenisKelamin, String notelp) {
        super(idUser, namaLengkap, email, password, tglLahir, jenisKelamin, notelp);
        this.NIM = NIM;
        this.jurusan = jurusan;
        this.tahunMasuk = tahunMasuk;
        this.tahunLulus = tahunLulus;
        this.ipk = ipk;
        this.predikat = predikat;
        this.rencanaStudi = rencanaStudi;
        this.transaksiMahasiswa = transaksiMahasiswa;
    }

    public String getNIM() {
        return NIM;
    }

    public void setNIM(String NIM) {
        this.NIM = NIM;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public int getTahunMasuk() {
        return tahunMasuk;
    }

    public void setTahunMasuk(int tahunMasuk) {
        this.tahunMasuk = tahunMasuk;
    }

    public int getTahunLulus() {
        return tahunLulus;
    }

    public void setTahunLulus(int tahunLulus) {
        this.tahunLulus = tahunLulus;
    }

    public float getIpk() {
        return ipk;
    }

    public void setIpk(float ipk) {
        this.ipk = ipk;
    }

    public String getPredikat() {
        return predikat;
    }

    public void setPredikat(String predikat) {
        this.predikat = predikat;
    }

    public ArrayList<RencanaStudi> getRencanaStudi() {
        return rencanaStudi;
    }

    public void setRencanaStudi(ArrayList<RencanaStudi> rencanaStudi) {
        this.rencanaStudi = rencanaStudi;
    }

    public ArrayList<Transaksi> getTransaksiMahasiswa() {
        return transaksiMahasiswa;
    }

    public void setTransaksiMahasiswa(ArrayList<Transaksi> transaksiMahasiswa) {
        this.transaksiMahasiswa = transaksiMahasiswa;
    }
    
    

    @Override
    public String toString() {
        return super.toString() +  "\n" + "Mahasiswa{" + "NIM=" + NIM + ", jurusan=" + jurusan + ", tahunMasuk=" + tahunMasuk + ", tahunLulus=" + tahunLulus + ", ipk=" + ipk + ", predikat=" + predikat + ", rencanaStudi=" + rencanaStudi + ", transaksiMahasiswa=" + transaksiMahasiswa + '}';
    }
    
    public float hitungIPK(){
        return ipk;
    }
}
