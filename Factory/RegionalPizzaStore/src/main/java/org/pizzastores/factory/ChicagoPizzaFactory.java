package org.pizzastores.factory;

import java.util.Objects;

import org.pizzastores.model.Chessy;
import org.pizzastores.model.Peperoni;
import org.pizzastores.model.Pizza;
import org.pizzastores.model.PizzaDescription;

public class ChicagoPizzaFactory implements AbstractPizzaFactoryMethod {

    @Override
    public Pizza createPizza(String type) {

        if (Objects.isNull(type))
            return null;
        if (type.isEmpty())
            return null;

        return validatePizzaType(ChicagoPizzas.valueOf(type));
    }

    private Pizza validatePizzaType(ChicagoPizzas convertedToEnum) {
        float price = (float) Math.random() * 10;
        int id = (int) Math.random() * 100;

        switch (convertedToEnum) {
        case CHICAGO_CHESSE:
            return new Chessy(new PizzaDescription(id, convertedToEnum.name(), price), convertedToEnum.getType())
                    .prepare().bake().slice().box();
        case CHICAGO_PEPERONI:
            return new Peperoni(new PizzaDescription(id, convertedToEnum.name(), price), convertedToEnum.getType())
                    .prepare().bake().slice().box();
        case CHICAGO_VEGGIE:
            return new Peperoni(new PizzaDescription(id, convertedToEnum.name(), price), convertedToEnum.getType())
                    .prepare().bake().slice().box();
        default:
            return null;
        }
    }
}