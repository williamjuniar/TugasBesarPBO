/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.menuMahasiswa;

import controller.DatabaseController.ContollerDaak.MatakuliahManageController;
import controller.DatabaseController.ContollerDaak.RencanaStudiManageController;
import controller.DatabaseController.ContollerDaak.RosterManageController;
import controller.DatabaseController.ControllerMahasiswa.JadwalMahasiswaController;
import controller.UserManager;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
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
import model.matakuliah.Roster;
import model.user.Mahasiswa;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import view.ViewConfig;
import static view.ViewConfig.FONT_TITLE;
/**
 *
 * @author 1119002 Albertus Angkuw
 */
public class JPanelJadwal  extends JPanel implements ActionListener, ViewConfig {
    private final JPanel Header;
    private final JLabel Judul, Semester, Tahun, Tanggal, Periode;
    private final JComboBox ViewSemester;
    private final String SemesterValue[] = {"", "Ganjil", "Genap", "Pendek"};
    private final String MatkulValue[] = {"", "ABC", "BCA", "CBA"};
    private final String KelasValue[] = {"", "A", "B"};
    private final JTextField ViewTahun;
    private final JButton Find;
    private final JTable daftarJadwal;
    UtilDateModel modelTanggal1, modelTanggal2;
    Properties p1, p2;
    JDatePanelImpl datePanel1, datePanel2;
    JDatePickerImpl tanggal, tanggalAkhir;
    JScrollPane jScrollPane1;
    public JPanelJadwal(){
        Header = new JPanel();
        Header.setBackground(Color.DARK_GRAY);
        Header.setBounds(0,20,700,50);
        Judul = new JLabel("INSTITUTE TEKNOLOGI HARAPAN BANGSA");
        Judul.setForeground(Color.WHITE);
        Judul.setFont(FONT_TITLE);
        Header.add(Judul);
        add(Header);
        setLayout(null);
        
        Semester = new JLabel("Semester");
        Semester.setBounds(15,50,100,100);
        add(Semester);
        ViewSemester = new JComboBox(SemesterValue);
        ViewSemester.setBounds(85,90,80,25);
        add(ViewSemester);
        
        Tahun = new JLabel("Tahun");
        Tahun.setBounds(180,50,100,100);
        add(Tahun);
        ViewTahun = new JTextField();
        ViewTahun.setBounds(230,90,50,25);
        add(ViewTahun);
        
        Tanggal = new JLabel("Tanggal");
        Tanggal.setBounds(295,50,100,100);
        add(Tanggal);
        modelTanggal1 = new UtilDateModel();
        p1 = new Properties();
        p1.put("text.today", "Today");
        p1.put("text.month", "Month");
        p1.put("text.year", "Year");
        datePanel1 = new JDatePanelImpl(modelTanggal1, p1);
        tanggal = new JDatePickerImpl(datePanel1, new DateLabelFormatter());
        tanggal.setBounds(360,90,130,30);
        add(tanggal);
        
        Periode = new JLabel("-");
        Periode.setBounds(500,85,20,30);
        Periode.setVisible(true);
        add(Periode);
        
        modelTanggal2 = new UtilDateModel();
        p2 = new Properties();
        p2.put("text.today", "Today");
        p2.put("text.month", "Month");
        p2.put("text.year", "Year");
        datePanel2 = new JDatePanelImpl(modelTanggal2, p2);
        tanggalAkhir = new JDatePickerImpl(datePanel2, new DateLabelFormatter());
        tanggalAkhir.setBounds(520,90,130,30);
        tanggalAkhir.setEnabled(false);
        tanggalAkhir.getComponent(1).setEnabled(false);
        add(tanggalAkhir);
        
        tanggal.addActionListener (new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tanggal.getModel().isSelected()){
                    modelTanggal2.setValue((Date) tanggal.getModel().getValue());
                    tanggalAkhir.getModel().addDay(7);
                }
            }
        });

        
        Find = new JButton("Lihat Jadwal Matakuliah");
        Find.setBounds(15,135,640,30);
        Find.setContentAreaFilled(true);
        Find.setBackground(Color.WHITE);
        Find.setForeground(BGCOLOR_DEFAULT);
        Find.setBorder(javax.swing.BorderFactory.createLineBorder(BGCOLOR_DEFAULT));
        Find.setFocusPainted(false);
        Find.setFont(FONT_DEFAULT_PLAIN);
        Find.addActionListener(this);
        add(Find);
        
        daftarJadwal = new JTable();
        jScrollPane1 = new JScrollPane();
    }
    public void showTables(){
        //Table Daftar Hadir
        int printTahun = Integer.valueOf(ViewTahun.getText());
        String printSemester = ViewSemester.getSelectedItem().toString();
        Mahasiswa mhs = UserManager.getInstance().getMahasiswa();
        RencanaStudi rsm = RencanaStudiManageController.getRencanastudi(mhs.getNIM(), printTahun, printSemester);
        ArrayList<DetailMatakuliah> dmk = new ArrayList<>();
        for(int i=0; i<rsm.getId_Mk().size(); i++){
            dmk.add(MatakuliahManageController.getDetailMatakuliah(rsm.getId_Mk().get(i)));
        }
        
        if(dmk == null){
            JOptionPane.showMessageDialog(null,"Maaf Jadwal tidak ditemukan");
            return;
        }
        ArrayList<Roster> arrRoster = new ArrayList<>();
        ArrayList<String> arrIDMK = new ArrayList<>();
        Date TanggalAwal = (Date) tanggal.getModel().getValue();
        Date TanggalAkhir = (Date) tanggalAkhir.getModel().getValue();
        for(int i=0; i<dmk.size(); i++){
            DetailMatakuliah detailMK = dmk.get(i);
            ArrayList<Roster> arrTemp = JadwalMahasiswaController.getJadwalMahasiswa(Integer.valueOf(detailMK.getId_MK()), TanggalAwal, TanggalAkhir);
            arrRoster.addAll(arrTemp);
            arrTemp.forEach(_item -> {
                arrIDMK.add(detailMK.getId_MK());
            });
        }
        //Cek Database
        String objectJadwal[][] = new String[arrRoster.size()][6];
        for(int i=0; i<arrRoster.size() ; i++){
            DetailMatakuliah detailMK = MatakuliahManageController.getDetailMatakuliah(arrIDMK.get(i));
            Matakuliah mk = MatakuliahManageController.getMatakuliah(detailMK.getKode_MK());
            DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");  
            String dateJadwal = dateFormat.format(arrRoster.get(i).getTanggal()); 
            objectJadwal[i][0] = dateJadwal;
            objectJadwal[i][1] = arrRoster.get(i).getRuangan();
            objectJadwal[i][2] = arrRoster.get(i).getJamMulai();
            objectJadwal[i][3] = arrRoster.get(i).getJamSelesai();
            objectJadwal[i][4] = mk.getKode_MK();
            objectJadwal[i][5] = mk.getNama_MK();
        }
        //Table Jadwal
        daftarJadwal.setModel(new DefaultTableModel(
            objectJadwal, 
            new String[] {
                "Tanggal","Ruangan", "Jam Mulai", "Jam Selesai", "Kode Mk","Nama MK"
            }
        ){
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false,false
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
        jScrollPane1.setViewportView(daftarJadwal);
        if (daftarJadwal.getColumnModel().getColumnCount() > 0) {
            daftarJadwal.getColumnModel().getColumn(0).setPreferredWidth(30);
            daftarJadwal.getColumnModel().getColumn(1).setPreferredWidth(100);
            daftarJadwal.getColumnModel().getColumn(2).setPreferredWidth(150);
            daftarJadwal.getColumnModel().getColumn(3).setPreferredWidth(30);
            daftarJadwal.getColumnModel().getColumn(4).setPreferredWidth(60);
            daftarJadwal.getColumnModel().getColumn(5).setPreferredWidth(60);
            
        }
        jScrollPane1.setBounds(15,180,640,420);
        jScrollPane1.setVisible(true);
        add(jScrollPane1);
    }
    
    public boolean checkAllData(){
        if(ViewSemester.getSelectedItem().toString().equals("")){
            return false;
        }
        if(ViewTahun.getText().equals("")){
            return false;
        }
        return true;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        System.out.println("Action Panel Daftar Hadir: " + action);
        //Periode.setVisible(true);
        if(action.equals("Lihat Jadwal Matakuliah")){
            if(checkAllData() == false){
                JOptionPane.showMessageDialog(null,"Silahkan Isi Semua Data!");
            }else{
                Find.setBackground(BGCOLOR_DEFAULT);
                Find.setForeground(COLOR_WHITE);
                showTables();
                Date printTanggal = (Date) tanggal.getModel().getValue();
                tanggal.getModel().addDay(7);
                Date printTanggalAkhir = (Date) tanggal.getModel().getValue();
                System.out.println(printTanggal);
                System.out.println(printTanggalAkhir.getTime());
            }
        }
    }
    
    @Override
    public Dimension getPreferredSize() {
        return DIMENSION_PANEL_CARD;
    }
}
