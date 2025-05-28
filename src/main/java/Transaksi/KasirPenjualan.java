package Transaksi;

import DAO.*;
import DataMaster.kom.OnlyNum;
import java.awt.Color;
import java.awt.Dimension;
import java.util.*;
import javax.swing.table.*;

public class KasirPenjualan extends komponen.PanelRound {
    
    private int no = 1;
    private int total = 0;
    private String tr;
    DefaultTableModel m_pesanan = null;
    
    public KasirPenjualan() {
        initComponents();
        
        setRoundBottomLeft(100);
        setRoundBottomRight(100);
        setRoundTopLeft(100);
        setRoundTopRight(100);
        
        panelRound1.setGradient(new Color(0x2CBAC6), new Color(0x48A3EE));

        setPreferredSize(new Dimension(1240, 640));
        
        DefaultTableModel tabel = (DefaultTableModel) Tabelpesanan.getModel();
        m_pesanan = tabel;
        
    }


    private void masukkanKeTabel(String kode) {
         
        no = 1;
        
        List<pesananDetailData> pesanan = transaksiObjek.ambilDetailTransaksi(kode);

        m_pesanan.setRowCount(0);
        
        for (pesananDetailData p : pesanan) {
            if(p.getLunas()){
                System.out.println("Transaksi sudah lunas!");
                return;
            }
                    
            int subtotal = p.get_harga() * p.get_jumlah();
            Object[] row = {
                no,
                p.getNama(),
                OnlyNum.Rp.format(p.get_harga()),
                p.get_jumlah(),
                OnlyNum.Rp.format(subtotal)
            };
            System.out.println(total);
            total += subtotal;
            no++;
            System.out.println(p.get_jumlah());
            System.out.println(p.get_harga());
            System.out.println(subtotal);
            System.out.println(total);
            System.out.println();

            m_pesanan.addRow(row);
            fieldtotal.setText(OnlyNum.Rp.format(total));
        }
    }
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
        PanelTr = new javax.swing.JPanel();
        labelpanel = new javax.swing.JLabel();
        AmbilData = new javax.swing.JButton();

        setBackground(new java.awt.Color(51, 153, 255));
        setMaximumSize(new java.awt.Dimension(1100, 650));
        setMinimumSize(new java.awt.Dimension(1100, 650));
        setPreferredSize(new java.awt.Dimension(1100, 650));
        setLayout(new java.awt.BorderLayout());

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));
        panelRound1.setGradientDirection(komponen.PanelRound.Direction.VERTICAL);
        panelRound1.setMaximumSize(new java.awt.Dimension(1100, 650));
        panelRound1.setMinimumSize(new java.awt.Dimension(1100, 650));
        panelRound1.setPreferredSize(new java.awt.Dimension(1100, 650));
        panelRound1.setRoundBottomLeft(100);
        panelRound1.setRoundBottomRight(100);
        panelRound1.setRoundTopLeft(100);
        panelRound1.setRoundTopRight(100);
        panelRound1.setVerifyInputWhenFocusTarget(false);
        panelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        struk.setBackground(new java.awt.Color(255, 255, 255));
        struk.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fieldtotal.setEditable(false);
        fieldtotal.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        fieldtotal.setText("Rp0,00");
        fieldtotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldtotalActionPerformed(evt);
            }
        });
        struk.add(fieldtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 410, 191, 34));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText(" Total");
        struk.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 380, 60, 34));

        Tabelpesanan.setBackground(new java.awt.Color(0, 204, 255));
        Tabelpesanan.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.cyan, java.awt.Color.blue));
        Tabelpesanan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Nama Produk", "Harga Jual", "Jumlah", "Sub Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Short.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Tabelpesanan.setHeaderBackgroundColor(new java.awt.Color(0, 153, 255));
        Tabelpesanan.getTableHeader().setResizingAllowed(false);
        Tabelpesanan.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(Tabelpesanan);
        if (Tabelpesanan.getColumnModel().getColumnCount() > 0) {
            Tabelpesanan.getColumnModel().getColumn(0).setResizable(false);
            Tabelpesanan.getColumnModel().getColumn(0).setPreferredWidth(15);
            Tabelpesanan.getColumnModel().getColumn(2).setPreferredWidth(25);
            Tabelpesanan.getColumnModel().getColumn(3).setResizable(false);
            Tabelpesanan.getColumnModel().getColumn(3).setPreferredWidth(20);
        }

        struk.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1200, 370));

        panelRound1.add(struk, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 1220, 450));

        Bayar.setBackground(new java.awt.Color(255, 51, 0));
        Bayar.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        Bayar.setText("Bayar");
        Bayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BayarActionPerformed(evt);
            }
        });
        panelRound1.add(Bayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 560, 170, -1));

        panelRound2.setBackground(new java.awt.Color(255, 255, 255));
        panelRound2.setRoundBottomLeft(50);
        panelRound2.setRoundBottomRight(50);
        panelRound2.setRoundTopLeft(50);
        panelRound2.setRoundTopRight(50);

        transaksi.setToolTipText("");
        transaksi.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
            .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelRound2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(transaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
            .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelRound2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(transaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        panelRound1.add(panelRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 50, 350, 40));

        PanelTr.setBackground(new java.awt.Color(0, 153, 255));

        labelpanel.setBackground(new java.awt.Color(0, 0, 0));
        labelpanel.setFont(new java.awt.Font("Merriweather Black", 1, 14)); // NOI18N
        labelpanel.setForeground(new java.awt.Color(255, 255, 255));
        labelpanel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelpanel.setText("ID TRANSAKSI");

        javax.swing.GroupLayout PanelTrLayout = new javax.swing.GroupLayout(PanelTr);
        PanelTr.setLayout(PanelTrLayout);
        PanelTrLayout.setHorizontalGroup(
            PanelTrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTrLayout.createSequentialGroup()
                .addComponent(labelpanel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PanelTrLayout.setVerticalGroup(
            PanelTrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTrLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labelpanel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelRound1.add(PanelTr, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 10, 150, 30));

        AmbilData.setBackground(new java.awt.Color(0, 153, 255));
        AmbilData.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        AmbilData.setText("Cari");
        AmbilData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AmbilDataActionPerformed(evt);
            }
        });
        panelRound1.add(AmbilData, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 50, 70, 40));

        add(panelRound1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void BayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BayarActionPerformed
        byte a = 1;
        pesananData pesDat = new pesananData(tr, Boolean.TRUE);
        transaksiObjek.updateTr(pesDat, a);
        m_pesanan.setRowCount(0);
        total = 0;
        fieldtotal.setText(OnlyNum.Rp.format(total));
    }//GEN-LAST:event_BayarActionPerformed

    private void fieldtotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldtotalActionPerformed
        
    }//GEN-LAST:event_fieldtotalActionPerformed

    private void AmbilDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AmbilDataActionPerformed
        tr = transaksi.getText();
        if (tr.length() < 9) {
            m_pesanan.setRowCount(0);
        } else {
            System.out.println("a " + tr);
            masukkanKeTabel(tr);
        }
    }//GEN-LAST:event_AmbilDataActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AmbilData;
    private javax.swing.JButton Bayar;
    private javax.swing.JPanel PanelTr;
    private komponen.Tabel_c Tabelpesanan;
    private javax.swing.JTextField fieldtotal;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelpanel;
    private komponen.PanelRound panelRound1;
    private komponen.PanelRound panelRound2;
    private javax.swing.JPanel struk;
    private javax.swing.JTextField transaksi;
    // End of variables declaration//GEN-END:variables
}
