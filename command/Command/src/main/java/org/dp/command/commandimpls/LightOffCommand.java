package org.dp.command.commandimpls;

import java.util.logging.Logger;

import org.dp.command.infrastructure.ICommand;
import org.dp.command.models.Light;

public class LightOffCommand implements ICommand {
    private final static Logger _LOG = Logger.getLogger(LightOffCommand.class.getName());

    private Light _light;

	public LightOffCommand(Light light) {
        _light = light;
    }

    @Override
    public void execute() {
        _LOG.info("[ENTERING void execute()]");

        if (_light.isOn())
            _light.toggle();

        _LOG.info("[ENDING void execute()] -> " + _light);
    }

    @Override
    public void undo() {
      _LOG.info("[ENTERING void undo()]");
      
        if (!_light.isOn())
            _light.toggle();
      
     _LOG.info("[ENDING void undo()]");
    }

}