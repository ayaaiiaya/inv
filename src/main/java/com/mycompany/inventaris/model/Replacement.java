package com.mycompany.inventaris.model;

import java.util.Date;

public class Replacement {

    // ===== ID =====
    private int idReplacement;
    private int idUser;
    private int idBarang;
    private int idPeminjaman;

    // ===== DATA BARANG & USER (JOIN) =====
    private String kode;           // BR-001
    private String namaBarang;
    private String kodeBarang;
    private String namaPeminjam;

    // ===== DETAIL =====
    private int jumlah;
    private String kondisi;
    private String alasan;
    private String status;

    // ===== TANGGAL =====
    private Date tanggalPengajuan;
    private Date tanggalVerifikasi;

    // ================= CONSTRUCTOR UNTUK TABLE =================
    public Replacement(
            int idUser1, String kode, String namaBarang, String kodeBarang, String namaPeminjam) {
        this.kode = kode;
        this.namaBarang = namaBarang;
        this.kodeBarang = kodeBarang;
        this.namaPeminjam = namaPeminjam;
        this.kondisi = kondisi;
        this.status = status;
    }

    // ================= CONSTRUCTOR INSERT =================
    public Replacement(int idUser, int idBarang, int idPeminjaman,
                       int jumlah, String kondisi, String alasan) {
        this.idUser = idUser;
        this.idBarang = idBarang;
        this.idPeminjaman = idPeminjaman;
        this.jumlah = jumlah;
        this.kondisi = kondisi;
        this.alasan = alasan;
        this.status = "PENDING";
    }

    // ================= GETTER & SETTER =================
    public int getIdReplacement() {
        return idReplacement;
    }

    public void setIdReplacement(int idReplacement) {
        this.idReplacement = idReplacement;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdBarang() {
        return idBarang;
    }

    public void setIdBarang(int idBarang) {
        this.idBarang = idBarang;
    }

    public int getIdPeminjaman() {
        return idPeminjaman;
    }

    public void setIdPeminjaman(int idPeminjaman) {
        this.idPeminjaman = idPeminjaman;
    }

    public String getKode() {
        return kode;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public String getKodeBarang() {
        return kodeBarang;
    }

    public String getNamaPeminjam() {
        return namaPeminjam;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public String getKondisi() {
        return kondisi;
    }

    public void setKondisi(String kondisi) {
        this.kondisi = kondisi;
    }

    public String getAlasan() {
        return alasan;
    }

    public void setAlasan(String alasan) {
        this.alasan = alasan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getTanggalPengajuan() {
        return tanggalPengajuan;
    }

    public void setTanggalPengajuan(Date tanggalPengajuan) {
        this.tanggalPengajuan = tanggalPengajuan;
    }

    public Date getTanggalVerifikasi() {
        return tanggalVerifikasi;
    }

    public void setTanggalVerifikasi(Date tanggalVerifikasi) {
        this.tanggalVerifikasi = tanggalVerifikasi;
    }
}
