package org.commons.oca;

import java.io.File;
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


}