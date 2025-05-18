package DAO;

public class userData {
    private int idUser;
    private String username, password, validate;
    private userObjek.Status status;
    private byte[] photos;
    
    userData(int idUser, userObjek.Status status, String username, byte[] foto){
        this.idUser = idUser;
        this.status = status;
        this.username = username;
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
    
    public void setAccount(String username, String pass){
        this.username = username;
        this.password = pass;
    }
    public void setProfil(byte[] fotoProfil){
        this.photos = fotoProfil;
    }
}
