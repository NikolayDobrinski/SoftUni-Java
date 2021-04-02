package softuni.OOP.design_patterns.command_pattern;

public class HeatingOffCommand implements ICommand{

    @Override
    public void execute() {
        System.out.println("Here is so hot.. heating OFF");
    }
}
