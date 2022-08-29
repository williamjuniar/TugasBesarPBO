/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.menuDosen;

import controller.DatabaseController.ContollerDaak.MatakuliahManageController;
import controller.DatabaseController.ContollerDaak.RosterManageController;
import controller.DatabaseController.ContollerDaak.UserManageController;
import controller.DatabaseController.ControllerDosen.MatakuliahController;
import controller.DatabaseController.ControllerDosen.RosterController;
import controller.UserManager;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import model.matakuliah.DetailMatakuliah;
import model.matakuliah.Kehadiran;
import model.matakuliah.Matakuliah;
import model.matakuliah.Roster;
import model.user.Dosen;
import model.user.User;
import view.ViewConfig;
import static view.ViewConfig.BGCOLOR_DEFAULT;
import static view.ViewConfig.COLOR_WHITE;
import static view.ViewConfig.DIMENSION_PANEL_CARD;
import static view.ViewConfig.FONT_DEFAULT_PLAIN;
import static view.ViewConfig.FONT_TITLE;
import view.menuDaak.Helper.JPanelHelperRencanaStudi;

/**
 *
 * @author 1119006 William Juniar
 * @author 1119038 Elangel Neilea Shaday
 */
public class JPanelDaftarHadir extends JPanel implements ActionListener,ViewConfig{
    //Variabel Daftar Hadir Dosen
    private JPanel Header;
    private JLabel Judul;
    private JButton daftarHadirDosen, daftarHadirMhs, editDaftarHadirMhs, FindDosen;
    private JLabel TahunDosen, SemesterDosen;
    private JTextField ViewTahunDosen;
    private JComboBox ViewSemesterDosen;
    private String SemesterValueDosen[] = {"", "Ganjil", "Genap", "Pendek"};
    private JTable tableDaftarHadirDosen;
    private JScrollPane jScrollPane1Dosen;
    
    //Variabel Daftar Hadir Mahasiswa
    private JLabel TahunMhs, SemesterMhs;
    private JButton Matakuliah;
    private JButton FindMhs;
    private JTextField ViewTahunMhs;
    private JComboBox ViewSemesterMhs, ViewMatkul;
    private String SemesterValueMhs[] = {"", "Ganjil", "Genap", "Pendek"};
    private String MatkulValue[] = {"", "A", "B", "C"};
    private JTable tableDaftarHadirMhs;
    private JScrollPane jScrollPanelMhs;
    
    //Variabel Edit Daftar Hadir Mahasiswa
    private JLabel EditTahunMhs, EditSemesterMhs, Tanggal;
    private JButton Cari, Next, Simpan, Batal,EditMatakuliah;
    private JTextField EditViewTahunMhs;
    private JComboBox EditViewSemesterMhs, EditViewMatkul, ViewTanggal;
    private String EditSemesterValueMhs[] = {"", "Ganjil", "Genap", "Pendek"};
    private String EditMatkulValue[] = {"", "A", "B", "C"};
    private String TanggalValue[] = {"", "01/10/2020", "02/11/2020", "03//12/2020"};
    private JTable editTableDaftarHadirMhs;
    private JScrollPane editJScrollPanelMhs;
    
    public JPanelDaftarHadir(){
        Header = new JPanel();
        Header.setBackground(Color.DARK_GRAY);
        Header.setBounds(0,20,700,50);
        Judul = new JLabel("INSTITUTE TEKNOLOGI HARAPAN BANGSA");
        Judul.setForeground(Color.WHITE);
        Judul.setFont(FONT_TITLE);
        Header.add(Judul);
        add(Header);
        setLayout(null);
        
        //Button Daftar Hadir Dosen
        daftarHadirDosen = new JButton("Daftar Hadir Dosen");
        daftarHadirDosen.setBounds(20, 85, 170 ,30);
        daftarHadirDosen.setContentAreaFilled(true);
        daftarHadirDosen.setBackground(COLOR_WHITE);
        daftarHadirDosen.setForeground(BGCOLOR_DEFAULT);
        daftarHadirDosen.setBorder(javax.swing.BorderFactory.createLineBorder(BGCOLOR_DEFAULT));
        daftarHadirDosen.setFocusPainted(false);
        daftarHadirDosen.setFont(FONT_DEFAULT_PLAIN );
        daftarHadirDosen.addActionListener(this);
        add(daftarHadirDosen);
        
        //Button Daftar Hadir Mahasiswa
        daftarHadirMhs = new JButton("Daftar Hadir Mahasiswa");
        daftarHadirMhs.setBounds(200, 85, 200 ,30);
        daftarHadirMhs.setContentAreaFilled(true);
        daftarHadirMhs.setBackground(COLOR_WHITE);
        daftarHadirMhs.setForeground(BGCOLOR_DEFAULT);
        daftarHadirMhs.setBorder(javax.swing.BorderFactory.createLineBorder(BGCOLOR_DEFAULT));
        daftarHadirMhs.setFocusPainted(false);
        daftarHadirMhs.setFont(FONT_DEFAULT_PLAIN );
        daftarHadirMhs.addActionListener(this);
        add(daftarHadirMhs);
        
        //Button Edit Daftar Hadir Mahasiswa
        editDaftarHadirMhs = new JButton("Edit Daftar Hadir Mahasiswa");
        editDaftarHadirMhs.setBounds(410, 85, 245 ,30);
        editDaftarHadirMhs.setContentAreaFilled(true);
        editDaftarHadirMhs.setBackground(COLOR_WHITE);
        editDaftarHadirMhs.setForeground(BGCOLOR_DEFAULT);
        editDaftarHadirMhs.setBorder(javax.swing.BorderFactory.createLineBorder(BGCOLOR_DEFAULT));
        editDaftarHadirMhs.setFocusPainted(false);
        editDaftarHadirMhs.setFont(FONT_DEFAULT_PLAIN );
        editDaftarHadirMhs.addActionListener(this);
        add(editDaftarHadirMhs);
        
        showDosen();
        showMahasiswa();
        editDaftarMhs();
    }
    private void showDosen(){
        //Input Daftar Hadir Dosen
        TahunDosen = new JLabel("Tahun");
        TahunDosen.setBounds(20,95,100,100);
        TahunDosen.setVisible(false);
        add(TahunDosen);
        ViewTahunDosen = new JTextField();
        ViewTahunDosen.setBounds(70,130,60,30);
        ViewTahunDosen.setVisible(false);
        add(ViewTahunDosen);
        
        SemesterDosen = new JLabel("Semester");
        SemesterDosen.setBounds(150,95,100,100);
        SemesterDosen.setVisible(false);
        add(SemesterDosen);
        ViewSemesterDosen = new JComboBox(SemesterValueDosen);
        ViewSemesterDosen.setBounds(220,130,100,30);
        ViewSemesterDosen.setVisible(false);
        add(ViewSemesterDosen);
        
        //Button Lihat Daftar Hadir Dosen
        FindDosen = new JButton("Lihat Daftar Hadir");
        FindDosen.setBounds(345,130,205,30);
        FindDosen.setContentAreaFilled(true);
        FindDosen.setBackground(Color.WHITE);
        FindDosen.setForeground(BGCOLOR_DEFAULT);
        FindDosen.setBorder(javax.swing.BorderFactory.createLineBorder(BGCOLOR_DEFAULT));
        FindDosen.setFocusPainted(false);
        FindDosen.setFont(FONT_DEFAULT_PLAIN);
        FindDosen.setVisible(false);
        FindDosen.addActionListener(this);
        add(FindDosen);
        
        //Table Daftar Hadir
      
        tableDaftarHadirDosen = new JTable();
        jScrollPane1Dosen = new JScrollPane();
    }    
    private void showMahasiswa(){
        //Input Daftar Hadir Mahasiswa
        TahunMhs = new JLabel("Tahun");
        TahunMhs.setBounds(20,95,100,100);
        TahunMhs.setVisible(false);
        add(TahunMhs);
        ViewTahunMhs = new JTextField();
        ViewTahunMhs.setBounds(70,130,60,30);
        ViewTahunMhs.setVisible(false);
        add(ViewTahunMhs);
        
        SemesterMhs = new JLabel("Semester");
        SemesterMhs.setBounds(140,95,100,100);
        SemesterMhs.setVisible(false);
        add(SemesterMhs);
        ViewSemesterMhs = new JComboBox(SemesterValueMhs);
        ViewSemesterMhs.setBounds(210,130,100,30);
        ViewSemesterMhs.setVisible(false);
        add(ViewSemesterMhs);
        
        Matakuliah = new JButton("Check MK");
        Matakuliah.setBounds(325,130,70,30);
        Matakuliah.setVisible(false);
        Matakuliah.addActionListener(this);
        add(Matakuliah);
        ViewMatkul = new JComboBox();
        ViewMatkul.setBounds(400,130,115,30);
        ViewMatkul.setVisible(false);
        add(ViewMatkul);
        
        //Button Lihat Daftar Hadir Mahasiswa
        FindMhs = new JButton("Daftar Hadir");
        FindMhs.setBounds(530,130,125,30);
        FindMhs.setContentAreaFilled(true);
        FindMhs.setBackground(Color.WHITE);
        FindMhs.setForeground(BGCOLOR_DEFAULT);
        FindMhs.setBorder(javax.swing.BorderFactory.createLineBorder(BGCOLOR_DEFAULT));
        FindMhs.setFocusPainted(false);
        FindMhs.setFont(FONT_DEFAULT_PLAIN);
        FindMhs.setVisible(false);
        FindMhs.addActionListener(this);
        add(FindMhs);
        
        //Table Daftar Hadir
        tableDaftarHadirMhs = new JTable();
        jScrollPanelMhs = new JScrollPane();
        
    }
    private void editDaftarMhs(){
        //Edit Daftar Hadir Mahasiswa
        EditTahunMhs = new JLabel("Tahun");
        EditTahunMhs.setBounds(20,95,100,100);
        EditTahunMhs.setVisible(false);
        add(EditTahunMhs);
        EditViewTahunMhs = new JTextField();
        EditViewTahunMhs.setBounds(70,130,60,30);
        EditViewTahunMhs.setVisible(false);
        add(EditViewTahunMhs);
        
        EditSemesterMhs = new JLabel("Semester");
        EditSemesterMhs.setBounds(140,95,100,100);
        EditSemesterMhs.setVisible(false);
        add(EditSemesterMhs);
        EditViewSemesterMhs = new JComboBox(EditSemesterValueMhs);
        EditViewSemesterMhs.setBounds(210,130,100,30);
        EditViewSemesterMhs.setVisible(false);
        add(EditViewSemesterMhs);
        
        EditMatakuliah = new JButton("Cek");
        EditMatakuliah.setBounds(325,130,70,30);
        EditMatakuliah.setVisible(false);
        add(EditMatakuliah);
        EditViewMatkul = new JComboBox(EditMatkulValue);
        EditViewMatkul.setBounds(400,130,115,30);
        EditViewMatkul.setVisible(false);
        add(EditViewMatkul);
        
        Next = new JButton("Next");
        Next.setBounds(530,130,125,30);
        Next.setContentAreaFilled(true);
        Next.setBackground(Color.WHITE);
        Next.setForeground(BGCOLOR_DEFAULT);
        Next.setBorder(javax.swing.BorderFactory.createLineBorder(BGCOLOR_DEFAULT));
        Next.setFocusPainted(false);
        Next.setFont(FONT_DEFAULT_PLAIN);
        Next.setVisible(false);
        Next.addActionListener(this);
        add(Next);
        
        Tanggal = new JLabel("Tanggal");
        Tanggal.setBounds(20,145,100,100);
        Tanggal.setVisible(false);
        add(Tanggal);
        ViewTanggal = new JComboBox(TanggalValue);
        ViewTanggal.setBounds(80,180,115,30);
        ViewTanggal.setVisible(false);
        add(ViewTanggal);
        
        Cari = new JButton("Search");
        Cari.setBounds(215,180,100,30);
        Cari.setContentAreaFilled(true);
        Cari.setBackground(Color.WHITE);
        Cari.setForeground(BGCOLOR_DEFAULT);
        Cari.setBorder(javax.swing.BorderFactory.createLineBorder(BGCOLOR_DEFAULT));
        Cari.setFocusPainted(false);
        Cari.setFont(FONT_DEFAULT_PLAIN);
        Cari.setVisible(false);
        Cari.addActionListener(this);
        add(Cari);
        
        //Table Daftar Hadir
        editTableDaftarHadirMhs = new JTable();
        editJScrollPanelMhs = new JScrollPane();
       
        
        Simpan = new JButton("Save");
        Simpan.setBounds(430,570,100,30);
        Simpan.setContentAreaFilled(true);
        Simpan.setBackground(Color.WHITE);
        Simpan.setForeground(BGCOLOR_DEFAULT);
        Simpan.setBorder(javax.swing.BorderFactory.createLineBorder(BGCOLOR_DEFAULT));
        Simpan.setFocusPainted(false);
        Simpan.setFont(FONT_DEFAULT_PLAIN);
        Simpan.setVisible(false);
        Simpan.addActionListener(this);
        add(Simpan);
        
        Batal = new JButton("Cancel");
        Batal.setBounds(550,570,100,30);
        Batal.setContentAreaFilled(true);
        Batal.setBackground(Color.WHITE);
        Batal.setForeground(BGCOLOR_DEFAULT);
        Batal.setBorder(javax.swing.BorderFactory.createLineBorder(BGCOLOR_DEFAULT));
        Batal.setFocusPainted(false);
        Batal.setFont(FONT_DEFAULT_PLAIN);
        Batal.setVisible(false);
        Batal.addActionListener(this);
        add(Batal);
    }
    private boolean checkAllDataDosen(){
        if(ViewTahunDosen.getText().equals("")){
            return false;
        }
        if(ViewSemesterDosen.getSelectedItem().toString().equals("")){
            return false;
        }
        return true;
    }
    private boolean checkAllDataMhs(){
        if(ViewTahunMhs.getText().equals("")){
            return false;
        }
        if(ViewSemesterMhs.getSelectedItem().toString().equals("")){
            return false;
        }
        if(ViewMatkul.getSelectedItem().toString().equals("")){
            return false;
        }
        return true;
    }
    private boolean checkAllDataEdit1(){
        if(EditViewTahunMhs.getText().equals("")){
            return false;
        }
        if(EditViewSemesterMhs.getSelectedItem().toString().equals("")){
            return false;
        }
        if(EditViewMatkul.getSelectedItem().toString().equals("")){
            return false;
        }
        return true;
    }
    private boolean checkAllDataEdit2(){
        if(ViewTanggal.getSelectedItem().toString().equals("")){
            return false;
        }
        return true;
    }
    public void ShowTablesDosen(){
        int printTahun = Integer.valueOf(ViewTahunDosen.getText());
        String printSemester = ViewSemesterDosen.getSelectedItem().toString();
        Dosen dsn = (Dosen) UserManager.getInstance().getUser();
        
        ArrayList<DetailMatakuliah> dmk = MatakuliahController.getArrayDetailMatakuliah(dsn.getNID(), printTahun, printSemester);
        
        if(dmk == null){
            JOptionPane.showMessageDialog(null,"Maaf Jadwal tidak ditemukan");
            return;
            
        }
        String DaftarHadirDosen[][] = new String[dmk.size()][5];
        ArrayList<Roster> arrRoster = new ArrayList<>();
        
        for(int i=0; i<dmk.size(); i++){
            DetailMatakuliah detailMK = dmk.get(i);
            Matakuliah mk = MatakuliahManageController.getMatakuliah(detailMK.getKode_MK());
            ArrayList<Roster> arrTemp = RosterManageController.getArrayRoster(detailMK.getId_MK());
            arrRoster.addAll(arrTemp);
            int counterKehadiran = 0;
            for(int j=0; j<arrTemp.size(); j++){
                if(arrTemp.get(i).isStatusDosen()){
                    counterKehadiran++;
                }
            }
            
            DaftarHadirDosen[i][0] = mk.getKode_MK();
            DaftarHadirDosen[i][1] = mk.getNama_MK();
            DaftarHadirDosen[i][2] = String.valueOf(detailMK.getKelas());
            DaftarHadirDosen[i][3] = String.valueOf(detailMK.getJumlahPertemuan());
            DaftarHadirDosen[i][4] = String.valueOf(counterKehadiran);
             
        }
        tableDaftarHadirDosen.setModel(new DefaultTableModel(
            DaftarHadirDosen, 
            new String[] {
                "Kode MK","Nama Matakuliah","Kelas"," Total Pertemuan", "Jumlah Kehadiran"
            }
        ){
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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
        jScrollPane1Dosen.setViewportView(tableDaftarHadirDosen);
        if (tableDaftarHadirDosen.getColumnModel().getColumnCount() > 0) {
            tableDaftarHadirDosen.getColumnModel().getColumn(0).setPreferredWidth(30);
            tableDaftarHadirDosen.getColumnModel().getColumn(1).setPreferredWidth(150);
            tableDaftarHadirDosen.getColumnModel().getColumn(2).setPreferredWidth(20);
            tableDaftarHadirDosen.getColumnModel().getColumn(3).setPreferredWidth(30);
            tableDaftarHadirDosen.getColumnModel().getColumn(4).setPreferredWidth(30);
            
        }
        jScrollPane1Dosen.setBounds(15,180,640,420);
        jScrollPane1Dosen.setVisible(true);
        add(jScrollPane1Dosen);
    }
    
    public void ShowTablesMahasiswa(){
        Dosen dsn = (Dosen) UserManager.getInstance().getUser();
        int tahun = Integer.valueOf(ViewTahunMhs.getText());
        String printSemester = ViewSemesterMhs.getSelectedItem().toString();
        int selectedIdx = ViewMatkul.getSelectedIndex();
        ArrayList<DetailMatakuliah> dmk = MatakuliahController.getArrayDetailMatakuliah(dsn.getNID(), tahun, printSemester);
        if(dmk == null){
            return;
        }
        DetailMatakuliah dmkDipilih = dmk.get(selectedIdx);
        ArrayList<Kehadiran> rosterMhs = RosterController.getArrayDaftarHadirMhs(dmkDipilih.getId_MK());
        //Connect Database
        class  MhsdanJumlahHadir{
            String nim;
            int jumlahHadir = 0;
        }
        ArrayList<String> daftarMhs  = new ArrayList<>();
        ArrayList<MhsdanJumlahHadir> groupMhs  = new ArrayList<>();
      
        for(int i=0; i<rosterMhs.size(); i++){
            Kehadiran kehadiran = rosterMhs.get(i);
            if(!daftarMhs.contains(kehadiran.getNIM())){
                daftarMhs.add(kehadiran.getNIM());
                MhsdanJumlahHadir mhs = new MhsdanJumlahHadir();
                mhs.nim = kehadiran.getNIM();
                if(kehadiran.getKeterangan().equals("Hadir")){
                mhs.jumlahHadir = 1;
                }
                groupMhs.add(mhs);
            }else{
                for(int j=0; j<groupMhs.size(); j++){
                    if(groupMhs.get(j).nim.equals(kehadiran.getNIM())){
                        if(kehadiran.getKeterangan().equals("Hadir")){
                            groupMhs.get(j).jumlahHadir++;
                        }
                    }
                }
            }
        }
        String DaftarHadirMahasiswa[][] = new String[groupMhs.size()][5];
        for(int i=0; i<groupMhs.size(); i++){
            DaftarHadirMahasiswa[i][0] = String.valueOf(i + 1) + ". ";
            User mhs = UserManageController.getUser(rosterMhs.get(i).getNIM());
            DaftarHadirMahasiswa[i][1] = rosterMhs.get(i).getNIM();
            DaftarHadirMahasiswa[i][2] = mhs.getNamaLengkap();
            DaftarHadirMahasiswa[i][3] = String.valueOf(groupMhs.get(i).jumlahHadir);
        }
        
        tableDaftarHadirMhs.setModel(new DefaultTableModel(
            DaftarHadirMahasiswa,
            new String[] {
                "No", "NIM", "Nama Mahasiswa", "Kelas", "Jumlah Kehadiran"
            }
        ){
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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
        jScrollPanelMhs.setViewportView(tableDaftarHadirMhs);
        if (tableDaftarHadirMhs.getColumnModel().getColumnCount() > 0) {
            tableDaftarHadirMhs.getColumnModel().getColumn(0).setPreferredWidth(30);
            tableDaftarHadirMhs.getColumnModel().getColumn(1).setPreferredWidth(100);
            tableDaftarHadirMhs.getColumnModel().getColumn(2).setPreferredWidth(150);
            tableDaftarHadirMhs.getColumnModel().getColumn(3).setPreferredWidth(30);
            tableDaftarHadirMhs.getColumnModel().getColumn(4).setPreferredWidth(60);
            
        }
        jScrollPanelMhs.setBounds(15,180,640,420);
        jScrollPanelMhs.setVisible(true);
        add(jScrollPanelMhs);
    }
    
    public void ShowTableEditMahasiswa(){
        String EditDaftarHadirMahasiswa[][] = new String[][] {
                {"1.", "1119002", "Albertus", "A",""}, 
                {"2.", "1119006", "William Juniar", "A",""}, 
                {"3.", "1119038", "Elangel", "B",""}
            };
        editTableDaftarHadirMhs.setModel(new DefaultTableModel(
            EditDaftarHadirMahasiswa,
              
            new String[] {
                "No", "NIM", "Nama Mahasiswa", "Kelas", "Jumlah Kehadiran"
            }
        ){
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
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
        editJScrollPanelMhs.setViewportView(editTableDaftarHadirMhs);
        if (editTableDaftarHadirMhs.getColumnModel().getColumnCount() > 0) {
            editTableDaftarHadirMhs.getColumnModel().getColumn(0).setPreferredWidth(30);
            editTableDaftarHadirMhs.getColumnModel().getColumn(1).setPreferredWidth(100);
            editTableDaftarHadirMhs.getColumnModel().getColumn(2).setPreferredWidth(150);
            editTableDaftarHadirMhs.getColumnModel().getColumn(3).setPreferredWidth(30);
            editTableDaftarHadirMhs.getColumnModel().getColumn(4).setPreferredWidth(60);
            
        }
        JComboBox comboBox = new JComboBox();
        comboBox.addItem("Hadir");
        comboBox.addItem("Sakit");
        comboBox.addItem("Alpha");
        TableColumn status = editTableDaftarHadirMhs.getColumnModel().getColumn(4);
        status.setCellEditor(new DefaultCellEditor(comboBox));
        editJScrollPanelMhs.setBounds(15,230,640,325);
        editJScrollPanelMhs.setVisible(true);
        add(editJScrollPanelMhs);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        System.out.println("Action Panel Daftar Hadir : " + action);
        if(action.equals("Cek")){
            Dosen dsn = (Dosen) UserManager.getInstance().getUser();
            int tahun = Integer.valueOf(ViewTahunMhs.getText());
            String printSemester = ViewSemesterMhs.getSelectedItem().toString();
            ArrayList<DetailMatakuliah> dmk = MatakuliahController.getArrayDetailMatakuliah(dsn.getNID(), tahun, printSemester);
            if(dmk == null){
                return;
            }
            String kodeMK[] = new String[dmk.size()];
            for(int i=0; i<dmk.size(); i++){
                kodeMK[i] = dmk.get(i).getKode_MK();
            }
            ViewMatkul.setVisible(false);
            ViewMatkul = new JComboBox(kodeMK);
            ViewMatkul.setBounds(400,130,115,30);
            ViewMatkul.setVisible(true);
            add(ViewMatkul);
        }
        if(action.equals("Check MK")){
            Dosen dsn = (Dosen) UserManager.getInstance().getUser();
            int tahun = Integer.valueOf(ViewTahunMhs.getText());
            String printSemester = ViewSemesterMhs.getSelectedItem().toString();
            ArrayList<DetailMatakuliah> dmk = MatakuliahController.getArrayDetailMatakuliah(dsn.getNID(), tahun, printSemester);
            if(dmk == null){
                return;
            }
            String kodeMK[] = new String[dmk.size()];
            for(int i=0; i<dmk.size(); i++){
                kodeMK[i] = dmk.get(i).getKode_MK();
            }
            ViewMatkul.setVisible(false);
            ViewMatkul = new JComboBox(kodeMK);
            ViewMatkul.setBounds(400,130,115,30);
            ViewMatkul.setVisible(true);
            add(ViewMatkul);
        }
        if(action.equals("Daftar Hadir Dosen")){
            daftarHadirDosen.setBackground(BGCOLOR_DEFAULT);
            daftarHadirDosen.setForeground(COLOR_WHITE);
            TahunDosen.setVisible(true);
            ViewTahunDosen.setVisible(true);
            SemesterDosen.setVisible(true);
            ViewSemesterDosen.setVisible(true);
            FindDosen.setVisible(true);
            daftarHadirMhs.setBackground(COLOR_WHITE);
            daftarHadirMhs.setForeground(BGCOLOR_DEFAULT);
            TahunMhs.setVisible(false);
            ViewTahunMhs.setVisible(false);
            SemesterMhs.setVisible(false);
            ViewSemesterMhs.setVisible(false);
            Matakuliah.setVisible(false);
            ViewMatkul.setVisible(false);
            FindMhs.setVisible(false);
            jScrollPanelMhs.setVisible(false);
            editDaftarHadirMhs.setBackground(COLOR_WHITE);
            editDaftarHadirMhs.setForeground(BGCOLOR_DEFAULT);
            EditTahunMhs.setVisible(false);
            EditViewTahunMhs.setVisible(false);
            EditSemesterMhs.setVisible(false);
            EditViewSemesterMhs.setVisible(false);
            EditMatakuliah.setVisible(false);
            EditViewMatkul.setVisible(false);
            Next.setVisible(false);
            Tanggal.setVisible(false);
            ViewTanggal.setVisible(false);
            Cari.setVisible(false);
            Simpan.setVisible(false);
            Batal.setVisible(false);
            editJScrollPanelMhs.setVisible(false);
        }
        if(action.equals("Lihat Daftar Hadir")){
            if(checkAllDataDosen() == false){
                JOptionPane.showMessageDialog(null,"Silahkan Isi Semua Data!");
            }else{
                FindDosen.setBackground(BGCOLOR_DEFAULT);
                FindDosen.setForeground(COLOR_WHITE);
                ShowTablesDosen();
                String printTahunDosen = ViewTahunDosen.getText();
                String printSemesterDosen = ViewSemesterDosen.getSelectedItem().toString();
            }
        }
        if(action.equals("Daftar Hadir Mahasiswa")){
            daftarHadirMhs.setBackground(BGCOLOR_DEFAULT);
            daftarHadirMhs.setForeground(COLOR_WHITE);
            TahunMhs.setVisible(true);
            ViewTahunMhs.setVisible(true);
            SemesterMhs.setVisible(true);
            ViewSemesterMhs.setVisible(true);
            Matakuliah.setVisible(true);
            ViewMatkul.setVisible(false);
            FindMhs.setVisible(true);
            daftarHadirDosen.setBackground(COLOR_WHITE);
            daftarHadirDosen.setForeground(BGCOLOR_DEFAULT);
            TahunDosen.setVisible(false);
            ViewTahunDosen.setVisible(false);
            SemesterDosen.setVisible(false);
            ViewSemesterDosen.setVisible(false);
            FindDosen.setVisible(false);
            jScrollPane1Dosen.setVisible(false);
            editDaftarHadirMhs.setBackground(COLOR_WHITE);
            editDaftarHadirMhs.setForeground(BGCOLOR_DEFAULT);
            EditTahunMhs.setVisible(false);
            EditViewTahunMhs.setVisible(false);
            EditSemesterMhs.setVisible(false);
            EditViewSemesterMhs.setVisible(false);
            EditMatakuliah.setVisible(false);
            EditViewMatkul.setVisible(false);
            Next.setVisible(false);
            Tanggal.setVisible(false);
            ViewTanggal.setVisible(false);
            Cari.setVisible(false);
            Simpan.setVisible(false);
            Batal.setVisible(false);
            editJScrollPanelMhs.setVisible(false);
        }
        if(action.equals("Daftar Hadir")){
            if(checkAllDataMhs() == false){
                JOptionPane.showMessageDialog(null,"Silahkan Isi Semua Data!");
            }else{
                FindMhs.setBackground(BGCOLOR_DEFAULT);
                FindMhs.setForeground(COLOR_WHITE);
                ShowTablesMahasiswa();
            }
        }
        if(action.equals("Edit Daftar Hadir Mahasiswa")){
            editDaftarHadirMhs.setBackground(BGCOLOR_DEFAULT);
            editDaftarHadirMhs.setForeground(COLOR_WHITE);
            EditTahunMhs.setVisible(true);
            EditViewTahunMhs.setVisible(true);
            EditSemesterMhs.setVisible(true);
            EditViewSemesterMhs.setVisible(true);
            EditMatakuliah.setVisible(true);
            EditViewMatkul.setVisible(true);
            Next.setVisible(true);
            Tanggal.setVisible(false); //tanggal
            ViewTanggal.setVisible(false); //tanggal
            Cari.setVisible(false); // search
            daftarHadirDosen.setBackground(COLOR_WHITE);
            daftarHadirDosen.setForeground(BGCOLOR_DEFAULT);
            TahunDosen.setVisible(false);
            ViewTahunDosen.setVisible(false);
            SemesterDosen.setVisible(false);
            ViewSemesterDosen.setVisible(false);
            FindDosen.setVisible(false);
            jScrollPane1Dosen.setVisible(false);
            daftarHadirMhs.setBackground(COLOR_WHITE);
            daftarHadirMhs.setForeground(BGCOLOR_DEFAULT);
            TahunMhs.setVisible(false);
            ViewTahunMhs.setVisible(false);
            SemesterMhs.setVisible(false);
            ViewSemesterMhs.setVisible(false);
            Matakuliah.setVisible(false);
            ViewMatkul.setVisible(false);
            FindMhs.setVisible(false);
            jScrollPanelMhs.setVisible(false);
        }
        if(action.equals("Next")){
            if(checkAllDataEdit1() == false){
                JOptionPane.showMessageDialog(null,"Silahkan Isi Semua Data!");
            }else{
                Next.setBackground(BGCOLOR_DEFAULT);
                Next.setForeground(COLOR_WHITE);
                Tanggal.setVisible(true);
                ViewTanggal.setVisible(true);
                Cari.setVisible(true);
            }
        }
        if(action.equals("Search")){
            if(checkAllDataEdit2() == false){
                JOptionPane.showMessageDialog(null,"Silahkan Isi Semua Data!");
            }else{
                Cari.setBackground(BGCOLOR_DEFAULT);
                Cari.setForeground(COLOR_WHITE);
                ShowTableEditMahasiswa();
                Simpan.setVisible(true);
                Batal.setVisible(true);
                String printEditTahun = EditViewTahunMhs.getText();
                String printEditSemester = EditViewSemesterMhs.getSelectedItem().toString();
                String printEditMatkul = EditViewMatkul.getSelectedItem().toString();
                String printTanggal = ViewTanggal.getSelectedItem().toString();
            }
        }
        if(action.equals("Save")){
             ArrayList<Kehadiran> arrEditHadirMhs = new ArrayList<>(); 
                for(int i=0; i<editTableDaftarHadirMhs.getModel().getRowCount(); i++){
                        Kehadiran kehadiran = new Kehadiran();
                        kehadiran.setNIM((String) editTableDaftarHadirMhs.getModel().getValueAt(i, 1));
                        kehadiran.setKeterangan((String)editTableDaftarHadirMhs.getModel().getValueAt(i, 4));
                        arrEditHadirMhs.add(kehadiran);
                        System.out.println(kehadiran.toString());
                }
            JOptionPane.showMessageDialog(null,"Data Berhasil Disimpan!");
        }
        if(action.equals("Cancel")){
            JOptionPane.showMessageDialog(null,"Data tidak ada yang berubah!");
        }
    }
    @Override
    public Dimension getPreferredSize() {
        return DIMENSION_PANEL_CARD;
    }
}