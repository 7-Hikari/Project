package Transaksi;

import javax.print.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Print {

    public void cetakStruk(String kode, List<Object[]> pesanan) {
        try {
            String printerName = "POS-80"; // ganti sesuai printermu
            PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null);
            PrintService printer = null;
            for (PrintService ps : services) {
                if (ps.getName().equalsIgnoreCase(printerName)) {
                    printer = ps;
                    break;
                }
            }
            if (printer == null) {
                System.out.println("Printer tidak ditemukan.");
                return;
            }

            int lineWidth = 48;

            StringBuilder sb = new StringBuilder();

            // Header - rata tengah dengan '=' di pinggir
            sb.append(centerWithFill("PAPOY DRINK", lineWidth, '=')).append("\n");
            sb.append(centerText("Jl. Jalan No. 123", lineWidth)).append("\n");
            sb.append("=".repeat(lineWidth)).append("\n\n");

            // Tanggal dan Nota, rata kiri
            String tgl = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date());
            sb.append(String.format("%-6s : %s\n", "Tgl", tgl));
            sb.append(String.format("%-6s : %s\n\n", "Nota", "#INV" + kode));

            // Header kolom pesanan, rata kiri
            sb.append(String.format("%-20s %5s %12s\n", "Item", "Qty", "Subtotal"));
            sb.append("-".repeat(lineWidth)).append("\n");

            int total = 0;
            for (Object[] row : pesanan) {
                String nama = potong(row[0].toString(), 20);
                int jumlah = Integer.parseInt(row[1].toString());
                int harga = Integer.parseInt(row[2].toString());
                int subtotal = jumlah * harga;
                total += subtotal;

                sb.append(String.format("%-20s %5d %12s\n", nama, jumlah, formatRupiah(subtotal)));
            }

            sb.append("-".repeat(lineWidth)).append("\n");

            // Total, rata kiri untuk label, rata kanan untuk nominal
            sb.append(String.format("%-26s %12s\n\n", "Total:", formatRupiah(total)));

            // Footer rata tengah tanpa spasi kosong tambahan
            sb.append(centerText("Terima kasih!", lineWidth)).append("\n");
            sb.append(centerText("Barang tidak bisa dikembalikan", lineWidth)).append("\n");

            // Output ke printer
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            out.write(sb.toString().getBytes("UTF-8"));

            // Barcode (set align center dengan ESC a 1)
            out.write(new byte[]{0x1B, 0x61, 0x01});

            out.write(new byte[]{0x1D, 0x48, 0x02}); // HRI di bawah
            out.write(new byte[]{0x1D, 0x77, 0x02}); // Lebar barcode
            out.write(new byte[]{0x1D, 0x68, 0x40}); // Tinggi barcode
            out.write(new byte[]{0x1D, 0x6B, 0x49}); // CODE128
            out.write((byte) kode.length());
            out.write(kode.getBytes("UTF-8"));

            out.write("\n\n".getBytes("UTF-8"));

            // Hapus bagian kode barcode tercetak di bawah teks barcode (INV kode)

            // Feed dan cut
            out.write(new byte[]{0x0A, 0x0A});
            out.write(new byte[]{0x1D, 0x56, 0x00});

            DocPrintJob job = printer.createPrintJob();
            Doc doc = new SimpleDoc(out.toByteArray(), DocFlavor.BYTE_ARRAY.AUTOSENSE, null);
            job.print(doc, null);

            System.out.println("Struk dicetak.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String centerText(String text, int width) {
        if (text.length() >= width) return text;
        int totalPadding = width - text.length();
        int paddingLeft = totalPadding / 2;
        int paddingRight = totalPadding - paddingLeft;
        return " ".repeat(paddingLeft) + text + " ".repeat(paddingRight);
    }

    private static String centerWithFill(String text, int width, char fillChar) {
        int textLength = text.length();
        if (textLength >= width) return text;
        int totalFill = width - textLength;
        int fillLeft = totalFill / 2;
        int fillRight = totalFill - fillLeft;
        return String.valueOf(fillChar).repeat(fillLeft) + text + String.valueOf(fillChar).repeat(fillRight);
    }

    private String potong(String text, int max) {
        return text.length() > max ? text.substring(0, max) : text;
    }

    private String formatRupiah(int amount) {
        return String.format("Rp%,d", amount).replace(',', '.');
    }
}
