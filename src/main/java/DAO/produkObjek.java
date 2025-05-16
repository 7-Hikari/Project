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

    public List<detailProdukData> getBahanProduk(byte id_produk) {
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

    public static void updateProduk(produkData data, byte[] fotoByte) {
        Connection conn = koneksi.connect();
        String sql = "Update m_produk set nama_produk = ?, Foto = ?, harga_jual = ?, stok = ? WHERE id_produk = ?";

        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, data.get_nama());
            pst.setBytes(2, fotoByte);
            pst.setInt(3, data.get_harga());
            pst.setShort(4, data.get_stok());
            pst.setByte(5, data.get_id());
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteProduk(produkData data) {
        Connection conn = koneksi.connect();
        byte id_produk = data.get_id();
        String sql = "delete from m_detailp where id_produk = ?;"
                + "delete form m_produk where id_produk = ?";

        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setByte(1, id_produk);
            pst.setByte(2, id_produk);
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteDetailProduk(detailProdukData detPdat) {
        Connection conn = koneksi.connect();
        String sql = "delete from m_detailp where id_produk =?  and id_bahan = ?";
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setByte(1, detPdat.getProdukId());
            pst.setShort(2, detPdat.getBahanId());
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
