package com.mycompany;

import java.io.Serializable;
import java.util.logging.Logger;

public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private float price;

    private final static Logger LOG = Logger.getLogger(Product.class.getName());

    public Product(String name, float price) {
        LOG.info("CREATING Product TDD");
        this.setName(name);
        this.setPrice(price);
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product [name=" + name + ", price=" + price + "]";
    }
}