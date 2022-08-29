/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.menuDosen;

import controller.DatabaseController.ControllerDosen.MatakuliahController;
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
public class JPanelRekapDataMengajar  extends JPanel implements ActionListener, ViewConfig{
    private final JPanel Header;
    private final JLabel Judul, Tahun, Semester;
    private final JComboBox ViewSemester;
    private final String SemesterValue[] = {"", "Ganjil", "Genap", "Pendek"};
    private final JTextField ViewTahun;
    private final JButton Find;
    private final JTable rekapData;
    private JScrollPane jScrollPane1;
    public JPanelRekapDataMengajar(){
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
        //Button Rekap Data Mengajar
        Find = new JButton("Lihat Rekap Data Mengajar");
        Find.setBounds(330,88,300,30);
        Find.setContentAreaFilled(true);
        Find.setBackground(Color.WHITE);
        Find.setForeground(BGCOLOR_DEFAULT);
        Find.setBorder(javax.swing.BorderFactory.createLineBorder(BGCOLOR_DEFAULT));
        Find.setFocusPainted(false);
        Find.setFont(FONT_DEFAULT_PLAIN);
        Find.addActionListener(this);
        add(Find);
        //Table Rekap Data Mengajar
        rekapData = new JTable();
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
    
    private void ShowTablesRekapDataMengajar(){
        Dosen dsn = (Dosen) UserManager.getInstance().getUser();
        int printTahun = Integer.valueOf(ViewTahun.getText());
        String printSemester = ViewSemester.getSelectedItem().toString();
        ArrayList<DetailMatakuliah> dmk = MatakuliahController.getArrayDetailMatakuliah(dsn.getNID(), printTahun, printSemester);
        if(dmk == null){
            JOptionPane.showMessageDialog(null,"Data yang dimasukan tidak tersedia!");
            return;
        }
        String RekapData[][] = new String[dmk.size()][5];
        for(int i=0;i <dmk.size();i++){
            RekapData[i][0] = String.valueOf(i + 1) + ". ";
            RekapData[i][1] = dmk.get(i).getKode_MK();
            RekapData[i][2] = dmk.get(i).getNama_MK();
            RekapData[i][3] = String.valueOf(dmk.get(i).getSks());
            RekapData[i][4] = String.valueOf(dmk.get(i).getKelas());
        }
        
        rekapData.setModel(new DefaultTableModel(
            RekapData, 
            new String[] {
                "No", "Kode MK", "Nama Matakuliah", "SKS", "Kelas"
            }
        ){
            Class[] types = new Class [] {
                java.lang.String.class,java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        jScrollPane1.setViewportView(rekapData);
        if (rekapData.getColumnModel().getColumnCount() > 0) {
            rekapData.getColumnModel().getColumn(0).setPreferredWidth(30);
            rekapData.getColumnModel().getColumn(1).setPreferredWidth(60);
            rekapData.getColumnModel().getColumn(2).setPreferredWidth(200);
            rekapData.getColumnModel().getColumn(3).setPreferredWidth(30);
            rekapData.getColumnModel().getColumn(4).setPreferredWidth(30);
            
           
        }
        jScrollPane1.setBounds(15,140,640,260);
        jScrollPane1.setVisible(true);
        add(jScrollPane1);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        System.out.println("Action Panel Rekap Data Mengajar: " + action);
        if(checkAllData() == false){
            JOptionPane.showMessageDialog(null,"Silahkan Isi Semua Data!");
        }else{
            Find.setBackground(BGCOLOR_DEFAULT);
            Find.setForeground(COLOR_WHITE);
            jScrollPane1.setVisible(true);
            System.out.println("");
            ShowTablesRekapDataMengajar();
            
        }
    }
    @Override
    public Dimension getPreferredSize() {
        return DIMENSION_PANEL_CARD;
    }
}
