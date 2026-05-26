package view;

import controller.PelangganController;
import dao.PelangganDAO;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Pelanggan;

public class PelangganView extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(PelangganView.class.getName());

    private final PelangganController controller = new PelangganController();
    private final PelangganDAO dao = new PelangganDAO();

    public PelangganView() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kelola Pelanggan");
        loadTable();
    }

    private void loadTable() {
        DefaultTableModel model = (DefaultTableModel) TabelPelanggan.getModel();
        model.setRowCount(0);
        List<Pelanggan> list = dao.getAll();
        for (Pelanggan p : list) {
            model.addRow(new Object[]{
                p.getIdPelanggan(),
                p.getNamaPelanggan(),
                p.getTingkatMember()
            });
        }
    }

    private void clearFields() {
        IdPelanggan.setText("");
        NamaPelanggan.setText("");
        TingkatMember.setSelectedIndex(0);
        TabelPelanggan.clearSelection();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TabelPelanggan = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        IdPelanggan = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        NamaPelanggan = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        TingkatMember = new javax.swing.JComboBox<>();
        Tambah = new javax.swing.JButton();
        Update = new javax.swing.JButton();
        Hapus = new javax.swing.JButton();
        Clear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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
        jScrollPane1.setViewportView(TabelPelanggan);
        if (TabelPelanggan.getColumnModel().getColumnCount() > 0) {
            TabelPelanggan.getColumnModel().getColumn(0).setResizable(false);
            TabelPelanggan.getColumnModel().getColumn(1).setResizable(false);
            TabelPelanggan.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabel1.setText("Id Pelanggan");
        jLabel2.setText("Nama Pelanggan");
        jLabel3.setText("Tingkat Member");

        TingkatMember.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bronze", "Silver", "Gold" }));

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
        Clear.addActionListener(this::ClearActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(IdPelanggan)
                    .addComponent(NamaPelanggan)
                    .addComponent(TingkatMember, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Tambah)
                                    .addComponent(Hapus))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Update)
                                    .addComponent(Clear))))
                        .addGap(6, 6, 6)))
                .addGap(0, 17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(IdPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NamaPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TingkatMember, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Tambah)
                    .addComponent(Update))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Hapus)
                    .addComponent(Clear))
                .addContainerGap(21, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TabelPelangganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelPelangganMouseClicked
        int row = TabelPelanggan.getSelectedRow();
        if (row >= 0) {
            DefaultTableModel model = (DefaultTableModel) TabelPelanggan.getModel();
            IdPelanggan.setText(model.getValueAt(row, 0).toString());
            NamaPelanggan.setText(model.getValueAt(row, 1).toString());
            String member = model.getValueAt(row, 2).toString();
            TingkatMember.setSelectedItem(member);
        }
    }//GEN-LAST:event_TabelPelangganMouseClicked

    private void TambahMouseClicked(java.awt.event.MouseEvent evt) {
        String id = IdPelanggan.getText().trim();
        String nama = NamaPelanggan.getText().trim();
        String member = TingkatMember.getSelectedItem().toString();

        if (id.isEmpty() || nama.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Id dan Nama tidak boleh kosong!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        controller.tambahPelanggan(id, nama, member);
        JOptionPane.showMessageDialog(this, "Pelanggan berhasil ditambahkan!");
        loadTable();
        clearFields();
    }

    private void UpdateMouseClicked(java.awt.event.MouseEvent evt) {
        String id = IdPelanggan.getText().trim();
        String nama = NamaPelanggan.getText().trim();
        String member = TingkatMember.getSelectedItem().toString();

        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Pilih pelanggan dari tabel terlebih dahulu!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Pelanggan pelanggan = new Pelanggan(id, nama, member);
        dao.update(pelanggan);
        JOptionPane.showMessageDialog(this, "Pelanggan berhasil diupdate!");
        loadTable();
        clearFields();
    }

    private void HapusMouseClicked(java.awt.event.MouseEvent evt) {
        String id = IdPelanggan.getText().trim();
        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Pilih pelanggan dari tabel terlebih dahulu!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(this, "Yakin ingin menghapus pelanggan ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            dao.delete(id);
            JOptionPane.showMessageDialog(this, "Pelanggan berhasil dihapus!");
            loadTable();
            clearFields();
        }
    }

    private void ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearActionPerformed
        clearFields();
    }//GEN-LAST:event_ClearActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new PelangganView().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Clear;
    private javax.swing.JButton Hapus;
    private javax.swing.JTextField IdPelanggan;
    private javax.swing.JTextField NamaPelanggan;
    private javax.swing.JTable TabelPelanggan;
    private javax.swing.JButton Tambah;
    private javax.swing.JComboBox<String> TingkatMember;
    private javax.swing.JButton Update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
