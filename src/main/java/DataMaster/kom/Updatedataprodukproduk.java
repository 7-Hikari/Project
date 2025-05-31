package DataMaster.kom;

import java.awt.Image;
import java.awt.Color;
import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import DAO.*;
import DataMaster.Dataprodukproduk;
import java.awt.Component;
import java.awt.Dimension;
import java.util.List;
import java.io.*;
import java.util.ArrayList;
import java.util.stream.Collectors;
import javax.swing.text.AbstractDocument;
import komponen.PanelRound;

public class Updatedataprodukproduk extends JPanel {
    private byte[] foto;
    private Dataprodukproduk.ProdukFormListener listener;
    private List<detailProdukData> bahanTerpilih;
    private produkData pDat;
    String np = "Nama Produk";
    private boolean dataBerubah = false;

    public void setDataBerubah(boolean berubah) {
        this.dataBerubah = berubah;
    }

    public boolean isDataBerubah() {
        return dataBerubah;
    }

    static void hanyaAngka(JTextField tf) {
    ((AbstractDocument) tf.getDocument()).setDocumentFilter(new OnlyNum());
}
    
    public Updatedataprodukproduk() {
        initComponents();
        loadCekbox();
        hanyaAngka(HargaP);
        hanyaAngka(stok);
        panelTitle.setGradientDirection(PanelRound.Direction.VERTICAL);
        Hapus.setVisible(false);
        Simpan.setLocation(400, 350);
        jLabelGambar.setMaximumSize(new Dimension(180,150));
    }
    
    public void setData(produkData pDat){
        this.pDat = pDat;
        foto = pDat.get_foto();
        if(foto != null){
        ImageIcon icon = new ImageIcon(foto);
        Image img = icon.getImage().getScaledInstance(180, 150, Image.SCALE_SMOOTH);
        jLabelGambar.setIcon(new ImageIcon(img));
        jLabelGambar.setText(null);
        } else {
            jLabelGambar.setText("No Image");
        }
        NamaP.setText(pDat.get_nama());
        HargaP.setText(Integer.toString(pDat.get_harga()));
        stok.setText(Short.toString(pDat.getStok()));
        
        byte x = pDat.get_id();
        loadCekbox(x);
        Simpan.setText("Update");
        Simpan.setLocation(320, 340);
        Hapus.setVisible(true);
    }
    
    private void loadCekbox(byte x){
        PanelBahan.removeAll();
        
        List<bahanData> listBahan = bahanObjek.getBahanKonsum();
        List<detailProdukData> bahanProduk = produkObjek.getBahanProduk(x);
        List<Short> idBahanProduk = bahanProduk.stream()
                .map(detailProdukData::getBahanId)
                .collect(Collectors.toList());
        
        for (bahanData b : listBahan) {
            JCheckBox cb = new JCheckBox(b.get_nama_b());
            cb.putClientProperty("id", b.get_id_b());
            cb.setForeground(Color.WHITE);
            cb.setBackground(new Color(0x5E3330));
            
            if (idBahanProduk.contains(b.get_id_b())) {
                cb.setSelected(true);
            }
            PanelBahan.add(cb);
        }
        PanelBahan.revalidate();
        PanelBahan.repaint();
    }
    
    private void loadCekbox(){
        PanelBahan.removeAll();
        
        List<bahanData> listBahan = bahanObjek.getBahanKonsum();
        for (bahanData b : listBahan) {
            JCheckBox cb = new JCheckBox(b.get_nama_b());
            cb.putClientProperty("id", b.get_id_b());
            cb.setForeground(Color.WHITE);
            cb.setBackground(new Color(0x5E3330));
            PanelBahan.add(cb);
        }
        PanelBahan.revalidate();
        PanelBahan.repaint();
    }

    private byte[] bacaFileKeByteArray(File file) throws IOException {
        try (InputStream is = new FileInputStream(file);
             ByteArrayOutputStream buffer = new ByteArrayOutputStream()) {
            int nRead;
            byte[] data = new byte[16384];
            while ((nRead = is.read(data, 0, data.length)) != -1) {
                buffer.write(data, 0, nRead);
            }
            buffer.flush();
            return buffer.toByteArray();
        }
    }
    
    private byte[] loadDefaultFoto() {
    try (InputStream in = getClass().getResourceAsStream("/img_lag.png");
         ByteArrayOutputStream buffer = new ByteArrayOutputStream()) {

        byte[] temp = new byte[4096];
        int len;
        while ((len = in.read(temp)) != -1) {
            buffer.write(temp, 0, len);
        }

        return buffer.toByteArray();
    } catch (IOException | NullPointerException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Foto default gagal dimuat.");
        return null;
    }
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTitle = new komponen.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        NamaP = new javax.swing.JTextField();
        HargaP = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Hapus = new javax.swing.JButton();
        pilihfile = new javax.swing.JButton();
        jLabelGambar = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        PanelBahan = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        Simpan = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        stok = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(265, 480));
        setMinimumSize(new java.awt.Dimension(265, 480));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(265, 480));
        setLayout(new java.awt.BorderLayout());

        panelTitle.setBackground(new Color (0x04AEF6));
        panelTitle.setGradientDirection(null);
        panelTitle.setRoundTopLeft(30);
        panelTitle.setRoundTopRight(30);
        panelTitle.setSolid(true);
        panelTitle.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Produk");
        jLabel1.setToolTipText("");
        panelTitle.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 206, -1));

        jButton1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("X");
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panelTitle.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 0, 50, 30));

        add(panelTitle, java.awt.BorderLayout.NORTH);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(390, 519));
        jPanel1.setMinimumSize(new java.awt.Dimension(390, 519));
        jPanel1.setPreferredSize(new java.awt.Dimension(390, 511));
        jPanel1.setLayout(null);

        NamaP.setBackground(new Color(0xFFEECA));
        NamaP.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        NamaP.setForeground(new java.awt.Color(0, 0, 0));
        NamaP.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        NamaP.setText("Nama Produk");
        NamaP.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                NamaPFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                NamaPFocusLost(evt);
            }
        });
        NamaP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NamaPActionPerformed(evt);
            }
        });
        jPanel1.add(NamaP);
        NamaP.setBounds(320, 50, 240, 36);

        HargaP.setBackground(new Color(0xFFEECA));
        HargaP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HargaPActionPerformed(evt);
            }
        });
        jPanel1.add(HargaP);
        HargaP.setBounds(320, 120, 240, 36);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Nama Produk");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(390, 30, 90, 17);

        Hapus.setBackground(new java.awt.Color(255, 51, 0));
        Hapus.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Hapus.setForeground(new java.awt.Color(0, 0, 0));
        Hapus.setText("Hapus");
        Hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HapusActionPerformed(evt);
            }
        });
        jPanel1.add(Hapus);
        Hapus.setBounds(480, 340, 80, 29);

        pilihfile.setText("Pilih file");
        pilihfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pilihfileActionPerformed(evt);
            }
        });
        jPanel1.add(pilihfile);
        pilihfile.setBounds(90, 280, 87, 30);

        jLabelGambar.setBackground(new java.awt.Color(0, 0, 0));
        jLabelGambar.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabelGambar.setForeground(new java.awt.Color(0, 0, 0));
        jLabelGambar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelGambar.setText("No Image");
        jLabelGambar.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.lightGray, null, null), null));
        jLabelGambar.setMaximumSize(new java.awt.Dimension(176, 141));
        jLabelGambar.setMinimumSize(new java.awt.Dimension(176, 141));
        jLabelGambar.setPreferredSize(new java.awt.Dimension(176, 141));
        jPanel1.add(jLabelGambar);
        jLabelGambar.setBounds(40, 100, 180, 170);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        PanelBahan.setBackground(new Color(0x5E3330));
        PanelBahan.setLayout(new java.awt.GridLayout(0, 2, 10, 5));
        jScrollPane1.setViewportView(PanelBahan);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(320, 240, 240, 90);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Bahan Pendukung");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(380, 220, 113, 17);

        Simpan.setBackground(new java.awt.Color(0, 255, 51));
        Simpan.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Simpan.setForeground(new java.awt.Color(0, 0, 0));
        Simpan.setText("Simpan");
        Simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SimpanActionPerformed(evt);
            }
        });
        jPanel1.add(Simpan);
        Simpan.setBounds(320, 340, 74, 29);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Stok");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(430, 160, 30, 17);

        stok.setBackground(new Color(0xFFEECA));
        jPanel1.add(stok);
        stok.setBounds(320, 180, 240, 28);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Harga");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(420, 100, 40, 17);

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void pilihfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pilihfileActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Gambar (JPG, PNG, JPEG)", "jpg", "png", "jpeg");
        fileChooser.setFileFilter(filter);

        int returnValue = fileChooser.showOpenDialog(this); // ganti null ke this biar modal
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                foto = bacaFileKeByteArray(selectedFile);
                ImageIcon icon = new ImageIcon(foto);
                Image img = icon.getImage().getScaledInstance(180, 150, Image.SCALE_SMOOTH);
                jLabelGambar.setIcon(new ImageIcon(img));
                jLabelGambar.setText(null);
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Gagal membaca file gambar!");
            }
        }
    }//GEN-LAST:event_pilihfileActionPerformed

    private void HargaPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HargaPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HargaPActionPerformed

    private void HapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HapusActionPerformed
        if (Simpan.getText().equals("Update")) {
            int confirm = JOptionPane.showConfirmDialog(this, "Mau menghapus data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (confirm != JOptionPane.YES_OPTION) {
                return;
            }
            produkObjek.deleteProduk(pDat);
            JOptionPane.showMessageDialog(this, "Berhasil dihapus");
            listener.onCloseForm();
            setDataBerubah(true);
        }
    }//GEN-LAST:event_HapusActionPerformed

    private void SimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SimpanActionPerformed
        if (NamaP.getText().equals(np) || HargaP.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Data selain 'Jumlah' dan 'Foto' dilarang kosong!");
            return;
        }
        if (foto == null) {
            foto = loadDefaultFoto();
        }
        
        dat();
        if (Simpan.getText().equals("Simpan")) {
            pDat = new produkData(foto, NamaP.getText(), Short.parseShort(HargaP.getText()));
            produkObjek.insertProduk(pDat, foto, bahanTerpilih);
        } else if (Simpan.getText().equals("Update")) {
            pDat = new produkData(pDat.get_id(), foto, NamaP.getText(), Short.parseShort(HargaP.getText()), Short.parseShort(stok.getText()));
            produkObjek.updateProduk(pDat, foto, bahanTerpilih);
        }
        
        JOptionPane.showMessageDialog(this, "Berhasil disimpan");
        listener.onCloseForm();
        setDataBerubah(true);
    }//GEN-LAST:event_SimpanActionPerformed

    private void NamaPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NamaPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NamaPActionPerformed

    private void NamaPFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_NamaPFocusGained
        if(NamaP.getText().equals(np)) {
            NamaP.setText("");
            NamaP.setForeground(new Color (0,0,0));
        }
    }//GEN-LAST:event_NamaPFocusGained

    private void NamaPFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_NamaPFocusLost
        if(NamaP.getText().equals("")) {
            NamaP.setText(np);
            NamaP.setForeground(new Color (169,169,169));
        }
    }//GEN-LAST:event_NamaPFocusLost

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setDataBerubah(false);
        listener.onCloseForm();
    }//GEN-LAST:event_jButton1ActionPerformed
    
    private List<detailProdukData> dat() {
    bahanTerpilih = new ArrayList<>();
        for (Component comp : PanelBahan.getComponents()) {
            if (comp instanceof JCheckBox cb && cb.isSelected()) {
                short id = (short) cb.getClientProperty("id");
                detailProdukData detP = new detailProdukData(id);
                bahanTerpilih.add(detP);
            }
        }
        return bahanTerpilih;
}
    
    public void setProdukFormListener(Dataprodukproduk.ProdukFormListener listener) {
        this.listener = listener;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Hapus;
    private javax.swing.JTextField HargaP;
    private javax.swing.JTextField NamaP;
    private javax.swing.JPanel PanelBahan;
    private javax.swing.JButton Simpan;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelGambar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private komponen.PanelRound panelTitle;
    private javax.swing.JButton pilihfile;
    private javax.swing.JTextField stok;
    // End of variables declaration//GEN-END:variables
}
