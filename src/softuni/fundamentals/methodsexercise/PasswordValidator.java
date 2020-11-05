package softuni.fundamentals.methodsexercise;

import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        boolean conditionOne = checkHowLong(input);
        boolean conditionTwo = checkForLetterAndDigits(input);
        boolean conditionThree = checkForAtLeastTwoDigits(input);

        if (conditionOne && conditionTwo && conditionThree) {
            System.out.println("Password is valid");
        }
        if (!conditionOne) {
            System.out.println("Password must be between 6 and 10 characters");
        }
        if (!conditionTwo) {
            System.out.println("Password must consist only of letters and digits");
        }
        if (!conditionThree) {
            System.out.println("Password must have at least 2 digits");
        }


    }

    private static boolean checkForAtLeastTwoDigits(String input) {
        int counter = 0;
        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);

            if (Character.isDigit(current)) {
                counter++;
            }
        }
        if (counter >= 2) {
            return true;
        }
        return false;
    }

    private static boolean checkForLetterAndDigits(String input) {
        for (int i = 0; i < input.length(); i++) {
            char letter = input.charAt(i);
            boolean isDigit = Character.isDigit(letter);
            boolean isLetter = Character.isLetter(letter);

            if (!isDigit && !isLetter) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkHowLong(String input) {
        return input.length() >= 6 && input.length() <= 10;

    }
}
