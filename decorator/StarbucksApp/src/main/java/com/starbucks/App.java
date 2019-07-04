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
        
        ITest something = (Dog dog) -> dog.getAge() == 9;
        something.test(new Dog());
        
    }
}
class Dog {
    private int age = 9;

    public int getAge() {
        return age;
    }
}
interface ITest {
    public boolean test(Dog dog);
}

