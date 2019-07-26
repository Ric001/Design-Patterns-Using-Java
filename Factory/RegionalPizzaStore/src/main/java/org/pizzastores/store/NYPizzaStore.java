package org.pizzastores.store;

import java.util.function.Supplier;

import org.pizzastores.factory.AbstractPizzaFactoryMethod;
import org.pizzastores.model.Pizza;

public class NYPizzaStore extends PizzaStore {

    public NYPizzaStore(Supplier<AbstractPizzaFactoryMethod> factorySup) {
        super(factorySup.get());
    }

	@Override
    public Pizza createPizza(String type) {
		return super.getFactory().createPizza(type);
	}

}