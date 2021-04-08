package softuni.OOP.oop_exam_prep.JavaOOPExam16Aug2020.onlineShop;

import softuni.OOP.oop_exam_prep.JavaOOPExam16Aug2020.onlineShop.core.EngineImpl;
import softuni.OOP.oop_exam_prep.JavaOOPExam16Aug2020.onlineShop.core.interfaces.Engine;

public class Main {
    public static void main(String[] args) {
        Engine engine = new EngineImpl();
        engine.run();
    }
}
