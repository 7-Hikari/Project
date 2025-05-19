package DataMaster;

import DAO.*;
import java.awt.Component;
import java.text.NumberFormat;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.Locale;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.event.TableModelEvent;

//@author RIZKI NABIL P

public class Datapembelianbahankulakan extends komponen.PanelRound {
    
    private int no, ttl;
    private DefaultTableModel tk = null;
    private DefaultTableModel tp = null;
    private pembelianData pemDat = null;
    private List<pembelianDetailData> pemDetDat;
    private final NumberFormat Rp = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
    
    public Datapembelianbahankulakan() {
        initComponents();
        
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

        loadBahan();
    }
    
    private void loadBahan() {
        List<bahanData> daftarBahan = bahanObjek.getAllBahan();

        for (bahanData bahdat : daftarBahan) {
            JCheckBox check = new JCheckBox(bahdat.get_nama_b());
            check.putClientProperty("id", bahdat.get_id_b());

            if ("Konsumsi".equalsIgnoreCase(bahdat.getStatusKonsumsi())) {
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        PanelBahan = new javax.swing.JPanel();
        skrolKons = new javax.swing.JScrollPane();
        pKons = new javax.swing.JPanel();
        skrolNkons = new javax.swing.JScrollPane();
        pNKons = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Pindahkan = new javax.swing.JButton();
        Hapus = new javax.swing.JButton();

        setBackground(new java.awt.Color(51, 255, 255));
        setMaximumSize(new java.awt.Dimension(1250, 650));
        setMinimumSize(new java.awt.Dimension(1250, 650));
        setPreferredSize(new java.awt.Dimension(1250, 650));
        setRoundBottomLeft(100);
        setRoundBottomRight(100);
        setRoundTopLeft(100);
        setRoundTopRight(100);

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

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 25, -1, -1));

        Panelprodukbahan.setBackground(new java.awt.Color(51, 51, 255));
        Panelprodukbahan.setOpaque(false);

        Total.setEditable(false);
        Total.setBackground(new java.awt.Color(255, 255, 255));
        Total.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        Total.setForeground(new java.awt.Color(0, 0, 0));
        Total.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Total.setText("Rp0,00");

        Simpan.setBackground(new java.awt.Color(0, 204, 51));
        Simpan.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        Simpan.setForeground(new java.awt.Color(0, 0, 0));
        Simpan.setText("Simpan");
        Simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SimpanActionPerformed(evt);
            }
        });

        Konversi.setBackground(new java.awt.Color(204, 204, 0));
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
                "No", "Id_bahan", "Nama", "Berat (g)", "Harga", "(g)/satuan"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
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
        TabelKonversi.setHeaderBackgroundColor(new java.awt.Color(0, 204, 255));
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
                "No", "Id_bahan", "Nama", "Jml", "Harga"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Short.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
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
        TabelPembelian.setHeaderBackgroundColor(new java.awt.Color(0, 204, 255));
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
        }

        jLabel1.setFont(new java.awt.Font("Century Schoolbook", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Daftar Bahan");

        jLabel2.setFont(new java.awt.Font("Century Schoolbook", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Konversi Bahan Konsumsi");

        jLabel3.setFont(new java.awt.Font("Century Schoolbook", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Pembelian");

        jLabel4.setFont(new java.awt.Font("Century Schoolbook", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Total");

        PanelBahan.setBackground(new java.awt.Color(255, 102, 204));
        PanelBahan.setOpaque(false);
        PanelBahan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        skrolKons.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        pKons.setBackground(new java.awt.Color(0, 204, 255));
        pKons.setLayout(new java.awt.GridLayout(0, 2, 2, 2));
        skrolKons.setViewportView(pKons);

        PanelBahan.add(skrolKons, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 180, 170));

        skrolNkons.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        pNKons.setBackground(new java.awt.Color(0, 204, 255));
        pNKons.setLayout(new java.awt.GridLayout(0, 2, 2, 2));
        skrolNkons.setViewportView(pNKons);

        PanelBahan.add(skrolNkons, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 180, 180));

        jLabel5.setFont(new java.awt.Font("Century Schoolbook", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Non-Konsumsi");
        PanelBahan.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 130, -1));

        jLabel6.setFont(new java.awt.Font("Century Schoolbook", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Konsumsi");
        PanelBahan.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 120, -1));

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

        Hapus.setBackground(new java.awt.Color(255, 0, 0));
        Hapus.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        Hapus.setForeground(new java.awt.Color(0, 0, 0));
        Hapus.setText("Hapus");
        Hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HapusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelprodukbahanLayout = new javax.swing.GroupLayout(Panelprodukbahan);
        Panelprodukbahan.setLayout(PanelprodukbahanLayout);
        PanelprodukbahanLayout.setHorizontalGroup(
            PanelprodukbahanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelprodukbahanLayout.createSequentialGroup()
                .addGroup(PanelprodukbahanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelprodukbahanLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(PanelBahan, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelprodukbahanLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel1)
                        .addGap(189, 189, 189)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 186, Short.MAX_VALUE)
                .addGroup(PanelprodukbahanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelprodukbahanLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(29, 29, 29)
                        .addComponent(Total, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelprodukbahanLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(135, 135, 135))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelprodukbahanLayout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(PanelprodukbahanLayout.createSequentialGroup()
                .addGap(397, 397, 397)
                .addComponent(Konversi, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(184, 184, 184)
                .addComponent(Simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117))
        );
        PanelprodukbahanLayout.setVerticalGroup(
            PanelprodukbahanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelprodukbahanLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(PanelprodukbahanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelprodukbahanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PanelBahan, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
                    .addGroup(PanelprodukbahanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelprodukbahanLayout.createSequentialGroup()
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(PanelprodukbahanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Total, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4)))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)))
                .addGap(27, 27, 27)
                .addGroup(PanelprodukbahanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Konversi)
                    .addComponent(Simpan)
                    .addComponent(Hapus))
                .addContainerGap(192, Short.MAX_VALUE))
        );

        jPanel1.add(Panelprodukbahan, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 53, 1240, -1));

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
        String nama;
        String id_bahan;
        for (Component comp : pKons.getComponents()) {
            if (comp instanceof JCheckBox cb) {
                if (cb.isSelected()) {
                    nama = cb.getText();
                    id_bahan = String.valueOf(cb.getClientProperty("id_bahan"));
                    if (!sudahAdaDiTabel(tk, nama)) {
                        tk.addRow(new Object[]{tk.getRowCount() + 1,id_bahan, nama, null, null, null});
                    }
                }
            }
        }

        for (Component comp : pNKons.getComponents()) {
            if (comp instanceof JCheckBox cb) {
                if (cb.isSelected()) {
                    nama = cb.getText();
                    id_bahan = String.valueOf(cb.getClientProperty("id_bahan"));
                    if (!sudahAdaDiTabel(tp, nama)) {
                        tp.addRow(new Object[]{tp.getRowCount() + 1, id_bahan, nama, 1, null});
                    }
                }
            }
        }
        resetCheckboxes(pKons);
        resetCheckboxes(pNKons);
        upTotal();
    }//GEN-LAST:event_PindahkanActionPerformed

    private void KonversiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KonversiActionPerformed
        String idBahan;
        String nama;
        int harga, berat;
        short i, jumlah, pembagi;
        for (i = 0; i < tk.getRowCount(); i++) {
            idBahan = String.valueOf(tk.getValueAt(i, 1));
            nama = String.valueOf(tk.getValueAt(i, 2));
            harga = 0;
            berat = Integer.parseInt(tk.getValueAt(i, 3).toString());
            pembagi = Short.parseShort(tk.getValueAt(i, 5).toString());
            jumlah = (short) Math.round((double) berat / pembagi);

            try {
                harga = Integer.parseInt(String.valueOf(tk.getValueAt(i, 4)));
            } catch (NumberFormatException e) {
            }

            if (!sudahAdaDiTabel(tp, nama)) {
                tp.addRow(new Object[]{
                    tp.getRowCount() + 1,
                    idBahan,
                    nama,
                    jumlah,
                    harga
                });
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
        
        
        tp.setRowCount(0);
        no_urut();
        upTotal();
    }//GEN-LAST:event_SimpanActionPerformed

    private void upTotal(){
        ttl = 0;
        for(int row =0; row < TabelPembelian.getRowCount(); row++) {
            Object nilai = TabelPembelian.getValueAt(row, 4);
            if (nilai !=null) {
                ttl += Integer.parseInt(nilai.toString());
            }
        }
        String forfield = Rp.format(ttl);
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
    
    private boolean sudahAdaDiTabel(DefaultTableModel model, String nama) {
        for (int i = 0; i < model.getRowCount(); i++) {
            if (nama.equalsIgnoreCase(String.valueOf(model.getValueAt(i, 1)))) {
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JPanel pKons;
    private javax.swing.JPanel pNKons;
    private javax.swing.JScrollPane skrolKons;
    private javax.swing.JScrollPane skrolNkons;
    // End of variables declaration//GEN-END:variables
}
