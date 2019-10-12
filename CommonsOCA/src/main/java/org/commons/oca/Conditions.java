package org.commons.oca;


import java.util.logging.Logger;

public class Conditions {

    private final static Logger _LOG = Logger.getLogger(Conditions.class.getName());

    public void evaluate() {
        _LOG.info("[ENTERING void evaluate()]");

        int score = 100;
        String result = "";
        String name = "Lion";
        final java.io.File file = new java.io.File("F");
        
        if (name.equals("Lion"))
            score = 200;
        if (name.equals("Lion"))
            score = 200;
        else 
            score = 300;

        if (score == 100)
            result = "A";
        else if (score == 50)
            result = "B";
        else 
            result = "F";
        
        _LOG.info("[ENDING void evaluate()]");
    }

    public void twist() {
        _LOG.info("[ENTERING void twist()]");

        String result = "1";
        int score = 10;

        if ((score = score + 10) == 100)
            result = "A";
        else if ((score = score + 29) == 50)
            result = "B";
        else if ((score = score +200) == 200)
            result = "C";
        else  
            result = "F";
        System.out.println(result + ":" + score);
    
        _LOG.info("[ENDING void twist()]");
    }

    public void elseBraces() {
        _LOG.info("[ENTERING void elseBraces()]");
        
        final String name = "LionKing";

        if (name.equals("Lion"))
            System.out.println("Lion");
        else {
            System.out.println("Not A Lion");
            System.out.println("Again, not a lion");
        }
        
        _LOG.info("[ENDING void elseBraces()]");
    }

    public void hiddenControls() {
        _LOG.info("[ENTERING viod hiddenControls()]");

        final String name = "Lion";
        if (name.equals("Lion"))
            for(int i = 0; i < 3; ++i)
                System.out.println(i);
        
        _LOG.info("[ENDING void hiddenControls()]");
    }

    public void logicalDesese() {
        _LOG.info("[ENTERING void logicalDesese]");

        boolean allow = false;
        
        if (allow)
            System.out.println("Value is true");
        else
            System.out.println("Value is false");

        _LOG.info("[ENDING void logicalDesese]");
    }

    public void thinkingTooMuch() {
        _LOG.info("[ENTERING void thinkingTooMuch()]");
        
        final int score = 110;
        if (score > 200) {
            if (score < 400)
                if (score > 300)
                    System.out.println(1);
                else 
                    System.out.println(2);
        } else {
            System.out.println(3);
        }
        _LOG.info("[ENDING void thinkingTooMuch()]");
    } 

    public void symphonyOfDestruction() {
        _LOG.info("[ENTERING void symphonyOfDestruction()]");

        final int bill  = 2000;
        final int discount = (bill > 2000) ? 15 : 10;
        System.out.println(discount);

        _LOG.info("[ENDING void symphonyOfDestruction()]");
    }

    public void ter() {
        _LOG.info("[ENTERING void ter()]");

        final Ter ter = new Ter();
        ter.ternaryConstruct();

        _LOG.info("[ENDING void ter()]");
    }
}


class Ter {
    public void ternaryConstruct() {
        final int bill = 2000;
        final int discount = (bill > 2000) ? getRegDisc() : getSpecDisc();
        System.out.println(discount);
    }

    public int getRegDisc() {
        return 11;
    }

    public int getSpecDisc() {
        return 15;
    }
} 

class TernaryConst {

    private final static Logger _LOG = Logger.getLogger(TernaryConst.class.getName());
    
    public void invalidTernaryConstruct() {
        _LOG.info("[ENTERING void invalidTernaryConstruct()]");

        final int bill = 2000;
        final int discount = (bill > 2000)? 10 : getRegularDiscount();
        System.out.println(discount);
        
        _LOG.info("[ENDING void invalidTernaryConstruct()]");
    }

    public void helloWorld() {
        _LOG.info("[ENTERING void helloWorld()]");
        
        final long bill = 2000;
        final Integer discountII = (5000 > 2000)? new Integer(10) : new Integer(15); 
        final long discount = (bill > 2000)? bill - 100 : bill - 50;

        _LOG.info("[ENDING void helloWorld()]");
    }

    public int getRegularDiscount() {
        System.out.println("Reg Discount -> 10");
        return 10;
    }

    public void caseConstants() {
        _LOG.info("[ENTERING void caseConstants()]");
        
        final int a = 50;
        final int b = 20;
        final int c = 30;

        switch(a) {
            case b + c: 
            System.out.println("A + B -> " + (a + b));
            break;
            case 10 * 7:
                System.out.println("Hello People");
                break;
        }
    
        _LOG.info("[ENDING void caseConstants()]");
    }

    
    public void execute() {
        _LOG.info("[ENTERING void execute()]");
        
        final int a = 10;
        final int b = 20;
        final int c = 30;
        
        switch(a) {
            case b + c : 
                System.out.println(b + c);
                break;
        }

        _LOG.info("[ENDING void execute()]");
    }

    public void executeII() {
        _LOG.info("[ENTERING void executeII()]");
        
        final byte myByte = 10;
        final String name = null;
        final String lastname = "Osiris";
    
        switch(String.valueOf(name)) {
            case "Paul" : 
                System.out.println(1);
                break;
            case "null":
                System.out.println("null");
                break;
        }

        _LOG.info("[ENDING void executeII()]");
    }

    public void executeIII() {
        _LOG.info("[ENTERING void executeIII()]");

        final int score = 10;
        
        switch(score) {
            case 100:
            case 50:
            case 10:
                System.out.println("Average score");
                break;    
            case 200:
                System.out.println("Good Score");
                break;
        }

        

        _LOG.info("[ENDING void executeIII()]");
    }

}