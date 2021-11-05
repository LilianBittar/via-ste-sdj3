package model;

import java.io.Serializable;

public class Adminstrator implements Serializable {

    private String email;
    private String password;

    public Adminstrator(String email, String password){
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
