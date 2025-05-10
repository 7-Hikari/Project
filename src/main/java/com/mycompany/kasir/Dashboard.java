package com.mycompany.kasir;

import DataMaster.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import java.util.HashMap;
import java.util.Map;

public class Dashboard extends JFrame {
    
    private int yBulatan = -1;
    private Map<JButton, ImageIcon[]> iconMap = new HashMap<>();

    public Dashboard() {
        initComponents();
        bulatan.setBackground(Color.WHITE);
        
        
        
        iconMap.put(tombol_dashb, new ImageIcon[]{new ImageIcon(getClass().getResource("/Dashb.png")), new ImageIcon(getClass().getResource("/imgdb.png"))});
        iconMap.put(tombol_Pembelian, new ImageIcon[]{new ImageIcon(getClass().getResource("/Pembelian.png")), new ImageIcon(getClass().getResource("/Pembelian_on.png"))});
//        iconMap.put(tombol_penjualan, new ImageIcon[]{iconNormal3, iconAktif3});
        iconMap.put(tombol_produk, new ImageIcon[]{new ImageIcon(getClass().getResource("/Produk.png")), new ImageIcon(getClass().getResource("/Produk_on.png"))});
        iconMap.put(tombol_rekapan, new ImageIcon[]{new ImageIcon(getClass().getResource("/Rekap.png")), new ImageIcon(getClass().getResource("/Rekap_on.png"))});
        yBulatan = bulatan.getY();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelNavigasi = new javax.swing.JPanel();
        tombol_Pembelian = new javax.swing.JButton();
        tombol_produk = new javax.swing.JButton();
        tombol_rekapan = new javax.swing.JButton();
        tombol_penjualan = new javax.swing.JButton();
        tombol_dashb = new javax.swing.JButton();
        bulatan = new komponen.PanelBulat();
        panelRound1 = new komponen.PanelRound();
        LabelJudul = new javax.swing.JLabel();
        panelnyaPanel = new komponen.PanelRound();
        panelubah = new komponen.PanelRound();
        Toko = new javax.swing.JLabel();
        foto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1440, 900));
        setMinimumSize(new java.awt.Dimension(1440, 900));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelNavigasi.setMaximumSize(new java.awt.Dimension(110, 650));
        panelNavigasi.setOpaque(false);
        panelNavigasi.setLayout(null);

        tombol_Pembelian.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pembelian.png"))); // NOI18N
        tombol_Pembelian.setContentAreaFilled(false);
        tombol_Pembelian.setMinimumSize(new java.awt.Dimension(50, 50));
        tombol_Pembelian.setPreferredSize(new java.awt.Dimension(50, 50));
        tombol_Pembelian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombol_PembelianActionPerformed(evt);
            }
        });
        panelNavigasi.add(tombol_Pembelian);
        tombol_Pembelian.setBounds(20, 410, 50, 50);

        tombol_produk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Produk.png"))); // NOI18N
        tombol_produk.setContentAreaFilled(false);
        tombol_produk.setPreferredSize(new java.awt.Dimension(50, 50));
        tombol_produk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombol_produkActionPerformed(evt);
            }
        });
        panelNavigasi.add(tombol_produk);
        tombol_produk.setBounds(20, 130, 50, 50);

        tombol_rekapan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rekap.png"))); // NOI18N
        tombol_rekapan.setContentAreaFilled(false);
        tombol_rekapan.setMinimumSize(new java.awt.Dimension(50, 50));
        tombol_rekapan.setPreferredSize(new java.awt.Dimension(50, 50));
        tombol_rekapan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombol_rekapanActionPerformed(evt);
            }
        });
        panelNavigasi.add(tombol_rekapan);
        tombol_rekapan.setBounds(20, 540, 50, 50);

        tombol_penjualan.setBackground(new java.awt.Color(158, 158, 158));
        tombol_penjualan.setForeground(new java.awt.Color(153, 153, 153));
        tombol_penjualan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Penjualan.png"))); // NOI18N
        tombol_penjualan.setContentAreaFilled(false);
        tombol_penjualan.setMinimumSize(new java.awt.Dimension(50, 50));
        tombol_penjualan.setPreferredSize(new java.awt.Dimension(50, 50));
        tombol_penjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombol_penjualanActionPerformed(evt);
            }
        });
        panelNavigasi.add(tombol_penjualan);
        tombol_penjualan.setBounds(20, 240, 50, 50);

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
        panelNavigasi.add(tombol_dashb);
        tombol_dashb.setBounds(20, 30, 50, 50);

        bulatan.setBackground(new java.awt.Color(255, 255, 255));

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

        panelNavigasi.add(bulatan);
        bulatan.setBounds(10, 20, 70, 70);

        getContentPane().add(panelNavigasi, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 110, 630));

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
                .addComponent(LabelJudul, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, 900, 90));

        panelnyaPanel.setBackground(new java.awt.Color(51, 255, 255));
        panelnyaPanel.setMaximumSize(new java.awt.Dimension(1270, 670));
        panelnyaPanel.setMinimumSize(new java.awt.Dimension(1270, 670));
        panelnyaPanel.setPreferredSize(new java.awt.Dimension(1270, 670));
        panelnyaPanel.setRoundBottomLeft(80);
        panelnyaPanel.setRoundBottomRight(80);
        panelnyaPanel.setRoundTopLeft(80);
        panelnyaPanel.setRoundTopRight(80);

        panelubah.setMaximumSize(new java.awt.Dimension(1250, 650));
        panelubah.setMinimumSize(new java.awt.Dimension(1250, 650));
        panelubah.setPreferredSize(new java.awt.Dimension(1250, 650));
        panelubah.setRoundBottomLeft(100);
        panelubah.setRoundBottomRight(100);
        panelubah.setRoundTopLeft(100);
        panelubah.setRoundTopRight(100);
        panelubah.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout panelnyaPanelLayout = new javax.swing.GroupLayout(panelnyaPanel);
        panelnyaPanel.setLayout(panelnyaPanelLayout);
        panelnyaPanelLayout.setHorizontalGroup(
            panelnyaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1270, Short.MAX_VALUE)
            .addGroup(panelnyaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelnyaPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelubah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        panelnyaPanelLayout.setVerticalGroup(
            panelnyaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 670, Short.MAX_VALUE)
            .addGroup(panelnyaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelnyaPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelubah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        getContentPane().add(panelnyaPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 1270, 670));

        Toko.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Toko.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Papoy.png"))); // NOI18N
        getContentPane().add(Toko, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 160, 130));

        URL url = getClass().getResource("komponen/Main.png");
        foto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        foto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Desktop.png"))); // NOI18N
        getContentPane().add(foto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1440, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tombol_produkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombol_produkActionPerformed
        interaksipanel(tombol_produk);
        panelubah.removeAll();
        panelubah.add(new Dataprodukproduk(), BorderLayout.CENTER);
        panelubah.revalidate();
        panelubah.repaint();
    }//GEN-LAST:event_tombol_produkActionPerformed

    private void tombol_PembelianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombol_PembelianActionPerformed
        interaksipanel(tombol_Pembelian);
    }//GEN-LAST:event_tombol_PembelianActionPerformed

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
        panelubah.add(new Penjualan(), BorderLayout.CENTER);
        panelubah.revalidate();
        panelubah.repaint();
    }//GEN-LAST:event_tombol_penjualanActionPerformed

    private void interaksipanel(JButton ba_en) {
        
        int targetY = ba_en.getY() + (ba_en.getHeight() - bulatan.getHeight()) / 2;
        
        if (targetY == yBulatan) {
        updateTombolAktif(ba_en);
        return;
    }
        int startY = yBulatan;
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
                    yBulatan = targetY;
                    waktu.stop();
                    updateTombolAktif(ba_en);
                }
            }
        });
        waktu.start();
        updateTombolNonAktif(ba_en);
    }
    
    private void updateTombolAktif(JButton aktif) {
        ImageIcon[] icons = iconMap.get(aktif);
        if (icons != null) {
            aktif.setIcon(icons[1]);
        }
    }

    private void updateTombolNonAktif(JButton aktif) {
        for (Map.Entry<JButton, ImageIcon[]> entry : iconMap.entrySet()) {
            JButton btn = entry.getKey();
            if (btn != aktif) {
                btn.setIcon(entry.getValue()[0]);
            }
        }
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
    private javax.swing.JLabel Toko;
    private komponen.PanelBulat bulatan;
    private javax.swing.JLabel foto;
    private javax.swing.JPanel panelNavigasi;
    private komponen.PanelRound panelRound1;
    private komponen.PanelRound panelnyaPanel;
    private komponen.PanelRound panelubah;
    private javax.swing.JButton tombol_Pembelian;
    private javax.swing.JButton tombol_dashb;
    private javax.swing.JButton tombol_penjualan;
    private javax.swing.JButton tombol_produk;
    private javax.swing.JButton tombol_rekapan;
    // End of variables declaration//GEN-END:variables
}
