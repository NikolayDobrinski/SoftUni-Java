package softuni.OOP.oop_exam_prep.JavaOOPExam12Dec2020.bakery.io;


import softuni.OOP.oop_exam_prep.JavaOOPExam12Dec2020.bakery.io.interfaces.OutputWriter;

public class ConsoleWriter implements OutputWriter {
    public void writeLine(String text) {
        System.out.println(text);
    }
}
