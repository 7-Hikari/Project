package DAO;

import java.util.*;
import java.sql.*;
import koneksi.koneksi;

public class pesananObjek {
    public static List<pesananData> getAllTrJual() {
        List<pesananData> listPesanan = new ArrayList<>();
        try {
            Connection conn = koneksi.connect();
            String sql = "SELECT * FROM transaksi_jual";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id_jual = rs.getInt("id_jual");
                String tanggal = rs.getString("waktu");
                int tagihan = rs.getInt("tagihan");
                boolean lunas = rs.getBoolean("lunas");
                byte user = rs.getByte("id_user");

                pesananData pesanan = new pesananData(id_jual, tanggal, tagihan, lunas, user);
                pesanan.setListDetail(ambilDetailTransaksi(conn, id_jual));
                listPesanan.add(pesanan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listPesanan;
    }
    
    private static List<pesananDetailData> ambilDetailTransaksi(Connection conn, int idTransaksi) throws SQLException {
        List<pesananDetailData> detailList = new ArrayList<>();

        String sql = "SELECT * FROM detail_transaksi_jual WHERE id_transaksi = ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, idTransaksi);
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            byte idProduk = rs.getByte("id_produk");
            short jumlah = rs.getShort("jumlah");
            short harga = rs.getShort("harga_satuan");

            detailList.add(new pesananDetailData(idProduk, jumlah, harga));
        }
        return detailList;
    }
    
    public static void simpanTransaksi(pesananData trDat, List<pesananDetailData> trDetDat) {
        String Tr = "INSERT INTO transaksi_jual(tagihan) VALUES (?)";
        String trDet = "INSERT INTO detail_jual(id_jual, id_produk, jumlah, harga_satuan) VALUES (?, ?, ?, ?)";

        try (Connection conn = koneksi.connect();
                PreparedStatement pstTransaksi = conn.prepareStatement(Tr, Statement.RETURN_GENERATED_KEYS);
                PreparedStatement pstDetail = conn.prepareStatement(trDet)) {

            pstTransaksi.setInt(1, trDat.get_tagihan());
            pstTransaksi.executeUpdate();

            ResultSet rs = pstTransaksi.getGeneratedKeys();
            int idTransaksi = -1;
            if (rs.next()) {
                idTransaksi = rs.getInt(1);
            }

            for (pesananDetailData detail : trDetDat) {
                pstDetail.setInt(1, idTransaksi);
                pstDetail.setByte(2, detail.get_produkId());
                pstDetail.setShort(3, detail.get_jumlah());
                pstDetail.setShort(4, detail.get_harga());
                pstDetail.addBatch();
            }
            pstDetail.executeBatch();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
