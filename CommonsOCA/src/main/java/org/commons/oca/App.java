package org.commons.oca;

public class App 
{
    public static void main( String[] args )
    {
        final Loops loop = new Loops();
        loop.printingLoop();
        
        final String line = "ab";
        for (int i = 0; i < line.length(); ++i, print()) 
            System.out.println(line.charAt(i));
    }

    public static void print() {
        System.out.println("Happy");
    } 
}
