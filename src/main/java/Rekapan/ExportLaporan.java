package Rekapan;

import DAO.*;
import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import koneksi.koneksi;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExportLaporan {

    private static Logger logger = koneksi.getLogger();
    private static Row row;
    private static CellStyle currencyStyle;
    private static DataFormat format;

    public static void exportToExcel(List<pesananData> dataTransaksi, List<pembelianData> pemDats, rekapanData rekapDat, int bulan, String tahun) {
        List<rekapanData> produkList = transaksiObjek.rekapProduk(bulan, tahun);
        Cell c;
        String tglStr;
        LocalDate tgl;
        java.sql.Date tanggal;

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Laporan Penjualan" + bulan + " " + tahun);

        currencyStyle = workbook.createCellStyle();
        format = workbook.createDataFormat();
        currencyStyle.setDataFormat(format.getFormat("Rp#,##0"));

        CreationHelper createHelper = workbook.getCreationHelper();
        CellStyle dateStyle = workbook.createCellStyle();
        dateStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd/MM/yyyy"));

//Ringkasan
        int rowNum = 0;
        sheet.createRow(rowNum++).createCell(0).setCellValue("Laporan Rekap Bulanan: " + bulan + " " + tahun);
        rowNum++;

        sheet.createRow(rowNum++).createCell(0).setCellValue("Total Transaksi");
        sheet.getRow(rowNum - 1).createCell(1).setCellValue(rekapDat.totalTransaksi);

        sheet.createRow(rowNum++).createCell(0).setCellValue("Total Produk Keluar");
        sheet.getRow(rowNum - 1).createCell(1).setCellValue(rekapDat.totalProdukKeluar);

        sheet.createRow(rowNum++).createCell(0).setCellValue("Total Pendapatan");
        Cell cPendapatan = sheet.getRow(rowNum - 1).createCell(1);
        cPendapatan.setCellValue(rekapDat.totalPendapatan);
        cPendapatan.setCellStyle(currencyStyle);

        double labaKotor = rekapDat.totalPendapatan - rekapDat.totalPembelian;
        sheet.createRow(rowNum++).createCell(0).setCellValue("Laba Kotor");
        Cell cLaba = sheet.getRow(rowNum - 1).createCell(1);
        cLaba.setCellValue(labaKotor);
        cLaba.setCellStyle(currencyStyle);

        rowNum++;
        sheet.createRow(rowNum++).createCell(0).setCellValue("Produk Penjualan Terendah");
        sheet.getRow(rowNum - 1).createCell(1).setCellValue(
                rekapDat.produkTerendah + " (" + rekapDat.jumlahTerendah + "x)"
        );

        rowNum++;
        sheet.createRow(rowNum++).createCell(0).setCellValue("Produk Unggulan");

        for (int i = 0; i < 3; i++) {
            if (rekapDat.namaUnggulan[i] != null) {
                row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue((i + 1) + ". " + rekapDat.namaUnggulan[i]);
                row.createCell(1).setCellValue(rekapDat.jumlahUnggulan[i] + "x");
            }
        }

        sheet.autoSizeColumn(0);
        sheet.autoSizeColumn(1);

//Transaksi jual
        rowNum += 3;
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
                row = sheet.createRow(rowNum++);
                tglStr = trx.get_tanggal();
                tgl = LocalDate.parse(tglStr);
                tanggal = java.sql.Date.valueOf(tgl);
                c = row.createCell(0);
                c.setCellValue(tanggal);
                c.setCellStyle(dateStyle);
                row.createCell(1).setCellValue(trx.getKode());
                row.createCell(2).setCellValue(trx.get_user());
                row.createCell(3).setCellValue(item.getNama());
                row.createCell(4).setCellValue(item.get_jumlah());
                Cell harga = row.createCell(5);
                harga.setCellValue(item.get_harga());
                harga.setCellStyle(currencyStyle);

                Cell subtotal = row.createCell(6);
                subtotal.setCellValue(item.get_jumlah() * item.get_harga());
                subtotal.setCellStyle(currencyStyle);
            }
        }

        // Autosize kolom
        for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
        }
//Produk
        Sheet dafProduk = workbook.createSheet("Rekap Produk");
        rowNum = 1;
        headerRow = dafProduk.createRow(0);

        headerRow.createCell(0).setCellValue("No");
        headerRow.createCell(1).setCellValue("Produk");
        headerRow.createCell(2).setCellValue("Jumlah Terjual");

        for (rekapanData dat : produkList) {
            row = dafProduk.createRow(rowNum);
            row.createCell(0).setCellValue(rowNum);
            row.createCell(1).setCellValue(dat.getNama());
            row.createCell(2).setCellValue(dat.getTerjual());
            rowNum++;
        }

//Belanjaan
        Sheet belanjaan = workbook.createSheet("Belanjaan");
        rowNum = 1;
        headerRow = belanjaan.createRow(0);
        String[] headersB = {"kode pembelian", "Tanggal", "Daftar Belanja", "Kategori", "Jumlah", "pembagi (g)", "Berat (g)", "Subtotal"};
        for (int i = 0; i < headersB.length; i++) {
            headerRow.createCell(i).setCellValue(headersB[i]);
        }
        for (pembelianData pembelian : pemDats) {
            int kode = pembelian.getIdBeli();
            for (pembelianDetailData det : pembelian.getlistPemDet()) {
                row = belanjaan.createRow(rowNum++);
                row.createCell(0).setCellValue(kode);
                tglStr = pembelian.getTanggal();
                tgl = LocalDate.parse(tglStr);
                tanggal = java.sql.Date.valueOf(tgl);
                c = row.createCell(1);
                c.setCellValue(tanggal);
                c.setCellStyle(dateStyle);

                String daftar;
                String kategori;

                if (det.getNamaP() != null) {
                    daftar = det.getNamaP();
                    kategori = "Produk";
                    row.createCell(5).setCellValue(det.getPembagi());
                    int berat = det.getJml() * det.getPembagi();
                    row.createCell(6).setCellValue(berat);
                } else {
                    daftar = det.getNamaB();
                    kategori = "Bahan";
                    row.createCell(4).setCellValue(det.getJml());

                    if (det.getKonsum()) {
                        row.createCell(5).setCellValue(det.getPembagi());
                        int berat = det.getJml() * det.getPembagi();
                        row.createCell(6).setCellValue(berat);
                    }
                }
                row.createCell(2).setCellValue(daftar);
                row.createCell(3).setCellValue(kategori);
                Cell sub = row.createCell(7);
                sub.setCellValue(det.getSubtotal());
                sub.setCellStyle(currencyStyle);
            }
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

            JOptionPane.showMessageDialog(null, "Laporan berhasil disimpan di "+folderPath);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Gagal menyimpan file", e);
        }

    }

    public static void exportHarian(List<rekapanData> reProdukDatas, List<bahanData> bahDats, int terjual, int jumlah, int masuk) throws FileNotFoundException {
        String tgl = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        String namaFile = "Ringkasan Harian - " + tgl + ".pdf";
        File folder = new File("pdf_laporan");
        if (!folder.exists()) {
            folder.mkdirs();
        }

        File outputFile = new File(folder, namaFile);

        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(outputFile));
        document.open();

        Font font = FontFactory.getFont(FontFactory.HELVETICA, 12);
        PdfPTable table = new PdfPTable(6);

        table.addCell("Produk");
        table.addCell("Terjual");
        table.addCell("Sisa Stok");
        table.addCell("");
        table.addCell("Bahan");
        table.addCell("Sisa Bahan");

        int rowCount = Math.max(reProdukDatas.size(), bahDats.size());
        for (int i = 0; i < rowCount; i++) {
            rekapanData r = (i < reProdukDatas.size()) ? reProdukDatas.get(i) : null;
            bahanData b = (i < bahDats.size()) ? bahDats.get(i) : null;

            table.addCell(r != null ? r.getNama() : "");
            table.addCell(r != null ? String.valueOf(r.getTerjual()) : "");
            table.addCell(r != null ? String.valueOf(r.getStok()) : "");
            table.addCell("");
            table.addCell(b != null ? b.get_nama_b() : "");
            table.addCell(b != null ? String.valueOf(b.jumlah()) : "");
        }

        document.add(table);

        document.add(new Paragraph("\nRingkasan:", font));
        document.add(new Paragraph("Jumlah Transaksi: " + jumlah, font));
        document.add(new Paragraph("Produk Terjual: " + terjual, font));
        document.add(new Paragraph("Uang Masuk: Rp" + String.format("%,d", masuk), font));

        document.close();

        JOptionPane.showMessageDialog(null, "Laporan berhasil disimpan di "+folder);
    }
}
