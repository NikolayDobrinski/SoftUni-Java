package softuni.OOP.oop_exam_prep.JavaOOPRetakeExam22Aug2020.easterRaces.io;

import softuni.OOP.oop_exam_prep.JavaOOPRetakeExam22Aug2020.easterRaces.io.interfaces.OutputWriter;

public class ConsoleWriter implements OutputWriter {
    @Override
    public void writeLine(String text) {
        System.out.println(text);
    }
}
