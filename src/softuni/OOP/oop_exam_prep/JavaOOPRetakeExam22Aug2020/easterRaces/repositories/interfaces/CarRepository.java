package softuni.OOP.oop_exam_prep.JavaOOPRetakeExam22Aug2020.easterRaces.repositories.interfaces;

import softuni.OOP.oop_exam_prep.JavaOOPRetakeExam22Aug2020.easterRaces.entities.cars.Car;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CarRepository implements Repository<Car>{

    Collection<Car> models;

    public CarRepository() {
        this.models = new ArrayList<>();
    }

    @Override
    public Car getByName(String name) {
        return models.stream().filter(p -> p.getModel().equals(name)).findFirst().orElse(null);
    }

    @Override
    public Collection<Car> getAll() {
        return Collections.unmodifiableCollection(this.models);
    }

    @Override
    public void add(Car model) {
            this.models.add(model);
    }

    @Override
    public boolean remove(Car model) {
        Car car = models.stream().filter(c -> c.getModel().equals(model.getModel())).findFirst().orElse(null);
        if (car != null) {
            this.models.remove(car);
            return true;
        }
        return false;
    }

}
