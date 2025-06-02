package Transaksi;

import java.awt.Color;

public class CustAccess extends javax.swing.JFrame {

    public CustAccess() {
        initComponents();
        setLocationRelativeTo(null);
        Penjualan p = new Penjualan();
        p.setVisible(true);
        panelRound1.setGradient(new Color(0x2cbac6), Color.white);
        panelRound2.setGradient(new Color(0x2cbac6), Color.white);
        panelRound3.setGradient(new Color(0x2cbac6), Color.white);
        IniPanel.add(p);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound2 = new komponen.PanelRound();
        panelRound1 = new komponen.PanelRound();
        panelRound3 = new komponen.PanelRound();
        IniPanel = new javax.swing.JPanel();
        Kembali = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pemesanan - Pelanggan");
        setMinimumSize(new java.awt.Dimension(1440, 900));
        setResizable(false);

        panelRound2.setBackground(new java.awt.Color(51, 153, 255));
        panelRound2.setGradientDirection(komponen.PanelRound.Direction.VERTICAL);
        panelRound2.setOpaque(true);
        panelRound2.setSolid(false);
        panelRound2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound1.setBackground(new java.awt.Color(51, 204, 255));
        panelRound1.setGradientDirection(komponen.PanelRound.Direction.VERTICAL);
        panelRound1.setRoundBottomLeft(50);
        panelRound1.setRoundBottomRight(50);
        panelRound1.setRoundTopLeft(50);
        panelRound1.setRoundTopRight(50);
        panelRound1.setSolid(false);
        panelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound3.setBackground(new java.awt.Color(102, 204, 255));
        panelRound3.setGradientDirection(komponen.PanelRound.Direction.VERTICAL);
        panelRound3.setRoundBottomLeft(50);
        panelRound3.setRoundBottomRight(50);
        panelRound3.setRoundTopLeft(50);
        panelRound3.setRoundTopRight(50);
        panelRound3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        IniPanel.setBackground(new java.awt.Color(255, 255, 255));
        IniPanel.setMaximumSize(new java.awt.Dimension(1240, 640));
        IniPanel.setMinimumSize(new java.awt.Dimension(1240, 640));
        IniPanel.setPreferredSize(new java.awt.Dimension(1240, 640));
        IniPanel.setLayout(new java.awt.BorderLayout());

        Kembali.setBackground(new java.awt.Color(255, 102, 102));
        Kembali.setText("Kembali");
        Kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KembaliActionPerformed(evt);
            }
        });
        IniPanel.add(Kembali, java.awt.BorderLayout.PAGE_END);

        panelRound3.add(IniPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, 666));

        panelRound1.add(panelRound3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 1360, -1));

        panelRound2.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 39, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
    private komponen.PanelRound panelRound1;
    private komponen.PanelRound panelRound2;
    private komponen.PanelRound panelRound3;
    // End of variables declaration//GEN-END:variables
}
