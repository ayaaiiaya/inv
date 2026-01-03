/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inventaris.dao;

import com.mycompany.inventaris.Koneksi;
import com.mycompany.inventaris.model.Barang;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class BarangDAO {
  public static ObservableList<Barang> getAll(){
    ObservableList<Barang> list = FXCollections.observableArrayList();
    
    try{
        Connection conn = Koneksi.getKoneksi();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM barang");
        
        while (rs.next()){
            list.add(new Barang(
                rs.getInt("id_barang"),
                rs.getString("kode_barang"),
                rs.getString("nama_barang"),
                rs.getString("kategori"),
                rs.getInt("stok"),
                rs.getString("kondisi"),
                rs.getString("lokasi"),
                rs.getString("status")
            ));
        }
        
        rs.close();
        st.close();
    }catch (Exception e){
        e.printStackTrace();
    }
    return list;
  }
}