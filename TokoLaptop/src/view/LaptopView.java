package view;

import controller.LaptopController;
import dao.LaptopDAO;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Laptop;

public class LaptopView extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(LaptopView.class.getName());

    private final LaptopController controller = new LaptopController();
    private final LaptopDAO dao = new LaptopDAO();

    public LaptopView() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kelola Laptop");
        loadTable();
    }

    private void loadTable() {
        DefaultTableModel model = (DefaultTableModel) TabelLaptop.getModel();
        model.setRowCount(0);
        List<Laptop> list = dao.getAll();
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

    private void clearFields() {
        IdLaptop.setText("");
        NamaLaptop.setText("");
        Spesifikasi.setText("");
        Stok.setText("");
        Harga.setText("");
        TabelLaptop.clearSelection();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelLaptop = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        IdLaptop = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        NamaLaptop = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Spesifikasi = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Stok = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Harga = new javax.swing.JTextField();
        Tambah = new javax.swing.JButton();
        Update = new javax.swing.JButton();
        Hapus = new javax.swing.JButton();
        Clear = new javax.swing.JButton();

        jLabel6.setText("jLabel6");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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

        jLabel1.setText("Id Laptop");
        jLabel2.setText("Nama Laptop");
        jLabel3.setText("Spesifikasi");
        jLabel4.setText("Stok");
        jLabel5.setText("Harga");

        Tambah.setText("Tambah");
        Tambah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TambahMouseClicked(evt);
            }
        });

        Update.setText("Update");
        Update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UpdateMouseClicked(evt);
            }
        });

        Hapus.setText("Hapus");
        Hapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HapusMouseClicked(evt);
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)
                        .addComponent(jLabel5)
                        .addComponent(IdLaptop)
                        .addComponent(NamaLaptop)
                        .addComponent(Spesifikasi)
                        .addComponent(Stok)
                        .addComponent(Harga, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Tambah)
                            .addComponent(Hapus))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Clear)
                            .addComponent(Update))))
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(IdLaptop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NamaLaptop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Spesifikasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Stok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Harga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Tambah)
                    .addComponent(Update))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Clear)
                    .addComponent(Hapus))
                .addContainerGap(17, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TabelLaptopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelLaptopMouseClicked
        int row = TabelLaptop.getSelectedRow();
        if (row >= 0) {
            DefaultTableModel model = (DefaultTableModel) TabelLaptop.getModel();
            IdLaptop.setText(model.getValueAt(row, 0).toString());
            NamaLaptop.setText(model.getValueAt(row, 1).toString());
            Spesifikasi.setText(model.getValueAt(row, 2).toString());
            Stok.setText(model.getValueAt(row, 3).toString());
            Harga.setText(model.getValueAt(row, 4).toString());
        }
    }//GEN-LAST:event_TabelLaptopMouseClicked

    private void TambahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TambahMouseClicked
        try {
            String id = IdLaptop.getText().trim();
            String nama = NamaLaptop.getText().trim();
            String spek = Spesifikasi.getText().trim();
            int stok = Integer.parseInt(Stok.getText().trim());
            double harga = Double.parseDouble(Harga.getText().trim());

            if (id.isEmpty() || nama.isEmpty() || spek.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Semua field harus diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                return;
            }

            controller.tambahLaptop(id, nama, spek, stok, harga);
            JOptionPane.showMessageDialog(this, "Laptop berhasil ditambahkan!");
            loadTable();
            clearFields();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Stok harus angka bulat dan Harga harus angka!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_TambahMouseClicked

    private void UpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateMouseClicked
        try {
            String id = IdLaptop.getText().trim();
            String nama = NamaLaptop.getText().trim();
            String spek = Spesifikasi.getText().trim();
            int stok = Integer.parseInt(Stok.getText().trim());
            double harga = Double.parseDouble(Harga.getText().trim());

            if (id.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Pilih laptop dari tabel terlebih dahulu!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                return;
            }

            Laptop laptop = new Laptop(id, nama, spek, stok, harga);
            dao.update(laptop);
            JOptionPane.showMessageDialog(this, "Laptop berhasil diupdate!");
            loadTable();
            clearFields();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Stok harus angka bulat dan Harga harus angka!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_UpdateMouseClicked

    private void HapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HapusMouseClicked
        String id = IdLaptop.getText().trim();
        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Pilih laptop dari tabel terlebih dahulu!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(this, "Yakin ingin menghapus laptop ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            dao.delete(id);
            JOptionPane.showMessageDialog(this, "Laptop berhasil dihapus!");
            loadTable();
            clearFields();
        }
    }//GEN-LAST:event_HapusMouseClicked

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
        java.awt.EventQueue.invokeLater(() -> new LaptopView().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Clear;
    private javax.swing.JButton Hapus;
    private javax.swing.JTextField Harga;
    private javax.swing.JTextField IdLaptop;
    private javax.swing.JTextField NamaLaptop;
    private javax.swing.JTextField Spesifikasi;
    private javax.swing.JTextField Stok;
    private javax.swing.JTable TabelLaptop;
    private javax.swing.JButton Tambah;
    private javax.swing.JButton Update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
