package org.commons.oca;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Logger;

public class Loops {
    
    private final static Logger _LOG = Logger.getLogger(Loops.class.getName());
    
    public void forLoop() {
        _LOG.info("[ENTERING void forLoop()]");

        final int tableOf = 25;
        int ctr2 = 12;

        for (int ctr = 1; ctr <= 5; ctr++) 
            System.out.println(tableOf * ctr);
        
        for (int in = 10,  k = 4; in <= k; in++, k++, ctr2--)
            System.out.println(in+":"+k+":"+ctr2);

        _LOG.info("[ENDING void forLoop()]");
    }

    public void forLoopII() {
        _LOG.info("[ENTERING void forLoppII()]");
        
        /**for (int j = 10, long longVar = 10; j <= 1; ++j) { Not allowed }*/
        //Correct Way: 
        for (int j = 10; j <= 1; j++)
            System.out.println("Show me what is like, to the drink me black and white?");
        
        int a = 1;
        for (; a <  5; ++a)
            System.out.println("Something in the way");

        _LOG.info("[ENDING void forLoopII()]");
    }

    public void forIII() {
        _LOG.info("[ENTERING void forIII()]");  
        
        for ( int a = 10; ; ++a) {
            System.out.println(a);
            break;
        }
        
        _LOG.info("[ENDING void forIII()]");
    }

    public void nestedLoops() {
        _LOG.info("[ENTERING void nestedLoops()]");

        for (int hrs = 1; hrs <= 6; hrs++) {
            for (int min = 1; min <= 60; min++) {
                System.out.println(hrs + ":" + min);
            }
        }
        _LOG.info("[ENDING void nestedLoops()]");
    }

    public void multiDimensional() {
        _LOG.info("[ENTERING void multiDimensional()]");

        final int[][] multiArr = new int[2][3];
        
        for (int i = 0; i < multiArr.length; i++)
            for (int j = 0; j < multiArr.length; j++)
                multiArr[i][j] = i + j;
        
        
        _LOG.info("[ENDING void multidimensional()] -> " + multiArr.toString());
    }

    public void iterator() {
        _LOG.info("[ENTERING void iterator()]");

        final ArrayList<String> myList = new ArrayList<>();
        myList.add("Java");
        myList.add("Loop");

        for (Iterator<String> i = myList.iterator(); i.hasNext(); )
            System.out.println(i.next());
        
        for (String val : myList)
            System.out.println(val);

        _LOG.info("[ENDING void iterator()]");
    }

    public void iterateNestedCollections() {
        _LOG.info("[ENTERING void iterateNestedCollections()]");

        final ArrayList<String> names = new ArrayList<>();
        names.add("Jose");
        names.add("Ricardo");

        final ArrayList<String> fruits = new ArrayList<>();
        fruits.add("Banana");
        fruits.add("Mango");

        final ArrayList<ArrayList<String>> nestedCollections = new ArrayList<>();
        nestedCollections.add(names);
        nestedCollections.add(fruits);

        for (ArrayList<String> collection : nestedCollections) 
            for (String val : collection)
                System.out.println(val);

        _LOG.info("[ENDING void iterateNestedCollections()]");
    }

    public void printingLoop() {
        _LOG.info("[ENTERING void printingLoop()]");
        
        int total = 0;
        int primeNums[] = { 2, 3, 7, 11 };
        
        for (int num : primeNums)
            total += num;
        System.out.println(total);

        _LOG.info("[ENDING void printingLoop()]");
    }
}