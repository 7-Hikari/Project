package Rekapan;
//@uthor Rafli RD

import DAO.pesananData;
import DAO.pesananDetailData;
import DAO.rekapanData;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LaporanTransaksiExporter {

    public static void exportToExcel(List<pesananData> dataTransaksi, rekapanData data, String bulan, String tahun) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Laporan " + bulan + " " + tahun);

        int rowNum = 0;
        sheet.createRow(rowNum++).createCell(0).setCellValue("Laporan Rekap Bulanan: " + bulan + " " + tahun);
        rowNum++;

        sheet.createRow(rowNum++).createCell(0).setCellValue("Total Transaksi");
        sheet.getRow(rowNum - 1).createCell(1).setCellValue(data.totalTransaksi);

        sheet.createRow(rowNum++).createCell(0).setCellValue("Total Produk Keluar");
        sheet.getRow(rowNum - 1).createCell(1).setCellValue(data.totalProdukKeluar);

        sheet.createRow(rowNum++).createCell(0).setCellValue("Total Pendapatan");
        sheet.getRow(rowNum - 1).createCell(1).setCellValue(data.totalPendapatan);

        double labaKotor = data.totalPendapatan - data.totalPembelian;
        sheet.createRow(rowNum++).createCell(0).setCellValue("Laba Kotor");
        sheet.getRow(rowNum - 1).createCell(1).setCellValue(labaKotor);

        rowNum++;
        sheet.createRow(rowNum++).createCell(0).setCellValue("Produk Penjualan Terendah");
        sheet.getRow(rowNum - 1).createCell(1).setCellValue(
                data.produkTerendah + " (" + data.jumlahTerendah + "x)"
        );

        rowNum++;
        sheet.createRow(rowNum++).createCell(0).setCellValue("Produk Unggulan");

        for (int i = 0; i < 3; i++) {
            if (data.namaUnggulan[i] != null) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue((i + 1) + ". " + data.namaUnggulan[i]);
                row.createCell(1).setCellValue(data.jumlahUnggulan[i] + "x");
            }
        }

        sheet.autoSizeColumn(0);
        sheet.autoSizeColumn(1);

        rowNum +=3;
        // Header
        String[] headers = {"Tanggal", "kode Transaksi", "Kasir", "Produk", "Jumlah", "Harga", "Subtotal"};
        Row headerRow = sheet.createRow(rowNum);
        for (int i = 0; i < headers.length; i++) {
            headerRow.createCell(i).setCellValue(headers[i]);
        }
        rowNum++;
        // Isi data
        for (pesananData trx : dataTransaksi) {
            for (pesananDetailData item : trx.getListDetail()) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(trx.get_tanggal());
                row.createCell(1).setCellValue(trx.getKode());
                row.createCell(2).setCellValue(trx.get_user());
                row.createCell(3).setCellValue(item.getNama());
                row.createCell(4).setCellValue(item.get_jumlah());
                row.createCell(5).setCellValue(item.get_harga());
                row.createCell(6).setCellValue(item.get_jumlah() * item.get_harga());
            }
        }

        // Autosize kolom
        for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
        }

        // Simpan file
        try {
            String userHome = System.getProperty("user.home");
            String folderPath = userHome + File.separator + "LaporanTransaksi";
            new File(folderPath).mkdirs(); // buat folder jika belum ada

            String filename = String.format("Laporan_%s_%s.xlsx", bulan, tahun);
            try (FileOutputStream fileOut = new FileOutputStream(folderPath + File.separator + filename)) {
                workbook.write(fileOut);
            }
            workbook.close();

            System.out.println("Laporan berhasil disimpan di: " + folderPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
