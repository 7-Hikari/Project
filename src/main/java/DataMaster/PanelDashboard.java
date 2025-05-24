package DataMaster;

import java.awt.Color;

/**
 *
 * @author Muhammad Zaiful
 */
public class PanelDashboard extends komponen.PanelRound {

    public PanelDashboard() {
        initComponents();
        
        setGradient(new Color(0x2CBAC6), new Color(0x48A3EE));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel2 = new komponen.PanelRound();
        HeadP2 = new komponen.PanelRound();
        Produkterjual = new javax.swing.JLabel();
        produkSaled = new javax.swing.JLabel();
        Panel1 = new komponen.PanelRound();
        HeadP1 = new komponen.PanelRound();
        Penjualanhariiini = new javax.swing.JLabel();
        Sales = new javax.swing.JLabel();
        Panel3 = new komponen.PanelRound();
        MoneyIn = new javax.swing.JLabel();
        HeadP3 = new komponen.PanelRound();
        Uangmasukhariini = new javax.swing.JLabel();
        Keterangan = new komponen.PanelRound();
        jScrollPane1 = new javax.swing.JScrollPane();
        stokProduk = new komponen.Tabel_c();
        headKeterangan = new komponen.PanelRound();
        Produk = new javax.swing.JLabel();
        Cetak = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Panel2.setGradientDirection(komponen.PanelRound.Direction.VERTICAL);
        Panel2.setPreferredSize(new java.awt.Dimension(300, 190));
        Panel2.setRoundBottomLeft(50);
        Panel2.setRoundBottomRight(50);
        Panel2.setRoundTopLeft(50);
        Panel2.setRoundTopRight(50);
        Panel2.setLayout(new java.awt.BorderLayout());

        HeadP2.setBackground(new java.awt.Color(66, 160, 255));
        HeadP2.setMaximumSize(new java.awt.Dimension(300, 40));
        HeadP2.setPreferredSize(new java.awt.Dimension(300, 40));
        HeadP2.setRoundTopLeft(50);
        HeadP2.setRoundTopRight(50);
        HeadP2.setSolid(true);
        HeadP2.setLayout(new java.awt.BorderLayout());

        Produkterjual.setBackground(new java.awt.Color(0, 0, 0));
        Produkterjual.setFont(new java.awt.Font("Book Antiqua", 1, 18)); // NOI18N
        Produkterjual.setForeground(new java.awt.Color(255, 255, 255));
        Produkterjual.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Produkterjual.setText("Produk terjual");
        HeadP2.add(Produkterjual, java.awt.BorderLayout.CENTER);

        Panel2.add(HeadP2, java.awt.BorderLayout.NORTH);

        produkSaled.setFont(new java.awt.Font("Stencil", 1, 48)); // NOI18N
        produkSaled.setForeground(new java.awt.Color(0, 0, 0));
        produkSaled.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Panel2.add(produkSaled, java.awt.BorderLayout.CENTER);

        add(Panel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 350, 170));

        Panel1.setGradientDirection(komponen.PanelRound.Direction.VERTICAL);
        Panel1.setRoundBottomLeft(50);
        Panel1.setRoundBottomRight(50);
        Panel1.setRoundTopLeft(50);
        Panel1.setRoundTopRight(50);
        Panel1.setLayout(new java.awt.BorderLayout());

        HeadP1.setBackground(new java.awt.Color(66, 160, 255));
        HeadP1.setMaximumSize(new java.awt.Dimension(300, 40));
        HeadP1.setPreferredSize(new java.awt.Dimension(300, 40));
        HeadP1.setRoundTopLeft(50);
        HeadP1.setRoundTopRight(50);
        HeadP1.setSolid(true);
        HeadP1.setLayout(new java.awt.BorderLayout());

        Penjualanhariiini.setBackground(new java.awt.Color(0, 0, 0));
        Penjualanhariiini.setFont(new java.awt.Font("Book Antiqua", 1, 18)); // NOI18N
        Penjualanhariiini.setForeground(new java.awt.Color(255, 255, 255));
        Penjualanhariiini.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Penjualanhariiini.setText("Transaksi Hari Ini");
        HeadP1.add(Penjualanhariiini, java.awt.BorderLayout.CENTER);

        Panel1.add(HeadP1, java.awt.BorderLayout.NORTH);

        Sales.setFont(new java.awt.Font("Futura Md BT", 1, 48)); // NOI18N
        Sales.setForeground(new java.awt.Color(0, 0, 0));
        Sales.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Sales.setText("212");
        Panel1.add(Sales, java.awt.BorderLayout.CENTER);

        add(Panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 350, 170));

        Panel3.setGradientDirection(komponen.PanelRound.Direction.VERTICAL);
        Panel3.setRoundBottomLeft(50);
        Panel3.setRoundBottomRight(50);
        Panel3.setRoundTopLeft(50);
        Panel3.setRoundTopRight(50);
        Panel3.setLayout(new java.awt.BorderLayout());

        MoneyIn.setFont(new java.awt.Font("Rockwell", 1, 48)); // NOI18N
        MoneyIn.setForeground(new java.awt.Color(0, 0, 0));
        MoneyIn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MoneyIn.setText("Rp100.000");
        Panel3.add(MoneyIn, java.awt.BorderLayout.CENTER);

        HeadP3.setBackground(new java.awt.Color(66, 160, 255));
        HeadP3.setMaximumSize(new java.awt.Dimension(300, 40));
        HeadP3.setPreferredSize(new java.awt.Dimension(300, 40));
        HeadP3.setRoundTopLeft(50);
        HeadP3.setRoundTopRight(50);
        HeadP3.setSolid(true);
        HeadP3.setLayout(new java.awt.BorderLayout());

        Uangmasukhariini.setBackground(new java.awt.Color(0, 0, 0));
        Uangmasukhariini.setFont(new java.awt.Font("Book Antiqua", 1, 18)); // NOI18N
        Uangmasukhariini.setForeground(new java.awt.Color(255, 255, 255));
        Uangmasukhariini.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Uangmasukhariini.setText("Uang masuk hari ini");
        HeadP3.add(Uangmasukhariini, java.awt.BorderLayout.CENTER);

        Panel3.add(HeadP3, java.awt.BorderLayout.NORTH);

        add(Panel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, 350, 170));

        Keterangan.setBackground(new java.awt.Color(51, 204, 255));
        Keterangan.setSolid(true);
        Keterangan.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setPreferredSize(new java.awt.Dimension(400, 406));

        stokProduk.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "No", "Nama Produk", "Terjual", "Sisa Stok"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        stokProduk.setPreferredScrollableViewportSize(new java.awt.Dimension(350, 400));
        stokProduk.setPreferredSize(new java.awt.Dimension(285, 80));
        jScrollPane1.setViewportView(stokProduk);
        if (stokProduk.getColumnModel().getColumnCount() > 0) {
            stokProduk.getColumnModel().getColumn(0).setMinWidth(30);
            stokProduk.getColumnModel().getColumn(0).setPreferredWidth(30);
            stokProduk.getColumnModel().getColumn(0).setMaxWidth(30);
            stokProduk.getColumnModel().getColumn(2).setMinWidth(80);
            stokProduk.getColumnModel().getColumn(2).setPreferredWidth(80);
            stokProduk.getColumnModel().getColumn(2).setMaxWidth(80);
            stokProduk.getColumnModel().getColumn(3).setMinWidth(80);
            stokProduk.getColumnModel().getColumn(3).setPreferredWidth(80);
            stokProduk.getColumnModel().getColumn(3).setMaxWidth(80);
        }

        Keterangan.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        headKeterangan.setBackground(new java.awt.Color(66, 160, 255));
        headKeterangan.setPreferredSize(new java.awt.Dimension(780, 40));
        headKeterangan.setRoundTopLeft(50);
        headKeterangan.setRoundTopRight(50);
        headKeterangan.setSolid(true);
        headKeterangan.setLayout(new java.awt.BorderLayout());

        Produk.setFont(new java.awt.Font("Perpetua", 1, 24)); // NOI18N
        Produk.setForeground(new java.awt.Color(255, 255, 255));
        Produk.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Produk.setText("Keterangan Produk");
        Produk.setPreferredSize(new java.awt.Dimension(410, 16));
        headKeterangan.add(Produk, java.awt.BorderLayout.CENTER);

        Keterangan.add(headKeterangan, java.awt.BorderLayout.NORTH);

        add(Keterangan, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, 780, 570));

        Cetak.setBackground(new java.awt.Color(0, 255, 0));
        Cetak.setFont(new java.awt.Font("Dubai Medium", 1, 14)); // NOI18N
        Cetak.setForeground(new java.awt.Color(0, 0, 0));
        Cetak.setText("Cetak");
        add(Cetak, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 600, 140, 40));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cetak;
    private komponen.PanelRound HeadP1;
    private komponen.PanelRound HeadP2;
    private komponen.PanelRound HeadP3;
    private komponen.PanelRound Keterangan;
    private javax.swing.JLabel MoneyIn;
    private komponen.PanelRound Panel1;
    private komponen.PanelRound Panel2;
    private komponen.PanelRound Panel3;
    private javax.swing.JLabel Penjualanhariiini;
    private javax.swing.JLabel Produk;
    private javax.swing.JLabel Produkterjual;
    private javax.swing.JLabel Sales;
    private javax.swing.JLabel Uangmasukhariini;
    private komponen.PanelRound headKeterangan;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel produkSaled;
    private komponen.Tabel_c stokProduk;
    // End of variables declaration//GEN-END:variables
}
