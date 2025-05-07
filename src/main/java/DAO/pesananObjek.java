package DAO;

import java.util.*;
import java.sql.*;
import koneksi.koneksi;

public class pesananObjek {
    public static List<pesananData> getAllTrJual() {
        List<pesananData> listPesanan = new ArrayList<>();
        Connection conn = koneksi.connect(); 
        String sql = "SELECT * FROM transaksi_jual";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id_jual = rs.getInt("id_jual");
                String tanggal = rs.getString("waktu");
                int tagihan = rs.getInt("tagihan");
                boolean lunas = rs.getBoolean("lunas");
                byte user = rs.getByte("id_user");

                pesananData pesanan = new pesananData(id_jual, tanggal, tagihan, lunas, user);
                pesanan.setListDetail(ambilDetailTransaksi(id_jual));
                listPesanan.add(pesanan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listPesanan;
    }
    
//    public static pesananData ambilTrJ (int idTr){
//         Connection conn = koneksi.connect(); 
//        String sql = "SELECT * FROM transaksi_jual where id_jual = ?";
//        pesananData pesanan = null;
//        
//        try {
//            PreparedStatement pst = conn.prepareStatement(sql);
//            pst.setInt(1, idTr);
//                    
//            try (ResultSet rs = pst.executeQuery();) {
//            
//            while (rs.next()) {
//                int id_jual = rs.getInt("id_jual");
//                String tanggal = rs.getString("waktu");
//                int tagihan = rs.getInt("tagihan");
//                boolean lunas = rs.getBoolean("lunas");
//                byte user = rs.getByte("id_user");
//
//                pesanan = new pesananData(id_jual, tanggal, tagihan, lunas, user);
//                pesanan.setListDetail(ambilDetailTransaksi(conn, id_jual));
//    }
//            } catch(SQLException e){
//                
//            }
//        } catch (SQLException e){
//            e.printStackTrace();
//        }
//        return pesanan;
//    }
    
    public static List<pesananDetailData> ambilDetailTransaksi(int idTransaksi){
        List<pesananDetailData> detailList = new ArrayList<>();

        String sql = "SELECT * FROM detail_jual WHERE id_jual = ?";
        Connection conn = koneksi.connect();
        
        try (PreparedStatement pst = conn.prepareStatement(sql);) {
            pst.setInt(1, idTransaksi);

            try (ResultSet rs = pst.executeQuery();) {

                while (rs.next()) {
                    byte idProduk = rs.getByte("id_produk");
                    short jumlah = rs.getShort("jumlah");
                    short harga = rs.getShort("harga_satuan");

                    detailList.add(new pesananDetailData(idProduk, jumlah, harga));
                }
            } catch (SQLException e){
                e.printStackTrace();
                System.out.println("hh");
            }
        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("aa");
        }
        return detailList;
    }
    
    public static void simpanTransaksi(pesananData trDat, List<pesananDetailData> trDetDat) {
        String Tr = "INSERT INTO transaksi_jual(tagihan) VALUES (?)";
        String trDet = "INSERT INTO detail_jual(id_jual, id_produk, jumlah, harga_satuan) VALUES (?, ?, ?, ?)";
        Connection conn = koneksi.connect();
        try {
            conn.setAutoCommit(false);

            try (PreparedStatement pstTransaksi = conn.prepareStatement(Tr, Statement.RETURN_GENERATED_KEYS);
                    PreparedStatement pstDetail = conn.prepareStatement(trDet);) {

                pstTransaksi.setInt(1, trDat.get_tagihan());
                pstTransaksi.executeUpdate();

                int idTransaksi = -1;
                try (ResultSet rs = pstTransaksi.getGeneratedKeys();) {
                    if (rs.next()) {
                        idTransaksi = rs.getInt(1);
                        trDat.setTransaksi_J(idTransaksi);
                    } else {
                        throw new SQLException("Gagal mendapatkan ID Transaksi");
                    }
                }

                for (pesananDetailData detail : trDetDat) {
                    pstDetail.setInt(1, idTransaksi);
                    pstDetail.setByte(2, detail.get_produkId());
                    pstDetail.setShort(3, detail.get_jumlah());
                    pstDetail.setShort(4, detail.get_harga());
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
    
    public static void updateTr(pesananData trDat, byte userId){
        String sql = "update transaksi_jual set Lunas = ?, id_user = ? where id_jual = ?";
        Connection conn = koneksi.connect(); 
        try{
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setBoolean(1, trDat.get_lunas());
            pst.setByte(2, userId);
            pst.setInt(3, trDat.get_idJual());
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
