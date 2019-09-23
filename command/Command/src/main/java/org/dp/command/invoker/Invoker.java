package org.dp.command.invoker;

import java.util.Optional;

import org.dp.command.infrastructure.ICommand;

public interface Invoker {
    boolean setCommand(Optional<? extends ICommand> command);

    boolean setCommand(ICommand command);
}