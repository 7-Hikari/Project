package Transaksi;

import javax.swing.*;
import java.awt.*;
import DAO.produkData;
import java.text.NumberFormat;
import java.util.Locale;

public class panelProduk extends JPanel {
    
    private ProdukListen listenerUpdateTabel;
    private produkData produkdat;
    private final NumberFormat Rp = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
   
    public void setproduklisten(ProdukListen pl) {
        this.listenerUpdateTabel = pl;
    }
    
    public panelProduk(produkData data) {
        initComponents();
        this.setPreferredSize(new Dimension(200, 320));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        spin.setModel(new SpinnerNumberModel(1, 1, 250, 1));
        spin.addChangeListener(e -> {
            if (listenerUpdateTabel != null) {
                listenerUpdateTabel.onJumlahChanged(data, (int) spin.getValue());
            }
        });
        
   
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
        Sisa.setText(String.valueOf(produkdat.getStok()));
    }
    
    public int getJumlah(){
        return (int) spin.getValue();
    }
    
    public interface ProdukListen {
            void onJumlahChanged(produkData produk, int jumlahBaru);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelDeskripsi = new javax.swing.JPanel();
        Harga = new javax.swing.JLabel();
        Nama = new javax.swing.JLabel();
        LabelHarga = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        spin = new javax.swing.JSpinner();
        LabelSisa = new javax.swing.JLabel();
        Sisa = new javax.swing.JLabel();
        panelFoto = new javax.swing.JPanel();
        foto = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(200, 300));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(51, 204, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(300, 500));
        jPanel1.setName(""); // NOI18N

        panelDeskripsi.setBackground(new java.awt.Color(255, 255, 255));

        Harga.setBackground(new java.awt.Color(0, 0, 0));
        Harga.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Harga.setForeground(new java.awt.Color(0, 0, 0));
        Harga.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Harga.setText("jLabel6");

        Nama.setFont(new java.awt.Font("Roboto Slab", 1, 18)); // NOI18N
        Nama.setForeground(new java.awt.Color(0, 0, 0));
        Nama.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Nama.setText("jLabel5");

        LabelHarga.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        LabelHarga.setForeground(new java.awt.Color(0, 0, 0));
        LabelHarga.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelHarga.setText("Harga");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Jumlah");

        spin.setMaximumSize(new java.awt.Dimension(40, 30));

        LabelSisa.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        LabelSisa.setForeground(new java.awt.Color(0, 0, 0));
        LabelSisa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelSisa.setText("Sisa Stok");

        Sisa.setBackground(new java.awt.Color(0, 0, 0));
        Sisa.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Sisa.setForeground(new java.awt.Color(0, 0, 0));
        Sisa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelDeskripsiLayout = new javax.swing.GroupLayout(panelDeskripsi);
        panelDeskripsi.setLayout(panelDeskripsiLayout);
        panelDeskripsiLayout.setHorizontalGroup(
            panelDeskripsiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDeskripsiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDeskripsiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDeskripsiLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(spin, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addGroup(panelDeskripsiLayout.createSequentialGroup()
                        .addGroup(panelDeskripsiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Nama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panelDeskripsiLayout.createSequentialGroup()
                                .addGroup(panelDeskripsiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LabelHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(LabelSisa))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panelDeskripsiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(panelDeskripsiLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(Sisa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(Harga, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())))
        );
        panelDeskripsiLayout.setVerticalGroup(
            panelDeskripsiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDeskripsiLayout.createSequentialGroup()
                .addComponent(Nama, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDeskripsiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Harga, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelHarga))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDeskripsiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelSisa)
                    .addComponent(Sisa, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelDeskripsiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap())
        );

        panelFoto.setPreferredSize(new java.awt.Dimension(170, 147));

        foto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        foto.setBorder(null);

        javax.swing.GroupLayout panelFotoLayout = new javax.swing.GroupLayout(panelFoto);
        panelFoto.setLayout(panelFotoLayout);
        panelFotoLayout.setHorizontalGroup(
            panelFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 209, Short.MAX_VALUE)
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
                    .addComponent(panelFoto, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                    .addComponent(panelDeskripsi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
    private javax.swing.JLabel LabelHarga;
    private javax.swing.JLabel LabelSisa;
    private javax.swing.JLabel Nama;
    private javax.swing.JLabel Sisa;
    private javax.swing.JLabel foto;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel panelDeskripsi;
    private javax.swing.JPanel panelFoto;
    private javax.swing.JSpinner spin;
    // End of variables declaration//GEN-END:variables
}
