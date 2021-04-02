package softuni.OOP.design_patterns.command_pattern;

public class HeatingOnCommand implements ICommand{

    @Override
    public void execute() {
        System.out.println("Here is so cold... Heating ON");
    }
}
