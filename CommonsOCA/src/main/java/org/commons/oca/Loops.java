package org.commons.oca;

import java.time.LocalDateTime;
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

    public void breakTale() {
        _LOG.info("[ENTERING void breakTale()]");
        
        final String[] programmers = { "Outer", "Inner" };
        for (String outer : programmers) 
        {
            for (String inner : programmers)
            {
                if (inner.equals("Inner"))
                    break;
                System.out.print(inner + ":");   
            }
        }
        _LOG.info("[ENDING void breakTale()]");
    }

    public void nameTale() 
    {
        _LOG.info("[ENTERING void nameTale()]");
        
        final String[] programmers = {"PAUL", "SHREYA", "SELVAN"};
        for (String name : programmers)
        {
            if (name.equals("SHREYA"))
            {
                continue;
            }
            System.out.println(name);
        }
        _LOG.info("[ENDING void nameTale()]");
    }

    public void labeledExpressions() 
    {
        _LOG.info("[ENTERING void labeledExpressions()]");

        final String[] programmers = {"Outer", "Inner"};
        outer:
            for (final String outer : programmers) 
                for (final String inner : programmers) {
                    if (inner.equals("Inner"))
                        continue outer;
                    System.out.println(inner + ":");
                }
        _LOG.info("[ENDING void labeledExpressions()]");
    }

    public void num20() 
    {
        _LOG.info("[ENTERING void num20()]");
        
        int num = 20;
        final int num2 = 20;
        
        switch(num) 
        {
            case num2: System.out.println(4);
            break;
            default: System.out.println("Default");
        }
        
        _LOG.info("[ENDING void num20()]");
    }

    public void tillICollapse()
    {
        _LOG.info("[ENTERING void tillICollapse()]");

        _LOG.info("[ENDING void tillICollapse()]");
    }
}

interface Runner 
{
    int speed();
    double distance = 70;
}

strictfp interface RunnerII extends Runner {

    static void askXamy()
    {

    }

    default void submitInterviewStatus() {
        System.out.println("Accept");
    }
}

class Monday implements Runner {
    @Override
    public int speed() {
        return (int) distance;
    }
}


interface Interviewer {
    abstract void condudctInterview();

    default void submitInterviewStatus() {
        System.out.println("Accept");
    }

    static void bookConferenceRoom(final LocalDateTime dateTime, final int duration) {
        System.out.println("Interview scheduled on:" + dateTime);
        System.out.println("Book conference room for: " + duration + "hrs");
    }

    static void lostIt(final String songName, final String letterContent) {
        System.out.println("All this time you were pretending so much for my happy ending");
        System.out.println("");
    }
}

class Emp implements Interviewer {

    @Override
    public void condudctInterview() {

    }
    
}