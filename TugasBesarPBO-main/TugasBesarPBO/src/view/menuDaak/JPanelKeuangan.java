/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.menuDaak;


import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import view.ViewConfig;
import static view.ViewConfig.BGCOLOR_DEFAULT;
import static view.ViewConfig.COLOR_WHITE;
import static view.ViewConfig.FONT_DEFAULT_PLAIN;
import view.menuDaak.Helper.JPanelHelperJadwal;
/**
 *
 * @author 1119002 Albertus Angkuw
 */
public class JPanelKeuangan  extends JPanel implements ActionListener,ViewConfig {
    private JLabel title;
    private JButton createJadwal;
    private JButton editJadwal;
    private JButton deleteJadwal;
    private JTextField yearJadwal;
    
    private JButton btnSearchEdit;
    private JButton btnSearchDelete;
    private JButton btnTypeMatakuliah;
    
    private JTextField kodeMKJadwal;
    
    private String listSemester[] = {"-Semester-","Ganjil", "Genap","Pendek"};
    private JComboBox optionSemester;
    
    private JPanelHelperJadwal jadwalCreate;
    private JPanelHelperJadwal jadwalEdit;
    private JPanelHelperJadwal jadwalDelete;
    
    
    private JLabel errorMsg ;
    private JButton Cancel;
    
    private String menuNow = null;
    
    
    public JPanelKeuangan(){
         setLayout(null);
        title = new JLabel("Keuangan  Management");
        title.setBounds(20, 0, 400, 60);
        title.setFont(new java.awt.Font("Segoe UI", 1, 20));
        add(title);
        
        createJadwal = new JButton("Tambah Jadwal");
        createJadwal.setBounds(20, 60, 170 ,30);
        createJadwal.setContentAreaFilled(true);
        createJadwal.setBackground(COLOR_WHITE);
        createJadwal.setForeground(BGCOLOR_DEFAULT);
        createJadwal.setBorder(javax.swing.BorderFactory.createLineBorder(BGCOLOR_DEFAULT));
        createJadwal.setFocusPainted(false);
        createJadwal.setFont(FONT_DEFAULT_PLAIN );
        createJadwal.addActionListener(this);
        add(createJadwal);
        
        editJadwal = new JButton("Edit Jadwal");
        editJadwal.setBounds(200, 60, 170 ,30);
        editJadwal.setContentAreaFilled(true);
        editJadwal.setBackground(COLOR_WHITE);
        editJadwal.setForeground(BGCOLOR_DEFAULT);
        editJadwal.setBorder(javax.swing.BorderFactory.createLineBorder(BGCOLOR_DEFAULT));
        editJadwal.setFocusPainted(false);
        editJadwal.setFont(FONT_DEFAULT_PLAIN );
        editJadwal.addActionListener(this);
        add(editJadwal);
        
        deleteJadwal = new JButton("Hapus Jadwal");
        deleteJadwal.setBounds(380, 60, 170 ,30);
        deleteJadwal.setContentAreaFilled(true);
        deleteJadwal.setBackground(COLOR_WHITE);
        deleteJadwal.setForeground(BGCOLOR_DEFAULT);
        deleteJadwal.setBorder(javax.swing.BorderFactory.createLineBorder(BGCOLOR_DEFAULT));
        deleteJadwal.setFocusPainted(false);
        deleteJadwal.setFont(FONT_DEFAULT_PLAIN );
        deleteJadwal.addActionListener(this);
        add(deleteJadwal);
        
        
        kodeMKJadwal = new JTextField(" Kode MK");
        kodeMKJadwal.setBounds(20, 100, 170 ,30);
        kodeMKJadwal.setFont(FONT_DEFAULT_PLAIN);
        kodeMKJadwal.setForeground(Color.GRAY);
        kodeMKJadwal.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (kodeMKJadwal.getText().equals(" Kode MK")) {
                    kodeMKJadwal.setText("");
                    kodeMKJadwal.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (kodeMKJadwal.getText().isEmpty()) {
                    kodeMKJadwal.setForeground(Color.GRAY);
                    kodeMKJadwal.setText(" Kode MK");
                }
            }
        });
        kodeMKJadwal.setVisible(false);
        add(kodeMKJadwal);
        
        optionSemester = new JComboBox(listSemester);
        optionSemester.setBounds(200, 100, 120 ,30);
        optionSemester.setFont(FONT_DEFAULT_PLAIN );
        optionSemester.setVisible(false);
        add(optionSemester);
        
        yearJadwal = new JTextField(" Tahun");
        yearJadwal.setBounds(330, 100, 70 ,30);
        yearJadwal.setFont(FONT_DEFAULT_PLAIN );
        yearJadwal.setForeground(Color.GRAY);
        yearJadwal.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (yearJadwal.getText().equals(" Tahun")) {
                    yearJadwal.setText("");
                    yearJadwal.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (yearJadwal.getText().isEmpty()) {
                    yearJadwal.setForeground(Color.GRAY);
                    yearJadwal.setText(" Tahun");
                }
            }
        });
        yearJadwal.setVisible(false);
        add(yearJadwal);
       
       
        
        btnSearchEdit = new JButton("Cari");
        btnSearchEdit.setBounds(420, 100, 100 ,30);
        btnSearchEdit.setContentAreaFilled(true);
        btnSearchEdit.setBackground(BGCOLOR_DEFAULT);
        btnSearchEdit.setForeground(COLOR_WHITE);
        btnSearchEdit.setBorder(javax.swing.BorderFactory.createLineBorder(BGCOLOR_DEFAULT));
        btnSearchEdit.setFocusPainted(false);
        btnSearchEdit.setFont(FONT_DEFAULT_PLAIN );
        btnSearchEdit.setVisible(false);
        btnSearchEdit.addActionListener(this);
        add(btnSearchEdit);
        
        btnTypeMatakuliah = new JButton("Process");
        btnTypeMatakuliah.setBounds(420, 100, 100 ,30);
        btnTypeMatakuliah.setContentAreaFilled(true);
        btnTypeMatakuliah.setBackground(BGCOLOR_DEFAULT);
        btnTypeMatakuliah.setForeground(COLOR_WHITE);
        btnTypeMatakuliah.setBorder(javax.swing.BorderFactory.createLineBorder(BGCOLOR_DEFAULT));
        btnTypeMatakuliah.setFocusPainted(false);
        btnTypeMatakuliah.setFont(FONT_DEFAULT_PLAIN );
        btnTypeMatakuliah.setVisible(false);
        btnTypeMatakuliah.addActionListener(this);
        add(btnTypeMatakuliah);
      
        errorMsg = new JLabel();
        errorMsg.setBounds(20, 140, 450, 30);
        errorMsg.setFont(new java.awt.Font("Segoe UI", 0, 16));
        add(errorMsg);
        //Benarkan Ini :v
        
        Cancel = new JButton("Cancel");
        Cancel.setBounds(500,580, 100, 30);
        Cancel.setContentAreaFilled(true);
        Cancel.setBackground(BGCOLOR_DEFAULT);
        Cancel.setForeground(COLOR_WHITE);
        Cancel.setBorder(javax.swing.BorderFactory.createLineBorder(BGCOLOR_DEFAULT));
        Cancel.setFocusPainted(false);
        Cancel.setFont(FONT_DEFAULT_PLAIN);
        Cancel.addActionListener(this);
        Cancel.setVisible(false);
        add(Cancel);
        
        
        //setBackground(Color.MAGENTA);
    }
    
    @Override
    public Dimension getPreferredSize() {
        return DIMENSION_PANEL_CARD;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
         String option = e.getActionCommand();
         System.out.println("Action Panel Jadwal Perkuliahan : " + option);
         
         if(jadwalCreate != null){
            jadwalCreate.setVisible(false);
         }
         if(jadwalEdit != null){
            jadwalEdit.setVisible(false);
         }
         if(jadwalDelete != null){
            jadwalDelete.setVisible(false); 
         }
       
             
         errorMsg.setVisible(false);
         Cancel.setVisible(false);
         //Proccces Create
         
         if(option.equals("Process")){
            //Melakukan pencarian nim ! di database 
            String  kodeMK = kodeMKJadwal.getText();
            String  semester = (String) optionSemester.getSelectedItem();
            String  tahun = yearJadwal.getText();
            System.out.println("Nim : " + kodeMK + " Semester : " + semester + " Tahun : " + tahun);
            if(true){      
                //jadwalCreate = new JPanelHelperJadwal("Input");
                jadwalCreate.setBounds(20,135,668,490);
                jadwalCreate.setVisible(false);
                add(jadwalCreate);
                jadwalCreate.setVisible(true);
            }
            Cancel.setVisible(true);
            return;
         }
         
         if(option.equals("Cancel")){
            if(jadwalCreate != null){
                jadwalCreate.setVisible(false);
            }
            return;
         }
         
         //Proccces Edit / Delete
         if(option.equals("Cari")){
             String  kodeMK = kodeMKJadwal.getText();
             String  semester = (String) optionSemester.getSelectedItem();
             String  tahun = yearJadwal.getText();
             System.out.println("Nim : " + kodeMK + " Semester : " + semester + " Tahun : " + tahun );
             //Lakukan pencarian didatabase nanti y :v
             boolean foundTest = true;
             //Dummy Boy
             
             //End Dummy
             if(foundTest){
                if(menuNow.equals("Edit Jadwal")){
                    //jadwalEdit = new JPanelHelperJadwal("Edit");
                    jadwalEdit.setBounds(20,135,660,490);
                    jadwalEdit.setVisible(false);
                    add(jadwalEdit);
                    jadwalEdit.setVisible(true);

                }else if(menuNow.equals("Delete Jadwal")){
                    //jadwalDelete = new JPanelHelperJadwal("Delete");
                    jadwalDelete.setBounds(20,135,660,490);
                    jadwalDelete.setVisible(false);
                    add(jadwalDelete);
                    jadwalDelete.setVisible(true);
                }

            }else{
                errorMsg.setText("Maaf pencarian tidak ditemukan.");
                errorMsg.setBounds(20, 140, 450, 30);
                errorMsg.setFont(new java.awt.Font("Segoe UI", 0, 16));
                errorMsg.setVisible(false);
                add(errorMsg);
                errorMsg.setVisible(true);
             }
             return;
         }
         //Reset Zone
         
         createJadwal.setBackground(COLOR_WHITE);
         createJadwal.setForeground(BGCOLOR_DEFAULT);
         editJadwal.setBackground(COLOR_WHITE);
         editJadwal.setForeground(BGCOLOR_DEFAULT);
         deleteJadwal.setBackground(COLOR_WHITE);
         deleteJadwal.setForeground(BGCOLOR_DEFAULT);
         btnSearchEdit.setVisible(false);
         btnTypeMatakuliah.setVisible(false);
         kodeMKJadwal.setVisible(false);
         optionSemester.setVisible(false);
         yearJadwal.setVisible(false);
            
        if(option.equals("Tambah Jadwal")){
            menuNow = "Tambah Jadwal";
            createJadwal.setBackground(BGCOLOR_DEFAULT);
            createJadwal.setForeground(COLOR_WHITE);
            optionSemester.setVisible(true);
            yearJadwal.setVisible(true);
            kodeMKJadwal.setVisible(true);
            btnTypeMatakuliah.setVisible(true);
        }else if(option.equals("Edit Jadwal")){
            menuNow = "Edit Jadwal";
            editJadwal.setBackground(BGCOLOR_DEFAULT);
            editJadwal.setForeground(COLOR_WHITE);
            optionSemester.setVisible(true);
            yearJadwal.setVisible(true);
            kodeMKJadwal.setVisible(true);
            btnSearchEdit.setVisible(true);
        }else if(option.equals("Hapus Jadwal")){
            menuNow = "Delete Jadwal";
            deleteJadwal.setBackground(BGCOLOR_DEFAULT);
            deleteJadwal.setForeground(COLOR_WHITE);
            optionSemester.setVisible(true);
            yearJadwal.setVisible(true);
            kodeMKJadwal.setVisible(true);
            btnSearchEdit.setVisible(true);
        }
         
    }
}
