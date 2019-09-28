package org.dp.command;

import java.util.Optional;

import org.dp.command.commandimpls.GarageCloseDoorCommand;
import org.dp.command.commandimpls.GarageOpenDoorCommand;
import org.dp.command.commandimpls.LightOffCommand;
import org.dp.command.commandimpls.LightOnCommand;
import org.dp.command.commandimpls.MacroCommand;
import org.dp.command.infrastructure.ICommand;
import org.dp.command.invoker.RemoteControl;
import org.dp.command.models.GarageDoor;
import org.dp.command.models.Light;

public class App 
{
    public static void main( String[] args )
    {
        final RemoteControl remoteControl = new RemoteControl();
        final Light livingRoom = new Light();
        final Light kitchenRoom = new Light();
        
        final LightOnCommand lightOnCommand = new LightOnCommand(livingRoom);
        final LightOffCommand lightOffCommand = new LightOffCommand(kitchenRoom);

        final GarageDoor door = new GarageDoor();
        final GarageOpenDoorCommand openCommand = new GarageOpenDoorCommand(door);
        final GarageCloseDoorCommand closeCommand = new GarageCloseDoorCommand(door); 

        remoteControl.setCommand(RemoteControl.ZERO_SLOT, lightOnCommand, lightOffCommand);
        remoteControl.setCommand(RemoteControl.ONE_SLOT, openCommand, closeCommand);

        ICommand[] offMacro = { closeCommand, lightOffCommand };
        ICommand[] onMacro = { openCommand, lightOnCommand };

        ICommand offMacroCommand = new MacroCommand(Optional.of(offMacro));
        ICommand onMacroCommand = new MacroCommand(Optional.of(onMacro));
        
        remoteControl.setCommand(RemoteControl.TWO_SLOT, onMacroCommand, offMacroCommand);
        System.out.println(remoteControl);

        lights(remoteControl);

        //door(remoteControl);
    }

    private static void lights(RemoteControl remoteControl) {
        
        remoteControl.onButtonWasPushed(RemoteControl.ZERO_SLOT);
        remoteControl.undo();
        remoteControl.offButtonWasPushed(RemoteControl.ONE_SLOT);
        remoteControl.undo();
        
    }

    private static void door(RemoteControl remoteControl) {

        remoteControl.onButtonWasPushed(RemoteControl.ONE_SLOT);
        remoteControl.undo();
        remoteControl.offButtonWasPushed(RemoteControl.ONE_SLOT);
        remoteControl.undo();

    }

    private static void runMacro(RemoteControl remoteControl) {
        
    }
}
