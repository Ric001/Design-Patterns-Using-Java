package org.dp.command.commandimpls;

import java.util.Optional;
import java.util.logging.Logger;

import org.dp.command.infrastructure.ICommand;

public class MacroCommand implements ICommand {

    private Optional<ICommand[]> _macro;

    private final static Logger _LOG = Logger.getLogger(MacroCommand.class.getName());
    
    public MacroCommand(Optional<ICommand[]> macro) {
        _macro = macro;
    }

    @Override
    public void execute() {
        _LOG.info("[ENTERING void execute()]");
        
        if (_macro.isPresent())
            for (ICommand command : _macro.get())
                command.execute();
        
        _LOG.info("[ENDING void execute()]");
    }

    @Override
    public void undo() {
        _LOG.info("[ENTERING void undo()]");

        if (_macro.isPresent())
            for (ICommand command : _macro.get())
                command.undo();

        _LOG.info("[ENDING void undo()]");
    }
    
}