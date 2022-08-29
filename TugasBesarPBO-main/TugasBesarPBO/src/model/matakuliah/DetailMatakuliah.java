/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.matakuliah;

import java.util.ArrayList;

/**
 * @author 1119002 Albertus Angkuw
 * @author 1119006 William Juniar
 * @author 1119038 Elangel Neilea Shaday
 */
public class DetailMatakuliah extends Matakuliah{
    private String id_MK;
    private int tahun;
    private String semester;
    private char kelas;
    private int jumlahPertemuan;
    private String nid;
    private ArrayList<Nilai> nilaiMahasiswa;
    private ArrayList<Roster> jadwal;
    private ArrayList<Kehadiran> kehadiranMahasiswa;

    public DetailMatakuliah(){
        super();

    }

    public DetailMatakuliah(String id_MK, int tahun, String semester, char kelas, int jumlahPertemuan, String nid, ArrayList<Nilai> nilaiMahasiswa, ArrayList<Roster> jadwal, ArrayList<Kehadiran> kehadiranMahasiswa) {
        this.id_MK = id_MK;
        this.tahun = tahun;
        this.semester = semester;
        this.kelas = kelas;
        this.jumlahPertemuan = jumlahPertemuan;
        this.nid = nid;
        this.nilaiMahasiswa = nilaiMahasiswa;
        this.jadwal = jadwal;
        this.kehadiranMahasiswa = kehadiranMahasiswa;
    }
    
    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getId_MK() {
        return id_MK;
    }

    public void setId_MK(String id_MK) {
        this.id_MK = id_MK;
    }

    public int getTahun() {
        return tahun;
    }

    public void setTahun(int tahun) {
        this.tahun = tahun;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public char getKelas() {
        return kelas;
    }

    public void setKelas(char kelas) {
        this.kelas = kelas;
    }

    public int getJumlahPertemuan() {
        return jumlahPertemuan;
    }

    public void setJumlahPertemuan(int jumlahPertemuan) {
        this.jumlahPertemuan = jumlahPertemuan;
    }

    public ArrayList<Nilai> getNilaiMahasiswa() {
        return nilaiMahasiswa;
    }

    public void setNilaiMahasiswa(ArrayList<Nilai> nilaiMahasiswa) {
        this.nilaiMahasiswa = nilaiMahasiswa;
    }

    public ArrayList<Roster> getJadwal() {
        return jadwal;
    }

    public void setJadwal(ArrayList<Roster> jadwal) {
        this.jadwal = jadwal;
    }

    public ArrayList<Kehadiran> getKehadiranMahasiswa() {
        return kehadiranMahasiswa;
    }

    public void setKehadiranMahasiswa(ArrayList<Kehadiran> kehadiranMahasiswa) {
        this.kehadiranMahasiswa = kehadiranMahasiswa;
    }

    
    @Override
    public String toString() {
        return "DetailMatakuliah{" + "id_MK=" + id_MK + ", tahun=" + tahun + ", semester=" + semester + ", kelas=" + kelas + ", jumlahPertemuan=" + jumlahPertemuan + ", nilaiMahasiswa=" + nilaiMahasiswa + ", jadwal=" + jadwal + ", kehadiranMahasiswa=" + kehadiranMahasiswa + '}';
    }
    
    public int hitungKehadiran(Kehadiran dataKehadiran){
        int counter = 0;
        if(dataKehadiran.getKeterangan() == "Hadir"){
            counter++;
        }
        return counter;
    }
}
