package controller;

import dao.LaptopDAO;
import model.Laptop;

public class LaptopController {

    LaptopDAO dao = new LaptopDAO();

    public void tambahLaptop(String idLaptop, String namaLaptop, String spesifikasi, int stok, double harga) {
        Laptop laptop = new Laptop(idLaptop, namaLaptop, spesifikasi, stok, harga);
        dao.insert(laptop);
    }

    public void updateLaptop(String idLaptop, String namaLaptop, String spesifikasi, int stok, double harga) {
        Laptop laptop = new Laptop(idLaptop, namaLaptop, spesifikasi, stok, harga);
        dao.update(laptop);
    }

    public void hapusLaptop(String idLaptop) {
        dao.delete(idLaptop);
    }
}
