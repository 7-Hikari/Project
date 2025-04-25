package com.mycompany.kasir;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;

public class Dashboard extends JFrame {

    private JButton tombol = null;
    private final panelbulat bulatan = new panelbulat(70);

    public Dashboard() {
        initComponents();
        bulatan.setBackground(Color.WHITE);
        navbar.add(bulatan);

        tombol_dashb.setBorder(UIManager.getBorder("Button.border"));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        navbar = new javax.swing.JPanel();
        tombol_dashb = new javax.swing.JButton();
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

        navbar.setLayout(null);

        tombol_dashb.setBackground(new java.awt.Color(255, 255, 255));
        tombol_dashb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgdb.png"))); // NOI18N
        tombol_dashb.setBorder(null);
        tombol_dashb.setBorderPainted(false);
        tombol_dashb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombol_dashbActionPerformed(evt);
            }
        });
        navbar.add(tombol_dashb);
        tombol_dashb.setBounds(10, 5, 50, 50);
        bulatan.setBounds(0, 5,150, 150);
        navbar.add(bulatan);

        tombol_karyawan.setText("jButton2");
        tombol_karyawan.setMinimumSize(new java.awt.Dimension(50, 50));
        tombol_karyawan.setPreferredSize(new java.awt.Dimension(50, 50));
        tombol_karyawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombol_karyawanActionPerformed(evt);
            }
        });
        navbar.add(tombol_karyawan);
        tombol_karyawan.setBounds(10, 60, 50, 50);

        tombol_produk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgdb.png"))); // NOI18N
        tombol_produk.setPreferredSize(new java.awt.Dimension(50, 50));
        tombol_produk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombol_produkActionPerformed(evt);
            }
        });
        navbar.add(tombol_produk);
        tombol_produk.setBounds(10, 115, 50, 50);

        tombol_rekapan.setText("jButton2");
        tombol_rekapan.setMinimumSize(new java.awt.Dimension(50, 50));
        tombol_rekapan.setPreferredSize(new java.awt.Dimension(50, 50));
        tombol_rekapan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombol_rekapanActionPerformed(evt);
            }
        });
        navbar.add(tombol_rekapan);
        tombol_rekapan.setBounds(10, 170, 50, 50);

        jButton6.setText("jButton2");
        jButton6.setMinimumSize(new java.awt.Dimension(50, 50));
        jButton6.setPreferredSize(new java.awt.Dimension(50, 50));
        navbar.add(jButton6);
        jButton6.setBounds(10, 225, 50, 50);

        jButton7.setText("jButton2");
        jButton7.setMinimumSize(new java.awt.Dimension(50, 50));
        jButton7.setPreferredSize(new java.awt.Dimension(50, 50));
        navbar.add(jButton7);
        jButton7.setBounds(10, 280, 50, 50);

        jButton8.setText("jButton2");
        jButton8.setMinimumSize(new java.awt.Dimension(50, 50));
        jButton8.setPreferredSize(new java.awt.Dimension(50, 50));
        navbar.add(jButton8);
        jButton8.setBounds(10, 335, 50, 50);

        tombol_penjualan.setBackground(new java.awt.Color(158, 158, 158));
        tombol_penjualan.setForeground(new java.awt.Color(153, 153, 153));
        tombol_penjualan.setText("jButton2");
        tombol_penjualan.setMinimumSize(new java.awt.Dimension(50, 50));
        tombol_penjualan.setPreferredSize(new java.awt.Dimension(50, 50));
        navbar.add(tombol_penjualan);
        tombol_penjualan.setBounds(10, 390, 50, 50);

        getContentPane().add(navbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 70, 580));

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

        System.out.println("ukuran H = " + bulatan.getHeight());
        System.out.println("ukuran W = " + bulatan.getWidth());
        System.out.println("start Y = " + startY);
        System.out.println("Y = " + tombol_produk.getY());
        System.out.println("X = " + tombol_produk.getX());
        System.out.println("tujuan = " + ba_en.getY());

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
            tombol.setBorder(UIManager.getBorder("Button.border"));
        }
        ba_en.setContentAreaFilled(false);
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
    private javax.swing.JLabel foto;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JPanel navbar;
    private javax.swing.JButton tombol_dashb;
    private javax.swing.JButton tombol_karyawan;
    private javax.swing.JButton tombol_penjualan;
    private javax.swing.JButton tombol_produk;
    private javax.swing.JButton tombol_rekapan;
    // End of variables declaration//GEN-END:variables
}
