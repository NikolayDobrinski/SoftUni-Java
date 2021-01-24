package softuni.advanced.streamsfilesdirectories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**Description:
 * Read the file named "input.txt" and extracts all integers that are not a part of a word in a separate file.
 */

public class ExtractIntegers {
    public static void main(String[] args) throws IOException {

        String path = "input.txt";

        Scanner scanner = new Scanner(new FileInputStream(path));

        PrintWriter out = new PrintWriter(new FileOutputStream("output.txt"));

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                out.println(scanner.nextInt());
            }

            scanner.next();
        }
        out.close();
    }
}
