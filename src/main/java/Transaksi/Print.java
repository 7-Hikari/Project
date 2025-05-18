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

            // Build isi struk
            StringBuilder sb = new StringBuilder();
            sb.append(center("== PAPOY DRINK ==")).append("\n");
            sb.append(center("Jl. Jalan No. 123")).append("\n");

            String tgl = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date());
            sb.append("Tgl : ").append(tgl).append("\n");
            sb.append("Nota: #INV").append(kode).append("\n\n");

            int total = 0;
            for (Object[] row : pesanan) {
                String nama = row[0].toString();
                int jumlah = Integer.parseInt(row[1].toString());
                int harga = Integer.parseInt(row[2].toString());
                int subtotal = jumlah * harga;
                total += subtotal;

                String line = String.format("%-10s x%d Rp%,d", potong(nama, 10), jumlah, subtotal);
                sb.append(line).append("\n");
            }

            sb.append("\n");
            sb.append(String.format("Total:       Rp%,d\n", total));
            sb.append("\n");

            // Footer
            sb.append(center("Terima kasih!\n"));
            sb.append(center("Barang tidak bisa dikembalikan\n\n"));

            // ESC/POS barcode (GS k)
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            out.write(sb.toString().getBytes("UTF-8"));

            // ESC/POS command to print barcode (CODE128 recommended)
            out.write(new byte[] { 0x1D, 0x48, 0x02 }); // HRI position: below
            out.write(new byte[] { 0x1D, 0x77, 0x02 }); // barcode width
            out.write(new byte[] { 0x1D, 0x68, 0x40 }); // barcode height
            out.write(new byte[] { 0x1D, 0x6B, 0x49 }); // CODE128
            out.write((byte) kode.length());           // length of data
            out.write(kode.getBytes("UTF-8"));         // actual data

            // Feed and cut
            out.write(new byte[]{ 0x0A, 0x0A });
            out.write(new byte[]{ 0x1D, 0x56, 0x00 }); // full cut

            DocPrintJob job = printer.createPrintJob();
            Doc doc = new SimpleDoc(out.toByteArray(), DocFlavor.BYTE_ARRAY.AUTOSENSE, null);
            job.print(doc, null);

            System.out.println("Struk dicetak.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String center(String teks) {
        int width = 32; // lebar karakter (pastikan sesuai font printer)
        int padding = (width - teks.length()) / 2;
        return " ".repeat(Math.max(0, padding)) + teks;
    }

    private String potong(String teks, int max) {
        return teks.length() > max ? teks.substring(0, max) : teks;
    }
}
