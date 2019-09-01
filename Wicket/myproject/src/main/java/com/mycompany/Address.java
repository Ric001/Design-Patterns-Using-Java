package com.mycompany;

import java.io.Serializable;
import java.util.logging.Logger;

public class Address implements Serializable {
    private static final long serialVersionUID = 1L;
    private String street;
    private String placeNumber;
    private String country;
    private String city;

    private final static Logger LOG = Logger.getLogger(Address.class.getName());

    public Address(String street, String placeNumber, String country, String city) {
        this(street, country, city);
        this.placeNumber = placeNumber;
    }

    public Address(String street, String country, String city) {
        this.street = street;
        this.country = country;
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPlaceNumber() {
        return placeNumber;
    }

    public void setPlaceNumber(String placeNumber) {
        this.placeNumber = placeNumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address [city=" + city + ", country=" + country + ", placeNumber=" + placeNumber + ", street=" + street
                + "]";
    }

    

}