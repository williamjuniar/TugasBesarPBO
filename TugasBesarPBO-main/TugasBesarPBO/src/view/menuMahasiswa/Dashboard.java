/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.menuMahasiswa;

import controller.UserManager;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.*;
import static javax.swing.BorderFactory.createMatteBorder;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import view.ViewConfig;
import view.loginMenu;
/**
 *
 * @author 1119002 Albertus Angkuw
 * @author 1119038 Elangel Neilea Shaday
 */
public class Dashboard implements ActionListener,ViewConfig {
    private final CardLayout card;
    private final JPanel cardPanel;
    private final JPanel sideBar;
    //--List Card as Menu
    
    //Menu Mahasiswa
    private final JPanelProfile profile;
    private final JPanelRencanaStudi rencanaStudi;
    private final JPanelDaftarHadir daftarHadir;
    private final JPanelTranskripNilai transkripNilai;
    private final JPanelKeuangan keuangan;
    private final JPanelJadwal jadwal;
    
    //List Button
    private final JButton showProfile ;
    private final JButton showRencanaStudi ;
    private final JButton showDaftarHadir;
    private final JButton showTranskripNilai ;
    private final JButton showKeuangan ;
    private final JButton showJadwal;
    private JButton exit;
    private JFrame frame;
    public Dashboard(){
        card = new CardLayout();
        cardPanel = new JPanel(card);
        sideBar = new JPanel(new GridLayout(10, 1, 10, 5));
        
        //--Action Menu
        showProfile = new JButton("Profile");
        showRencanaStudi = new JButton("Rencana Studi");
        showDaftarHadir = new JButton("Daftar Hadir");
        showTranskripNilai = new JButton("Transkrip Nilai");
        showKeuangan = new JButton("Keuangan");
        showJadwal = new JButton("Jadwal");
        exit = new JButton("Keluar");
        sideBar.add(showProfile);
        sideBar.add(showRencanaStudi);
        sideBar.add(showDaftarHadir);
        sideBar.add(showTranskripNilai);
        sideBar.add(showKeuangan);
        sideBar.add(showJadwal);
        sideBar.add(exit);
        //--Styling
        
        sideBar.setBackground(BGCOLOR_DEFAULT);
        sideBar.setBorder(new EmptyBorder(130, 0, 15, 0));
        
        showProfile.setBackground(BGCOLOR_DEFAULT);
        showRencanaStudi.setBackground(BGCOLOR_DEFAULT);
        showDaftarHadir.setBackground(BGCOLOR_DEFAULT);
        showTranskripNilai.setBackground(BGCOLOR_DEFAULT);
        showKeuangan.setBackground(BGCOLOR_DEFAULT);
        showJadwal.setBackground(BGCOLOR_DEFAULT);
        exit.setBackground(BGCOLOR_DEFAULT);
        
        showProfile.setForeground(COLOR_WHITE );
        showRencanaStudi.setForeground(COLOR_GRAY);
        showDaftarHadir.setForeground(COLOR_GRAY);
        showTranskripNilai.setForeground(COLOR_GRAY);
        showKeuangan.setForeground(COLOR_GRAY);
        showJadwal.setForeground(COLOR_GRAY);
        exit.setForeground(COLOR_GRAY);
        
        showProfile.setBorder(createMatteBorder(0, 12, 0, 0, COLOR_WHITE));
        showRencanaStudi.setBorder(createMatteBorder(0, 12, 0, 0, COLOR_WHITE));
        showDaftarHadir.setBorder(createMatteBorder(0, 12, 0, 0, COLOR_WHITE));
        showTranskripNilai.setBorder(createMatteBorder(0, 12, 0, 0, COLOR_WHITE));
        showKeuangan.setBorder(createMatteBorder(0, 12, 0, 0, COLOR_WHITE));
        showJadwal.setBorder(createMatteBorder(0, 12, 0, 0, COLOR_WHITE));
        exit.setBorder(createMatteBorder(0, 12, 0, 0, COLOR_WHITE));
        
        showProfile.setPreferredSize(new Dimension(200, 20));
        showRencanaStudi.setPreferredSize(new Dimension(200, 20));
        showDaftarHadir.setPreferredSize(new Dimension(200, 20));
        showTranskripNilai.setPreferredSize(new Dimension(200, 20));
        showKeuangan.setPreferredSize(new Dimension(200, 20));
        showJadwal.setPreferredSize(new Dimension(200, 20));
        exit.setPreferredSize(new Dimension(200, 20));
        
        showProfile.setBorderPainted(true);
        showRencanaStudi.setBorderPainted(false);
        showDaftarHadir.setBorderPainted(false);
        showTranskripNilai.setBorderPainted(false);
        showKeuangan.setBorderPainted(false);
        showJadwal.setBorderPainted(false);
        exit.setBorderPainted(false);
                
        showProfile.setContentAreaFilled(false);
        showRencanaStudi.setContentAreaFilled(false);
        showDaftarHadir.setContentAreaFilled(false);
        showTranskripNilai.setContentAreaFilled(false);
        showKeuangan.setContentAreaFilled(false);
        showJadwal.setContentAreaFilled(false);
        exit.setContentAreaFilled(false);
        
        showProfile.setFocusPainted(false);
        showRencanaStudi.setFocusPainted(false);
        showDaftarHadir.setFocusPainted(false);
        showTranskripNilai.setFocusPainted(false);
        showKeuangan.setFocusPainted(false);
        showJadwal.setFocusPainted(false);
        exit.setFocusPainted(false);
        //End of styling
        
        showProfile.addActionListener(this);
        showRencanaStudi.addActionListener(this);
        showDaftarHadir.addActionListener(this);
        showTranskripNilai.addActionListener(this);
        showKeuangan.addActionListener(this);
        showJadwal.addActionListener(this);
        exit.addActionListener(this);
        
        //--List Menu
        profile = new JPanelProfile();
        rencanaStudi = new JPanelRencanaStudi();
        daftarHadir = new JPanelDaftarHadir();
        transkripNilai = new JPanelTranskripNilai();
        keuangan = new JPanelKeuangan();
        jadwal = new JPanelJadwal();
        
        cardPanel.add(profile,"ProfilePanel");
        cardPanel.add(rencanaStudi,"RencanaStudiPanel");
        cardPanel.add(daftarHadir,"DaftarHadirPanel");
        cardPanel.add(transkripNilai,"TranskripNilaiPanel");
        cardPanel.add(keuangan,"KeuanganPanel");
        cardPanel.add(jadwal,"JadwalPanel");
        
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
        showRencanaStudi.setForeground(COLOR_GRAY);
        showDaftarHadir.setForeground(COLOR_GRAY);
        showTranskripNilai.setForeground(COLOR_GRAY);
        showKeuangan.setForeground(COLOR_GRAY);
        showJadwal.setForeground(COLOR_GRAY);
        
        showProfile.setBorderPainted(false);
        showRencanaStudi.setBorderPainted(false);
        showDaftarHadir.setBorderPainted(false);
        showTranskripNilai.setBorderPainted(false);
        showKeuangan.setBorderPainted(false);
        showJadwal.setBorderPainted(false);
        if("Profile".equals(option)){
            card.show(cardPanel,"ProfilePanel");
            showProfile.setBorderPainted(true);
            showProfile.setForeground(COLOR_WHITE);
        }else if("Rencana Studi".equals(option)){
            card.show(cardPanel,"RencanaStudiPanel");
            showRencanaStudi.setBorderPainted(true);
            showRencanaStudi.setForeground(COLOR_WHITE);
        }else if("Daftar Hadir".equals(option)){
            card.show(cardPanel,"DaftarHadirPanel");
            showDaftarHadir.setBorderPainted(true);
            showDaftarHadir.setForeground(COLOR_WHITE);
        }else if("Transkrip Nilai".equals(option)){
            card.show(cardPanel,"TranskripNilaiPanel");
            showTranskripNilai.setBorderPainted(true);
            showTranskripNilai.setForeground(COLOR_WHITE);
        }else if("Keuangan".equals(option)){
            card.show(cardPanel,"KeuanganPanel");
            showKeuangan.setBorderPainted(true);
            showKeuangan.setForeground(COLOR_WHITE);
        }else if("Jadwal".equals(option)){
            card.show(cardPanel,"JadwalPanel");
            showJadwal.setBorderPainted(true);
            showJadwal.setForeground(COLOR_WHITE);
        }else if("Keluar".equals(option)){
            System.out.println("Keluar");
            frame.dispose();
            UserManager.getInstance().setUser(null);
            loginMenu loginMenu = new loginMenu();
        }
        
        //System.out.println(option);
    }
//    public static void main(String[] args){
//        dashboard dashboard = new dashboard();
//    }
}
