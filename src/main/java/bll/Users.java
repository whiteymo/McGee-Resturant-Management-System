package bll;

import java.io.Serializable;

/**
 *
 * @author Dell
 */
public class Users implements Serializable{

    private int id;
    private String fname;
    private String lname;
    private String username;
    private String password;
    private String gender;
    private String role;

    public Users(int id, String fname, String lname, String username, String password, String gender, String role) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.role = role;
    }

    public Users(String username, String password){
        this.username = username;
        this.password = password;
    }

    public Users(String username, String password, String role) {
        this.username =username;
        this.password = password;
        this.role = role;
    }

    public Users(){

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
