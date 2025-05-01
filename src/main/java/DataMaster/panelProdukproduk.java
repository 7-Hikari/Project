package DataMaster;

import com.mycompany.kasir.*;
import javax.swing.*;
import java.awt.*;
import DAO.produkData;

public class panelProdukproduk extends JPanel {
    
    private ProdukListen listenerUpdateTabel;
    private produkData produkdat;
   
    
    public void setproduklisten(ProdukListen pl) {
        this.listenerUpdateTabel = pl;
    }
    
    public panelProdukproduk(produkData data) {
        initComponents();
        this.setPreferredSize(new Dimension(200, 300));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        spin.setModel(new SpinnerNumberModel(1, 1, 999, 1));
        spin.addChangeListener(e -> {
            if (listenerUpdateTabel != null) {
                listenerUpdateTabel.onJumlahChanged(data, (int) spin.getValue());
            }
        });
        
   
        this.produkdat = data;
        
        foto.setPreferredSize(new Dimension(50,50));
        foto.setMaximumSize(new Dimension(50,50));
        foto.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        byte[] datFoto = data.get_foto();
        
        if (datFoto != null && datFoto.length > 0) {
            ImageIcon ikon = new ImageIcon(datFoto);
            Image img = ikon.getImage().getScaledInstance(170, 170, Image.SCALE_SMOOTH);
            foto.setIcon(new ImageIcon(img));
        } else {
            foto.setIcon(null);
        }
        
        Nama.setText(produkdat.get_nama());
        Harga.setText(String.valueOf(produkdat.get_harga()));
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        spin = new javax.swing.JSpinner();
        foto = new javax.swing.JLabel();
        Nama = new javax.swing.JLabel();
        Harga = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(200, 300));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(300, 500));
        jPanel1.setName(""); // NOI18N

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel1.setText("Nama:");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel2.setText("Harga:");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel3.setText("Jumlah");

        spin.setMaximumSize(new java.awt.Dimension(40, 30));

        foto.setPreferredSize(null);

        Nama.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        Nama.setText("jLabel5");

        Harga.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        Harga.setText("jLabel6");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Nama))
                    .addComponent(foto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Harga))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addComponent(spin, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(foto, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Nama))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Harga))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(spin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSpinner spin;
    // End of variables declaration//GEN-END:variables
}
