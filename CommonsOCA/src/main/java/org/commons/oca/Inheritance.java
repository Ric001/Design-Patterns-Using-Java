package org.commons.oca;

public class Inheritance {

}

class Programmer extends Employee {

    private String[] programmingLanguages;

    void writeCode() {
    }

    public String[] getProgrammingLanguages() {
        return programmingLanguages;
    }

    public void setProgrammingLanguages(String[] programmingLanguages) {
        this.programmingLanguages = programmingLanguages;
    }
}

class Manager extends Employee {

    private int teamSize;

    void reportProjectStatus() {
    }

    public int getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }
}

class Employee {

    private String name;
    private String address;
    private String phoneNumber;
    private float expirience;
    private String facebookId;

    public String getName() {
        return name;
    }

    public String getFacebookId() {
        return facebookId;
    }

    public void setFacebookId(String facebookId) {
        this.facebookId = facebookId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getExpirience() {
        return expirience;
    }

    public void setExpirience(float expirience) {
        this.expirience = expirience;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Astronaut extends Employee {
    private int hoursInSpace;

    public int getHoursInSpace() {
        return hoursInSpace;
    }

    public void setHoursInSpace(int hoursInSpace) {
        this.hoursInSpace = hoursInSpace;
    }
}

class Doctor extends Employee {

    private String surgery;
   
    public String getSurgery() {
        return surgery;
    }

    public void setSurgery(String surgery) {
        this.surgery = surgery;
    }
}