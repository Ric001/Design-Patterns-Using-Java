package org.commons.oca;

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
    
}