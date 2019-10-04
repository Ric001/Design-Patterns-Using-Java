package org.commons.oca;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

public class Loops {
    
    private final static Logger _LOG = Logger.getLogger(Loops.class.getName());
    
    public void enhancedForLoop() {
        _LOG.info("[ENTERING void enhancedForLoop()]");
        
        final List<String> exams = new ArrayList<>();
        exams.add("Java");
        exams.add("Oracle");
        
        final List<String> levels = new ArrayList<>();
        levels.add("Basic");
        levels.add("Advanced");
        
        final List<String> grades = new ArrayList<>();
        grades.add("Password");
        grades.add("Fail");
        
        for (final String exam : exams) 
            for (final String level : levels)
                for (final String grade : grades) 
                    System.out.println(exam + ":" + level + ":" + grade);
        
        _LOG.info("[ENDING void enhancedFoorLoop()]");
    }
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

    public void whileLoop() {
        _LOG.info("[ENTERING void whileLopp()]");
        
        int num = 9;
        boolean divisibleBy7 = false;
        while (!divisibleBy7) {
            System.out.println(num);
            if (num % 7 == 0) divisibleBy7 = true;
            --num;
        }

        _LOG.info("[ENDING void whileLoop()]");
    }


    public void doWhile() {
        _LOG.info("[ENTERING void doWhile()]");
        
        boolean exitSelected = false;
        do {
            final String selectedOption = displayMenuToUser();
            if (selectedOption.equals("exit"))
                exitSelected = true;
            else
                executeCommand(selectedOption);
        } while (exitSelected == false);

        _LOG.info("[ENDING void doWhile()]");
    }

    private void executeCommand(final String command) {
        System.out.println("Executing " + command);
    }

    private String displayMenuToUser() {
        _LOG.info("[ENTERING String displayMenuToUser()]");

        final String EXIT_OPTION = "exit";
        System.out.println("========================");
        System.out.println("      1.Do Nothing      ");
        System.out.println("      2. Exit           ");
        System.out.println("========================");
        
        _LOG.info("[RETURNING FROM String displayMenuToUser()] " + EXIT_OPTION);
        return EXIT_OPTION;
    }
}