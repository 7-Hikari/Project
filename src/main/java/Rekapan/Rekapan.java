package Rekapan;

public class Rekapan extends javax.swing.JPanel {

    komponen.koordinat koor = new komponen.koordinat();
    
    public Rekapan() {
        initComponents();
        panel_rekap.add(koor);
        panel_rekap.revalidate();
        panel_rekap.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scroll_rekap = new javax.swing.JScrollPane();
        panel_rekap = new javax.swing.JPanel();
        cetak = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout panel_rekapLayout = new javax.swing.GroupLayout(panel_rekap);
        panel_rekap.setLayout(panel_rekapLayout);
        panel_rekapLayout.setHorizontalGroup(
            panel_rekapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 844, Short.MAX_VALUE)
        );
        panel_rekapLayout.setVerticalGroup(
            panel_rekapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 564, Short.MAX_VALUE)
        );

        scroll_rekap.setViewportView(panel_rekap);

        add(scroll_rekap, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -4, 850, 460));

        cetak.setText("Cetak");
        cetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cetakActionPerformed(evt);
            }
        });
        add(cetak, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 490, 130, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void cetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cetakActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cetakActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cetak;
    private javax.swing.JPanel panel_rekap;
    private javax.swing.JScrollPane scroll_rekap;
    // End of variables declaration//GEN-END:variables
}
