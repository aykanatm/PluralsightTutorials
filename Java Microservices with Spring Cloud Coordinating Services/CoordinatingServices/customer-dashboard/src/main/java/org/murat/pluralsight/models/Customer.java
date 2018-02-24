package org.murat.pluralsight.models;

public class Customer {
    private String id;
    private String name;
    private String lastname;

    public Customer(){}
    public Customer(String id, String name, String lastname){
        this.id = id;
        this.name = name;
        this.lastname = lastname;
    }

    public String getId() {
        return id;
    }

    public String getLastname() {
        return lastname;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setName(String name) {
        this.name = name;
    }
}
