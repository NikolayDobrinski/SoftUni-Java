package softuni.OOP.oop_exam_prep.JavaOOPRetakeExam22Aug2020.easterRaces.io;

import softuni.OOP.oop_exam_prep.JavaOOPRetakeExam22Aug2020.easterRaces.io.interfaces.InputReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader  implements InputReader {
    private BufferedReader reader;

    public ConsoleReader() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public String readLine() throws IOException {
        return this.reader.readLine();
    }
}
