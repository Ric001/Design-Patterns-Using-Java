package org.pizzastores.factory;

import java.util.Objects;

import org.pizzastores.model.Chessy;
import org.pizzastores.model.Peperoni;
import org.pizzastores.model.Pizza;
import org.pizzastores.model.PizzaDescription;
import org.pizzastores.model.Veggie;

public class NYPizzaFactory implements AbstractPizzaFactoryMethod {

    @Override
    public Pizza createPizza(String type) {
        
        if (Objects.isNull(type))
            return null;
        if (type.isEmpty())
            return null;

        return validatePizzaType(NYPizzas.valueOf(type));
    }

    private Pizza validatePizzaType(NYPizzas convertedToEnum) {
        final float price = (float) Math.random() * 10;
        final int id = (int) Math.random() * 100; 
        
        switch(convertedToEnum) {
            case NY_CHESSY:
                return new Chessy(new PizzaDescription(id, convertedToEnum.name(), price), convertedToEnum.getType())
                .prepare().bake().slice().box();
             case NY_PEPERONI:
                return new Peperoni(new PizzaDescription(id, convertedToEnum.name(), price), convertedToEnum.getType())
                .prepare().bake().slice().box();
            case NY_VEGGIE:
                return new Veggie(new PizzaDescription(id, convertedToEnum.name(), price), convertedToEnum.getType())
                    .prepare().bake().slice().box();
            default:
                return null;
        }
    }

}