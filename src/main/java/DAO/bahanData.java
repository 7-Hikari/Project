package DAO;


public class bahanData {
    private short id_b;
    private String nama_b;
    private boolean kateg;
    private short jumlah;
    
    public static boolean parseKonsumsi(String kategori){
        return "konsumsi".equalsIgnoreCase(kategori);
    }
    
    public bahanData(){
        
    }
    
    public bahanData(short id, String nama, boolean kateg, short jumlah) {
        this.id_b = id;
        this.nama_b = nama;
        this.kateg = kateg;
        this.jumlah = jumlah;
    }
    public bahanData(String nama, boolean kateg, short jml){
        this.nama_b = nama;
        this.kateg = kateg;
        this.jumlah = jml;
    }
    
    public short get_id_b() {
        return id_b;
    }
    public String get_nama_b(){
        return nama_b;
    }
    boolean get_kategori(){
        return kateg;
    }
    public String getStatusKonsumsi(){
        return kateg ? "Konsumsi" : "Non-Konsumsi";
    }
    public short jumlah(){
        return jumlah;
    }
    public void setIdBahan(short id){
        this.id_b = id;
    }
}