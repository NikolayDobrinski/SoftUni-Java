package softuni.advanced.streamsfilesdirectories;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**Description:
 * We have to read file named "input.txt" and write all its content to a file "output.txt" while skipping any punctuation.
 * Skip the following symbols: ',', '.', '!', '?'.
 */

public class WriteToFile {
    public static void main(String[] args) {

        String inputPath = "D:\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String outputPath = "D:\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\output.txt";

        List<Character> symbolsToSkip = new ArrayList<>();
        Collections.addAll(symbolsToSkip, '.', ',', '!', '?');

        try (InputStream in = new FileInputStream(inputPath);
             OutputStream out = new FileOutputStream(outputPath)) {
            int oneByte = 0;

            while ((oneByte = in.read()) >= 0) {
                if (!symbolsToSkip.contains((char) oneByte)) {
                    out.write(oneByte);
                }
            }
        } catch (IOException e) {
            e.getMessage();
        }
    }
}
