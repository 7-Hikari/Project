package DAO;

public class pesananDetailData {

    private Byte produkId;
    private short jumlah, harga;
    private String namaP;
    private boolean lunas;
    
    public pesananDetailData(byte idproduk, String nama, short jumlah, short harga, boolean lunas){
        this.produkId = idproduk;
        this.namaP = nama;
        this.jumlah = jumlah;
        this.harga = harga;
        this.lunas = lunas;
    }
    public pesananDetailData(byte idproduk, short jumlah, short harga){
        this.produkId = idproduk;
        this.jumlah = jumlah;
        this.harga = harga;
    }
    public byte get_produkId(){
        return produkId;
    }
    public String getNama(){
        return namaP;
    }
    public short get_jumlah(){
        return jumlah;
    }
    public short get_harga(){
        return harga;
    }
    public boolean getLunas(){
        return lunas;
    }
}
