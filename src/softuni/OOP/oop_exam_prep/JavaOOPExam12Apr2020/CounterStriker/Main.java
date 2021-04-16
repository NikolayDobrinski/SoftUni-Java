package softuni.OOP.oop_exam_prep.JavaOOPExam12Apr2020.CounterStriker;

import softuni.OOP.oop_exam_prep.JavaOOPExam12Apr2020.CounterStriker.core.Engine;
import softuni.OOP.oop_exam_prep.JavaOOPExam12Apr2020.CounterStriker.core.EngineImpl;

public class Main {
    public static void main(String[] args) {
        Engine engine = new EngineImpl();
        engine.run();
    }
}
