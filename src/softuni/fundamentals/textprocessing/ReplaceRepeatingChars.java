package softuni.fundamentals.textprocessing;

import java.util.Scanner;

/**
 * Program that reads a string and replaces any sequence of the same letters with a single corresponding letter.
 */

public class ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        StringBuilder sb = new StringBuilder();

        char previousChar = input.charAt(0);
        sb.append(previousChar);

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if (previousChar != currentChar) {
                sb.append(currentChar);
                previousChar = currentChar;
            }
        }
        System.out.println(sb);
    }
}
