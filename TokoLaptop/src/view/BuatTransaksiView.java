package view;

import controller.TransaksiController;
import dao.LaptopDAO;
import dao.PelangganDAO;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.BronzeMember;
import model.GoldMember;
import model.Laptop;
import model.Member;
import model.Pelanggan;
import model.SilverMember;

public class BuatTransaksiView extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(BuatTransaksiView.class.getName());

    private final TransaksiController controller = new TransaksiController();
    private final LaptopDAO laptopDAO = new LaptopDAO();
    private final PelangganDAO pelangganDAO = new PelangganDAO();

    // Menyimpan data yang dipilih
    private String selectedIdLaptop = "";
    private String selectedNamaLaptop = "";
    private double selectedHargaLaptop = 0;
    private int selectedStokLaptop = 0;
    private String selectedIdPelanggan = "";
    private String selectedNamaPelanggan = "";
    private String selectedTingkatMember = "";

    public BuatTransaksiView() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Buat Transaksi");
        loadTabelLaptop();
        loadTabelPelanggan();
    }

    private void loadTabelLaptop() {
        DefaultTableModel model = (DefaultTableModel) TabelLaptop.getModel();
        model.setRowCount(0);
        List<Laptop> list = laptopDAO.getAll();
        for (Laptop l : list) {
            model.addRow(new Object[]{
                l.getIdLaptop(),
                l.getNamaLaptop(),
                l.getSpesifikasi(),
                l.getStok(),
                String.format("%.0f", l.getHarga())
            });
        }
    }

    private void loadTabelPelanggan() {
        DefaultTableModel model = (DefaultTableModel) TabelPelanggan.getModel();
        model.setRowCount(0);
        List<Pelanggan> list = pelangganDAO.getAll();
        for (Pelanggan p : list) {
            model.addRow(new Object[]{
                p.getIdPelanggan(),
                p.getNamaPelanggan(),
                p.getTingkatMember()
            });
        }
    }

    private void hitungHarga() {
        if (selectedHargaLaptop > 0 && !selectedTingkatMember.isEmpty()) {
            Member member;
            switch (selectedTingkatMember) {
                case "Silver": member = new SilverMember(); break;
                case "Gold":   member = new GoldMember();   break;
                default:       member = new BronzeMember(); break;
            }
            double diskon = member.hitungDiskon(selectedHargaLaptop);
            double hargaAkhir = selectedHargaLaptop - diskon;
            HargaAwal.setText(String.format("%.0f", selectedHargaLaptop));
            Diskon.setText(String.format("%.0f", diskon));     
            HargaAkhir.setText(String.format("%.0f", hargaAkhir));  
        }
    }

    private void clearFields() {
        IdTransaksi.setText("");
        NamaLaptop.setText("");
        NamaPelanggan.setText("");
        HargaAwal.setText("");
        Diskon.setText("");
        HargaAkhir.setText("");
        selectedIdLaptop = "";
        selectedNamaLaptop = "";
        selectedHargaLaptop = 0;
        selectedStokLaptop = 0;
        selectedIdPelanggan = "";
        selectedNamaPelanggan = "";
        selectedTingkatMember = "";
        TabelLaptop.clearSelection();
        TabelPelanggan.clearSelection();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TabelLaptop = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        TabelPelanggan = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        IdTransaksi = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        NamaLaptop = new javax.swing.JTextField();
        NamaPelanggan = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        HargaAwal = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Diskon = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        HargaAkhir = new javax.swing.JTextField();
        Tambah = new javax.swing.JButton();
        Clear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TabelLaptop.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id Laptop", "Nama Laptop", "Spesifikasi", "Stok", "Harga"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TabelLaptop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelLaptopMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabelLaptop);
        if (TabelLaptop.getColumnModel().getColumnCount() > 0) {
            TabelLaptop.getColumnModel().getColumn(0).setResizable(false);
            TabelLaptop.getColumnModel().getColumn(1).setResizable(false);
            TabelLaptop.getColumnModel().getColumn(2).setResizable(false);
            TabelLaptop.getColumnModel().getColumn(3).setResizable(false);
            TabelLaptop.getColumnModel().getColumn(4).setResizable(false);
        }

        TabelPelanggan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id Pelanggan", "Nama Pelanggan", "Tingkat Member"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TabelPelanggan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelPelangganMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TabelPelanggan);
        if (TabelPelanggan.getColumnModel().getColumnCount() > 0) {
            TabelPelanggan.getColumnModel().getColumn(0).setResizable(false);
            TabelPelanggan.getColumnModel().getColumn(1).setResizable(false);
            TabelPelanggan.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabel1.setText("Id Transaksi");

        jLabel2.setText("Nama Laptop");

        jLabel3.setText("Nama Pelanggan");

        NamaLaptop.setEditable(false);

        NamaPelanggan.setEditable(false);

        jLabel4.setText("Harga Awal");

        HargaAwal.setEditable(false);

        jLabel5.setText("Diskon");

        Diskon.setEditable(false);

        jLabel6.setText("Harga Akhir");

        HargaAkhir.setEditable(false);

        Tambah.setText("Tambah");
        Tambah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TambahMouseClicked(evt);
            }
        });

        Clear.setText("Clear");
        Clear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ClearMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Tambah)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Clear))
                            .addComponent(HargaAwal)
                            .addComponent(Diskon)
                            .addComponent(HargaAkhir)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(IdTransaksi)
                            .addComponent(NamaLaptop)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(NamaPelanggan))))
                .addGap(0, 22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(IdTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NamaLaptop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NamaPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(HargaAwal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Diskon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(HargaAkhir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Tambah)
                            .addComponent(Clear))
                        .addContainerGap(20, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TabelLaptopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelLaptopMouseClicked
        int row = TabelLaptop.getSelectedRow();
        if (row >= 0) {
            DefaultTableModel model = (DefaultTableModel) TabelLaptop.getModel();
            selectedIdLaptop = model.getValueAt(row, 0).toString();
            selectedNamaLaptop = model.getValueAt(row, 1).toString();
            selectedStokLaptop = Integer.parseInt(model.getValueAt(row, 3).toString());
            selectedHargaLaptop = Double.parseDouble(model.getValueAt(row, 4).toString());
            NamaLaptop.setText(selectedNamaLaptop);
            hitungHarga();
        }
    }//GEN-LAST:event_TabelLaptopMouseClicked

    private void TabelPelangganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelPelangganMouseClicked
        int row = TabelPelanggan.getSelectedRow();
        if (row >= 0) {
            DefaultTableModel model = (DefaultTableModel) TabelPelanggan.getModel();
            selectedIdPelanggan = model.getValueAt(row, 0).toString();
            selectedNamaPelanggan = model.getValueAt(row, 1).toString();
            selectedTingkatMember = model.getValueAt(row, 2).toString();
            NamaPelanggan.setText(selectedNamaPelanggan);
            hitungHarga();
        }
    }//GEN-LAST:event_TabelPelangganMouseClicked

    private void TambahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TambahMouseClicked
        if (selectedIdLaptop.isEmpty() || selectedIdPelanggan.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Pilih Laptop dan Pelanggan dari tabel!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String idTransaksi = IdTransaksi.getText().trim();
        double hargaAwal = Double.parseDouble(HargaAwal.getText());
        double diskon = Double.parseDouble(Diskon.getText());
        double hargaAkhir = Double.parseDouble(HargaAkhir.getText());

        controller.tambahTransaksi(idTransaksi, selectedNamaPelanggan, selectedNamaLaptop, hargaAwal, diskon, hargaAkhir);

        // Kurangi stok laptop, hapus jika stok habis
        int stokBaru = selectedStokLaptop - 1;
        if (stokBaru <= 0) {
            laptopDAO.delete(selectedIdLaptop);
        } else {
            int row = TabelLaptop.getSelectedRow();
            String spesifikasi = row >= 0 ? TabelLaptop.getValueAt(row, 2).toString() : "";
            Laptop laptopUpdate = new Laptop(selectedIdLaptop, selectedNamaLaptop, spesifikasi, stokBaru, selectedHargaLaptop);
            laptopDAO.update(laptopUpdate);
        }

        JOptionPane.showMessageDialog(this, "Transaksi berhasil dibuat!");
        loadTabelLaptop();
        clearFields();
    }//GEN-LAST:event_TambahMouseClicked

    private void ClearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClearMouseClicked
        clearFields();
    }//GEN-LAST:event_ClearMouseClicked

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> new BuatTransaksiView().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Clear;
    private javax.swing.JTextField Diskon;
    private javax.swing.JTextField HargaAkhir;
    private javax.swing.JTextField HargaAwal;
    private javax.swing.JTextField IdTransaksi;
    private javax.swing.JTextField NamaLaptop;
    private javax.swing.JTextField NamaPelanggan;
    private javax.swing.JTable TabelLaptop;
    private javax.swing.JTable TabelPelanggan;
    private javax.swing.JButton Tambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
