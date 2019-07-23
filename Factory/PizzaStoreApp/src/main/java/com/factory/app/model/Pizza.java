package com.factory.app.model;


public abstract class Pizza {
    
    protected PizzaDescription description;
    protected boolean prepared;
    protected boolean cooked;
    protected boolean sliced;
    protected boolean packaged;

    public Pizza(PizzaDescription description) {
        this.description = description;
    }

    public Pizza() {}

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
    public String toString() {
        return "Pizza [cooked=" + cooked + ", description=" + description + ", packaged=" + packaged + ", prepared="
                + prepared + ", sliced=" + sliced + "]";
    }

    
}