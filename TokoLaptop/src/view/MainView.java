package view;

import javax.swing.*;

public class MainView extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MainView.class.getName());

    public MainView() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Manajemen Toko Laptop");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        KelolaLaptop = new javax.swing.JButton();
        KelolaPelanggan = new javax.swing.JButton();
        BuatTransaksi = new javax.swing.JButton();
        KelolaTransaksi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        jLabel1.setText("MANAJEMEN TOKO LAPTOP");

        KelolaLaptop.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        KelolaLaptop.setText("Kelola Laptop");
        KelolaLaptop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                KelolaLaptopMouseClicked(evt);
            }
        });

        KelolaPelanggan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        KelolaPelanggan.setText("Kelola Pelanggan");
        KelolaPelanggan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                KelolaPelangganMouseClicked(evt);
            }
        });

        BuatTransaksi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        BuatTransaksi.setText("Buat Transaksi");
        BuatTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BuatTransaksiMouseClicked(evt);
            }
        });

        KelolaTransaksi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        KelolaTransaksi.setText("Kelola Transaksi");
        KelolaTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                KelolaTransaksiMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                    .addComponent(KelolaLaptop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(KelolaPelanggan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BuatTransaksi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(KelolaTransaksi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(KelolaLaptop, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(KelolaPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BuatTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(KelolaTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void KelolaLaptopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KelolaLaptopMouseClicked
        new LaptopView().setVisible(true);
    }//GEN-LAST:event_KelolaLaptopMouseClicked

    private void KelolaPelangganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KelolaPelangganMouseClicked
        new PelangganView().setVisible(true);
    }//GEN-LAST:event_KelolaPelangganMouseClicked

    private void BuatTransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BuatTransaksiMouseClicked
        new BuatTransaksiView().setVisible(true);
    }//GEN-LAST:event_BuatTransaksiMouseClicked

    private void KelolaTransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KelolaTransaksiMouseClicked
        new KelolaTransaksiView().setVisible(true);
    }//GEN-LAST:event_KelolaTransaksiMouseClicked

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
        java.awt.EventQueue.invokeLater(() -> new MainView().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BuatTransaksi;
    private javax.swing.JButton KelolaLaptop;
    private javax.swing.JButton KelolaPelanggan;
    private javax.swing.JButton KelolaTransaksi;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
