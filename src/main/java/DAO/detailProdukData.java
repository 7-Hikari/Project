package DAO;

public class detailProdukData {
    private byte id_produk, id_bahan;
    private String nama_bahan;
    
    detailProdukData(byte idProduk, byte idBahan, String nama_bahan){
        this.id_produk = idProduk;
        this.id_bahan = idBahan;
        this.nama_bahan = nama_bahan;
    }
    public byte getProdukId(){
        return id_produk;
    }
    public byte getBahanId(){
        return id_bahan;
    }
    public String getNamabahan(){
        return nama_bahan;
    }
    public void setDetailProduk(byte idProduk, byte idBahan){
        this.id_produk = idProduk;
        this.id_bahan = idBahan;
    }
}
