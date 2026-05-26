package model;

public class Transaksi {
    private String idTransaksi;
    private String namaPelanggan;
    private String namaLaptop;
    private double hargaAwal;
    private double diskon;
    private double hargaAkhir;

    public Transaksi(String idTransaksi, String namaPelanggan, String namaLaptop, double hargaAwal, double diskon, double hargaAkhir) {
        this.idTransaksi = idTransaksi;
        this.namaPelanggan = namaPelanggan;
        this.namaLaptop = namaLaptop;
        this.hargaAwal = hargaAwal;
        this.diskon = diskon;
        this.hargaAkhir = hargaAkhir;
    }

    public String getIdTransaksi() {
        return idTransaksi;
    }
    public void setIdTransaksi(String idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public String getNamaPelanggan() {
        return namaPelanggan;
    }
    public void setNamaPelanggan(String namaPelanggan) {
        this.namaPelanggan = namaPelanggan;
    }

    public String getNamaLaptop() {
        return namaLaptop;
    }
    public void setNamaLaptop(String namaLaptop) {
        this.namaLaptop = namaLaptop;
    }

    public double getHargaAwal() {
        return hargaAwal;
    }
    public void setHargaAwal(double hargaAwal) {
        this.hargaAwal = hargaAwal;
    }

    public double getDiskon() {
        return diskon;
    }
    public void setDiskon(double diskon) {
        this.diskon = diskon;
    }

    public double getHargaAkhir() {
        return hargaAkhir;
    }
    public void setHargaAkhir(double hargaAkhir) {
        this.hargaAkhir = hargaAkhir;
    }
}