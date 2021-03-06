package softuni.OOP.oop_exam_prep.JavaOOPRetakeExam22Aug2020.easterRaces.repositories.interfaces;

import softuni.OOP.oop_exam_prep.JavaOOPRetakeExam22Aug2020.easterRaces.entities.drivers.Driver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class DriverRepository implements Repository<Driver> {

    Collection<Driver> models;

    public DriverRepository() {
        this.models = new ArrayList<>();
    }

    @Override
    public Driver getByName(String name) {
        return models.stream().filter(d-> d.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public Collection<Driver> getAll() {
        return Collections.unmodifiableCollection(models);
    }

    @Override
    public void add(Driver model) {
        models.add(model);
    }

    @Override
    public boolean remove(Driver model) {
        Driver  driver = models.stream().filter(d-> d.getName().equals(model.getName())).findFirst().orElse(null);
        if (driver!=null){
            models.remove(driver);
            return true;
        }
        return false;
    }
}

