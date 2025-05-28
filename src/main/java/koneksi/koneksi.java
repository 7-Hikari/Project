package koneksi;

import java.sql.*;
import java.util.logging.*;

public class koneksi {

    private static final String URL = "jdbc:mysql://localhost:3306/app2";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static Connection connection = null;
    
    private static final Logger logger = Logger.getLogger(koneksi.class.getName());

    static {
        try {
            FileHandler fh = new FileHandler("error-log.txt", true); // Simpan log ke file
            fh.setFormatter(new SimpleFormatter());
            logger.addHandler(fh);
            logger.setLevel(Level.ALL);
        } catch (Exception e) {
            // Kalau logger gagal diinisialisasi, tetap tampilkan di konsol
            e.printStackTrace();
        }
    }
     public static Logger getLogger() {
        return logger;
    }
    

    public static Connection connect() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Koneksi berhasil!");
            }
        } catch (SQLException e) {
            System.out.println("Koneksi gagal: " + e.getMessage());
            logger.log(Level.SEVERE, "Gagal membuat koneksi ke database", e);
        }
        return connection;
    }

    public static void close() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            logger.log(Level.WARNING, "Gagal menutup koneksi", e);
        }
    }
}
