package org.pizzastores.store;

import java.util.function.Supplier;

import org.pizzastores.factory.AbstractPizzaFactoryMethod;
import org.pizzastores.model.Pizza;

public class ChicagoPizzaStore extends PizzaStore {

    public ChicagoPizzaStore(Supplier<AbstractPizzaFactoryMethod> factorySup) {
        super(factorySup.get());
    }
    
    @Override
    public Pizza createPizza(String type) {
		return getFactory().createPizza(type);
	}

    
}