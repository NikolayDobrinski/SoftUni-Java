package softuni.fundamentals.textprocessing;

import java.util.Scanner;

/**
 * Description: Program that reads n lines of strings and extracts the name and age of a given person.
 * The name of the person will be between '@' and '|'. The person’s age will be between '#' and '*'.
 */

public class ExtractPersonInformation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String currentString = scan.nextLine();

            int nameStartChar = currentString.indexOf('@');
            int nameEndChar = currentString.indexOf('|');
            String name = currentString.substring(nameStartChar + 1, nameEndChar);

            int ageStartIndex = currentString.indexOf('#');
            int ageEndIndex = currentString.indexOf('*');
            String age = currentString.substring(ageStartIndex + 1, ageEndIndex);

            System.out.printf("%s is %s years old.%n", name, age);
        }
    }
}
