package view;

import dao.TransaksiDAO;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Transaksi;

public class KelolaTransaksiView extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(KelolaTransaksiView.class.getName());

    private final TransaksiDAO dao = new TransaksiDAO();
    private String selectedIdTransaksi = "";

    public KelolaTransaksiView() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kelola Transaksi");
        loadTable();
    }

    private void loadTable() {
        DefaultTableModel model = (DefaultTableModel) TabelTransaksi.getModel();
        model.setRowCount(0);
        List<Transaksi> list = dao.getAll();
        for (Transaksi t : list) {
            model.addRow(new Object[]{
                t.getIdTransaksi(),
                t.getNamaLaptop(),
                t.getNamaPelanggan(),
                String.format("%.0f", t.getHargaAwal()),
                String.format("%.0f", t.getDiskon()),
                String.format("%.0f", t.getHargaAkhir()),
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TabelTransaksi = new javax.swing.JTable();
        Hapus = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        TabelTransaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id Transaksi", "Nama Laptop", "Nama Pelanggan", "Harga Awal", "Diskon", "Harga Akhir"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TabelTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelTransaksiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabelTransaksi);
        if (TabelTransaksi.getColumnModel().getColumnCount() > 0) {
            TabelTransaksi.getColumnModel().getColumn(0).setResizable(false);
            TabelTransaksi.getColumnModel().getColumn(1).setResizable(false);
            TabelTransaksi.getColumnModel().getColumn(2).setResizable(false);
            TabelTransaksi.getColumnModel().getColumn(3).setResizable(false);
            TabelTransaksi.getColumnModel().getColumn(4).setResizable(false);
            TabelTransaksi.getColumnModel().getColumn(5).setResizable(false);
        }

        Hapus.setText("Hapus");
        Hapus.setPreferredSize(new java.awt.Dimension(75, 27));
        Hapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HapusMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 701, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Hapus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TabelTransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelTransaksiMouseClicked
        int row = TabelTransaksi.getSelectedRow();
        if (row >= 0) {
            DefaultTableModel model = (DefaultTableModel) TabelTransaksi.getModel();
            selectedIdTransaksi = model.getValueAt(row, 0).toString();
        }
    }//GEN-LAST:event_TabelTransaksiMouseClicked

    private void HapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HapusMouseClicked
        if (selectedIdTransaksi.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Pilih transaksi dari tabel terlebih dahulu!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(this, "Yakin ingin menghapus transaksi ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            dao.delete(selectedIdTransaksi);
            JOptionPane.showMessageDialog(this, "Transaksi berhasil dihapus!");
            selectedIdTransaksi = "";
            loadTable();
        }
    }//GEN-LAST:event_HapusMouseClicked

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
        java.awt.EventQueue.invokeLater(() -> new KelolaTransaksiView().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Hapus;
    private javax.swing.JTable TabelTransaksi;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
