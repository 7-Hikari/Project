package DAO;
//@uthor Rafli RD

public class pembelianDetailData {
    private Object item;
    private short jumlah, pembagiG;
    private String nama_b, nama_pr;
    private boolean konsumsi;
    private int subtotal;

    public pembelianDetailData(String nama_bahan, String nama_produk, short jumlah, boolean konsum, short bagi, int hargasub) { //riwayat
        this.nama_b = nama_bahan;
        this.nama_pr = nama_produk;
        this.jumlah = jumlah;
        this.konsumsi = konsum;
        this.pembagiG = bagi;
        this.subtotal = hargasub;
    }
    public pembelianDetailData(Object item, short jumlah, boolean konsum, short bagi, int subtotal){ //insert
        this.item = item;
        this.jumlah = jumlah;
        this.konsumsi = konsum;
        this.pembagiG = bagi;
        this.subtotal = subtotal;
    }
    Object getItem(){
        return item;
    }
    public String getNamaB(){
        return nama_b;
    }
    public String getNamaP(){
        return nama_pr;
    }
    public short getJml(){
        return jumlah;
    }
    public boolean getKonsum(){
        return konsumsi;
    }
    public short getPembagi(){
        return pembagiG;
    }
    public int getSubtotal(){
        return subtotal;
    }
}
