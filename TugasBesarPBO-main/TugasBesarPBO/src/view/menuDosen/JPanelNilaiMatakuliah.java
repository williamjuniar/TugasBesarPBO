/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.menuDosen;

import controller.DatabaseController.ContollerDaak.UserManageController;
import controller.DatabaseController.ControllerDosen.MatakuliahController;
import controller.DatabaseController.ControllerDosen.NilaiController;
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
import model.matakuliah.Nilai;
import model.user.Dosen;
import view.ViewConfig;
import static view.ViewConfig.BGCOLOR_DEFAULT;
import static view.ViewConfig.COLOR_WHITE;
import static view.ViewConfig.DIMENSION_PANEL_CARD;
import static view.ViewConfig.FONT_DEFAULT_PLAIN;
import static view.ViewConfig.FONT_TITLE;
/**
 *
 * @author 1119002 Albertus Angkuw
 * @author 1119006 William Juniar
 */
public class JPanelNilaiMatakuliah  extends JPanel implements ActionListener, ViewConfig{
    ArrayList<DetailMatakuliah> dmk = null;
    private final JPanel Header;
    private final JLabel Judul, Tahun, Semester,Matakuliah;
    private JComboBox ViewSemester,ViewMatakuliah;
    private final JButton Find,Next,Save;
    private final String SemesterValue[] = {"", "Ganjil", "Genap", "Pendek"};
    private final JTextField ViewTahun;
    private final JTable daftarNilai;
    private JScrollPane jScrollPane1;
    private String idMK = null;
    public JPanelNilaiMatakuliah(){
        Header = new JPanel();
        Header.setBackground(Color.DARK_GRAY);
        Header.setBounds(0,20,700,50);
        Judul = new JLabel("INSTITUT TEKNOLOGI HARAPAN BANGSA");
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
       
        Next = new JButton("Next");
        Next.setBounds(330,88,150,30);
        Next.setContentAreaFilled(true);
        Next.setBackground(Color.WHITE);
        Next.setForeground(BGCOLOR_DEFAULT);
        Next.setBorder(javax.swing.BorderFactory.createLineBorder(BGCOLOR_DEFAULT));
        Next.setFocusPainted(false);
        Next.setFont(FONT_DEFAULT_PLAIN);
        Next.setVisible(true);
        Next.addActionListener(this);
        add(Next);
        
        Matakuliah = new JLabel("Matakuliah");
        Matakuliah.setBounds(40,140,100,30);
        Matakuliah.setVisible(false);
        add(Matakuliah);
       
        
        Save = new JButton("Save");      
        Save.setBounds(15,520,125,30);
        Save.setContentAreaFilled(true);
        Save.setBackground(Color.WHITE);
        Save.setForeground(BGCOLOR_DEFAULT);
        Save.setBorder(javax.swing.BorderFactory.createLineBorder(BGCOLOR_DEFAULT));
        Save.setFocusPainted(false);
        Save.setFont(FONT_DEFAULT_PLAIN);
        Save.setVisible(false);
        Save.addActionListener(this);
        add(Save);
        //Button Lihat Daftar Hadir
        Find = new JButton("Lihat Daftar Nilai");
        Find.setBounds(255,140,125,30);
        Find.setContentAreaFilled(true);
        Find.setBackground(Color.WHITE);
        Find.setForeground(BGCOLOR_DEFAULT);
        Find.setBorder(javax.swing.BorderFactory.createLineBorder(BGCOLOR_DEFAULT));
        Find.setFocusPainted(false);
        Find.setFont(FONT_DEFAULT_PLAIN);
        Find.addActionListener(this);
        Find.setVisible(false);
        add(Find);
        //Table Nilai Matakuliah
        daftarNilai = new JTable();
        jScrollPane1 = new JScrollPane();
        

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
    public void ShowTablesNilaiMatakuliah(){
        DetailMatakuliah detailMK = dmk.get(ViewMatakuliah.getSelectedIndex());
        ArrayList<Nilai> nilaiMhs = NilaiController.getNilaiMahasiswa(Integer.valueOf(detailMK.getId_MK()));
        String DataNilai[][] = new String[nilaiMhs.size()][10];
        if(nilaiMhs == null){
            JOptionPane.showMessageDialog(null,"Data yang dimasukan tidak tersedia!");
            return;
        }
        idMK = detailMK.getId_MK();
        for(int i=0;i <nilaiMhs.size();i++){
            DataNilai[i][0] = nilaiMhs.get(i).getNIM();
            DataNilai[i][1] = UserManageController.getUser(nilaiMhs.get(i).getNIM()).getNamaLengkap();
            DataNilai[i][2] = String.valueOf(nilaiMhs.get(i).getNilai1());
            DataNilai[i][3] = String.valueOf(nilaiMhs.get(i).getNilai2());
            DataNilai[i][4] = String.valueOf(nilaiMhs.get(i).getNilai3());
            DataNilai[i][5] = String.valueOf(nilaiMhs.get(i).getNilai4());
            DataNilai[i][6] = String.valueOf(nilaiMhs.get(i).getNilai5());
            DataNilai[i][7] = String.valueOf(nilaiMhs.get(i).getNilaiUAS());
            DataNilai[i][8] = String.valueOf(nilaiMhs.get(i).getNilaiAkhir());
            DataNilai[i][9] = nilaiMhs.get(i).getHurufMutu();
           
        }
        
        daftarNilai.setModel(new DefaultTableModel(
            DataNilai, 
            new String[] {
                "NIM","Nama", "N1", "N2", "N3", "N4", "N5", "UAS", "NA", "HM"
            }
        ){
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true, true, true, true, false, false
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
        jScrollPane1.setViewportView(daftarNilai);
        if (daftarNilai.getColumnModel().getColumnCount() > 0) {
            daftarNilai.getColumnModel().getColumn(0).setPreferredWidth(40);
            daftarNilai.getColumnModel().getColumn(1).setPreferredWidth(80);
            daftarNilai.getColumnModel().getColumn(2).setPreferredWidth(20);
            daftarNilai.getColumnModel().getColumn(3).setPreferredWidth(20);
            daftarNilai.getColumnModel().getColumn(4).setPreferredWidth(20);
            daftarNilai.getColumnModel().getColumn(5).setPreferredWidth(20);
            daftarNilai.getColumnModel().getColumn(6).setPreferredWidth(20);
            daftarNilai.getColumnModel().getColumn(7).setPreferredWidth(20);
            daftarNilai.getColumnModel().getColumn(8).setPreferredWidth(20);
            daftarNilai.getColumnModel().getColumn(9).setPreferredWidth(20);
        }
        jScrollPane1.setBounds(15,180,640,320);
        jScrollPane1.setVisible(true);
        add(jScrollPane1);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
        String action = e.getActionCommand();
        System.out.println("Action Panel Nilai Matakuliah: " + action);
            if(action.equals("Next")){
                if(checkAllData() == false){
                    JOptionPane.showMessageDialog(null,"Silahkan Isi Semua Data!");
                }
                else{
                Next.setBackground(BGCOLOR_DEFAULT);
                Next.setForeground(COLOR_WHITE);
                Matakuliah.setVisible(true);
                Find.setVisible(true);
                Dosen dsn = (Dosen) UserManager.getInstance().getUser();
                int tahun = Integer.valueOf(ViewTahun.getText());
                String semester = ViewSemester.getSelectedItem().toString();
                dmk = MatakuliahController.getArrayDetailMatakuliah(dsn.getNID(), tahun, semester);
                if(dmk == null){
                    JOptionPane.showMessageDialog(null,"Data yang dimasukan tidak tersedia!");
                    return;
                }
                String RekapData[] = new String[dmk.size()];
                for(int i=0;i <dmk.size();i++){
                    RekapData[i] = dmk.get(i).getNama_MK();
                }
                ViewMatakuliah = new JComboBox(RekapData);
                ViewMatakuliah.setBounds(110,140,115,30);
                ViewMatakuliah.setVisible(true);
                add(ViewMatakuliah);
                
                }
            }
            if(action.equals("Lihat Daftar Nilai")){
                
                ShowTablesNilaiMatakuliah();
                jScrollPane1.setVisible(true);
                Save.setVisible(true);
                
                
                
            }
            if(action.equals("Save")){
                ArrayList<Nilai> arrDaftarNilai = new ArrayList<>(); 
                for(int i=0; i<daftarNilai.getModel().getRowCount(); i++){
                        Nilai nilai = new Nilai();
                        nilai.setNIM((String) daftarNilai.getModel().getValueAt(i, 0));
                        nilai.setNilai1(Integer.valueOf((String)daftarNilai.getModel().getValueAt(i, 2)));
                        nilai.setNilai2(Integer.valueOf((String)daftarNilai.getModel().getValueAt(i, 3)));
                        nilai.setNilai3(Integer.valueOf((String)daftarNilai.getModel().getValueAt(i, 4)));
                        nilai.setNilai4(Integer.valueOf((String)daftarNilai.getModel().getValueAt(i, 5)));
                        nilai.setNilai5(Integer.valueOf((String)daftarNilai.getModel().getValueAt(i, 6)));
                        nilai.setNilaiUAS(Integer.valueOf((String)daftarNilai.getModel().getValueAt(i, 7)));
                        nilai.setNilaiAkhir(nilai.hitungNA());
                        nilai.setHurufMutu(nilai.convertHurufMutu());
                        arrDaftarNilai.add(nilai);
                        daftarNilai.getModel().setValueAt(nilai.getNilaiAkhir(), i, 8);
                        daftarNilai.getModel().setValueAt(nilai.getHurufMutu(), i, 9);
                        if(!NilaiController.updateNilaiMahasiswa(nilai, idMK)){
                            JOptionPane.showMessageDialog(null, "Update Nilai Gagal!");
                            return;
                        }
                        
                }
                
            }
        
    }
    @Override
    public Dimension getPreferredSize() {
        return DIMENSION_PANEL_CARD;
    }
}
