/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.menuDaak.Helper;

import controller.DatabaseController.ContollerDaak.UserManageController;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Properties;
import javax.swing.*;
import model.user.Dosen;
import model.user.Mahasiswa;
import org.jdatepicker.JDatePicker;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import view.ViewConfig;

/**
 *
 * @author 1119002 Albertus Angkuw
 */
public class JPanelHelperMahasiswa extends JPanel implements ActionListener, ViewConfig {
    private  JLabel labelNim;
    private  JLabel labelNama;
    private  JLabel labelEmail;
    private  JLabel labelPassword;
    private  JLabel labelTanggal;
    private  JLabel labelJK;
    private  JLabel labelTelp;
    private  JLabel labelJurusan;
    private  JLabel labelTahunMasuk;
    private  JLabel labelTahunLulus;
    private  JLabel labelIpk;
    private  JLabel labelPredikat;
    private  JLabel labelFoto;
    

    private JTextField fieldNim;
    private JTextField fieldNama;
    private JTextField fieldEmail;
    private JPasswordField fieldPassword;
    
     
    private UtilDateModel modelTglLahir;
    private JDatePanelImpl datePanelTglLahir;
    private Properties  propertiesTglLahir;   
    private JDatePickerImpl fieldTanggalLahir;
        
    private ButtonGroup groupJk;
    private JRadioButton fieldPria;
    private JRadioButton fieldWanita;
    private JTextField fieldTelp;
    private JTextField fieldJurusan;
    private JTextField fieldTahunMasuk;
    private JTextField fieldTahunLulus;
    private JTextField fieldIpk;
    private JTextField fieldPredikat;
    
    JTextArea fieldFoto;
    private JButton Save;
    private JButton Delete;
    
    private Mahasiswa mhs = null;

    
    public JPanelHelperMahasiswa(String type,Mahasiswa mhs){
        setLayout(null);
        this.mhs = mhs;
        
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
        //setBackground(Color.PINK);
    }
    
    private void generateLabel(){
        
        labelNim = new JLabel("Nim :");
        labelNim.setBounds(0,5, 120, 30);
        labelNim.setFont(FONT_DEFAULT_PLAIN );
        add(labelNim);
        
        
        labelNama = new JLabel("Nama :");
        labelNama.setBounds(0,45, 120, 30);
        labelNama.setFont(FONT_DEFAULT_PLAIN );
        add(labelNama);
        
        labelEmail = new JLabel("Email :");
        labelEmail.setBounds(0,85, 120, 30);
        labelEmail.setFont(FONT_DEFAULT_PLAIN);
        add(labelEmail);
        
        labelPassword = new JLabel("Password :");
        labelPassword.setBounds(0,125, 120, 30);
        labelPassword.setFont(FONT_DEFAULT_PLAIN);
        add(labelPassword);
        
        labelTanggal = new JLabel("Tanggal Lahir :");
        labelTanggal.setBounds(0,165, 120, 30);
        labelTanggal.setFont(FONT_DEFAULT_PLAIN);
        add(labelTanggal);
        
        labelJK = new JLabel("Jenis Kelamin :");
        labelJK.setBounds(0,205, 120, 30);
        labelJK.setFont(FONT_DEFAULT_PLAIN);
        add(labelJK);
        
        labelTelp = new JLabel("Nomor Telepon :");
        labelTelp.setBounds(0,245, 120, 30);
        labelTelp.setFont(FONT_DEFAULT_PLAIN);
        add(labelTelp);
                
        labelJurusan = new JLabel("Jurusan :");
        labelJurusan.setBounds(0,285, 120, 30);
        labelJurusan.setFont(FONT_DEFAULT_PLAIN);
        add(labelJurusan);
        
        labelTahunMasuk = new JLabel("Tahun Masuk :");
        labelTahunMasuk.setBounds(0,325, 120, 30);
        labelTahunMasuk.setFont(FONT_DEFAULT_PLAIN);
        add(labelTahunMasuk);
        
        labelTahunLulus = new JLabel("Tahun Lulus :");
        labelTahunLulus.setBounds(0,365, 120, 30);
        labelTahunLulus.setFont(FONT_DEFAULT_PLAIN);
        add(labelTahunLulus);
        
        labelIpk = new JLabel("IPK :");
        labelIpk.setBounds(0,405, 120, 30);
        labelIpk.setFont(FONT_DEFAULT_PLAIN);
        add(labelIpk);

        labelPredikat = new JLabel("Predikat :");
        labelPredikat.setBounds(0,445, 120, 30);
        labelPredikat.setFont(FONT_DEFAULT_PLAIN);
        add(labelPredikat);
        
        labelFoto = new JLabel("URL Foto Profile :");
        labelFoto.setBounds(340,5, 120, 30);
        labelFoto.setFont(FONT_DEFAULT_PLAIN);
        add(labelFoto);
        
    }
    
    private void generateInputForm(){
        
        generateLabel();
        
        fieldNim = new JTextField();
        fieldNim.setBounds(120,5, 200, 30);
        fieldNim.setFont(FONT_DEFAULT_PLAIN);
        add(fieldNim);
        
        fieldNama = new JTextField();
        fieldNama.setBounds(120,45, 200, 30);
        fieldNama.setFont(FONT_DEFAULT_PLAIN);
        add(fieldNama);
        
        fieldEmail = new JTextField();
        fieldEmail.setBounds(120,85, 200, 30);
        fieldEmail.setFont(FONT_DEFAULT_PLAIN);
        add(fieldEmail);
        
        fieldPassword = new JPasswordField();
        fieldPassword.setBounds(120,125, 200, 30);
        fieldPassword.setFont(FONT_DEFAULT_PLAIN);
        add(fieldPassword);
        
        propertiesTglLahir = new Properties();
        propertiesTglLahir.put("text.today", "Today");
        propertiesTglLahir.put("text.month", "Month");
        propertiesTglLahir.put("text.year", "Year");
        modelTglLahir = new UtilDateModel();
        datePanelTglLahir = new JDatePanelImpl(modelTglLahir, propertiesTglLahir);
        fieldTanggalLahir = new JDatePickerImpl(datePanelTglLahir, new DateLabelFormatter());
        fieldTanggalLahir.setBounds(120,165, 200, 30);
        add(fieldTanggalLahir);
                
        fieldPria = new JRadioButton("Pria");
        fieldPria.setBounds(120,205, 100, 30);
        fieldPria.setFont(FONT_DEFAULT_PLAIN);
        add(fieldPria);
        
        fieldWanita = new JRadioButton("Wanita");
        fieldWanita.setBounds(220,205, 100, 30);
        fieldWanita.setFont(FONT_DEFAULT_PLAIN);
        add(fieldWanita);
        
        groupJk = new ButtonGroup();
        groupJk.add(fieldPria);
        groupJk.add(fieldWanita);
        
        fieldTelp = new JTextField();
        fieldTelp.setBounds(120,245, 200, 30);
        fieldTelp.setFont(FONT_DEFAULT_PLAIN);
        add(fieldTelp);
        
        fieldJurusan = new JTextField();
        fieldJurusan.setBounds(120,285, 200, 30);
        fieldJurusan.setFont(FONT_DEFAULT_PLAIN);
        add(fieldJurusan);
        
        fieldTahunMasuk = new JTextField();
        fieldTahunMasuk.setBounds(120,325, 50, 30);
        fieldTahunMasuk.setFont(FONT_DEFAULT_PLAIN);
        add(fieldTahunMasuk);
        
        fieldTahunLulus = new JTextField();
        fieldTahunLulus.setBounds(120,365, 50, 30);
        fieldTahunLulus.setFont(FONT_DEFAULT_PLAIN);
        add(fieldTahunLulus);
        
        fieldIpk = new JTextField();
        fieldIpk.setBounds(120,405, 50, 30);
        fieldIpk.setFont(FONT_DEFAULT_PLAIN);
        add(fieldIpk);
        
        fieldPredikat = new JTextField();
        fieldPredikat.setBounds(120,445, 200, 30);
        fieldPredikat.setFont(FONT_DEFAULT_PLAIN);
        add(fieldPredikat);
        
        fieldFoto = new JTextArea();
        fieldFoto.setLineWrap(true);
        fieldFoto.setBounds(340,45, 300, 100);
        fieldFoto.setFont(FONT_DEFAULT_PLAIN);
        add(fieldFoto);
        
    }
    
    private void generateEditForm(){
        
        generateInputForm();
              
        fieldNim.setText(mhs.getNIM());
        fieldNama.setText(mhs.getNamaLengkap());
        fieldEmail.setText(mhs.getEmail());
        fieldPassword.setText("");
        modelTglLahir.setSelected(true);
        modelTglLahir.setValue(mhs.getTanggalLahir());
        if(mhs.getJenisKelamin().equals("Laki-Laki")){
           fieldPria.setSelected(true);
        }else{
           fieldWanita.setSelected(true); 
        }
        fieldTelp.setText(mhs.getNomorTelepon());
        fieldJurusan.setText(mhs.getJurusan());
        fieldTahunMasuk.setText(String.valueOf(mhs.getTahunMasuk()));
        fieldTahunLulus.setText(String.valueOf(mhs.getTahunLulus()));
        fieldIpk.setText(String.valueOf(mhs.getIpk()));
        fieldPredikat.setText(mhs.getPredikat());
        fieldFoto.setText(mhs.getPathFoto());
        
        
        
    }
    
    private void generateShowForm(){
        
        generateEditForm();
              
        fieldNim.setEditable(false);
        fieldNama.setEditable(false);
        fieldEmail.setEditable(false);
        fieldPassword.setEditable(false);
        modelTglLahir.setSelected(true);
        modelTglLahir.setDate(2001, 9, 17);
        fieldTanggalLahir.setEnabled(false);
        fieldTanggalLahir.getComponent(1).setEnabled(false);
        fieldPria.setEnabled(false);
        fieldWanita.setEnabled(false); 
        fieldTelp.setEditable(false);
        fieldJurusan.setEditable(false);
        fieldTahunMasuk.setEditable(false);
        fieldTahunLulus.setEditable(false);
        fieldIpk.setEditable(false);
        fieldPredikat.setEditable(false);
        fieldFoto.setEditable(false);
        Save.setVisible(false);
        
    }
  
    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        System.out.println("Action Panel Helper Mahasiswa : " + action);
        if(action.equals("Simpan")){
            String nim = fieldNim.getText();
            String nama = fieldNama.getText();
            String email = fieldEmail.getText();
            String password = new String(fieldPassword.getPassword());
            Date tanggalLahir = (Date) fieldTanggalLahir.getModel().getValue();
            String jk = "";
            if(fieldPria.isSelected()){
                jk = "Laki-Laki";
            }else if(fieldWanita.isSelected()){
                jk = "Perempuan";
            }
            String telepon =  fieldTelp.getText();
            String jurusan =fieldJurusan.getText();
            String tahunMasuk = fieldTahunMasuk.getText();
            String tahunLulus = fieldTahunLulus.getText();
            String ipk = fieldIpk.getText();
            String predikat = fieldPredikat.getText();
            String urlFoto = fieldFoto.getText();
            
            Mahasiswa newMhs = new Mahasiswa();
            newMhs.setNIM(nim);
            newMhs.setNamaLengkap(nama); 
            newMhs.setEmail(email);
            newMhs.setPassword(password);
            newMhs.setTanggalLahir(tanggalLahir);
            newMhs.setJenisKelamin(jk);
            newMhs.setNomorTelepon(telepon);
            newMhs.setJurusan(jurusan);
            newMhs.setTahunMasuk(Integer.valueOf(tahunMasuk));
            newMhs.setTahunLulus(Integer.valueOf(tahunLulus));
            newMhs.setIpk(Float.valueOf(ipk));
            newMhs.setPredikat(predikat);
            newMhs.setPathFoto(urlFoto);
            newMhs.setJenisUser(3);
            
            if(mhs == null){
                newMhs.setIdUser();
                if(UserManageController.insertNewUser(newMhs)){
                    JOptionPane.showMessageDialog(null, "Berhasil Menyimpan ke Database");
                }else{
                    JOptionPane.showMessageDialog(null, "Gagal Menyimpan ke Database");
                }
            }else{
                newMhs.setIdUser(mhs.getIdUser());
                if(UserManageController.updateMahasiswa(newMhs)){
                    JOptionPane.showMessageDialog(null, "Berhasil Mengupdate ke Database");
                }else{
                    JOptionPane.showMessageDialog(null, "Gagal Mengupdate ke Database");
                }
            }
           
            //To Sql Controller !
        }else if(action.equals("Hapus")){
            if(UserManageController.deleteMahasiswa(mhs.getIdUser())){
                    JOptionPane.showMessageDialog(null, "Berhasil Menghapus ke Database");
            }else{
                JOptionPane.showMessageDialog(null, "Gagal Menghapus ke Database");
            }
        }
        
    }
    
   
   
}
