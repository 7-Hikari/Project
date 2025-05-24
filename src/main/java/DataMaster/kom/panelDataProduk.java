package DataMaster.kom;

import javax.swing.*;
import java.awt.*;
import DAO.produkData;

public class panelDataProduk extends JPanel {
    
    private final produkData produkdat;
    
    public panelDataProduk(produkData data) {
        initComponents();
        this.setPreferredSize(new Dimension(200, 260));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
   
        this.produkdat = data;
        
        foto.setPreferredSize(new Dimension(50,50));
        foto.setMaximumSize(new Dimension(50,50));
        byte[] datFoto = data.get_foto();
        
        if (datFoto != null && datFoto.length > 0) {
            ImageIcon ikon = new ImageIcon(datFoto);
            Image img = ikon.getImage().getScaledInstance(170, 147, Image.SCALE_SMOOTH);
            foto.setIcon(new ImageIcon(img));
        } else {
            foto.setIcon(null);
        }
        
        Nama.setText(produkdat.get_nama());
        String harga = OnlyNum.Rp.format(produkdat.get_harga());
        Harga.setText(harga);
        sisa.setText(String.valueOf(produkdat.getStok()));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelDeskripsi = new javax.swing.JPanel();
        Harga = new javax.swing.JLabel();
        Nama = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        sisa = new javax.swing.JTextField();
        panelFoto = new javax.swing.JPanel();
        foto = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(200, 300));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(300, 500));
        jPanel1.setName(""); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelDeskripsi.setBackground(new java.awt.Color(255, 255, 255));

        Harga.setBackground(new java.awt.Color(255, 255, 255));
        Harga.setFont(new java.awt.Font("Sitka Text", 1, 16)); // NOI18N
        Harga.setForeground(new java.awt.Color(0, 0, 0));
        Harga.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Harga.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        Nama.setFont(new java.awt.Font("Roboto Slab", 1, 18)); // NOI18N
        Nama.setForeground(new java.awt.Color(0, 0, 0));
        Nama.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Nama.setText("Nama Produk");

        jLabel1.setFont(new java.awt.Font("Franklin Gothic Demi", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Stok");

        sisa.setBackground(new java.awt.Color(255, 255, 255));
        sisa.setFont(new java.awt.Font("Britannic Bold", 1, 12)); // NOI18N
        sisa.setForeground(new java.awt.Color(0, 0, 0));
        sisa.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout panelDeskripsiLayout = new javax.swing.GroupLayout(panelDeskripsi);
        panelDeskripsi.setLayout(panelDeskripsiLayout);
        panelDeskripsiLayout.setHorizontalGroup(
            panelDeskripsiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDeskripsiLayout.createSequentialGroup()
                .addGroup(panelDeskripsiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDeskripsiLayout.createSequentialGroup()
                        .addGroup(panelDeskripsiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelDeskripsiLayout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(Harga, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelDeskripsiLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)))
                        .addGap(0, 26, Short.MAX_VALUE))
                    .addGroup(panelDeskripsiLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelDeskripsiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Nama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDeskripsiLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(sisa, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        panelDeskripsiLayout.setVerticalGroup(
            panelDeskripsiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDeskripsiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Nama)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDeskripsiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDeskripsiLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 8, Short.MAX_VALUE))
                    .addComponent(sisa, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Harga, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        jPanel1.add(panelDeskripsi, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 165, -1, -1));

        panelFoto.setPreferredSize(new java.awt.Dimension(170, 147));

        foto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        foto.setBorder(null);

        javax.swing.GroupLayout panelFotoLayout = new javax.swing.GroupLayout(panelFoto);
        panelFoto.setLayout(panelFotoLayout);
        panelFotoLayout.setHorizontalGroup(
            panelFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(panelFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFotoLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(foto, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        panelFotoLayout.setVerticalGroup(
            panelFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 153, Short.MAX_VALUE)
            .addGroup(panelFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelFotoLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(foto, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jPanel1.add(panelFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 188, 153));

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
    
    public produkData getproduk(){
        return this.produkdat;
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Harga;
    private javax.swing.JLabel Nama;
    private javax.swing.JLabel foto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel panelDeskripsi;
    private javax.swing.JPanel panelFoto;
    private javax.swing.JTextField sisa;
    // End of variables declaration//GEN-END:variables
}
