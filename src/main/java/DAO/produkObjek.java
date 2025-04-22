package DAO;

import java.util.*;
import java.sql.*;
import koneksi.koneksi;

public class produkObjek {
    public static List<produkData> getAllProduk() {
        List<produkData> listProduk = new ArrayList<>();
        try {
            Connection conn = koneksi.connect();
            String sql = "SELECT * FROM produk";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                byte[] foto = rs.getBytes("Foto");
                byte id = rs.getByte("id_produk");
                String nama = rs.getString("nama_produk");
                int harga = rs.getInt("harga_jual");

                produkData p = new produkData(id, foto, nama, harga);
                listProduk.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listProduk;
    }
}
