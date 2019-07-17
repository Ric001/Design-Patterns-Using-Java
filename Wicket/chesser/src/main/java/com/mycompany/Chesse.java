package com.mycompany;

import java.io.Serializable;

public class Chesse implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name;
    private String description;
    private double price;

    public Chesse(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    
}