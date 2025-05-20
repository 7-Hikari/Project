package DAO;

import java.util.*;
import java.sql.*;
import koneksi.koneksi;

public class produkObjek {

    public static List<produkData> getAllProduk() {
        List<produkData> listProduk = new ArrayList<>();
        String sql = "SELECT * FROM m_produk";
        try {
            Connection conn = koneksi.connect();
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

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

    public static List<detailProdukData> getBahanProduk(byte id_produk) {
        List<detailProdukData> listBahan = new ArrayList<>();
        try {
            Connection conn = koneksi.connect();
            String sql = "select dp.id_bahan, nama_bahan from m_detailp dp join m_bahan on dp.id_bahan = m_bahan.id_bahan where dp.id_produk = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setByte(1, id_produk);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                byte id_bahan = rs.getByte("id_bahan");
                String namaBahan = rs.getString("nama_bahan");
                listBahan.add(new detailProdukData(id_produk, id_bahan, namaBahan));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listBahan;
    }

    public static void insertProduk(produkData data, byte[] fotoByte, List<detailProdukData> detPDat) {
        Connection conn = koneksi.connect();
        String sqlP = "Insert INTO m_produk (nama_produk, Foto, harga_jual) VALUES (?, ?, ?)";
        String sqlDet = "Insert into m_detailp (id_produk, id_bahan) values (?, ?)";
        try {
            conn.setAutoCommit(false);

            try (PreparedStatement pstP = conn.prepareStatement(sqlP, Statement.RETURN_GENERATED_KEYS); PreparedStatement pstDet = conn.prepareStatement(sqlDet);) {
                pstP.setString(1, data.get_nama());
                pstP.setBytes(2, fotoByte);
                pstP.setInt(3, data.get_harga());
                pstP.executeUpdate();

                byte idP = -1;
                try (ResultSet rs = pstP.getGeneratedKeys();) {
                    if (rs.next()) {
                        idP = rs.getByte(1);
                        data.setIdp(idP);
                    } else {
                        throw new SQLException("Gagal mendapatkan ID Produk");
                    }
                }
                for (detailProdukData pDet : detPDat) {
                    pstDet.setByte(1, idP);
                    pstDet.setShort(2, pDet.getBahanId());
                    pstDet.addBatch();
                }
                pstDet.executeBatch();
                conn.commit();
            }
        } catch (SQLException e) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.setAutoCommit(true);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public static void updateProduk(produkData data, byte[] fotoByte, List<detailProdukData> detPDat) {
    Connection conn = koneksi.connect();
    String sqlUpdate = "Update m_produk set nama_produk = ?, Foto = ?, harga_jual = ?, stok = ? where id_produk = ?";
    String sqlDeleteDetail = "Delete from m_detailp where id_produk = ?";
    String sqlInsertDetail = "Insert into m_detailp (id_produk, id_bahan) values (?, ?)";
    try {
        conn.setAutoCommit(false);

        try (
            PreparedStatement pstUpdate = conn.prepareStatement(sqlUpdate);
            PreparedStatement pstDelete = conn.prepareStatement(sqlDeleteDetail);
            PreparedStatement pstInsert = conn.prepareStatement(sqlInsertDetail);
        ) {
            pstUpdate.setString(1, data.get_nama());
            pstUpdate.setBytes(2, fotoByte);
            pstUpdate.setInt(3, data.get_harga());
            pstUpdate.setShort(4, data.getStok());
            pstUpdate.setByte(5, data.get_id());
            pstUpdate.executeUpdate();

            pstDelete.setByte(1, data.get_id());
            pstDelete.executeUpdate();

            for (detailProdukData pDet : detPDat) {
                pstInsert.setByte(1, data.get_id());
                pstInsert.setShort(2, pDet.getBahanId());
                pstInsert.addBatch();
            }

            pstInsert.executeBatch();
            conn.commit();
        }
    } catch (SQLException e) {
        try {
            if (conn != null) conn.rollback();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        e.printStackTrace();
    } finally {
        try {
            if (conn != null) conn.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


    public static void deleteProduk(produkData data) {
        Connection conn = koneksi.connect();
        byte id_produk = data.get_id();
        String sqld = "delete from m_detailp where id_produk = ?;";
        String sqlp = "DELETE from m_produk WHERE id_produk = ?";

        try (PreparedStatement pstd = conn.prepareStatement(sqld); PreparedStatement pstp = conn.prepareStatement(sqlp);) {
            pstd.setByte(1, id_produk);
            pstd.executeUpdate();
            pstp.setByte(1, id_produk);
            pstp.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
