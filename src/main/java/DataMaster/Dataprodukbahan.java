package DataMaster;

import DAO.DataCache;
import DAO.bahanData;
import DAO.bahanObjek;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import komponen.PanelRound;
 // @author RIZKI NABIL P

public class Dataprodukbahan extends komponen.PanelRound {

    private DefaultTableModel tB = null;
    private int no = 1;
    private String nama, kateg;
    private short jml, id;
    private bahanData bD = new bahanData();
    
    public Dataprodukbahan() {
        initComponents();
        
        panelData.setGradientDirection(PanelRound.Direction.VERTICAL);
        setGradientDirection(PanelRound.Direction.VERTICAL);
        setGradient(new Color(0x2CC4C9), new Color(0x22EBC6));
        panelRound1.setGradientDirection(PanelRound.Direction.VERTICAL);
        panelRound1.setGradient(new Color(0x2CC4C9), new Color(0x22EBC6));
        TitleForm.setGradient(new Color(0,153,255), new Color(0,153,255));
        
        setSize(1200, 620);
        Get.setVisible(false);
        
        tB = (DefaultTableModel) tabelBahan.getModel();
        LoadBahan();
        
        tabelBahan.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt){
                if (tabelBahan.getSelectedRow() != -1){
                    Get.setVisible(true);
                }
            }
        });
    }
    
    private void LoadBahan(){
        no = 1;
        tB.setRowCount(0);
        DataCache.refreshBahan();
        for(bahanData dat : DataCache.getBahan()){
            tB.addRow(new Object[] {
                no++,
                dat.get_id_b(),
                dat.get_nama_b(),
                dat.getStatusKonsumsi(),
                dat.jumlah()
        });
        }
        NamaBahan.setText(null);
        Jumlah.setText(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound1 = new komponen.PanelRound();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelBahan = new komponen.Tabel_c();
        panelData = new komponen.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Jumlah = new javax.swing.JTextField();
        NamaBahan = new javax.swing.JTextField();
        Kategori = new javax.swing.JComboBox<>();
        Hapus = new javax.swing.JButton();
        TitleForm = new komponen.PanelRound();
        PopUpTitle = new javax.swing.JLabel();
        Simpan = new javax.swing.JButton();
        Get = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 204));
        setMaximumSize(new java.awt.Dimension(1237, 494));
        setMinimumSize(new java.awt.Dimension(1237, 494));
        setPreferredSize(new java.awt.Dimension(1237, 494));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound1.setMaximumSize(new java.awt.Dimension(1237, 410));
        panelRound1.setMinimumSize(new java.awt.Dimension(1237, 410));
        panelRound1.setPreferredSize(new java.awt.Dimension(1237, 410));
        panelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));

        tabelBahan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "id", "Nama Bahan", "Konsumsi", "Jumlah"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Short.class, java.lang.String.class, java.lang.String.class, java.lang.Short.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelBahan.setCellFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        tabelBahan.setHeaderBackgroundColor(new java.awt.Color(0, 153, 255));
        jScrollPane2.setViewportView(tabelBahan);
        if (tabelBahan.getColumnModel().getColumnCount() > 0) {
            tabelBahan.getColumnModel().getColumn(0).setMinWidth(35);
            tabelBahan.getColumnModel().getColumn(0).setPreferredWidth(35);
            tabelBahan.getColumnModel().getColumn(0).setMaxWidth(35);
            tabelBahan.getColumnModel().getColumn(1).setMinWidth(0);
            tabelBahan.getColumnModel().getColumn(1).setPreferredWidth(0);
            tabelBahan.getColumnModel().getColumn(1).setMaxWidth(0);
        }

        panelRound1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 480));

        panelData.setBackground(new java.awt.Color(255, 255, 255));
        panelData.setRoundBottomRight(100);
        panelData.setRoundTopRight(100);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Nama Bahan");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Kategori");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Jumlah ");

        Jumlah.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Jumlah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JumlahActionPerformed(evt);
            }
        });

        NamaBahan.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        Kategori.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        Kategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Konsumsi", "Non-Konsumsi" }));

        Hapus.setBackground(new java.awt.Color(255, 51, 51));
        Hapus.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        Hapus.setForeground(new java.awt.Color(0, 0, 0));
        Hapus.setText("Hapus");
        Hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HapusActionPerformed(evt);
            }
        });

        TitleForm.setBackground(new java.awt.Color(0, 153, 255));
        TitleForm.setRoundTopRight(100);

        PopUpTitle.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        PopUpTitle.setForeground(new java.awt.Color(0, 0, 0));
        PopUpTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PopUpTitle.setText("Bahan");
        PopUpTitle.setToolTipText("");

        javax.swing.GroupLayout TitleFormLayout = new javax.swing.GroupLayout(TitleForm);
        TitleForm.setLayout(TitleFormLayout);
        TitleFormLayout.setHorizontalGroup(
            TitleFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PopUpTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        TitleFormLayout.setVerticalGroup(
            TitleFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TitleFormLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(PopUpTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );

        Simpan.setBackground(new java.awt.Color(0, 204, 51));
        Simpan.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        Simpan.setForeground(new java.awt.Color(0, 0, 0));
        Simpan.setText("Simpan");
        Simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SimpanActionPerformed(evt);
            }
        });

        Get.setBackground(new java.awt.Color(0, 204, 51));
        Get.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Get.setForeground(new java.awt.Color(0, 0, 0));
        Get.setText("Ambil");
        Get.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDataLayout = new javax.swing.GroupLayout(panelData);
        panelData.setLayout(panelDataLayout);
        panelDataLayout.setHorizontalGroup(
            panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDataLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDataLayout.createSequentialGroup()
                        .addComponent(Simpan)
                        .addGap(32, 32, 32)
                        .addComponent(Get)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Hapus)
                        .addGap(52, 52, 52))
                    .addGroup(panelDataLayout.createSequentialGroup()
                        .addGroup(panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(panelDataLayout.createSequentialGroup()
                                .addGroup(panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(80, 80, 80)
                                .addGroup(panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Kategori, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(NamaBahan, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Jumlah, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(44, Short.MAX_VALUE))))
            .addComponent(TitleForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelDataLayout.setVerticalGroup(
            panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDataLayout.createSequentialGroup()
                .addComponent(TitleForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addGroup(panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(NamaBahan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72)
                .addGroup(panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Kategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68)
                .addGroup(panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(Jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addGroup(panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Simpan)
                    .addComponent(Hapus)
                    .addComponent(Get))
                .addGap(21, 21, 21))
        );

        panelRound1.add(panelData, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 0, 370, 480));

        add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1210, 500));
    }// </editor-fold>//GEN-END:initComponents

    private void JumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JumlahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JumlahActionPerformed

    private void SimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SimpanActionPerformed
        nama = NamaBahan.getText();
        kateg = Kategori.getSelectedItem().toString();
        jml = 1;

        if (Simpan.getText().equals("Simpan")) {
            bD = new bahanData(nama, bahanData.parseKonsumsi(kateg), jml);
            bahanObjek.insertBahan(bD);
            LoadBahan();
            JOptionPane.showMessageDialog(this, "Data tersimpan!", "Info", JOptionPane.INFORMATION_MESSAGE);
        } else if (Simpan.getText().equals("Update")) {
            jml = Short.parseShort(Jumlah.getText());
            if (jml < 0 || jml > Short.MAX_VALUE) {
                JOptionPane.showMessageDialog(this, "Batas jumlah antara 0 hingga 32,767", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            bD = new bahanData(id, nama, bahanData.parseKonsumsi(kateg), jml);
            bahanObjek.updateBahan(bD);
            Simpan.setText("Simpan");
            LoadBahan();
            JOptionPane.showMessageDialog(this, "Data diperbarui!", "Info", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }//GEN-LAST:event_SimpanActionPerformed

    private void HapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HapusActionPerformed
        no = tabelBahan.getSelectedRow();
        int confirm = JOptionPane.showConfirmDialog(this, "Mau menghapus data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }
        Simpan.setText("Simpan");
        id = (short) tabelBahan.getValueAt(no, 1);
        bahanObjek.deleteBahan(id);
        JOptionPane.showMessageDialog(this, "Data telah dihapus!", "Info", JOptionPane.INFORMATION_MESSAGE);
        LoadBahan();
    }//GEN-LAST:event_HapusActionPerformed

    private void GetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GetActionPerformed
        if (tabelBahan.getSelectedRow() != -1){
        no = tabelBahan.getSelectedRow();

        id = (short) tabelBahan.getValueAt(no, 1);
        NamaBahan.setText(tabelBahan.getValueAt(no, 2).toString());
        Kategori.setSelectedItem(tabelBahan.getValueAt(no, 3));
        Jumlah.setText(tabelBahan.getValueAt(no, 4).toString());
        Simpan.setText("Update");
        Get.setVisible(false);
        }
    }//GEN-LAST:event_GetActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Get;
    private javax.swing.JButton Hapus;
    private javax.swing.JTextField Jumlah;
    private javax.swing.JComboBox<String> Kategori;
    private javax.swing.JTextField NamaBahan;
    private javax.swing.JLabel PopUpTitle;
    private javax.swing.JButton Simpan;
    private komponen.PanelRound TitleForm;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private komponen.PanelRound panelData;
    private komponen.PanelRound panelRound1;
    private komponen.Tabel_c tabelBahan;
    // End of variables declaration//GEN-END:variables
}
