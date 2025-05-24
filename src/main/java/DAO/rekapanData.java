package DAO;
//@uthor Rafli RD

public class rekapanData {
    public int totalTransaksi, totalProdukKeluar, jumlahTerendah, totalPendapatan, totalPembelian;
    public String[] namaUnggulan = new String[3];
    public int[] jumlahUnggulan = new int[3];
    public String produkTerendah;
    
    private String namaProduk;
    private short terjual, stok;
    
    public rekapanData(){}
    
    rekapanData(String nama, short terjual, short stok){
        this.namaProduk = nama;
        this.stok = stok;
        this.terjual = terjual;
    }
    public String getNama(){
        return namaProduk;
    }
    public short getTerjual(){
        return terjual;
    }
    public short getStok(){
        return stok;
    }
}
