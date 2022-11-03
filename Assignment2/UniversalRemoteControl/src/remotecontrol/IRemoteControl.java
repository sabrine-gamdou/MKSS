package remotecontrol;

import commands.Command;

/**
 * Interface for a generic remote control.
 */
public interface IRemoteControl {

    /**
     * Configures the given button number with the given opposite commands (For example: configure button 0 with
     * the positive command PLAY and the negative command PAUSE
     * @param buttonNo number of the button to be configured
     * @param positiveCommand the positive command of the given button
     * @param negativeCommand the negative command of the given button
     */
    void configureButtonAction(int buttonNo, Command positiveCommand, Command negativeCommand);
    /**
     * The action button was pressed.
     * Depending on its status, it will execute an activate or deactivate action.
     *
     * @param no The number of the button.
     */
    void actionButtonPressed(int no);

    /**
     * The undo button was pressed.
     * It will undo the previous action.
     */
    void undoButtonPressed();
}
