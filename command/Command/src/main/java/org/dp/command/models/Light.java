package org.dp.command.models;

public class Light {
    private boolean on;

    private void on() {
        on = true;
        System.out.println("Light's on");
    }

    private void off() {
        on = false;
        System.out.println("Light's off");
    }

    public boolean isOn() {
        if (on)
            return true;
        return false;
    }

    public void toggle() {
        if (isOn())
            off();
        else 
            on();
    }

    @Override
    public String toString() {
        return "Light [on=" + on + "]";
    }

    

    
}