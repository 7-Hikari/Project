package DAO;


public class produkData {
    private byte foto[];
    private byte id;
    private String nama;
    private short harga;

    public produkData(byte id, byte foto[], String nama, short harga) {
        this.id = id;
        this.foto = foto;
        this.nama = nama;
        this.harga = harga;
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
    
    public produkData(byte foto[], String nama, short harga) {
        this.nama = nama;
        this.foto = foto;
        this.harga = harga;
    }
    
    void setIdp(byte id){
        this.id = id;
    }
    
    public void setProdukData(byte id, byte foto[], String nama, short harga){
        this.id = id;
        this.nama = nama;
        this.foto = foto;
        this.harga = harga;
    }
}
