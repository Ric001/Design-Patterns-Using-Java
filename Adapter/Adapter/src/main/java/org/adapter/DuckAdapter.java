package org.adapter;

import java.util.Objects;
import java.util.Optional;

public class DuckAdapter implements Duckable {
    private Optional<Turkie> duck;

    public DuckAdapter(Optional<Turkie> duck) {
        setDuck(duck);
    }

    
    @Override
    public void quack() 
    {
        if (duck.isPresent()) 
        {
            duck.get().quack();            
        }
    }

    public Optional<Turkie> getDuck() {
        return duck;
    }

    public void setDuck(Optional<Turkie> duck) {
        if (Objects.isNull(duck)) {
            duck = Optional.empty();
        }
        this.duck = duck;
    }

    @Override
    public void fly() {
       if (duck.isPresent())
       {
           duck.get().flyShort();
       }
    }
    
}