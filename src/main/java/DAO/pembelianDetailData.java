package DAO;
//@uthor Rafli RD

public class pembelianDetailData {
    private short jumlah, id_b, idProduk, pembagiG;
    private String nama_b, nama_pr;
    private byte konsumsi;
    private int subtotal;

    public pembelianDetailData(String nama_bahan, String nama_produk, short jumlah, short bagi, int hargasub) { //riwayat
        this.nama_b = nama_bahan;
        this.nama_pr = nama_produk;
        this.jumlah = jumlah;
        this.pembagiG = bagi;
        this.subtotal = hargasub;
    }
    public pembelianDetailData(short id_bahan, short id_produk, short jumlah, byte konsum, short bagi, int subtotal){ //insert
        this.id_b = id_bahan;
        this.idProduk = id_produk;
        this.jumlah = jumlah; //0 non-konsumsi, 1 konsumsi, 2 produk
        this.konsumsi = konsum;
        this.pembagiG = bagi;
        this.subtotal = subtotal;
    }
    public short getIdBahan(){
        return id_b;
    }
    public String getNamaB(){
        return nama_b;
    }
    public short getIdPr(){
        return idProduk;
    }
    public String getNamaP(){
        return nama_pr;
    }
    public short getJml(){
        return jumlah;
    }
    byte getKonsum(){
        return konsumsi;
    }
    public short getPembagi(){
        return pembagiG;
    }
    public int getSubtotal(){
        return subtotal;
    }
}
