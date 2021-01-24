package softuni.advanced.streamsfilesdirectories;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;

/**Description:
 * We are provided a folder named "Files-and-Streams". We have to create a program that lists the names of all directories in it
 * (including all nested directories). On the last line we have to print the count of all folders, including the root folder.
 */

public class NestedFolders {
    public static void main(String[] args) {

        String path = "D:\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams";

        File root = new File(path);

        Deque<File> dirs = new ArrayDeque<>();

        dirs.offer(root);

        int counter = 0;

        while (!dirs.isEmpty()) {
            File current = dirs.poll();

            File[] nestedFiles = current.listFiles();

            for (File nestedFile: nestedFiles) {
                if (nestedFile.isDirectory()) {
                    dirs.offer(nestedFile);
                    counter++;
                    System.out.println(current.getName());

                }
            }
        }
        System.out.println(counter + " folders");

    }
}
