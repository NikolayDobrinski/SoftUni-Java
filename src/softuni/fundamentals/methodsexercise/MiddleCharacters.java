package softuni.fundamentals.methodsexercise;

import java.util.Scanner;

public class MiddleCharacters {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        middleCharacterifOddorEven(input);

    }

    private static void middleCharacterifOddorEven(String input) {
        if (input.length() % 2 != 0) {
            System.out.println(input.charAt(input.length() / 2));
        } else if ((input.length() % 2 == 0)) {
            System.out.print(input.charAt(input.length() / 2 - 1));
            System.out.print(input.charAt(input.length() / 2));
        }

    }
}
