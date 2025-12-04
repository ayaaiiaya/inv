/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inventaris.model;

/**
 *
 * @author pnady
 */
public class User {
    private int id_user;
    private String nama;
    private String username;
    private String password;
    private String role;
    private String status;
    
    public User(int id_user, String nama, String username, String password, String role, String status){
        this.id_user = id_user;
        this.nama = nama;
        this.username = username;
        this.password = password;
        this.role = role;
        this.status = status;
    }
    
    public int getIdUser(){
        return id_user;
    }
    
    public void setIdBarang(int id_user){
        this.id_user = id_user;
    }
    
    public String getNama(){
        return nama;
    }
    
    public void setNama(String nama){
        this.nama = nama;
    }
    
    public String getUsername(){
        return username;
    }
    
    public void setUsername(String username){
        this.username = username;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public String getRole(){
        return role;
    }
    
    public void setRole(String role){
        this.role = role;
    }
    
    public String getStatus(){
        return status;
    }
    
    public void setStatus(String status){
        this.status = status;
    }
}
