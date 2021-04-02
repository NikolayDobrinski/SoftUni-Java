package softuni.OOP.design_patterns.observer_pattern;

public interface ISubject {

    void registerObserver(IObserver observer);
    void removeObserver(IObserver observer);
    void notifyObservers();
    void changeState(String state);
}
