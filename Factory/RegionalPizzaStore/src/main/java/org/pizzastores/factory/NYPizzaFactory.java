package org.pizzastores.factory;

import java.util.Objects;
import java.util.logging.Logger;

import org.pizzastores.model.Chessy;
import org.pizzastores.model.Peperoni;
import org.pizzastores.model.Pizza;
import org.pizzastores.model.PizzaDescription;
import org.pizzastores.model.Veggie;

public class NYPizzaFactory implements AbstractPizzaFactoryMethod {
    private final static Logger LOG = Logger.getLogger(NYPizzaFactory.class.getName());

    @Override
    public Pizza createPizza(String type) {
        LOG.info("[ENTERING createPizza(String type): Pizza]");
        Pizza pizza = null;
        if (Objects.isNull(type) || type.isEmpty())
            return pizza;

        return pizza = validatePizzaType(NYPizzas.valueOf(type));
    }

    private Pizza validatePizzaType(NYPizzas convertedToEnum) {
        LOG.info("[ENTERING validatePizzaType(NYPizzas convertedToEnum): Pizza]");

        final float price = (float) Math.random() * 10;
        final int id = (int) Math.random() * 100;

        switch (convertedToEnum) {
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
            LOG.info("Unsupported New York Pizza Type");
            return null;
        }
    }

}