package softuni.advanced.streamsfilesdirectories;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**Description:
 * We have to write a program that reads the contents of two text files and merges them together into a third one.
 */

public class MergeTwoFiles {

    private static final String INPUT_ONE = "src\\softuni\\advanced\\streamsfilesdirectories\\resources\\inputOne.txt";
    private static final String INPUT_TWO = "src\\softuni\\advanced\\streamsfilesdirectories\\resources\\inputTwo.txt";
    private static final String OUTPUT_PATH = "src\\softuni\\advanced\\streamsfilesdirectories\\resources\\output.txt";

    public static void main(String[] args) {

        try (BufferedReader inputOneReader = new BufferedReader(new FileReader(INPUT_ONE));
             BufferedReader inputTwoReader = new BufferedReader(new FileReader(INPUT_TWO));
             PrintWriter writer = new PrintWriter(OUTPUT_PATH)) {

            String line = inputOneReader.readLine();

            while (line != null) {
                writer.println(line);
                line = inputOneReader.readLine();
            }

            line = inputTwoReader.readLine();

            while (line != null) {
                writer.println(line);
                line = inputTwoReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
