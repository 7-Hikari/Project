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
                short harga = rs.getShort("harga_jual");
                short stok = rs.getShort("stok");

                produkData p = new produkData(id, foto, nama, harga, stok);
                listProduk.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listProduk;
    }
    
    public static void insertProduk(produkData data, byte[] fotoByte) {
        Connection conn = koneksi.connect();
        String sql = "Insert INTO produk (nama_produk, Foto, harga_jual) VALUES (?, ?, ?)";
        
        try (PreparedStatement pst = conn.prepareStatement(sql)){
            pst.setString(1, data.get_nama());
            pst.setBytes(2, fotoByte);
            pst.setInt(3, data.get_harga());
            pst.executeUpdate();
        } catch(Exception e){
            e.printStackTrace();
        } 
    }
    
    public static void updateProduk(produkData data, byte[] fotoByte){
        Connection conn = koneksi.connect();
        String sql = "Update produk set nama_produk = ?, Foto = ?, harga_jual = ?, stok = ? WHERE id_produk = ?";
        
        try (PreparedStatement pst = conn.prepareStatement(sql)){
            pst.setString(1, data.get_nama());
            pst.setBytes(2, fotoByte);
            pst.setInt(3, data.get_harga());
            pst.setShort(4, data.get_stok());
            pst.setByte(5, data.get_id());
            pst.executeUpdate();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void deleteProduk(produkData data){
        Connection conn = koneksi.connect();
        String sql = "delete from produk where id_produk = ?";
        
        try (PreparedStatement pst = conn.prepareStatement(sql)){
            pst.setByte(1, data.get_id());
            pst.executeUpdate();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
