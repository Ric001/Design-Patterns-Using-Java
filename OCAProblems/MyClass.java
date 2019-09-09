import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Objects;

import java.util.logging.Logger;

import sun.launcher.resources.launcher;
import sun.util.logging.resources.logging;

public class MyClass {

    public static void main(String[] args) {
        new StringTests().appending();
        // final StringTests testOne = new StringTests();
        // final StringTests testTwo = new StringTests();
        // testOne.setVal("Natural");
        // testTwo.setVal("Natural");

        // if (testOne.match(testTwo))
        //     System.out.println("They do Match");

    }

}



// jdbc:oracle:thin:@//172.27.5.17:1521/PCDLOL

// -Doracle.net.tns_admin=C:\Users\jose osorio soto\Desktop\ff\tnsnames.ora

// oracle.jdbc.timezoneAsRegion=false

class Calc {
    // Return type is not part of the method signature
    double calcAverage(double marks1, int marks2) {
        return (marks1 + marks2) / 2.0;
    }

    double calcAverage(int marks1, double marks2) {
        return (marks1 + marks2) / 2.0;
    }

    /** This is an overloaded method */
    private int calcAverage(float mark1, int mark2) {
        return (mark1 + mark2) / 2;
    }

    public double calcAverage(int marks1, int marks2) {
        /** This is an overloaded method */
        return (marks1 + marks2) / 2.0;
    }

    /***
     * Constructors can be user-defined constructors if they were created by a coder
     * instead of the java compiler.
     */
}

class Employee {
    String name;
    int age;
    // Initializers blocks are used to initialize instance data
    // from anonymous classes
    {
        System.out.println("Im an initializer block");
    }

    {
        System.out.println("Im an initializer block II");
    }

    {
        System.out.println("Im an initializer block III");
    }

    /**
     * 
     */
    Employee() {
        // this();
        /***
         * Recursive constructor invocation, since the constructor is enternally being
         * callled by himself
         */
    }

    /**
     * Employee Constructor
     * 
     * @param newAge  - The Person Age
     * @param newName - The Person Name
     */
    Employee(int newAge, String newName) {
        name = newName;
        age = newAge;
        System.out.println("Constructor(int, String)");
    }

    public int daysOffWork(int... days) {
        int daysOff = 0;
        for (int i = 0; i < days.length; i++)
            daysOff += days[i];
        return daysOff;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee [age=" + age + ", name=" + name + "]";
    }

    
}

class PersonOwn {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + "]";
    }
}


class Phone {
    private double weight;
    private String model;
    private String company;

    void makeCall() {
        System.out.println("Making call");
    }

    void recieveCall() {
        System.out.println("Recieving call");    
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    
}

