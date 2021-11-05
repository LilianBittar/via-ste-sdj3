package model;

import java.io.Serializable;

public class Clerk implements Serializable {

    private String name;
    private boolean isAvailable;

    public Clerk(String name, boolean isAvailable){
        this.name = name;
        this.isAvailable = isAvailable;
    }

    public String getName(){
        return name;
    }

    public boolean isAvailable(){
        return isAvailable;
    }
}
