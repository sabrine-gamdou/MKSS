package commands;


public abstract class Command {

    private Command oppositeCommand;

    public void configureUndo(Command command) {
        this.oppositeCommand = command;
    }

    public abstract void execute();

    public abstract String toString();

    public Command getOppositeCommand() {
        return oppositeCommand;
    }
}
