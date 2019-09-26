package org.dp.command.models;

public class GarageDoor {

    private boolean open;
    
    public boolean isOpen() {
        return open;
    }

    public void open() {
        if (!isOpen()) {
            open = true;
            System.out.println("Doors Opened");
        }
            
    }

    public void close() {
        if (isOpen()) {
            open = false;
            System.out.println("Doors closed");
        }
    }

}