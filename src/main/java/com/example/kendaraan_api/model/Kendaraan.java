package com.example.kendaraan_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "kendaraan")
public class Kendaraan {
    @Id
    @Column(name = "nomor_registrasi", nullable = false, unique = true)
    private String nomorRegistrasi;

    @NotBlank
    @Column(name = "nama_pemilik", nullable = false)
    private String namaPemilik;

    @Column(columnDefinition = "TEXT")
    private String alamat;

    @Column(name = "merk_kendaraan")
    private String merkKendaraan;

    @Max(value = 9999)
    @Min(value = 1000)
    @Column(name = "tahun_pembuatan", length = 4)
    private Integer tahunPembuatan;

    @Column(name = "kapasitas_silinder")
    private Integer kapasitasSilinder;

    @Column(name = "warna_kendaraan")
    private String warnaKendaraan;

    @Enumerated(EnumType.STRING)
    @Column(name = "bahan_bakar")
    private BahanBakar bahanBakar;

    public enum BahanBakar {
        Merah, Hitam, Biru, AbuAbu;
    }

    public String getNomorRegistrasi() {
        return nomorRegistrasi;
    }

    public void setNomorRegistrasi(String nomorRegistrasi) {
        this.nomorRegistrasi = nomorRegistrasi;
    }

    public String getNamaPemilik() {
        return namaPemilik;
    }

    public void setNamaPemilik(String namaPemilik) {
        this.namaPemilik = namaPemilik;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getMerkKendaraan() {
        return merkKendaraan;
    }

    public void setMerkKendaraan(String merkKendaraan) {
        this.merkKendaraan = merkKendaraan;
    }

    public Integer getTahunPembuatan() {
        return tahunPembuatan;
    }

    public void setTahunPembuatan(Integer tahunPembuatan) {
        this.tahunPembuatan = tahunPembuatan;
    }

    public Integer getKapasitasSilinder() {
        return kapasitasSilinder;
    }

    public void setKapasitasSilinder(Integer kapasitasSilinder) {
        this.kapasitasSilinder = kapasitasSilinder;
    }

    public String getWarnaKendaraan() {
        return warnaKendaraan;
    }

    public void setWarnaKendaraan(String warnaKendaraan) {
        this.warnaKendaraan = warnaKendaraan;
    }

    public BahanBakar getBahanBakar() {
        return bahanBakar;
    }

    public void setBahanBakar(BahanBakar bahanBakar) {
        this.bahanBakar = bahanBakar;
    }
}
