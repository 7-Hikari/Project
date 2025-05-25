package DAO;
//@uthor Rafli RD
import java.util.List;

public class DataCache {
    
    private static List<produkData> daftarProduk;

    // Getter, read-only
    public static List<produkData> getProduk() {
        if (daftarProduk == null) {
            daftarProduk = produkObjek.getAllProduk();
        }
        return daftarProduk;
    }
    // Refresh
    public static void refreshProduk() {
        daftarProduk = produkObjek.getAllProduk();
    }
}

