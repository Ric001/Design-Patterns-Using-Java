package org.dp.command.commandimpls;

import java.util.Objects;


import org.dp.command.infrastructure.ICommand;
import org.dp.command.models.GarageDoor;

public class GarageOpenDoorCommand implements ICommand {

    private GarageDoor optional;

    public GarageOpenDoorCommand(GarageDoor door) {
        if (Objects.nonNull(door))
            optional = door;
    }
    
    @Override
    public void execute() {
        optional.open();
    }

    @Override
    public void undo() {
        optional.close();

    }

}