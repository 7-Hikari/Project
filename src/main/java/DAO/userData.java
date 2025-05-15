package DAO;

public class userData {
    private int idUser;
    private String username, password;
    private userObjek.Status status;
    
    userData(int idUser, userObjek.Status status, String username){
        this.idUser = idUser;
        this.status = status;
        this.username = username;
    }
    
     public userData(String username, String password){
        this.username = username;
        this.password = password;
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
    public String getPassword(){
        return password;
    }
    
    public void setAccount(String username, String pass){
        this.username = username;
        this.password = pass;
    }
}
