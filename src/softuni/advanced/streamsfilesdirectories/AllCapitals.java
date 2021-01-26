package softuni.advanced.streamsfilesdirectories;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**Description:
 * We have to write a program that reads a text file and changes the casing of all letters to upperCase.
 * Then we write the output to another file.
 */

public class AllCapitals {

    private static final String INPUT_PATH = "src\\softuni\\advanced\\streamsfilesdirectories\\resources\\input.txt";
    private static final String OUTPUT_PATH = "src\\softuni\\advanced\\streamsfilesdirectories\\resources\\output.txt";

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_PATH));
             PrintWriter writer = new PrintWriter(OUTPUT_PATH)) {

            String line = reader.readLine();

            while (line != null) {
                writer.println(line.toUpperCase());

                line = reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
