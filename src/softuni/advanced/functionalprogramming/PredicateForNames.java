package softuni.advanced.functionalprogramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

/**Description:
 * We have to write a predicate witch goal is to check a name for its length and to return true if
 * the names length is less or equal the passed integer that represents the length we have to use.
 * On the second line we will be given a string array with some names.
 * We have to print the names, passing the condition in the predicate.
 */

public class PredicateForNames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int length = Integer.parseInt(scan.nextLine());

        String[] names = scan.nextLine().split("\\s+");

        Predicate<String> lengthPredicate = name -> name.length() <= length;

        Arrays.stream(names).filter(lengthPredicate).forEach(e -> System.out.println(e));

    }
}
