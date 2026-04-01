package com.example.kendaraan_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.kendaraan_api.dto.ApiResponse;
import com.example.kendaraan_api.model.Kendaraan;
import com.example.kendaraan_api.service.KendaraanService;

import java.util.List;

@RestController
@RequestMapping("/api/kendaraan")
@CrossOrigin // supaya bisa diakses frontend (jQuery, dll)
public class KendaraanController {

    @Autowired
    private KendaraanService service;

    // 🔹 GET ALL
    @GetMapping
    public ApiResponse<List<Kendaraan>> getAll() {
        return new ApiResponse<>(true, "Berhasil ambil semua data", service.getAll());
    }

    // 🔹 SEARCH (GET /api/kendaraan/search?nomorRegistrasi=...&namaPemilik=...)
    @GetMapping("/search")
    public ApiResponse<List<Kendaraan>> search(
            @RequestParam(required = false) String nomorRegistrasi,
            @RequestParam(required = false) String namaPemilik) {
        return new ApiResponse<>(true, "Hasil pencarian", service.search(nomorRegistrasi, namaPemilik));
    }

    // 🔹 GET BY ID
    @GetMapping("/{id}")
    public ApiResponse<Kendaraan> getById(@PathVariable String id) {
        return new ApiResponse<>(true, "Berhasil ambil data", service.getById(id));
    }

    // 🔹 CREATE
    @PostMapping
    public ApiResponse<Kendaraan> create(@RequestBody Kendaraan kendaraan) {
        return new ApiResponse<>(true, "Data berhasil ditambahkan", service.create(kendaraan));
    }

    // 🔹 UPDATE
    @PutMapping("/{id}")
    public ApiResponse<Kendaraan> update(@PathVariable String id,
            @RequestBody Kendaraan kendaraan) {
        return new ApiResponse<>(true, "Data berhasil diupdate", service.update(id, kendaraan));
    }

    // 🔹 DELETE
    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable String id) {
        service.delete(id);
        return new ApiResponse<>(true, "Data berhasil dihapus", null);
    }
}