package commands;

import remotecontrol.RemoteControl;

public class NextPreviousCommand extends Command{

    NextPreviousCommand(RemoteControl remoteControl) {
        super(remoteControl);
    }

    @Override
    public void execute() {
        //TODO check status then print what button did?
        System.out.println("next/previous button pressed");
    }
}
