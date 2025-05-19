package DataMaster;

import DAO.*;
import Rekapan.Rekapan;
import Transaksi.KasirPenjualan;
import Transaksi.Penjualan;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import komponen.PanelRound;

public class Dashboard extends JFrame {

    private int yBulatan = -1;
    private final Map<JButton, ImageIcon[]> iconMap = new HashMap<>();
    private final Map<String, Set<JButton>> RoleAkses = new HashMap<>();

    private userObjek.Status status;
    private userData loginUser;

    private void Access() {
        RoleAkses.put("Pelanggan", Set.of(tombol_Penjualan));
        RoleAkses.put("Karyawan", Set.of(tombol_dashb, tombol_Penjualan, tombol_Kasir));
        Set<JButton> Boundless = Set.of(
                tombol_Kasir, tombol_Pembelian, tombol_Penjualan,
                tombol_dashb, tombol_produk, tombol_rekapan);
        RoleAkses.put("Pemilik", Boundless);
        RoleAkses.put("SuperAdmin", Boundless);
    }

    private boolean HakAkses(JButton x) {
        String role = (status == null) ? "Pelanggan" : status.toString();
        Set<JButton> akses = RoleAkses.get(role);
        if (akses == null || !akses.contains(x)) {
            JOptionPane.showMessageDialog(this, "Anda tidak memiliki akses", "Peringatan!", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

    public Dashboard(userData login) {
        this.loginUser = login;
        this.status = loginUser.getStatus();

        initComponents();
        panelBulat1.setDiameter(90);
        panelBulat1.revalidate();
        panelBulat1.repaint();
        panelBulat1.add(jLabel7);
        panelnyaPanel.setGradientDirection(PanelRound.Direction.VERTICAL);
        panelnyaPanel.setGradient(new Color(0x2CBAC6), new Color(0x48A3EE));
        panelubah.setGradientDirection(PanelRound.Direction.VERTICAL);
        panelubah.setGradient(new Color(0x2CBAC6), new Color(0x48A3EE));

        bulatan.setBackground(Color.WHITE);
        Access();

        iconMap.put(tombol_dashb, new ImageIcon[]{new ImageIcon(getClass().getResource("/Dashb.png")), new ImageIcon(getClass().getResource("/imgdb.png"))});
        iconMap.put(tombol_Pembelian, new ImageIcon[]{new ImageIcon(getClass().getResource("/Pembelian.png")), new ImageIcon(getClass().getResource("/Pembelian_on.png"))});
        iconMap.put(tombol_Kasir, new ImageIcon[]{new ImageIcon(getClass().getResource("/Kasir.png")), new ImageIcon(getClass().getResource("/Kasir_on.png"))});
        iconMap.put(tombol_Penjualan, new ImageIcon[]{new ImageIcon(getClass().getResource("/Jual.png")), new ImageIcon(getClass().getResource("/Jual_on.png"))});
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
        tombol_Kasir = new javax.swing.JButton();
        tombol_dashb = new javax.swing.JButton();
        tombol_Penjualan = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        bulatan = new komponen.PanelBulat();
        panelRounddashbord = new komponen.PanelRound();
        LabelJudul = new javax.swing.JLabel();
        panelnyaPanel = new komponen.PanelRound();
        panelubah = new komponen.PanelRound();
        Toko = new javax.swing.JLabel();
        panelBulat1 = new komponen.PanelBulat();
        jLabel7 = new javax.swing.JLabel();
        foto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/Papoy.png")).getImage());
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
        tombol_Pembelian.setBounds(20, 340, 50, 50);

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
        tombol_rekapan.setBounds(20, 530, 50, 50);

        tombol_Kasir.setBackground(new java.awt.Color(158, 158, 158));
        tombol_Kasir.setForeground(new java.awt.Color(153, 153, 153));
        tombol_Kasir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Kasir.png"))); // NOI18N
        tombol_Kasir.setContentAreaFilled(false);
        tombol_Kasir.setMinimumSize(new java.awt.Dimension(50, 50));
        tombol_Kasir.setPreferredSize(new java.awt.Dimension(50, 50));
        tombol_Kasir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombol_KasirActionPerformed(evt);
            }
        });
        panelNavigasi.add(tombol_Kasir);
        tombol_Kasir.setBounds(20, 230, 50, 50);

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

        tombol_Penjualan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Jual.png"))); // NOI18N
        tombol_Penjualan.setContentAreaFilled(false);
        tombol_Penjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombol_PenjualanActionPerformed(evt);
            }
        });
        panelNavigasi.add(tombol_Penjualan);
        tombol_Penjualan.setBounds(20, 440, 50, 50);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Rekapan");
        panelNavigasi.add(jLabel1);
        jLabel1.setBounds(10, 580, 70, 16);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Dashboard");
        panelNavigasi.add(jLabel2);
        jLabel2.setBounds(10, 100, 70, 16);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Produk");
        panelNavigasi.add(jLabel3);
        jLabel3.setBounds(10, 190, 70, 16);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Penjualan");
        panelNavigasi.add(jLabel4);
        jLabel4.setBounds(10, 490, 70, 16);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Pembelian");
        panelNavigasi.add(jLabel5);
        jLabel5.setBounds(10, 390, 70, 16);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Kasir");
        panelNavigasi.add(jLabel6);
        jLabel6.setBounds(10, 290, 70, 16);

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

        panelRounddashbord.setBackground(new java.awt.Color(255, 255, 255));
        panelRounddashbord.setRequestFocusEnabled(false);
        panelRounddashbord.setRoundBottomLeft(80);
        panelRounddashbord.setRoundBottomRight(80);
        panelRounddashbord.setRoundTopLeft(80);
        panelRounddashbord.setRoundTopRight(80);

        LabelJudul.setBackground(new java.awt.Color(0, 0, 0));
        LabelJudul.setFont(new java.awt.Font("Lucida Calligraphy", 1, 60)); // NOI18N
        LabelJudul.setForeground(new java.awt.Color(0, 0, 0));
        LabelJudul.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelJudul.setText("Dashboard");

        javax.swing.GroupLayout panelRounddashbordLayout = new javax.swing.GroupLayout(panelRounddashbord);
        panelRounddashbord.setLayout(panelRounddashbordLayout);
        panelRounddashbordLayout.setHorizontalGroup(
            panelRounddashbordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRounddashbordLayout.createSequentialGroup()
                .addContainerGap(241, Short.MAX_VALUE)
                .addComponent(LabelJudul, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(201, 201, 201))
        );
        panelRounddashbordLayout.setVerticalGroup(
            panelRounddashbordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRounddashbordLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabelJudul, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(panelRounddashbord, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, 900, 90));

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
            .addGroup(panelnyaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelubah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        panelnyaPanelLayout.setVerticalGroup(
            panelnyaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelnyaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelubah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        getContentPane().add(panelnyaPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 1270, 670));

        Toko.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Toko.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Papoy.png"))); // NOI18N
        getContentPane().add(Toko, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 160, 130));

        panelBulat1.setPreferredSize(new java.awt.Dimension(90, 90));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Add User.png"))); // NOI18N

        javax.swing.GroupLayout panelBulat1Layout = new javax.swing.GroupLayout(panelBulat1);
        panelBulat1.setLayout(panelBulat1Layout);
        panelBulat1Layout.setHorizontalGroup(
            panelBulat1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBulat1Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(17, 17, 17))
        );
        panelBulat1Layout.setVerticalGroup(
            panelBulat1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBulat1Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(19, 19, 19))
        );

        getContentPane().add(panelBulat1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 40, -1, 90));

        URL url = getClass().getResource("komponen/Main.png");
        foto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        foto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Desktop.png"))); // NOI18N
        getContentPane().add(foto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1440, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tombol_produkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombol_produkActionPerformed
        if (!HakAkses(tombol_produk)) {
            return;
        }
        interaksipanel(tombol_produk);
        LabelJudul.setText("Produk");
        panelubah.removeAll();
        panelubah.add(new Dataprodukproduk(), BorderLayout.CENTER);
        panelubah.revalidate();
        panelubah.repaint();
    }//GEN-LAST:event_tombol_produkActionPerformed

    private void tombol_PembelianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombol_PembelianActionPerformed
        if (!HakAkses(tombol_Pembelian)) {
            return;
        }
        interaksipanel(tombol_Pembelian);
        LabelJudul.setText("Pembelian");
        panelubah.removeAll();
        panelubah.add(new Datapembelianbahankulakan(), BorderLayout.CENTER);
        panelubah.revalidate();
        panelubah.repaint();
    }//GEN-LAST:event_tombol_PembelianActionPerformed

    private void tombol_dashbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombol_dashbActionPerformed
        if (!HakAkses(tombol_dashb)) {
            return;
        }
        interaksipanel(tombol_dashb);
        LabelJudul.setText("Dashboard");
        panelubah.removeAll();
        panelubah.revalidate();
        panelubah.repaint();
    }//GEN-LAST:event_tombol_dashbActionPerformed

    private void tombol_rekapanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombol_rekapanActionPerformed
        if (!HakAkses(tombol_rekapan)) {
            return;
        }
        interaksipanel(tombol_rekapan);
        LabelJudul.setText("Rekapan");
        panelubah.removeAll();
        panelubah.add(new Rekapan(), BorderLayout.CENTER);
        panelubah.revalidate();
        panelubah.repaint();
    }//GEN-LAST:event_tombol_rekapanActionPerformed

    private void tombol_KasirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombol_KasirActionPerformed
        if (!HakAkses(tombol_Kasir)) {
            return;
        }
        interaksipanel(tombol_Kasir);
        LabelJudul.setText("Kasir");
        panelubah.removeAll();
        panelubah.add(new KasirPenjualan(), BorderLayout.CENTER);
        panelubah.revalidate();
        panelubah.repaint();
    }//GEN-LAST:event_tombol_KasirActionPerformed

    private void tombol_PenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombol_PenjualanActionPerformed
        if (!HakAkses(tombol_Penjualan)) {
            return;
        }
        interaksipanel(tombol_Penjualan);
        LabelJudul.setText("Penjualan");
        panelubah.removeAll();
        panelubah.add(new Penjualan(), BorderLayout.CENTER);
        panelubah.revalidate();
        panelubah.repaint();
    }//GEN-LAST:event_tombol_PenjualanActionPerformed

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

        Timer waktu = new Timer(20, null);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelJudul;
    private javax.swing.JLabel Toko;
    private komponen.PanelBulat bulatan;
    private javax.swing.JLabel foto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private komponen.PanelBulat panelBulat1;
    private javax.swing.JPanel panelNavigasi;
    private komponen.PanelRound panelRounddashbord;
    private komponen.PanelRound panelnyaPanel;
    private komponen.PanelRound panelubah;
    private javax.swing.JButton tombol_Kasir;
    private javax.swing.JButton tombol_Pembelian;
    private javax.swing.JButton tombol_Penjualan;
    private javax.swing.JButton tombol_dashb;
    private javax.swing.JButton tombol_produk;
    private javax.swing.JButton tombol_rekapan;
    // End of variables declaration//GEN-END:variables
}
