/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.DatabaseController.LoginController;
import controller.UserManager;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import model.user.User;
import static view.ViewConfig.BGCOLOR_DEFAULT;
import static view.ViewConfig.FONT_DEFAULT_PLAIN;
import view.menuDaak.Dashboard;

/**
 *
 * @author 1119038 Elangel Neilea Shaday
 */
public class loginMenu implements ActionListener,ViewConfig{
    private JFrame Frame;
    private JPanel Menu;
    private JLabel Email, Password;
    private JTextField ViewEmail;
    private JPasswordField ViewPassword;
    private JButton Login;
    
    public loginMenu(){
        Frame = new JFrame("Login");
        
        Menu = new JPanel();
        Menu.setBounds(0,0,500,600);
        Menu.setBackground(BGCOLOR_DEFAULT);
        Menu.setLayout(null);
        Frame.add(Menu);
        
        //Foto
        JLabel ViewFoto;
        Image img = null;
        String RESOURCE = "asset/logo.png";
        URL url = getClass().getResource( RESOURCE );
        if(url == null ){
            try {
                throw new Exception( "ERR cannot find resource: " + RESOURCE );
            } catch (Exception ex1) {
                Logger.getLogger(view.menuMahasiswa.JPanelProfile.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        img = Toolkit.getDefaultToolkit().getImage( url );
        Image newPicture1 = img.getScaledInstance(170,170, Image.SCALE_SMOOTH);
        ImageIcon image1 = new ImageIcon(newPicture1);
        ViewFoto = new JLabel(image1);
        ViewFoto.setBounds(160,50,170,170);
        Menu.add(ViewFoto);
        
        Email = new JLabel("Email");
        Email.setBounds(225,245,100,30);
        Email.setForeground(COLOR_WHITE);
        Email.setFont(FONT_TITLE);
        Menu.add(Email);
        ViewEmail = new JTextField();
        ViewEmail.setBounds(100,290,300,30);
        Menu.add(ViewEmail);
        
        Password = new JLabel("Password");
        Password.setBounds(210,335,100,30);
        Password.setForeground(COLOR_WHITE);
        Password.setFont(FONT_TITLE);
        Menu.add(Password);
        ViewPassword = new JPasswordField();
        ViewPassword.setBounds(100,380,300,30);
        Menu.add(ViewPassword);
        
        Login = new JButton("Login");
        Login.setBounds(210,435,90,30);
        Login.setContentAreaFilled(true);
        Login.setBackground(Color.WHITE);
        Login.setForeground(BGCOLOR_DEFAULT);
        Login.setBorder(javax.swing.BorderFactory.createLineBorder(BGCOLOR_DEFAULT));
        Login.setFocusPainted(false);
        Login.setFont(FONT_DEFAULT_PLAIN);
        Login.addActionListener(this);
        Menu.add(Login);
        
        Frame.setSize(500,580);
        Frame.setLocationRelativeTo(null);
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame.setVisible(true);
        Frame.setResizable(false);
    }
    
    private boolean checkAllData(){
        if(ViewEmail.getText().equals("")){
            return false;
        }
        if(ViewPassword.getText().equals("")){
            return false;
        }
        return true;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if(action.equals("Login")){
            if(checkAllData() == true){
                String email = ViewEmail.getText();
                String password = String.valueOf(ViewPassword.getPassword());
                
                User user = LoginController.searchUser(email, password);
                if(user != null){
                    JOptionPane.showMessageDialog(null,"Berhasil Login!");
                    UserManager.getInstance().setUser(user);
                    if(user.getJenisUser() == 1){
                        Frame.dispose();
                        new view.menuDaak.Dashboard();
                    }else if(user.getJenisUser() == 2){
                        Frame.dispose();
                        new view.menuDosen.Dashboard();
                    }else if(user.getJenisUser() == 3){
                        Frame.dispose();
                        new view.menuMahasiswa.Dashboard();
                    }else{
                        System.out.println("User tidak ditemukan");
                        System.out.println(user.toString());
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"Data tidak ditemukan!");
                }
            }else{
                JOptionPane.showMessageDialog(null,"Silahkan Masukkan Data dengan Benar!");
            }
        }
    }
    
    public static void main(String[] args) {
        loginMenu menu = new loginMenu();
    }
}
