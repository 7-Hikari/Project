package com.mycompany.kasir;

public class CustAccess extends javax.swing.JFrame {

    public CustAccess() {
        initComponents();
        setLocationRelativeTo(null);
        Penjualan p = new Penjualan();
        p.setVisible(true);
        IniPanel.add(p);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel = new javax.swing.JPanel();
        Kembali = new javax.swing.JButton();
        IniPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pemesanan - Pelanggan");
        setMaximumSize(new java.awt.Dimension(1440, 900));
        setMinimumSize(new java.awt.Dimension(1440, 900));
        setPreferredSize(new java.awt.Dimension(1440, 900));
        setResizable(false);

        Panel.setLayout(null);

        Kembali.setBackground(new java.awt.Color(0, 153, 255));
        Kembali.setText("Kembali");
        Kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KembaliActionPerformed(evt);
            }
        });
        Panel.add(Kembali);
        Kembali.setBounds(50, 818, 150, 50);

        IniPanel.setBackground(new java.awt.Color(255, 102, 102));
        IniPanel.setMaximumSize(new java.awt.Dimension(1240, 640));
        IniPanel.setMinimumSize(new java.awt.Dimension(1240, 640));
        IniPanel.setPreferredSize(new java.awt.Dimension(1240, 640));
        IniPanel.setLayout(new java.awt.BorderLayout());
        Panel.add(IniPanel);
        IniPanel.setBounds(60, 120, 1240, 640);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 1434, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void KembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KembaliActionPerformed
        new Login.Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_KembaliActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel IniPanel;
    private javax.swing.JButton Kembali;
    private javax.swing.JPanel Panel;
    // End of variables declaration//GEN-END:variables
}
