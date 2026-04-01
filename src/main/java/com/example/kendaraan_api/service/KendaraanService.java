package com.example.kendaraan_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kendaraan_api.model.Kendaraan;
import com.example.kendaraan_api.repository.KendaraanRepository;

import java.util.List;

@Service
public class KendaraanService {
    @Autowired
    private KendaraanRepository repository;

    // 🔹 GET ALL
    public List<Kendaraan> getAll() {
        return repository.findAll();
    }

    // 🔹 SEARCH (filter client-side params, null = abaikan filter)
    public List<Kendaraan> search(String nomorRegistrasi, String namaPemilik) {
        String noReg = (nomorRegistrasi == null || nomorRegistrasi.isBlank()) ? null : nomorRegistrasi;
        String nama  = (namaPemilik == null || namaPemilik.isBlank()) ? null : namaPemilik;
        return repository.search(noReg, nama);
    }

    // 🔹 GET BY ID
    public Kendaraan getById(String nomorRegistrasi) {
        return repository.findById(nomorRegistrasi)
                .orElseThrow(() -> new RuntimeException("Data tidak ditemukan"));
    }

    // 🔹 CREATE
    public Kendaraan create(Kendaraan kendaraan) {
        return repository.save(kendaraan);
    }

    // 🔹 UPDATE
    public Kendaraan update(String nomorRegistrasi, Kendaraan kendaraan) {
        Kendaraan existing = getById(nomorRegistrasi);

        existing.setNamaPemilik(kendaraan.getNamaPemilik());
        existing.setAlamat(kendaraan.getAlamat());
        existing.setMerkKendaraan(kendaraan.getMerkKendaraan());
        existing.setTahunPembuatan(kendaraan.getTahunPembuatan());
        existing.setKapasitasSilinder(kendaraan.getKapasitasSilinder());
        existing.setWarnaKendaraan(kendaraan.getWarnaKendaraan());
        existing.setBahanBakar(kendaraan.getBahanBakar());

        return repository.save(existing);
    }

    // 🔹 DELETE
    public void delete(String nomorRegistrasi) {
        repository.deleteById(nomorRegistrasi);
    }
}
