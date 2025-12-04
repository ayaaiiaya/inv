/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inventaris.service;
import com.mycompany.inventaris.dao.LoginDAO;
import com.mycompany.inventaris.model.User;

/**
 *
 * @author pnady
 */
public class LoginService {
    private LoginDAO loginDao = new LoginDAO();
    
    public User authenticate(String username, String password){
        return loginDao.login(username, password);
    }
}
