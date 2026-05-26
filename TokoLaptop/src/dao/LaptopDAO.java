package dao;

import config.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Laptop;

public class LaptopDAO {

    public void insert(Laptop laptop) {

        try {
            String sql = "INSERT INTO data_laptop(id_laptop, nama_laptop, spesifikasi, stok, harga) VALUES(?,?,?,?,?)";

            PreparedStatement ps = DatabaseConnection
                    .getConnection()
                    .prepareStatement(sql);

            ps.setString(1, laptop.getIdLaptop());
            ps.setString(2, laptop.getNamaLaptop());
            ps.setString(3, laptop.getSpesifikasi());
            ps.setInt(4, laptop.getStok());
            ps.setDouble(5, laptop.getHarga());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Laptop> getAll() {

        List<Laptop> list = new ArrayList<>();

        try {
            String sql = "SELECT * FROM data_laptop";

            Statement st = DatabaseConnection
                    .getConnection()
                    .createStatement();

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                //inisialisasi
                Laptop laptop = null;
                //mengambil dari db
                String idLaptop = rs.getString("id_laptop");
                String namaLaptop = rs.getString("nama_laptop");
                String spesifikasi = rs.getString("spesifikasi");
                int stok = rs.getInt("stok");
                double harga = rs.getDouble("harga");
                //dimasukkan di constructor
                laptop = new Laptop(idLaptop,namaLaptop,spesifikasi,stok,harga);
                //dimasukkan ke list laptop
                list.add(laptop);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public void update(Laptop laptop) {

        try {
            String sql = "UPDATE data_laptop SET nama_laptop=?, spesifikasi=?, stok=?, harga=? WHERE id_laptop=?";

            PreparedStatement ps = DatabaseConnection
                    .getConnection()
                    .prepareStatement(sql);

            ps.setString(1, laptop.getNamaLaptop());
            ps.setString(2, laptop.getSpesifikasi());
            ps.setInt(3, laptop.getStok());
            ps.setDouble(4, laptop.getHarga());
            ps.setString(5, laptop.getIdLaptop());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(String idLaptop) {

        try {
            String sql = "DELETE FROM data_laptop WHERE id_laptop=?";

            PreparedStatement ps = DatabaseConnection
                    .getConnection()
                    .prepareStatement(sql);

            ps.setString(1, idLaptop);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}