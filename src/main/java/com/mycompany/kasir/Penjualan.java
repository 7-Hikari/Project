package com.mycompany.kasir;

import DAO.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import komponen.wraplayout;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.text.NumberFormat;
import javax.swing.table.*;

public class Penjualan extends JPanel {
    
    private int no = 1;
    private final NumberFormat Rp = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
    
    public Penjualan() {
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

            produkP.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    produkData produk = produkP.getproduk();
                    int jumlah = produkP.getJumlah();
                    masukkanKeTabel(produk, jumlah);
                }
            });
            produkP.setproduklisten((produk, jumlahBaru) -> {
                updateBarisTabel(produk, jumlahBaru);
            });

            flowpanel.add(produkP);

            flowpanel.setLayout(new wraplayout(FlowLayout.LEFT, 10, 10));

        }

        int jumlahItem = flowpanel.getComponentCount();
        int tinggiPerBaris = 350;
        int kolom = 3;
        int baris = (int) Math.ceil(jumlahItem / (double) kolom);
        int tinggiTotal = baris * tinggiPerBaris + 50;

        flowpanel.setPreferredSize(new Dimension(640, tinggiTotal));
        flowpanel.revalidate();
        flowpanel.repaint();

    }

    private void updateBarisTabel(produkData produk, int jumlahBaru) {
        DefaultTableModel model = (DefaultTableModel) Tabelpesanan.getModel();

        for (int i = 0; i < model.getRowCount(); i++) {
            if (model.getValueAt(i, 2).equals(produk.get_nama())) {
                model.setValueAt(jumlahBaru, i, 4);
                model.setValueAt(jumlahBaru * produk.get_harga(), i, 5);
                upTotal();
                break;
            }
        }
    }

    private void masukkanKeTabel(produkData data, int jumlahBaru) {
        DefaultTableModel model = (DefaultTableModel) Tabelpesanan.getModel();
        boolean ada = false;

        for (int i = 0; i < model.getRowCount(); i++) {
            String namaProdukDiTabel = model.getValueAt(i, 2).toString();

            if (namaProdukDiTabel.equals(data.get_nama())) {
                // Produk sudah ada → update jumlah dan total
                int jumlahLama = (int) model.getValueAt(i, 4);
                int jumlahBaruFinal = jumlahLama + jumlahBaru;
                
                model.setValueAt(jumlahBaruFinal, i, 4); // Jumlah
                model.setValueAt(jumlahBaruFinal * data.get_harga(), i, 5); // Total
                
                ada = true;
                break;
            }
        }

        if (!ada) {
            model.addRow(new Object[]{
                no++,
                data.get_id(),
                data.get_nama(),
                data.get_harga(),
                jumlahBaru,
                data.get_harga() * jumlahBaru
            });
            upTotal();
        }
    }
    
    private void upTotal(){
        int total = 0;
        for(int row =0; row < Tabelpesanan.getRowCount(); row++) {
            Object nilai = Tabelpesanan.getValueAt(row, 5);
            if (nilai !=null) {
                total += Integer.parseInt(nilai.toString());
            }
        }
        String ttl = Rp.format(total);
        fieldtotal.setText(String.valueOf(ttl));
    }
    
    private void no_urut(){
        for (no = 1; no <= Tabelpesanan.getRowCount(); no++){
            Tabelpesanan.setValueAt(no, no - 1, 0);
        }
    }
    
    private void simpan(){
        for(no = 0; no < Tabelpesanan.getRowCount(); no++){
            
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        struk = new javax.swing.JPanel();
        fieldtotal = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabelpesanan = new komponen.Tabel_c();
        tmbl_hapus = new javax.swing.JButton();
        scroll = new JScrollPane();
        flowpanel = new JPanel();
        jButton1 = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(1100, 800));
        setPreferredSize(new java.awt.Dimension(1100, 800));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(1340, 800));
        jPanel1.setPreferredSize(new java.awt.Dimension(1340, 800));

        struk.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fieldtotal.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        fieldtotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldtotalActionPerformed(evt);
            }
        });
        struk.add(fieldtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 485, 191, 34));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel9.setText(" Total");
        struk.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 485, 106, 34));

        Tabelpesanan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "id", "Nama", "Harga", "Jumlah", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Byte.class, java.lang.String.class, java.lang.Integer.class, java.lang.Short.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Tabelpesanan);
        if (Tabelpesanan.getColumnModel().getColumnCount() > 0) {
            Tabelpesanan.getColumnModel().getColumn(0).setResizable(false);
            Tabelpesanan.getColumnModel().getColumn(0).setPreferredWidth(15);
            Tabelpesanan.getColumnModel().getColumn(1).setMinWidth(0);
            Tabelpesanan.getColumnModel().getColumn(1).setPreferredWidth(0);
            Tabelpesanan.getColumnModel().getColumn(1).setMaxWidth(0);
            Tabelpesanan.getColumnModel().getColumn(4).setPreferredWidth(25);
            Tabelpesanan.getColumnModel().getColumn(5).setResizable(false);
        }

        struk.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 400, 390));

        tmbl_hapus.setBackground(new java.awt.Color(255, 0, 0));
        tmbl_hapus.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        tmbl_hapus.setText("Hapus");
        tmbl_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tmbl_hapusActionPerformed(evt);
            }
        });
        struk.add(tmbl_hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(317, 36, 80, 30));

        scroll.setMinimumSize(new java.awt.Dimension(600, 25));
        scroll.setPreferredSize(new java.awt.Dimension(600, 8));

        flowpanel.setMaximumSize(new java.awt.Dimension(600, 800));
        flowpanel.setMinimumSize(new java.awt.Dimension(600, 8));
        flowpanel.setPreferredSize(new java.awt.Dimension(600, 8));
        flowpanel.setLayout(new java.awt.GridLayout(5, 4, 2, 2));
        scroll.setViewportView(flowpanel);

        jButton1.setBackground(new java.awt.Color(0, 255, 51));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jButton1.setText("Pesan");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(496, 496, 496)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(struk, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(struk, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(195, Short.MAX_VALUE))
        );

        add(jPanel1, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        simpan();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void fieldtotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldtotalActionPerformed
        
    }//GEN-LAST:event_fieldtotalActionPerformed

    private void tmbl_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tmbl_hapusActionPerformed
           if(Tabelpesanan.getSelectedRow() >= 0){
            ((DefaultTableModel) Tabelpesanan.getModel()).
            removeRow(Tabelpesanan.getSelectedRow());
            no_urut();
        }
    }//GEN-LAST:event_tmbl_hapusActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private komponen.Tabel_c Tabelpesanan;
    private javax.swing.JTextField fieldtotal;
    private javax.swing.JPanel flowpanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JPanel struk;
    private javax.swing.JButton tmbl_hapus;
    // End of variables declaration//GEN-END:variables
}
