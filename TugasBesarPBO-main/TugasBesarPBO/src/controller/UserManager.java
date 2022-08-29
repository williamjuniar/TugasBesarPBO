/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import model.user.Mahasiswa;

import model.user.Daak;

import model.user.User;

/**
 *
 * @author 1119002 Albertus Angkuw
 * @author 1119038 Elangel Neilea Shaday
 */
public class UserManager {
    //Singleton untuk user
    private static UserManager instance;
    private User user;
    private UserManager(){};
    public static UserManager getInstance(){
        if(instance == null){
            instance = new UserManager();
        }
        return instance;
    }
    
    public Mahasiswa getMahasiswa(){
        return (Mahasiswa) user;
    }
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    public Daak getDaak(){
        return (Daak) user;
    }
    @Override
    public String toString() {
        return "UserManager{" + "user=" + user + '}';
    }
}
