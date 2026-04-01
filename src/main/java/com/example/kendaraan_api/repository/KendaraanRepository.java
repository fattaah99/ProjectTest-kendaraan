package com.example.kendaraan_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.kendaraan_api.model.Kendaraan;

import java.util.List;

public interface KendaraanRepository extends JpaRepository<Kendaraan, String> {

    @Query("SELECT k FROM Kendaraan k WHERE "
            + "(:nomorRegistrasi IS NULL OR LOWER(k.nomorRegistrasi) LIKE LOWER(CONCAT('%', :nomorRegistrasi, '%'))) AND "
            + "(:namaPemilik IS NULL OR LOWER(k.namaPemilik) LIKE LOWER(CONCAT('%', :namaPemilik, '%')))")
    List<Kendaraan> search(@Param("nomorRegistrasi") String nomorRegistrasi,
                           @Param("namaPemilik") String namaPemilik);
}
