package softuni.advanced.functionalprogramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**Description:
 * We have to write a program that reads one line of Integers separated by ", " and:
 * Print the even numbers;
 * Sort them in ascending order;
 * Print them again;
 * We have to use lambda expressions.
 */

public class SortEvenNumbers {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int[] numbers = Arrays.stream(scan.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .filter(e -> isDivisibleBy(e, 2))
                .toArray();

        System.out.println(formatArray(numbers));

        Arrays.sort(numbers);

        System.out.println(formatArray(numbers));

    }

    public static String formatArray(int[] arr) {
        return Arrays.stream(arr)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));
    }

    public static boolean isDivisibleBy(int number, int divisor) {
        return number % divisor == 0;
    }
}
