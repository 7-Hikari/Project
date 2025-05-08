package com.mycompany.kasir;

import DataMaster.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.net.*;

public class Dashboard extends JFrame {
    
    komponen.koordinat rekap = new komponen.koordinat();
    private JButton tombol = null;
    private Border asbor;

    public Dashboard() {
        initComponents();
        bulatan.setBackground(Color.WHITE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tombol_karyawan = new javax.swing.JButton();
        tombol_produk = new javax.swing.JButton();
        tombol_rekapan = new javax.swing.JButton();
        tombol_penjualan = new javax.swing.JButton();
        tombol_dashb = new javax.swing.JButton();
        bulatan = new komponen.PanelBulat();
        panelRound1 = new komponen.PanelRound();
        LabelJudul = new javax.swing.JLabel();
        panelnyaPanel = new komponen.PanelRound();
        panelubah = new komponen.PanelRound();
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
        getContentPane().add(tombol_karyawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 660, -1, -1));

        tombol_produk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Produk.png"))); // NOI18N
        tombol_produk.setPreferredSize(new java.awt.Dimension(50, 50));
        tombol_produk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombol_produkActionPerformed(evt);
            }
        });
        getContentPane().add(tombol_produk, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, -1, -1));

        tombol_rekapan.setText("jButton2");
        tombol_rekapan.setMinimumSize(new java.awt.Dimension(50, 50));
        tombol_rekapan.setPreferredSize(new java.awt.Dimension(50, 50));
        tombol_rekapan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombol_rekapanActionPerformed(evt);
            }
        });
        getContentPane().add(tombol_rekapan, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, -1, -1));

        tombol_penjualan.setBackground(new java.awt.Color(158, 158, 158));
        tombol_penjualan.setForeground(new java.awt.Color(153, 153, 153));
        tombol_penjualan.setText("jButton2");
        tombol_penjualan.setMinimumSize(new java.awt.Dimension(50, 50));
        tombol_penjualan.setPreferredSize(new java.awt.Dimension(50, 50));
        tombol_penjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombol_penjualanActionPerformed(evt);
            }
        });
        getContentPane().add(tombol_penjualan, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, -1, -1));

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

        javax.swing.GroupLayout bulatanLayout = new javax.swing.GroupLayout(bulatan);
        bulatan.setLayout(bulatanLayout);
        bulatanLayout.setHorizontalGroup(
            bulatanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );
        bulatanLayout.setVerticalGroup(
            bulatanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        getContentPane().add(bulatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, -1));

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));
        panelRound1.setRequestFocusEnabled(false);
        panelRound1.setRoundBottomLeft(80);
        panelRound1.setRoundBottomRight(80);
        panelRound1.setRoundTopLeft(80);
        panelRound1.setRoundTopRight(80);

        LabelJudul.setForeground(new java.awt.Color(0, 0, 0));
        LabelJudul.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addContainerGap(241, Short.MAX_VALUE)
                .addComponent(LabelJudul, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(201, 201, 201))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabelJudul, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 900, 70));

        panelnyaPanel.setBackground(new java.awt.Color(51, 255, 255));
        panelnyaPanel.setMaximumSize(new java.awt.Dimension(1270, 670));
        panelnyaPanel.setMinimumSize(new java.awt.Dimension(1270, 670));
        panelnyaPanel.setPreferredSize(new java.awt.Dimension(1270, 670));
        panelnyaPanel.setRoundBottomLeft(80);
        panelnyaPanel.setRoundBottomRight(80);
        panelnyaPanel.setRoundTopLeft(80);
        panelnyaPanel.setRoundTopRight(80);

        panelubah.setRoundBottomLeft(100);
        panelubah.setRoundBottomRight(100);
        panelubah.setRoundTopLeft(100);
        panelubah.setRoundTopRight(100);
        panelubah.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout panelnyaPanelLayout = new javax.swing.GroupLayout(panelnyaPanel);
        panelnyaPanel.setLayout(panelnyaPanelLayout);
        panelnyaPanelLayout.setHorizontalGroup(
            panelnyaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelnyaPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelubah, javax.swing.GroupLayout.PREFERRED_SIZE, 1260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelnyaPanelLayout.setVerticalGroup(
            panelnyaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelnyaPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelubah, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(panelnyaPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 150, 1270, 670));

        URL url = getClass().getResource("komponen/Main.png");
        foto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Main.png"))); // NOI18N
        foto.setText("jLabel2");
        getContentPane().add(foto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1733, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tombol_produkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombol_produkActionPerformed
        interaksipanel(tombol_produk);
        panelubah.removeAll();
        panelubah.add(new Dataprodukproduk(), BorderLayout.CENTER);
        panelubah.revalidate();
        panelubah.repaint();
    }//GEN-LAST:event_tombol_produkActionPerformed

    private void tombol_karyawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombol_karyawanActionPerformed
        interaksipanel(tombol_karyawan);
    }//GEN-LAST:event_tombol_karyawanActionPerformed

    private void tombol_dashbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombol_dashbActionPerformed
        interaksipanel(tombol_dashb);
        panelubah.removeAll();
        panelubah.revalidate();
        panelubah.repaint();
    }//GEN-LAST:event_tombol_dashbActionPerformed

    private void tombol_rekapanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombol_rekapanActionPerformed
        interaksipanel(tombol_rekapan);
        panelubah.removeAll();
        panelubah.revalidate();
        panelubah.repaint();
    }//GEN-LAST:event_tombol_rekapanActionPerformed

    private void tombol_penjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombol_penjualanActionPerformed
        interaksipanel(tombol_penjualan);
        panelubah.removeAll();
        panelubah.add(new KasirPenjualan(), BorderLayout.CENTER);
        panelubah.revalidate();
        panelubah.repaint();
    }//GEN-LAST:event_tombol_penjualanActionPerformed

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
    private javax.swing.JLabel LabelJudul;
    private komponen.PanelBulat bulatan;
    private javax.swing.JLabel foto;
    private komponen.PanelRound panelRound1;
    private komponen.PanelRound panelnyaPanel;
    private komponen.PanelRound panelubah;
    private javax.swing.JButton tombol_dashb;
    private javax.swing.JButton tombol_karyawan;
    private javax.swing.JButton tombol_penjualan;
    private javax.swing.JButton tombol_produk;
    private javax.swing.JButton tombol_rekapan;
    // End of variables declaration//GEN-END:variables
}
