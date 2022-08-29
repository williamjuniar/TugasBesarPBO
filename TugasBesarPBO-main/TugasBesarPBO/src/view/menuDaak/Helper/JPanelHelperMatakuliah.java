/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.menuDaak.Helper;

import controller.DatabaseController.ContollerDaak.MatakuliahManageController;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import model.enums.JenisMatakuliah;
import model.enums.SifatMatakuliah;
import model.matakuliah.Matakuliah;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import view.ViewConfig;
import static view.ViewConfig.FONT_DEFAULT_PLAIN;

/**
 *
 * @author S W I F T 3
 */
public class JPanelHelperMatakuliah extends JPanel implements ActionListener, ViewConfig {
    private  JLabel labelKodeMK;
    private  JLabel labelNamaMK;
    private  JLabel labelJenisMK;
    private  JLabel labelSifatMK;
    private  JLabel labelSKS;
    
    JTextField fieldKodeMK;
    JTextField fieldNamaMK;
    JComboBox fieldJenisMK;
    JComboBox fieldSifatMK;
    JSpinner fieldSKS;
        
    JButton Save;
    JButton Delete;
    Matakuliah matakuliah = null;
    
    public JPanelHelperMatakuliah(String type,Matakuliah kodeMK){
        setLayout(null);
        this.matakuliah = kodeMK;
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
        setBackground(Color.DARK_GRAY);
    }
    
    private void generateLabel(){
        
        labelKodeMK = new JLabel("Kode Matakuliah  :");
        labelKodeMK.setBounds(0,5, 120, 30);
        labelKodeMK.setFont(FONT_DEFAULT_PLAIN );
        add(labelKodeMK);
        
        labelNamaMK = new JLabel("Nama Matakuliah :");
        labelNamaMK.setBounds(0,45, 120, 30);
        labelNamaMK.setFont(FONT_DEFAULT_PLAIN );
        add(labelNamaMK);
        
        labelJenisMK = new JLabel("Jenis Matakuliah :");
        labelJenisMK.setBounds(0,85, 120, 30);
        labelJenisMK.setFont(FONT_DEFAULT_PLAIN);
        add(labelJenisMK);
        
        labelSifatMK = new JLabel("Sifat Matakuliah :");
        labelSifatMK.setBounds(0,125, 120, 30);
        labelSifatMK.setFont(FONT_DEFAULT_PLAIN);
        add(labelSifatMK);
        
        labelSKS = new JLabel("Jumlah SKS :");
        labelSKS.setBounds(0,165, 120, 30);
        labelSKS.setFont(FONT_DEFAULT_PLAIN);
        add(labelSKS);
       
    }
    
    private void generateInputForm(){
        
        generateLabel();
        
        fieldKodeMK = new JTextField();
        fieldKodeMK.setBounds(140,5, 200, 30);
        fieldKodeMK.setFont(FONT_DEFAULT_PLAIN);
        add(fieldKodeMK);
        
        fieldNamaMK = new JTextField();
        fieldNamaMK.setBounds(140,45, 200, 30);
        fieldNamaMK.setFont(FONT_DEFAULT_PLAIN);
        add(fieldNamaMK);
        
        fieldJenisMK = new JComboBox(JenisMatakuliah.values());
        fieldJenisMK.setBounds(140,85, 200, 30);
        fieldJenisMK.setFont(FONT_DEFAULT_PLAIN);
        add(fieldJenisMK);
        
        fieldSifatMK = new JComboBox(SifatMatakuliah.values());
        fieldSifatMK.setBounds(140,125, 200, 30);
        fieldSifatMK.setFont(FONT_DEFAULT_PLAIN);
        add(fieldSifatMK);
        
        fieldSKS = new JSpinner();
        fieldSKS.setBounds(140,165, 200, 30);
        fieldSKS.setFont(FONT_DEFAULT_PLAIN);
        add(fieldSKS);
        
        
      
    }
    
    private void generateEditForm(){
    
        generateInputForm();
        
        fieldKodeMK.setText(matakuliah.getKode_MK());
        fieldNamaMK.setText(matakuliah.getNama_MK());
        fieldJenisMK.setSelectedIndex(matakuliah.getJenis_MK().ordinal());
        fieldSifatMK.setSelectedIndex(matakuliah.getSifat_MK().ordinal());
        fieldSKS.setValue(matakuliah.getSks());
    
    }
    
    private void generateShowForm(){
        
        generateEditForm();
        
        fieldKodeMK.setEditable(false);
        fieldNamaMK.setEditable(false);
        fieldJenisMK.setEnabled(false);
        fieldSifatMK.setEnabled(false);
        fieldSKS.setEnabled(false);        
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        System.out.println("Action Panel Helper Matakuliah : " + action);
        if(action.equals("Simpan")){
            String kode_MK = fieldKodeMK.getText();
            String namaMK = fieldNamaMK.getText();
            JenisMatakuliah jenisMK = (JenisMatakuliah) fieldJenisMK.getItemAt(fieldJenisMK.getSelectedIndex());
            SifatMatakuliah sifatMK = (SifatMatakuliah) fieldSifatMK.getItemAt(fieldSifatMK.getSelectedIndex());
            int sksMK = (int) fieldSKS.getValue();
           
            Matakuliah  mk = new Matakuliah();
            
            mk.setKode_MK(kode_MK);
            mk.setNama_MK(namaMK);
            mk.setJenis_MK(jenisMK);
            mk.setSifat_MK(sifatMK);
            mk.setSks(sksMK);
            
            if(matakuliah == null){
                if(MatakuliahManageController.insertMatakuliah(mk)){
                   JOptionPane.showMessageDialog(null, "Berhasil Menyimpan ke Database");
                }else{
                   JOptionPane.showMessageDialog(null, "Gagal Menyimpan ke Database");
                }
            }else{
                 mk.setKode_MK(matakuliah.getKode_MK());
                if(MatakuliahManageController.updateMatakuliah(mk)){
                   JOptionPane.showMessageDialog(null, "Berhasil Mengupdate  ke Database");
                }else{
                   JOptionPane.showMessageDialog(null, "Gagal Mengupdate  ke Database");
                }
            }
        }else if(action.equals("Hapus")){
            if(MatakuliahManageController.deleteMatakuliah(matakuliah.getKode_MK())){
                    JOptionPane.showMessageDialog(null, "Berhasil Menghapus ke Database");
            }else{
                JOptionPane.showMessageDialog(null, "Gagal Menghapus ke Database");
            }
        }
        
        
    }
    
}
