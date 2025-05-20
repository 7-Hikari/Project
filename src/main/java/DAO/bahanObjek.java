package DAO;

import java.util.*;
import java.sql.*;
import koneksi.koneksi;

public class bahanObjek {
    
    public static List<bahanData> getAllBahan() {
        List<bahanData> listBahan = new ArrayList<>();
        String sql = "SELECT * FROM m_bahan";
        Connection conn = koneksi.connect(); 
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                short id_b = rs.getShort("id_bahan");
                String nama_b = rs.getString("nama_bahan");
                boolean kateg = rs.getBoolean("konsumsi");
                short jumlah = rs.getShort("stok");
                bahanData B = new bahanData(id_b, nama_b, kateg, jumlah);
                listBahan.add(B);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listBahan;
    }
    
    public static List<bahanData> getBahanKonsum() {
        List<bahanData> listBahan = new ArrayList<>();
        String sql = "SELECT * FROM m_bahan where konsumsi = true";
        Connection conn = koneksi.connect(); 
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                short id_b = rs.getShort("id_bahan");
                String nama_b = rs.getString("nama_bahan");
                boolean kateg = rs.getBoolean("konsumsi");
                short jumlah = rs.getShort("stok");
                bahanData B = new bahanData(id_b, nama_b, kateg, jumlah);
                listBahan.add(B);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listBahan;
    }
    
    public static void insertBahan(bahanData bahdat){
        String sql = "insert into m_bahan (nama_bahan, konsumsi) values (?, ?)";
        Connection conn = koneksi.connect();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            
            pst.setString(1, bahdat.get_nama_b());
            pst.setBoolean(2, bahdat.get_kategori());
            pst.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public static void updateBahan(bahanData bahdat){
        String sql = "update m_bahan set nama_bahan = ?, konsumsi = ?, stok = ? where id_bahan = ?";
        Connection conn = koneksi.connect();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            
            pst.setString(1, bahdat.get_nama_b());
            pst.setBoolean(2, bahdat.get_kategori());
            pst.setShort(3, bahdat.jumlah());
            pst.setShort(4, bahdat.get_id_b());
            pst.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public static void deleteBahan(short id){
        String sql = "delete from m_bahan where id_bahan = ?";
        Connection conn = koneksi.connect();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setShort(1, id);
            pst.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
}
