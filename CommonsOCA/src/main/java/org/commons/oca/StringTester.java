package org.commons.oca;

import java.util.logging.Logger;

public class StringTester {

    private final static Logger _LOG = Logger.getLogger(StringTester.class.getName());
    
    public void insertTest() {
        _LOG.info("[ ENTERING void insertTest() ]");
        
        final StringBuilder sb = new StringBuilder("Bon");
        sb.insert(2, 'r');
        System.out.println(sb);

        final StringBuilder sb1 = new StringBuilder("123");
        final char[] name = { 'J', 'A', 'V', 'A' };
        sb1.insert(1, name, 1, 3);

        _LOG.info("[ ENDING void insertTest() ]");
    }

    public void delete() {
        _LOG.info("[ENTERING void delete()]");
        final StringBuilder sb1 = new StringBuilder("0123456");
        //Removes elements on positions between 2 and four exluding the element
        //on the 4th position

        sb1.delete(2, 4);
        
        //Delete only one character as follows
        sb1.deleteCharAt(2);

        System.out.println(sb1);
        _LOG.info("[ENDING void delete()]");
    }   

    public void deleteCharAt() {
        
    }
}