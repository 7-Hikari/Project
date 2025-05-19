package DAO;

import java.util.List;

public class pembelianData {
    private String tanggal;
    private int tagihan, id_beli;
    private List<pembelianDetailData> listPemDet;
    
    pembelianData(int id_beli, String tanggal, int total){
        this.id_beli = id_beli;
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
    public List<pembelianDetailData> getlistPemDet(){
        return listPemDet;
    }
    public void setListPemDet(List <pembelianDetailData> lPemDet){
        this.listPemDet = lPemDet;
    }
    void setIdBeli(int idBeli){
        this.id_beli = idBeli;
    }
}
