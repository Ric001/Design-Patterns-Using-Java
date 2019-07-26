package org.pizzastores.factory;

import org.pizzastores.model.Pizza;

public interface AbstractPizzaFactoryMethod {
    public Pizza createPizza(String type);
}