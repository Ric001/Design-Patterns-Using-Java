package org.dp.command;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.dp.command.commandimpls.GarageCloseDoorCommand;
import org.dp.command.commandimpls.GarageOpenDoorCommand;
import org.dp.command.commandimpls.LightOffCommand;
import org.dp.command.commandimpls.LightOnCommand;
import org.dp.command.commandimpls.MacroCommand;
import org.dp.command.infrastructure.ICommand;
import org.dp.command.invoker.RemoteControl;
import org.dp.command.models.GarageDoor;
import org.dp.command.models.Light;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class App {
    public static void main(final String[] args) {
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

        final ICommand[] offMacroCommandArray = { closeCommand, lightOffCommand };
        final ICommand[] onMacroCommandArray = { openCommand, lightOnCommand };

        final ICommand offMacroCommand = new MacroCommand(Optional.of(offMacroCommandArray));
        final ICommand onMacroCommand = new MacroCommand(Optional.of(onMacroCommandArray));

        remoteControl.setCommand(RemoteControl.TWO_SLOT, onMacroCommand, offMacroCommand);
        System.out.println(remoteControl);

        lights(remoteControl);

        // door(remoteControl);

        final DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            final DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            final Document document = documentBuilder.parse(new File("response.xml"));
            document.getDocumentElement();
            NodeList nodeList = document.getElementsByTagName("CD");
            for (int temp = 0; temp < nodeList.getLength(); temp++) {
                Node node = nodeList.item(temp);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    System.out.println(element.getElementsByTagName("TITLE").item(0).getTextContent());
                    System.out.println(element.getElementsByTagName("ARTIST").item(0).getTextContent());
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void lights(final RemoteControl remoteControl) {

        remoteControl.onButtonWasPushed(RemoteControl.ZERO_SLOT);
        remoteControl.undo();
        remoteControl.offButtonWasPushed(RemoteControl.ONE_SLOT);
        remoteControl.undo();

    }

    private static void door(final RemoteControl remoteControl) {

        remoteControl.onButtonWasPushed(RemoteControl.ONE_SLOT);
        remoteControl.undo();
        remoteControl.offButtonWasPushed(RemoteControl.ONE_SLOT);
        remoteControl.undo();

    }

    private static void runMacro(final RemoteControl remoteControl) {

        remoteControl.onButtonWasPushed(RemoteControl.TWO_SLOT);
        remoteControl.undo();

        remoteControl.offButtonWasPushed(RemoteControl.TWO_SLOT);
        remoteControl.undo();
    
    }
}
