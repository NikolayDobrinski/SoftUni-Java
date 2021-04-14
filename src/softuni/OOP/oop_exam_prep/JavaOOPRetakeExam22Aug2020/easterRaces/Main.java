package softuni.OOP.oop_exam_prep.JavaOOPRetakeExam22Aug2020.easterRaces;

import softuni.OOP.oop_exam_prep.JavaOOPRetakeExam22Aug2020.easterRaces.core.EngineImpl;
import softuni.OOP.oop_exam_prep.JavaOOPRetakeExam22Aug2020.easterRaces.core.interfaces.Controller;
import softuni.OOP.oop_exam_prep.JavaOOPRetakeExam22Aug2020.easterRaces.core.interfaces.ControllerImpl;
import softuni.OOP.oop_exam_prep.JavaOOPRetakeExam22Aug2020.easterRaces.entities.cars.Car;
import softuni.OOP.oop_exam_prep.JavaOOPRetakeExam22Aug2020.easterRaces.entities.drivers.Driver;
import softuni.OOP.oop_exam_prep.JavaOOPRetakeExam22Aug2020.easterRaces.entities.racers.Race;
import softuni.OOP.oop_exam_prep.JavaOOPRetakeExam22Aug2020.easterRaces.io.ConsoleReader;
import softuni.OOP.oop_exam_prep.JavaOOPRetakeExam22Aug2020.easterRaces.io.ConsoleWriter;
import softuni.OOP.oop_exam_prep.JavaOOPRetakeExam22Aug2020.easterRaces.repositories.interfaces.CarRepository;
import softuni.OOP.oop_exam_prep.JavaOOPRetakeExam22Aug2020.easterRaces.repositories.interfaces.DriverRepository;
import softuni.OOP.oop_exam_prep.JavaOOPRetakeExam22Aug2020.easterRaces.repositories.interfaces.RaceRepository;
import softuni.OOP.oop_exam_prep.JavaOOPRetakeExam22Aug2020.easterRaces.repositories.interfaces.Repository;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Repository<Car> motorcycleRepository = new CarRepository();
        Repository<Race> raceRepository = new RaceRepository();
        Repository<Driver> riderRepository = new DriverRepository();

        Controller controller = new ControllerImpl(riderRepository, motorcycleRepository, raceRepository);

        ConsoleReader reader = new ConsoleReader();
        ConsoleWriter writer = new ConsoleWriter();
        EngineImpl engine = new EngineImpl(reader, writer, controller);
        engine.run();
    }
}
