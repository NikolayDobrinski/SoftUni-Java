package softuni.OOP.oop_exam_prep.JavaOOPExam10April2021.aquarium;

import softuni.OOP.oop_exam_prep.JavaOOPExam10April2021.aquarium.core.Engine;
import softuni.OOP.oop_exam_prep.JavaOOPExam10April2021.aquarium.core.EngineImpl;


public class Main {
    public static void main(String[] args) {
        Engine engine = new EngineImpl();
        engine.run();
    }
}
