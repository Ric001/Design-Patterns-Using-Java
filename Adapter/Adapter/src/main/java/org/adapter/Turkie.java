package org.adapter;

public class Turkie implements Tukierable {

    @Override
    public void quack() {
        System.out.println("Quack like a Turkie");
    }

    @Override
    public void flyShort() {
        System.out.println("Fly like a Turkie");
    }
    
}