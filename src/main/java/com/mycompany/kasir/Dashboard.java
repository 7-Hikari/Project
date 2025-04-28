package com.mycompany.kasir;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.net.*;
import java.awt.*;

public class Dashboard extends JFrame {

    private JButton tombol = null;
    private Border asbor;

    public Dashboard() {
        initComponents();
        
        bulatan.setDiameter(70);
        asbor = tombol_dashb.getBorder();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tombol_karyawan = new javax.swing.JButton();
        tombol_produk = new javax.swing.JButton();
        tombol_rekapan = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        tombol_penjualan = new javax.swing.JButton();
        tombol_dashb = new javax.swing.JButton();
        bulatan = new com.mycompany.kasir.panelbulat();
        foto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(2026, 1440));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tombol_karyawan.setText("jButton2");
        tombol_karyawan.setMinimumSize(new java.awt.Dimension(50, 50));
        tombol_karyawan.setPreferredSize(new java.awt.Dimension(50, 50));
        tombol_karyawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombol_karyawanActionPerformed(evt);
            }
        });
        getContentPane().add(tombol_karyawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, -1, -1));

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
        getContentPane().add(tombol_rekapan, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, -1, -1));

        jButton6.setText("jButton2");
        jButton6.setMinimumSize(new java.awt.Dimension(50, 50));
        jButton6.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 580, -1, -1));

        jButton7.setText("jButton2");
        jButton7.setMinimumSize(new java.awt.Dimension(50, 50));
        jButton7.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 650, -1, -1));

        jButton8.setText("jButton2");
        jButton8.setMinimumSize(new java.awt.Dimension(50, 50));
        jButton8.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 720, -1, -1));

        tombol_penjualan.setBackground(new java.awt.Color(158, 158, 158));
        tombol_penjualan.setForeground(new java.awt.Color(153, 153, 153));
        tombol_penjualan.setText("jButton2");
        tombol_penjualan.setMinimumSize(new java.awt.Dimension(50, 50));
        tombol_penjualan.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(tombol_penjualan, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, -1, -1));

        tombol_dashb.setBackground(new java.awt.Color(255, 255, 255));
        tombol_dashb.setForeground(null);
        tombol_dashb.setForeground(new java.awt.Color(0, 255, 255));
        tombol_dashb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgdb.png"))); // NOI18N
        tombol_dashb.setBorder(null);
        tombol_dashb.setContentAreaFilled(false);
        tombol_dashb.setFocusPainted(false);
        tombol_dashb.setFocusable(false);
        tombol_dashb.setRequestFocusEnabled(false);
        tombol_dashb.setVerifyInputWhenFocusTarget(false);
        tombol_dashb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombol_dashbActionPerformed(evt);
            }
        });
        getContentPane().add(tombol_dashb, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 50, 50));

        bulatan.setBackground(new java.awt.Color(255, 255, 255));
        bulatan.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout bulatanlayout = new javax.swing.GroupLayout(bulatan);
        bulatan.setLayout(bulatanlayout);
        bulatanlayout.setHorizontalGroup(
            bulatanlayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );
        bulatanlayout.setVerticalGroup(
            bulatanlayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        getContentPane().add(bulatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 70, 70));

        URL url = getClass().getResource("komponen/Main.png");
        foto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Main.png"))); // NOI18N
        foto.setText("jLabel2");
        getContentPane().add(foto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1733, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tombol_produkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombol_produkActionPerformed
        interaksipanel(tombol_produk);
    }//GEN-LAST:event_tombol_produkActionPerformed

    private void tombol_karyawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombol_karyawanActionPerformed
        interaksipanel(tombol_karyawan);
    }//GEN-LAST:event_tombol_karyawanActionPerformed

    private void tombol_dashbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombol_dashbActionPerformed
        interaksipanel(tombol_dashb);
    }//GEN-LAST:event_tombol_dashbActionPerformed

    private void tombol_rekapanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombol_rekapanActionPerformed
        interaksipanel(tombol_rekapan);
    }//GEN-LAST:event_tombol_rekapanActionPerformed

    private void interaksipanel(JButton ba_en) {
        ba_en.setContentAreaFilled(false);

        int targetY = ba_en.getY() + (ba_en.getHeight() - bulatan.getHeight()) / 2;
        int startY = bulatan.getY();
        int selisih = Math.abs(targetY - startY);
        int langkah_a = Math.max(2, selisih / 15);
        int langkah = langkah_a * ((targetY > startY) ? 1 : -1);

        Timer waktu = new Timer(10, null);
        waktu.addActionListener(new ActionListener() {
            int y = startY;

            @Override
            public void actionPerformed(ActionEvent e) {
                if ((langkah > 0 && y < targetY) || (langkah < 0 && y > targetY)) {
                    y += langkah;
                    bulatan.setLocation(bulatan.getX(), y);
                    bulatan.repaint();
                } else {
                    bulatan.setLocation(bulatan.getX(), targetY);
                    waktu.stop();
                }
            }
        });
        waktu.start();
        if (tombol != null) {
            tombol.setContentAreaFilled(true);
            tombol.setBorder(asbor);
        }
        ba_en.setContentAreaFilled(false);
        ba_en.setBorder(asbor);
        tombol = ba_en;
    }

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
    private com.mycompany.kasir.panelbulat bulatan;
    private javax.swing.JLabel foto;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton tombol_dashb;
    private javax.swing.JButton tombol_karyawan;
    private javax.swing.JButton tombol_penjualan;
    private javax.swing.JButton tombol_produk;
    private javax.swing.JButton tombol_rekapan;
    // End of variables declaration//GEN-END:variables
}
