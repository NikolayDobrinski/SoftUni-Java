package softuni.OOP.interfaces_abstraction.SayHello;

public class European implements Person {

    private String name;

    public European(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
