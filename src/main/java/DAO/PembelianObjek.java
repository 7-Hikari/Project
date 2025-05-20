package DAO;

import java.util.*;
import java.sql.*;
import koneksi.koneksi;

public class PembelianObjek {
    public static List<pembelianData> getAllPemDat(byte bulan, short tahun){
        Map<Integer, pembelianData> mapPem = new LinkedHashMap<>();
        Connection conn = koneksi.connect();
        
        String sql = """
        SELECT pem.id_beli, pem.waktu, pem.tagihan,
               db.jumlah, db.pembagi_g, db.harga_subtotal,
               b.nama_bahan, p.nama_produk
        FROM transaksi_beli pem
        JOIN detail_beli db ON db.id_beli = pem.id_beli
        JOIN m_bahan b ON db.id_bahan = b.id_bahan
        JOIN m_produk p ON db.id_produk = p.id_produk
        WHERE MONTH(pem.waktu) = ? AND YEAR(pem.waktu) = ?
        ORDER BY pem.id_beli
    """;

        try(PreparedStatement pst = conn.prepareStatement(sql)){
            pst.setByte(1, bulan);
            pst.setShort(2, tahun);
            
            try (ResultSet rs = pst.executeQuery()){
                while (rs.next()) {
                    int id = rs.getInt("id_beli");
                 
                    pembelianData pemData = mapPem.get(id);
                    if (pemData == null) {
                        String waktu = rs.getString("waktu");
                        int tagihan = rs.getInt("tagihan");

                        pemData = new pembelianData(waktu, tagihan);
                        pemData.setListPemDet(new ArrayList<>());
                        mapPem.put(id, pemData);
                    }
                    String namaB = rs.getString("nama_bahan");
                    String namaP= rs.getString("nama_produk");
                    short jumlah = rs.getShort("jumlah");
                    short pembagiG = rs.getShort("pembagi_g");
                    int subtotal = rs.getInt("harga_subtotal");

                    pembelianDetailData pemDetDat = new pembelianDetailData(namaB, namaP, jumlah, pembagiG, subtotal);
                    pemData.getlistPemDet().add(pemDetDat);
                }
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return new ArrayList<>(mapPem.values());
    }
    
    public static void simpanBeli(int total, List<pembelianDetailData> pemDetDat){
        String Tr = "INSERT INTO transaksi_beli(tagihan) VALUES (?)";
        String trDet = "INSERT INTO detail_jual(id_beli, id_bahan, id_produk, jumlah, konsumsi, pembagi_g, harga_subtotal)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?)";
        Connection conn = koneksi.connect();
        try {
            conn.setAutoCommit(false);

            try (PreparedStatement pstTransaksi = conn.prepareStatement(Tr, Statement.RETURN_GENERATED_KEYS);
                    PreparedStatement pstDetail = conn.prepareStatement(trDet);) {
                
                pstTransaksi.setInt(1, total);
                pstTransaksi.executeUpdate();

                int idBeli = -1;
                try (ResultSet rs = pstTransaksi.getGeneratedKeys();) {
                    if (rs.next()) {
                        idBeli = rs.getInt(1);
                    } else {
                        throw new SQLException("Gagal mendapatkan ID Transaksi");
                    }
                }

                for (pembelianDetailData detail : pemDetDat) {
                    pstDetail.setInt(1, idBeli);
                    pstDetail.setShort(2, detail.getIdBahan());
                    pstDetail.setShort(3, detail.getIdPr());
                    pstDetail.setShort(4, detail.getJml());
                    pstDetail.setByte(5, detail.getKonsum());
                    pstDetail.setShort(6, detail.getPembagi());
                    pstDetail.setInt(7, detail.getSubtotal());
                    pstDetail.addBatch();
                }
                pstDetail.executeBatch();
                conn.commit();
            }
        } catch (SQLException e) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.setAutoCommit(true);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
