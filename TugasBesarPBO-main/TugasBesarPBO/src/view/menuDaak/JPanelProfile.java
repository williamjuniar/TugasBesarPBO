/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.menuDaak;


import controller.UserManager;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import model.user.Daak;
import view.ViewConfig;
import static view.ViewConfig.BGCOLOR_DEFAULT;
import static view.ViewConfig.COLOR_WHITE;
import static view.ViewConfig.DIMENSION_PANEL_CARD;
import static view.ViewConfig.FONT_DEFAULT_PLAIN;
import static view.ViewConfig.FONT_TITLE;

/**
 *
 * @author 1119002 Albertus Angkuw
 */
public class JPanelProfile extends JPanel implements ViewConfig{
    private final JPanel Header;
    private final JLabel Judul;
    private final JLabel NIK, Nama, Jabatan, StatusKontrak, TanggalLahir, JenisKelamin, NomorHP, Email, HAKeuangan, HAKemahasiswaan, HARencanaStudi, HAUser, HAJadwal;
    private final JLabel ViewNIK, ViewNama, ViewJabatan, ViewStatusKontrak, ViewTanggalLahir, ViewJenisKelamin, ViewNomorHP, ViewEmail, ViewHAKeuangan, ViewHAKemahasiswaan, ViewHARencanaStudi, ViewHAUser, ViewHAJadwal;
    
    public JPanelProfile(){
        Daak daak = UserManager.getInstance().getDaak();
        
        Header = new JPanel();
        Header.setBackground(Color.DARK_GRAY);
        Header.setBounds(0,20,700,50);
        Judul = new JLabel("INSTITUTE TEKNOLOGI HARAPAN BANGSA");
        Judul.setForeground(Color.WHITE);
        Judul.setFont(FONT_TITLE);
        Header.add(Judul);
        add(Header);
        setLayout(null);
       
        JLabel ViewFoto;
        Image img = null;
        try {
            img = ImageIO.read(new URL(daak.getPathFoto()));
        } catch (Exception ex) {
            String RESOURCE = "../asset/profile-dp.png";
            URL url = getClass().getResource( RESOURCE );
            if(url == null ){
                try {
                    throw new Exception( "ERR cannot find resource: " + RESOURCE );
                } catch (Exception ex1) {
                    Logger.getLogger(view.menuMahasiswa.JPanelProfile.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
            img = Toolkit.getDefaultToolkit().getImage( url );
            System.out.println("Error " + ex.getMessage());
        } 
        Image newPicture1 = img.getScaledInstance(300,300, Image.SCALE_SMOOTH);
        ImageIcon image1 = new ImageIcon(newPicture1);
        ViewFoto = new JLabel(image1);
        ViewFoto.setBounds(50,100,270,300);
        add(ViewFoto);
        //NIM
        NIK = new JLabel("NIK");
        NIK.setBounds(350,80,170,100);
        add(NIK);
        ViewNIK = new JLabel(": " + daak.getNIK());
        ViewNIK.setBounds(490,80,200,100);
        add(ViewNIK);
        //Nama
        Nama = new JLabel("Nama");
        Nama.setBounds(350,110,170,100);
        add(Nama);
        ViewNama = new JLabel(":  " + daak.getNamaLengkap());
        ViewNama.setBounds(490,110,200,100);
        add(ViewNama);
        //Jurusan
        Jabatan = new JLabel("Jabatan ");
        Jabatan.setBounds(350,140,170,100);
        add(Jabatan);
        ViewJabatan = new JLabel(": " + daak.getJabatan());
        ViewJabatan.setBounds(490,140,200,100);
        add(ViewJabatan);
        //Angkatan
        String statusKontrak = "Aktif";
        if(!daak.isStatusKontrak()){
            statusKontrak = "Tidak Aktif";
        }
        StatusKontrak = new JLabel("Status Kontrak");
        StatusKontrak.setBounds(350,170,170,100);
        add(StatusKontrak);
        ViewStatusKontrak = new JLabel(": " + statusKontrak);
        ViewStatusKontrak.setBounds(490,170,200,100);
        add(ViewStatusKontrak);
        //Tanggal Lahir
        DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");  
        String tgllahir = dateFormat.format(daak.getTanggalLahir());
        TanggalLahir = new JLabel("Tanggal Lahir");
        TanggalLahir.setBounds(350,200,170,100);
        add(TanggalLahir);
        ViewTanggalLahir = new JLabel(": " + tgllahir);
        ViewTanggalLahir.setBounds(490,200,200,100);
        add(ViewTanggalLahir);
        //Jenis Kelamin
        JenisKelamin = new JLabel("Jenis Kelamin");
        JenisKelamin.setBounds(350,230,170,100);
        add(JenisKelamin);
        ViewJenisKelamin = new JLabel(": " + daak.getJenisKelamin());
        ViewJenisKelamin.setBounds(490,230,200,100);
        add(ViewJenisKelamin);
        //Nomor HP
        NomorHP = new JLabel("Nomor HP");
        NomorHP.setBounds(350,260,170,100);
        add(NomorHP);
        ViewNomorHP = new JLabel(": " + daak.getNomorTelepon());
        ViewNomorHP.setBounds(490,260,200,100);
        add(ViewNomorHP);
        //Email
        Email = new JLabel("Email");
        Email.setBounds(350,290,170,100);
        add(Email);
        ViewEmail = new JLabel(": " + daak.getEmail());
        ViewEmail.setBounds(490,290,200,100);
        add(ViewEmail);
        //Alamat 
        HAKeuangan = new JLabel("Akses Keuangan");
        HAKeuangan.setBounds(350,320,170,100);
        add(HAKeuangan);
        ViewHAKeuangan = new JLabel(": " + getPrivilege(daak.isHakAksesKeuangan()));
        ViewHAKeuangan.setBounds(490,320,200,100);
        add(ViewHAKeuangan);
        
        HAKemahasiswaan = new JLabel("Akses Matakuliah");
        HAKemahasiswaan.setBounds(350,350,170,100);
        add(HAKemahasiswaan);
        ViewHAKemahasiswaan = new JLabel(": " + getPrivilege(daak.isHakAksesMatakuliah()));
        ViewHAKemahasiswaan.setBounds(490,350,200,100);
        add(ViewHAKemahasiswaan);
        
        HARencanaStudi = new JLabel("Akses Rencana Studi");
        HARencanaStudi.setBounds(350,380,170,100);
        add(HARencanaStudi);
        ViewHARencanaStudi = new JLabel(": " + getPrivilege(daak.isHakAksesRencanaStudi()));
        ViewHARencanaStudi.setBounds(490,380,200,100);
        add(ViewHARencanaStudi);
        
        HAUser = new JLabel("Akses User");
        HAUser.setBounds(350,410,170,100);
        add(HAUser);
        ViewHAUser = new JLabel(": " + getPrivilege(daak.isHakAksesUser()));
        ViewHAUser.setBounds(490,410,200,100);
        add(ViewHAUser);
        
        HAJadwal = new JLabel("Akses Jadwal Kuliah");
        HAJadwal.setBounds(350,440,170,100);
        add(HAJadwal);
        ViewHAJadwal = new JLabel(": " + getPrivilege(daak.isHakAksesJadwalPerkuliahan()));
        ViewHAJadwal.setBounds(490,440,200,100);
        add(ViewHAJadwal);
    }
    
    private String getPrivilege(boolean privilege){
        if(privilege){
            return "Boleh";        
        }
        return "Tidak Boleh";
    }
    @Override
    public Dimension getPreferredSize() {
        return DIMENSION_PANEL_CARD;
    }
}
