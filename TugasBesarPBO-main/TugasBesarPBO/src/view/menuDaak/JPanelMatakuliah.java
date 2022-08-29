/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.menuDaak;


import controller.DatabaseController.ContollerDaak.MatakuliahManageController;
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
import model.matakuliah.DetailMatakuliah;
import model.matakuliah.Matakuliah;
import view.ViewConfig;
import static view.ViewConfig.BGCOLOR_DEFAULT;
import static view.ViewConfig.COLOR_WHITE;
import static view.ViewConfig.FONT_DEFAULT_PLAIN;
import view.menuDaak.Helper.JPanelHelperDetailMatakuliah;
import view.menuDaak.Helper.JPanelHelperMatakuliah;

/**
 *
 * @author 1119002 Albertus Angkuw
 */
public class JPanelMatakuliah  extends JPanel implements ActionListener,ViewConfig{
    private JLabel title;
    private JButton createMatakuliah;
    private JButton editMatakuliah;
    private JButton deleteMatakuliah;
    private JTextField searchMatakuliah;
    private JTextField yearMatakuliah;
    
    private JButton btnSearchEdit;
    private JButton btnSearchDelete;
    private JButton btnTypeMatakuliah;
    
    private String[] listMatakuliah = {"-Kategori Matakuliah-","Matakuliah", "Detail Matakuliah"};
    private JComboBox optionListMatakuliah;
    
    private String listSemester[] = {"-Semester-","Ganjil", "Genap","Pendek"};
    private JComboBox optionSemester;
    
    private JPanelHelperMatakuliah matakuliahCreate;
    private JPanelHelperMatakuliah matakuliahEdit;
    private JPanelHelperMatakuliah matakuliahDelete;
    
    private JPanelHelperDetailMatakuliah detailMatakuliahCreate;
    private JPanelHelperDetailMatakuliah detailMatakuliahEdit;
    private JPanelHelperDetailMatakuliah detailMatakuliahDelete;
    
    private JLabel errorMsg ;
    private JButton Cancel;
    
    private String menuNow = null;
    public JPanelMatakuliah(){
        setLayout(null);
        title = new JLabel("Matakuliah Management");
        title.setBounds(20, 0, 300, 60);
        title.setFont(new java.awt.Font("Segoe UI", 1, 20));
        add(title);
        
        createMatakuliah = new JButton("Tambah Matakuliah");
        createMatakuliah.setBounds(20, 60, 170 ,30);
        createMatakuliah.setContentAreaFilled(true);
        createMatakuliah.setBackground(COLOR_WHITE);
        createMatakuliah.setForeground(BGCOLOR_DEFAULT);
        createMatakuliah.setBorder(javax.swing.BorderFactory.createLineBorder(BGCOLOR_DEFAULT));
        createMatakuliah.setFocusPainted(false);
        createMatakuliah.setFont(FONT_DEFAULT_PLAIN );
        createMatakuliah.addActionListener(this);
        add(createMatakuliah);
        
        editMatakuliah = new JButton("Edit Matakuliah");
        editMatakuliah.setBounds(200, 60, 170 ,30);
        editMatakuliah.setContentAreaFilled(true);
        editMatakuliah.setBackground(COLOR_WHITE);
        editMatakuliah.setForeground(BGCOLOR_DEFAULT);
        editMatakuliah.setBorder(javax.swing.BorderFactory.createLineBorder(BGCOLOR_DEFAULT));
        editMatakuliah.setFocusPainted(false);
        editMatakuliah.setFont(FONT_DEFAULT_PLAIN );
        editMatakuliah.addActionListener(this);
        add(editMatakuliah);
        
        deleteMatakuliah = new JButton("Hapus Matakuliah");
        deleteMatakuliah.setBounds(380, 60, 170 ,30);
        deleteMatakuliah.setContentAreaFilled(true);
        deleteMatakuliah.setBackground(COLOR_WHITE);
        deleteMatakuliah.setForeground(BGCOLOR_DEFAULT);
        deleteMatakuliah.setBorder(javax.swing.BorderFactory.createLineBorder(BGCOLOR_DEFAULT));
        deleteMatakuliah.setFocusPainted(false);
        deleteMatakuliah.setFont(FONT_DEFAULT_PLAIN );
        deleteMatakuliah.addActionListener(this);
        add(deleteMatakuliah);
        
        
        optionListMatakuliah = new JComboBox(listMatakuliah);
        optionListMatakuliah.setBounds(20, 100, 170 ,30);
        optionListMatakuliah.setVisible(false);
        optionListMatakuliah.setFont(FONT_DEFAULT_PLAIN);
        add(optionListMatakuliah);
        
        searchMatakuliah = new JTextField(" Kode Matakuliah");
        searchMatakuliah.setBounds(200, 100, 120 ,30);
        searchMatakuliah.setFont(FONT_DEFAULT_PLAIN );
        searchMatakuliah.setForeground(Color.GRAY);
        searchMatakuliah.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (searchMatakuliah.getText().equals(" Kode Matakuliah")) {
                    searchMatakuliah.setText("");
                    searchMatakuliah.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (searchMatakuliah.getText().isEmpty()) {
                    searchMatakuliah.setForeground(Color.GRAY);
                    searchMatakuliah.setText(" Kode Matakuliah");
                }
            }
        });
        searchMatakuliah.setVisible(false);
        add(searchMatakuliah);
        
        yearMatakuliah = new JTextField(" Tahun");
        yearMatakuliah.setBounds(330, 100, 70 ,30);
        yearMatakuliah.setFont(FONT_DEFAULT_PLAIN );
        yearMatakuliah.setForeground(Color.GRAY);
        yearMatakuliah.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (yearMatakuliah.getText().equals(" Tahun")) {
                    yearMatakuliah.setText("");
                    yearMatakuliah.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (yearMatakuliah.getText().isEmpty()) {
                    yearMatakuliah.setForeground(Color.GRAY);
                    yearMatakuliah.setText(" Tahun");
                }
            }
        });
        yearMatakuliah.setVisible(false);
        add(yearMatakuliah);
       
        optionSemester = new JComboBox(listSemester);
        optionSemester.setBounds(410, 100, 100 ,30);
        optionSemester.setFont(FONT_DEFAULT_PLAIN );
        optionSemester.setVisible(false);
        add(optionSemester);
        
        btnSearchEdit = new JButton("Cari");
        btnSearchEdit.setBounds(20, 140, 100 ,30);
        btnSearchEdit.setContentAreaFilled(true);
        btnSearchEdit.setBackground(BGCOLOR_DEFAULT);
        btnSearchEdit.setForeground(COLOR_WHITE);
        btnSearchEdit.setBorder(javax.swing.BorderFactory.createLineBorder(BGCOLOR_DEFAULT));
        btnSearchEdit.setFocusPainted(false);
        btnSearchEdit.setFont(FONT_DEFAULT_PLAIN );
        btnSearchEdit.setVisible(false);
        btnSearchEdit.addActionListener(this);
        add(btnSearchEdit);
        
        optionListMatakuliah.addActionListener (new ActionListener () {
            public void actionPerformed(ActionEvent e) {
                searchMatakuliah.setVisible(false);
                optionSemester.setVisible(false);
                yearMatakuliah.setVisible(false);
                btnSearchEdit.setVisible(false);
                if(menuNow.equals("Edit Matakuliah") || menuNow.equals("Delete Matakuliah") ){
                    if(optionListMatakuliah.getItemAt(optionListMatakuliah.getSelectedIndex()).equals("Matakuliah")){
                        searchMatakuliah.setVisible(true);
                        btnSearchEdit.setBounds(340, 100, 100 ,30);
                        btnSearchEdit.setVisible(true);
                    }else if(optionListMatakuliah.getItemAt(optionListMatakuliah.getSelectedIndex()).equals("Detail Matakuliah")){
                        searchMatakuliah.setVisible(true);
                        optionSemester.setVisible(true);
                        yearMatakuliah.setVisible(true);
                        btnSearchEdit.setBounds(530, 100, 100 ,30);
                        btnSearchEdit.setVisible(true);
                    }
                }
            }
        });
        
        
        btnTypeMatakuliah = new JButton("Process");
        btnTypeMatakuliah.setBounds(200, 100, 100 ,30);
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
        
        //setBackground(Color.yellow);
    }
    
    @Override
    public Dimension getPreferredSize() {
        return DIMENSION_PANEL_CARD;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
         String option = e.getActionCommand();
         System.out.println("Action Panel Matakuliah : " + option);
         
         if(matakuliahCreate != null){
            matakuliahCreate.setVisible(false);
         }
         if(matakuliahEdit != null){
            matakuliahEdit.setVisible(false);
         }
         if(matakuliahDelete != null){
            matakuliahDelete.setVisible(false); 
         }
         if(detailMatakuliahCreate != null){
            detailMatakuliahCreate.setVisible(false);
         }
         if(detailMatakuliahEdit != null){
            detailMatakuliahEdit.setVisible(false);
         }
         if(detailMatakuliahDelete != null){
            detailMatakuliahDelete.setVisible(false); 
         }
         if(matakuliahDelete != null){
            matakuliahDelete.setVisible(false); 
         }
                  
         errorMsg.setVisible(false);
         Cancel.setVisible(false);
         //Proccces Create
         
         if(option.equals("Process")){
            if(optionListMatakuliah.getItemAt(optionListMatakuliah.getSelectedIndex()).equals("-Kategori Matakuliah-")){
             return;
            }
            if(optionListMatakuliah.getItemAt(optionListMatakuliah.getSelectedIndex()).equals("Matakuliah")){      
                matakuliahCreate = new JPanelHelperMatakuliah("Input",null);
                matakuliahCreate.setBounds(20,135,668,490);
                matakuliahCreate.setVisible(false);
                add(matakuliahCreate);
                matakuliahCreate.setVisible(true);
            }else if(optionListMatakuliah.getItemAt(optionListMatakuliah.getSelectedIndex()).equals("Detail Matakuliah")){      
                detailMatakuliahCreate = new JPanelHelperDetailMatakuliah("Input",null);
                detailMatakuliahCreate.setBounds(20,135,668,490);
                detailMatakuliahCreate.setVisible(false);
                add(detailMatakuliahCreate);
                detailMatakuliahCreate.setVisible(true);
            }
            Cancel.setVisible(true);
            return;
         }
         
         if(option.equals("Cancel")){
            if(matakuliahCreate != null){
                matakuliahCreate.setVisible(false);
            }
            if(detailMatakuliahCreate != null){
                detailMatakuliahCreate.setVisible(false);
            }
            return;
         }
         
         Matakuliah tempMK = null;
         //Proccces Edit / Delete
         if(option.equals("Cari")){
             String matakuliahToSearch = searchMatakuliah.getText();
             String tipe = "";
             boolean foundTest = false;
             if(optionListMatakuliah.getSelectedIndex() == 2){
                if(!checkInput("Detail")){
                    JOptionPane.showMessageDialog(null, "Isilah form terlebih dahulu");
                    return;
                }
                int tahun = Integer.valueOf(yearMatakuliah.getText()); 
                String semester =(String) optionSemester.getSelectedItem();
                tempMK = MatakuliahManageController.getDetailMatakuliah(matakuliahToSearch, tahun, semester);
                if( tempMK != null){
                    foundTest = true;
                }else{
                    foundTest = false;
                }
                tipe = "Detail Matakuliah";
             }else if(optionListMatakuliah.getSelectedIndex() == 1){
                if(!checkInput("MK")){
                    JOptionPane.showMessageDialog(null, "Isilah form terlebih dahulu");
                    return;
                }
                tempMK = MatakuliahManageController.getMatakuliah(matakuliahToSearch);
                if( tempMK != null){
                    foundTest = true;
                }else{
                    foundTest = false;
                }
                tipe = "Matakuliah";
             }
             
             if(foundTest){
                if(tipe.equals("Matakuliah")){
                    if(menuNow.equals("Edit Matakuliah")){
                        matakuliahEdit = new JPanelHelperMatakuliah("Edit",tempMK);
                        matakuliahEdit.setBounds(20,135,660,490);
                        matakuliahEdit.setVisible(false);
                        add(matakuliahEdit);
                        matakuliahEdit.setVisible(true);

                    }else if(menuNow.equals("Delete Matakuliah")){
                        matakuliahDelete = new JPanelHelperMatakuliah("Delete",tempMK);
                        matakuliahDelete.setBounds(20,135,660,490);
                        matakuliahDelete.setVisible(false);
                        add(matakuliahDelete);
                        matakuliahDelete.setVisible(true);
                    }
                }else if(tipe.equals("Detail Matakuliah")){
                    if(menuNow.equals("Edit Matakuliah")){
                        detailMatakuliahEdit = new JPanelHelperDetailMatakuliah("Edit",(DetailMatakuliah) tempMK);
                        detailMatakuliahEdit.setBounds(20,135,660,490);
                        detailMatakuliahEdit.setVisible(false);
                        add(detailMatakuliahEdit);
                        detailMatakuliahEdit.setVisible(true);

                    }else if(menuNow.equals("Delete Matakuliah")){
                        detailMatakuliahDelete = new JPanelHelperDetailMatakuliah("Delete",(DetailMatakuliah) tempMK);
                        detailMatakuliahDelete.setBounds(20,135,660,490);
                        detailMatakuliahDelete.setVisible(false);
                        add(detailMatakuliahDelete);
                        detailMatakuliahDelete.setVisible(true);
                    }
                }
            }else{
                errorMsg.setText("Maaf pencarian untuk '" + matakuliahToSearch + "' tidak ditemukan.");
                errorMsg.setBounds(20, 140, 450, 30);
                errorMsg.setFont(new java.awt.Font("Segoe UI", 0, 16));
                errorMsg.setVisible(false);
                add(errorMsg);
                errorMsg.setVisible(true);
             }
             return;
         }
         //Reset Zone
         
         createMatakuliah.setBackground(COLOR_WHITE);
         createMatakuliah.setForeground(BGCOLOR_DEFAULT);
         editMatakuliah.setBackground(COLOR_WHITE);
         editMatakuliah.setForeground(BGCOLOR_DEFAULT);
         deleteMatakuliah.setBackground(COLOR_WHITE);
         deleteMatakuliah.setForeground(BGCOLOR_DEFAULT);
         searchMatakuliah.setVisible(false);
         btnSearchEdit.setVisible(false);
         btnTypeMatakuliah.setVisible(false);
         optionListMatakuliah.setVisible(false);
         optionSemester.setVisible(false);
         yearMatakuliah.setVisible(false);
            
        if(option.equals("Tambah Matakuliah")){
            menuNow = "Tambah Matakuliah";
            createMatakuliah.setBackground(BGCOLOR_DEFAULT);
            createMatakuliah.setForeground(COLOR_WHITE);
            optionListMatakuliah.setVisible(true);
            btnTypeMatakuliah.setVisible(true);
        }else if(option.equals("Edit Matakuliah")){
            menuNow = "Edit Matakuliah";
            editMatakuliah.setBackground(BGCOLOR_DEFAULT);
            editMatakuliah.setForeground(COLOR_WHITE);
            optionListMatakuliah.setVisible(true);
        }else if(option.equals("Hapus Matakuliah")){
            menuNow = "Delete Matakuliah";
            deleteMatakuliah.setBackground(BGCOLOR_DEFAULT);
            deleteMatakuliah.setForeground(COLOR_WHITE);
            optionListMatakuliah.setVisible(true);
        }
         
    }
    private boolean checkInput(String type){
        if(type.equals("Detail")){
            if(searchMatakuliah.getText().equals(" Kode Matakuliah") || yearMatakuliah.getText().equals(" Tahun") || ((String)optionSemester.getSelectedItem()).equals("-Semester-") ){
                return false;
            }
        }else{
            if(searchMatakuliah.getText().equals(" Kode Matakuliah")){
                return false;
            }
            
        }    
        return true;
    }
     
}
