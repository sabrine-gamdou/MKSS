package commands;

public class NextCommand extends Command {
    @Override
    public void execute() {
        System.out.println("NEXT command triggered.");
    }

    @Override
    public String toString(){
        return "NEXT";
    }
}
