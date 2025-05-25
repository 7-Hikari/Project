package Transaksi;

import DAO.*;
import DataMaster.kom.OnlyNum;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.event.TableModelEvent;

//@author RIZKI NABIL P

public class dataKulakan extends komponen.PanelRound {
    
    private int no, ttl;
    private DefaultTableModel tk = null;
    private DefaultTableModel tp = null;
    private List<pembelianDetailData> pemDetDat;
    
    public dataKulakan() {
        initComponents();
        
        setGradient(new Color(0x2CBAC6), new Color(0x48A3EE));
        
        tk = (DefaultTableModel) TabelKonversi.getModel();
        tp = (DefaultTableModel) TabelPembelian.getModel();
        
        tp.addTableModelListener(e -> {
            if (e.getType() == TableModelEvent.UPDATE) {
                int col = e.getColumn();
                if (col == 4 || col == TableModelEvent.ALL_COLUMNS) {
                    
                    upTotal();
                }
            }
        });

        loadProdukBahan();
    }
    
    private void loadProdukBahan() {
        JCheckBox check;
        
        for(produkData proDat : DataCache.getProduk()){
            check = new JCheckBox(proDat.get_nama());
            check.putClientProperty("data", proDat);
            pProd.add(check);
        }

        for (bahanData bahdat : bahanObjek.getAllBahan()) {
            check = new JCheckBox(bahdat.get_nama_b());
            check.putClientProperty("data", bahdat);
            if (bahdat.get_kategori()) {
                pKons.add(check);
            } else {
                pNKons.add(check);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        Panelprodukbahan = new javax.swing.JPanel();
        Total = new javax.swing.JTextField();
        Simpan = new javax.swing.JButton();
        Konversi = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TabelKonversi = new komponen.Tabel_c();
        jScrollPane5 = new javax.swing.JScrollPane();
        TabelPembelian = new komponen.Tabel_c();
        jLabel4 = new javax.swing.JLabel();
        PanelBahan = new javax.swing.JPanel();
        skrolProd = new javax.swing.JScrollPane();
        pProd = new komponen.PanelRound();
        skrolKons = new javax.swing.JScrollPane();
        pKons = new komponen.PanelRound();
        skrolNkons = new javax.swing.JScrollPane();
        pNKons = new komponen.PanelRound();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Pindahkan = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        Hapus = new javax.swing.JButton();
        panelRound1 = new komponen.PanelRound();
        jLabel2 = new javax.swing.JLabel();
        panelRound2 = new komponen.PanelRound();
        jLabel3 = new javax.swing.JLabel();
        panelRound3 = new komponen.PanelRound();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(51, 255, 255));
        setGradientDirection(komponen.PanelRound.Direction.VERTICAL);
        setMaximumSize(new java.awt.Dimension(1250, 650));
        setMinimumSize(new java.awt.Dimension(1250, 650));
        setPreferredSize(new java.awt.Dimension(1250, 650));
        setRoundBottomLeft(100);
        setRoundBottomRight(100);
        setRoundTopLeft(100);
        setRoundTopRight(100);
        setSolid(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(1250, 650));
        jPanel1.setMinimumSize(new java.awt.Dimension(1250, 650));
        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(1250, 650));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setMaximumSize(new java.awt.Dimension(1250, 22));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1250, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 25, 1250, -1));

        Panelprodukbahan.setBackground(new java.awt.Color(51, 51, 255));
        Panelprodukbahan.setMaximumSize(new java.awt.Dimension(1240, 600));
        Panelprodukbahan.setOpaque(false);
        Panelprodukbahan.setPreferredSize(new java.awt.Dimension(1240, 600));
        Panelprodukbahan.setRequestFocusEnabled(false);

        Total.setEditable(false);
        Total.setBackground(new java.awt.Color(255, 255, 255));
        Total.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        Total.setForeground(new java.awt.Color(0, 0, 0));
        Total.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Total.setText("Rp0,00");

        Simpan.setBackground(new java.awt.Color(0, 102, 204));
        Simpan.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        Simpan.setForeground(new java.awt.Color(0, 0, 0));
        Simpan.setText("Simpan");
        Simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SimpanActionPerformed(evt);
            }
        });

        Konversi.setBackground(new java.awt.Color(0, 102, 204));
        Konversi.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        Konversi.setForeground(new java.awt.Color(0, 0, 0));
        Konversi.setText("Konversi");
        Konversi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KonversiActionPerformed(evt);
            }
        });

        TabelKonversi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "ProBah", "Nama", "Berat (g)", "Harga", "(g)/satuan"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TabelKonversi.setCellFont(new java.awt.Font("Fira Sans Medium", 1, 11)); // NOI18N
        TabelKonversi.setFont(new java.awt.Font("Fira Sans SemiBold", 0, 13)); // NOI18N
        TabelKonversi.setHeaderBackgroundColor(new java.awt.Color(0, 153, 255));
        TabelKonversi.setHeaderFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        jScrollPane2.setViewportView(TabelKonversi);
        if (TabelKonversi.getColumnModel().getColumnCount() > 0) {
            TabelKonversi.getColumnModel().getColumn(0).setMinWidth(25);
            TabelKonversi.getColumnModel().getColumn(0).setPreferredWidth(25);
            TabelKonversi.getColumnModel().getColumn(0).setMaxWidth(25);
            TabelKonversi.getColumnModel().getColumn(1).setMinWidth(0);
            TabelKonversi.getColumnModel().getColumn(1).setPreferredWidth(0);
            TabelKonversi.getColumnModel().getColumn(1).setMaxWidth(0);
            TabelKonversi.getColumnModel().getColumn(3).setMinWidth(90);
            TabelKonversi.getColumnModel().getColumn(3).setPreferredWidth(90);
            TabelKonversi.getColumnModel().getColumn(3).setMaxWidth(90);
            TabelKonversi.getColumnModel().getColumn(5).setMinWidth(80);
            TabelKonversi.getColumnModel().getColumn(5).setPreferredWidth(80);
            TabelKonversi.getColumnModel().getColumn(5).setMaxWidth(80);
        }

        TabelPembelian.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "ProBah", "Nama", "Jml", "Harga", "pembagi"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.String.class, java.lang.Short.class, java.lang.Integer.class, java.lang.Short.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TabelPembelian.setCellFont(new java.awt.Font("Fira Sans Medium", 1, 11)); // NOI18N
        TabelPembelian.setFont(new java.awt.Font("Fira Sans SemiBold", 1, 13)); // NOI18N
        TabelPembelian.setHeaderBackgroundColor(new java.awt.Color(0, 153, 255));
        TabelPembelian.setName(""); // NOI18N
        TabelPembelian.setShowGrid(true);
        jScrollPane5.setViewportView(TabelPembelian);
        if (TabelPembelian.getColumnModel().getColumnCount() > 0) {
            TabelPembelian.getColumnModel().getColumn(0).setMinWidth(25);
            TabelPembelian.getColumnModel().getColumn(0).setPreferredWidth(25);
            TabelPembelian.getColumnModel().getColumn(0).setMaxWidth(25);
            TabelPembelian.getColumnModel().getColumn(1).setMinWidth(0);
            TabelPembelian.getColumnModel().getColumn(1).setPreferredWidth(0);
            TabelPembelian.getColumnModel().getColumn(1).setMaxWidth(0);
            TabelPembelian.getColumnModel().getColumn(3).setMinWidth(40);
            TabelPembelian.getColumnModel().getColumn(3).setPreferredWidth(40);
            TabelPembelian.getColumnModel().getColumn(3).setMaxWidth(40);
            TabelPembelian.getColumnModel().getColumn(5).setMinWidth(0);
            TabelPembelian.getColumnModel().getColumn(5).setPreferredWidth(0);
            TabelPembelian.getColumnModel().getColumn(5).setMaxWidth(0);
        }

        jLabel4.setFont(new java.awt.Font("Century Schoolbook", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Total");

        PanelBahan.setBackground(new java.awt.Color(255, 102, 204));
        PanelBahan.setOpaque(false);
        PanelBahan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        skrolProd.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        pProd.setBackground(new java.awt.Color(138, 231, 255));
        pProd.setGradientDirection(komponen.PanelRound.Direction.VERTICAL);
        pProd.setSolid(true);
        pProd.setLayout(new java.awt.GridLayout(0, 2, 1, 2));
        skrolProd.setViewportView(pProd);

        PanelBahan.add(skrolProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 190, 100));

        skrolKons.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        pKons.setBackground(new java.awt.Color(138, 231, 255));
        pKons.setSolid(true);
        pKons.setLayout(new java.awt.GridLayout(0, 2, 1, 2));
        skrolKons.setViewportView(pKons);

        PanelBahan.add(skrolKons, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 190, 130));

        skrolNkons.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        pNKons.setBackground(new java.awt.Color(138, 231, 255));
        pNKons.setGradientDirection(komponen.PanelRound.Direction.DIAGONAL);
        pNKons.setSolid(true);
        pNKons.setLayout(new java.awt.GridLayout(0, 2, 1, 2));
        skrolNkons.setViewportView(pNKons);

        PanelBahan.add(skrolNkons, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 190, 90));

        jLabel5.setFont(new java.awt.Font("Century Schoolbook", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Non-Konsumsi");
        PanelBahan.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 130, -1));

        jLabel6.setFont(new java.awt.Font("Century Schoolbook", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Bahan Utama Produk");
        PanelBahan.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 190, -1));

        Pindahkan.setBackground(new java.awt.Color(51, 255, 51));
        Pindahkan.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        Pindahkan.setForeground(new java.awt.Color(0, 0, 0));
        Pindahkan.setText("Ambil");
        Pindahkan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PindahkanActionPerformed(evt);
            }
        });
        PanelBahan.add(Pindahkan, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 450, -1, -1));

        jLabel7.setFont(new java.awt.Font("Century Schoolbook", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Konsumsi");
        PanelBahan.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 120, -1));

        Hapus.setBackground(new java.awt.Color(255, 0, 0));
        Hapus.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        Hapus.setForeground(new java.awt.Color(0, 0, 0));
        Hapus.setText("Hapus");
        Hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HapusActionPerformed(evt);
            }
        });

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));
        panelRound1.setRoundBottomLeft(25);
        panelRound1.setRoundBottomRight(25);
        panelRound1.setRoundTopLeft(25);
        panelRound1.setRoundTopRight(25);
        panelRound1.setSolid(true);

        jLabel2.setFont(new java.awt.Font("Century Schoolbook", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Konversi Bahan Konsumsi");

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(17, 17, 17))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2))
        );

        panelRound2.setBackground(new java.awt.Color(255, 255, 255));
        panelRound2.setRoundBottomLeft(30);
        panelRound2.setRoundBottomRight(30);
        panelRound2.setRoundTopLeft(30);
        panelRound2.setRoundTopRight(30);
        panelRound2.setSolid(true);

        jLabel3.setFont(new java.awt.Font("Century Schoolbook", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Pembelian");

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound2Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(18, 18, 18))
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3))
        );

        panelRound3.setBackground(new java.awt.Color(255, 255, 255));
        panelRound3.setRoundBottomLeft(30);
        panelRound3.setRoundBottomRight(30);
        panelRound3.setRoundTopLeft(30);
        panelRound3.setRoundTopRight(30);
        panelRound3.setSolid(true);

        jLabel1.setFont(new java.awt.Font("Century Schoolbook", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Daftar Bahan");

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );

        javax.swing.GroupLayout PanelprodukbahanLayout = new javax.swing.GroupLayout(Panelprodukbahan);
        Panelprodukbahan.setLayout(PanelprodukbahanLayout);
        PanelprodukbahanLayout.setHorizontalGroup(
            PanelprodukbahanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelprodukbahanLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Konversi, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(236, 236, 236)
                .addComponent(Hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(179, 179, 179)
                .addComponent(Simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(145, 145, 145))
            .addGroup(PanelprodukbahanLayout.createSequentialGroup()
                .addGroup(PanelprodukbahanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelprodukbahanLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(180, 180, 180)
                        .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelprodukbahanLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(PanelBahan, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(PanelprodukbahanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelprodukbahanLayout.createSequentialGroup()
                        .addGroup(PanelprodukbahanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelprodukbahanLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(88, 88, 88)
                                .addComponent(Total, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelprodukbahanLayout.createSequentialGroup()
                        .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(151, 151, 151))))
        );
        PanelprodukbahanLayout.setVerticalGroup(
            PanelprodukbahanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelprodukbahanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelprodukbahanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelprodukbahanLayout.createSequentialGroup()
                        .addGroup(PanelprodukbahanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelprodukbahanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelprodukbahanLayout.createSequentialGroup()
                                .addGap(0, 8, Short.MAX_VALUE)
                                .addComponent(PanelBahan, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelprodukbahanLayout.createSequentialGroup()
                                .addGroup(PanelprodukbahanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(PanelprodukbahanLayout.createSequentialGroup()
                                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(PanelprodukbahanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel4)
                                            .addComponent(Total, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(PanelprodukbahanLayout.createSequentialGroup()
                        .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(PanelprodukbahanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelprodukbahanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Simpan)
                        .addComponent(Hapus))
                    .addComponent(Konversi))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel1.add(Panelprodukbahan, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 53, 1240, 600));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void PindahkanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PindahkanActionPerformed
        for (Component comp : pProd.getComponents()) {
        if (comp instanceof JCheckBox cb && cb.isSelected()) {
            produkData prod = (produkData) cb.getClientProperty("data");
            if (!sudahAdaObjekDiTabel(tk, prod)) {
                tk.addRow(new Object[]{tk.getRowCount() + 1, prod, prod.get_nama(), null, null, null});
            }
        }
    }

    for (Component comp : pKons.getComponents()) {
        if (comp instanceof JCheckBox cb && cb.isSelected()) {
            bahanData bah = (bahanData) cb.getClientProperty("data");
            if (!sudahAdaObjekDiTabel(tk, bah)) {
                tk.addRow(new Object[]{tk.getRowCount() + 1, bah, bah.get_nama_b(), null, null, null});
            }
        }
    }

    for (Component comp : pNKons.getComponents()) {
        if (comp instanceof JCheckBox cb && cb.isSelected()) {
            bahanData bah = (bahanData) cb.getClientProperty("data");
            if (!sudahAdaObjekDiTabel(tp, bah)) {
                tp.addRow(new Object[]{tp.getRowCount() + 1, bah, bah.get_nama_b(), 1, null, null});
            }
        }
    }
        resetCheckboxes(pKons);
        resetCheckboxes(pProd);
        resetCheckboxes(pNKons);
        upTotal();
    }//GEN-LAST:event_PindahkanActionPerformed

    private void KonversiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KonversiActionPerformed
        for (int i = 0; i < tk.getRowCount(); i++) {
            Object obj = tk.getValueAt(i, 1);
            switch (obj) {
                case bahanData bah -> prosesKonversi(bah, i);
                case produkData prod -> prosesKonversi(prod, i);
                default -> {
                    continue;
                }
            }
        }
        tk.setRowCount(0);
        upTotal();
    }//GEN-LAST:event_KonversiActionPerformed

    private void HapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HapusActionPerformed
        int barisKonversi = TabelKonversi.getSelectedRow();
        int barisPembelian = TabelPembelian.getSelectedRow();

        if (barisKonversi != -1) {
            tk.removeRow(barisKonversi);
        } else if (barisPembelian != -1) {
            tp.removeRow(barisPembelian);
        }
        no_urut();
        upTotal();
    }//GEN-LAST:event_HapusActionPerformed

    private void SimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SimpanActionPerformed
        pemDetDat = ambilDataTabel();
        transaksiObjek.simpanBeli(ttl, pemDetDat);
        tp.setRowCount(0);
        no_urut();
        upTotal();
    }//GEN-LAST:event_SimpanActionPerformed

    private List<pembelianDetailData> ambilDataTabel(){
        List<pembelianDetailData> list = new ArrayList<>();
        
        for(no = 0; no < TabelPembelian.getRowCount(); no++){
            Object item = tp.getValueAt(no, 1);
            short jumlah = Short.parseShort(tp.getValueAt(no, 3).toString());
            int harga = Integer.parseInt(tp.getValueAt(no, 4).toString());
            boolean konsumsi = true;
            short pembagi = 0;
            if (item instanceof bahanData bah) {
                konsumsi = bah.get_kategori();
                if(konsumsi) pembagi = Short.parseShort(tp.getValueAt(no, 5).toString());
            } else if (item instanceof produkData) {
                konsumsi = true;
                pembagi = Short.parseShort(tp.getValueAt(no, 5).toString());
            }
            
            list.add(new pembelianDetailData(item, jumlah, konsumsi, pembagi, harga));
        }
        return list;
    }
    
    private void prosesKonversi(bahanData bah, int row) {
        String nama = tk.getValueAt(row, 2).toString();
        int berat = Integer.parseInt(tk.getValueAt(row, 3).toString());
        int harga = Integer.parseInt(tk.getValueAt(row, 4).toString());
        int pembagi = Integer.parseInt(tk.getValueAt(row, 5).toString());

        short jumlah = (short) Math.round((double) berat / pembagi);

        if (!sudahAdaObjekDiTabel(tp, bah)) {
            tp.addRow(new Object[]{
                tp.getRowCount() + 1,
                bah,
                nama,
                jumlah,
                harga,
                pembagi
            });
        }
    }

    private void prosesKonversi(produkData prod, int row) {
        String nama = tk.getValueAt(row, 2).toString();
        int berat = Integer.parseInt(tk.getValueAt(row, 3).toString());
        int harga = Integer.parseInt(tk.getValueAt(row, 4).toString());
        int pembagi = Integer.parseInt(tk.getValueAt(row, 5).toString());

        short jumlah = (short) Math.round((double) berat / pembagi);

        if (!sudahAdaObjekDiTabel(tp, prod)) {
            tp.addRow(new Object[]{
                tp.getRowCount() + 1,
                prod,
                nama,
                jumlah,
                harga,
                pembagi
            });
        }
    }

    private void upTotal() {
        ttl = 0;
        for (int row = 0; row < TabelPembelian.getRowCount(); row++) {
            Object nilai = TabelPembelian.getValueAt(row, 4);
            if (nilai != null) {
                ttl += Integer.parseInt(nilai.toString());
            }
        }
        String forfield = OnlyNum.Rp.format(ttl);
        Total.setText(String.valueOf(forfield));
    }
    
    private void no_urut(){
        for (no = 1; no <= TabelKonversi.getRowCount(); no++){
            TabelKonversi.setValueAt(no, no - 1, 0);
        }
        for (no = 1; no <= TabelPembelian.getRowCount(); no++){
            TabelPembelian.setValueAt(no, no - 1, 0);
        }
    }

    private boolean sudahAdaObjekDiTabel(DefaultTableModel model, Object target) {
        for (int i = 0; i < model.getRowCount(); i++) {
            Object obj = model.getValueAt(i, 1); // kolom objek
            if (obj != null && obj.equals(target)) {
                return true;
            }
        }
        return false;
    }


    private void resetCheckboxes(JPanel panel) {
        for (Component comp : panel.getComponents()) {
            if (comp instanceof JCheckBox cb) {
                cb.setSelected(false);
            }
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Hapus;
    private javax.swing.JButton Konversi;
    private javax.swing.JPanel PanelBahan;
    private javax.swing.JPanel Panelprodukbahan;
    private javax.swing.JButton Pindahkan;
    private javax.swing.JButton Simpan;
    private komponen.Tabel_c TabelKonversi;
    private komponen.Tabel_c TabelPembelian;
    private javax.swing.JTextField Total;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private komponen.PanelRound pKons;
    private komponen.PanelRound pNKons;
    private komponen.PanelRound pProd;
    private komponen.PanelRound panelRound1;
    private komponen.PanelRound panelRound2;
    private komponen.PanelRound panelRound3;
    private javax.swing.JScrollPane skrolKons;
    private javax.swing.JScrollPane skrolNkons;
    private javax.swing.JScrollPane skrolProd;
    // End of variables declaration//GEN-END:variables
}
