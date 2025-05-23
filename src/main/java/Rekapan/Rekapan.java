package Rekapan;

import DAO.pesananData;
import DAO.transaksiObjek;
import DAO.rekapanData;
import java.awt.Color;
import java.awt.Component;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.Locale;
import javax.swing.*;

public class Rekapan extends komponen.PanelRound {
    private List<String> labels;
    private List<Number> values;
    private String selected;
    private rekapanData reDat;
    private int ttlPendapatan, labaKotor, pilihBulan;
    private final NumberFormat Rp = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
    
    String[] bulan = {
            "Januari", "Februari", "Maret", "April",
            "Mei", "Juni", "Juli", "Agustus",
            "September", "Oktober", "November", "Desember"
        };
    private void ambilTahun() {
        jCbTahun.setModel(new DefaultComboBoxModel<>(
                transaksiObjek.getTh().stream()
                        .map(String::valueOf)
                        .toArray(String[]::new)
        ));
    }
    
    public Rekapan() {
        initComponents();
        jCbBulan.setModel(new DefaultComboBoxModel<>(bulan));
        setGradient(new Color(0x2CBAC6), new Color(0x48A3EE));
        
        ambilTahun();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRingkas = new komponen.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        TotalProdukkeluar = new javax.swing.JTextField();
        Totaltransaksi = new javax.swing.JTextField();
        JmlUnggulan1 = new javax.swing.JTextField();
        NamaUnggulan1 = new javax.swing.JTextField();
        namaUnggulan2 = new javax.swing.JTextField();
        JmlUnggulan2 = new javax.swing.JTextField();
        namaUnggulan3 = new javax.swing.JTextField();
        JmlUnggulan3 = new javax.swing.JTextField();
        JmlPenTerendah = new javax.swing.JTextField();
        Totalpendapatan = new javax.swing.JTextField();
        Laba = new javax.swing.JTextField();
        NamaPenTerendah = new javax.swing.JTextField();
        jCbBulan = new javax.swing.JComboBox<>();
        ChartPenjualan = new komponen.PenjualanChartPanel();
        dasarChart = new komponen.PanelRound();
        jCbTahun = new javax.swing.JComboBox<>();
        Ekspor = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setGradientDirection(komponen.PanelRound.Direction.VERTICAL);
        setMaximumSize(new java.awt.Dimension(1250, 650));
        setMinimumSize(new java.awt.Dimension(1250, 650));
        setPreferredSize(new java.awt.Dimension(1250, 650));
        setRoundBottomLeft(100);
        setRoundBottomRight(100);
        setRoundTopLeft(100);
        setRoundTopRight(100);
        setSolid(false);
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRingkas.setBackground(new java.awt.Color(51, 204, 255));
        panelRingkas.setRoundBottomRight(100);
        panelRingkas.setRoundTopRight(100);
        panelRingkas.setSolid(true);

        jLabel1.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Total Transaksi ");

        jLabel2.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Total Produk Keluar");

        jLabel3.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Produk Unggulan");

        jLabel4.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Produk penjualan Terendah ");

        jLabel5.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Total Pendapatan");

        jLabel6.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Laba Kotor");

        TotalProdukkeluar.setEditable(false);
        TotalProdukkeluar.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        Totaltransaksi.setEditable(false);
        Totaltransaksi.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        JmlUnggulan1.setEditable(false);
        JmlUnggulan1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        NamaUnggulan1.setEditable(false);
        NamaUnggulan1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        namaUnggulan2.setEditable(false);
        namaUnggulan2.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        JmlUnggulan2.setEditable(false);
        JmlUnggulan2.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        namaUnggulan3.setEditable(false);
        namaUnggulan3.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        JmlUnggulan3.setEditable(false);
        JmlUnggulan3.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        JmlPenTerendah.setEditable(false);
        JmlPenTerendah.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        Totalpendapatan.setEditable(false);
        Totalpendapatan.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        Laba.setEditable(false);
        Laba.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        NamaPenTerendah.setEditable(false);
        NamaPenTerendah.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jCbBulan.setBackground(new java.awt.Color(51, 204, 255));
        jCbBulan.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jCbBulan.setForeground(new java.awt.Color(0, 0, 0));
        jCbBulan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jCbBulan.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                boolean isSelected, boolean cellHasFocus) {
                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                label.setHorizontalAlignment(SwingConstants.CENTER); // center text
                return label;
            }
        });
        jCbBulan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCbBulanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRingkasLayout = new javax.swing.GroupLayout(panelRingkas);
        panelRingkas.setLayout(panelRingkasLayout);
        panelRingkasLayout.setHorizontalGroup(
            panelRingkasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRingkasLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(panelRingkasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(namaUnggulan3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(namaUnggulan2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NamaUnggulan1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(181, Short.MAX_VALUE))
            .addGroup(panelRingkasLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRingkasLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(panelRingkasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRingkasLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(84, 84, 84))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRingkasLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(100, 100, 100))))
            .addGroup(panelRingkasLayout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRingkasLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(117, 117, 117))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRingkasLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(98, 98, 98))
            .addGroup(panelRingkasLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(panelRingkasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Laba, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TotalProdukkeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JmlUnggulan1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JmlUnggulan2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JmlUnggulan3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelRingkasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRingkasLayout.createSequentialGroup()
                            .addComponent(NamaPenTerendah, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JmlPenTerendah, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(Totalpendapatan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRingkasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jCbBulan, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Totaltransaksi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRingkasLayout.setVerticalGroup(
            panelRingkasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRingkasLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jCbBulan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Totaltransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(7, 7, 7)
                .addComponent(TotalProdukkeluar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelRingkasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JmlUnggulan1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NamaUnggulan1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRingkasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JmlUnggulan2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(namaUnggulan2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRingkasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JmlUnggulan3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(namaUnggulan3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(11, 11, 11)
                .addGroup(panelRingkasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JmlPenTerendah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NamaPenTerendah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addGap(5, 5, 5)
                .addComponent(Totalpendapatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(5, 5, 5)
                .addComponent(Laba, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        add(panelRingkas, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 20, 310, 580));

        ChartPenjualan.setAutoscrolls(true);
        ChartPenjualan.setBarColor(new java.awt.Color(0, 204, 255));
        add(ChartPenjualan, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 910, 540));

        dasarChart.setBackground(new java.awt.Color(51, 204, 255));
        dasarChart.setSolid(true);

        jCbTahun.setBackground(new java.awt.Color(51, 204, 255));
        jCbTahun.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jCbTahun.setForeground(new java.awt.Color(0, 0, 0));
        jCbTahun.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jCbTahun.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                boolean isSelected, boolean cellHasFocus) {
                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                label.setHorizontalAlignment(SwingConstants.CENTER); // center text
                return label;
            }
        });
        jCbTahun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCbTahunActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dasarChartLayout = new javax.swing.GroupLayout(dasarChart);
        dasarChart.setLayout(dasarChartLayout);
        dasarChartLayout.setHorizontalGroup(
            dasarChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dasarChartLayout.createSequentialGroup()
                .addGap(387, 387, 387)
                .addComponent(jCbTahun, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(390, Short.MAX_VALUE))
        );
        dasarChartLayout.setVerticalGroup(
            dasarChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dasarChartLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCbTahun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(545, Short.MAX_VALUE))
        );

        add(dasarChart, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 910, 580));

        Ekspor.setBackground(new java.awt.Color(0, 204, 102));
        Ekspor.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        Ekspor.setForeground(new java.awt.Color(0, 0, 0));
        Ekspor.setText("Ekspor");
        Ekspor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EksporActionPerformed(evt);
            }
        });
        add(Ekspor, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 610, 150, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void jCbTahunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCbTahunActionPerformed
        selected = (String) jCbTahun.getSelectedItem();
        pilihBulan = jCbBulan.getSelectedIndex()+1;

        if (selected != null && !selected.isEmpty()) {
            short tahun = Short.parseShort(selected);
            Map<String, Integer> data = transaksiObjek.getPenjualanRekap(tahun);
            labels = new ArrayList<>(data.keySet());
            values = new ArrayList<>(data.values());
            ChartPenjualan.setData(labels, values);
            if(pilihBulan >= 1)Ringkasan(pilihBulan, selected);
        }
    }//GEN-LAST:event_jCbTahunActionPerformed

    private void jCbBulanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCbBulanActionPerformed
        selected = (String) jCbTahun.getSelectedItem();
        pilihBulan = jCbBulan.getSelectedIndex()+1;
        if (selected != null && !selected.isEmpty() && pilihBulan >=1)Ringkasan(pilihBulan, selected);
    }//GEN-LAST:event_jCbBulanActionPerformed

    private void EksporActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EksporActionPerformed
        List<pesananData> dat = transaksiObjek.getJual(pilihBulan, selected);
        LaporanTransaksiExporter.exportToExcel(dat, reDat, (String) jCbBulan.getSelectedItem(), selected);
    }//GEN-LAST:event_EksporActionPerformed

    private void Ringkasan(int bulan, String tahun) {
        reDat = transaksiObjek.getRingkasanBulanan(bulan, tahun);
        
        ttlPendapatan = reDat.totalPendapatan;
        labaKotor = ttlPendapatan - reDat.totalPembelian;
        
        Totalpendapatan.setText(Rp.format(ttlPendapatan));
        Laba.setText(Rp.format(labaKotor));
        
        Totaltransaksi.setText(String.valueOf(reDat.totalTransaksi));
        TotalProdukkeluar.setText(String.valueOf(reDat.totalProdukKeluar));
        JmlPenTerendah.setText(String.valueOf(reDat.jumlahTerendah));
        NamaPenTerendah.setText(reDat.produkTerendah);
        
        JTextField[] namaFields = {NamaUnggulan1, namaUnggulan2, namaUnggulan3};
        JTextField[] jumlahFields = {JmlUnggulan1, JmlUnggulan2, JmlUnggulan3};

        for (int i = 0; i < 3; i++) {
            namaFields[i].setText(reDat.namaUnggulan[i] != null ? reDat.namaUnggulan[i] : "-");
            jumlahFields[i].setText(String.valueOf(reDat.jumlahUnggulan[i]));
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private komponen.PenjualanChartPanel ChartPenjualan;
    private javax.swing.JButton Ekspor;
    private javax.swing.JTextField JmlPenTerendah;
    private javax.swing.JTextField JmlUnggulan1;
    private javax.swing.JTextField JmlUnggulan2;
    private javax.swing.JTextField JmlUnggulan3;
    private javax.swing.JTextField Laba;
    private javax.swing.JTextField NamaPenTerendah;
    private javax.swing.JTextField NamaUnggulan1;
    private javax.swing.JTextField TotalProdukkeluar;
    private javax.swing.JTextField Totalpendapatan;
    private javax.swing.JTextField Totaltransaksi;
    private komponen.PanelRound dasarChart;
    private javax.swing.JComboBox<String> jCbBulan;
    private javax.swing.JComboBox<String> jCbTahun;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField namaUnggulan2;
    private javax.swing.JTextField namaUnggulan3;
    private komponen.PanelRound panelRingkas;
    // End of variables declaration//GEN-END:variables
}
