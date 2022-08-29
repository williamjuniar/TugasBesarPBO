/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.menuDaak;


import controller.DatabaseController.ContollerDaak.RencanaStudiManageController;
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
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.matakuliah.RencanaStudi;
import view.ViewConfig;
import static view.ViewConfig.BGCOLOR_DEFAULT;
import static view.ViewConfig.COLOR_WHITE;
import static view.ViewConfig.FONT_DEFAULT_PLAIN;
import view.menuDaak.Helper.JPanelHelperDetailMatakuliah;
import view.menuDaak.Helper.JPanelHelperMatakuliah;
import view.menuDaak.Helper.JPanelHelperRencanaStudi;
/**
 *
 * @author 1119002 Albertus Angkuw
 */
public class JPanelRencanaStudi  extends JPanel  implements ActionListener,ViewConfig {
    private JLabel title;
    private JButton createRencanaStudi;
    private JButton editRencanaStudi;
    private JButton deleteRencanaStudi;
    private JTextField yearRencanaStudi;
    
    private JButton btnSearchEdit;
    private JButton btnSearchDelete;
    private JButton btnTypeMatakuliah;
    
    private JTextField nimRencanaStudi;
    
    private String listSemester[] = {"-Semester-","Ganjil", "Genap","Pendek"};
    private JComboBox optionSemester;
    
    private JPanelHelperRencanaStudi rencanaStudiCreate;
    private JPanelHelperRencanaStudi rencanaStudiEdit;
    private JPanelHelperRencanaStudi rencanaStudiDelete;
    
    
    private JLabel errorMsg ;
    private JButton Cancel;
    
    private String menuNow = null;
    public JPanelRencanaStudi(){
        setLayout(null);
        title = new JLabel("Rencana Studi Management");
        title.setBounds(20, 0, 300, 60);
        title.setFont(new java.awt.Font("Segoe UI", 1, 20));
        add(title);
        
        createRencanaStudi = new JButton("Tambah Rencana Studi");
        createRencanaStudi.setBounds(20, 60, 170 ,30);
        createRencanaStudi.setContentAreaFilled(true);
        createRencanaStudi.setBackground(COLOR_WHITE);
        createRencanaStudi.setForeground(BGCOLOR_DEFAULT);
        createRencanaStudi.setBorder(javax.swing.BorderFactory.createLineBorder(BGCOLOR_DEFAULT));
        createRencanaStudi.setFocusPainted(false);
        createRencanaStudi.setFont(FONT_DEFAULT_PLAIN );
        createRencanaStudi.addActionListener(this);
        add(createRencanaStudi);
        
        editRencanaStudi = new JButton("Edit Rencana Studi");
        editRencanaStudi.setBounds(200, 60, 170 ,30);
        editRencanaStudi.setContentAreaFilled(true);
        editRencanaStudi.setBackground(COLOR_WHITE);
        editRencanaStudi.setForeground(BGCOLOR_DEFAULT);
        editRencanaStudi.setBorder(javax.swing.BorderFactory.createLineBorder(BGCOLOR_DEFAULT));
        editRencanaStudi.setFocusPainted(false);
        editRencanaStudi.setFont(FONT_DEFAULT_PLAIN );
        editRencanaStudi.addActionListener(this);
        add(editRencanaStudi);
        
        deleteRencanaStudi = new JButton("Hapus Rencana Studi");
        deleteRencanaStudi.setBounds(380, 60, 170 ,30);
        deleteRencanaStudi.setContentAreaFilled(true);
        deleteRencanaStudi.setBackground(COLOR_WHITE);
        deleteRencanaStudi.setForeground(BGCOLOR_DEFAULT);
        deleteRencanaStudi.setBorder(javax.swing.BorderFactory.createLineBorder(BGCOLOR_DEFAULT));
        deleteRencanaStudi.setFocusPainted(false);
        deleteRencanaStudi.setFont(FONT_DEFAULT_PLAIN );
        deleteRencanaStudi.addActionListener(this);
        add(deleteRencanaStudi);
        
        
        nimRencanaStudi = new JTextField(" NIM");
        nimRencanaStudi.setBounds(20, 100, 170 ,30);
        nimRencanaStudi.setFont(FONT_DEFAULT_PLAIN);
        nimRencanaStudi.setForeground(Color.GRAY);
        nimRencanaStudi.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (nimRencanaStudi.getText().equals(" NIM")) {
                    nimRencanaStudi.setText("");
                    nimRencanaStudi.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (nimRencanaStudi.getText().isEmpty()) {
                    nimRencanaStudi.setForeground(Color.GRAY);
                    nimRencanaStudi.setText(" NIM");
                }
            }
        });
        nimRencanaStudi.setVisible(false);
        add(nimRencanaStudi);
        
        optionSemester = new JComboBox(listSemester);
        optionSemester.setBounds(200, 100, 120 ,30);
        optionSemester.setFont(FONT_DEFAULT_PLAIN );
        optionSemester.setVisible(false);
        add(optionSemester);
        
        yearRencanaStudi = new JTextField(" Tahun");
        yearRencanaStudi.setBounds(330, 100, 70 ,30);
        yearRencanaStudi.setFont(FONT_DEFAULT_PLAIN );
        yearRencanaStudi.setForeground(Color.GRAY);
        yearRencanaStudi.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (yearRencanaStudi.getText().equals(" Tahun")) {
                    yearRencanaStudi.setText("");
                    yearRencanaStudi.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (yearRencanaStudi.getText().isEmpty()) {
                    yearRencanaStudi.setForeground(Color.GRAY);
                    yearRencanaStudi.setText(" Tahun");
                }
            }
        });
        yearRencanaStudi.setVisible(false);
        add(yearRencanaStudi);
       
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
        
        //setBackground(Color.DARK_GRAY);
    }
    
    @Override
    public Dimension getPreferredSize() {
        return DIMENSION_PANEL_CARD;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         String option = e.getActionCommand();
         System.out.println("Action Panel Rencana Studi : " + option);
         
         if(rencanaStudiCreate != null){
            rencanaStudiCreate.setVisible(false);
         }
         if(rencanaStudiEdit != null){
            rencanaStudiEdit.setVisible(false);
         }
         if(rencanaStudiDelete != null){
            rencanaStudiDelete.setVisible(false); 
         }
       
             
         errorMsg.setVisible(false);
         Cancel.setVisible(false);
         //Proccces Create
         
         if(option.equals("Process")){
            String  nim = nimRencanaStudi.getText();
            String  semester = (String) optionSemester.getSelectedItem();
            String  tahun = yearRencanaStudi.getText();
            if(!checkInput()){
                JOptionPane.showMessageDialog(null, "Isilah form terlebih dahulu");
                return;
            }
            rencanaStudiCreate = new JPanelHelperRencanaStudi("Input",nim,semester,Integer.valueOf(tahun));
            rencanaStudiCreate.setBounds(20,135,668,490);
            rencanaStudiCreate.setVisible(false);
            add(rencanaStudiCreate);
            rencanaStudiCreate.setVisible(true);

            Cancel.setVisible(true);
            return;
         }
         
         if(option.equals("Cancel")){
            if(rencanaStudiCreate != null){
                rencanaStudiCreate.setVisible(false);
            }
            return;
         }
         
         //Proccces Edit / Delete
         if(option.equals("Cari")){
             String  nim = nimRencanaStudi.getText();
             String  semester = (String) optionSemester.getSelectedItem();
             int  tahun = Integer.valueOf(yearRencanaStudi.getText());
             String  idrsm = "";
             if(!checkInput()){
                 JOptionPane.showMessageDialog(null, "Isilah form terlebih dahulu");
                 return;
             }
             boolean foundTest = false;
             RencanaStudi rsm = RencanaStudiManageController.getRencanastudi(nim, tahun, semester);
             //Lakukan pencarian didatabase nanti
             if(rsm != null){
                 foundTest = true;
             }
             if(foundTest){
                if(menuNow.equals("Edit Rencana Studi")){
                    rencanaStudiEdit = new JPanelHelperRencanaStudi("Edit",rsm,nim);
                    rencanaStudiEdit.setBounds(20,135,660,490);
                    rencanaStudiEdit.setVisible(false);
                    add(rencanaStudiEdit);
                    rencanaStudiEdit.setVisible(true);

                }else if(menuNow.equals("Delete Rencana Studi")){
                    rencanaStudiDelete = new JPanelHelperRencanaStudi("Delete",rsm,nim);
                    rencanaStudiDelete.setBounds(20,135,660,490);
                    rencanaStudiDelete.setVisible(false);
                    add(rencanaStudiDelete);
                    rencanaStudiDelete.setVisible(true);
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
         
         createRencanaStudi.setBackground(COLOR_WHITE);
         createRencanaStudi.setForeground(BGCOLOR_DEFAULT);
         editRencanaStudi.setBackground(COLOR_WHITE);
         editRencanaStudi.setForeground(BGCOLOR_DEFAULT);
         deleteRencanaStudi.setBackground(COLOR_WHITE);
         deleteRencanaStudi.setForeground(BGCOLOR_DEFAULT);
         btnSearchEdit.setVisible(false);
         btnTypeMatakuliah.setVisible(false);
         nimRencanaStudi.setVisible(false);
         optionSemester.setVisible(false);
         yearRencanaStudi.setVisible(false);
            
        if(option.equals("Tambah Rencana Studi")){
            menuNow = "Tambah Rencana Studi";
            createRencanaStudi.setBackground(BGCOLOR_DEFAULT);
            createRencanaStudi.setForeground(COLOR_WHITE);
            optionSemester.setVisible(true);
            yearRencanaStudi.setVisible(true);
            nimRencanaStudi.setVisible(true);
            btnTypeMatakuliah.setVisible(true);
        }else if(option.equals("Edit Rencana Studi")){
            menuNow = "Edit Rencana Studi";
            editRencanaStudi.setBackground(BGCOLOR_DEFAULT);
            editRencanaStudi.setForeground(COLOR_WHITE);
            optionSemester.setVisible(true);
            yearRencanaStudi.setVisible(true);
            nimRencanaStudi.setVisible(true);
            btnSearchEdit.setVisible(true);
        }else if(option.equals("Hapus Rencana Studi")){
            menuNow = "Delete Rencana Studi";
            deleteRencanaStudi.setBackground(BGCOLOR_DEFAULT);
            deleteRencanaStudi.setForeground(COLOR_WHITE);
            optionSemester.setVisible(true);
            yearRencanaStudi.setVisible(true);
            nimRencanaStudi.setVisible(true);
            btnSearchEdit.setVisible(true);
        }
         
    }
    private boolean checkInput(){
        return !(yearRencanaStudi.getText().equals("") || "".equals(nimRencanaStudi.getText()) || ((String) optionSemester.getSelectedItem()).equals("-Semester-"));
    }
}
