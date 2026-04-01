# Aplikasi Data Kendaraan

Aplikasi manajemen data kendaraan

---




## 🌐 Frontend (HTML)

### Letak File Frontend

Frontend tersedia dalam dua lokasi:

| Lokasi | Keterangan |
|---|---|
| `src/main/resources/static/index.html` | FE yang di-serve langsung oleh Spring Boot |

---

### Cara Menjalankan Frontend


```
http://localhost:8080/index.html
```


## 🚀 Cara Menjalankan Backend (Spring Boot)
   ```
   http://localhost:8080
   ```
---


## 📡 Endpoint API

| Method | Endpoint | Keterangan |
|---|---|---|
| GET | `/api/kendaraan` | Ambil semua data |
| GET | `/api/kendaraan/{id}` | Ambil data by nomor registrasi |
| GET | `/api/kendaraan/search?nomorRegistrasi=&namaPemilik=` | Cari data |
| POST | `/api/kendaraan` | Tambah data baru |
| PUT | `/api/kendaraan/{id}` | Update data |
| DELETE | `/api/kendaraan/{id}` | Hapus data |
