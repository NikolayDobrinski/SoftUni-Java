package softuni.advanced.streamsfilesdirectories;

import java.io.*;

/**Description:
 * Read the file named "input.txt" and write to another file all lines which number is divisible by 3.
 */

public class WriteEveryThirdLine {
    public static void main(String[] args) {

        String inputPath = "input.txt";
        String outputPath = "output.txt";

        try (BufferedReader in = new BufferedReader(new FileReader(inputPath));
             PrintWriter out = new PrintWriter(new FileWriter(outputPath))) {

            int counter = 1;
            String line = in.readLine();

            while (line != null) {
                if (counter % 3 == 0) {
                    out.println(line);
                }
                counter++;
                line = in.readLine();
            }
        }
        catch (IOException e) {
            e.getMessage();
        }
    }
}
