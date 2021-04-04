package softuni.OOP.oop_exam_prep.JavaOOPRetakeExam19Dec2020.viceCity;

import softuni.OOP.oop_exam_prep.JavaOOPRetakeExam19Dec2020.viceCity.core.EngineImpl;
import softuni.OOP.oop_exam_prep.JavaOOPRetakeExam19Dec2020.viceCity.core.interfaces.Controller;
import softuni.OOP.oop_exam_prep.JavaOOPRetakeExam19Dec2020.viceCity.core.interfaces.ControllerImpl;
import softuni.OOP.oop_exam_prep.JavaOOPRetakeExam19Dec2020.viceCity.core.interfaces.Engine;

public class Main {
    public static void main(String[] args) {
        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}
