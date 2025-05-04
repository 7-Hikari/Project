//package DAO;
//
//import java.util.*;
//import java.sql.*;
//import koneksi.koneksi;
//
//public class pesananObjek {
//    public static List<pesananData> getAllTrJual() {
//        List<pesananData> listPesanan = new ArrayList<>();
//        try {
//            Connection conn = koneksi.connect();
//            String sql = "SELECT * FROM transaksi_jual";
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery(sql);
//
//            while (rs.next()) {
//                int id_jual = rs.getInt("id_jual");
//                
//
//                pesananData pesanan = new produkData(id, foto, nama, harga, stok);
//                listProduk.add(p);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return listProduk;
//    }
//}
