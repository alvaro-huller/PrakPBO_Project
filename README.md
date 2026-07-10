# TokoLaptop

TokoLaptop adalah aplikasi desktop untuk manajemen toko laptop, meliputi pengelolaan data laptop, data pelanggan beserta tingkat keanggotaan (member), dan pencatatan transaksi penjualan lengkap dengan perhitungan diskon otomatis berdasarkan tingkat member pelanggan. Aplikasi ini dibangun menggunakan Java Swing dengan basis data MySQL sebagai penyimpanan data.

## Deskripsi

TokoLaptop dikembangkan untuk memenuhi capaian pembelajaran mata kuliah Praktikum Pemrograman Berorientasi Objek (PBO), dengan penerapan pola arsitektur **MVC (Model-View-Controller)** yang dipadukan dengan pola **DAO (Data Access Object)** untuk memisahkan logika akses data dari logika bisnis dan antarmuka pengguna.

Selain itu, project ini secara khusus dirancang untuk mendemonstrasikan konsep-konsep inti OOP melalui sistem keanggotaan pelanggan:

- **Interface** (`Discountable`) mendefinisikan kontrak perhitungan diskon
- **Abstract class** (`Member`) mengimplementasikan interface tersebut dan menjadi kelas dasar bagi seluruh tingkat member
- **Inheritance & Polymorphism**: `BronzeMember`, `SilverMember`, dan `GoldMember` masing-masing meng-override method `hitungDiskon()` dengan persentase diskon berbeda, sehingga perhitungan diskon dapat dipanggil secara polymorphic tanpa perlu mengetahui tingkat member secara eksplisit di kode pemanggil

## Fitur

### Manajemen Data Laptop
- Menambahkan data laptop baru (ID, nama, spesifikasi, stok, harga)
- Menampilkan seluruh data laptop dalam tabel
- Mengedit dan menghapus data laptop yang sudah tersimpan

### Manajemen Data Pelanggan
- Menambahkan data pelanggan baru beserta tingkat keanggotaannya (Bronze, Silver, atau Gold)
- Menampilkan, mengedit, dan menghapus data pelanggan

### Manajemen Transaksi
- Membuat transaksi baru dengan memilih pelanggan dan laptop yang dibeli
- Perhitungan diskon otomatis berdasarkan tingkat member pelanggan:
  - Bronze — diskon 5%
  - Silver — diskon 10%
  - Gold — diskon 15%
- Perhitungan harga akhir otomatis (harga awal dikurangi diskon)
- Menampilkan riwayat seluruh transaksi dalam tabel
- Menghapus data transaksi

### Akses Data
- Seluruh operasi database menggunakan `PreparedStatement`, sehingga aman dari SQL injection
- Koneksi database terpusat melalui satu kelas `DatabaseConnection` (singleton-style connection)

## Tech Stack

| Kategori | Teknologi |
|---|---|
| Bahasa | Java |
| UI Framework | Java Swing (NetBeans GUI Builder) |
| Database | MySQL / MariaDB |
| Konektor DB | MySQL Connector/J (JDBC) |
| IDE | Apache NetBeans |
| Build Tool | Ant (`build.xml`, otomatis dari NetBeans) |
| Arsitektur | MVC + DAO Pattern, OOP (interface, abstract class, inheritance, polymorphism) |

## Struktur Project

```
TokoLaptop/
├── src/
│   ├── config/
│   │   └── DatabaseConnection.java     # Koneksi terpusat ke database MySQL
│   ├── model/
│   │   ├── Laptop.java                  # Entity data laptop
│   │   ├── Pelanggan.java                # Entity data pelanggan
│   │   ├── Transaksi.java                # Entity data transaksi
│   │   ├── Discountable.java             # Interface kontrak perhitungan diskon
│   │   ├── Member.java                   # Abstract class dasar member
│   │   ├── BronzeMember.java             # Diskon 5%
│   │   ├── SilverMember.java             # Diskon 10%
│   │   └── GoldMember.java               # Diskon 15%
│   ├── dao/
│   │   ├── LaptopDAO.java                # Query CRUD data laptop
│   │   ├── PelangganDAO.java             # Query CRUD data pelanggan
│   │   └── TransaksiDAO.java             # Query CRUD data transaksi
│   ├── controller/
│   │   ├── LaptopController.java         # Penghubung View dan LaptopDAO
│   │   ├── PelangganController.java      # Penghubung View dan PelangganDAO
│   │   └── TransaksiController.java      # Penghubung View dan TransaksiDAO
│   ├── view/
│   │   ├── MainView.java                 # Tampilan utama aplikasi
│   │   ├── LaptopView.java               # Tampilan manajemen laptop
│   │   ├── PelangganView.java            # Tampilan manajemen pelanggan
│   │   ├── BuatTransaksiView.java        # Tampilan pembuatan transaksi baru
│   │   └── KelolaTransaksiView.java      # Tampilan riwayat & kelola transaksi
│   └── main/
│       └── Main.java                     # Entry point aplikasi
├── db_tokolaptop.sql                     # Skema & data awal database
└── build.xml                             # Konfigurasi build Ant
```

**Alur data:** `View` → `Controller` → `DAO` → `Database (MySQL)`, dengan perhitungan diskon dilakukan melalui polymorphism pada hierarki kelas `Member`.

## Skema Database

Database: `db_tokolaptop`

**Tabel `data_laptop`**

| Kolom | Tipe | Keterangan |
|---|---|---|
| `id_laptop` | VARCHAR(10), PK | ID unik laptop |
| `nama_laptop` | VARCHAR(100) | Nama laptop |
| `spesifikasi` | TEXT | Spesifikasi laptop |
| `stok` | INT | Jumlah stok tersedia |
| `harga` | DOUBLE | Harga laptop |

**Tabel `data_pelanggan`**

| Kolom | Tipe | Keterangan |
|---|---|---|
| `id_pelanggan` | VARCHAR(10), PK | ID unik pelanggan |
| `nama_pelanggan` | VARCHAR(100) | Nama pelanggan |
| `tingkat_member` | VARCHAR(20) | Tingkat keanggotaan (Bronze/Silver/Gold) |

**Tabel `transaksi`**

| Kolom | Tipe | Keterangan |
|---|---|---|
| `id_transaksi` | VARCHAR(10), PK | ID unik transaksi |
| `nama_pelanggan` | VARCHAR(100) | Nama pelanggan yang bertransaksi |
| `nama_laptop` | VARCHAR(100) | Laptop yang dibeli |
| `harga_awal` | DOUBLE | Harga sebelum diskon |
| `diskon` | DOUBLE | Nominal diskon yang diterapkan |
| `harga_akhir` | DOUBLE | Harga setelah diskon |

Skema lengkap beserta data contoh tersedia di [`db_tokolaptop.sql`](./db_tokolaptop.sql).

## Cara Menjalankan

### Prasyarat
- Java Development Kit (JDK) 8 atau lebih baru
- Apache NetBeans IDE
- MySQL / MariaDB (disarankan via XAMPP)
- MySQL Connector/J (sudah tersedia di `dist/lib/mysql-connector-j-9.5.0.jar`)

### Langkah instalasi

1. **Clone / extract project**
   ```bash
   git clone <repo-url>
   ```

2. **Siapkan database**
   - Jalankan MySQL/MariaDB (misalnya melalui XAMPP)
   - Buat database baru bernama `db_tokolaptop`
   - Import file `db_tokolaptop.sql` melalui phpMyAdmin atau terminal:
     ```bash
     mysql -u root -p db_tokolaptop < db_tokolaptop.sql
     ```

3. **Sesuaikan konfigurasi koneksi**
   Buka `src/config/DatabaseConnection.java` dan sesuaikan kredensial database jika diperlukan:
   ```java
   String url = "jdbc:mysql://localhost:3306/db_tokolaptop";
   String user = "root";
   String password = "";
   ```

4. **Buka project di NetBeans**
   - Buka NetBeans → `File > Open Project` → pilih folder `TokoLaptop`
   - Pastikan library **MySQL Connector/J** sudah ditambahkan ke Project Libraries

5. **Jalankan aplikasi**
   - Klik kanan project → `Run`, atau tekan `F6`
   - Alternatif: jalankan langsung file JAR yang sudah dibangun di `dist/TokoLaptop.jar`

## Cara Pakai

1. Tambahkan data laptop melalui menu **Kelola Laptop**
2. Tambahkan data pelanggan beserta tingkat membernya melalui menu **Kelola Pelanggan**
3. Buat transaksi baru melalui menu **Buat Transaksi**, pilih pelanggan dan laptop — diskon dan harga akhir akan dihitung otomatis sesuai tingkat member
4. Lihat dan kelola riwayat transaksi melalui menu **Kelola Transaksi**

## Author

Tugas Praktikum Pemrograman Berorientasi Objek (PBO)

## Lisensi

Project ini dibuat untuk keperluan akademik/tugas praktikum dan bebas digunakan untuk tujuan pembelajaran.