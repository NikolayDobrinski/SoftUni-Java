package softuni.advanced.functionalprogramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**Description:
 * We have to write a program using Predicate<String> that reads one line of text from the console.
 * Then we have to print the count of words that start with a Uppercase letter and the words.
 */

public class CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Predicate<String> startsWithUpperCase
                = str -> str != null && !str.isEmpty() && Character.isUpperCase(str.charAt(0));

        List<String> upperCaseWords = Arrays.stream(scan.nextLine().split("\\s+"))
                .filter(startsWithUpperCase)
                .collect(Collectors.toList());

        System.out.println(upperCaseWords.size());
        System.out.println(upperCaseWords.stream().collect(Collectors.joining(System.lineSeparator())));
    }
}
