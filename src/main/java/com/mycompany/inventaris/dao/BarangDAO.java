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
import java.util.ArrayList;
import java.util.List;

public class BarangDAO {
  public static List<Barang> getAll(){
      List<Barang> list = new ArrayList<>();
      
      String sql = "select*from barang";
      try{
          Connection conn = Koneksi.getKoneksi();
          Statement st = conn.createStatement();
          ResultSet rs = st.executeQuery(sql);
          
          while(rs.next()){
              list.add(new Barang(
                      rs.getInt("id_barang"),
                      rs.getString("kode_barang"),
                      rs.getString("nama_barang"),
                      rs.getString("kategori"),
                      rs.getString("stok"),
                      rs.getString("kondisi"),
                      rs.getString("lokasi"),
                      rs.getString("status")
              ));
          }
      }catch(Exception e){
          e.printStackTrace();
      }
      
      return list;
  }
}