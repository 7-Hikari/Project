package DAO;

import java.util.*;
import java.sql.*;
import koneksi.koneksi;

public class userObjek {
    static enum Status {
        Pemilik, Karyawan, SuperAdmin
    }
    
    public static userData CekUser(String user, String pass){
        userData UD = null;
        try {
            Connection conn = koneksi.connect();
            String sql = "select * from pengguna where nama = ? and password = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, user);
            pst.setString(2, pass);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                byte id_user = rs.getByte("id_user");
                Status status = Status.valueOf(rs.getString("status"));
                String nama = rs.getString("nama");
                String sandi = rs.getString("password");

                UD = new userData(id_user, status, nama, sandi);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return UD;
    }
    
    public static void RegisUser(userData usDat){
        Connection conn = koneksi.connect();
        String sql = "insert into pengguna (nama, password) values (?, ?)";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, usDat.getUsername());
            pst.setString(2, usDat.getPassword());
            pst.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public static void updatePengguna(userData usDat){
        Connection conn = koneksi.connect();
        String sql = "update pengguna set password = ?, status = ? where nama = ?";
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
