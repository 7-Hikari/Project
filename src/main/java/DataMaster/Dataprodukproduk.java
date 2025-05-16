package DataMaster;

import DAO.*;
import java.awt.BorderLayout;
import java.util.*;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import komponen.wraplayout;

/**
 *
 * @author RIZKI NABIL P
 */
public class Dataprodukproduk extends javax.swing.JPanel {
    private Dataprodukbahan probah = new Dataprodukbahan();

    public Dataprodukproduk() {
        initComponents();
        
        loadProduk();
    }

    void loadProduk(){
        flow.setPreferredSize(new java.awt.Dimension(650, 800));
        flow.setViewportView(DataProduk);
        flow.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        flow.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        DataProduk.removeAll();

        List<produkData> daftarProduk = produkObjek.getAllProduk();
        
        for (produkData data : daftarProduk) {
            panelDataProduk produkP = new panelDataProduk(data);

            produkP.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    produkData produk = produkP.getproduk();
//                    masukkanKeTabel(produk, jumlah);
                }
            });
            DataProduk.add(produkP);
            DataProduk.setLayout(new wraplayout(FlowLayout.CENTER, 30, 10));
    }
        int jumlahItem = DataProduk.getComponentCount();
        int tinggiPerBaris = 200;
        int kolom = 3;
        int baris = (int) Math.ceil(jumlahItem / (double) kolom);
        int tinggiTotal = baris * tinggiPerBaris + 50;

        DataProduk.setPreferredSize(new java.awt.Dimension(640, tinggiTotal));
        DataProduk.revalidate();
        DataProduk.repaint();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        Panelprodukbahan = new komponen.PanelRound();
        Hapus = new javax.swing.JButton();
        Edit = new javax.swing.JButton();
        Tambah = new javax.swing.JButton();
        flow = new javax.swing.JScrollPane();
        DataProduk = new komponen.PanelRound();
        Bahan = new javax.swing.JButton();
        Produk = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();

        setMaximumSize(new java.awt.Dimension(1200, 620));
        setMinimumSize(new java.awt.Dimension(1200, 620));
        setPreferredSize(new java.awt.Dimension(1200, 620));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(1260, 620));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1290, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );

        Panelprodukbahan.setBackground(new java.awt.Color(51, 204, 255));
        Panelprodukbahan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Hapus.setText("Hapus");
        Panelprodukbahan.add(Hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 430, 122, 34));

        Edit.setText("Edit");
        Edit.setPreferredSize(new java.awt.Dimension(122, 34));
        Edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditActionPerformed(evt);
            }
        });
        Panelprodukbahan.add(Edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 430, -1, -1));

        Tambah.setText("Tambah");
        Tambah.setPreferredSize(new java.awt.Dimension(122, 34));
        Tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TambahActionPerformed(evt);
            }
        });
        Panelprodukbahan.add(Tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 430, -1, -1));

        flow.setBackground(new java.awt.Color(0, 204, 255));
        flow.setMaximumSize(new java.awt.Dimension(1230, 410));

        DataProduk.setBackground(new java.awt.Color(0, 204, 255));
        DataProduk.setMaximumSize(new java.awt.Dimension(1230, 410));
        DataProduk.setMinimumSize(new java.awt.Dimension(1230, 410));
        DataProduk.setRoundBottomLeft(100);
        DataProduk.setRoundBottomRight(100);
        DataProduk.setRoundTopLeft(100);
        DataProduk.setRoundTopRight(100);
        DataProduk.setLayout(new java.awt.GridLayout(5, 4, 2, 2));
        flow.setViewportView(DataProduk);

        Panelprodukbahan.add(flow, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 10, 1240, 410));

        Bahan.setText("Bahan");
        Bahan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BahanActionPerformed(evt);
            }
        });

        Produk.setText("Produk");
        Produk.setPreferredSize(new java.awt.Dimension(553, 45));
        Produk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProdukActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 26, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 119, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(Produk, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88)
                        .addComponent(Bahan, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Panelprodukbahan, javax.swing.GroupLayout.DEFAULT_SIZE, 1290, Short.MAX_VALUE))
                .addContainerGap(0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(Bahan, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(Produk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Panelprodukbahan, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(478, Short.MAX_VALUE))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1290, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void TambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TambahActionPerformed

    }//GEN-LAST:event_TambahActionPerformed

    private void BahanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BahanActionPerformed
   
    if(probah ==null){
        probah = new Dataprodukbahan();
    }
     probah.setBounds(0,0,Panelprodukbahan.getWidth(),Panelprodukbahan.getHeight());
    probah.setBorder(BorderFactory.createLineBorder(Color.RED));
    
    Panelprodukbahan.removeAll();
    Panelprodukbahan.add(probah, new org.netbeans.lib.awtextra.AbsoluteConstraints(0,0,Panelprodukbahan.getWidth(),Panelprodukbahan.getHeight()));
    Panelprodukbahan.revalidate();
    Panelprodukbahan.repaint();
        System.out.println("ss" + Panelprodukbahan.getWidth());
    }//GEN-LAST:event_BahanActionPerformed

    private void EditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EditActionPerformed

    private void ProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProdukActionPerformed
    tampilkanPanelProduk();
    }//GEN-LAST:event_ProdukActionPerformed

    private void tampilkanPanelProduk() {
    Panelprodukbahan.removeAll();
    Panelprodukbahan.add(flow, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 10, 1240, 410));
    Panelprodukbahan.add(Tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 430, -1, -1));
    Panelprodukbahan.add(Edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 430, -1, -1));
    Panelprodukbahan.add(Hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 430, 122, 34));

    Panelprodukbahan.revalidate();
    Panelprodukbahan.repaint();

    loadProduk(); // optionally reload
}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bahan;
    private komponen.PanelRound DataProduk;
    private javax.swing.JButton Edit;
    private javax.swing.JButton Hapus;
    private komponen.PanelRound Panelprodukbahan;
    private javax.swing.JButton Produk;
    private javax.swing.JButton Tambah;
    private javax.swing.JScrollPane flow;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    // End of variables declaration//GEN-END:variables
}
