package org.commons.singletton;

import java.util.Optional;
import java.util.logging.Logger;

public class ChocolateBoiler {
    
    private boolean empty;
    private boolean boiled;

    private final static Logger _LOG = Logger.getLogger(ChocolateBoiler.class.getName());
    private static Optional<ChocolateBoiler> chocolateBoiler;

    private volatile static Optional<ChocolateBoiler> vChocolateBoiler;

    private ChocolateBoiler() {
        this.empty = true;
        this.boiled = false;
    }

    public static synchronized ChocolateBoiler get() {
        _LOG.info("[ENTERING ChocolateBoiler get()]");

        if (!chocolateBoiler.isPresent())
            chocolateBoiler = Optional.of(new ChocolateBoiler());

        _LOG.info("[RETURNING ChocolateBoiler get()]" + chocolateBoiler.get());
        return chocolateBoiler.get();
    }

    public static synchronized ChocolateBoiler getVolatile() {
        _LOG.info("[ENTERING ChocolateBoiler getVolatile()]");
        
        if (!vChocolateBoiler.isPresent())
            synchronized(ChocolateBoiler.class) {
                if (!vChocolateBoiler.isPresent())
                    vChocolateBoiler = Optional.of(new ChocolateBoiler());
            }
        
        _LOG.info("[RETURNING ChocolateBoiler getVolatile()] " + vChocolateBoiler);
        return vChocolateBoiler.get();
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
        
        if (!isBoiled() && !isEmpty()) 
            boiled = true;
        
        _LOG.info("[ENDING void drain()]");
    }


    public boolean isEmpty() {
        return empty;
    }
    
    public boolean isBoiled() {
        return boiled;
    }

    @Override
    public String toString() {
        return "ChocolateBoiler [boiled=" + boiled + ", empty=" + empty + "]";
    }
    
   
}