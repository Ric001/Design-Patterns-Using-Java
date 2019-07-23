package com.factory.app.model;
import com.factory.app.model.enums.EPizzaTypes;
public abstract class Pizza {
    
    protected String name;
    protected float price;
    protected EPizzaTypes type;
    protected boolean prepared;
    protected boolean cooked;
    protected boolean sliced;
    protected boolean packaged;

    public Pizza(String name, float price, EPizzaTypes type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public boolean isPrepared() {
        return prepared;
    }

    public boolean isCooked() {
        return cooked;
    }

    public boolean isSliced() {
        return sliced;
    }

    public boolean isPackaged() {
        return packaged;
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
}