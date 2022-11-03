package remotecontrol;

import commands.Command;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Base implementation for the remote control.
 */
public class RemoteControl implements IRemoteControl {

    public final static int NO_OF_ACTION_BUTTONS = 3;
    private final boolean[] buttonStatus;
    private final Map<Integer, Map.Entry<Command, Command>> configuredActions;
    private final Stack<Command> commandHistory;

    public RemoteControl() {
        buttonStatus = new boolean[NO_OF_ACTION_BUTTONS];
        configuredActions = new HashMap<>();
        commandHistory = new Stack<>();
    }

    public void configureButtonAction(int buttonNumber, Command positiveCommand, Command negativeCommand) {
        System.out.printf("\nButton %s configuration: %n", buttonNumber);
        System.out.printf(">>Positive command: %s%n", positiveCommand);
        System.out.printf(">>Negative command: %s%n", negativeCommand);

        configuredActions.put(buttonNumber, new Map.Entry<>() {
            @Override
            public Command getKey() {
                return positiveCommand;
            }

            @Override
            public Command getValue() {
                return negativeCommand;
            }

            @Override
            public Command setValue(Command value) {
                return value;
            }
        });
    }

    /**
     * The action button was pressed.
     * Depending on its status, it will execute an activate or deactivate action.
     *
     * @param no The number of the button.
     */
    public void actionButtonPressed(int no) {
        Command positiveCommand = configuredActions.get(no).getKey();
        Command negativeCommand = configuredActions.get(no).getValue();
        // Execute action
        if (!buttonStatus[no]) {
            System.out.println("\nButton activated: " + no);
            positiveCommand.execute();
            commandHistory.push(positiveCommand);
            positiveCommand.configureUndo(negativeCommand);
        } else {
            System.out.println("\nButton deactivated: " + no);
            negativeCommand.execute();
            commandHistory.push(negativeCommand);
            negativeCommand.configureUndo(positiveCommand);
        }
        // Invert button status
        buttonStatus[no] = !buttonStatus[no];
    }

    /**
     * The undo button was pressed.
     * It will undo the previous action.
     */
    public void undoButtonPressed() {
        if(commandHistory.isEmpty()){
            System.out.println("Empty history, no command to undo.");
            return;
        }

        System.out.println("\n<<<<<<<< Undo button pressed\n");
        Command oppositeCommand = commandHistory.pop().getOppositeCommand();

        if(oppositeCommand != null){
            commandHistory.push(oppositeCommand);
            oppositeCommand.execute();
        }
    }
}
