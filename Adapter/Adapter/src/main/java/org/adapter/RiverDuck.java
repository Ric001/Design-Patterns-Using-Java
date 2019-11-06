package org.adapter;

public class RiverDuck implements Duckable
{
    
    @Override
    public void quack() {
        System.out.println("River quack");
    }

    @Override
    public void fly() {
        System.out.println("River flying");
    }
    
}