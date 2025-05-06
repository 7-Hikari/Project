package DAO;

public class pesananDetailData {

    private Byte produkId;
    private short jumlah, harga;
    
    public pesananDetailData(byte idproduk, short jumlah, short harga){
        this.produkId = idproduk;
        this.jumlah = jumlah;
        this.harga = harga;
    }
    public byte get_produkId(){
        return produkId;
    }
    public short get_jumlah(){
        return jumlah;
    }
    public short get_harga(){
        return harga;
    }
    public void setDetail_J(byte idproduk, short jumlah, short harga){
        this.produkId = idproduk;
        this.jumlah = jumlah;
        this.harga = harga;
    }
}
