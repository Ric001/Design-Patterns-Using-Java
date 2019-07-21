package com.mycompany;

import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;

public class Cart implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private List<Chesse> chesses = new ArrayList<>();
    private Address billingAddress = new Address();
    private double total;

    public List<Chesse> getChesses() {
        return chesses;
    }

    public void setChesses(List<Chesse> chesses) {
        this.chesses = chesses;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    public double getTotal() {
        for (Chesse cheese : chesses) 
            total += cheese.getPrice();
        return total;
    }

    public void clearAmount() {
        total = 0;
    }
}