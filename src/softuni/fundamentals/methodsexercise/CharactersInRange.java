package softuni.fundamentals.methodsexercise;

import java.util.Scanner;

public class CharactersInRange {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        char one = scan.nextLine().charAt(0);
        char two = scan.nextLine().charAt(0);
        printCharactersBetween(one, two);

    }

    private static void printCharactersBetween(char a, char b) {
        String output = "";
        if (a < b) {
            for (char i = (char) (a + 1); i < b; i++) {
                System.out.print(i + " ");
            }
        } else {
            for (char i = (char) (b + 1); i < a; i++) {
                System.out.print(i + " ");
            }
        }
    }
}
