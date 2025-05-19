package DAO;
//@uthor Rafli RD

public class pembelianDetailData {
    private short jumlah, id_b;
    private String nama_b;
    private boolean konsumsi;
    private int berat_g, subtotal;

    public pembelianDetailData(short id_bahan, String nama_bahan, short jumlah, int berat_g, int hargasub) {
        this.id_b = id_bahan;
        this.nama_b = nama_bahan;
        this.jumlah = jumlah;
        this.berat_g = berat_g;
        this.subtotal = hargasub;
    }
    public pembelianDetailData(short id_bahan, short jumlah, boolean konsum, int berat, int subtotal){
        this.id_b = id_bahan;
        this.jumlah = jumlah;
        this.konsumsi = konsum;
        this.berat_g = berat;
        this.subtotal = subtotal;
    }
    public short getIdBahan(){
        return id_b;
    }
    public String getNamaB(){
        return nama_b;
    }
    public short getJml(){
        return jumlah;
    }
    boolean getKonsum(){
        return konsumsi;
    }
    public int getBerat(){
        return berat_g;
    }
    public int getSubtotal(){
        return subtotal;
    }
}
