/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.menuDosen;

import controller.UserManager;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.*;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import view.ViewConfig;
import view.loginMenu;
/**
 *
 * @author 1119002 Albertus Angkuw
 * @author 1119006 William Juniar
 */
public class Dashboard implements ActionListener,ViewConfig {
    private final CardLayout card;
    private final JPanel cardPanel;
    private final JPanel sideBar;
    //--List Card as Menu
   
    //Menu Dosen
    private final JPanelProfile profile;
    private final JPanelJadwalMengajar jadwalmengajar;
    private final JPanelDaftarHadir daftarhadir;
    private final JPanelNilaiMatakuliah nilaimatakuliah;
    private final JPanelRekapDataMengajar rekapdatamengajar;
    
    
    //List Button
    private final JButton showProfile;
    private final JButton showJadwalMengajar;
    private final JButton showDaftarHadir;
    private final JButton showNilaiMatakuliah;
    private final JButton showRekapDataMengajar;
    private JButton exit;
    
    private JFrame frame;
    public Dashboard(){
        card = new CardLayout();
        cardPanel = new JPanel(card);
        sideBar = new JPanel(new GridLayout(10, 1, 10, 5));
        
        //--Action Menu
        showProfile = new JButton("Profile");
        showJadwalMengajar = new JButton("Jadwal Mengajar");
        showDaftarHadir = new JButton("Daftar Hadir");
        showNilaiMatakuliah = new JButton("Nilai Matakuliah");
        showRekapDataMengajar = new JButton("Rekap Data Mengajar");
        exit = new JButton("Keluar");
        sideBar.add(showProfile);
        sideBar.add(showJadwalMengajar);
        sideBar.add(showDaftarHadir);
        sideBar.add(showNilaiMatakuliah);
        sideBar.add(showRekapDataMengajar);
        sideBar.add(exit);
        //--Styling
        
        sideBar.setBackground(BGCOLOR_DEFAULT);
        sideBar.setBorder(new EmptyBorder(130, 0, 15, 0));
        
        showProfile.setBackground(BGCOLOR_DEFAULT);
        showJadwalMengajar.setBackground(BGCOLOR_DEFAULT);
        showDaftarHadir.setBackground(BGCOLOR_DEFAULT);
        showNilaiMatakuliah.setBackground(BGCOLOR_DEFAULT);
        showRekapDataMengajar.setBackground(BGCOLOR_DEFAULT);
        exit.setBackground(BGCOLOR_DEFAULT);
        
        showProfile.setForeground(COLOR_WHITE );
        showJadwalMengajar.setForeground(COLOR_GRAY);
        showDaftarHadir.setForeground(COLOR_GRAY);
        showNilaiMatakuliah.setForeground(COLOR_GRAY);
        showRekapDataMengajar.setForeground(COLOR_GRAY);
        exit.setForeground(COLOR_GRAY);
        
        showProfile.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 12, 0, 0, COLOR_WHITE));
        showJadwalMengajar.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 12, 0, 0, COLOR_WHITE));
        showDaftarHadir.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 12, 0, 0, COLOR_WHITE));
        showNilaiMatakuliah.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 12, 0, 0, COLOR_WHITE));
        showRekapDataMengajar.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 12, 0, 0, COLOR_WHITE));
        exit.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 12, 0, 0, COLOR_WHITE));
        
        showProfile.setPreferredSize(new Dimension(200, 20));
        showJadwalMengajar.setPreferredSize(new Dimension(200, 20));
        showDaftarHadir.setPreferredSize(new Dimension(200, 20));
        showNilaiMatakuliah.setPreferredSize(new Dimension(200, 20));
        showRekapDataMengajar.setPreferredSize(new Dimension(200, 20));
        exit.setPreferredSize(new Dimension(200, 20));
        
        showProfile.setBorderPainted(true);
        showJadwalMengajar.setBorderPainted(false);
        showDaftarHadir.setBorderPainted(false);
        showNilaiMatakuliah.setBorderPainted(false);
        showRekapDataMengajar.setBorderPainted(false);
        exit.setBorderPainted(false);
        
        showProfile.setContentAreaFilled(false);
        showJadwalMengajar.setContentAreaFilled(false);
        showDaftarHadir.setContentAreaFilled(false);
        showNilaiMatakuliah.setContentAreaFilled(false);
        showRekapDataMengajar.setContentAreaFilled(false);
        exit.setContentAreaFilled(false);
        
        showProfile.setFocusPainted(false);
        showJadwalMengajar.setFocusPainted(false);
        showDaftarHadir.setFocusPainted(false);
        showNilaiMatakuliah.setFocusPainted(false);
        showRekapDataMengajar.setFocusPainted(false);
        exit.setFocusPainted(false);
        //End of styling
        
        showProfile.addActionListener(this);
        showJadwalMengajar.addActionListener(this);
        showDaftarHadir.addActionListener(this);
        showNilaiMatakuliah.addActionListener(this);
        showRekapDataMengajar.addActionListener(this);
        exit.addActionListener(this);
        
        //--List Menu
        profile = new JPanelProfile();
        jadwalmengajar = new JPanelJadwalMengajar();
        daftarhadir = new JPanelDaftarHadir();
        nilaimatakuliah = new JPanelNilaiMatakuliah();
        rekapdatamengajar = new JPanelRekapDataMengajar();
        
        cardPanel.add(profile,"ProfilePanel");
        cardPanel.add(jadwalmengajar,"JadwalMengajarPanel");
        cardPanel.add(daftarhadir,"DaftarHadirPanel");
        cardPanel.add(nilaimatakuliah,"NilaiMatakuliahPanel");
        cardPanel.add(rekapdatamengajar,"RekapDataMengajarPanel");
        
        //End of List Menu
        
        //-- Inisialisasi Frame
        frame = new JFrame("Sistem Informasi Akademik");
        frame.add(cardPanel);
        frame.add(sideBar, BorderLayout.WEST);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        //End of Inisialisasi Frame
    }
    @Override
    public void actionPerformed(ActionEvent e){
        String option = e.getActionCommand();
        
        showProfile.setForeground(COLOR_GRAY);
        showJadwalMengajar.setForeground(COLOR_GRAY);
        showDaftarHadir.setForeground(COLOR_GRAY);
        showNilaiMatakuliah.setForeground(COLOR_GRAY);
        showRekapDataMengajar.setForeground(COLOR_GRAY);
        
        showProfile.setBorderPainted(false);
        showJadwalMengajar.setBorderPainted(false);
        showDaftarHadir.setBorderPainted(false);
        showNilaiMatakuliah.setBorderPainted(false);
        showRekapDataMengajar.setBorderPainted(false);
        if("Profile".equals(option)){
            card.show(cardPanel,"ProfilePanel");
            showProfile.setBorderPainted(true);
            showProfile.setForeground(COLOR_WHITE);
        }else if("Jadwal Mengajar".equals(option)){
            card.show(cardPanel,"JadwalMengajarPanel");
            showJadwalMengajar.setBorderPainted(true);
             showJadwalMengajar.setForeground(COLOR_WHITE);
        }else if("Daftar Hadir".equals(option)){
            card.show(cardPanel,"DaftarHadirPanel");
            showDaftarHadir.setBorderPainted(true);
            showDaftarHadir.setForeground(COLOR_WHITE);
        }else if("Nilai Matakuliah".equals(option)){
            card.show(cardPanel,"NilaiMatakuliahPanel");
            showNilaiMatakuliah.setBorderPainted(true);
            showNilaiMatakuliah.setForeground(COLOR_WHITE);
        }else if("Rekap Data Mengajar".equals(option)){
            card.show(cardPanel,"RekapDataMengajarPanel");
            showRekapDataMengajar.setBorderPainted(true);
            showRekapDataMengajar.setForeground(COLOR_WHITE);
        }else if("Keluar".equals(option)){
            System.out.println("Keluar");
            frame.dispose();
            UserManager.getInstance().setUser(null);
            loginMenu loginMenu = new loginMenu();
        }
        //System.out.println(option);
    }
//    public static void main(String[] args) {
//        new Dashboard();
//    }
}
