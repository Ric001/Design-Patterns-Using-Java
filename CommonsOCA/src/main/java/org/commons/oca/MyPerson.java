package org.commons.oca;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class MyPerson {

    private String name;
    private final static Logger _LOG = Logger.getLogger(MyPerson.class.getName());

    public MyPerson(String name) {
        this.name = name;
    }
    
    @Override
    public boolean equals(Object o) {
        _LOG.info("[ENTERING boolean equals(Object o)]");

        if (o instanceof MyPerson) {
            MyPerson person = (MyPerson) o;
            return person.getName().equals(name);
        }

        _LOG.info("[RETURNING boolean equals(Object o)] : false");
        return false;
    }

    public String getName() {
        return name;
    }
    
    public void managingReferences() {
        _LOG.info("[ENTERING void managingReferences()]");
        
        final List<String> myArrList = new ArrayList<>();

        myArrList.add("One");
        myArrList.add("Two");
        myArrList.set(myArrList.indexOf("One"), myArrList.get(0).replace("O", "B"));
        
        final List<String> yourArrList = myArrList;

        for (String val : myArrList)
            System.out.println(val);

        for (String val : yourArrList)
            System.out.println(val);
        
        _LOG.info("[ENDING void managingReferences()]");
    }

    public void clearing() {
        _LOG.info("[ENTERING  clearing(): void]");
        
        final ArrayList<String> myArrlist = new ArrayList<>();
        myArrlist.add("One");
        myArrlist.add("Two");
        myArrlist.clear();

        for(String val : myArrlist)
            System.out.println(val);

        _LOG.info("[ENDING clearing(): void]");
    }

    public void gettingAndSize() {
        _LOG.info("[ENTERING void gettingAndSize()]");
        
        final List<String> myArrList = new ArrayList<>();
        myArrList.add("One");
        myArrList.add("Two");

        final String valFormList = myArrList.get(1);
        System.out.println(valFormList);
        System.out.println(myArrList.size());

        _LOG.info("[ENDING void gettingAndSize()]");
    }
    
    public void afterWinter() {
        _LOG.info("[ ENTERING void afterWinter() ]");

        final ArrayList<StringBuilder> mArrayList = new ArrayList<>();
        final StringBuilder sb = new StringBuilder("Jan");
        final StringBuilder sb2 = new StringBuilder("Feb");
        final StringBuilder sb3 = new StringBuilder("Ma");
        
        mArrayList.add(sb);
        mArrayList.add(sb2);
        mArrayList.add(sb3);

        System.out.println(mArrayList.contains(new StringBuilder("Jan")));
        System.out.println(mArrayList.contains(sb));
        System.out.println(mArrayList.indexOf(new StringBuilder("Feb")));
        System.out.println(mArrayList.indexOf(sb2));
        System.out.println(mArrayList.lastIndexOf(new StringBuilder("Feb")));
        System.out.println(mArrayList.lastIndexOf(sb2));

        _LOG.info("[ ENDING void afterWinter() ]");
    }

}

class Product {
    private String name;
    
    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object ob) {
        if (ob instanceof Product) {
            final Product p = (Product) ob;
            final boolean isEqual = name.equals(p.getName());
            return isEqual;
        }
        return false;
    }
}