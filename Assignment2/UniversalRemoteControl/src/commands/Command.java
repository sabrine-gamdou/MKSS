package commands;

import remotecontrol.RemoteControl;

public abstract class Command {
    public RemoteControl remoteControl;

    Command(RemoteControl remoteControl){
        this.remoteControl = remoteControl;
    }

    public void undo(){
        System.out.println("Undo action");
    }

    public abstract void execute();
}
