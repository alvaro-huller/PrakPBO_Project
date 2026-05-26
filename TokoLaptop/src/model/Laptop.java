package model;

public class Laptop {
    private String idLaptop;
    private String namaLaptop;
    private String spesifikasi;
    private int stok;
    private double harga;

    public Laptop(String idLaptop, String namaLaptop, String spesifikasi, int stok, double harga) {
        this.idLaptop = idLaptop;
        this.namaLaptop = namaLaptop;
        this.spesifikasi = spesifikasi;
        this.stok = stok;
        this.harga = harga;
    }

    public String getIdLaptop() {
        return idLaptop;
    }
    public void setIdLaptop(String idLaptop) {
        this.idLaptop = idLaptop;
    }

    public String getNamaLaptop() {
        return namaLaptop;
    }
    public void setNamaLaptop(String namaLaptop) {
        this.namaLaptop = namaLaptop;
    }

    public String getSpesifikasi() {
        return spesifikasi;
    }
    public void setSpesifikasi(String spesifikasi) {
        this.spesifikasi = spesifikasi;
    }

    public int getStok() {
        return stok;
    }
    public void setStok(int stok) {
        this.stok = stok;
    }

    public double getHarga() {
        return harga;
    }
    public void setHarga(double harga) {
        this.harga = harga;
    }
}