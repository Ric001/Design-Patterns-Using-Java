package org.dp.command.commandimpls;

import java.util.logging.Logger;

import org.dp.command.infrastructure.ICommand;
import org.dp.command.models.Light;

public class LightOnCommand implements ICommand {
    
    private Light light;
    private final static Logger _LOG = Logger.getLogger(LightOnCommand.class.getName());
    
    public LightOnCommand(Light _Light) {
        light = _Light;
    }

    @Override
    public void execute() {
        _LOG.info("[ENTERING void execute()]");
        
        light.toggle();
    
        _LOG.info("[ENDING void execute()]");
    }


}