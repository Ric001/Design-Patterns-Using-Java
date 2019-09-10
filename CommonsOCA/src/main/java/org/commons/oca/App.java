package org.commons.oca;

import java.util.ArrayList;
import java.util.logging.Logger;

public class App 
{
    private final static Logger LOG = Logger.getLogger(App.class.getName());
    public static void main( String[] args )
    {
        LOG.info("[ENTERING void main(String[] args)]");

       final ArrayList<MyPerson> persons = new ArrayList<>();

       final MyPerson p1 = new MyPerson("Freya");
       final MyPerson p2 = new MyPerson("Paul");
       final MyPerson p3 = new MyPerson("Harry");
        
        persons.add(p1);
        persons.add(p2);
        persons.add(p3);
        persons.remove(new MyPerson("Paul"));

        for (MyPerson e : persons) 
            System.out.println(e.getName());

        final ArrayList<MyPerson> strings = new ArrayList<>();
        strings.addAll(persons);
        
        LOG.info("[ENDING void mani(String[] args)]");
    }

}
