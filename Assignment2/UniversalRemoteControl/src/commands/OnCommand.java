package commands;

public class OnCommand extends Command{
    @Override
    public void execute() {
        System.out.println("ON command triggered.");
    }

    @Override
    public String toString(){
        return "ON";
    }
}
