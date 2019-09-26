package org.dp.command;

import org.dp.command.commandimpls.GarageDoorCommand;
import org.dp.command.infrastructure.ICommand;
import org.dp.command.invoker.RemoteControl;
import org.dp.command.models.GarageDoor;

public class App 
{
    public static void main( String[] args )
    {
        final RemoteControl remoteControl = new RemoteControl();
        final GarageDoor door = new GarageDoor();
        final ICommand gaCommand = new GarageDoorCommand(door);
        remoteControl.setCommand(gaCommand);
        remoteControl.pressButton();
        
    }
}
