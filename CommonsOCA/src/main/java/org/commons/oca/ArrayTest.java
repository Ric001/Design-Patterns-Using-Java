package org.commons.oca;

import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Logger;

public class ArrayTest {
    
    private final static Logger _LOG = Logger.getLogger(ArrayTest.class.getName());

    public void vector() {
        _LOG.info("[ENTERING array(): void]");

        final int intArray[] = new int[]{ 1, 2, 3};
        final String objArray[] = new String[] {"Harry", "Fito", "Paez"};
        //1. Declaring the array
        int[] agesArray = null;
        //2. Allocating the array
        agesArray = new int[2];
        //3. Initializing the array
        agesArray[0] = 22; agesArray[1] = 11;
        final CopyOnWriteArrayList<Integer> cp = new CopyOnWriteArrayList<>();
        _LOG.info("[ENDING array(): void]");
    }

    public void twoDimensional() {
        _LOG.info("[ENTERING twoDimensional(): void]");
        final int[] multiArr[] = new int[2][3];
        for (int row = 0; row < multiArr.length; row++)
            for(int column = 0; column < multiArr[column].length; column++)
                multiArr[row][column] = row + column;

        _LOG.info("[ENDING twoDimensional(): void]");
    }

    public void usingArray() {
        _LOG.info("[ENTERING void allocating() ]");
        final int intArray[] = new int[2];
        
        for (int i = 0; i < intArray.length; i++)
            intArray[i] = i + 5;
        
        intArray[0] = 10;
        intArray[1] = 1870;

        _LOG.info("[ENDING void allocating()]");
    }

    public void arrayStr() {
        _LOG.info("[ENTERING void arrayStr()]");
        final String[] strArray = new String[4];
        
        for(int i = 0; i < strArray.length; i++)
            strArray[i] = new String("Hello " + i);

        strArray[1] = "Summer";
        strArray[3] = "Winter";
        strArray[0] = "Autumn";
        strArray[2] = "Spring";
        
        _LOG.info("[ENDING void arrayStr()]");
    }

    public void stationsArr() {
        _LOG.info("[ENTERING void statationArr()]");    
        final String[] strArray = new String[] {"Autumn", "Summer", "Spring", "Winter"};
        strArray[2] = null;
        
        for(String val : strArray) 
            if (Objects.nonNull(val))
                System.out.println(val);

        _LOG.info("[ENDING void stationsArr()]");
    }
}

interface MyInterface {}

abstract class Vehicule {}

class MyClass implements MyInterface {}

class MyClass2 implements MyInterface {}

class Car extends Vehicule {}
class Bus extends Vehicule {}

class Test {
    
    private final static Logger LOG  = Logger.getLogger(Test.class.getName());

    public void perform() {
        LOG.info("[ENTERING void perform()]");

        final MyInterface[] interfaceArray = new MyInterface[] {
            new MyClass(),
            new MyClass2(),
            null
        };

        final Vehicule[] vehicules = { 
            new Car(),
            new Bus(),
            null
        };

        final Object[] objArray = new Object[] {
            new MyClass(),
            null,
            new Car(),
            new java.util.Date(),
            new String("name"),
            new Integer[7]
        };
        
        for(Vehicule vehicule: vehicules) 
            if (Objects.nonNull(vehicule))
                System.out.println(vehicule.getClass().getName());
        
        for(MyInterface interfaceElement: interfaceArray)
            if (Objects.nonNull(interfaceElement))
                System.out.println(interfaceElement.getClass().getName());

        for(Object obj: objArray) 
            if (Objects.isNull(obj))
                System.out.println(obj.getClass().getName());
        
        LOG.info("[ENDING void perform()]");
    }

    public void arrayList() {
        LOG.info("[ENTERING void arrayList()]");
        
        final ArrayList<String> names = new ArrayList<>();
        
        LOG.info("[ENDING void arrayList()]");
    }

}


