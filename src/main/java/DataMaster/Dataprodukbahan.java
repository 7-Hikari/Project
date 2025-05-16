package DataMaster;

import DAO.bahanData;
import DAO.bahanObjek;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import javax.swing.JOptionPane;
 // @author RIZKI NABIL P

public class Dataprodukbahan extends javax.swing.JPanel {

    private DefaultTableModel tB = null;
    private int no = 1;
    private String nama, kateg;
    private short jml, id;
    private bahanData bD = null;
    
    public Dataprodukbahan() {
        initComponents();
        setSize(1200, 620);
        
        tB = (DefaultTableModel) tabelBahan.getModel();
        loadBahan();
        tabelBahan.setHeaderBackgroundColor(new Color(0x2CBAC6));
        
        tabelBahan.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt){
                if (evt.getClickCount() == 2 && tabelBahan.getSelectedRow() != -1){
                    no = tabelBahan.getSelectedRow();
                    
                    id = (short) tabelBahan.getValueAt(no, 1);
                    NamaBahan.setText(tabelBahan.getValueAt(no, 2).toString());
                    Kategori.setSelectedItem(tabelBahan.getValueAt(no, 3));
                    Jumlah.setText(tabelBahan.getValueAt(no, 4).toString());
                    Simpan.setText("Update");
                }
            }
        });
    }
    
    private void loadBahan(){
        no = 1;
        tB.setRowCount(0);
        List<bahanData> daftarBahan = bahanObjek.getAllBahan();
        
        for(bahanData dat : daftarBahan){
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelBahan = new komponen.Tabel_c();
        panelRound1 = new komponen.PanelRound();
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

        setBackground(new java.awt.Color(204, 204, 204));
        setMaximumSize(new java.awt.Dimension(1247, 464));
        setMinimumSize(new java.awt.Dimension(1247, 464));
        setPreferredSize(new java.awt.Dimension(1247, 464));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setMaximumSize(new java.awt.Dimension(680, 473));
        jPanel1.setMinimumSize(new java.awt.Dimension(680, 473));
        jPanel1.setPreferredSize(new java.awt.Dimension(680, 473));

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
        jScrollPane2.setViewportView(tabelBahan);
        if (tabelBahan.getColumnModel().getColumnCount() > 0) {
            tabelBahan.getColumnModel().getColumn(0).setMinWidth(35);
            tabelBahan.getColumnModel().getColumn(0).setPreferredWidth(35);
            tabelBahan.getColumnModel().getColumn(0).setMaxWidth(35);
            tabelBahan.getColumnModel().getColumn(1).setMinWidth(0);
            tabelBahan.getColumnModel().getColumn(1).setPreferredWidth(0);
            tabelBahan.getColumnModel().getColumn(1).setMaxWidth(0);
        }

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));
        panelRound1.setRoundBottomRight(100);
        panelRound1.setRoundTopRight(100);

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TitleFormLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PopUpTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        TitleFormLayout.setVerticalGroup(
            TitleFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TitleFormLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(PopUpTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(16, 16, 16))
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

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(Simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                        .addComponent(Hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Jumlah)
                    .addComponent(NamaBahan)
                    .addComponent(Kategori, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(47, Short.MAX_VALUE))
            .addComponent(TitleForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addComponent(TitleForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(NamaBahan, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Kategori, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 881, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 0, 1290, 481));
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
            loadBahan();
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
            loadBahan();
            JOptionPane.showMessageDialog(this, "Data diperbarui!", "Info", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }//GEN-LAST:event_SimpanActionPerformed

    private void HapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HapusActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Mau menghapus data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }
        Simpan.setText("Simpan");
        bD.setIdBahan(id);
        bahanObjek.deleteBahan(bD);
        JOptionPane.showMessageDialog(this, "Data telah dihapus!", "Info", JOptionPane.INFORMATION_MESSAGE);
        loadBahan();
    }//GEN-LAST:event_HapusActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private komponen.PanelRound panelRound1;
    private komponen.Tabel_c tabelBahan;
    // End of variables declaration//GEN-END:variables
}
