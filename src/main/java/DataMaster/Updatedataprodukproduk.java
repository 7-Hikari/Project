package DataMaster;

import java.awt.Image;
import java.awt.Color;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import DAO.*;
import java.awt.Component;
import java.util.List;
import java.io.*;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

public class Updatedataprodukproduk extends javax.swing.JPanel {
    private byte[] foto;
    private Dataprodukproduk.ProdukFormListener listener;
    
    public Updatedataprodukproduk() {
        initComponents();
        
        loadCekbox();
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
    
    public byte[] getFotoBytes() {
        return foto;
    }
    
    public void setFotoBytes(byte[] bytes) {
        this.foto = bytes;
        if (bytes != null) {
            ImageIcon icon = new ImageIcon(bytes);
            Image img = icon.getImage().getScaledInstance(220, 170, Image.SCALE_SMOOTH);
            jLabelGambar.setIcon(new ImageIcon(img));
            jLabelGambar.setText(null);
        } else {
            jLabelGambar.setIcon(new ImageIcon(getClass().getResource("/img_lag.png")));
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        NamaP = new javax.swing.JTextField();
        HargaP = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Simpan = new javax.swing.JButton();
        JmlP = new javax.swing.JTextField();
        jButtonFile = new javax.swing.JButton();
        jLabelGambar = new javax.swing.JLabel();
        PanelBahan = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(349, 574));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(NamaP, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 310, 36));

        HargaP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HargaPActionPerformed(evt);
            }
        });
        jPanel1.add(HargaP, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 300, 125, 36));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nama");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, -1, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Harga");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 280, -1, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Jumlah");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, -1, -1));

        Simpan.setBackground(new java.awt.Color(0, 255, 51));
        Simpan.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Simpan.setForeground(new java.awt.Color(0, 0, 0));
        Simpan.setText("Simpan");
        Simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SimpanActionPerformed(evt);
            }
        });
        jPanel1.add(Simpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 460, -1, -1));
        jPanel1.add(JmlP, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 70, 36));

        jButtonFile.setText("Pilih file");
        jButtonFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFileActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonFile, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 87, 19));

        jLabelGambar.setBackground(new java.awt.Color(0, 0, 0));
        jLabelGambar.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabelGambar.setForeground(new java.awt.Color(0, 0, 0));
        jLabelGambar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelGambar.setText("No Image");
        jLabelGambar.setMaximumSize(new java.awt.Dimension(176, 141));
        jLabelGambar.setMinimumSize(new java.awt.Dimension(176, 141));
        jLabelGambar.setPreferredSize(new java.awt.Dimension(176, 141));
        jPanel1.add(jLabelGambar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 220, 170));

        PanelBahan.setBackground(new Color(0x5E3330));
        PanelBahan.setLayout(new java.awt.GridLayout(0, 2, 10, 5));
        jPanel1.add(PanelBahan, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 372, 370, 80));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Bahan Pendukung");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 350, -1, -1));

        jPanel2.setBackground(new java.awt.Color(0, 153, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Produk");
        jLabel1.setToolTipText("");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFileActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Gambar (JPG, PNG, JPEG)", "jpg", "png", "jpeg");
        fileChooser.setFileFilter(filter);

        int returnValue = fileChooser.showOpenDialog(this); // ganti null ke this biar modal
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                foto = bacaFileKeByteArray(selectedFile);
                ImageIcon icon = new ImageIcon(foto);
                Image img = icon.getImage().getScaledInstance(220, 170, Image.SCALE_SMOOTH);
                jLabelGambar.setIcon(new ImageIcon(img));
                jLabelGambar.setText(null);
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Gagal membaca file gambar!");
            }

            System.out.println("File dipilih: " + foto);
        } else {
            System.out.println("Lu batalin, wajar sih lo emang suka ragu 😒");
        }
    }//GEN-LAST:event_jButtonFileActionPerformed

    private void HargaPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HargaPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HargaPActionPerformed

    private void SimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SimpanActionPerformed
        produkData pDat = new produkData();
        if(NamaP.getText().isEmpty() || HargaP.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Data selain 'Jumlah' dilarang kosong");
            return;
        }
        pDat.setProdukData(NamaP.getText(), Short.parseShort(HargaP.getText()));
        
        List<detailProdukData> bahanTerpilih = new ArrayList<>();
        for (Component comp : PanelBahan.getComponents()) {
            if (comp instanceof JCheckBox cb && cb.isSelected()) {
                short id = (short) cb.getClientProperty("id");
                detailProdukData detP = new detailProdukData(id);
                bahanTerpilih.add(detP);
            }
        }
        produkObjek.insertProduk(pDat, foto, bahanTerpilih);
        if (listener != null) {
                listener.onProdukSaved(pDat);
            }
    }//GEN-LAST:event_SimpanActionPerformed
    
    public void setProdukFormListener(Dataprodukproduk.ProdukFormListener listener) {
        this.listener = listener;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField HargaP;
    private javax.swing.JTextField JmlP;
    private javax.swing.JTextField NamaP;
    private javax.swing.JPanel PanelBahan;
    private javax.swing.JButton Simpan;
    private javax.swing.JButton jButtonFile;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelGambar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
