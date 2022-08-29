/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.menuDaak.Helper;

import controller.DatabaseController.ContollerDaak.MatakuliahManageController;
import static controller.DatabaseController.ContollerDaak.MatakuliahManageController.getDetailMatakuliah;
import controller.DatabaseController.ContollerDaak.RencanaStudiManageController;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.matakuliah.DetailMatakuliah;
import model.matakuliah.Matakuliah;
import model.matakuliah.RencanaStudi;
import view.ViewConfig;
import static view.ViewConfig.BGCOLOR_DEFAULT;
import static view.ViewConfig.COLOR_WHITE;
import static view.ViewConfig.FONT_DEFAULT_PLAIN;

/**
 *
 * @author S W I F T 3
 */
public class JPanelHelperRencanaStudi extends JPanel implements ActionListener, ViewConfig  {
    private  JLabel labelJumlahMK;
    private  JLabel labelKodeMK;
    private  JLabel labelNamaMK;
    private  JLabel labelSKS;
    
    private JTextField fieldJumlahMK;
    private ArrayList<JTextField> fieldMK;
    private ArrayList<JLabel> fieldNamaMK;
    private ArrayList<JLabel> fieldSKS;
    private ArrayList<JTextField> fieldKelas;
    private ArrayList<JLabel>kelas;
           
    private JButton cekMK;
    private JButton btnJumlahMK;
    private JButton Save;
    private JButton Delete;
    
    private String type;
    private int jmlMK;
    private RencanaStudi RSM = null;
    private String nim = "";
    private String semester = "" ;
    private int tahun = 0;
    
    //Untuk Add
    public JPanelHelperRencanaStudi(String type,String nim, String semester, int tahun){
        setupPanel();
        this.nim = nim;
        this.semester = semester;
        this.tahun = tahun;
        this.type = type;
        generateNumberMK();
        cekMK.setVisible(true);
        Delete.setVisible(false);
        Save.setVisible(true);
    }
    //Untuk Edit dan Delete
    public JPanelHelperRencanaStudi(String type,RencanaStudi RSM,String nim){
        setupPanel();
        this.RSM = RSM;
        this.nim = nim;
        this.type = type;
        this.semester = RSM.getSemesterAjaran();
        this.tahun = RSM.getTahunAjaran();
        if(type.equals("Delete")){
            generateShowForm();
            cekMK.setVisible(false);
            Delete.setVisible(true);
            Save.setVisible(false);
        }else if(type.equals("Edit")){
            generateEditForm();
            cekMK.setVisible(true);
            Delete.setVisible(false);
            Save.setVisible(true);
        }
        
    }
    private void setupPanel(){
        setLayout(null);
       
        cekMK = new JButton("Cek Data");
        cekMK.setBounds(260,445, 100, 30);
        cekMK.setContentAreaFilled(true);
        cekMK.setBackground(BGCOLOR_DEFAULT);
        cekMK.setForeground(COLOR_WHITE);
        cekMK.setBorder(javax.swing.BorderFactory.createLineBorder(BGCOLOR_DEFAULT));
        cekMK.setFocusPainted(false);
        cekMK.setFont(FONT_DEFAULT_PLAIN);
        cekMK.addActionListener(this);
        cekMK.setVisible(false);
        add(cekMK);
            
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
    
    private void generateNumberMK(){
        labelJumlahMK = new JLabel("Jumlah Matakuliah");
        labelJumlahMK.setBounds(0,5, 120, 30);
        labelJumlahMK.setFont(FONT_DEFAULT_PLAIN );
        add(labelJumlahMK);
        
        fieldJumlahMK = new JTextField();
        fieldJumlahMK.setBounds(140,5, 200, 30);
        fieldJumlahMK.setFont(FONT_DEFAULT_PLAIN);
        add(fieldJumlahMK);
        
        btnJumlahMK = new JButton("Ok");
        btnJumlahMK.setBounds(360,5, 100, 30);
        btnJumlahMK.setContentAreaFilled(true);
        btnJumlahMK.setBackground(BGCOLOR_DEFAULT);
        btnJumlahMK.setForeground(COLOR_WHITE);
        btnJumlahMK.setBorder(javax.swing.BorderFactory.createLineBorder(BGCOLOR_DEFAULT));
        btnJumlahMK.setFocusPainted(false);
        btnJumlahMK.setFont(FONT_DEFAULT_PLAIN);
        btnJumlahMK.addActionListener(this);
        add(btnJumlahMK);
        
        
    }
    private void generateLabel(){
        int marginTop = 45;
        
        labelKodeMK = new JLabel("Kode MK");
        labelKodeMK.setFont(FONT_DEFAULT_PLAIN);
        labelKodeMK.setBounds(0,marginTop, 70, 30);
        labelKodeMK.setVisible(false);
        add(labelKodeMK);
        labelKodeMK.setVisible(true);
        
        labelNamaMK = new JLabel("Nama MK");
        labelNamaMK.setFont(FONT_DEFAULT_PLAIN);
        labelNamaMK.setBounds(90,marginTop, 200, 30);
        labelNamaMK.setVisible(false);
        add(labelNamaMK);
        labelNamaMK.setVisible(true);
        
        labelSKS = new JLabel("SKS");
        labelSKS.setFont(FONT_DEFAULT_PLAIN);
        labelSKS.setBounds(310,marginTop, 70, 30);
        labelSKS.setVisible(false);
        add(labelSKS);
        labelSKS.setVisible(true);
        
        labelSKS = new JLabel("Kelas");
        labelSKS.setFont(FONT_DEFAULT_PLAIN);
        labelSKS.setBounds(400,marginTop, 70, 30);
        labelSKS.setVisible(false);
        add(labelSKS);
        labelSKS.setVisible(true);
        
        labelSKS = new JLabel("Daftar Kelas");
        labelSKS.setFont(FONT_DEFAULT_PLAIN);
        labelSKS.setBounds(490,marginTop, 1000, 30);
        labelSKS.setVisible(false);
        add(labelSKS);
        labelSKS.setVisible(true);
        
    }
    
    private void generateInputForm(){
        
        generateLabel();
        
        fieldMK = new ArrayList<JTextField>();
        fieldNamaMK = new ArrayList<JLabel>();
        fieldSKS = new ArrayList<JLabel>();
        fieldKelas = new ArrayList<JTextField>();
        kelas = new ArrayList<JLabel>();
        int marginTop = 85;
        for(int i=0; i<jmlMK; i++){
            JTextField temp = new JTextField();
            temp.setBounds(0,marginTop, 70, 30);
            temp.setFont(FONT_DEFAULT_PLAIN);
            temp.setVisible(false);
            add(temp);
            temp.setVisible(true);
            fieldMK.add(temp);
            
            JLabel temp1 = new JLabel("-");
            temp1.setBounds(90,marginTop, 200, 30);
            temp1.setFont(FONT_DEFAULT_PLAIN);
            temp1.setVisible(false);
            add(temp1);
            temp1.setVisible(true);
            fieldNamaMK.add(temp1);
            
            JLabel temp2 = new JLabel("-");
            temp2.setBounds(310,marginTop, 70, 30);
            temp2.setFont(FONT_DEFAULT_PLAIN);
            temp2.setVisible(false);
            add(temp2);
            temp2.setVisible(true);
            fieldSKS.add(temp2);
            
            JTextField temp3 = new JTextField();
            temp3.setBounds(400,marginTop, 70, 30);
            temp3.setFont(FONT_DEFAULT_PLAIN);
            temp3.setVisible(false);
            add(temp3);
            temp3.setVisible(true);
            temp3.setEnabled(false);
            fieldKelas.add(temp3);
            
            JLabel temp4 = new JLabel("-");
            temp4.setBounds(490,marginTop, 100, 30);
            temp4.setFont(FONT_DEFAULT_PLAIN);
            temp4.setVisible(false);
            add(temp4);
            temp4.setVisible(true);
            kelas.add(temp4);
                       
            marginTop += 40;
        }
      
    }
    
    private void generateEditForm(){
        //Check Database 
        jmlMK = RSM.getId_Mk().size();
        generateNumberMK();
        fieldJumlahMK.setText(String.valueOf(jmlMK));
        generateInputForm();
        for(int i=0; i<fieldMK.size(); i++){
            DetailMatakuliah detailMK = getDetailMatakuliah(RSM.getId_Mk().get(i));
            fieldMK.get(i).setText(detailMK.getKode_MK());
        }
        System.out.println(semester + " test  "+ tahun);
        //checkMK();
        
    }
    
    private void generateShowForm(){
        
        generateEditForm();
        btnJumlahMK.setEnabled(false);
        for(int i=0; i< fieldMK.size(); i++){
            fieldMK.get(i).setEditable(false);
            fieldKelas.get(i).setEditable(false);
        }
       
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        System.out.println("Action Panel Helper Rencana Studi : " + action);
        if(action.equals("Ok")){
            jmlMK = Integer.valueOf(fieldJumlahMK.getText());
            if(fieldMK != null){
                for(int i=0; i<fieldMK.size(); i++){
                    fieldMK.get(i).setVisible(false);
                    fieldNamaMK.get(i).setVisible(false);
                    fieldSKS.get(i).setVisible(false);
                    fieldKelas.get(i).setVisible(false);
                    kelas.get(i).setVisible(false);
                }
                fieldMK.clear();
                fieldNamaMK.clear();
                fieldSKS.clear();
                fieldKelas.clear();
                kelas.clear();
            }
            generateInputForm();
        }
        if(action.equals("Simpan")){
            if(!checkInput()){
                JOptionPane.showMessageDialog(labelKodeMK, "Terdapat Kode Matakuliah yang tidak ditemukan !");
                return;
            }
            ArrayList<String> idMK = new ArrayList<>();
            
            for(int i=0; i<fieldMK.size(); i++){
                String kodeMKCheck = fieldMK.get(i).getText();
                char kelas = fieldKelas.get(i).getText().charAt(0);
                DetailMatakuliah mk = MatakuliahManageController.getDetailMatakuliah(kodeMKCheck, tahun, semester,kelas);
                idMK.add(mk.getId_MK());
            }
            if(RSM == null){
                RencanaStudi newRS = new RencanaStudi();
                newRS.setSemesterAjaran(semester);
                newRS.setTahunAjaran(tahun);
                newRS.createId_RSM(nim);
                newRS.setId_Mk(idMK);
                if(RencanaStudiManageController.insertRencanaStudi(newRS, nim)){
                    JOptionPane.showMessageDialog(labelKodeMK, "Data berhasil dimasukan ke database");
                }else{
                    JOptionPane.showMessageDialog(labelKodeMK, "Data gagal dimasukan ke database");
                }
            }else{
                RencanaStudi newRS = new RencanaStudi();
                newRS.setSemesterAjaran(semester);
                newRS.setTahunAjaran(tahun);
                newRS.setId_RSM(RSM.getId_RSM());
                newRS.setId_Mk(idMK);
                RencanaStudiManageController.deleteHasilStudi(RSM,nim);
                if(RencanaStudiManageController.updateRencanaStudi(newRS, nim)){
                    JOptionPane.showMessageDialog(labelKodeMK, "Data berhasil diupdate ke database");
                }else{
                    JOptionPane.showMessageDialog(labelKodeMK, "Data gagal diupdate ke database");
                }
            }
        }
        if(action.equals("Hapus")){
            if(RencanaStudiManageController.deleteRencanaStudi(RSM.getId_RSM())){
                    JOptionPane.showMessageDialog(labelKodeMK, "Data berhasil dihapus di database");
            }else{
                    JOptionPane.showMessageDialog(labelKodeMK, "Data gagal dihapus di database");
            }
        }
    
        if(action.equals("Cek Data")){
            checkMK();
        }
    }
    private boolean checkMK(){
        int errorCount = 0;
        for(int i=0; i<fieldMK.size(); i++){
                String kodeMK = fieldMK.get(i).getText();
                ArrayList<DetailMatakuliah> mk =  MatakuliahManageController.getArrayDetailMatakuliah(kodeMK, tahun, semester);
                if(!mk.isEmpty()){
                    String allKelas = "";
                    for(int j=0; j<mk.size(); j++){
                        fieldNamaMK.get(i).setText(mk.get(j).getNama_MK());
                        fieldSKS.get(i).setText(String.valueOf(mk.get(j).getSks()));
                        allKelas += String.valueOf(mk.get(j).getKelas());
                        if(j < mk.size()-1){
                            allKelas += ", ";
                        }
                    }
                    fieldKelas.get(i).setEnabled(true);
                    kelas.get(i).setText(allKelas);
                }else{
                    fieldNamaMK.get(i).setText("-Tidak ditemukan !-");
                    errorCount++;
                }
                
        }
        if(errorCount > 0){
            return false;
        }else{
            return true;
        }
    }
    private boolean checkInput(){
        for(int i=0; i<fieldMK.size(); i++){
            if(fieldNamaMK.get(i).getText().equals("-Tidak ditemukan !-") || fieldKelas.get(i).getText().equals("")){
                return false;
            }
        }
        return true;
    }
}
