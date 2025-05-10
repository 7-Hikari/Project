package com.mycompany.kasir;

import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.awt.Font;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.util.List;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Print {
    public void cetakStruk(String kode, List<Object[]> dataTabel, Path x) {
    try {
        String printerName = "Thermal Printer Generic"; // Ganti sesuai nama printer kamu

        // Cari printer
        PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null);
        PrintService selectedService = null;
        for (PrintService service : services) {
            if (service.getName().equalsIgnoreCase(printerName)) {
                selectedService = service;
                break;
            }
        }

        if (selectedService == null) {
            System.out.println("Printer tidak ditemukan.");
            return;
        }

        // Muat gambar barcode dari file
        BufferedImage barcodeImage = ImageIO.read(x.toFile());

        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintService(selectedService);

        job.setPrintable(new Printable() {
            @Override
            public int print(Graphics g, PageFormat pf, int pageIndex) throws PrinterException {
                if (pageIndex > 0) return NO_SUCH_PAGE;

                Graphics2D g2d = (Graphics2D) g;
                g2d.translate(pf.getImageableX(), pf.getImageableY());

                // Contoh teks
                                int y = 10;
                g2d.setFont(new Font("Monospaced", Font.PLAIN, 10));
                
                FontMetrics fm = g2d.getFontMetrics();
                int pageWidth = (int) pf.getImageableWidth();
                
                // Header toko
                String toko = "== PAPOY DRINK ==";
                g2d.drawString(toko, (pageWidth - fm.stringWidth(toko)) / 2, y); y += 15;
                String alamat = "Jl. Jalan No. 123";
                g2d.drawString(alamat, (pageWidth - fm.stringWidth(alamat)) / 2, y); y += 15;

                // Tanggal dan nomor transaksi
                String tgl = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date());
                g2d.drawString("Tgl : " + tgl, 0, y); y += 15;
                g2d.drawString("Nota: #INV" + kode, 0, y); y += 25;

                // Isi produk (contoh)
                int total = 0;
                for (Object[] baris : dataTabel) {
                    String nama = baris[0].toString();
                    int qty = Integer.parseInt(baris[1].toString());
                    int harga = Integer.parseInt(baris[2].toString());
                    int subtotal = qty * harga;
                    total += subtotal;

                    String kanan = String.format("x%d Rp%,d", qty, subtotal);
                    g2d.drawString(nama, 0, y);
                    g2d.drawString(kanan, pageWidth - fm.stringWidth(kanan), y);
                    y += 15;
                }
                String totalStr = "TOTAL: Rp" + String.format("%,d", total);
                g2d.drawString(totalStr, pageWidth - fm.stringWidth(totalStr), y); y += 25;

                // Gambar barcode (pusatkan horizontal)
                int barcodeX = (int) ((pf.getImageableWidth() - barcodeImage.getWidth()) / 2);
                g2d.drawImage(barcodeImage, barcodeX, y, null);
                y += barcodeImage.getHeight() + 20;

                // Footer
                String[] footer = {
                    "Terima kasih!",
                    "Barang yang sudah dibeli",
                    "tidak dapat dikembalikan."
                };
                for (String line : footer) {
                    g2d.drawString(line, (pageWidth - fm.stringWidth(line)) / 2, y);
                    y += 15;
                }
                
                g2d.dispose();

                return PAGE_EXISTS;
            }
        });

        job.print();

    } catch (Exception e) {
        e.printStackTrace();
    }
}
    
    public void previewStrukKePng(String kode, List<Object[]> dataTabel, BufferedImage barcodeImage, Path outputPath) {
    try {
        // Ukuran kertas thermal kecil, 58mm = ±220 pixel lebar
        int width = 576;
        int height = 600; // sementara, bisa disesuaikan

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = image.createGraphics();
        FontMetrics fm = g2d.getFontMetrics();
        String header = "== PAPOY DRINK ==";
        int headerX = (width - fm.stringWidth(header)) / 2;

        // Background putih
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, width, height);

        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Monospaced", Font.PLAIN, 10));

        int y = 10;

        // Header
        g2d.drawString(header, headerX, y); y += 15;
        g2d.drawString("Jl. Jalan No. 123", 0, y); y += 15;

        String tgl = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date());
        g2d.drawString("Tgl : " + tgl, 0, y); y += 15;
        g2d.drawString("Nota: #INV" + kode, 0, y); y += 25;

        int total = 0;
        for (Object[] baris : dataTabel) {
            String nama = baris[0].toString();
            int qty = Integer.parseInt(baris[1].toString());
            int harga = Integer.parseInt(baris[2].toString());
            int subtotal = qty * harga;
            total += subtotal;

            String kanan = String.format("Rp%,d", subtotal);
            g2d.drawString(nama, 0, y);
            g2d.drawString(String.format("X%d", qty), headerX, y);
            g2d.drawString(kanan, width - fm.stringWidth(kanan), y);
            y += 15;
        }

        y += 10;
        String totalStr = "TOTAL: Rp" + String.format("%,d", total);
        g2d.drawString(totalStr, width - fm.stringWidth(totalStr), y); y += 25;

        if (barcodeImage != null) {
            int barcodeX = (width - barcodeImage.getWidth()) / 2;
            g2d.drawImage(barcodeImage, barcodeX, y, null);
            y += barcodeImage.getHeight() + 15;
        }

        // Footer
        String[] footer = {
            "Terima kasih!",
            "Barang yang sudah dibeli",
            "tidak dapat dikembalikan."
        };
        for (String line : footer) {
            g2d.drawString(line, (width - fm.stringWidth(line)) / 2, y);
            y += 15;
        }

            g2d.dispose();

            // Crop tinggi final jika perlu
            BufferedImage cropped = image.getSubimage(0, 0, width, y);
            ImageIO.write(cropped, "png", outputPath.toFile());

            System.out.println("Struk preview disimpan ke: " + outputPath);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
