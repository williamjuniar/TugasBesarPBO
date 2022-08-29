/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.menuMahasiswa;

import controller.DatabaseController.ContollerDaak.MatakuliahManageController;
import controller.DatabaseController.ContollerDaak.RencanaStudiManageController;
import controller.UserManager;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.matakuliah.DetailMatakuliah;
import model.matakuliah.Matakuliah;
import model.matakuliah.RencanaStudi;
import model.user.Mahasiswa;
import view.ViewConfig;
import static view.ViewConfig.BGCOLOR_DEFAULT;
import static view.ViewConfig.FONT_DEFAULT_PLAIN;
import static view.ViewConfig.FONT_TITLE;
/**
 *
 * @author 1119002 Albertus Angkuw
 * @author 1119038 Elangel Neilea Shaday
 */
public class JPanelRencanaStudi  extends JPanel implements ActionListener, ViewConfig {
    private final JPanel Header;
    private final JLabel Judul, Tahun, Semester;
    private final JComboBox ViewSemester;
    private final String SemesterValue[] = {"", "Ganjil", "Genap", "Pendek"};
    private final JTextField ViewTahun;
    private final JButton Find;
    private final JTable rencanaStudi;
    JScrollPane jScrollPane1;
    public JPanelRencanaStudi(){
        Header = new JPanel();
        Header.setBackground(Color.DARK_GRAY);
        Header.setBounds(0,20,700,50);
        Judul = new JLabel("INSTITUTE TEKNOLOGI HARAPAN BANGSA");
        Judul.setForeground(Color.WHITE);
        Judul.setFont(FONT_TITLE);
        Header.add(Judul);
        add(Header);
        setLayout(null);
        
        Tahun = new JLabel("Tahun");
        Tahun.setBounds(40,50,100,100);
        add(Tahun);
        ViewTahun = new JTextField();
        ViewTahun.setBounds(85,90,50,25);
        add(ViewTahun);
        Semester = new JLabel("Semester");
        Semester.setBounds(145,50,100,100);
        add(Semester);
        ViewSemester = new JComboBox(SemesterValue);
        ViewSemester.setBounds(210,90,100,25);
        add(ViewSemester);
        //Button Lihat Daftar Hadir
        Find = new JButton("Lihat Daftar Matakuliah");
        Find.setBounds(330,88,300,30);
        Find.setContentAreaFilled(true);
        Find.setBackground(Color.WHITE);
        Find.setForeground(BGCOLOR_DEFAULT);
        Find.setBorder(javax.swing.BorderFactory.createLineBorder(BGCOLOR_DEFAULT));
        Find.setFocusPainted(false);
        Find.setFont(FONT_DEFAULT_PLAIN);
        Find.addActionListener(this);
        add(Find);
        
        rencanaStudi = new JTable();
        jScrollPane1 = new JScrollPane();
    }
    public void showTables(){
        //Table Daftar Hadir
        int printTahun = Integer.valueOf(ViewTahun.getText());
        String printSemester = ViewSemester.getSelectedItem().toString();
        Mahasiswa mhs = UserManager.getInstance().getMahasiswa();
        RencanaStudi rsm = RencanaStudiManageController.getRencanastudi(mhs.getNIM(), printTahun, printSemester);
        ArrayList<Matakuliah> MK = new ArrayList<>();
        if(rsm == null){
            JOptionPane.showMessageDialog(null,"Maaf rencana studi tidak ditemukan ");
            return;
        }
        for(int i=0; i<rsm.getId_Mk().size(); i++){
            DetailMatakuliah detailMK = MatakuliahManageController.getDetailMatakuliah(rsm.getId_Mk().get(i));
            MK.add(MatakuliahManageController.getMatakuliah(detailMK.getKode_MK()));
        }
        //Cek Database
        String objectRencanaStudi[][] = new String[MK.size()][6];
        for(int i=0; i<MK.size(); i++){
            objectRencanaStudi[i][0] = String.valueOf(i+1) + ". ";
            objectRencanaStudi[i][1] = MK.get(i).getKode_MK();
            objectRencanaStudi[i][2] = MK.get(i).getNama_MK();
            objectRencanaStudi[i][3] = String.valueOf(MatakuliahManageController.getDetailMatakuliah(rsm.getId_Mk().get(i)).getKelas());
            objectRencanaStudi[i][4] = MK.get(i).getJenis_MK().toString();
            objectRencanaStudi[i][5] = MK.get(i).getSifat_MK().toString();
        }
        rencanaStudi.setModel(new DefaultTableModel(
            objectRencanaStudi, 
            new String[] {
                "No", "Kode MK", "Nama Matakuliah", "Kelas", "Jenis MK","Sifat MK"
            }
        ){
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
            @Override
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(rencanaStudi);
        if (rencanaStudi.getColumnModel().getColumnCount() > 0) {
            rencanaStudi.getColumnModel().getColumn(0).setPreferredWidth(30);
            rencanaStudi.getColumnModel().getColumn(1).setPreferredWidth(60);
            rencanaStudi.getColumnModel().getColumn(2).setPreferredWidth(200);
            rencanaStudi.getColumnModel().getColumn(3).setPreferredWidth(30);
            rencanaStudi.getColumnModel().getColumn(4).setPreferredWidth(60);
            rencanaStudi.getColumnModel().getColumn(5).setPreferredWidth(60);
        }
        jScrollPane1.setBounds(15,140,640,460);
        jScrollPane1.setVisible(true);
        add(jScrollPane1);
    }
    private boolean checkAllData(){
        if(ViewTahun.getText().equals("")){
            return false;
        }
        if(ViewSemester.getSelectedItem().toString().equals("")){
            return false;
        }
        return true;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        System.out.println("Action Panel Rencana Studi: " + action);
        if(action.equals("Lihat Daftar Matakuliah")){
            if(checkAllData() == false){
                JOptionPane.showMessageDialog(null,"Silahkan Isi Semua Data!");
            }else{
                Find.setBackground(BGCOLOR_DEFAULT);
                Find.setForeground(COLOR_WHITE);
                showTables();
            }
        }
    }
    @Override
    public Dimension getPreferredSize() {
        return DIMENSION_PANEL_CARD;
    }
}
