package DAO;

import java.security.*;
import java.sql.*;
import koneksi.koneksi;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class userObjek {
    static enum Status {
        Pemilik, Karyawan, SuperAdmin
    }
    
    private static String hash(String pass) {
        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            byte[] hashed = m.digest(pass.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(hashed);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static userData CekUser(String user, String pass){
        userData UD = null;
        String sql = "select * from pengguna where nama = ? and password = ?";
        Connection conn = koneksi.connect(); 
        try {
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, user);
            pst.setString(2, hash(pass));
            try (ResultSet rs = pst.executeQuery();) {

                if (rs.next()) {
                    byte id_user = rs.getByte("id_user");
                    Status status = Status.valueOf(rs.getString("status"));
                    String nama = rs.getString("nama");

                    UD = new userData(id_user, status, nama);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return UD;
    }
    
    public static void RegisUser(userData usDat){
        String sql = "insert into pengguna (nama, password) values (?, ?)";
        Connection conn = koneksi.connect(); 
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            
            pst.setString(1, usDat.getUsername());
            pst.setString(2, hash(usDat.getPassword()));
            pst.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public static void updatePengguna(userData usDat){
        String sql = "update pengguna set password = ?, status = ? where nama = ?";
        Connection conn = koneksi.connect(); 
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            
            pst.setString(1, usDat.getPassword());
            pst.setString(2, usDat.getStatus().name());
            pst.setString(3, usDat.getUsername());
            pst.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
}
