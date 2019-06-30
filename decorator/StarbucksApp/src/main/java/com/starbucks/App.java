package com.starbucks;

public class App 
{
    public static void main( String[] args )
    {
        Beverage espresso = new Espresso();
        System.out.println("Espressso: " + (float)espresso.cost());

        Beverage houseBlend = new HouseBlend(); 
        houseBlend = new Mocha(houseBlend);
        houseBlend = new Whip(houseBlend);
        
        System.out.println(houseBlend.getDescription() + "\nCost: " 
        + (float) houseBlend.cost());
    }
}
