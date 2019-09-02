package com.mycompany;

import java.io.Serializable;

public class Person implements Serializable {

    private String name;
    private String lastname;
    private String profession;

    public Person(String name, String lastname, String profession) {
        this.name = name;
        this.lastname = lastname;
        this.profession = profession;
    }

    public Person() {}
    

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

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    
    @Override
    public String toString() {
        return "Person [lastname=" + lastname + ", name=" + name + ", profession=" + profession + "]";
    }

    
}