package DAO;


public class bahanData {
    private byte id_b;
    private String nama_b;
    private bahanObjek.kategori kateg;
    private short jumlah;
    
    bahanData(byte id, String nama, bahanObjek.kategori kateg, short jumlah) {
        this.id_b = id;
        this.nama_b = nama;
        this.kateg = kateg;
        this.jumlah = jumlah;
    }
    public bahanData(String nama, bahanObjek.kategori kateg, short jml){
        this.nama_b = nama;
        this.kateg = kateg;
        this.jumlah = jml;
    }
    
    public byte get_id_b() {
        return id_b;
    }
    public String get_nama_b(){
        return nama_b;
    }
    public bahanObjek.kategori get_kategori(){
        return kateg;
    }
    public short jumlah(){
        return jumlah;
    }
    public void setBahan(byte id, String nama, bahanObjek.kategori kateg, short jumlah){
        this.id_b = id;
        this.nama_b = nama;
        this.kateg = kateg;
        this.jumlah = jumlah;
    }
}