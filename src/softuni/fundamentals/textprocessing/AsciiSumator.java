package softuni.fundamentals.textprocessing;

import java.util.Scanner;

/**
 * Description: Program that prints a sum of all characters between two given characters (their ascii code).
 */

public class AsciiSumator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        char charStart = scan.nextLine().charAt(0);
        char charEnd = scan.nextLine().charAt(0);

        String randomString = scan.nextLine();
        int sum = 0;

        for (int j = 0; j < randomString.length(); j++) {
            char currentChar = randomString.charAt(j);
            if (currentChar > charStart && currentChar < charEnd) {
                sum += currentChar;
            }
        }

        System.out.println(sum);

    }
}
