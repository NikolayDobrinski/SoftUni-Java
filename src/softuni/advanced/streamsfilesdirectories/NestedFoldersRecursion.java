package softuni.advanced.streamsfilesdirectories;

import java.io.File;

/**Description:
 * We are provided a folder named "Files-and-Streams". We have to create a program that lists the names of all directories in it
 * (including all nested directories). On the last line we have to print the count of all folders, including the root folder.
 */

public class NestedFoldersRecursion {

    public static int foldersCount = 1;

    public static void main(String[] args) {

        String path = "D:\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams";

        File file = new File(path);

        dfs(file);
        System.out.println(foldersCount + " folders");
    }

    public static void dfs(File file) {
        foldersCount++;
        for (File f : file.listFiles()) {
            if (f.isDirectory()) {
                dfs(f);
            }
        }
        System.out.println(file.getName());
    }
}
