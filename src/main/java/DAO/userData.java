package DAO;

public class userData {
    private int idUser;
    private String username, password, validate, RFID;
    private userObjek.Status status;
    private byte[] photos;
    
    userData(int idUser, String RFID, userObjek.Status status, String username, byte[] foto){
        this.idUser = idUser;
        this.status = status;
        this.RFID = RFID;
        this.username = username;
        this.photos = foto;
    }
    userData(String nama){
        this.username = nama;
    }
    
     public userData(String username, String password, String validasi){
        this.username = username;
        this.password = password;
        this.validate = validasi;
    }
    
    public int getId_User(){
        return idUser;
    }
    public String getRFID(){
        return RFID;
    }
    public String getUsername(){
        return username;
    }
    public userObjek.Status getStatus(){
        return status;
    }
    String getPassword(){
        return password;
    }
    String getValidate(){
        return validate;
    }
    public byte[] getFoto(){
        return photos;
    }
    
    public void setAccount(int id, String username, String pass, String RFID){
        this.idUser = id;
        this.username = username;
        this.password = pass;
        this.RFID = RFID;
    }
    public void setProfil(byte[] fotoProfil){
        this.photos = fotoProfil;
    }
}
