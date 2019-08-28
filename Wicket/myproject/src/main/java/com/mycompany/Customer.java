package com.mycompany;

import java.io.Serializable;
import java.util.logging.Logger;

public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String lastname;
    private String age;


    private final static Logger LOG = Logger.getLogger(Customer.class.getName());

    public Customer(String name, String lastname, String age) {
        LOG.info("CREATING CUSTOMER TDD");
        this.setName(name);
        this.setLastname(lastname);
        this.setAge(age);
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Customer [age=" + age + ", lastname=" + lastname + ", name=" + name + "]";
    }
 
    
}