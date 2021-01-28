package softuni.advanced.functionalprogramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

/**Description:
 * We have to write a program using Function<String, Integer>
 * that reads one line of Integers separated by ", " and prints the count of the numbers and their sum.
 */

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        Function<String, Long> getCount = str -> {
            return Arrays.stream(str.split(", "))
                    .mapToInt(Integer::parseInt)
                    .count();
        };

        Function<String, Integer> getSum = str -> {
            return Arrays.stream(str.split(", "))
                    .mapToInt(Integer::parseInt)
                    .sum();
        };

        System.out.println("Count = " + getCount.apply(input));
        System.out.println("Sum = " + getSum.apply(input));

    }
}
