/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.user;

import model.matakuliah.DetailMatakuliah;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author 1119002 Albertus Angkuw
 * @author 1119006 William Juniar
 * @author 1119038 Elangel Neilea Shaday
 */
public class Dosen extends User {
    private String NIM;
    private String programStudi;
    private String bidangIlmu;
    private String gelarAkademik;
    private String statusPegawai; //PNS/nonpns
    private String statusIkatanKerja; //Dosen tetap, tidak tetap , dll
    private boolean statusDosen;
    private ArrayList<DetailMatakuliah> Matakuliah;

    public Dosen(String NIM, String programStudi, String bidangIlmu, String gelarAkademik, String statusPegawai, String statusIkatanKerja, boolean statusDosen, ArrayList<DetailMatakuliah> Matakuliah, String idUser, String namaLengkap, String email, String password, Date tglLahir, String jenisKelamin, String notelp) {
        super(idUser, namaLengkap, email, password, tglLahir, jenisKelamin, notelp);
        this.NIM = NIM;
        this.programStudi = programStudi;
        this.bidangIlmu = bidangIlmu;
        this.gelarAkademik = gelarAkademik;
        this.statusPegawai = statusPegawai;
        this.statusIkatanKerja = statusIkatanKerja;
        this.statusDosen = statusDosen;
        this.Matakuliah = Matakuliah;
    }

    public Dosen() {
        super();
    }


    public ArrayList<DetailMatakuliah> getMatakuliah() {
        return Matakuliah;
    }

    public void setMatakuliah(ArrayList<DetailMatakuliah> Matakuliah) {
        this.Matakuliah = Matakuliah;
    }

    public String getNID() {
        return NIM;
    }

    public void setNID(String NIM) {
        this.NIM = NIM;
    }

    public String getProgramStudi() {
        return programStudi;
    }

    public void setProgramStudi(String programStudi) {
        this.programStudi = programStudi;
    }

    public String getBidangIlmu() {
        return bidangIlmu;
    }

    public void setBidangIlmu(String bidangIlmu) {
        this.bidangIlmu = bidangIlmu;
    }

    public String getGelarAkademik() {
        return gelarAkademik;
    }

    public void setGelarAkademik(String gelarAkademik) {
        this.gelarAkademik = gelarAkademik;
    }

    public String getStatusPegawai() {
        return statusPegawai;
    }

    public void setStatusPegawai(String statusPegawai) {
        this.statusPegawai = statusPegawai;
    }

    public String getStatusIkatanKerja() {
        return statusIkatanKerja;
    }

    public void setStatusIkatanKerja(String statusIkatanKerja) {
        this.statusIkatanKerja = statusIkatanKerja;
    }

    public boolean isStatusDosen() {
        return statusDosen;
    }

    public void setStatusDosen(boolean statusDosen) {
        this.statusDosen = statusDosen;
    }

    @Override
    public String toString() {
        return super.toString() +  "\n" + "Dosen{" + "NIM=" + NIM + ", programStudi=" + programStudi + ", bidangIlmu=" + bidangIlmu + ", gelarAkademik=" + gelarAkademik + ", statusPegawai=" + statusPegawai + ", statusIkatanKerja=" + statusIkatanKerja + ", statusDosen=" + statusDosen + ", Matakuliah=" + Matakuliah + '}';
    }
}