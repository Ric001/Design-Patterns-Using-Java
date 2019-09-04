package com.mycompany.models;

import java.io.Serializable;

public class Address implements Serializable {
    private static final long serialVersionUID = 1L;

    private String street;
    private String city;
    private String country;
    private String placeNumber;

    
    public Address() {
    }

    public Address(String street, String city, String country, String placeNumber) {
        this.street = street;
        this.city = city;
        this.country = country;
        this.placeNumber = placeNumber;
    }

    
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPlaceNumber() {
        return placeNumber;
    }

    public void setPlaceNumber(String placeNumber) {
        this.placeNumber = placeNumber;
    }

    @Override
    public String toString() {
        return "Address [city=" + city + ", country=" + country + ", placeNumber=" + placeNumber + ", street=" + street
                + "]";
    }
}