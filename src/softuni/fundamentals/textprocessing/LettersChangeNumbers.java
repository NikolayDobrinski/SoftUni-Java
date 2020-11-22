package softuni.fundamentals.textprocessing;

import java.util.Scanner;

/**
 * Description: You get a string consisting of a number between two letters. Depending on whether the letter was in front
 * of the number or after it you would perform different mathematical operations on the number to achieve the result.
 */

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\s+");
        double sum = 0;

        for (String s : input) {
            char firstLetter = s.charAt(0);
            char secondLetter = s.charAt(s.length() - 1);
            double number = Double.parseDouble(s.substring(1, s.length() - 1));

            int firstLetterPosition = getLetterAlphabeticPosition(firstLetter);
            int secondLetterPosition = getLetterAlphabeticPosition(secondLetter);

            if (Character.isUpperCase(firstLetter)) {
                sum += number / firstLetterPosition;
            } else {
                sum += number * firstLetterPosition;
            }
            if (Character.isUpperCase(secondLetter)) {
                sum -= secondLetterPosition;
            } else {
                sum += secondLetterPosition;
            }
        }
        System.out.printf("%.2f", sum);
    }

    private static int getLetterAlphabeticPosition(char c) {
        char targetChar = Character.toLowerCase(c);
        char initialChar = 'a';
        int position = targetChar - initialChar + 1;

        return (position);

    }
}
