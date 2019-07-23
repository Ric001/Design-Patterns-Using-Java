package com.factory.app.model;

import com.factory.app.model.enums.EPizzaTypes;

public class PizzaDescription {
    private String name;
    private float price;
    private EPizzaTypes type;

    public PizzaDescription(String name, float price, EPizzaTypes type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public PizzaDescription() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public EPizzaTypes getType() {
        return type;
    }

    public void setType(EPizzaTypes type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "PizzaDescription [name=" + name + ", price=" + price + ", type=" + type + "]";
    }

    
}