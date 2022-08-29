/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.menuDaak.Helper;

import controller.DatabaseController.ContollerDaak.UserManageController;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Properties;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.matakuliah.DetailMatakuliah;

import model.user.Daak;
import model.user.Mahasiswa;
import model.user.User;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import view.ViewConfig;
import static view.ViewConfig.BGCOLOR_DEFAULT;
import static view.ViewConfig.COLOR_WHITE;
import static view.ViewConfig.FONT_DEFAULT_PLAIN;

/**
 *
 * @author 1119002 Albertus Angkuw
 */
public class JPanelHelperDaak extends JPanel implements ActionListener, ViewConfig {
 
    private  JLabel labelNik;
    private  JLabel labelNama;
    private  JLabel labelEmail;
    private  JLabel labelPassword;
    private  JLabel labelTanggal;
    private  JLabel labelJK;
    private  JLabel labelTelp;
    private  JLabel labelJabatan;
    private  JLabel labelHakAksesRencanaStudi;
    private  JLabel labelHakAksesMatakuliah;
    private  JLabel labelHakAksesKeuangan;
    private  JLabel labelHakAksesJadwalPerkuliahan;
    private  JLabel labelHakAksesUser;
    private  JLabel labelStatusKontrak;
    private  JLabel labelFoto;
    
    private JTextField fieldNik;
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
    private JTextField fieldJabatan;
    
    private ButtonGroup groupHARencanaStudi;
    private JRadioButton fieldHARencanaStudiYes;
    private JRadioButton fieldHARencanaStudiNo;
    
    private ButtonGroup groupHAMatakuliah;
    private JRadioButton fieldHAMatakuliahYes;
    private JRadioButton fieldHAMatakuliahNo;
    
    private ButtonGroup groupHAKeuangan;
    private JRadioButton fieldHAKeuanganYes;
    private JRadioButton fieldHAKeuanganNo;
    
    private ButtonGroup groupHAJadwalPerkuliahan;
    private JRadioButton fieldHAJadwalPerkuliahanYes;
    private JRadioButton fieldHAJadwalPerkuliahanNo;
    
    private ButtonGroup groupHAUser;
    private JRadioButton fieldHAUserYes;
    private JRadioButton fieldHAUserNo;
    
    private ButtonGroup groupStatusKontrak;
    private JRadioButton fieldStatusKontrakAktif;
    private JRadioButton fieldStatusKontrakNonAktif;

     
    JTextArea fieldFoto;
    JButton Save;
    JButton Delete;
    
    Daak daak = null;
    public JPanelHelperDaak(String type,Daak daak){
        setLayout(null);
        this.daak = daak;
        
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
        
        labelNik = new JLabel("Nik :");
        labelNik.setBounds(0,5, 120, 30);
        labelNik.setFont(FONT_DEFAULT_PLAIN );
        add(labelNik);
        
        
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
                
        labelJabatan = new JLabel("Jabatan :");
        labelJabatan.setBounds(0,285, 120, 30);
        labelJabatan.setFont(FONT_DEFAULT_PLAIN);
        add(labelJabatan);
        
        labelHakAksesRencanaStudi = new JLabel("A. Rencana Studi :");
        labelHakAksesRencanaStudi.setBounds(0,325, 120, 30);
        labelHakAksesRencanaStudi.setFont(FONT_DEFAULT_PLAIN);
        add(labelHakAksesRencanaStudi);
        
        labelHakAksesMatakuliah = new JLabel("A. Matakuliah :");
        labelHakAksesMatakuliah.setBounds(0,365, 120, 30);
        labelHakAksesMatakuliah.setFont(FONT_DEFAULT_PLAIN);
        add(labelHakAksesMatakuliah);
        
        labelHakAksesKeuangan = new JLabel("A. Keuangan :");
        labelHakAksesKeuangan.setBounds(0,405, 120, 30);
        labelHakAksesKeuangan.setFont(FONT_DEFAULT_PLAIN);
        add(labelHakAksesKeuangan);
        
        labelHakAksesUser = new JLabel("A. User :");
        labelHakAksesUser.setBounds(0,445, 120, 30);
        labelHakAksesUser.setFont(FONT_DEFAULT_PLAIN);
        add(labelHakAksesUser);
        
        labelHakAksesJadwalPerkuliahan = new JLabel("A. Jadwal Kuliah :");
        labelHakAksesJadwalPerkuliahan.setBounds(340,5, 120, 30);
        labelHakAksesJadwalPerkuliahan.setFont(FONT_DEFAULT_PLAIN);
        add(labelHakAksesJadwalPerkuliahan);
        
        
        labelStatusKontrak = new JLabel("Status Kontrak :");
        labelStatusKontrak.setBounds(340,45, 120, 30);
        labelStatusKontrak.setFont(FONT_DEFAULT_PLAIN);
        add(labelStatusKontrak);
        
        labelFoto = new JLabel("URL Foto Profile :");
        labelFoto.setBounds(340,85, 120, 30);
        labelFoto.setFont(FONT_DEFAULT_PLAIN);
        add(labelFoto);
    }
    
    private void generateInputForm(){
        
        generateLabel();
        
        fieldNik = new JTextField();
        fieldNik.setBounds(120,5, 200, 30);
        fieldNik.setFont(FONT_DEFAULT_PLAIN);
        add(fieldNik);
        
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
        
        fieldJabatan = new JTextField();
        fieldJabatan.setBounds(120,285, 200, 30);
        fieldJabatan.setFont(FONT_DEFAULT_PLAIN);
        add(fieldJabatan);
        
        // --
        fieldHARencanaStudiYes = new JRadioButton("Boleh");
        fieldHARencanaStudiYes.setBounds(120,325, 100, 30);
        fieldHARencanaStudiYes.setFont(FONT_DEFAULT_PLAIN);
        add(fieldHARencanaStudiYes);
        
        fieldHARencanaStudiNo = new JRadioButton("Tidak Boleh");
        fieldHARencanaStudiNo.setBounds(220,325, 100, 30);
        fieldHARencanaStudiNo.setFont(FONT_DEFAULT_PLAIN);
        add(fieldHARencanaStudiNo);
        
        groupHARencanaStudi = new ButtonGroup();
        groupHARencanaStudi.add(fieldHARencanaStudiYes);
        groupHARencanaStudi.add(fieldHARencanaStudiNo);
        
        fieldHAMatakuliahYes = new JRadioButton("Boleh");
        fieldHAMatakuliahYes.setBounds(120,365, 100, 30);
        fieldHAMatakuliahYes.setFont(FONT_DEFAULT_PLAIN);
        add(fieldHAMatakuliahYes);
        
        fieldHAMatakuliahNo = new JRadioButton("Tidak Boleh");
        fieldHAMatakuliahNo.setBounds(220,365, 100, 30);
        fieldHAMatakuliahNo.setFont(FONT_DEFAULT_PLAIN);
        add(fieldHAMatakuliahNo);
        
        groupHAMatakuliah = new ButtonGroup();
        groupHAMatakuliah.add(fieldHAMatakuliahYes);
        groupHAMatakuliah.add(fieldHAMatakuliahNo);
        
        fieldHAKeuanganYes = new JRadioButton("Boleh");
        fieldHAKeuanganYes.setBounds(120,405, 100, 30);
        fieldHAKeuanganYes.setFont(FONT_DEFAULT_PLAIN);
        add(fieldHAKeuanganYes);
        
        fieldHAKeuanganNo = new JRadioButton("Tidak Boleh");
        fieldHAKeuanganNo.setBounds(220,405, 100, 30);
        fieldHAKeuanganNo.setFont(FONT_DEFAULT_PLAIN);
        add(fieldHAKeuanganNo);
        
        groupHAKeuangan = new ButtonGroup();
        groupHAKeuangan.add(fieldHAKeuanganYes);
        groupHAKeuangan.add(fieldHAKeuanganNo);
        
        
        fieldHAUserYes = new JRadioButton("Boleh");
        fieldHAUserYes.setBounds(120,445, 100, 30);
        fieldHAUserYes.setFont(FONT_DEFAULT_PLAIN);
        add(fieldHAUserYes);
        
        fieldHAUserNo = new JRadioButton("Tidak Boleh");
        fieldHAUserNo.setBounds(220,445, 100, 30);
        fieldHAUserNo.setFont(FONT_DEFAULT_PLAIN);
        add(fieldHAUserNo);
        
        groupHAUser = new ButtonGroup();
        groupHAUser.add(fieldHAUserYes);
        groupHAUser.add(fieldHAUserNo);
 
        
        fieldHAJadwalPerkuliahanYes = new JRadioButton("Boleh");
        fieldHAJadwalPerkuliahanYes.setBounds(455,5, 75, 30);
        fieldHAJadwalPerkuliahanYes.setFont(FONT_DEFAULT_PLAIN);
        add(fieldHAJadwalPerkuliahanYes);
        
        fieldHAJadwalPerkuliahanNo = new JRadioButton("Tidak Boleh");
        fieldHAJadwalPerkuliahanNo.setBounds(535,5, 100, 30);
        fieldHAJadwalPerkuliahanNo.setFont(FONT_DEFAULT_PLAIN);
        add(fieldHAJadwalPerkuliahanNo);
        
        groupHAJadwalPerkuliahan = new ButtonGroup();
        groupHAJadwalPerkuliahan.add(fieldHAJadwalPerkuliahanYes);
        groupHAJadwalPerkuliahan.add(fieldHAJadwalPerkuliahanNo);
        
        fieldStatusKontrakAktif = new JRadioButton("Aktif");
        fieldStatusKontrakAktif.setBounds(455,45, 75, 30);
        fieldStatusKontrakAktif.setFont(FONT_DEFAULT_PLAIN);
        add(fieldStatusKontrakAktif);
        
        fieldStatusKontrakNonAktif = new JRadioButton("Tidak Aktif");
        fieldStatusKontrakNonAktif.setBounds(535,45, 100, 30);
        fieldStatusKontrakNonAktif.setFont(FONT_DEFAULT_PLAIN);
        add(fieldStatusKontrakNonAktif);
        
        groupStatusKontrak = new ButtonGroup();
        groupStatusKontrak.add(fieldStatusKontrakAktif);
        groupStatusKontrak.add(fieldStatusKontrakNonAktif);
        
        fieldFoto = new JTextArea();
        fieldFoto.setLineWrap(true);
        fieldFoto.setBounds(340,125, 300, 100);
        fieldFoto.setFont(FONT_DEFAULT_PLAIN);
        add(fieldFoto);
    }
    
    private void generateEditForm(){
        
        generateInputForm();
              
        fieldNik.setText(daak.getNIK());
        fieldNama.setText(daak.getNamaLengkap());
        fieldEmail.setText(daak.getEmail());
        fieldPassword.setText("");
        modelTglLahir.setSelected(true);
        modelTglLahir.setValue(daak.getTanggalLahir());
        if(daak.getJenisKelamin().equals("Laki-Laki")){
           fieldPria.setSelected(true);
        }else{
           fieldWanita.setSelected(true); 
        }
        fieldTelp.setText(daak.getNomorTelepon());
        fieldJabatan.setText(daak.getJabatan());
                
        if(daak.isHakAksesRencanaStudi()){
           fieldHARencanaStudiYes.setSelected(true);
        }else{
           fieldHARencanaStudiNo.setSelected(true); 
        }
        
        if(daak.isHakAksesMatakuliah()){
           fieldHAMatakuliahYes.setSelected(true);
        }else{
           fieldHAMatakuliahNo.setSelected(true); 
        }
        
        if(daak.isHakAksesKeuangan()){
           fieldHAKeuanganYes.setSelected(true);
        }else{
           fieldHAKeuanganNo.setSelected(true); 
        }
        
        if(daak.isHakAksesUser()){
           fieldHAUserYes.setSelected(true);
        }else{
           fieldHAUserNo.setSelected(true); 
        }
        
        if(daak.isHakAksesJadwalPerkuliahan()){
           fieldHAJadwalPerkuliahanYes.setSelected(true);
        }else{
           fieldHAJadwalPerkuliahanNo.setSelected(true); 
        }
        
        if(daak.isStatusKontrak()){
           fieldStatusKontrakAktif.setSelected(true);
        }else{
           fieldStatusKontrakNonAktif.setSelected(true); 
        }
        fieldFoto.setText(daak.getPathFoto());
    }
    
    private void generateShowForm(){
        
        generateEditForm();
              
        fieldNik.setEditable(false);
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
        fieldJabatan.setEditable(false);

        fieldHARencanaStudiYes.setEnabled(false);
        fieldHARencanaStudiNo.setEnabled(false);
        fieldHAMatakuliahYes.setEnabled(false);
        fieldHAMatakuliahNo.setEnabled(false);
        fieldHAKeuanganYes.setEnabled(false);
        fieldHAKeuanganNo.setEnabled(false);
        fieldHAUserYes.setEnabled(false);
        fieldHAUserNo.setEnabled(false);
        fieldHAJadwalPerkuliahanYes.setEnabled(false);
        fieldHAJadwalPerkuliahanNo.setEnabled(false);
        fieldStatusKontrakAktif.setEnabled(false);
        fieldStatusKontrakNonAktif.setEnabled(false);
        fieldFoto.setEditable(false);
    }
  
    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        System.out.println("Action Panel Helper Dosen : " + action);
        if(action.equals("Simpan")){
            String nik = fieldNik.getText();
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
            String jabatan =fieldJabatan.getText();
            
            boolean HARencanaStudi = false;
            if(fieldHARencanaStudiYes.isSelected()){
                HARencanaStudi = true;
            }
            
            boolean HAMatakuliah = false;
            if(fieldHAMatakuliahYes.isSelected()){
                HAMatakuliah = true;
            }
            
            boolean HAKeuangan = false;
            if(fieldHAKeuanganYes.isSelected()){
                HAKeuangan = true;
            }
            
            boolean HAUser = false;
            if(fieldHAUserYes.isSelected()){
                HAUser = true;
            }
            
            boolean HAJadwalPerkuliahan = false;
            if(fieldHAJadwalPerkuliahanYes.isSelected()){
                HAJadwalPerkuliahan = true;
            }
            

            boolean statusKontrak = false;
            if(fieldStatusKontrakAktif.isSelected()){
                statusKontrak = true;
            }
            String urlFoto = fieldFoto.getText();
            
            Daak newDaak = new Daak();
            
            
            newDaak.setNIK(nik);
            newDaak.setNamaLengkap(nama); 
            newDaak.setEmail(email);
            newDaak.setPassword(password);
            newDaak.setTanggalLahir(tanggalLahir);
            newDaak.setJenisKelamin(jk);
            newDaak.setNomorTelepon(telepon);
            newDaak.setJabatan(jabatan);
            newDaak.setHakAksesJadwalPerkuliahan(HAJadwalPerkuliahan); 
            newDaak.setHakAksesKeuangan(HAKeuangan);
            newDaak.setHakAksesMatakuliah(HAMatakuliah);
            newDaak.setHakAksesRencanaStudi(HARencanaStudi);
            newDaak.setHakAksesUser(HAUser);
            newDaak.setStatusKontrak(statusKontrak);
            newDaak.setPathFoto(urlFoto);
            newDaak.setJenisUser(1);
            if(daak == null){
                newDaak.setIdUser();
                if(UserManageController.insertNewUser((User) newDaak)){
                    JOptionPane.showMessageDialog(null, "Berhasil Menyimpan ke Database");
                }else{
                    JOptionPane.showMessageDialog(null, "Gagal Menyimpan ke Database");
                }
            }else{
                newDaak.setIdUser(daak.getIdUser());
                if(UserManageController.updateDaak(newDaak)){
                    JOptionPane.showMessageDialog(null, "Berhasil Mengupdate ke Database");
                }else{
                    JOptionPane.showMessageDialog(null, "Gagal Mengupdate ke Database");
                }
            }
        }else if(action.equals("Hapus")){
            if(UserManageController.deleteDaak(daak.getIdUser())){
                    JOptionPane.showMessageDialog(null, "Berhasil Menghapus ke Database");
            }else{
                JOptionPane.showMessageDialog(null, "Gagal Menghapus ke Database");
            }
        }
        
    }
        
}
