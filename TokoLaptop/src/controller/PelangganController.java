package controller;

import dao.PelangganDAO;
import model.Pelanggan;

public class PelangganController {

    PelangganDAO dao = new PelangganDAO();

    public void tambahPelanggan(String idPelanggan, String namaPelanggan, String tingkatMember) {
        Pelanggan pelanggan = new Pelanggan(idPelanggan, namaPelanggan, tingkatMember);
        dao.insert(pelanggan);
    }

    public void updatePelanggan(String idPelanggan, String namaPelanggan, String tingkatMember) {
        Pelanggan pelanggan = new Pelanggan(idPelanggan, namaPelanggan, tingkatMember);
        dao.update(pelanggan);
    }

    public void hapusPelanggan(String idPelanggan) {
        dao.delete(idPelanggan);
    }
}
