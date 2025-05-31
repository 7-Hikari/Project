package DAO;

import java.security.*;
import java.sql.*;
import koneksi.koneksi;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.logging.*;

public class userObjek {

    private static Logger logger = koneksi.getLogger();

    public static enum Status {
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

    public static userData CekUser(String user, String pass) {
        userData UD = null;
        String sql = "select * from pengguna where nama = ? and password = ?";
        Connection conn = koneksi.connect();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, user);
            pst.setString(2, hash(pass));
            try (ResultSet rs = pst.executeQuery();) {

                if (rs.next()) {
                    int id_user = rs.getInt("id_user");
                    String rfid = rs.getString("RFID");
                    Status status = Status.valueOf(rs.getString("status"));
                    String nama = rs.getString("nama");
                    byte[] ikon = rs.getBytes("foto");

                    UD = new userData(id_user, rfid, status, nama, ikon);
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Gagal mengecek user", e);
        }
        return UD;
    }

    public static userData Forgot(String user, String validate) {
        userData UD = null;
        String sql = "select * from pengguna where nama = ? and Validasi = ?";
        Connection conn = koneksi.connect();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, user);
            pst.setString(2, hash(validate));
            try (ResultSet rs = pst.executeQuery();) {

                if (rs.next()) {
                    String nama = rs.getString("nama");

                    UD = new userData(nama);
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Gagal memvalidasi user", e);
        }
        return UD;
    }

    public static userData CekID(String RFID) {
        userData UD = null;
        String sql = "select * from pengguna where RFID = ?";
        Connection conn = koneksi.connect();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, RFID);
            try (ResultSet rs = pst.executeQuery();) {

                if (rs.next()) {
                    int id_user = rs.getInt("id_user");
                    String rfid = rs.getString("RFID");
                    Status status = Status.valueOf(rs.getString("status"));
                    String nama = rs.getString("nama");
                    byte[] ikon = rs.getBytes("foto");

                    UD = new userData(id_user, rfid, status, nama, ikon);
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Gagal mengecek RFID", e);
        }
        return UD;
    }

    public static void RegisUser(userData usDat) {
        String sql = "insert into pengguna (nama, password, Validasi) values (?, ?, ?)";
        Connection conn = koneksi.connect();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, usDat.getUsername());
            pst.setString(2, hash(usDat.getPassword()));
            pst.setString(3, hash(usDat.getValidate()));
            pst.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Gagal meregistrasi akun", e);
        }
    }
    
    public static boolean adaPemilik() {
        String sql = "SELECT 1 FROM pengguna WHERE status = 'Pemilik' LIMIT 1";
        Connection conn = koneksi.connect();
        try (PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            return rs.next();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "database masih mereset", e);
            return false;
        }
    }
    
    public static void regisPemilik(userData usDat) {
        String sql = "insert into pengguna (nama, password, Validasi, status) values (?, ?, ?, ?)";
        Connection conn = koneksi.connect();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, usDat.getUsername());
            pst.setString(2, hash(usDat.getPassword()));
            pst.setString(3, hash(usDat.getValidate()));
            pst.setString(4, "Pemilik");
            pst.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Gagal meregistrasi akun", e);
        }
    }

    public static void updatePengguna(userData usDat) {
        String sql = "update pengguna set password = ?, RFID = ? where nama = ? and id_user = ?";
        Connection conn = koneksi.connect();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, usDat.getPassword());
            pst.setString(2, usDat.getRFID());
            pst.setString(3, usDat.getUsername());
            pst.setInt(4, usDat.getId_User());
            pst.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Gagal mengupdate akun pengguna", e);
        }
    }

    public static void updateFoto(userData usDat) {
        String sql = "update pengguna set foto = ? where nama = ? and id_user = ?";
        Connection conn = koneksi.connect();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setBytes(1, usDat.getFoto());
            pst.setString(2, usDat.getUsername());
            pst.setInt(3, usDat.getId_User());
            pst.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Gagal mengubah foto", e);
        }
    }

    public static void deleteAccount(userData usDat) {
        String sql = "delete pengguna where id_user = ?";
        Connection conn = koneksi.connect();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setInt(1, usDat.getId_User());
            pst.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Gagal mengubah menghapus akun", e);
        }
    }

     public static void reset() {
        String[] sqlStatements = {
            "SET FOREIGN_KEY_CHECKS = 0",

            "DELETE FROM detail_jual",
            "ALTER TABLE detail_jual AUTO_INCREMENT = 1",

            "DELETE FROM detail_beli",
            "ALTER TABLE detail_beli AUTO_INCREMENT = 1",

            "DELETE FROM m_detailp",
            "ALTER TABLE m_detailp AUTO_INCREMENT = 1",

            "DELETE FROM transaksi_jual",
            "ALTER TABLE transaksi_jual AUTO_INCREMENT = 1",

            "DELETE FROM transaksi_beli",
            "ALTER TABLE transaksi_beli AUTO_INCREMENT = 1",

            "DELETE FROM m_produk",
            "ALTER TABLE m_produk AUTO_INCREMENT = 1",

            "DELETE FROM m_bahan",
            "ALTER TABLE m_bahan AUTO_INCREMENT = 1",

            "DELETE FROM pengguna",
            "ALTER TABLE pengguna AUTO_INCREMENT = 1",
            
            "INSERT INTO pengguna (status, nama, password) VALUES " +
            "('SuperAdmin', 'Admin', '" + hash("Eau de Farfum Asoyy") + "')",

            "SET FOREIGN_KEY_CHECKS = 1"
        };

        try (Connection conn = koneksi.connect();
             Statement stmt = conn.createStatement()) {

            for (String sql : sqlStatements) {
                stmt.execute(sql);
            }
            System.out.println("Database berhasil direset.");
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Gagal mereset database", e);
        }
    }
}
