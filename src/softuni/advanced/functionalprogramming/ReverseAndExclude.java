package softuni.advanced.functionalprogramming;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**Description:
 * Program that reverses a collection and removes elements that are divisible by a given integer n.
 */

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        int n = Integer.parseInt(scan.nextLine());

        Collections.reverse(numbers);

        Predicate<Integer> predicate = e -> e % n != 0;

        numbers.stream().filter(predicate::test).forEach(e -> System.out.print(e + " "));
    }
}
