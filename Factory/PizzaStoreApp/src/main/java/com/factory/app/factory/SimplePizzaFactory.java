package com.factory.app.factory;

import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;
import java.util.logging.Logger;

import com.factory.app.model.Cheesy;
import com.factory.app.model.Peperoni;
import com.factory.app.model.Pizza;
import com.factory.app.model.PizzaDescription;
import com.factory.app.model.Veggie;

public class SimplePizzaFactory {
    private List<Pizza> gottenPizas;

    private static final Logger LOG = Logger.getLogger(SimplePizzaFactory.class.getName());
    
    public SimplePizzaFactory(Supplier<List<Pizza>> supplierList) {
        LOG.info("[CREATING SimplePizzaFactory(Supplier<List<Pizza>>)]");
        this.gottenPizas = supplierList.get();
    }

    public Pizza getPizza(PizzaDescription description) {
        LOG.info("[ENTERING getPizza(PizzaDescription): Pizza]");
        Pizza pizza = null;

        switch (description.getType()) {
        case CHESSY:
            pizza = new Cheesy(description);
            break;
        case VEGGIE:
            pizza = new Veggie(description);
            break;
        case PEPERONI:
            pizza = new Peperoni(description);
            break;
        }

        if (Objects.isNull(pizza))
            return pizza;

        pizza.prepare().cook().slice().pack();
        gottenPizas.add(pizza);
        return pizza;
    }

    public List<Pizza> getGottenPizas() {
        return gottenPizas;
    }

    public void setGottenPizas(List<Pizza> gottenPizas) {
        this.gottenPizas = gottenPizas;
    }

    @Override
    public String toString() {
        return "SimplePizzaFactory [gottenPizas=" + gottenPizas + "]";
    }

}