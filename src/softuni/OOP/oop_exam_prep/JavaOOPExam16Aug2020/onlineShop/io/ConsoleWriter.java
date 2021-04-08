package softuni.OOP.oop_exam_prep.JavaOOPExam16Aug2020.onlineShop.io;


import softuni.OOP.oop_exam_prep.JavaOOPExam16Aug2020.onlineShop.io.interfaces.OutputWriter;

public class ConsoleWriter implements OutputWriter {
    @Override
    public void writeLine(String text) {
        System.out.println(text);
    }
}
