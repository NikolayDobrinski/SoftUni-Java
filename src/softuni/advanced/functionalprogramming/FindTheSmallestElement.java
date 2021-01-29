package softuni.advanced.functionalprogramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

/**Description:
 * We have to write a custom function which finds the smallest integer in a sequence of integers.
 * Our task is to collect the integers from the input, find the smallest one and print its index.
 * (if more than one such elements exist, print the index of the rightmost one).
 */

public class FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        Function<List<Integer>, Integer> getLastIndexOfMinElement =
                list -> list.lastIndexOf(list.stream().min(Integer::compare).get());

        System.out.println(getLastIndexOfMinElement.apply(numbers));

    }
}
