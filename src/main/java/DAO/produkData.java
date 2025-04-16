package DAO;


public class produkData {
    private byte foto[];
    private byte id;
    private String nama;
    private int harga;
    
    public produkData(){}
    
    public produkData(byte id, byte foto[], String nama, int harga) {
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
}
