package org.dp.command.invoker;

import java.util.Objects;
import java.util.Optional;
import java.util.logging.Logger;

import org.dp.command.infrastructure.ICommand;

public class RemoteControl implements Invoker {

    private Optional<? extends ICommand> slot;
    private ICommand command;
    private final static Logger _LOG = Logger.getLogger(RemoteControl.class.getName());
    
    private ICommand[] onCommands;
    private ICommand[] offCommands;
    private ICommand lastCommand;
    
    
    public static final int ZERO_SLOT = 0;
    public static final int ONE_SLOT = 1;
    public static final int TWO_SLOT = 2;

    public RemoteControl() {
        slot = Optional.empty();
        onCommands = new ICommand[7];
        offCommands = new ICommand[7];
        ICommand none = noneCommand();
        lastCommand = none;
        initSlotSet(none);
    }

    private void initSlotSet(ICommand noneCommand) {
        _LOG.info("[ENTERING void initSlotSet()]");

        if (Objects.nonNull(noneCommand))
            for (int i = 0; i < onCommands.length; i++) {
                onCommands[i] = noneCommand;
                offCommands[i] = noneCommand;
            }

        _LOG.info("[ENDING void initSlotSet()]");
    }

    private ICommand noneCommand() {
        _LOG.info("[ ENTERING void noneCommand() ]");

        return new ICommand(){
            @Override
            public void execute() {
                System.out.println("[ NONE ]");   
            }

            @Override
            public void undo() {
               System.out.println("[ NONE ]");

            }
        };

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

    public void setCommand(final int slot, final ICommand onCommmand, ICommand offCommand) {
        _LOG.info("[ENTERING void setCommand(final int slot, final ICommand onCommand, ICommand offCommand)]");
        
        onCommands[slot] = onCommmand;
        offCommands[slot] = offCommand;
        
        _LOG.info("[ENDING void setCommand(final int slot, final ICommand onCommand, ICommand offCommand)]");
    }


    public void onButtonWasPushed(final int slot) {
        _LOG.info("[ENTERING void onButtonWasPushed(final int slot)]");

        onCommands[slot].execute();
        lastCommand = onCommands[slot];

        _LOG.info("[ENDING void onButtonWasPushed(final int slot)]");
    }

    public void offButtonWasPushed(final int slot) {
        _LOG.info("[ENTERING void offButtonWasPushed(final int slot)]");

        offCommands[slot].execute();
        lastCommand = offCommands[slot];
        
        _LOG.info("[ENDING void offButtonWasPushed(final int slot)]");
    }

    public void undo() {
        _LOG.info("[ENTERING void undo()]");

        lastCommand.undo();

        _LOG.info("[ENDING void undo()]");
    }
    @Override
    public String toString() {
        final StringBuffer buffer = new StringBuffer();
        buffer.append("\n-------- Remote Control ----------\n");
    
        for (int i = 0; i < onCommands.length; i++) 
            buffer.append("[slot " + i + " ] " + onCommands[i].getClass().getName() + "   " + offCommands[i].getClass().getName() + "\n");
        
        return buffer.toString();
    }
}