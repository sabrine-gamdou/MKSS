package commands;

import remotecontrol.RemoteControl;

public class PlayPauseCommand extends Command{
    PlayPauseCommand(RemoteControl remoteControl) {
        super(remoteControl);
    }

    @Override
    public void execute() {
        //TODO check status then print what button did?
        System.out.println("play/pause button pressed");
    }
}
