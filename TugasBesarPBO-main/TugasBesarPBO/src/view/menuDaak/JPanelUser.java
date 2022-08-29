/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.menuDaak;


import controller.DatabaseController.ContollerDaak.UserManageController;
import view.menuDaak.Helper.JPanelHelperMahasiswa;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JButton;
import javax.swing.*;
import model.user.*;
import model.user.User;
import view.ViewConfig;
import static view.ViewConfig.*;
import view.menuDaak.Helper.JPanelHelperDaak;
import view.menuDaak.Helper.JPanelHelperDosen;

/**
 *
 * @author 1119002 Albertus Angkuw
 */
public class JPanelUser  extends JPanel implements ActionListener,ViewConfig  {
    private JLabel title;
    private JButton createUser;
    private JButton editUser;
    private JButton deleteUser;
    private JTextField searchUser;
    
    private JButton btnSearchEdit;
    private JButton btnSearchDelete;
    private JButton btnTypeUser;
    
    private String listUser[] = {"","DAAK", "Dosen","Mahasiswa"};
    private JComboBox optionListUser;
    
    private JPanelHelperMahasiswa mahasiswaCreate;
    private JPanelHelperMahasiswa mahasiswaEdit;
    private JPanelHelperMahasiswa mahasiswaDelete;
    
    private JPanelHelperDosen dosenCreate;
    private JPanelHelperDosen dosenEdit;
    private JPanelHelperDosen dosenDelete;
    
    private JPanelHelperDaak daakCreate;
    private JPanelHelperDaak daakEdit;
    private JPanelHelperDaak daakDelete;

    private JLabel errorMsg ;
    private JButton Cancel;
    
    private String menuNow = null;
    
    public JPanelUser(){
        setLayout(null);
        title = new JLabel("User Management");
        title.setBounds(20, 0, 200, 60);
        title.setFont(new java.awt.Font("Segoe UI", 1, 20));
        add(title);
        
        createUser = new JButton("Tambah User");
        createUser.setBounds(20, 60, 170 ,30);
        createUser.setContentAreaFilled(true);
        createUser.setBackground(COLOR_WHITE);
        createUser.setForeground(BGCOLOR_DEFAULT);
        createUser.setBorder(javax.swing.BorderFactory.createLineBorder(BGCOLOR_DEFAULT));
        createUser.setFocusPainted(false);
        createUser.setFont(FONT_DEFAULT_PLAIN );
        createUser.addActionListener(this);
        add(createUser);
        
        editUser = new JButton("Edit User");
        editUser.setBounds(200, 60, 170 ,30);
        editUser.setContentAreaFilled(true);
        editUser.setBackground(COLOR_WHITE);
        editUser.setForeground(BGCOLOR_DEFAULT);
        editUser.setBorder(javax.swing.BorderFactory.createLineBorder(BGCOLOR_DEFAULT));
        editUser.setFocusPainted(false);
        editUser.setFont(FONT_DEFAULT_PLAIN );
        editUser.addActionListener(this);
        add(editUser);
        
        deleteUser = new JButton("Hapus User");
        deleteUser.setBounds(380, 60, 170 ,30);
        deleteUser.setContentAreaFilled(true);
        deleteUser.setBackground(COLOR_WHITE);
        deleteUser.setForeground(BGCOLOR_DEFAULT);
        deleteUser.setBorder(javax.swing.BorderFactory.createLineBorder(BGCOLOR_DEFAULT));
        deleteUser.setFocusPainted(false);
        deleteUser.setFont(FONT_DEFAULT_PLAIN );
        deleteUser.addActionListener(this);
        add(deleteUser);
        
        searchUser = new JTextField(" Nama atau Nomor Induk");
        searchUser.setBounds(20, 100, 250 ,30);
        searchUser.setFont(FONT_DEFAULT_PLAIN );
        searchUser.setForeground(Color.GRAY);
        searchUser.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (searchUser.getText().equals(" Nama atau Nomor Induk")) {
                    searchUser.setText("");
                    searchUser.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (searchUser.getText().isEmpty()) {
                    searchUser.setForeground(Color.GRAY);
                    searchUser.setText(" Nama atau Nomor Induk");
                }
            }
        });
        searchUser.setVisible(false);
        add(searchUser);
        
        btnSearchEdit = new JButton("Cari");
        btnSearchEdit.setBounds(285, 100, 100 ,30);
        btnSearchEdit.setContentAreaFilled(true);
        btnSearchEdit.setBackground(BGCOLOR_DEFAULT);
        btnSearchEdit.setForeground(COLOR_WHITE);
        btnSearchEdit.setBorder(javax.swing.BorderFactory.createLineBorder(BGCOLOR_DEFAULT));
        btnSearchEdit.setFocusPainted(false);
        btnSearchEdit.setFont(FONT_DEFAULT_PLAIN );
        btnSearchEdit.setVisible(false);
        btnSearchEdit.addActionListener(this);
        add(btnSearchEdit);
        
        optionListUser = new JComboBox(listUser);
        optionListUser.setBounds(20, 100, 250 ,30);
        optionListUser.setVisible(false);
        add(optionListUser);
        
        
        btnTypeUser = new JButton("Process");
        btnTypeUser.setBounds(285, 100, 100 ,30);
        btnTypeUser.setContentAreaFilled(true);
        btnTypeUser.setBackground(BGCOLOR_DEFAULT);
        btnTypeUser.setForeground(COLOR_WHITE);
        btnTypeUser.setBorder(javax.swing.BorderFactory.createLineBorder(BGCOLOR_DEFAULT));
        btnTypeUser.setFocusPainted(false);
        btnTypeUser.setFont(FONT_DEFAULT_PLAIN );
        btnTypeUser.setVisible(false);
        btnTypeUser.addActionListener(this);
        add(btnTypeUser);
      
                      
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
        
        //setBackground(Color.RED);
    }
    
    @Override
    public Dimension getPreferredSize() {
        return DIMENSION_PANEL_CARD;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         String option = e.getActionCommand();
         System.out.println("Action Panel User : " + option);
         
         if(mahasiswaCreate != null){
            mahasiswaCreate.setVisible(false);
         }
         if(mahasiswaEdit != null){
            mahasiswaEdit.setVisible(false);
         }
         if(mahasiswaDelete != null){
            mahasiswaDelete.setVisible(false); 
         }
         if(dosenCreate != null){
            dosenCreate.setVisible(false);
         }
         if(dosenEdit != null){
            dosenEdit.setVisible(false);
         }
         if(dosenDelete != null){
            dosenDelete.setVisible(false); 
         }
         if(mahasiswaDelete != null){
            mahasiswaDelete.setVisible(false); 
         }
         if(daakCreate != null){
            daakCreate.setVisible(false);
         }
         if(daakEdit != null){
            daakEdit.setVisible(false);
         }
         if(daakDelete != null){
            daakDelete.setVisible(false); 
         }
            
         if(errorMsg != null){
             errorMsg.setVisible(false);
         }
         
         if(Cancel != null){
             Cancel.setVisible(false);
         }
         
         //Proccces Create
         if(option.equals("Process")){
            if(optionListUser.getItemAt(optionListUser.getSelectedIndex()).equals("Mahasiswa")){      
                mahasiswaCreate = new JPanelHelperMahasiswa("Input",null);
                mahasiswaCreate.setBounds(20,135,668,490);
                mahasiswaCreate.setVisible(false);
                add(mahasiswaCreate);
                mahasiswaCreate.setVisible(true);
                
            }else if(optionListUser.getItemAt(optionListUser.getSelectedIndex()).equals("Dosen")){
                dosenCreate = new JPanelHelperDosen("Input",null);
                dosenCreate.setBounds(20,135,668,490);
                dosenCreate.setVisible(false);
                add(dosenCreate);
                dosenCreate.setVisible(true);
            }else if(optionListUser.getItemAt(optionListUser.getSelectedIndex()).equals("DAAK")){
                daakCreate = new JPanelHelperDaak("Input",null);
                daakCreate.setBounds(20,135,668,490);
                daakCreate.setVisible(false);
                add(daakCreate);
                daakCreate.setVisible(true);
            }
            Cancel.setVisible(true);
            return;
         }
         
         if(option.equals("Cancel")){
            if(mahasiswaCreate != null){
                mahasiswaCreate.setVisible(false);
            }
            if(dosenCreate != null){
                dosenCreate.setVisible(false);
            }
            return;
         }
         
         //Proccces Edit / Delete
         if(option.equals("Cari")){
             String nameToSearch = searchUser.getText();
             User user = UserManageController.getUser(nameToSearch);
             String tipe = "";

             if(nameToSearch.equals(" Nama atau Nomor Induk")){
                 JOptionPane.showMessageDialog(null, "Isilah form terlebih dahulu");
                 return;
             }


             boolean foundTest = false;
             if(user != null){
                foundTest = true;
                System.out.println(" Test : " + user.getJenisUser());
                if(user.getJenisUser() == 1){
                    tipe = "Daak";
                }else if(user.getJenisUser() == 2){
                    tipe = "Dosen";
                }else if(user.getJenisUser() == 3){
                    tipe = "Mahasiswa";
                }else{
                    foundTest = false;
                }
             }
               
             if(foundTest){
                if(tipe.equals("Mahasiswa")){
                    if(menuNow.equals("Edit")){
                        mahasiswaEdit = new JPanelHelperMahasiswa("Edit",(Mahasiswa) user);
                        mahasiswaEdit.setBounds(20,135,660,490);
                        mahasiswaEdit.setVisible(false);
                        add(mahasiswaEdit);
                        mahasiswaEdit.setVisible(true);

                    }else if(menuNow.equals("Delete")){
                        mahasiswaDelete = new JPanelHelperMahasiswa("Delete",(Mahasiswa) user);
                        mahasiswaDelete.setBounds(20,135,660,490);
                        mahasiswaDelete.setVisible(false);
                        add(mahasiswaDelete);
                        mahasiswaDelete.setVisible(true);
                    }
                }else if(tipe.equals("Dosen")){
                    if(menuNow.equals("Edit")){
                        dosenEdit = new JPanelHelperDosen("Edit",(Dosen) user);
                        dosenEdit.setBounds(20,135,660,490);
                        dosenEdit.setVisible(false);
                        add(dosenEdit);
                        dosenEdit.setVisible(true);

                    }else if(menuNow.equals("Delete")){
                        dosenDelete = new JPanelHelperDosen("Delete",(Dosen) user);
                        dosenDelete.setBounds(20,135,660,490);
                        dosenDelete.setVisible(false);
                        add(dosenDelete);
                        dosenDelete.setVisible(true);
                    }
                }else if(tipe.equals("Daak")){
                    System.out.println("Menu now " + menuNow);
                    if(menuNow.equals("Edit")){
                        daakEdit = new JPanelHelperDaak("Edit",(Daak) user);
                        daakEdit.setBounds(20,135,668,490);
                        daakEdit.setVisible(false);
                        add(daakEdit);
                        daakEdit.setVisible(true);

                    }else if(menuNow.equals("Delete")){
                        System.out.println("Tes1");
                        daakDelete = new JPanelHelperDaak("Delete", (Daak) user);
                        daakDelete.setBounds(20,135,668,490);
                        daakDelete.setVisible(false);
                        add(daakDelete);
                        daakDelete.setVisible(true);
                    }
                }
            }else{
                errorMsg.setText("Maaf pencarian untuk '" + nameToSearch + "' tidak ditemukan.");
                errorMsg.setBounds(20, 130, 480, 60);
                errorMsg.setFont(new java.awt.Font("Segoe UI", 0, 16));
                errorMsg.setVisible(false);
                add(errorMsg);
                errorMsg.setVisible(true);
             }
             return;
         }
         //Reset Zone
         
         createUser.setBackground(COLOR_WHITE);
         createUser.setForeground(BGCOLOR_DEFAULT);
         editUser.setBackground(COLOR_WHITE);
         editUser.setForeground(BGCOLOR_DEFAULT);
         deleteUser.setBackground(COLOR_WHITE);
         deleteUser.setForeground(BGCOLOR_DEFAULT);
         searchUser.setVisible(false);
         btnSearchEdit.setVisible(false);
         btnTypeUser.setVisible(false);
         optionListUser.setVisible(false);
         
        if(option.equals("Tambah User")){
            menuNow = "Tambah User";
            createUser.setBackground(BGCOLOR_DEFAULT);
            createUser.setForeground(COLOR_WHITE);
            optionListUser.setVisible(true);
            btnTypeUser.setVisible(true);
            
         }else if(option.equals("Edit User")){
            menuNow = "Edit";
            editUser.setBackground(BGCOLOR_DEFAULT);
            editUser.setForeground(COLOR_WHITE);
            searchUser.setVisible(true);
            btnSearchEdit.setVisible(true);
         }else if(option.equals("Hapus User")){
            menuNow = "Delete";
            deleteUser.setBackground(BGCOLOR_DEFAULT);
            deleteUser.setForeground(COLOR_WHITE);
            searchUser.setVisible(true);
            btnSearchEdit.setVisible(true);
         }
         
    }
     
}
