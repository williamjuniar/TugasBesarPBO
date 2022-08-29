/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.matakuliah;

/**
 * @author 1119002 Albertus Angkuw
 * @author 1119006 William Juniar
 * @author 1119038 Elangel Neilea Shaday
 */
public class Nilai {
    private String NIM;
    private int nilai1;
    private int nilai2;
    private int nilai3;
    private int nilai4;
    private int nilai5;
    private int nilaiUAS;
    private float nilaiAkhir;
    private String hurufMutu;

    public Nilai(){
        
    }
    public Nilai(String nim,int nilai1, int nilai2, int nilai3, int nilai4, int nilai5, int nilaiUAS, float nilaiAkhir, String hurufMutu) {
        this.NIM = nim;
        this.nilai1 = nilai1;
        this.nilai2 = nilai2;
        this.nilai3 = nilai3;
        this.nilai4 = nilai4;
        this.nilai5 = nilai5;
        this.nilaiUAS = nilaiUAS;
        this.nilaiAkhir = nilaiAkhir;
        this.hurufMutu = hurufMutu;
    }

    public String getNIM() {
        return NIM;
    }

    public void setNIM(String NIM) {
        this.NIM = NIM;
    }

    
    public int getNilai1() {
        return nilai1;
    }

    public void setNilai1(int nilai1) {
        this.nilai1 = nilai1;
    }

    public int getNilai2() {
        return nilai2;
    }

    public void setNilai2(int nilai2) {
        this.nilai2 = nilai2;
    }

    public int getNilai3() {
        return nilai3;
    }

    public void setNilai3(int nilai3) {
        this.nilai3 = nilai3;
    }

    public int getNilai4() {
        return nilai4;
    }

    public void setNilai4(int nilai4) {
        this.nilai4 = nilai4;
    }

    public int getNilai5() {
        return nilai5;
    }

    public void setNilai5(int nilai5) {
        this.nilai5 = nilai5;
    }

    public int getNilaiUAS() {
        return nilaiUAS;
    }

    public void setNilaiUAS(int nilaiUAS) {
        this.nilaiUAS = nilaiUAS;
    }

    public float getNilaiAkhir() {
        return nilaiAkhir;
    }

    public void setNilaiAkhir(float nilaiAkhir) {
        this.nilaiAkhir = nilaiAkhir;
    }

    public String getHurufMutu() {
        return hurufMutu;
    }

    public void setHurufMutu(String hurufMutu) {
        this.hurufMutu = hurufMutu;
    }

    @Override
    public String toString() {
        return "Nilai{" + "nilai1=" + nilai1 + ", nilai2=" + nilai2 + ", nilai3=" + nilai3 + ", nilai4=" + nilai4 + ", nilai5=" + nilai5 + ", nilaiUAS=" + nilaiUAS + ", nilaiAkhir=" + nilaiAkhir + ", hurufMutu=" + hurufMutu + '}';
    }
    
    public float hitungNA(){
        float total = nilai1 + nilai2 + nilai3 + nilai4 + nilai5 + nilaiUAS;
        nilaiAkhir = total / 6;
        return nilaiAkhir;
    }
    
    public String convertHurufMutu(){
        float nilai = hitungNA();
        if(nilai >= 80){
            hurufMutu = "A";
        }else if(nilai >= 76){
            hurufMutu = "A-";
        }else if(nilai >= 72){
            hurufMutu = "B+";
        }else if(nilai >= 68){
            hurufMutu = "B";
        }else if(nilai >= 64){
            hurufMutu = "B-";
        }else if(nilai >= 60){
            hurufMutu = "C+";
        }else if(nilai >= 56){
            hurufMutu = "C";
        }else if(nilai >= 41){
            hurufMutu = "D";
        }else{
            hurufMutu = "E";
        }
        return hurufMutu;
    }
}
