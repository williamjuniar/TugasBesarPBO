/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.menuDaak.Helper;

import controller.DatabaseController.ContollerDaak.RosterManageController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import model.matakuliah.Roster;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import view.ViewConfig;
import static view.ViewConfig.BGCOLOR_DEFAULT;
import static view.ViewConfig.COLOR_WHITE;
import static view.ViewConfig.FONT_DEFAULT_PLAIN;

/**
 *
 * @author S W I F T 3
 */
public class JPanelHelperJadwal extends JPanel implements ActionListener, ViewConfig  {
    private  JLabel labelTanggal;
    private  JLabel labelJamMulai;
    private  JLabel labelJamSelesai;
    private  JLabel labelRuangan;
    private  JLabel labelKehadiranDosen;
    
       
    private UtilDateModel modelTglRoster;
    private JDatePanelImpl datePanelTglLahir;
    private Properties  propertiesTglLahir;   
        
    private JDatePickerImpl fieldTanggal;
    private JSpinner fieldJamMulai;
    private final String listJam[] = {"01:00:00","01:30:00","02:00:00","02:30:00","03:00:00","03:30:00","04:00:00","04:30:00","05:00:00","05:30:00","06:00:00","06:30:00","07:00:00","07:30:00","08:00:00","08:30:00","09:00:00","09:30:00","10:00:00" ,"10:30:00" ,"11:00:00" ,"11:30:00" ,"12:00:00" ,"12:30:00" ,"13:00:00" ,"13:30:00" ,"14:00:00" ,"14:30:00" ,"15:00:00" ,"15:30:00" ,"16:00:00" ,"16:30:00" ,"17:00:00" ,"17:30:00" ,"18:00:00" ,"18:30:00" ,"19:00:00" ,"19:30:00" ,"20:00:00" ,"20:30:00" ,"21:00:00" ,"21:30:00" ,"22:00:00" ,"22:30:00" ,"23:00:00" ,"23:30:00" ,"24:00:00" ,"24:30:00"};
    
    private JSpinner fieldJamSelesai;
    private JTextField fieldRuangan;
    private JRadioButton fieldDosenHadir;
    private JRadioButton fieldDosenTidakHadir;
    private JComboBox fieldAllRoster;
    
    private ButtonGroup bgKehadiranDosen;
    private JButton Save;
    private JButton Delete;
    
    private String idMK = "";
    private ArrayList<Roster> roster = null;
    private Roster rosterNow = null;
    private boolean isEdit = true;
    
    public JPanelHelperJadwal(String type,ArrayList<Roster> roster,String idMK){
        this.idMK = idMK;
        this.roster = roster;
        generatePanel();
        if(type.equals("Delete")){
            generateShowForm(roster.get(0));
            isEdit = false;
            Delete.setVisible(true);
            Save.setVisible(false);
        }else if(type.equals("Edit")){
            generateEditForm(roster.get(0));
            Delete.setVisible(false);
            Save.setVisible(true);
        }
    }
    
    public JPanelHelperJadwal(String type,String idMK){
        this.idMK = idMK;
        generatePanel();
        generateInputForm();
        Delete.setVisible(false);
        Save.setVisible(true);
    }
    
    private void generatePanel(){
        setLayout(null);
        
        Save = new JButton("Simpan");
        Save.setBounds(370,445, 100, 30);
        Save.setContentAreaFilled(true);
        Save.setBackground(BGCOLOR_DEFAULT);
        Save.setForeground(COLOR_WHITE);
        Save.setBorder(javax.swing.BorderFactory.createLineBorder(BGCOLOR_DEFAULT));
        Save.setFocusPainted(false);
        Save.setFont(FONT_DEFAULT_PLAIN);
        Save.addActionListener(this);
        Save.setVisible(false);
        add(Save);
        
        Delete = new JButton("Hapus");
        Delete.setBounds(370,445, 100, 30);
        Delete.setContentAreaFilled(true);
        Delete.setBackground(BGCOLOR_DEFAULT);
        Delete.setForeground(COLOR_WHITE);
        Delete.setBorder(javax.swing.BorderFactory.createLineBorder(BGCOLOR_DEFAULT));
        Delete.setFocusPainted(false);
        Delete.setFont(FONT_DEFAULT_PLAIN);
        Delete.addActionListener(this);
        Delete.setVisible(false);
        add(Delete);
        
    }
    private void generateLabel(){
        labelTanggal = new JLabel("Tanggal :");
        labelTanggal.setBounds(0,5, 120, 30);
        labelTanggal.setFont(FONT_DEFAULT_PLAIN );
        add(labelTanggal);
        
        labelJamMulai = new JLabel("Jam Mulai :");
        labelJamMulai.setBounds(0,45, 120, 30);
        labelJamMulai.setFont(FONT_DEFAULT_PLAIN );
        add(labelJamMulai);
        
        labelJamSelesai = new JLabel("Jam Selesai :");
        labelJamSelesai.setBounds(0,85, 120, 30);
        labelJamSelesai.setFont(FONT_DEFAULT_PLAIN);
        add(labelJamSelesai);
        
        labelRuangan = new JLabel("Ruangan :");
        labelRuangan.setBounds(0,125, 120, 30);
        labelRuangan.setFont(FONT_DEFAULT_PLAIN);
        add(labelRuangan);
        
        labelKehadiranDosen = new JLabel("Kehadiran Dosen :");
        labelKehadiranDosen.setBounds(0,165, 120, 30);
        labelKehadiranDosen.setFont(FONT_DEFAULT_PLAIN);
        add(labelKehadiranDosen);
        
    }
    
    private void generateInputForm(){
        
        generateLabel();
        
        propertiesTglLahir = new Properties();
        propertiesTglLahir.put("text.today", "Today");
        propertiesTglLahir.put("text.month", "Month");
        propertiesTglLahir.put("text.year", "Year");
        modelTglRoster = new UtilDateModel();
        datePanelTglLahir = new JDatePanelImpl(modelTglRoster, propertiesTglLahir);
        fieldTanggal = new JDatePickerImpl(datePanelTglLahir, new DateLabelFormatter());
        fieldTanggal.setBounds(140,5, 200, 30);
        fieldTanggal.setFont(FONT_DEFAULT_PLAIN);
        add(fieldTanggal);
        
        fieldJamMulai = new JSpinner(new SpinnerListModel(listJam));
        fieldJamMulai.setBounds(140,45, 200, 30);
        fieldJamMulai.setFont(FONT_DEFAULT_PLAIN);
        add(fieldJamMulai);
        
        fieldJamSelesai = new JSpinner(new SpinnerListModel(listJam));
        fieldJamSelesai.setBounds(140,85, 200, 30);
        fieldJamSelesai.setFont(FONT_DEFAULT_PLAIN);
        add(fieldJamSelesai);
        
        fieldRuangan = new JTextField();
        fieldRuangan.setBounds(140,125, 200, 30);
        fieldRuangan.setFont(FONT_DEFAULT_PLAIN);
        add(fieldRuangan);
        
        fieldDosenHadir = new JRadioButton("Hadir");
        fieldDosenHadir.setBounds(140,165, 100, 30);
        fieldDosenHadir.setFont(FONT_DEFAULT_PLAIN);
        add(fieldDosenHadir);
        
        fieldDosenTidakHadir = new JRadioButton("Tidak Hadir");
        fieldDosenTidakHadir.setBounds(240,165, 100, 30);
        fieldDosenTidakHadir.setFont(FONT_DEFAULT_PLAIN);
        add(fieldDosenTidakHadir);
        
        bgKehadiranDosen = new ButtonGroup();
        bgKehadiranDosen.add(fieldDosenHadir);
        bgKehadiranDosen.add(fieldDosenTidakHadir);
        
        if(roster != null){
            String listdate[] = new String[roster.size()] ;
            for(int i=0; i<listdate.length; i++){
                DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");  
                listdate[i] = dateFormat.format(roster.get(i).getTanggal());  
            }
            fieldAllRoster = new JComboBox(listdate);
            fieldAllRoster.setBounds(360,5, 150, 30);
            fieldAllRoster.setFont(FONT_DEFAULT_PLAIN);
            add(fieldAllRoster);
            
            fieldAllRoster.addActionListener (new ActionListener () {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //Reset
                        if( roster.get(fieldAllRoster.getSelectedIndex()) != rosterNow ){
                            fieldTanggal.setVisible(false);
                            fieldJamMulai.setVisible(false);
                            fieldJamSelesai.setVisible(false);
                            fieldRuangan.setVisible(false);
                            fieldDosenHadir.setVisible(false);
                            fieldDosenTidakHadir.setVisible(false);
                            if(isEdit){
                                generateEditForm(roster.get(fieldAllRoster.getSelectedIndex()));
                            }else{
                                generateShowForm(roster.get(fieldAllRoster.getSelectedIndex()));
                            }
                            
                            //System.out.println("Tanggl yg baru  " + rosterNow.getRuangan());
                            

                        }
                    }
            });
        }
        
        
    }
    
    private void generateEditForm(Roster r){
        generateInputForm();
        modelTglRoster.setSelected(true);
        modelTglRoster.setValue(r.getTanggal());
        fieldJamMulai.setValue(r.getJamMulai());
        fieldJamSelesai.setValue(r.getJamSelesai());
        fieldRuangan.setText(r.getRuangan());
        if(r.isStatusDosen()){
            fieldDosenHadir.setSelected(true);
        }else{
            fieldDosenTidakHadir.setSelected(true);
        }
        rosterNow = r;
    }
    
    private void generateShowForm(Roster r){
        
        generateEditForm(r);
        fieldTanggal.setEnabled(false);
        fieldTanggal.getComponent(1).setEnabled(false);
        fieldJamMulai.setEnabled(false); 
        fieldJamSelesai.setEnabled(false);
        fieldRuangan.setEditable(false);
            
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        System.out.println("Action Panel Helper Matakuliah : " + action);
        if(action.equals("Simpan")){
            Date tanggal = (Date) fieldTanggal.getModel().getValue();
            String jamMulai = (String) fieldJamMulai.getValue();
            String jamSelesai = (String) fieldJamSelesai.getValue();
            String ruangan = fieldRuangan.getText();
            boolean statusDosen = false;
            if(fieldDosenHadir.isSelected()){
                statusDosen = true;
            }
            
            Roster newRoster = new Roster(0,tanggal,jamMulai,jamSelesai,ruangan,statusDosen);
            if(roster == null){
                if(RosterManageController.insertRoster(newRoster, idMK)){
                    JOptionPane.showMessageDialog(null, "Berhasil Menyimpan ke Database");
                }else{
                    JOptionPane.showMessageDialog(null, "Gagal Menyimpan ke Database");
                }
            }else{
                int idroster = RosterManageController.getRoster(rosterNow, idMK);
                if(RosterManageController.updateRoster(newRoster, idMK, idroster)){
                    JOptionPane.showMessageDialog(null, "Berhasil Menyimpan ke Database");
                }else{
                    JOptionPane.showMessageDialog(null, "Gagal Menyimpan ke Database");
                }
                //update
            }
            
        }else if(action.equals("Hapus")){
            int idroster = RosterManageController.getRoster(rosterNow, idMK);
            if(RosterManageController.deleteRoster(idroster)){
                    JOptionPane.showMessageDialog(null, "Berhasil Menghapus di Database");
            }else{
                JOptionPane.showMessageDialog(null, "Gagal Menghapus di Database");
            }
            //Hapus ke controller database
        }
        
        
    }
       
}
