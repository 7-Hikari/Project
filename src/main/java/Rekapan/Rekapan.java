package Rekapan;

import java.awt.Color;
import javax.swing.SpinnerListModel;
import komponen.PanelRound;

public class Rekapan extends komponen.PanelRound {
    
    String[] bulan = {
            "Januari", "Februari", "Maret", "April",
            "Mei", "Juni", "Juli", "Agustus",
            "September", "Oktober", "November", "Desember"
        };
    
    public Rekapan() {
        initComponents();
        SpinBulan.setModel(new SpinnerListModel(bulan));
        setGradientDirection(PanelRound.Direction.VERTICAL);
        setGradient(new Color(0x2CBAC6), new Color(0x48A3EE));
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cetak = new javax.swing.JButton();
        panelRound1 = new komponen.PanelRound();
        SpinBulan = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        TotalProdukkeluar = new javax.swing.JTextField();
        Totaltransaksi = new javax.swing.JTextField();
        Unggulan2 = new javax.swing.JTextField();
        Unggulan1 = new javax.swing.JTextField();
        Unggulan3 = new javax.swing.JTextField();
        Unggulan4 = new javax.swing.JTextField();
        Unggulan5 = new javax.swing.JTextField();
        Unggulan6 = new javax.swing.JTextField();
        Produkpenjualanterendah = new javax.swing.JTextField();
        Totalpendapatan = new javax.swing.JTextField();
        Laba = new javax.swing.JTextField();
        penjualanChartPanel1 = new komponen.PenjualanChartPanel();
        panelRound2 = new komponen.PanelRound();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1250, 650));
        setMinimumSize(new java.awt.Dimension(1250, 650));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(1250, 650));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cetak.setBackground(new java.awt.Color(0, 204, 102));
        cetak.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        cetak.setForeground(new java.awt.Color(0, 0, 0));
        cetak.setText("Cetak");
        cetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cetakActionPerformed(evt);
            }
        });
        add(cetak, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 610, 140, 40));

        panelRound1.setBackground(new java.awt.Color(51, 204, 255));
        panelRound1.setRoundBottomRight(100);
        panelRound1.setRoundTopRight(100);
        panelRound1.setSolid(true);

        SpinBulan.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N

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
        jLabel6.setText("Laba");

        TotalProdukkeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TotalProdukkeluarActionPerformed(evt);
            }
        });

        Totaltransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TotaltransaksiActionPerformed(evt);
            }
        });

        Unggulan2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Unggulan2ActionPerformed(evt);
            }
        });

        Unggulan1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Unggulan1ActionPerformed(evt);
            }
        });

        Unggulan3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Unggulan3ActionPerformed(evt);
            }
        });

        Unggulan4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Unggulan4ActionPerformed(evt);
            }
        });

        Unggulan5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Unggulan5ActionPerformed(evt);
            }
        });

        Unggulan6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Unggulan6ActionPerformed(evt);
            }
        });

        Totalpendapatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TotalpendapatanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Unggulan5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Unggulan3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Unggulan1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(181, Short.MAX_VALUE))
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jLabel4))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(jLabel5)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(84, 84, 84))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(100, 100, 100))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(140, 140, 140))))
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(SpinBulan, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Laba, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Totalpendapatan, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Produkpenjualanterendah, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TotalProdukkeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Totaltransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Unggulan2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Unggulan4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Unggulan6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SpinBulan, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Unggulan2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Unggulan1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Unggulan4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Unggulan3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Unggulan6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Unggulan5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(11, 11, 11)
                .addComponent(Produkpenjualanterendah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Totalpendapatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Laba, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 20, 310, 580));
        add(penjualanChartPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 910, 580));

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        add(panelRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 100, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void cetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cetakActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cetakActionPerformed

    private void Unggulan6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Unggulan6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Unggulan6ActionPerformed

    private void Unggulan5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Unggulan5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Unggulan5ActionPerformed

    private void Unggulan4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Unggulan4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Unggulan4ActionPerformed

    private void Unggulan3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Unggulan3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Unggulan3ActionPerformed

    private void Unggulan1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Unggulan1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Unggulan1ActionPerformed

    private void Unggulan2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Unggulan2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Unggulan2ActionPerformed

    private void TotaltransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TotaltransaksiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TotaltransaksiActionPerformed

    private void TotalProdukkeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TotalProdukkeluarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TotalProdukkeluarActionPerformed

    private void TotalpendapatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TotalpendapatanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TotalpendapatanActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Laba;
    private javax.swing.JTextField Produkpenjualanterendah;
    private javax.swing.JSpinner SpinBulan;
    private javax.swing.JTextField TotalProdukkeluar;
    private javax.swing.JTextField Totalpendapatan;
    private javax.swing.JTextField Totaltransaksi;
    private javax.swing.JTextField Unggulan1;
    private javax.swing.JTextField Unggulan2;
    private javax.swing.JTextField Unggulan3;
    private javax.swing.JTextField Unggulan4;
    private javax.swing.JTextField Unggulan5;
    private javax.swing.JTextField Unggulan6;
    private javax.swing.JButton cetak;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private komponen.PanelRound panelRound1;
    private komponen.PanelRound panelRound2;
    private komponen.PenjualanChartPanel penjualanChartPanel1;
    // End of variables declaration//GEN-END:variables
}
