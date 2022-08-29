/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.user;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author 1119002 Albertus Angkuw
 * @author 1119006 William Juniar
 * @author 1119038 Elangel Neilea Shaday
 */
public abstract class User {
    private String idUser;
    private String namaLengkap;
    private String email;
    private String password;
    private Date tanggalLahir;
    private String jenisKelamin;
    private String nomorTelepon;
    private int jenisUser;
    private String pathFoto;
    public User(){
        
    }
    public User(String idUser, String namaLengkap, String email, String password, Date tanggalLahir, String jenisKelamin, String nomorTelepon) {
        this.idUser = idUser;
        this.namaLengkap = namaLengkap;
        this.email = email;
        this.password = password;
        this.tanggalLahir = tanggalLahir;
        this.jenisKelamin = jenisKelamin;
        this.nomorTelepon = nomorTelepon;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser() {
        try { 
            String input = namaLengkap + String.valueOf(jenisUser) + email;
            // Static getInstance method is called with hashing MD5 
            MessageDigest md = MessageDigest.getInstance("MD5"); 
  
            // digest() method is called to calculate message digest 
            //  of an input digest() return array of byte 
            byte[] messageDigest = md.digest(input.getBytes()); 
  
            // Convert byte array into signum representation 
            BigInteger no = new BigInteger(1, messageDigest); 
  
            // Convert message digest into hex value 
            String hashtext = no.toString(16); 
            while (hashtext.length() < 32) { 
                hashtext = "0" + hashtext; 
            }
            this.idUser = hashtext; 
        }  
  
        // For specifying wrong message digest algorithms 
        catch (NoSuchAlgorithmException e) { 
            this.idUser = "";
            throw new RuntimeException(e); 
        } 
        
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }
    
    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = getSHA(password);
    }

    public Date getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getNomorTelepon() {
        return nomorTelepon;
    }

    public void setNomorTelepon(String nomorTelepon) {
        this.nomorTelepon = nomorTelepon;
    }

    public int getJenisUser() {
        return jenisUser;
    }

    public void setJenisUser(int jenisUser) {
        this.jenisUser = jenisUser;
    }

    public String getPathFoto() {
        return pathFoto;
    }

    public void setPathFoto(String pathFoto) {
        this.pathFoto = pathFoto;
    }
    
    public static String getSHA(String input){  
        /*
            Reference Code https://www.geeksforgeeks.org/sha-256-hash-in-java/?ref=lbp
        */
        // Static getInstance method is called with hashing SHA  
        MessageDigest md = null;  
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
  
        // digest() method called  
        // to calculate message digest of an input  
        // and return array of byte 
        BigInteger number = new BigInteger(1,md.digest(input.getBytes(StandardCharsets.UTF_8)));
        
        // Convert message digest into hex value  
        StringBuilder hexString = new StringBuilder(number.toString(16));  
  
        // Pad with leading zeros 
        while (hexString.length() < 32){  
            hexString.insert(0, '0');  
        }  
        return hexString.toString();  
    } 
    
    public boolean checkPassword(String passwordInput){
        String hashPwd = getSHA(passwordInput);
        return hashPwd.equals(password);
    }

    @Override
    public String toString() {
        return "User{" + "idUser=" + idUser + ", namaLengkap=" + namaLengkap + ", email=" + email + ", password=" + password + ", tanggalLahir=" + tanggalLahir + ", jenisKelamin=" + jenisKelamin + ", nomorTelepon=" + nomorTelepon + ", jenisUser=" + jenisUser + ", pathFoto=" + pathFoto + '}';
    }

    
}
