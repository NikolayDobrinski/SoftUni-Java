package softuni.OOP.oop_exam_prep.JavaOOPRetakeExam22Aug2020.easterRaces.entities.racers;

import softuni.OOP.oop_exam_prep.JavaOOPRetakeExam22Aug2020.easterRaces.entities.drivers.Driver;

import java.util.ArrayList;
import java.util.Collection;

public class RaceImpl implements Race{

    private String name;
    private int laps;
    private Collection<Driver> drivers;

    public RaceImpl(String name, int laps) {
        this.setName(name);
        this.setLaps(laps);
        this.drivers = new ArrayList<>();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty() || name.length() < 5) {
            throw new IllegalArgumentException(String.format("Name %s cannot be less than 5 symbols.", name));
        }
        this.name = name;
    }

    public void setLaps(int laps) {
        if (laps < 1) {
            throw new IllegalArgumentException(String.format("Laps cannot be less than 1."));
        }
        this.laps = laps;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getLaps() {
        return this.laps;
    }

    @Override
    public Collection<Driver> getDrivers() {
        return this.drivers;
    }

    @Override
    public void addDriver(Driver driver) {
        if (driver == null) {
            throw new IllegalArgumentException(String.format("Driver cannot be null."));
        }

        if (driver.getCanParticipate() == false) {
            throw new IllegalArgumentException(String.format("Driver %s could not participate in race.", driver));
        }

        Driver dr = this.drivers.stream().filter(d -> d.getName().equals(driver.getName())).findFirst().orElse(null);

        if (dr != null) {
            throw new IllegalArgumentException(String.format("Driver %s is already added in %s race.", driver.getName(), this.getName()));
        }

        this.drivers.add(driver);
    }
}
