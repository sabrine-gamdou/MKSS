package commands;

public class OffCommand  extends Command {

    @Override
    public void execute() {
        System.out.println("OFF command triggered.");
    }

    @Override
    public String toString(){
        return "OFF";
    }
}