package org.pizzastores.store;

import java.util.Objects;

import org.pizzastores.factory.AbstractPizzaFactoryMethod;
import org.pizzastores.model.Pizza;

public abstract class PizzaStore {
    private AbstractPizzaFactoryMethod factory;

    public PizzaStore(AbstractPizzaFactoryMethod factory) {
        if (Objects.isNull(factory))
            throw new NullPointerException();
        this.factory = factory;
    }
    public final Pizza orderPizza(String type) {
        return createPizza(type);
    }
    
    public abstract Pizza createPizza(String type);
    
    public AbstractPizzaFactoryMethod getFactory() {
        return factory;
    }

    public void setFactory(AbstractPizzaFactoryMethod factory) {
        this.factory = factory;
    }
}