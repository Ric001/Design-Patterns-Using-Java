package com.factory.app.model;

import static java.util.Objects.isNull;

public abstract class Pizza {

    protected PizzaDescription description;
    protected boolean prepared;
    protected boolean cooked;
    protected boolean sliced;
    protected boolean packaged;
    protected int pizzaID;

    public Pizza(PizzaDescription description) {
        this.description = description;
    }

    public Pizza() {
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

    public Pizza prepare() {
        prepared = true;
        return this;
    }

    public Pizza cook() {
        cooked = true;
        return this;
    }

    public Pizza slice() {
        sliced = true;
        return this;
    }

    public Pizza pack() {
        packaged = true;
        return this;
    }

    public PizzaDescription getDescription() {
        return description;
    }

    public Pizza setDescription(PizzaDescription description) {
        this.description = description;
        return this;
    }

    @Override
    public boolean equals(Object incomingPizza) {
        if (isNull(incomingPizza)) 
            return false;
        
        if (incomingPizza instanceof Pizza) 
            return ((Pizza) incomingPizza).getPizzaID() == pizzaID;

        return false;
    }

    public int getPizzaID() {
        return pizzaID;
    }

    public void setPizzaID(int pizzaID) {
        this.pizzaID = pizzaID;
    }

    @Override
    public String toString() {
        return "Pizza [cooked=" + cooked + ", description=" + description + ", packaged=" + packaged + ", pizzaID="
                + pizzaID + ", prepared=" + prepared + ", sliced=" + sliced + "]";
    }

}