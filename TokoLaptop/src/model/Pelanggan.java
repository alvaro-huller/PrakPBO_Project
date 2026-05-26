package model;

public class Pelanggan {
    private String idPelanggan;
    private String namaPelanggan;
    private String tingkatMember;

    public Pelanggan(String idPelanggan, String namaPelanggan, String tingkatMember) {
        this.idPelanggan = idPelanggan;
        this.namaPelanggan = namaPelanggan;
        this.tingkatMember = tingkatMember;
    }
    
    public String getIdPelanggan() {
        return idPelanggan;
    }
    public void setIdPelanggan(String idPelanggan) {
        this.idPelanggan = idPelanggan;
    }

    public String getNamaPelanggan() {
        return namaPelanggan;
    }
    public void setNamaPelanggan(String namaPelanggan) {
        this.namaPelanggan = namaPelanggan;
    }

    public String getTingkatMember() {
        return tingkatMember;
    }
    public void setTingkatMember(String tingkatMember) {
        this.tingkatMember = tingkatMember;
    }
}