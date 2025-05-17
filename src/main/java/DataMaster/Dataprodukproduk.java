package DataMaster;

import DAO.*;
import java.util.List;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;
import komponen.PanelRound;
import komponen.wraplayout;

/**
 *
 * @author RIZKI NABIL P
 */
public class Dataprodukproduk extends komponen.PanelRound {

    private Dataprodukbahan probah = new Dataprodukbahan();

    public interface ProdukFormListener {

        void onCloseForm();;
    }
    private JDialog jdialog;
    private Updatedataprodukproduk formPanel;
    private String judul;

    public Dataprodukproduk() {
        initComponents();

        setRoundBottomLeft(100);
        setRoundBottomRight(100);
        setRoundTopLeft(100);
        setRoundTopRight(100);

        loadProduk();
        Panelprodukbahan.setGradientDirection(PanelRound.Direction.VERTICAL);
        Panelprodukbahan.setGradient(new Color(0x2CC4C9), new Color(0x22EBC6));
        DataProduk.setGradientDirection(PanelRound.Direction.VERTICAL);
        DataProduk.setGradient(new Color(0x2CC4C9), new Color(0x22EBC6));
    }

    void loadProduk() {
        flow.setPreferredSize(new java.awt.Dimension(650, 800));
        flow.setViewportView(DataProduk);

        DataProduk.removeAll();

        List<produkData> daftarProduk = produkObjek.getAllProduk();

        for (produkData data : daftarProduk) {
            panelDataProduk produkP = new panelDataProduk(data);

            produkP.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    showDetProduk(produkP.getproduk());
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

        DataProduk.setPreferredSize(new Dimension(640, tinggiTotal));
        DataProduk.revalidate();
        DataProduk.repaint();
    }

    private void showDetProduk(produkData pDat) {
        formPanel = new Updatedataprodukproduk();
        formPanel.setData(pDat);
        judul = "Detail Produk";
        dialog(judul, formPanel);
    }

    private void dialog(String title, Updatedataprodukproduk UPP) {
        jdialog = new JDialog((Frame) SwingUtilities.getWindowAncestor(this), title, true);
        jdialog.setUndecorated(true);

        formPanel.setProdukFormListener(() -> {
            jdialog.dispose();
            loadProduk();
        });
        jdialog.setPreferredSize(new Dimension(265, 450));
        jdialog.setContentPane(UPP);
        jdialog.pack();
        jdialog.setLocationRelativeTo(null);
        jdialog.setShape(new RoundRectangle2D.Double(0, 0, jdialog.getWidth(), jdialog.getHeight(), 30, 30));
        jdialog.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        Panelprodukbahan = new komponen.PanelRound();
        Tambah = new javax.swing.JButton();
        flow = new javax.swing.JScrollPane();
        DataProduk = new komponen.PanelRound();
        PaNavBol = new javax.swing.JPanel();
        Produk = new javax.swing.JButton();
        Bahan = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(51, 255, 255));
        setMaximumSize(new java.awt.Dimension(1200, 620));
        setMinimumSize(new java.awt.Dimension(1200, 620));
        setPreferredSize(new java.awt.Dimension(1200, 620));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new Color(0x2CC4C9)
        );
        jPanel1.setMaximumSize(new java.awt.Dimension(1250, 620));
        jPanel1.setMinimumSize(new java.awt.Dimension(1260, 620));
        jPanel1.setPreferredSize(new java.awt.Dimension(1250, 620));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1224, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );

        Panelprodukbahan.setBackground(new java.awt.Color(51, 255, 255));
        Panelprodukbahan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Tambah.setBackground(new java.awt.Color(51, 255, 51));
        Tambah.setFont(new java.awt.Font("Roboto Medium", 1, 12)); // NOI18N
        Tambah.setForeground(new java.awt.Color(0, 0, 0));
        Tambah.setText("Tambah");
        Tambah.setPreferredSize(new java.awt.Dimension(122, 34));
        Tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TambahActionPerformed(evt);
            }
        });
        Panelprodukbahan.add(Tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 460, -1, -1));

        flow.setBackground(new java.awt.Color(0, 204, 255));
        flow.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        flow.setMaximumSize(new java.awt.Dimension(1230, 410));
        flow.setPreferredSize(new java.awt.Dimension(1250, 416));

        DataProduk.setBackground(new java.awt.Color(0, 204, 255));
        DataProduk.setMaximumSize(new java.awt.Dimension(1250, 410));
        DataProduk.setMinimumSize(new java.awt.Dimension(1250, 410));
        DataProduk.setPreferredSize(new java.awt.Dimension(1250, 410));
        DataProduk.setLayout(new java.awt.GridLayout(5, 4, 2, 2));
        flow.setViewportView(DataProduk);

        Panelprodukbahan.add(flow, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 10, 1230, 440));

        PaNavBol.setMaximumSize(new java.awt.Dimension(1250, 2147483647));
        PaNavBol.setPreferredSize(new java.awt.Dimension(1250, 63));
        PaNavBol.setLayout(new java.awt.BorderLayout());

        Produk.setBackground(new Color(0x2CC4C9));
        Produk.setText("Produk");
        Produk.setMinimumSize(new java.awt.Dimension(600, 28));
        Produk.setPreferredSize(new java.awt.Dimension(600, 45));
        Produk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProdukActionPerformed(evt);
            }
        });
        PaNavBol.add(Produk, java.awt.BorderLayout.WEST);

        Bahan.setBackground(new Color(0x2CC4C9)
        );
        Bahan.setText("Bahan");
        Bahan.setMinimumSize(new java.awt.Dimension(600, 28));
        Bahan.setPreferredSize(new java.awt.Dimension(600, 28));
        Bahan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BahanActionPerformed(evt);
            }
        });
        PaNavBol.add(Bahan, java.awt.BorderLayout.EAST);

        jPanel3.setBackground(new java.awt.Color(0, 255, 204));
        jPanel3.setMaximumSize(new java.awt.Dimension(50, 50));
        jPanel3.setMinimumSize(new java.awt.Dimension(50, 50));
        jPanel3.setPreferredSize(new java.awt.Dimension(50, 50));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 85, Short.MAX_VALUE)
        );

        PaNavBol.add(jPanel3, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Panelprodukbahan, javax.swing.GroupLayout.PREFERRED_SIZE, 1256, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(PaNavBol, javax.swing.GroupLayout.PREFERRED_SIZE, 1224, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(PaNavBol, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Panelprodukbahan, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 650));
    }// </editor-fold>//GEN-END:initComponents

    private void TambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TambahActionPerformed
        formPanel = new Updatedataprodukproduk();
        judul = "Tambah Produk";
        dialog(judul, formPanel);
    }//GEN-LAST:event_TambahActionPerformed

    private void ProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProdukActionPerformed
        tampilkanPanelProduk();
    }//GEN-LAST:event_ProdukActionPerformed

    private void BahanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BahanActionPerformed
        if (probah == null) {
            probah = new Dataprodukbahan();
        }
        probah.setBounds(0, 0, Panelprodukbahan.getWidth(), Panelprodukbahan.getHeight());
        probah.setBorder(BorderFactory.createLineBorder(Color.RED));

        Panelprodukbahan.removeAll();
        Panelprodukbahan.add(probah, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, Panelprodukbahan.getWidth(), Panelprodukbahan.getHeight()));
        Panelprodukbahan.revalidate();
        Panelprodukbahan.repaint();
    }//GEN-LAST:event_BahanActionPerformed

    private void tampilkanPanelProduk() {
        Panelprodukbahan.removeAll();
        Panelprodukbahan.add(flow, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 10, 1240, 410));
        Panelprodukbahan.add(Tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 460, -1, -1));
        Panelprodukbahan.revalidate();
        Panelprodukbahan.repaint();

        loadProduk();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bahan;
    private komponen.PanelRound DataProduk;
    private javax.swing.JPanel PaNavBol;
    private komponen.PanelRound Panelprodukbahan;
    private javax.swing.JButton Produk;
    private javax.swing.JButton Tambah;
    private javax.swing.JScrollPane flow;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    // End of variables declaration//GEN-END:variables
}
