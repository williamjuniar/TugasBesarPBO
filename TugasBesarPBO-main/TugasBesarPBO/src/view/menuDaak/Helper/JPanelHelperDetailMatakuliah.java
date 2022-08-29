/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.menuDaak.Helper;

import controller.DatabaseController.ContollerDaak.MatakuliahManageController;
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
import view.ViewConfig;
import static view.ViewConfig.FONT_DEFAULT_PLAIN;

/**
 *
 * @author S W I F T 3
 */
public class JPanelHelperDetailMatakuliah extends JPanel implements ActionListener, ViewConfig  {
    private  JLabel labelKodeMK;
    private  JLabel labelTahunAjaran;
    private  JLabel labelSemester;
    private  JLabel labelKelas;
    private  JLabel labelJumlahPertemuan;
    private  JLabel labelDosen;
    
    JTextField fieldKodeMK;
    JTextField fieldTahunAjaran;
    String[] listSemester = {"","Ganjil", "Genap","Pendek"};
    JComboBox fieldSemester;
    JTextField fieldKelas;
    JTextField fieldJumlahPertemuan;
    JTextField fieldNID;
        
    JButton Save;
    JButton Delete;
    DetailMatakuliah detailMK = null;
     
    public JPanelHelperDetailMatakuliah(String type,DetailMatakuliah detailMK){
        setLayout(null);
        this.detailMK = detailMK;
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
        
        if(type.equals("Input")){
            generateInputForm();
            Delete.setVisible(false);
            Save.setVisible(true);
        }else if(type.equals("Delete")){
            generateShowForm();
            Delete.setVisible(true);
            Save.setVisible(false);
        }else if(type.equals("Edit")){
            generateEditForm();
            Delete.setVisible(false);
            Save.setVisible(true);
        }
    }
    private void generateLabel(){
                
        labelKodeMK = new JLabel("Kode Matakuliah  :");
        labelKodeMK.setBounds(0,5, 120, 30);
        labelKodeMK.setFont(FONT_DEFAULT_PLAIN );
        add(labelKodeMK);
        
        labelTahunAjaran = new JLabel("Tahun Ajaran :");
        labelTahunAjaran.setBounds(0,45, 120, 30);
        labelTahunAjaran.setFont(FONT_DEFAULT_PLAIN );
        add(labelTahunAjaran);
        
        labelSemester = new JLabel("Semester :");
        labelSemester.setBounds(0,85, 120, 30);
        labelSemester.setFont(FONT_DEFAULT_PLAIN);
        add(labelSemester);
        
        labelKelas = new JLabel("Kelas :");
        labelKelas.setBounds(0,125, 120, 30);
        labelKelas.setFont(FONT_DEFAULT_PLAIN);
        add(labelKelas);
        
        labelJumlahPertemuan = new JLabel("Jumlah Pertemuan :");
        labelJumlahPertemuan.setBounds(0,165, 130, 30);
        labelJumlahPertemuan.setFont(FONT_DEFAULT_PLAIN);
        add(labelJumlahPertemuan);
        
        labelDosen = new JLabel("Dosen Pengajar :");
        labelDosen.setBounds(0,205, 130, 30);
        labelDosen.setFont(FONT_DEFAULT_PLAIN);
        add(labelDosen);
       
    }
    
    private void generateInputForm(){
        
        generateLabel();
        
        fieldKodeMK = new JTextField();
        fieldKodeMK.setBounds(140,5, 100, 30);
        fieldKodeMK.setFont(FONT_DEFAULT_PLAIN);
        add(fieldKodeMK);
        
        fieldTahunAjaran = new JTextField();
        fieldTahunAjaran.setBounds(140,45, 100, 30);
        fieldTahunAjaran.setFont(FONT_DEFAULT_PLAIN);
        add(fieldTahunAjaran);
        
        fieldSemester = new JComboBox(listSemester);
        fieldSemester.setBounds(140,85, 200, 30);
        fieldSemester.setFont(FONT_DEFAULT_PLAIN);
        add(fieldSemester);
        
        fieldKelas = new JTextField();
        fieldKelas.setBounds(140,125, 70, 30);
        fieldKelas.setFont(FONT_DEFAULT_PLAIN);
        add(fieldKelas);
        
        fieldJumlahPertemuan = new JTextField();
        fieldJumlahPertemuan.setBounds(140,165, 70, 30);
        fieldJumlahPertemuan.setFont(FONT_DEFAULT_PLAIN);
        add(fieldJumlahPertemuan);
        
        fieldNID = new JTextField();
        fieldNID.setBounds(140,205, 70, 30);
        fieldNID.setFont(FONT_DEFAULT_PLAIN);
        add(fieldNID);
        
        
      
    }
    
    private void generateEditForm(){
    
        generateInputForm();
        
        fieldKodeMK.setText(detailMK.getId_MK());
        fieldTahunAjaran.setText(String.valueOf(detailMK.getTahun()));
        fieldSemester.setSelectedItem(detailMK.getSemester());
        fieldKelas.setText(String.valueOf(detailMK.getKelas()));
        fieldJumlahPertemuan.setText(String.valueOf(detailMK.getJumlahPertemuan()));
        fieldNID.setText(detailMK.getNid());
    
    }
    
    private void generateShowForm(){
        
        generateEditForm();
        
        fieldKodeMK.setEditable(false);
        fieldTahunAjaran.setEditable(false);
        fieldSemester.setEnabled(false);
        fieldKelas.setEnabled(false);
        fieldJumlahPertemuan.setEditable(false);
        fieldNID.setEditable(false);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        System.out.println("Action Panel Helper Detail Matakuliah : " + action);
        if(action.equals("Simpan")){
            String kodeMK = fieldKodeMK.getText();
            String tahunAjaran = fieldTahunAjaran.getText();
            String semester = (String) fieldSemester.getItemAt(fieldSemester.getSelectedIndex());
            String kelas = fieldKelas.getText();
            String jumlahPertemuan = fieldJumlahPertemuan.getText();
            String dosen = fieldNID.getText();
            DetailMatakuliah dMK = new DetailMatakuliah();
            dMK.setKode_MK(kodeMK);
            dMK.setTahun(Integer.valueOf(tahunAjaran));
            dMK.setSemester(semester);
            dMK.setKelas(kelas.charAt(0));
            dMK.setJumlahPertemuan(Integer.valueOf(jumlahPertemuan));
            dMK.setNid(dosen);
            
            if(detailMK == null){
                if(MatakuliahManageController.insertDetailMatakuliah(dMK)){
                   JOptionPane.showMessageDialog(null, "Berhasil Menyimpan ke Database");
                }else{
                   JOptionPane.showMessageDialog(null, "Gagal Menyimpan ke Database");
                }
            }else{
                dMK.setId_MK(detailMK.getId_MK());
                if(MatakuliahManageController.updateDetailMatakuliah(dMK)){
                   JOptionPane.showMessageDialog(null, "Berhasil Mengupdate  ke Database");
                }else{
                   JOptionPane.showMessageDialog(null, "Gagal Mengupdate  ke Database");
                }
            }
            
        }else if(action.equals("Hapus")){
            if(MatakuliahManageController.deleteDetailMatakuliah(detailMK.getKode_MK(),detailMK.getTahun(),detailMK.getSemester())){
                    JOptionPane.showMessageDialog(null, "Berhasil Menghapus ke Database");
            }else{
                JOptionPane.showMessageDialog(null, "Gagal Menghapus ke Database");
            }
        }
        
    }
    
}
