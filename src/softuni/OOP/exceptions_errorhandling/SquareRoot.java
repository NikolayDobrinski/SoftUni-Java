package softuni.OOP.exceptions_errorhandling;

import java.util.Scanner;

/** Description:
 * We have to write a program that reads an integer number and calculates and prints its square root.
 * If the number is invalid, we print "Invalid number". In all cases finally print "Good bye". Use try-catch-finally.
 */

public class SquareRoot {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        try {
            System.out.println(Math.sqrt(Integer.parseInt(scan.nextLine())));
        } catch (NumberFormatException ignored) {
            System.out.println("Invalid number");
        } finally {
            System.out.println("Good bye");
        }

    }
}
