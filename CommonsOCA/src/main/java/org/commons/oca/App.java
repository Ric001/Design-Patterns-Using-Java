package org.commons.oca;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        final List<Hector> list = new ArrayList<>();
        list.forEach(val -> {
            val.printEdad();
        });
    }

    public static void print() {
        System.out.println("Happy");
    }
}

class Hector {
    int edad;

    public Hector(int edad) {
        this.edad = edad;
    }

    public void printEdad() {
        System.out.println(this.edad);
    }

}