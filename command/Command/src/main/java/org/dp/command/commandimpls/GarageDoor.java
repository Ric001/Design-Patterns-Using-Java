package org.dp.command.commandimpls;

import java.util.Objects;

import org.dp.command.infrastructure.ICommand;
import org.dp.command.models.Light;

public class GarageDoor implements ICommand {

    private boolean up;
    private boolean stopped;
    private boolean lightOn;
    private Light light;

    public GarageDoor(Light light) {
        this.light = light;
    }

    public boolean isUp() {
       return up;
    }

    public void up() {
        up = true;
    }

    public void down() {
        up = false;
    }

    public boolean isStopped() {
        return stopped;
    }

    public boolean isLightOn() {
        return lightOn;
    }

    public boolean lightOn() {
       if (Objects.nonNull(light) && !light.isOn())
            light.toggle();
        return light.isOn();
    }

    public boolean lightOff() {
        if(Objects.isNull(light) && light.isOn())
            light.toggle();
        return light.isOn();
    }

    @Override
    public void execute() {
        if (lightOn())
            System.out.println("Light on");
        if(!isUp())
            up();
    }
    
    public void undo() {
        if (!lightOn())
            lightOff();
        if(isUp() && isStopped())
            down();
    }
}