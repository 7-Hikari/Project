package DAO;

import java.util.List;

public class pesananData {
    private int id_jual, tagihan;
    private String tanggal, kode, user;
    private Boolean Lunas;
    private List<pesananDetailData> listDetail;
    
    pesananData(String kode, String tanggal, int tagihan, String user){ //transaksi jual
        this.kode = kode;
        this.tanggal = tanggal;
        this.tagihan = tagihan;
        this.user = user;
    }
    public pesananData(String kode, int tagihan){
        this.kode = kode;
        this.tagihan = tagihan;
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
    public String get_user(){
        return user;
    }
    public String getKode(){
        return kode;
    }
    public List<pesananDetailData> getListDetail(){
        return listDetail;
    }
    public void setListDetail(List<pesananDetailData> listDetail) {
        this.listDetail = listDetail;
    }
    public pesananData(String kode, Boolean lunas){
        this.kode = kode;
        this.Lunas = lunas;
    }
    void setTransaksi_J(int id_jual){
        this.id_jual = id_jual;
    }
}
