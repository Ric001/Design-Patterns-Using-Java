package org.adapter;

import java.util.Optional;

public class TurkieAdapter implements Tukierable {

    private Optional<? extends Duckable> duck;

    

    @Override
    public void quack() {
        duck.get().quack();
    }

    @Override
    public void flyShort() {
        duck.get().fly();
    }

    public TurkieAdapter(Optional<? extends Duckable> duck) {
        this.duck = duck;
    }

}