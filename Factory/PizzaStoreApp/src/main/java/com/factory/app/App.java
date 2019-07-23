package com.factory.app;

import java.util.ArrayList;
import com.factory.app.businesslogic.PizzaStore;
import com.factory.app.factory.SimplePizzaFactory;
import com.factory.app.model.Pizza;
import com.factory.app.model.PizzaDescription;
import com.factory.app.model.enums.EPizzaTypes;
import static java.lang.System.out;

public class App 
{
    public static void main( String[] args )
    {
        PizzaDescription description = new PizzaDescription("Veggie Lover Pizza", 750F, EPizzaTypes.VEGGIE);
        SimplePizzaFactory factory = new SimplePizzaFactory(ArrayList<Pizza>::new);
        PizzaStore store = new PizzaStore(factory);
        out.println(store.orderPizza(description));
    }
}
