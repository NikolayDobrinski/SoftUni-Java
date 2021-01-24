package softuni.advanced.streamsfilesdirectories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**Description:
 * Read the file named "input.txt" and write to file "output.txt" every character's ASCII representation.
 * Write every space or new line as it is, e.g. as a space or a new line.
 */

public class CopyBytes {
    public static void main(String[] args) throws IOException {

        String path = "input.txt";

        FileInputStream inputStream = new FileInputStream(path);

        FileOutputStream outputStream = new FileOutputStream("öutput.txt");

        PrintWriter writer = new PrintWriter(outputStream);

        int oneByte = inputStream.read();

        while (oneByte >= 0) {

            if (oneByte == 10 || oneByte == 32) {
                writer.print((char) oneByte);
            } else {
                writer.print(oneByte);
            }

            oneByte = inputStream.read();
        }

        writer.close();
        inputStream.close();

    }
}
