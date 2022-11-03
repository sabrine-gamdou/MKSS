import commands.*;
import remotecontrol.RemoteControl;

/**
 * Main for testing the functionality
 */
public class Main {
    public static void main(String[] args) {
        RemoteControl mediaPlayerRemote = new RemoteControl();

        mediaPlayerRemote.configureButtonAction(0, new OnCommand(), new OffCommand());
        mediaPlayerRemote.configureButtonAction(1, new NextCommand(), new PreviousCommand());
        mediaPlayerRemote.configureButtonAction(2, new PlayCommand(), new PauseCommand());

        System.out.println("\nPressing buttons: ");
        mediaPlayerRemote.actionButtonPressed(0);
        mediaPlayerRemote.actionButtonPressed(1);
        mediaPlayerRemote.actionButtonPressed(2);

        mediaPlayerRemote.undoButtonPressed();

        mediaPlayerRemote.actionButtonPressed(1);
        mediaPlayerRemote.undoButtonPressed();

        mediaPlayerRemote.actionButtonPressed(0);
        mediaPlayerRemote.undoButtonPressed();
        mediaPlayerRemote.undoButtonPressed();

		mediaPlayerRemote.actionButtonPressed(2);
		mediaPlayerRemote.actionButtonPressed(2);
		mediaPlayerRemote.actionButtonPressed(1);

		mediaPlayerRemote.undoButtonPressed();
		mediaPlayerRemote.undoButtonPressed();
		mediaPlayerRemote.undoButtonPressed();
		mediaPlayerRemote.undoButtonPressed();
    }
}

