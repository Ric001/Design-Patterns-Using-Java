package org.pizzastores;

import org.pizzastores.factory.ChicagoPizzaFactory;
import org.pizzastores.factory.ChicagoPizzas;
import org.pizzastores.factory.NYPizzaFactory;
import org.pizzastores.factory.NYPizzas;
import org.pizzastores.store.ChicagoPizzaStore;
import org.pizzastores.store.NYPizzaStore;
import org.pizzastores.store.PizzaStore;

public class App 
{
    public static void main( String[] args )
    {
        App app = new App();
        app.testPizzaStore(new NYPizzaStore(NYPizzaFactory::new), NYPizzas.NY_CHESSY.name()); 
        app.testPizzaStore(new ChicagoPizzaStore(ChicagoPizzaFactory::new), ChicagoPizzas.CHICAGO_PEPERONI.name());
    }

    public void testPizzaStore(PizzaStore store, String type) {
        System.out.println(store.orderPizza(type).toString());
    }
}
