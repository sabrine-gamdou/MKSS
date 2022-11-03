package commands;

public class PreviousCommand extends Command{

    @Override
    public void execute() {
        System.out.println("PREVIOUS command triggered.");
    }

    @Override
    public String toString(){
        return "PREVIOUS";
    }
}