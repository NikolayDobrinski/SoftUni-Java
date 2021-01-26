package softuni.advanced.streamsfilesdirectories;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**Description:
 * We have to write a program that reads a text file and inserts line numbers in front of each of its lines.
 * The result should be written to another text file.
 */

public class LineNumbers {

    private static final String INPUT_PATH = "src\\softuni\\advanced\\streamsfilesdirectories\\resources\\inputLineNumbers.txt";
    private static final String OUTPUT_PATH = "src\\softuni\\advanced\\streamsfilesdirectories\\resources\\output.txt";

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_PATH));
             PrintWriter writer = new PrintWriter(OUTPUT_PATH)) {

            int rowCounter = 1;

            String line = reader.readLine();

            while (line != null) {
                writer.println(String.format("%d. %s", rowCounter, line));
                rowCounter++;

                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
