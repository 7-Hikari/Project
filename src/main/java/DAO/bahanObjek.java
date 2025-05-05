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
        try {
            Connection conn = koneksi.connect();
            String sql = "SELECT * FROM m_bahan";
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
        Connection conn = koneksi.connect();
        String sql = "insert into m_bahan (nama_bahan, kategori) values (?, ?)";
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
        Connection conn = koneksi.connect();
        String sql = "update m_bahan set nama_bahan = ?, jumlah = ? where id_bahan = ?";
        try{
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, bahdat.get_nama_b());
            pst.setShort(2, bahdat.jumlah());
            pst.setByte(3, bahdat.get_id_b());
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public static void deleteBahan(bahanData bahdat){
        Connection conn = koneksi.connect();
        String sql = "delete from m_bahan where id_bahan = ?";
        try{
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setByte(1, bahdat.get_id_b());
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
}
