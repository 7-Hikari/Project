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
            String sql = "SELECT * FROM bahan";
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
}
