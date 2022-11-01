package commands;

import remotecontrol.RemoteControl;

public class OnOffCommand extends Command{
    OnOffCommand(RemoteControl remoteControl) {
        super(remoteControl);
    }

    @Override
    public void execute() {
        //TODO check status then print what button did?
        System.out.println("on/off button pressed");
    }
}
