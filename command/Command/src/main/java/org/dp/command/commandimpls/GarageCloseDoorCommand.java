package org.dp.command.commandimpls;

import java.util.logging.Logger;

import org.dp.command.infrastructure.ICommand;
import org.dp.command.models.GarageDoor;

public class GarageCloseDoorCommand implements ICommand {
    
    private final static Logger _LOG = Logger.getLogger(GarageCloseDoorCommand.class.getName());
    
    private GarageDoor door;

    public GarageCloseDoorCommand(GarageDoor door) {
        this.door = door;
    }
    
	@Override
	public void execute() {
        _LOG.info("[ENTERING void execute()]");
            door.close();
        _LOG.info("[ENDING void execute()]");
	}

    @Override
    public void undo() {
        _LOG.info("[ENTERING void undo()]");
            door.open();
        _LOG.info("[ENDING void undo()]");

    }
}