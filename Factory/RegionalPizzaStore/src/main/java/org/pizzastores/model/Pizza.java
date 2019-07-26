package org.pizzastores.model;

public abstract class Pizza {
    protected PizzaDescription description;
    protected String type;
    protected boolean baked;
    protected boolean prepared;
    protected boolean boxed;
    protected boolean sliced;

    public Pizza(PizzaDescription description, String type) {
        this.description = description;
        this.type = type;
    }

    public Pizza prepare() {
        prepared = true;
        return this;  
    }

    public Pizza bake() {
        baked = true;
        return this;
    }

    public Pizza  box() {
        boxed = true;
        return this;
    }

    public Pizza slice() {
        sliced = true;
        return this;
    }

    @Override
    public String toString() {
        return "'Pizza': {baked:" + baked + ", boxed:" + boxed + ", description:" + description + ", prepared:" + prepared
                + ", sliced:" + sliced + ", type:" + type + "}";
    }

    
    
}