package softuni.advanced.streamsfilesdirectories;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**Description:
 * We have to write a program that reads a text file and prints the sum of the ASCII symbols of all
 * characters inside of the file. For this purpose we have to use BufferedReader in combination with FileReader.
 */

public class SumBytes {

    private static final String PATH = "src\\softuni\\advanced\\streamsfilesdirectories\\resources\\input.txt";

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new FileReader(PATH))) {

            String line = reader.readLine();
            int sum = 0;

            while (line != null) {
                for (int i = 0; i < line.length(); i++) {
                    sum += line.charAt(i);
                }

                line = reader.readLine();
            }
            System.out.println(sum);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
