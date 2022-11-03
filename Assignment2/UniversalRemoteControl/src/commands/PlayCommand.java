package commands;

public class PlayCommand  extends Command{
    @Override
    public void execute() {
        System.out.println("PLAY command triggered.");
    }

    @Override
    public String toString(){
        return "PLAY";
    }
}