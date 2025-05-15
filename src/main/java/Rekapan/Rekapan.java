package Rekapan;

import javax.swing.SpinnerListModel;

public class Rekapan extends javax.swing.JPanel {
    
    String[] bulan = {
            "Januari", "Februari", "Maret", "April",
            "Mei", "Juni", "Juli", "Agustus",
            "September", "Oktober", "November", "Desember"
        };
    
    public Rekapan() {
        initComponents();
        SpinBulan.setModel(new SpinnerListModel(bulan));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cetak = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        SpinBulan = new javax.swing.JSpinner();
        penjualanChartPanel1 = new komponen.PenjualanChartPanel();

        setMaximumSize(new java.awt.Dimension(1250, 650));
        setMinimumSize(new java.awt.Dimension(1250, 650));
        setPreferredSize(new java.awt.Dimension(1250, 650));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cetak.setText("Cetak");
        cetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cetakActionPerformed(evt);
            }
        });
        add(cetak, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 600, 140, 40));

        SpinBulan.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(98, Short.MAX_VALUE)
                .addComponent(SpinBulan, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(SpinBulan, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(529, Short.MAX_VALUE))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 0, 330, 590));
        add(penjualanChartPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 600));
    }// </editor-fold>//GEN-END:initComponents

    private void cetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cetakActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cetakActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner SpinBulan;
    private javax.swing.JButton cetak;
    private javax.swing.JPanel jPanel1;
    private komponen.PenjualanChartPanel penjualanChartPanel1;
    // End of variables declaration//GEN-END:variables
}
