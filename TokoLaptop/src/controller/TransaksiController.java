package controller;

import dao.TransaksiDAO;
import model.Transaksi;

public class TransaksiController {

    TransaksiDAO dao = new TransaksiDAO();

    public void tambahTransaksi(String idTransaksi, String namaPelanggan, String namaLaptop, double hargaAwal, double diskon, double hargaAkhir) {
        Transaksi transaksi = new Transaksi(idTransaksi, namaPelanggan, namaLaptop, hargaAwal, diskon, hargaAkhir);
        dao.insert(transaksi);
    }

    public void hapusTransaksi(String idTransaksi) {
        dao.delete(idTransaksi);
    }
}
