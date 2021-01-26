package softuni.advanced.streamsfilesdirectories;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**Description:
 * We have to write a program that traverses a folder and calculates its size in bytes.
 */

public class GetFolderSize {
    private static final String DIR_PATH = "src\\softuni\\advanced\\streamsfilesdirectories\\resources\\Exercises Resources";
    private static final String OUTPUT_PATH = "src\\softuni\\advanced\\streamsfilesdirectories\\resources\\output.txt";

    public static void main(String[] args) {

        try (PrintWriter writer = new PrintWriter(OUTPUT_PATH)) {

            File folder = new File(DIR_PATH);
            int size = 0;
            File[] files = folder.listFiles();

            if (files != null) {
                for (File file : files) {
                    size += file.length();
                }
            }
            writer.println("Folder size: " + size);


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
