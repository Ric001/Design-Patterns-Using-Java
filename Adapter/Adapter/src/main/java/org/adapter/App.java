package org.adapter;

import java.util.Optional;

public class App 
{
    public static void main( String[] args )
    {
       final Duckable duck = new DuckAdapter(Optional.of(new Turkie()));
       duck.quack();
       duck.fly();
       final Tukierable turkie = new TurkieAdapter(Optional.of(new MallardDuck()));
       turkie.quack();
       turkie.flyShort();
    }
}
