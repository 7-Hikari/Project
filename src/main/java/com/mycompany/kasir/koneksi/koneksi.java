package com.mycompany.kasir.koneksi;

import java.sql.*;
public class koneksi {
    private static final String URL = "jdbc:mysql://localhost:3306/app2";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static Connection connection = null;
    public static Connection connect() {
        if (connection == null){
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Koneksi berhasil!");
        } catch (SQLException e) {
            System.out.println("Koneksi gagal: " + e.getMessage());
        }
        }
        return connection;
    }
    }