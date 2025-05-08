package DAO;

import java.util.List;

public class pesananData {
    private int id_jual, tagihan;
    private String tanggal;
    private Boolean Lunas;
    private Byte user;
    private List<pesananDetailData> listDetail;
    
    pesananData(int id_jual, String tanggal, int tagihan, Boolean lunas, Byte user){ //transaksi jual
        this.id_jual = id_jual;
        this.tanggal = tanggal;
        this.tagihan = tagihan;
        this.Lunas = lunas;
        this.user = user;
    }
    public pesananData(int tagihan){
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
    public Byte get_user(){
        return user;
    }
    public List<pesananDetailData> getListDetail(){
        return listDetail;
    }
    public void setListDetail(List<pesananDetailData> listDetail) {
        this.listDetail = listDetail;
    }
    public pesananData(int id_jual, Boolean lunas){
        this.id_jual = id_jual;
        this.Lunas = lunas;
    }
    void setTransaksi_J(int id_jual){
        this.id_jual = id_jual;
    }
}
