package com.mycompany.kasir;

import java.awt.Color;
import javax.swing.*;
import java.net.*;
public class Dashboard extends JFrame {

    public Dashboard() {
        initComponents();
        panelbulat2.setDiameter(70);
        panelbulat2.setBackground(new Color(0xC6C6C6));
        
        tombol_dashb.setContentAreaFilled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tombol_dashb = new javax.swing.JButton();
        panelbulat2 = new com.mycompany.kasir.panelbulat();
        tombol_karyawan = new javax.swing.JButton();
        tombol_produk = new javax.swing.JButton();
        tombol_rekapan = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        tombol_penjualan = new javax.swing.JButton();
        foto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(2026, 1440));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, -1, -1));

        tombol_dashb.setBackground(new java.awt.Color(255, 255, 255));
        tombol_dashb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgdb.png"))); // NOI18N
        tombol_dashb.setBorder(null);
        tombol_dashb.setBorderPainted(false);
        tombol_dashb.setPreferredSize(new java.awt.Dimension(50, 50));
        tombol_dashb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombol_dashbActionPerformed(evt);
            }
        });
        getContentPane().add(tombol_dashb, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 50, -1));
        tombol_dashb.getAccessibleContext().setAccessibleName("J");

        getContentPane().add(panelbulat2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 70, 70));

        tombol_karyawan.setText("jButton2");
        tombol_karyawan.setMinimumSize(new java.awt.Dimension(50, 50));
        tombol_karyawan.setPreferredSize(new java.awt.Dimension(50, 50));
        tombol_karyawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombol_karyawanActionPerformed(evt);
            }
        });
        getContentPane().add(tombol_karyawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, -1, -1));

        tombol_produk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgdb.png"))); // NOI18N
        tombol_produk.setPreferredSize(new java.awt.Dimension(50, 50));
        tombol_produk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombol_produkActionPerformed(evt);
            }
        });
        getContentPane().add(tombol_produk, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, -1));

        tombol_rekapan.setText("jButton2");
        tombol_rekapan.setMinimumSize(new java.awt.Dimension(50, 50));
        tombol_rekapan.setPreferredSize(new java.awt.Dimension(50, 50));
        tombol_rekapan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombol_rekapanActionPerformed(evt);
            }
        });
        getContentPane().add(tombol_rekapan, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, -1, -1));

        jButton6.setText("jButton2");
        jButton6.setMinimumSize(new java.awt.Dimension(50, 50));
        jButton6.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 570, -1, -1));

        jButton7.setText("jButton2");
        jButton7.setMinimumSize(new java.awt.Dimension(50, 50));
        jButton7.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 640, -1, -1));

        jButton8.setText("jButton2");
        jButton8.setMinimumSize(new java.awt.Dimension(50, 50));
        jButton8.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 710, -1, -1));

        tombol_penjualan.setBackground(new java.awt.Color(158, 158, 158));
        tombol_penjualan.setForeground(new java.awt.Color(153, 153, 153));
        tombol_penjualan.setText("jButton2");
        tombol_penjualan.setMinimumSize(new java.awt.Dimension(50, 50));
        tombol_penjualan.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(tombol_penjualan, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, -1, -1));

        URL url = getClass().getResource("komponen/Main.png");
        foto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Main.png"))); // NOI18N
        foto.setText("jLabel2");
        getContentPane().add(foto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1733, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tombol_produkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombol_produkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tombol_produkActionPerformed

    private void tombol_karyawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombol_karyawanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tombol_karyawanActionPerformed

    private void tombol_dashbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombol_dashbActionPerformed
        System.out.println("H");
    }//GEN-LAST:event_tombol_dashbActionPerformed

    private void tombol_rekapanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombol_rekapanActionPerformed

    }//GEN-LAST:event_tombol_rekapanActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel foto;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JPanel jPanel1;
    private com.mycompany.kasir.panelbulat panelbulat2;
    private javax.swing.JButton tombol_dashb;
    private javax.swing.JButton tombol_karyawan;
    private javax.swing.JButton tombol_penjualan;
    private javax.swing.JButton tombol_produk;
    private javax.swing.JButton tombol_rekapan;
    // End of variables declaration//GEN-END:variables
}
