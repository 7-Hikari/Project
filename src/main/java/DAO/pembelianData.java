package DAO;

import java.util.List;

public class pembelianData {
    private String tanggal;
    private int tagihan, id_beli;
    private List<pembelianDetailData> listPemDet;
    
    pembelianData(String tanggal, int total){
        this.tanggal = tanggal;
        this.tagihan = total;
    }
    public pembelianData(int total){
        this.tagihan = total;
    }
    public int getIdBeli(){
        return id_beli;
    }
    public String getTanggal(){
        return tanggal;
    }
    public int getTotal(){
        return tagihan;
    }
    void setidBeli(int idBeli){
        this.id_beli = idBeli;
    }
    public List<pembelianDetailData> getlistPemDet(){
        return listPemDet;
    }
    public void setListPemDet(List <pembelianDetailData> lPemDet){
        this.listPemDet = lPemDet;
    }
}
