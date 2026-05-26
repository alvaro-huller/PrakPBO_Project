package dao;

import config.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Transaksi;

public class TransaksiDAO {

    public void insert(Transaksi transaksi) {

        try {
            String sql = "INSERT INTO transaksi(id_transaksi, nama_pelanggan, nama_laptop, harga_awal, diskon, harga_akhir) VALUES(?,?,?,?,?,?)";

            PreparedStatement ps = DatabaseConnection
                    .getConnection()
                    .prepareStatement(sql);

            ps.setString(1, transaksi.getIdTransaksi());
            ps.setString(2, transaksi.getNamaPelanggan());
            ps.setString(3, transaksi.getNamaLaptop());
            ps.setDouble(4, transaksi.getHargaAwal());
            ps.setDouble(5, transaksi.getDiskon());
            ps.setDouble(6, transaksi.getHargaAkhir());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Transaksi> getAll() {

        List<Transaksi> list = new ArrayList<>();

        try {
            String sql = "SELECT * FROM transaksi";

            Statement st = DatabaseConnection
                    .getConnection()
                    .createStatement();

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                Transaksi transaksi = null;
                
                String idTransaksi = rs.getString("id_transaksi");
                String namaPelanggan = rs.getString("nama_pelanggan");
                String namaLaptop = rs.getString("nama_laptop");
                double hargaAwal = rs.getDouble("harga_awal");
                double diskon = rs.getDouble("diskon");
                double hargaAkhir = rs.getDouble("harga_akhir");

                transaksi = new Transaksi(idTransaksi, namaPelanggan, namaLaptop,hargaAwal, diskon, hargaAkhir);
                
                list.add(transaksi);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public void delete(String idTransaksi) {

        try {
            String sql = "DELETE FROM transaksi WHERE id_transaksi=?";

            PreparedStatement ps = DatabaseConnection
                    .getConnection()
                    .prepareStatement(sql);

            ps.setString(1, idTransaksi);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}