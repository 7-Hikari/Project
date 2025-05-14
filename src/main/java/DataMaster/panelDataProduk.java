package DataMaster;

import javax.swing.*;
import java.awt.*;
import DAO.produkData;
import java.text.NumberFormat;
import java.util.Locale;

public class panelDataProduk extends JPanel {
    
    private produkData produkdat;
    private final NumberFormat Rp = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
    
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
        String harga = Rp.format(produkdat.get_harga());
        Harga.setText(harga);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelDeskripsi = new javax.swing.JPanel();
        Harga = new javax.swing.JLabel();
        Nama = new javax.swing.JLabel();
        stok = new javax.swing.JLabel();
        LabelHarga = new javax.swing.JLabel();
        LStok = new javax.swing.JLabel();
        panelFoto = new javax.swing.JPanel();
        foto = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(200, 300));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(300, 500));
        jPanel1.setName(""); // NOI18N

        panelDeskripsi.setBackground(new java.awt.Color(255, 255, 255));

        Harga.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        Harga.setText("jLabel6");
        Harga.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        Nama.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        Nama.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Nama.setText("jLabel5");

        stok.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        stok.setText("Stok");

        LabelHarga.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        LabelHarga.setText("Harga:");
        LabelHarga.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        LStok.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        LStok.setText("jLabel5");

        javax.swing.GroupLayout panelDeskripsiLayout = new javax.swing.GroupLayout(panelDeskripsi);
        panelDeskripsi.setLayout(panelDeskripsiLayout);
        panelDeskripsiLayout.setHorizontalGroup(
            panelDeskripsiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDeskripsiLayout.createSequentialGroup()
                .addComponent(LabelHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Harga, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelDeskripsiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Nama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(21, 21, 21))
            .addGroup(panelDeskripsiLayout.createSequentialGroup()
                .addComponent(stok, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addComponent(LStok, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelDeskripsiLayout.setVerticalGroup(
            panelDeskripsiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDeskripsiLayout.createSequentialGroup()
                .addComponent(Nama, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDeskripsiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelHarga)
                    .addComponent(Harga))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDeskripsiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stok)
                    .addComponent(LStok))
                .addContainerGap(7, Short.MAX_VALUE))
        );

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelDeskripsi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelFoto, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelDeskripsi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
    
    public produkData getproduk(){
        return this.produkdat;
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Harga;
    private javax.swing.JLabel LStok;
    private javax.swing.JLabel LabelHarga;
    private javax.swing.JLabel Nama;
    private javax.swing.JLabel foto;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel panelDeskripsi;
    private javax.swing.JPanel panelFoto;
    private javax.swing.JLabel stok;
    // End of variables declaration//GEN-END:variables
}
