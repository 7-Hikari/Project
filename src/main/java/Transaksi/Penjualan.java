package Transaksi;

import DAO.*;
import java.awt.*;
import komponen.wraplayout;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.util.*;
import com.google.zxing.*;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import java.awt.image.BufferedImage;
import java.text.*;
import java.nio.file.Path;
import javax.swing.table.DefaultTableModel;

public class Penjualan extends komponen.PanelRound {
    
    private int no = 1;
    private final String tgl = new SimpleDateFormat("yyMMdd").format(new Date());
    private java.util.List<Byte> ProdukIdList = new ArrayList<>();
    private final NumberFormat Rp = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
    int total = 0;
    
    DefaultTableModel m_pesanan = null;
    
    public Penjualan() {
        initComponents();
        
        setRoundBottomLeft(100);
        setRoundBottomRight(100);
        setRoundTopLeft(100);
        setRoundTopRight(100);
        
        setLayout(new BorderLayout());
        add(panelRound1, BorderLayout.CENTER);
        setPreferredSize(new java.awt.Dimension(1240, 640));
        
        m_pesanan = (DefaultTableModel) Tabelpesanan.getModel();
        
        loadproduk();
    }
    
    public void loadproduk() {
        scroll.setPreferredSize(new java.awt.Dimension(650, 800));
        scroll.setViewportView(flowpanel);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        flowpanel.removeAll();

        java.util.List<produkData> daftarProduk = produkObjek.getAllProduk();
        
        for (produkData data : daftarProduk) {
            panelProduk produkP = new panelProduk(data);

            produkP.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    produkData produk = produkP.getproduk();
                    int jumlah = produkP.getJumlah();
                    masukkanKeTabel(produk, jumlah);
                }
            });
            produkP.setproduklisten((produk, jumlahBaru) -> {
                updateBarisTabel(produk, jumlahBaru);
            });

            flowpanel.add(produkP);

            flowpanel.setLayout(new wraplayout(FlowLayout.LEFT, 10, 10));

        }

        int jumlahItem = flowpanel.getComponentCount();
        int tinggiPerBaris = 320;
        int kolom = 3;
        int baris = (int) Math.ceil(jumlahItem / (double) kolom);
        int tinggiTotal = baris * tinggiPerBaris + 50;

        flowpanel.setPreferredSize(new java.awt.Dimension(640, tinggiTotal));
        flowpanel.revalidate();
        flowpanel.repaint();

    }

    private void updateBarisTabel(produkData produk, int jumlahBaru) {
        
        for (int i = 0; i < m_pesanan.getRowCount(); i++) {
            if (m_pesanan.getValueAt(i, 2).equals(produk.get_nama())) {
                m_pesanan.setValueAt(jumlahBaru, i, 4);
                m_pesanan.setValueAt(jumlahBaru * produk.get_harga(), i, 5);
                upTotal();
                break;
            }
        }
    }

    private void masukkanKeTabel(produkData data, int jumlahBaru) {
        boolean ada = false;

        for (int i = 0; i < m_pesanan.getRowCount(); i++) {
            String namaProdukDiTabel = m_pesanan.getValueAt(i, 2).toString();

            if (namaProdukDiTabel.equals(data.get_nama())) {
                // Produk sudah ada → update jumlah dan total
                int jumlahLama = (int) m_pesanan.getValueAt(i, 4);
                int jumlahBaruFinal = jumlahLama + jumlahBaru;
                
                m_pesanan.setValueAt(jumlahBaruFinal, i, 4); // Jumlah
                m_pesanan.setValueAt(jumlahBaruFinal * data.get_harga(), i, 5); // Total
                
                ada = true;
                break;
            }
        }

        if (!ada) {
            m_pesanan.addRow(new Object[]{
                no++,
                data.get_id(),
                data.get_nama(),
                data.get_harga(),
                jumlahBaru,
                data.get_harga() * jumlahBaru
            });
            upTotal();
            ProdukIdList.add(data.get_id());
        }
    }
    
    private void upTotal(){
        total = 0;
        for(int row =0; row < Tabelpesanan.getRowCount(); row++) {
            Object nilai = Tabelpesanan.getValueAt(row, 5);
            if (nilai !=null) {
                total += Integer.parseInt(nilai.toString());
            }
        }
        String ttl = Rp.format(total);
        fieldtotal.setText(String.valueOf(ttl));
    }
    
    private void no_urut(){
        for (no = 1; no <= Tabelpesanan.getRowCount(); no++){
            Tabelpesanan.setValueAt(no, no - 1, 0);
        }
    }
    
    private void simpan(int total) {
        short count = pesananObjek.CekKode();
        String kode = tgl + count;
        
        pesananData pesDat = new pesananData(kode, total);
        java.util.List<pesananDetailData> listDetail = new ArrayList<>();
        
        for (no = 0; no < Tabelpesanan.getRowCount(); no++) {
            byte idProduk = (byte) ProdukIdList.get(no);
            short jumlah = Short.parseShort(Tabelpesanan.getValueAt(no, 4).toString());
            short harga = Short.parseShort(Tabelpesanan.getValueAt(no, 3).toString());

            pesananDetailData PDetDat = new pesananDetailData(idProduk, jumlah, harga);
            listDetail.add(PDetDat);
        }
        pesananObjek.simpanTransaksi(pesDat, listDetail);
        cetakBC(kode);
    }
    
    private void cetakBC(String code){
        

        int width = 300;
        int height = 100;
        
        try{
            Hashtable<EncodeHintType, Object> hints = new Hashtable<>();
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            
            BitMatrix matrix = new MultiFormatWriter().encode(
                    code, BarcodeFormat.CODE_128, width, height, hints);
            
            BufferedImage bcImg = MatrixToImageWriter.toBufferedImage(matrix);
            
            Path jalur = Path.of("barcode.png");

            ImageIO.write(bcImg, "png", jalur.toFile());
            
            Print cetak = new Print();
            
            java.util.List<Object[]> tabelDat = new ArrayList<>();
            for(no = 0; no < m_pesanan.getRowCount();no++){
                Object[] baris = {
                m_pesanan.getValueAt(no, 2), //nama
                m_pesanan.getValueAt(no, 4), //jumlah
                m_pesanan.getValueAt(no, 3), //harga
};
                tabelDat.add(baris);
            }
            BufferedImage barcode = ImageIO.read(Path.of("barcode.png").toFile());
            
            cetak.cetakStruk(code, tabelDat);


            
            
            System.out.println("barcode");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound1 = new komponen.PanelRound();
        struk = new javax.swing.JPanel();
        fieldtotal = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabelpesanan = new komponen.Tabel_c();
        tmbl_hapus = new javax.swing.JButton();
        scroll = new JScrollPane();
        flowpanel = new JPanel();
        Pesan = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(1100, 800));
        setPreferredSize(new java.awt.Dimension(1100, 800));
        setLayout(new java.awt.BorderLayout());

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));
        panelRound1.setMaximumSize(new java.awt.Dimension(1240, 640));
        panelRound1.setMinimumSize(new java.awt.Dimension(1240, 640));
        panelRound1.setPreferredSize(new java.awt.Dimension(1240, 640));
        panelRound1.setRoundBottomLeft(100);
        panelRound1.setRoundBottomRight(100);
        panelRound1.setRoundTopLeft(100);
        panelRound1.setRoundTopRight(100);
        panelRound1.setVerifyInputWhenFocusTarget(false);
        panelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        struk.setBackground(new java.awt.Color(102, 204, 255));
        struk.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fieldtotal.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        fieldtotal.setText("Rp0,00");
        fieldtotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldtotalActionPerformed(evt);
            }
        });
        struk.add(fieldtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 485, 191, 34));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText(" Total");
        struk.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 485, 106, 34));

        Tabelpesanan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "id", "Nama", "Harga", "Jumlah", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Byte.class, java.lang.String.class, java.lang.Integer.class, java.lang.Short.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Tabelpesanan.setHeaderBackgroundColor(new java.awt.Color(51, 204, 255));
        jScrollPane1.setViewportView(Tabelpesanan);
        if (Tabelpesanan.getColumnModel().getColumnCount() > 0) {
            Tabelpesanan.getColumnModel().getColumn(0).setResizable(false);
            Tabelpesanan.getColumnModel().getColumn(0).setPreferredWidth(15);
            Tabelpesanan.getColumnModel().getColumn(1).setMinWidth(0);
            Tabelpesanan.getColumnModel().getColumn(1).setPreferredWidth(0);
            Tabelpesanan.getColumnModel().getColumn(1).setMaxWidth(0);
            Tabelpesanan.getColumnModel().getColumn(4).setPreferredWidth(25);
            Tabelpesanan.getColumnModel().getColumn(5).setResizable(false);
        }

        struk.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 400, 390));

        tmbl_hapus.setBackground(new java.awt.Color(255, 0, 0));
        tmbl_hapus.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        tmbl_hapus.setText("Hapus");
        tmbl_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tmbl_hapusActionPerformed(evt);
            }
        });
        struk.add(tmbl_hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(317, 36, 80, 30));

        panelRound1.add(struk, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 10, 420, 540));

        scroll.setMinimumSize(new java.awt.Dimension(600, 25));
        scroll.setPreferredSize(new java.awt.Dimension(600, 8));

        flowpanel.setBackground(new java.awt.Color(102, 204, 255));
        flowpanel.setMaximumSize(new java.awt.Dimension(600, 800));
        flowpanel.setMinimumSize(new java.awt.Dimension(600, 8));
        flowpanel.setPreferredSize(new java.awt.Dimension(600, 8));
        flowpanel.setLayout(new java.awt.GridLayout(5, 4, 2, 2));
        scroll.setViewportView(flowpanel);

        panelRound1.add(scroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 770, 540));

        Pesan.setBackground(new java.awt.Color(0, 255, 51));
        Pesan.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        Pesan.setForeground(new java.awt.Color(0, 0, 0));
        Pesan.setText("Pesan");
        Pesan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PesanActionPerformed(evt);
            }
        });
        panelRound1.add(Pesan, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 560, 107, -1));

        add(panelRound1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void PesanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PesanActionPerformed
        simpan(total);
        JOptionPane.showMessageDialog(this, "Silahkan Ambil Nota dan bawa ke Kasir\n untuk melakukan pembayaran ya!",
                "Pesanan Berhasil", JOptionPane.INFORMATION_MESSAGE);
        m_pesanan.setRowCount(0);
        no_urut();
        fieldtotal.setText("Rp0,00");
        ProdukIdList.clear();
        
    }//GEN-LAST:event_PesanActionPerformed

    private void fieldtotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldtotalActionPerformed
        
    }//GEN-LAST:event_fieldtotalActionPerformed

    private void tmbl_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tmbl_hapusActionPerformed
        int barisPilih = Tabelpesanan.getSelectedRow();
        if(barisPilih >= 0){
            m_pesanan.removeRow(barisPilih);
            no_urut();
            ProdukIdList.remove(barisPilih);
            upTotal();
        }
    }//GEN-LAST:event_tmbl_hapusActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Pesan;
    private komponen.Tabel_c Tabelpesanan;
    private javax.swing.JTextField fieldtotal;
    private javax.swing.JPanel flowpanel;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private komponen.PanelRound panelRound1;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JPanel struk;
    private javax.swing.JButton tmbl_hapus;
    // End of variables declaration//GEN-END:variables
}
