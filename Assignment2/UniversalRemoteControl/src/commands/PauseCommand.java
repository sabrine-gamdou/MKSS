package commands;

public class PauseCommand extends Command{
    @Override
    public void execute() {
        System.out.println("PAUSE command triggered.");
    }

    @Override
    public String toString(){
        return "PAUSE";
    }
}
