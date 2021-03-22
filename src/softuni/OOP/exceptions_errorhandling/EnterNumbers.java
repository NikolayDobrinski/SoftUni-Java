package softuni.OOP.exceptions_errorhandling;

import java.util.Scanner;

/** Description:
 * We have to write a method printNumbers(int start, int end) that prints an integer numbers in a given range [start…end].
 * If an invalid number or a non-number text is entered, the method should throw an exception. Using this method we have to
 * write a program that enters start and end: 1 < start < end < 100. If the user enters an invalid number,
 * make the user enter all of them again.
 */

public class EnterNumbers {
    public static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (true) {
            try {
                Pair numbers = readInput(scan);
                printRange(numbers);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    private static void printRange(Pair numbers) {
        for (int i = numbers.first; i <= numbers.second; i++) {
            System.out.println(i);
        }
    }

    private static Pair readInput(Scanner scan) {
        int first = Integer.parseInt(scan.nextLine());
        int second = Integer.parseInt(scan.nextLine());

        if (first < 1 || first > second || second > 100) {
            throw new IllegalArgumentException("Invalid input! The input must be: 1 < start < end < 100");
        }
        return new Pair(first, second);
    }
}
