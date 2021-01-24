package softuni.advanced.streamsfilesdirectories;

import java.io.File;

/**Description:
 * We are provided a folder named "Files-and-Streams". We have to create a program that lists the names and file sizes
 * (in bytes) of all files that are placed directly in it (we do not have to include the files in nested folders).
 */

public class ListFiles {
    public static void main(String[] args) {

        String fileName = "D:\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams";

        File file = new File(fileName);

        File[] innerFiles = file.listFiles();

        for (File innerFile : innerFiles) {

            if (!innerFile.isDirectory()) {
                System.out.printf("%s: [%d]%n", innerFile.getName(), innerFile.length());
            }
        }
    }
}
