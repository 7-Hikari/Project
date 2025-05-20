package DAO;


public class produkData {
    private byte foto[];
    private byte id;
    private String nama;
    private short harga, stok;

    public produkData(byte id, byte foto[], String nama, short harga, short stok) {
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
    public short getStok(){
        return stok;
    }
    
    public produkData(byte foto[], String nama, short harga) { //insert
        this.nama = nama;
        this.foto = foto;
        this.harga = harga;
    }
    
    public void setStok(byte id, short stok){ //update stok pembelian
        this.id = id;
        this.stok = stok;
    }
    
    void setIdp(byte id){
        this.id = id;
    }
    
    public void setProdukData(byte id, byte foto[], String nama, short harga){ //update
        this.id = id;
        this.nama = nama;
        this.foto = foto;
        this.harga = harga;
    }
}
