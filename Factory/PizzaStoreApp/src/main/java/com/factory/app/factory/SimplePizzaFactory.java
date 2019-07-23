package com.factory.app.factory;

import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

import com.factory.app.model.Cheesy;
import com.factory.app.model.Peperoni;
import com.factory.app.model.Pizza;
import com.factory.app.model.PizzaDescription;
import com.factory.app.model.Veggie;

public class SimplePizzaFactory {
    private List<Pizza> gottenPizas;

    public SimplePizzaFactory(Supplier<List<Pizza>> supplierList) {
        this.gottenPizas = supplierList.get();
    }

    public Pizza getPizza(PizzaDescription description) {
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
            return null;

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

}