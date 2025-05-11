package DAO;

import java.util.*;
import java.sql.*;
import koneksi.koneksi;

public class bahanObjek {
    static enum kategori {
        dimakan, tidak
    }
    
    public static List<bahanData> getAllBahan() {
        List<bahanData> listBahan = new ArrayList<>();
        String sql = "SELECT * FROM m_bahan";
        Connection conn = koneksi.connect(); 
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                byte id_b = rs.getByte("id_bahan");
                String nama_b = rs.getString("nama_bahan");
                kategori kateg = kategori.valueOf(rs.getString("kategori"));
                short jumlah = rs.getShort("jumlah");

                bahanData B = new bahanData(id_b, nama_b, kateg, jumlah);
                listBahan.add(B);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listBahan;
    }
    
    public static void insertBahan(bahanData bahdat){
        String sql = "insert into m_bahan (nama_bahan, kategori) values (?, ?)";
        Connection conn = koneksi.connect();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            
            pst.setString(1, bahdat.get_nama_b());
            pst.setString(2, bahdat.get_kategori().name());
            pst.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public static void updateBahan(bahanData bahdat){
        String sql = "update m_bahan set nama_bahan = ?, jumlah = ? where id_bahan = ?";
        Connection conn = koneksi.connect();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            
            pst.setString(1, bahdat.get_nama_b());
            pst.setShort(2, bahdat.jumlah());
            pst.setByte(3, bahdat.get_id_b());
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public static void deleteBahan(bahanData bahdat){
        String sql = "delete from m_bahan where id_bahan = ?";
        Connection conn = koneksi.connect();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setByte(1, bahdat.get_id_b());
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
}
