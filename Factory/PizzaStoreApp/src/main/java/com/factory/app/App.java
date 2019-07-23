package com.factory.app;

import java.util.ArrayList;
import java.util.List;

import com.factory.app.businesslogic.PizzaStore;
import com.factory.app.factory.SimplePizzaFactory;
import com.factory.app.model.Pizza;
import com.factory.app.model.PizzaDescription;
import com.factory.app.model.enums.EPizzaTypes;

public class App 
{
    public static void main( String[] args )
    {
        PizzaDescription description = new PizzaDescription("Veggie Lover Pizza", 750F, EPizzaTypes.VEGGIE);
        SimplePizzaFactory factory = new SimplePizzaFactory(ArrayList<Pizza>::new);
        PizzaStore store = new PizzaStore(factory);
        System.out.println(store.orderPizza(description).toString());
        
    }
}
