package com.factory.app.businesslogic;

import java.util.Objects;

import com.factory.app.factory.SimplePizzaFactory;
import com.factory.app.model.Pizza;
import com.factory.app.model.PizzaDescription;

public class PizzaStore  {
    private SimplePizzaFactory factory;

    public PizzaStore(SimplePizzaFactory factory) {
        this.factory = factory;
    }

    public Pizza orderPizza(PizzaDescription description) {
        if (Objects.isNull(factory))
            return null;
            
        return factory.getPizza(description);
    }
    
    public SimplePizzaFactory getFactory() {
        return factory;
    }

    public void setFactory(SimplePizzaFactory factory) {
        this.factory = factory;
    }


}