package DAO;

public class pesananData {
    private int id_jual, tagihan;
    private String tanggal;
    private Boolean Lunas;
    private Byte user, produkId, bahanId;
    private short jumlah, harga;
    
    pesananData(int id_jual, String tanggal, int tagihan, Boolean lunas, Byte user){ //transaksi jual
        this.id_jual = id_jual;
        this.tanggal = tanggal;
        this.tagihan = tagihan;
        this.Lunas = lunas;
        this.user = user;
    }
    public int get_idJual(){
        return id_jual;
    }
    public String get_tanggal(){
        return tanggal;
    }
    public int get_tagihan(){
        return tagihan;
    }
    public Boolean get_lunas(){
        return Lunas;
    }
    public Byte get_user(){
        return user;
    }
    public void setTransaksi_J(int id_jual, String tanggal, int tagihan, Boolean lunas, Byte user){
        this.id_jual = id_jual;
        this.tanggal = tanggal;
        this.tagihan = tagihan;
        this.Lunas = lunas;
        this.user = user;
    }
    
    pesananData(byte idproduk, short jumlah, short harga){ //detail transaksi jual
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
    public void setDetail_J(int id_jual, byte idproduk, short jumlah, short harga){
        this.id_jual = id_jual;
        this.produkId = idproduk;
        this.jumlah = jumlah;
        this.harga = harga;
    }
    
    pesananData(byte bahan_id){ //untuk pesanan custom
        this.bahanId = bahan_id;
    }
    public void setTanpaBahan(byte bahan_id){
        this.bahanId = bahan_id;
    }
}
