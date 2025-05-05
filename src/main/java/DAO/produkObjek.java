  package DAO;

import java.util.*;
import java.sql.*;
import koneksi.koneksi;

public class produkObjek {
    public static List<produkData> getAllProduk() {
        List<produkData> listProduk = new ArrayList<>();
        try {
            Connection conn = koneksi.connect();
            String sql = "SELECT * FROM m_produk";
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
    
    public List<detailProdukData> getBahanProduk(byte id_produk){
        List<detailProdukData> listBahan = new ArrayList<>();
        try{
            Connection conn = koneksi.connect();
            String sql = "select dp.id_bahan, nama_bahan from m_detailp dp join m_bahan on dp.id_bahan = m_bahan.id_bahan where dp.id_produk = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setByte(1, id_produk);
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()){
                byte id_bahan = rs.getByte("id_bahan");
                String namaBahan = rs.getString("nama_bahan");
                listBahan.add(new detailProdukData(id_produk, id_bahan, namaBahan));
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return listBahan;
    }
    
    public static void insertProduk(produkData data, byte[] fotoByte) {
        Connection conn = koneksi.connect();
        String sql = "Insert INTO m_produk (nama_produk, Foto, harga_jual) VALUES (?, ?, ?)";
        
        try (PreparedStatement pst = conn.prepareStatement(sql)){
            pst.setString(1, data.get_nama());
            pst.setBytes(2, fotoByte);
            pst.setInt(3, data.get_harga());
            pst.executeUpdate();
        } catch(Exception e){
            e.printStackTrace();
        } 
    }
    
    public static void insertDetailProduk(detailProdukData detPdat){
        Connection conn = koneksi.connect();
        String sql = "insert into detail_produk (id_produk, id_bahan) values (?, ?)";
        try(PreparedStatement pst = conn.prepareStatement(sql)){
            pst.setByte(1, detPdat.getProdukId());
            pst.setByte(2, detPdat.getBahanId());
            pst.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public static void updateProduk(produkData data, byte[] fotoByte){
        Connection conn = koneksi.connect();
        String sql = "Update m_produk set nama_produk = ?, Foto = ?, harga_jual = ?, stok = ? WHERE id_produk = ?";
        
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
        byte id_produk = data.get_id();
        String sql = "delete from m_produk where id_produk = ?;"
                + "delete form m_detailp where id_produk = ?";
        
        try (PreparedStatement pst = conn.prepareStatement(sql)){
            pst.setByte(1, id_produk);
            pst.setByte(2, id_produk);
            pst.executeUpdate();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void deleteDetailProduk(detailProdukData detPdat){
        Connection conn = koneksi.connect();
        String sql = "delete from m_detailp where id_produk =?  and id_bahan = ?";
        try (PreparedStatement pst = conn.prepareStatement(sql)){
            pst.setByte(1, detPdat.getProdukId());
            pst.setByte(2, detPdat.getBahanId());
            pst.executeUpdate();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
