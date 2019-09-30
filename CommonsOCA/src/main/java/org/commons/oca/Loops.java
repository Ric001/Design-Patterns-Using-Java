package org.commons.oca;

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

        _LOG.info("[ENDING void forLoopII()]");
    }
}