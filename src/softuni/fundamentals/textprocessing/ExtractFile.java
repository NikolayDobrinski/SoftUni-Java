package softuni.fundamentals.textprocessing;

import java.util.Scanner;

public class ExtractFile {

    /**
     * Write a program that reads the path to a file and subtracts the file name and its extension.
     */

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String path = scan.nextLine();
        String file = path.substring(path.lastIndexOf("\\") + 1);

        String name = file.substring(0, file.indexOf("."));
        String extension = file.substring(file.indexOf(".") + 1);

        System.out.println("File name: " + name);
        System.out.println("File extension: " + extension);
    }
}
