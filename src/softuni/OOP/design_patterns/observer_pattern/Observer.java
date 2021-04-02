package softuni.OOP.design_patterns.observer_pattern;

public class Observer implements IObserver {

    @Override
    public void update() {
        System.out.println("Hurray, I'm updated!");
    }
}
