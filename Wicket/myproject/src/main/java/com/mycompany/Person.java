package com.mycompany;

import java.io.Serializable;
import java.util.logging.Logger;

public class Person implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private String name;
    private String lastname;
    private String career;
    private Address address;
    
    private final static Logger LOG = Logger.getLogger(Person.class.getName());

    public Person(String name, String lastname, String career, Address address) {
        LOG.info("[ CREATING Person TDD ]");
        
        this.name = name;
        this.lastname = lastname;
        this.career = career;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person [address=" + address + ", career=" + career + ", lastname=" + lastname + ", name=" + name + "]";
    }

    
    
}