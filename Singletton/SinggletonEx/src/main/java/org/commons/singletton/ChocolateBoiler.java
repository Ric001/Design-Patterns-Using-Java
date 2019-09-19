package org.commons.singletton;

import java.util.logging.Logger;

public class ChocolateBoiler {
    
    private boolean empty;
    private boolean boiled;

    private final static Logger _LOG = Logger.getLogger(ChocolateBoiler.class.getName());
    
    public ChocolateBoiler() {
        empty = true;
        boiled = false;
    }

    public void fill() {
        _LOG.info("[ENTERING void fill()]");
        if (isEmpty()) {
            empty = false;
            boiled = false;
        }
        _LOG.info("[ENDING void fill()]");
    }

    public void drain() {
        _LOG.info("[ENTERING void drain()]");
        if (!isBoiled() && !isEmpty()) {
            boiled = true;
        }
        _LOG.info("[ENDING void drain()]");
    }


    public boolean isEmpty() {
        return empty;
    }
    
    public boolean isBoiled() {
        return boiled;
    }
    
}