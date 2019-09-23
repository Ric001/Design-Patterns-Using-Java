package org.dp.command;

import java.util.Optional;

import org.dp.command.commandimpls.LightOnCommand;
import org.dp.command.infrastructure.ICommand;
import org.dp.command.invoker.Invoker;
import org.dp.command.invoker.RemoteControl;
import org.dp.command.models.Light;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Invoker remote = new RemoteControl();
        Light light = new Light();
        Optional<? extends ICommand> lightOnCommand = Optional.of(new LightOnCommand(light));
        ICommand lightOn = new LightOnCommand(light);
        remote.setCommand(lightOnCommand);
        RemoteControl control = (RemoteControl) remote;
        control.pressButton();
    }
}
