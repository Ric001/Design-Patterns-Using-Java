package org.dp.command.invoker;

import java.util.Objects;
import java.util.Optional;
import java.util.logging.Logger;

import org.dp.command.infrastructure.ICommand;

public class RemoteControl implements Invoker {

    private Optional<? extends ICommand> slot;
    private ICommand command;
    private final static Logger _LOG = Logger.getLogger(RemoteControl.class.getName());

    public RemoteControl() {
        slot = Optional.empty();
    }
    
    @Override
    public boolean setCommand(Optional<? extends ICommand> command) {
        _LOG.info("[ENTERING boolean setCommand(Optional<ICommand> command)]");
        
        if (slot.isPresent()) {
            System.out.println("Not Empty Slot was found");
            return false;
        }
        slot = command;

        _LOG.info("[RETURNING FROM boolean setCommand(Optional<ICommand> command)] true" );
        return true;
    }

    public void pressButton() {
        _LOG.info("[ENTERING void pressingButton()]");
        if (Objects.nonNull(command))
            command.execute();
        _LOG.info("[ENDING void pressButton()]");
    }

    @Override
    public boolean setCommand(ICommand command) {
        _LOG.info("[ENTERING boolean setCommand(ICommand command)]");

        if (Objects.isNull(command) || Objects.nonNull(this.command))
            return false;
        this.command = command;
        
        _LOG.info("[ENDING boolean setCommand(ICommand command)] False");
        return false;
    }
}