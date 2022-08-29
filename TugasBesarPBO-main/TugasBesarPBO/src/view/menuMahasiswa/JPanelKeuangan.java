/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.menuMahasiswa;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import model.matakuliah.Kehadiran;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import view.ViewConfig;
import static view.ViewConfig.BGCOLOR_DEFAULT;
import static view.ViewConfig.COLOR_WHITE;
import static view.ViewConfig.FONT_DEFAULT_PLAIN;
import static view.ViewConfig.FONT_TITLE;
/**
 *
 * @author 1119002 Albertus Angkuw
 * @author 1119038 Elangel Neilea Shaday
 */
public class JPanelKeuangan  extends JPanel implements ActionListener, ViewConfig{
    private JPanel Header;
    private final JLabel Judul;
    private JButton Tagihan, Pembayaran, CekPembayaran;
    
    //Variabel Tagihan
    private JPanel Sum, ViewSum;
    private JLabel TahunTagihan, SemesterTagihan, SKS, ViewSKS, Total, ViewTotal;
    private JButton FindTagihan;
    private JTextField ViewTahunTagihan;
    private JComboBox ViewSemesterTagihan;
    private String SemesterValueTagihan[] = {"", "Ganjil", "Genap", "Pendek"};
    private JTable tableTagihan;
    private JScrollPane jScrollPane1Tagihan;
    
    //Variabel Pembayaran
    private JLabel TahunBayar, SemesterBayar, Tanggal;
    private JButton Next, Search, Save, Cancel;
    private JTextField ViewTahunBayar;
    private JComboBox ViewSemesterBayar, ViewMatkul;
    private String SemesterValueBayar[] = {"", "Ganjil", "Genap", "Pendek"};
    private String MatkulValue[] = {"", "A", "B", "C"};
    UtilDateModel modelTanggal;
    Properties p;
    JDatePanelImpl datePanel;
    JDatePickerImpl ViewTanggal;
    JScrollPane jScrollPane1Tanggal;
    private JTable tablePembayaran;
    private JScrollPane jScrollPane1Pembayaran;
    
    //Variabel Cek Pembayaran
    private JLabel CekTahunPembayaran, CekSemesterPembayaran, Matakuliah;
    private JButton FindListBayar;
    private JTextField ViewCekTahunBayar;
    private JComboBox ViewCekSemesterBayar;
    private String CekValueSemesterPembayaran[] = {"", "Ganjil", "Genap", "Pendek"};
    private JTable tableCekTransaksi;
    private JScrollPane jScrollPane1Transaksi;
    
    public JPanelKeuangan(){
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
        Tagihan = new JButton("Tagihan");
        Tagihan.setBounds(20, 85, 200 ,30);
        Tagihan.setContentAreaFilled(true);
        Tagihan.setBackground(COLOR_WHITE);
        Tagihan.setForeground(BGCOLOR_DEFAULT);
        Tagihan.setBorder(javax.swing.BorderFactory.createLineBorder(BGCOLOR_DEFAULT));
        Tagihan.setFocusPainted(false);
        Tagihan.setFont(FONT_DEFAULT_PLAIN );
        Tagihan.addActionListener(this);
        add(Tagihan);
        
        //Button Daftar Hadir Mahasiswa
        Pembayaran = new JButton("Pembayaran");
        Pembayaran.setBounds(240, 85, 190 ,30);
        Pembayaran.setContentAreaFilled(true);
        Pembayaran.setBackground(COLOR_WHITE);
        Pembayaran.setForeground(BGCOLOR_DEFAULT);
        Pembayaran.setBorder(javax.swing.BorderFactory.createLineBorder(BGCOLOR_DEFAULT));
        Pembayaran.setFocusPainted(false);
        Pembayaran.setFont(FONT_DEFAULT_PLAIN );
        Pembayaran.addActionListener(this);
        add(Pembayaran);
        
        //Button Edit Daftar Hadir Mahasiswa
        CekPembayaran = new JButton("Cek Pembayaran");
        CekPembayaran.setBounds(450, 85, 200 ,30);
        CekPembayaran.setContentAreaFilled(true);
        CekPembayaran.setBackground(COLOR_WHITE);
        CekPembayaran.setForeground(BGCOLOR_DEFAULT);
        CekPembayaran.setBorder(javax.swing.BorderFactory.createLineBorder(BGCOLOR_DEFAULT));
        CekPembayaran.setFocusPainted(false);
        CekPembayaran.setFont(FONT_DEFAULT_PLAIN );
        CekPembayaran.addActionListener(this);
        add(CekPembayaran);
        
        showTagihan();
        showPembayaran();
        showCekPembayaran();
        
        ShowTablesTagihan();
        ShowTablesPembayaran();
        ShowTablesTransaksi();
    }
    public void showTagihan(){
        //Input Daftar Hadir Dosen
        TahunTagihan = new JLabel("Tahun");
        TahunTagihan.setBounds(20,95,100,100);
        TahunTagihan.setVisible(false);
        add(TahunTagihan);
        ViewTahunTagihan = new JTextField();
        ViewTahunTagihan.setBounds(70,130,60,30);
        ViewTahunTagihan.setVisible(false);
        add(ViewTahunTagihan);
        
        SemesterTagihan = new JLabel("Semester");
        SemesterTagihan.setBounds(150,95,100,100);
        SemesterTagihan.setVisible(false);
        add(SemesterTagihan);
        ViewSemesterTagihan = new JComboBox(SemesterValueTagihan);
        ViewSemesterTagihan.setBounds(220,130,100,30);
        ViewSemesterTagihan.setVisible(false);
        add(ViewSemesterTagihan);
        
        //Button Lihat Daftar Hadir Dosen
        FindTagihan = new JButton("Lihat Tagihan");
        FindTagihan.setBounds(345,130,205,30);
        FindTagihan.setContentAreaFilled(true);
        FindTagihan.setBackground(Color.WHITE);
        FindTagihan.setForeground(BGCOLOR_DEFAULT);
        FindTagihan.setBorder(javax.swing.BorderFactory.createLineBorder(BGCOLOR_DEFAULT));
        FindTagihan.setFocusPainted(false);
        FindTagihan.setFont(FONT_DEFAULT_PLAIN);
        FindTagihan.setVisible(false);
        FindTagihan.addActionListener(this);
        add(FindTagihan);
        
        SKS = new JLabel("Jumlah SKS:");
        SKS.setBounds(20,160,100,30);
        SKS.setVisible(false);
        add(SKS);
        ViewSKS = new JLabel("10");
        ViewSKS.setBounds(110,160,100,30);
        ViewSKS.setVisible(false);
        add(ViewSKS);
        
        //Table Tagihan
        tableTagihan = new JTable();
        jScrollPane1Tagihan = new JScrollPane();
        
        Sum = new JPanel();
        Sum.setBounds(400,290,100,30);
        Sum.setBackground(COLOR_GRAY);
        Total = new JLabel("Total");
        Total.setBounds(10,10,100,30);
        Sum.add(Total);
        Sum.setVisible(false);
        add(Sum);
        
        ViewSum = new JPanel();
        ViewSum.setBounds(500,290,150,30);
        ViewSum.setBackground(BGCOLOR_DEFAULT);
        ViewTotal = new JLabel("Rp 3100000");
        ViewTotal.setBounds(130,570,200,30);
        ViewTotal.setForeground(COLOR_WHITE);
        ViewSum.add(ViewTotal);
        ViewSum.setVisible(false);
        add(ViewSum);
    }
    public void showPembayaran(){
        //Edit Daftar Hadir Mahasiswa
        TahunBayar = new JLabel("Tahun");
        TahunBayar.setBounds(20,95,100,100);
        TahunBayar.setVisible(false);
        add(TahunBayar);
        ViewTahunBayar = new JTextField();
        ViewTahunBayar.setBounds(70,130,60,30);
        ViewTahunBayar.setVisible(false);
        add(ViewTahunBayar);
        
        SemesterBayar = new JLabel("Semester");
        SemesterBayar.setBounds(140,95,100,100);
        SemesterBayar.setVisible(false);
        add(SemesterBayar);
        ViewSemesterBayar = new JComboBox(SemesterValueBayar);
        ViewSemesterBayar.setBounds(210,130,100,30);
        ViewSemesterBayar.setVisible(false);
        add(ViewSemesterBayar);
        
        Matakuliah = new JLabel("Matakuliah");
        Matakuliah.setBounds(325,95,100,100);
        Matakuliah.setVisible(false);
        add(Matakuliah);
        ViewMatkul = new JComboBox(MatkulValue);
        ViewMatkul.setBounds(400,130,115,30);
        ViewMatkul.setVisible(false);
        add(ViewMatkul);
        
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
        modelTanggal = new UtilDateModel();
        p= new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        datePanel = new JDatePanelImpl(modelTanggal, p);
        ViewTanggal = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        ViewTanggal.setBounds(80,180,115,30);
        ViewTanggal.setVisible(false);
        add(ViewTanggal);
        
        Search = new JButton("Bayar");
        Search.setBounds(215,180,100,30);
        Search.setContentAreaFilled(true);
        Search.setBackground(Color.WHITE);
        Search.setForeground(BGCOLOR_DEFAULT);
        Search.setBorder(javax.swing.BorderFactory.createLineBorder(BGCOLOR_DEFAULT));
        Search.setFocusPainted(false);
        Search.setFont(FONT_DEFAULT_PLAIN);
        Search.setVisible(false);
        Search.addActionListener(this);
        add(Search);
        
        //Table Daftar Hadir
        tablePembayaran = new JTable();
        jScrollPane1Pembayaran = new JScrollPane();
       
        Save = new JButton("Save");
        Save.setBounds(430,570,100,30);
        Save.setContentAreaFilled(true);
        Save.setBackground(Color.WHITE);
        Save.setForeground(BGCOLOR_DEFAULT);
        Save.setBorder(javax.swing.BorderFactory.createLineBorder(BGCOLOR_DEFAULT));
        Save.setFocusPainted(false);
        Save.setFont(FONT_DEFAULT_PLAIN);
        Save.setVisible(false);
        Save.addActionListener(this);
        add(Save);
        
        Cancel = new JButton("Cancel");
        Cancel.setBounds(550,570,100,30);
        Cancel.setContentAreaFilled(true);
        Cancel.setBackground(Color.WHITE);
        Cancel.setForeground(BGCOLOR_DEFAULT);
        Cancel.setBorder(javax.swing.BorderFactory.createLineBorder(BGCOLOR_DEFAULT));
        Cancel.setFocusPainted(false);
        Cancel.setFont(FONT_DEFAULT_PLAIN);
        Cancel.setVisible(false);
        Cancel.addActionListener(this);
        add(Cancel);
        
        ShowTablesPembayaran();
    }
    public void showCekPembayaran(){
        //Input Daftar Hadir Dosen
        CekTahunPembayaran = new JLabel("Tahun");
        CekTahunPembayaran.setBounds(20,95,100,100);
        CekTahunPembayaran.setVisible(false);
        add(CekTahunPembayaran);
        ViewCekTahunBayar = new JTextField();
        ViewCekTahunBayar.setBounds(70,130,60,30);
        ViewCekTahunBayar.setVisible(false);
        add(ViewCekTahunBayar);
        
        CekSemesterPembayaran = new JLabel("Semester");
        CekSemesterPembayaran.setBounds(150,95,100,100);
        CekSemesterPembayaran.setVisible(false);
        add(CekSemesterPembayaran);
        ViewCekSemesterBayar = new JComboBox(SemesterValueTagihan);
        ViewCekSemesterBayar.setBounds(220,130,100,30);
        ViewCekSemesterBayar.setVisible(false);
        add(ViewCekSemesterBayar);
        
        //Button Lihat Daftar Hadir Dosen
        FindListBayar = new JButton("Lihat Transaksi");
        FindListBayar.setBounds(345,130,205,30);
        FindListBayar.setContentAreaFilled(true);
        FindListBayar.setBackground(Color.WHITE);
        FindListBayar.setForeground(BGCOLOR_DEFAULT);
        FindListBayar.setBorder(javax.swing.BorderFactory.createLineBorder(BGCOLOR_DEFAULT));
        FindListBayar.setFocusPainted(false);
        FindListBayar.setFont(FONT_DEFAULT_PLAIN);
        FindListBayar.setVisible(false);
        FindListBayar.addActionListener(this);
        add(FindListBayar);
        
        //Table Cek Pembayaran
        tableCekTransaksi = new JTable();
        jScrollPane1Transaksi = new JScrollPane();
    }
    public void ShowTablesTagihan(){
        //Connect Database
        String daftarTagihan[][] = new String[][] {
                {"BK2018GA2020","Biaya Kemahasiswaan","200000","200000"}, 
                {"BS2018GA2020","Biaya SKS","100000","1000000"}, 
                {"BTGA2020","Biaya Tetap","2000000","2000000"}
            };
        tableTagihan.setModel(new DefaultTableModel(
            daftarTagihan, 
            new String[] {
                "ID_Kategori","Nama_Kategori","Harga","Jumlah Bayar"
            }
        ){
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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
        jScrollPane1Tagihan.setViewportView(tableTagihan);
        if (tableTagihan.getColumnModel().getColumnCount() > 0) {
            tableTagihan.getColumnModel().getColumn(0).setPreferredWidth(30);
            tableTagihan.getColumnModel().getColumn(1).setPreferredWidth(150);
            tableTagihan.getColumnModel().getColumn(2).setPreferredWidth(20);
            tableTagihan.getColumnModel().getColumn(3).setPreferredWidth(30);
        }
        jScrollPane1Tagihan.setBounds(15,195,640,75);
        jScrollPane1Tagihan.setVisible(false);
        add(jScrollPane1Tagihan);
    }
    public void ShowTablesPembayaran(){
        Object daftarPembayaran[][] = {
                {"BK2018GA2020","Biaya Kemahasiswaan","200000","200000",false}, 
                {"BS2018GA2020","Biaya SKS","100000","1000000",false}, 
                {"BTGA2020","Biaya Tetap","2000000","2000000",false}
            };
        tablePembayaran.setModel(new DefaultTableModel(
            daftarPembayaran,
            new String[] {
                "ID_Kategori","Nama_Kategori","Harga","Jumlah Bayar","Bayar"
            }
        ){
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
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
                switch (columnIndex) {
                    case 0:
                        return String.class;
                    case 1:
                        return String.class;
                    case 2:
                        return String.class;
                    case 3:
                        return String.class;
                    default:
                        return Boolean.class;
                }
            }
        });
        jScrollPane1Pembayaran.setViewportView(tablePembayaran);
        if (tablePembayaran.getColumnModel().getColumnCount() > 0) {
            tablePembayaran.getColumnModel().getColumn(0).setPreferredWidth(30);
            tablePembayaran.getColumnModel().getColumn(1).setPreferredWidth(100);
            tablePembayaran.getColumnModel().getColumn(2).setPreferredWidth(150);
            tablePembayaran.getColumnModel().getColumn(3).setPreferredWidth(30);
            tablePembayaran.getColumnModel().getColumn(4).setPreferredWidth(60);
            
        }
        JCheckBox pilihan = new JCheckBox();
        TableColumn status = tablePembayaran.getColumnModel().getColumn(4);
        status.setCellEditor(new DefaultCellEditor(pilihan));
        jScrollPane1Pembayaran.setBounds(15,230,640,325);
        jScrollPane1Pembayaran.setVisible(false);
        add(jScrollPane1Pembayaran);
    }
    public void ShowTablesTransaksi(){
        //Connect Database
        String DaftarHadirDosen[][] = new String[][] {
                {"01/10/2020","Biaya Kemahasiswaan","200000","200000"}, 
                {"02/10/2020","Biaya SKS","100000","1000000"}, 
                {"03/10/2020","Biaya Tetap","2000000","2000000"}
            };
        tableCekTransaksi.setModel(new DefaultTableModel(
            DaftarHadirDosen, 
            new String[] {
                "Tanggal","Nama_Kategori","Harga","Jumlah Bayar"
            }
        ){
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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
        jScrollPane1Transaksi.setViewportView(tableCekTransaksi);
        if (tableCekTransaksi.getColumnModel().getColumnCount() > 0) {
            tableCekTransaksi.getColumnModel().getColumn(0).setPreferredWidth(30);
            tableCekTransaksi.getColumnModel().getColumn(1).setPreferredWidth(150);
            tableCekTransaksi.getColumnModel().getColumn(2).setPreferredWidth(20);
            tableCekTransaksi.getColumnModel().getColumn(3).setPreferredWidth(30);
        }
        jScrollPane1Transaksi.setBounds(15,180,640,420);
        jScrollPane1Transaksi.setVisible(false);
        add(jScrollPane1Transaksi);
    }
    private boolean checkAllDataTagihan(){
        if(ViewTahunTagihan.getText().equals("")){
            return false;
        }
        if(ViewSemesterTagihan.getSelectedItem().toString().equals("")){
            return false;
        }
        return true;
    }
    private boolean checkAllDataTransaksi(){
        if(ViewCekTahunBayar.getText().equals("")){
            return false;
        }
        if(ViewCekSemesterBayar.getSelectedItem().toString().equals("")){
            return false;
        }
        return true;
    }
    private boolean checkAllDataEdit1(){
        if(ViewTahunBayar.getText().equals("")){
            return false;
        }
        if(ViewSemesterBayar.getSelectedItem().toString().equals("")){
            return false;
        }
        if(ViewMatkul.getSelectedItem().toString().equals("")){
            return false;
        }
        return true;
    }
    private Boolean checkAllDataEdit2(){
        if(ViewTanggal.getModel().getValue().equals("")){
            return false;
        }
        return true;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        System.out.println("Action Panel Keuangan : " + action);
        
        if(action.equals("Tagihan")){
            Tagihan.setBackground(BGCOLOR_DEFAULT);
            Tagihan.setForeground(COLOR_WHITE);
            TahunTagihan.setVisible(true);
            ViewTahunTagihan.setVisible(true);
            SemesterTagihan.setVisible(true);
            ViewSemesterTagihan.setVisible(true);
            FindTagihan.setVisible(true);
            Pembayaran.setBackground(COLOR_WHITE);
            Pembayaran.setForeground(BGCOLOR_DEFAULT);
            TahunBayar.setVisible(false);
            ViewTahunBayar.setVisible(false);
            SemesterBayar.setVisible(false);
            ViewSemesterBayar.setVisible(false);
            Matakuliah.setVisible(false);
            ViewMatkul.setVisible(false);
            Next.setVisible(false);
            Tanggal.setVisible(false);
            ViewTanggal.setVisible(false);
            Search.setVisible(false);
            jScrollPane1Pembayaran.setVisible(false);
            Save.setVisible(false);
            Cancel.setVisible(false);
            CekPembayaran.setBackground(COLOR_WHITE);
            CekPembayaran.setForeground(BGCOLOR_DEFAULT);
            CekTahunPembayaran.setVisible(false);
            ViewCekTahunBayar.setVisible(false);
            CekSemesterPembayaran.setVisible(false);
            ViewCekSemesterBayar.setVisible(false);
            FindListBayar.setVisible(false);
            jScrollPane1Transaksi.setVisible(false);
        }
        if(action.equals("Lihat Tagihan")){
            if(checkAllDataTagihan() == false){
                JOptionPane.showMessageDialog(null,"Silahkan Isi Semua Data!");
            }else{
                FindTagihan.setBackground(BGCOLOR_DEFAULT);
                FindTagihan.setForeground(COLOR_WHITE);
                SKS.setVisible(true);
                ViewSKS.setVisible(true);
                jScrollPane1Tagihan.setVisible(true);
                Sum.setVisible(true);
                ViewSum.setVisible(true);
                String printTahunTagihan = ViewTahunTagihan.getText();
                String printSemesterTagihan = ViewSemesterTagihan.getSelectedItem().toString();
            }
        }
        if(action.equals("Pembayaran")){
            Pembayaran.setBackground(BGCOLOR_DEFAULT);
            Pembayaran.setForeground(COLOR_WHITE);
            TahunBayar.setVisible(true);
            ViewTahunBayar.setVisible(true);
            SemesterBayar.setVisible(true);
            ViewSemesterBayar.setVisible(true);
            Matakuliah.setVisible(true);
            ViewMatkul.setVisible(true);
            Next.setVisible(true);
            Tagihan.setBackground(COLOR_WHITE);
            Tagihan.setForeground(BGCOLOR_DEFAULT);
            TahunTagihan.setVisible(false);
            ViewTahunTagihan.setVisible(false);
            SemesterTagihan.setVisible(false);
            ViewSemesterTagihan.setVisible(false);
            FindTagihan.setVisible(false);
            SKS.setVisible(false);
            ViewSKS.setVisible(false);
            jScrollPane1Tagihan.setVisible(false);
            Sum.setVisible(false);
            ViewSum.setVisible(false);
            CekPembayaran.setBackground(COLOR_WHITE);
            CekPembayaran.setForeground(BGCOLOR_DEFAULT);
            CekTahunPembayaran.setVisible(false);
            ViewCekTahunBayar.setVisible(false);
            CekSemesterPembayaran.setVisible(false);
            ViewCekSemesterBayar.setVisible(false);
            FindListBayar.setVisible(false);
            jScrollPane1Transaksi.setVisible(false);
        }
        if(action.equals("Next")){
            if(checkAllDataEdit1() == false){
                JOptionPane.showMessageDialog(null,"Silahkan Isi Semua Data!");
            }else{
                Next.setBackground(BGCOLOR_DEFAULT);
                Next.setForeground(COLOR_WHITE);
                Tanggal.setVisible(true);
                ViewTanggal.setVisible(true);
                Search.setVisible(true);
            }
        }
        if(action.equals("Bayar")){
            if(checkAllDataEdit2() == false){
                JOptionPane.showMessageDialog(null,"Silahkan Isi Semua Data!");
            }else{
                Search.setBackground(BGCOLOR_DEFAULT);
                Search.setForeground(COLOR_WHITE);
                jScrollPane1Pembayaran.setVisible(true);
                Save.setVisible(true);
                Cancel.setVisible(true);
                String printEditTahun = ViewTahunBayar.getText();
                String printEditSemester = ViewSemesterBayar.getSelectedItem().toString();
                String printEditMatkul = ViewMatkul.getSelectedItem().toString();
                Date printTanggal = (Date) ViewTanggal.getModel().getValue();
                ViewTanggal.getModel().addDay(7);
                Date printTanggalAkhir = (Date) ViewTanggal.getModel().getValue();
                System.out.println(printTanggal);
                System.out.println(printTanggalAkhir.getTime());
            }
        }
        if(action.equals("Save")){
            for(int i=0; i<tablePembayaran.getModel().getRowCount(); i++){
                    if(tablePembayaran.getModel().getValueAt(i, 4).equals(true)){
                        System.out.println("Membayar: " + tablePembayaran.getModel().getValueAt(i, 1));
                    }
            }
            JOptionPane.showMessageDialog(null,"Data Berhasil Disimpan!");
        }
        if(action.equals("Cancel")){
            JOptionPane.showMessageDialog(null,"Data tidak ada yang berubah!");
        }
        if(action.equals("Cek Pembayaran")){
            CekPembayaran.setBackground(BGCOLOR_DEFAULT);
            CekPembayaran.setForeground(COLOR_WHITE);
            CekTahunPembayaran.setVisible(true);
            ViewCekTahunBayar.setVisible(true);
            CekSemesterPembayaran.setVisible(true);
            ViewCekSemesterBayar.setVisible(true);
            FindListBayar.setVisible(true);
            Tagihan.setBackground(COLOR_WHITE);
            Tagihan.setForeground(BGCOLOR_DEFAULT);
            TahunTagihan.setVisible(false);
            ViewTahunTagihan.setVisible(false);
            SemesterTagihan.setVisible(false);
            ViewSemesterTagihan.setVisible(false);
            FindTagihan.setVisible(false);
            SKS.setVisible(false);
            ViewSKS.setVisible(false);
            jScrollPane1Tagihan.setVisible(false);
            Sum.setVisible(false);
            ViewSum.setVisible(false);
            Pembayaran.setBackground(COLOR_WHITE);
            Pembayaran.setForeground(BGCOLOR_DEFAULT);
            TahunBayar.setVisible(false);
            ViewTahunBayar.setVisible(false);
            SemesterBayar.setVisible(false);
            ViewSemesterBayar.setVisible(false);
            Matakuliah.setVisible(false);
            ViewMatkul.setVisible(false);
            Next.setVisible(false);
            Tanggal.setVisible(false);
            ViewTanggal.setVisible(false);
            Search.setVisible(false);
            jScrollPane1Pembayaran.setVisible(false);
            Save.setVisible(false);
            Cancel.setVisible(false);
        }
        if(action.equals("Lihat Transaksi")){
            if(checkAllDataTransaksi() == false){
                JOptionPane.showMessageDialog(null,"Silahkan Isi Semua Data!");
            }else{
                FindListBayar.setBackground(BGCOLOR_DEFAULT);
                FindListBayar.setForeground(COLOR_WHITE);
                jScrollPane1Transaksi.setVisible(true);
                String printTahunTransaksi = ViewCekTahunBayar.getText();
                String printSemesterTransaksi = ViewCekSemesterBayar.getSelectedItem().toString();
            }
        }
    }
    @Override
    public Dimension getPreferredSize() {
        return DIMENSION_PANEL_CARD;
    }
}
