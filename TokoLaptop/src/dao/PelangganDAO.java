package dao;

import config.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Pelanggan;

public class PelangganDAO {

    public void insert(Pelanggan pelanggan) {

        try {
            String sql = "INSERT INTO data_pelanggan(id_pelanggan, nama_pelanggan, tingkat_member) VALUES(?,?,?)";

            PreparedStatement ps = DatabaseConnection
                    .getConnection()
                    .prepareStatement(sql);

            ps.setString(1, pelanggan.getIdPelanggan());
            ps.setString(2, pelanggan.getNamaPelanggan());
            ps.setString(3, pelanggan.getTingkatMember());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Pelanggan> getAll() {

        List<Pelanggan> list = new ArrayList<>();

        try {
            String sql = "SELECT * FROM data_pelanggan";

            Statement st = DatabaseConnection
                    .getConnection()
                    .createStatement();

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                Pelanggan pelanggan = null;

                String idPelanggan = rs.getString("id_pelanggan");
                String namaPelanggan = rs.getString("nama_pelanggan");
                String tingkatMember = rs.getString("tingkat_member");
                
                pelanggan = new Pelanggan(idPelanggan, namaPelanggan, tingkatMember);
                
                list.add(pelanggan);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public void update(Pelanggan pelanggan) {

        try {
            String sql = "UPDATE data_pelanggan SET nama_pelanggan=?, tingkat_member=? WHERE id_pelanggan=?";

            PreparedStatement ps = DatabaseConnection
                    .getConnection()
                    .prepareStatement(sql);

            ps.setString(1, pelanggan.getNamaPelanggan());
            ps.setString(2, pelanggan.getTingkatMember());
            ps.setString(3, pelanggan.getIdPelanggan());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(String idPelanggan) {

        try {
            String sql = "DELETE FROM data_pelanggan WHERE id_pelanggan=?";

            PreparedStatement ps = DatabaseConnection
                    .getConnection()
                    .prepareStatement(sql);

            ps.setString(1, idPelanggan);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}