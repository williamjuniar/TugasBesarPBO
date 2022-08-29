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
import model.user.Daak;
import model.user.Dosen;
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
public class JPanelHelperDosen extends JPanel implements ActionListener, ViewConfig {
 
    private  JLabel labelNid;
    private  JLabel labelNama;
    private  JLabel labelEmail;
    private  JLabel labelPassword;
    private  JLabel labelTanggal;
    private  JLabel labelJK;
    private  JLabel labelTelp;
    private  JLabel labelProgramStudi;
    private  JLabel labelBidangIlmu;
    private  JLabel labelGelarAkademik;
    private  JLabel labelStatusPegawai;
    private  JLabel labelIkatanKerja;
    private  JLabel labelStatusDosen;
    private  JLabel labelFoto;
    
    JTextField fieldNid;
    JTextField fieldNama;
    JTextField fieldEmail;
    JPasswordField fieldPassword;
    
     

    private UtilDateModel modelTglLahir;
    private JDatePanelImpl datePanelTglLahir;
    private Properties  propertiesTglLahir;   
    private JDatePickerImpl fieldTanggalLahir;
        
    private ButtonGroup groupJk;
    private JRadioButton fieldPria;
    private JRadioButton fieldWanita;
    private JTextField fieldTelp;
    private JTextField fieldProgramStudi;
    private JTextField fieldBidangIlmu;
    private JTextField fieldGelarAkademik;
    private String listIkatanKerja[] = {"","Dosen Tetap", "Dosen Tidak Tetap","Dosen Honorer"};
    private JComboBox fieldIkatanKerja;
    private String listStatusPegawai[] = {"","PNS", "Bukan-PNS"};
    private JComboBox fieldStatusPegawai;
    private ButtonGroup grupStatus;
    private JRadioButton fieldStatusDosenAktif;
    private JRadioButton fieldStatusDosenTidakAktif;

    JTextArea fieldFoto;
    JButton Save;
    JButton Delete;
    
    
    String idUser = null;
    Dosen dosen = null;
    public JPanelHelperDosen(String type,Dosen dosen){
        setLayout(null);
        this.dosen = dosen;
        this.idUser = idUser;        
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
        
        labelNid = new JLabel("Nid :");
        labelNid.setBounds(0,5, 120, 30);
        labelNid.setFont(FONT_DEFAULT_PLAIN );
        add(labelNid);
        
        
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
                
        labelProgramStudi = new JLabel("Program Studi :");
        labelProgramStudi.setBounds(0,285, 120, 30);
        labelProgramStudi.setFont(FONT_DEFAULT_PLAIN);
        add(labelProgramStudi);
        
        labelBidangIlmu = new JLabel("Bidang Ilmu :");
        labelBidangIlmu.setBounds(0,325, 120, 30);
        labelBidangIlmu.setFont(FONT_DEFAULT_PLAIN);
        add(labelBidangIlmu);
        
        labelGelarAkademik = new JLabel("Gelar Akademik :");
        labelGelarAkademik.setBounds(0,365, 120, 30);
        labelGelarAkademik.setFont(FONT_DEFAULT_PLAIN);
        add(labelGelarAkademik);
        
        labelStatusPegawai = new JLabel("Status Pegawai :");
        labelStatusPegawai.setBounds(0,405, 120, 30);
        labelStatusPegawai.setFont(FONT_DEFAULT_PLAIN);
        add(labelStatusPegawai);
        
        labelStatusDosen = new JLabel("Status Dosen :");
        labelStatusDosen.setBounds(0,445, 120, 30);
        labelStatusDosen.setFont(FONT_DEFAULT_PLAIN);
        add(labelStatusDosen);
        //
        labelIkatanKerja = new JLabel("Ikatan Kerja :");
        labelIkatanKerja.setBounds(340,5, 120, 30);
        labelIkatanKerja.setFont(FONT_DEFAULT_PLAIN);
        add(labelIkatanKerja);
        
        labelFoto = new JLabel("URL Foto Profile :");
        labelFoto.setBounds(340,45, 120, 30);
        labelFoto.setFont(FONT_DEFAULT_PLAIN);
        add(labelFoto);
    }
    
    private void generateInputForm(){
        
        generateLabel();
        
        fieldNid = new JTextField();
        fieldNid.setBounds(120,5, 200, 30);
        fieldNid.setFont(FONT_DEFAULT_PLAIN);
        add(fieldNid);
        
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
        
        fieldProgramStudi = new JTextField();
        fieldProgramStudi.setBounds(120,285, 200, 30);
        fieldProgramStudi.setFont(FONT_DEFAULT_PLAIN);
        add(fieldProgramStudi);
        
        fieldBidangIlmu = new JTextField();
        fieldBidangIlmu.setBounds(120,325, 200, 30);
        fieldBidangIlmu.setFont(FONT_DEFAULT_PLAIN);
        add(fieldBidangIlmu);
        
        fieldGelarAkademik = new JTextField();
        fieldGelarAkademik.setBounds(120,365, 200, 30);
        fieldGelarAkademik.setFont(FONT_DEFAULT_PLAIN);
        add(fieldGelarAkademik);
        
        fieldStatusPegawai = new JComboBox(listStatusPegawai);
        fieldStatusPegawai.setBounds(120,405, 200, 30);
        fieldStatusPegawai.setFont(FONT_DEFAULT_PLAIN);
        add(fieldStatusPegawai);
        
                
        fieldStatusDosenAktif = new JRadioButton("Aktif");
        fieldStatusDosenAktif.setBounds(120,445, 100, 30);
        fieldStatusDosenAktif.setFont(FONT_DEFAULT_PLAIN);
        add(fieldStatusDosenAktif);
        
        fieldStatusDosenTidakAktif = new JRadioButton("Tidak Aktif");
        fieldStatusDosenTidakAktif.setBounds(220,445, 100, 30);
        fieldStatusDosenTidakAktif.setFont(FONT_DEFAULT_PLAIN);
        add(fieldStatusDosenTidakAktif);
        
        grupStatus = new ButtonGroup();
        grupStatus.add(fieldStatusDosenAktif);
        grupStatus.add(fieldStatusDosenTidakAktif);
        
        fieldIkatanKerja = new JComboBox(listIkatanKerja);
        fieldIkatanKerja.setBounds(480,5, 150, 30);
        fieldIkatanKerja.setFont(FONT_DEFAULT_PLAIN);
        add(fieldIkatanKerja);
        
        fieldFoto = new JTextArea();
        fieldFoto.setLineWrap(true);
        fieldFoto.setBounds(340,85, 300, 100);
        fieldFoto.setFont(FONT_DEFAULT_PLAIN);
        add(fieldFoto);
    }
    
    private void generateEditForm(){
        
        generateInputForm();
              
        fieldNid.setText(dosen.getNID());
        fieldNama.setText(dosen.getNamaLengkap());
        fieldEmail.setText(dosen.getEmail());
        fieldPassword.setText("");
        modelTglLahir.setSelected(true);
        modelTglLahir.setValue(dosen.getTanggalLahir());
        if(dosen.getJenisKelamin().equals("Laki-Laki")){
           fieldPria.setSelected(true);
        }else{
           fieldWanita.setSelected(true); 
        }
        fieldTelp.setText(dosen.getNomorTelepon());
        fieldProgramStudi.setText(dosen.getProgramStudi());
        fieldBidangIlmu.setText(dosen.getBidangIlmu());
        fieldGelarAkademik.setText(dosen.getGelarAkademik());
        fieldStatusPegawai.setSelectedItem(dosen.getStatusPegawai());
        fieldIkatanKerja.setSelectedItem(dosen.getStatusIkatanKerja());
        if(dosen.isStatusDosen()){
            fieldStatusDosenAktif.setSelected(true);
             fieldStatusDosenTidakAktif.setSelected(false);
        }else{
           fieldStatusDosenAktif.setSelected(false);
             fieldStatusDosenTidakAktif.setSelected(true);
        }
        fieldFoto.setText(dosen.getPathFoto());
    }
    
    private void generateShowForm(){
        
        generateEditForm();
              
        fieldNid.setEditable(false);
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
        fieldProgramStudi.setEditable(false);
        fieldBidangIlmu.setEditable(false);
        fieldGelarAkademik.setEditable(false);
        fieldStatusPegawai.setEditable(false);
        Save.setVisible(false);
        fieldStatusPegawai.setEnabled(false);
        fieldIkatanKerja.setEnabled(false);
        fieldStatusDosenAktif.setEnabled(false);
        fieldStatusDosenTidakAktif.setEnabled(false);
        fieldFoto.setEditable(false);
        
    }
  
    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        System.out.println("Action Panel Helper Dosen : " + action);
        if(action.equals("Simpan")){
            String nid = fieldNid.getText();
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
            String programstudi =fieldProgramStudi.getText();
            String bidangIlmu = fieldBidangIlmu.getText();
            String gelarAkademik = fieldGelarAkademik.getText();
            String statusPegawai = (String) fieldStatusPegawai.getItemAt(fieldStatusPegawai.getSelectedIndex()) ;
            String statusIkatanKerja = (String) fieldIkatanKerja.getItemAt(fieldIkatanKerja.getSelectedIndex()) ;
            boolean statusDosen = false;
            if(fieldStatusDosenAktif.isSelected()){
                statusDosen = true;
            }
            String urlFoto = fieldFoto.getText();
            
            Dosen newDosen = new Dosen();
            
            newDosen.setNID(nid);
            newDosen.setNamaLengkap(nama); 
            newDosen.setEmail(email);
            newDosen.setPassword(password);
            newDosen.setTanggalLahir(tanggalLahir);
            newDosen.setJenisKelamin(jk);
            newDosen.setNomorTelepon(telepon);
            newDosen.setBidangIlmu(bidangIlmu); 
            newDosen.setGelarAkademik(gelarAkademik);
            newDosen.setProgramStudi(programstudi);
            newDosen.setStatusIkatanKerja(statusIkatanKerja);
            newDosen.setStatusPegawai(statusPegawai);
            newDosen.setStatusDosen(statusDosen);
            newDosen.setPathFoto(urlFoto);
            newDosen.setJenisUser(2);
           
            if(dosen == null){
                newDosen.setIdUser();
                if(UserManageController.insertNewUser(newDosen)){
                    JOptionPane.showMessageDialog(null, "Berhasil Menyimpan ke Database");
                }else{
                    JOptionPane.showMessageDialog(null, "Gagal Menyimpan ke Database");
                }
            }else{
                newDosen.setIdUser(dosen.getIdUser());
                if(UserManageController.updateDosen(newDosen)){
                    JOptionPane.showMessageDialog(null, "Berhasil Mengupdate ke Database");
                }else{
                    JOptionPane.showMessageDialog(null, "Gagal Mengupdate ke Database");
                }
            }
            
          
        }else if(action.equals("Hapus")){
            if(UserManageController.deleteDosen(dosen.getIdUser())){
                    JOptionPane.showMessageDialog(null, "Berhasil Menghapus ke Database");
            }else{
                JOptionPane.showMessageDialog(null, "Gagal Menghapus ke Database");
            }
        }
        
    }
        
}
