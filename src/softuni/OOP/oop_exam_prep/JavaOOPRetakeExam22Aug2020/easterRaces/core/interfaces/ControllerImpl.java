package softuni.OOP.oop_exam_prep.JavaOOPRetakeExam22Aug2020.easterRaces.core.interfaces;

import softuni.OOP.oop_exam_prep.JavaOOPRetakeExam22Aug2020.easterRaces.entities.cars.Car;
import softuni.OOP.oop_exam_prep.JavaOOPRetakeExam22Aug2020.easterRaces.entities.cars.MuscleCar;
import softuni.OOP.oop_exam_prep.JavaOOPRetakeExam22Aug2020.easterRaces.entities.cars.SportsCar;
import softuni.OOP.oop_exam_prep.JavaOOPRetakeExam22Aug2020.easterRaces.entities.drivers.Driver;
import softuni.OOP.oop_exam_prep.JavaOOPRetakeExam22Aug2020.easterRaces.entities.drivers.DriverImpl;
import softuni.OOP.oop_exam_prep.JavaOOPRetakeExam22Aug2020.easterRaces.entities.racers.Race;
import softuni.OOP.oop_exam_prep.JavaOOPRetakeExam22Aug2020.easterRaces.entities.racers.RaceImpl;
import softuni.OOP.oop_exam_prep.JavaOOPRetakeExam22Aug2020.easterRaces.repositories.interfaces.Repository;

import java.util.List;
import java.util.stream.Collectors;

import static softuni.OOP.oop_exam_prep.JavaOOPRetakeExam22Aug2020.easterRaces.common.ExceptionMessages.*;
import static softuni.OOP.oop_exam_prep.JavaOOPRetakeExam22Aug2020.easterRaces.common.OutputMessages.*;

public class ControllerImpl implements Controller {

    private Repository<Car> motorcycleRepository;
    private Repository<Race> raceRepository;
    private Repository<Driver> riderRepository;

    public ControllerImpl(Repository<Driver> riderRepository,Repository<Car> motorcycleRepository, Repository<Race> raceRepository) {
        this.riderRepository = riderRepository;
        this.motorcycleRepository = motorcycleRepository;
        this.raceRepository = raceRepository;
    }

    @Override
    public String createDriver(String driver) {
        Driver dr = this.riderRepository.getByName(driver);
        if (dr != null) {
            throw new IllegalArgumentException(String.format("Driver $s is already created.", driver));
        }
        dr = new DriverImpl(driver);
        this.riderRepository.add(dr);
        return String.format("Driver %s is created.", driver);
    }

    @Override
    public String createCar(String type, String model, int horsePower) {
        Car car = null;
        if (this.motorcycleRepository.getByName(model)!=null){
            throw new IllegalArgumentException(String.format(CAR_EXISTS, model));
        }
        switch (type){
            case "Muscle":
                car = new MuscleCar(model, horsePower);
                break;
            case "Sports":
                car = new  SportsCar(model,horsePower);
                break;
        }
        motorcycleRepository.add(car);
        return String.format(CAR_CREATED, car.getClass().getSimpleName(), model);
    }

    @Override
    public String addCarToDriver(String driverName, String carModel) {
        Driver driver = this.riderRepository.getByName(driverName);
        if (driver == null) {
            throw new IllegalArgumentException(String.format("Driver %s could not be found.", driverName));
        }

        Car car = this.motorcycleRepository.getByName(carModel);

        if (car == null) {
            throw new IllegalArgumentException(String.format("Car %s could not be found.", carModel));
        }

        driver.addCar(car);

        return String.format("Driver %s received car %s.", driverName, carModel);
    }

    @Override
    public String addDriverToRace(String raceName, String driverName) {
        Race race = this.raceRepository.getByName(raceName);

        if (race == null) {
            throw new IllegalArgumentException(String.format("Race %s could not be found.", raceName));
        }


        Driver driver = this.riderRepository.getByName(driverName);
        if (driver == null) {
            throw new IllegalArgumentException(String.format("Driver %s could not be found.", driverName));
        }

        race.addDriver(driver);

        return String.format("Driver %s added in %s race.", driverName, raceName);
    }

    @Override
    public String startRace(String raceName) {
        if (raceRepository.getByName(raceName)==null){
            throw new IllegalArgumentException(String.format(RACE_NOT_FOUND, raceName));
        }
        Race race = raceRepository.getByName(raceName);
        if (race.getDrivers().size()<3){
            throw new IllegalArgumentException(String.format(RACE_INVALID, raceName, 3));
        }
        List<Driver> winners = race.getDrivers().stream()
                .sorted((f,s)-> Double.compare(s.getCar().calculateRacePoints(race.getLaps()),
                        f.getCar().calculateRacePoints(race.getLaps()))).
                        limit(3).collect(Collectors.toList());
        raceRepository.remove(race);
        StringBuilder sb = new StringBuilder(String.format(DRIVER_FIRST_POSITION, winners.get(0).getName(), race.getName()));
        sb.append(System.lineSeparator());
        sb.append(String.format(DRIVER_SECOND_POSITION, winners.get(1).getName(), race.getName()));
        sb.append(System.lineSeparator());
        sb.append(String.format(DRIVER_THIRD_POSITION, winners.get(2).getName(), race.getName()));
        return sb.toString().trim();
    }


    @Override
    public String createRace(String name, int laps) {
        Race race = this.raceRepository.getByName(name);
        if (race != null) {
            throw new IllegalArgumentException(String.format("Race %s is already created.", name));
        }

        race = new RaceImpl(name, laps);
        this.raceRepository.add(race);

        return String.format("Race %s is created.", name);
    }
}
