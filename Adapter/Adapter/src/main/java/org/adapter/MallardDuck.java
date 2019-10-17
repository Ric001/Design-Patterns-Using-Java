package org.adapter;

public class MallardDuck implements Duckable {

    @Override
    public void quack() {
        System.out.println("Quack like a Mallard Duck");

    }

    @Override
    public void fly() {
        System.out.println("Fly Like a Mallard Duck");

    }

}