package com.mycompany.kasir;

import DAO.*;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import komponenpanel.wraplayout;
import java.awt.Color;
import javax.swing.*;
import java.util.*;

public class MENU extends JPanel {

    public MENU() {
        initComponents();
        
        setLayout(new BorderLayout());
        add(jPanel1, BorderLayout.CENTER);

        setPreferredSize(new Dimension(1300, 800));
        
        loadproduk();
    }

    public void loadproduk() {
        scroll.setPreferredSize(new Dimension(650, 800));
        scroll.setViewportView(flowpanel);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        flowpanel.removeAll();

        List<produkData> daftarProduk = produkObjek.getAllProduk();

        for (produkData data : daftarProduk) {
            panelProduk produkP = new panelProduk(data);

            flowpanel.add(produkP);

            flowpanel.setLayout(new wraplayout(FlowLayout.LEFT, 10, 10));

        }
    
        int jumlahItem = flowpanel.getComponentCount();
        int tinggiPerBaris = 300;
        int kolom = 3;
        int baris = (int) Math.ceil(jumlahItem / (double) kolom);
        int tinggiTotal = baris * tinggiPerBaris + 50;
        
        flowpanel.setPreferredSize(new Dimension(640, tinggiTotal));
        flowpanel.revalidate();
        flowpanel.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tombol = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        struk = new javax.swing.JPanel();
        jTextFieldtotal = new javax.swing.JTextField();
        jTextFieldsubtotal = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        scroll = new JScrollPane();
        flowpanel = new JPanel();

        setPreferredSize(new java.awt.Dimension(1100, 800));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1340, 800));

        tombol.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setBackground(new java.awt.Color(0, 255, 51));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jButton1.setText("Total");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(51, 102, 255));
        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jButton2.setText("Receipt");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tombolLayout = new javax.swing.GroupLayout(tombol);
        tombol.setLayout(tombolLayout);
        tombolLayout.setHorizontalGroup(
            tombolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tombolLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        tombolLayout.setVerticalGroup(
            tombolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tombolLayout.createSequentialGroup()
                .addGroup(tombolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 20, Short.MAX_VALUE))
        );

        jTextFieldtotal.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N

        jTextFieldsubtotal.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jTextFieldsubtotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldsubtotalActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel9.setText(" Total");

        jLabel45.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel45.setText("Sub Total");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout strukLayout = new javax.swing.GroupLayout(struk);
        struk.setLayout(strukLayout);
        strukLayout.setHorizontalGroup(
            strukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, strukLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(strukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(strukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldtotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldsubtotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, strukLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        strukLayout.setVerticalGroup(
            strukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(strukLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(strukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldsubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(strukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        flowpanel.setMaximumSize(new java.awt.Dimension(600, 800));
        flowpanel.setMinimumSize(new java.awt.Dimension(600, 8));
        flowpanel.setPreferredSize(new java.awt.Dimension(600, 8));
        flowpanel.setLayout(new java.awt.GridLayout(5, 4, 2, 2));
        scroll.setViewportView(flowpanel);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 773, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(struk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(147, 147, 147)
                .addComponent(tombol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(struk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tombol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldsubtotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldsubtotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldsubtotalActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel flowpanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldsubtotal;
    private javax.swing.JTextField jTextFieldtotal;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JPanel struk;
    private javax.swing.JPanel tombol;
    // End of variables declaration//GEN-END:variables
}
