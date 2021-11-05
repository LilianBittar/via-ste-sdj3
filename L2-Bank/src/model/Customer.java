package model;

public class Customer {
    private String name;
    private int Id;

    public Customer(String name, int Id){
        this.name = name;
        this.Id = Id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return Id;
    }
}