package softuni.OOP.oop_exam_prep.JavaOOPRetakeExam22Aug2020.easterRaces.entities.racers;

import softuni.OOP.oop_exam_prep.JavaOOPRetakeExam22Aug2020.easterRaces.entities.drivers.Driver;


import java.util.Collection;

public interface Race {
    String getName();

    int getLaps();

    Collection<Driver> getDrivers();

    void addDriver(Driver driver);
}
