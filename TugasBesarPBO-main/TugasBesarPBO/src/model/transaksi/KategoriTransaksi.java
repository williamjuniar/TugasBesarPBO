/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.transaksi;

/**
 * @author 1119002 Albertus Angkuw
 * @author 1119006 William Juniar
 * @author 1119038 Elangel Neilea Shaday
 *
 * @author ASUS
 */
public class KategoriTransaksi {
    private int idKategori;
    private String namakategori;
    private int harga;
    private char kategoriSemester;
    private int kategoriAngkatan;
    private int tahunBerlaku;

    public KategoriTransaksi(int idKategori, String namakategori, int harga, char kategoriSemester, int kategoriAngkatan, int tahunBerlaku) {
        this.idKategori = idKategori;
        this.namakategori = namakategori;
        this.harga = harga;
        this.kategoriSemester = kategoriSemester;
        this.kategoriAngkatan = kategoriAngkatan;
        this.tahunBerlaku = tahunBerlaku;
    }

    public int getIdKategori() {
        return idKategori;
    }

    public void setIdKategori(int idKategori) {
        this.idKategori = idKategori;
    }

    public String getNamakategori() {
        return namakategori;
    }

    public void setNamakategori(String namakategori) {
        this.namakategori = namakategori;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }


    public char getKategoriSemester() {
        return kategoriSemester;
    }

    public void setKategoriSemester(char kategoriSemester) {
        this.kategoriSemester = kategoriSemester;
    }

    public void setKategoriAngkatan(int kategoriAngkatan) {
        this.kategoriAngkatan = kategoriAngkatan;
    }

    public int getTahunBerlaku() {
        return tahunBerlaku;
    }

    public void setTahunBerlaku(int tahunBerlaku) {
        this.tahunBerlaku = tahunBerlaku;
    }

    @Override
    public String toString() {
        return "KategoriTransaksi{" + "idKategori=" + idKategori + ", namakategori=" + namakategori + ", harga=" + harga + ", kategoriSemester=" + kategoriSemester + ", kategoriAngkatan=" + kategoriAngkatan + ", tahunBerlaku=" + tahunBerlaku + '}';
    }
}
