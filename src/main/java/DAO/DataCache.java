package DAO;
//@uthor Rafli RD
import java.util.List;

public class DataCache {
    
    private static List<produkData> daftarProduk;
    private static List<bahanData> daftarBahan;

    //saat aplikasi dibuka
    public static void loadAll() {
        daftarProduk = produkObjek.getAllProduk();
        daftarBahan = bahanObjek.getAllBahan();
    }

    // Getter, read-only
    public static List<produkData> getProduk() {
        if (daftarProduk == null) {
            daftarProduk = produkObjek.getAllProduk();
        }
        return daftarProduk;
    }

    public static List<bahanData> getBahan() {
        if (daftarBahan == null) {
            daftarBahan = bahanObjek.getAllBahan();
        }
        return daftarBahan;
    }

    // Refresh
    public static void refreshProduk() {
        daftarProduk = produkObjek.getAllProduk();
    }

    public static void refreshBahan() {
        daftarBahan = bahanObjek.getAllBahan();
    }
}

