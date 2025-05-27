package DAO;

import java.util.*;
import java.sql.*;
import koneksi.koneksi;

public class transaksiObjek {

    //rekapan
    public static List<Short> getTh() {
        Connection conn = koneksi.connect();
        List<Short> th = new ArrayList<>();
        String sql = "SELECT Year(waktu) AS tahun FROM transaksi_jual GROUP by year(waktu) ORDER BY `tahun`";
        try (Statement stm = conn.createStatement(); ResultSet rs = stm.executeQuery(sql)) {

            while (rs.next()) {
                short tahun = rs.getShort("tahun");
                th.add(tahun);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return th;
    }

    public static Map<String, Integer> getPenjualanRekap(short tahun) {
        Map<String, Integer> hasil = new LinkedHashMap<>();
        Connection conn = koneksi.connect();
        String sql = "SELECT DATE_FORMAT(waktu, '%b') AS bulan, sum(tagihan) as total "
                + "FROM transaksi_jual where year(waktu) = ? and Lunas = 1 group by month(waktu) "
                + "order by month(waktu)";
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setShort(1, tahun);

            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    String bulan = rs.getString("bulan");
                    int total = rs.getInt("total");

                    hasil.put(bulan, total);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hasil;
    }

    public static rekapanData getRingkasanBulanan(int bulan, String tahun) {
        rekapanData data = new rekapanData();
        try {
            Connection conn = koneksi.connect();
            data.totalTransaksi = getTotalTransaksi(conn, bulan, tahun);
            data.totalProdukKeluar = getTotalProdukKeluar(conn, bulan, tahun);
            isiTop3Produk(conn, bulan, tahun, data);
            isiProdukTerendah(conn, bulan, tahun, data);
            data.totalPendapatan = getTotalPendapatan(conn, bulan, tahun);
            data.totalPembelian = getTotalPembelian(conn, bulan, tahun);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

    private static int getTotalTransaksi(Connection conn, int bulan, String tahun) throws SQLException {
        String sql = "SELECT COUNT(*) FROM transaksi_jual WHERE MONTH(waktu) = ? AND YEAR(waktu) = ? AND Lunas = 1";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, bulan);
            stmt.setString(2, tahun);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next() ? rs.getInt(1) : 0;
            }
        }
    }

    private static int getTotalProdukKeluar(Connection conn, int bulan, String tahun) throws SQLException {
        String sql = """
        SELECT SUM(dj.jumlah) FROM detail_jual dj 
        JOIN transaksi_jual t ON dj.id_jual = t.id_jual 
        WHERE MONTH(t.waktu) = ? AND YEAR(t.waktu) = ? AND t.Lunas = 1""";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, bulan);
            stmt.setString(2, tahun);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next() ? rs.getInt(1) : 0;
            }
        }
    }

    private static void isiTop3Produk(Connection conn, int bulan, String tahun, rekapanData data) throws SQLException {
        String sql = """
        SELECT p.nama_produk, SUM(dj.jumlah) as jumlah
        FROM detail_jual dj
        JOIN m_produk p ON dj.id_produk = p.id_produk
        JOIN transaksi_jual t ON dj.id_jual = t.id_jual
        WHERE MONTH(t.waktu) = ? AND YEAR(t.waktu) = ? AND t.Lunas = 1
        GROUP BY p.id_produk ORDER BY jumlah DESC LIMIT 3""";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, bulan);
            stmt.setString(2, tahun);
            try (ResultSet rs = stmt.executeQuery()) {
                int i = 0;
                while (rs.next() && i < 3) {
                    data.namaUnggulan[i] = rs.getString("nama_produk");
                    data.jumlahUnggulan[i] = rs.getInt("jumlah");
                    i++;
                }
            }
        }
    }

    private static void isiProdukTerendah(Connection conn, int bulan, String tahun, rekapanData data) throws SQLException {
        String sql = """
        SELECT p.nama_produk, SUM(dj.jumlah) as jumlah
        FROM detail_jual dj
        JOIN m_produk p ON dj.id_produk = p.id_produk
        JOIN transaksi_jual t ON dj.id_jual = t.id_jual
        WHERE MONTH(t.waktu) = ? AND YEAR(t.waktu) = ? AND t.Lunas = 1
        GROUP BY p.id_produk ORDER BY jumlah ASC LIMIT 1""";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, bulan);
            stmt.setString(2, tahun);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    data.produkTerendah = rs.getString("nama_produk");
                    data.jumlahTerendah = rs.getInt("jumlah");
                }
            }
        }
    }

    private static int getTotalPendapatan(Connection conn, int bulan, String tahun) throws SQLException {
        String sql = "SELECT SUM(tagihan) FROM transaksi_jual WHERE MONTH(waktu) = ? AND YEAR(waktu) = ? AND Lunas = 1";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, bulan);
            stmt.setString(2, tahun);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next() ? rs.getInt(1) : 0;
            }
        }
    }

    private static int getTotalPembelian(Connection conn, int bulan, String tahun) throws SQLException {
        String sql = "SELECT SUM(tagihan) FROM transaksi_beli WHERE MONTH(waktu) = ? AND YEAR(waktu) = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, bulan);
            stmt.setString(2, tahun);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next() ? rs.getInt(1) : 0;
            }
        }
    }

    public static List<pesananData> getJual(int bulan, String tahun) {
        List<pesananData> list = new ArrayList<>();
        pesananData dat;
        String sql = "select kode_jual, waktu, tagihan, nama from transaksi_jual t "
                + "join pengguna p on t.id_user = p.id_user WHERE MONTH(t.waktu) = ? "
                + "AND YEAR(t.waktu) = ? and t.Lunas = 1 ";
        Connection conn = koneksi.connect();

        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, bulan);
            pst.setString(2, tahun);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String kode = rs.getString("kode_jual");
                String tgl = rs.getString("waktu");
                String tanggal = tgl.substring(0, 10);
                int ttl = rs.getInt("tagihan");
                String nama = rs.getString("nama");

                dat = new pesananData(kode, tanggal, ttl, nama);
                dat.setListDetail(ambilDetailTransaksi(kode));
                list.add(dat);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<rekapanData> tabelDashboard() {
        List<rekapanData> rekap = new ArrayList<>();
        String sql = """
                     SELECT p.nama_produk, SUM(dj.jumlah) AS terjual, p.stok
                         FROM m_produk p
                         JOIN detail_jual dj ON p.id_produk = dj.id_produk
                         JOIN transaksi_jual tj ON tj.id_jual = dj.id_jual
                         WHERE DATE(tj.waktu) = CURRENT_DATE and tj.Lunas = 1
                         GROUP BY dj.id_produk
                         """;
        Connection conn = koneksi.connect();

        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                String nama = rs.getString("nama_produk");
                short terjual = rs.getShort("terjual");
                short stok = rs.getShort("stok");

                rekap.add(new rekapanData(nama, terjual, stok));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rekap;
    }

    public static rekapanData harianData() {
        rekapanData reDat = new rekapanData();
        Connection conn = koneksi.connect();
        String sql = "SELECT SUM(tagihan) as total, count(*) as jml FROM transaksi_jual "
                + "WHERE waktu >= CURRENT_DATE AND waktu < CURRENT_DATE + INTERVAL 1 DAY and Lunas = 1 ";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) {
                reDat.totalPendapatan = rs.getInt("total");
                reDat.totalTransaksi = rs.getInt("jml");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reDat;
    }
    
    public static List<rekapanData> rekapProduk(int bulan, String tahun){
        Connection conn = koneksi.connect();
        List<rekapanData> produkList = new ArrayList<>();
        String sql = """
        SELECT p.nama_produk, SUM(dj.jumlah) as jumlah
        FROM detail_jual dj
        JOIN m_produk p ON dj.id_produk = p.id_produk
        JOIN transaksi_jual t ON dj.id_jual = t.id_jual
        WHERE MONTH(t.waktu) = ? AND YEAR(t.waktu) = ? AND t.Lunas = 1
        GROUP BY p.id_produk ORDER BY jumlah DESC""";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, bulan);
            stmt.setString(2, tahun);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    String nama = rs.getString("nama_produk");
                    short jml = rs.getShort("jumlah");
                    short z = 0;
                    produkList.add(new rekapanData(nama, jml, z));
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return produkList;
    }

    //penjualan data
    public static List<pesananDetailData> ambilDetailTransaksi(String kode) {
        List<pesananDetailData> detailList = new ArrayList<>();

        String sql = """
                     SELECT dt.id_produk as id_p, nama_produk, dt.harga_satuan, dt.jumlah, tr.Lunas 
                     FROM detail_jual dt JOIN m_produk ON dt.id_produk = m_produk.id_produk 
                     join transaksi_jual tr on dt.id_jual = tr.id_jual 
                     WHERE tr.kode_jual = ?""";
        Connection conn = koneksi.connect();

        try (PreparedStatement pst = conn.prepareStatement(sql);) {
            pst.setString(1, kode);

            try (ResultSet rs = pst.executeQuery();) {

                while (rs.next()) {
                    byte idProduk = rs.getByte("id_p");
                    String nama = rs.getString("nama_produk");
                    short jumlah = rs.getShort("jumlah");
                    boolean stts = rs.getBoolean("Lunas");
                    short harga = rs.getShort("harga_satuan");

                    detailList.add(new pesananDetailData(idProduk, nama, jumlah, harga, stts));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return detailList;
    }

    public static short CekKode() {
        String sql = "SELECT COUNT(*) as n FROM transaksi_jual WHERE DATE(waktu) = CURRENT_DATE";
        Connection conn = koneksi.connect();
        short n = 0;
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                n = rs.getShort("n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }

    public static void simpanTransaksi(pesananData trDat, List<pesananDetailData> trDetDat) {
        String Tr = "INSERT INTO transaksi_jual(kode_jual, tagihan) VALUES (?, ?)";
        String trDet = "INSERT INTO detail_jual(id_jual, id_produk, jumlah, harga_satuan) VALUES (?, ?, ?, ?)";
        Connection conn = koneksi.connect();
        try {
            conn.setAutoCommit(false);

            try (PreparedStatement pstTransaksi = conn.prepareStatement(Tr, Statement.RETURN_GENERATED_KEYS); PreparedStatement pstDetail = conn.prepareStatement(trDet);) {

                pstTransaksi.setString(1, trDat.getKode());
                pstTransaksi.setInt(2, trDat.get_tagihan());
                pstTransaksi.executeUpdate();

                int idTransaksi = -1;
                try (ResultSet rs = pstTransaksi.getGeneratedKeys();) {
                    if (rs.next()) {
                        idTransaksi = rs.getInt(1);
                        trDat.setTransaksi_J(idTransaksi);
                    } else {
                        throw new SQLException("Gagal mendapatkan ID Transaksi");
                    }
                }

                for (pesananDetailData detail : trDetDat) {
                    pstDetail.setInt(1, idTransaksi);
                    pstDetail.setByte(2, detail.get_produkId());
                    pstDetail.setShort(3, detail.get_jumlah());
                    pstDetail.setShort(4, detail.get_harga());
                    pstDetail.addBatch();
                }
                pstDetail.executeBatch();
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

    public static void updateTr(pesananData trDat, byte userId) {

        String sql = "update transaksi_jual set Lunas = ?, id_user = ? where kode_jual = ?";
        Connection conn = koneksi.connect();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setBoolean(1, trDat.get_lunas());
            pst.setByte(2, userId);
            pst.setString(3, trDat.getKode());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //pembelian data
    public static List<pembelianData> getAllPemDat(int bulan, String tahun) {
        Map<Integer, pembelianData> mapPem = new LinkedHashMap<>();
        Connection conn = koneksi.connect();

        String sql = """
        SELECT pem.id_beli, pem.waktu, pem.tagihan,
               db.jumlah, db.konsumsi, db.pembagi_g, db.harga_subtotal,
               b.nama_bahan, p.nama_produk
        FROM transaksi_beli pem
        JOIN detail_beli db ON db.id_beli = pem.id_beli
        left JOIN m_bahan b ON db.id_bahan = b.id_bahan
        left JOIN m_produk p ON db.id_produk = p.id_produk
        WHERE MONTH(pem.waktu) = ? AND YEAR(pem.waktu) = ?
        ORDER BY pem.id_beli
    """;

        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, bulan);
            pst.setString(2, tahun);

            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("id_beli");

                    pembelianData pemData = mapPem.get(id);
                    if (pemData == null) {
                        String waktu = rs.getString("waktu");
                        int tagihan = rs.getInt("tagihan");

                        pemData = new pembelianData(waktu, tagihan);
                        pemData.setidBeli(id);
                        pemData.setListPemDet(new ArrayList<>());
                        mapPem.put(id, pemData);
                    }
                    String namaB = rs.getString("nama_bahan");
                    String namaP = rs.getString("nama_produk");
                    short jumlah = rs.getShort("jumlah");
                    boolean konsum = rs.getBoolean("konsumsi");
                    short pembagiG = rs.getShort("pembagi_g");
                    int subtotal = rs.getInt("harga_subtotal");

                    pembelianDetailData pemDetDat = new pembelianDetailData(namaB, namaP, jumlah, konsum, pembagiG, subtotal);
                    pemData.getlistPemDet().add(pemDetDat);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>(mapPem.values());
    }

    public static void simpanBeli(int total, List<pembelianDetailData> pemDetDat) {
        String Tr = "INSERT INTO transaksi_beli(tagihan) VALUES (?)";
        String trDet = "INSERT INTO detail_beli(id_beli, id_bahan, id_produk, jumlah, konsumsi, pembagi_g, harga_subtotal)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?)";
        Connection conn = koneksi.connect();
        try {
            conn.setAutoCommit(false);

            try (PreparedStatement pstTransaksi = conn.prepareStatement(Tr, Statement.RETURN_GENERATED_KEYS); PreparedStatement pstDetail = conn.prepareStatement(trDet);) {

                pstTransaksi.setInt(1, total);
                pstTransaksi.executeUpdate();

                int idBeli = -1;
                try (ResultSet rs = pstTransaksi.getGeneratedKeys();) {
                    if (rs.next()) {
                        idBeli = rs.getInt(1);
                    } else {
                        throw new SQLException("Gagal mendapatkan ID Transaksi");
                    }
                }

                for (pembelianDetailData detail : pemDetDat) {
                    Object item = detail.getItem();
                    pstDetail.setInt(1, idBeli);

                    if (item instanceof bahanData b) {
                        pstDetail.setShort(2, b.get_id_b());
                        pstDetail.setNull(3, Types.INTEGER);
                    } else if (item instanceof produkData p) {
                        pstDetail.setNull(2, Types.INTEGER);
                        pstDetail.setByte(3, p.get_id());
                    }

                    pstDetail.setShort(4, detail.getJml());
                    pstDetail.setBoolean(5, detail.getKonsum());
                    pstDetail.setShort(6, detail.getPembagi());
                    pstDetail.setInt(7, detail.getSubtotal());
                    pstDetail.addBatch();
                }
                pstDetail.executeBatch();
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
}
