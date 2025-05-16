package DAO;


public class produkData {
    private byte foto[];
    private byte id;
    private String nama;
    private short harga, stok;
    
    
    public produkData(){}
    
    produkData(byte id, byte foto[], String nama, short harga, short stok) {
        this.id = id;
        this.foto = foto;
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }
    public byte get_id(){
        return id;
    }
    public byte[] get_foto(){
        return foto;
    }
    public String get_nama(){
        return nama;
    }
    public int get_harga(){
        return harga;
    }
    public short get_stok(){
        return stok;
    }
    
    public void setProdukData(String nama, short harga) {
        this.nama = nama;
        this.harga = harga;
    }
    
    void setIdp(byte id){
        this.id = id;
    }
    
    public void setProdukData(byte id, String nama, short harga, short stok){
        this.id = id;
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }
}
