package com.mycompany.kasir;

import DAO.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Color;
import komponen.wraplayout;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.text.NumberFormat;
import javax.swing.table.*;

public class KasirPenjualan extends komponen.PanelRound {
    
    private int no = 1;
    private List<Byte> ProdukIdList = new ArrayList<>();
    private final NumberFormat Rp = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
    int total = 0;
    DefaultTableModel m_pesanan = null;
    
    public KasirPenjualan() {
        initComponents();
        
        setRoundBottomLeft(100);
        setRoundBottomRight(100);
        setRoundTopLeft(100);
        setRoundTopRight(100);
        
        setLayout(new BorderLayout());
        add(panelRound1, BorderLayout.CENTER);

        setPreferredSize(new Dimension(1240, 640));
        
        DefaultTableModel tabel = (DefaultTableModel) Tabelpesanan.getModel();
        m_pesanan = tabel;
        
    }


    private void masukkanKeTabel(int transaksi) {
        
            List <pesananDetailData> pesanan = pesananObjek.ambilDetailTransaksi(transaksi);
            
            DefaultTableModel mo = (DefaultTableModel) Tabelpesanan.getModel();
            mo.setRowCount(0);
            
            for(pesananDetailData p : pesanan){
                Object [] row = {
                    p.get_produkId(), p.get_jumlah(), p.get_harga()
                };
                
                System.out.println(p.get_produkId());
                System.out.println(p.get_jumlah());
                System.out.println(p.get_harga());
                
                mo.addRow(row);
            }
            
            }
//
//        if (!ada) {
//            m_pesanan.addRow(new Object[]{
//                no++,
//                data.get_id(),
//                data.get_nama(),
//                data.get_harga(),
//                jumlahBaru,
//                data.get_harga() * jumlahBaru
//            });
//            upTotal();
//            ProdukIdList.add(data.get_id());
//        }
//    }
    
//    private void upTotal(){
//        total = 0;
//        for(int row =0; row < Tabelpesanan.getRowCount(); row++) {
//            Object nilai = Tabelpesanan.getValueAt(row, 5);
//            if (nilai !=null) {
//                total += Integer.parseInt(nilai.toString());
//            }
//        }
//        String ttl = Rp.format(total);
//        fieldtotal.setText(String.valueOf(ttl));
//    }
//    
//    private void no_urut(){
//        for (no = 1; no <= Tabelpesanan.getRowCount(); no++){
//            Tabelpesanan.setValueAt(no, no - 1, 0);
//        }
//    }
//    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound1 = new komponen.PanelRound();
        struk = new javax.swing.JPanel();
        fieldtotal = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabelpesanan = new komponen.Tabel_c();
        Bayar = new javax.swing.JButton();
        panelRound2 = new komponen.PanelRound();
        transaksi = new javax.swing.JTextField();

        setBackground(new java.awt.Color(51, 153, 255));
        setMaximumSize(new java.awt.Dimension(1100, 800));
        setMinimumSize(new java.awt.Dimension(1100, 800));
        setPreferredSize(new java.awt.Dimension(1100, 800));
        setLayout(new java.awt.BorderLayout());

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));
        panelRound1.setMaximumSize(new java.awt.Dimension(1240, 640));
        panelRound1.setMinimumSize(new java.awt.Dimension(1240, 640));
        panelRound1.setPreferredSize(new java.awt.Dimension(1240, 640));
        panelRound1.setRoundBottomLeft(100);
        panelRound1.setRoundBottomRight(100);
        panelRound1.setRoundTopLeft(100);
        panelRound1.setRoundTopRight(100);
        panelRound1.setVerifyInputWhenFocusTarget(false);
        panelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        struk.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fieldtotal.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        fieldtotal.setText("Rp0,00");
        fieldtotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldtotalActionPerformed(evt);
            }
        });
        struk.add(fieldtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 420, 191, 34));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel9.setText(" Total");
        struk.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 420, 106, 34));

        Tabelpesanan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Harga", "Jumlah"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
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
            Tabelpesanan.getColumnModel().getColumn(0).setPreferredWidth(15);
            Tabelpesanan.getColumnModel().getColumn(2).setPreferredWidth(25);
        }

        struk.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1200, 310));

        panelRound1.add(struk, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 1220, 490));

        Bayar.setBackground(new java.awt.Color(0, 255, 51));
        Bayar.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        Bayar.setText("Bayar");
        Bayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BayarActionPerformed(evt);
            }
        });
        panelRound1.add(Bayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 600, 107, -1));

        panelRound2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        transaksi.setText("jTextField2");
        panelRound2.add(transaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 3, 310, 40));

        panelRound1.add(panelRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 40, 310, 40));

        add(panelRound1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void BayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BayarActionPerformed
        JOptionPane.showMessageDialog(this, "Silahkan Ambil Nota dan bawa ke Kasir\n untuk melakukan pembayaran ya!",
                "Pesanan Berhasil", JOptionPane.INFORMATION_MESSAGE);
        m_pesanan.setRowCount(0);
        fieldtotal.setText("Rp0,00");
        ProdukIdList.clear();
        String tr = transaksi.getText();
        int trans = Integer.parseInt(tr.substring(6));
        System.out.println("a "+trans);
        masukkanKeTabel(trans);
        
    }//GEN-LAST:event_BayarActionPerformed

    private void fieldtotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldtotalActionPerformed
        
    }//GEN-LAST:event_fieldtotalActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bayar;
    private komponen.Tabel_c Tabelpesanan;
    private javax.swing.JTextField fieldtotal;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private komponen.PanelRound panelRound1;
    private komponen.PanelRound panelRound2;
    private javax.swing.JPanel struk;
    private javax.swing.JTextField transaksi;
    // End of variables declaration//GEN-END:variables
}
