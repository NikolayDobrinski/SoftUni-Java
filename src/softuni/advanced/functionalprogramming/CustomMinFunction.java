package softuni.advanced.functionalprogramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

/**Description:
 * We have to write a program that reads a set of numbers and finds the smallest of them
 * using a simple Function<Integer[], Integer> .
 */

public class CustomMinFunction {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int[] numbers = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Function<int[], Integer> getMinNumber = number -> Arrays.stream(numbers).min().getAsInt();

        Integer minNumber = getMinNumber.apply(numbers);

        System.out.println(minNumber);

    }
}
