package DAO;

public class detailProdukData {
    private byte id_produk;
    private short id_bahan;
    private String nama_bahan;
    
    detailProdukData(byte idProduk, short idBahan, String nama_bahan){
        this.id_produk = idProduk;
        this.id_bahan = idBahan;
        this.nama_bahan = nama_bahan;
    }
    public detailProdukData(short idBahan){
        this.id_bahan = idBahan;
    }
    public byte getProdukId(){
        return id_produk;
    }
    public short getBahanId(){
        return id_bahan;
    }
    public String getNamabahan(){
        return nama_bahan;
    }
    public void setDetailProduk(byte idProduk, short idBahan){
        this.id_produk = idProduk;
        this.id_bahan = idBahan;
    }
}
