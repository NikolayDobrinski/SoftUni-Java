package softuni.OOP.solid.DependencyInversion.p02_Worker;

public class Manager {

    public Manager() {
        Worker worker = new Worker();
        worker.work();
    }
}
