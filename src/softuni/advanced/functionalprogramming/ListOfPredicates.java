package softuni.advanced.functionalprogramming;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**Description:
 * We have to find all numbers in the range 1..N that are divisible by the numbers of a given sequence using predicates.
 */

public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        Set<Integer> numbersSet = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).boxed().collect(Collectors.toCollection(HashSet::new));

        Predicate<Integer> isDivisible = num -> {
            for (Integer divider: numbersSet) {
                if (num % divider != 0) {
                    return false;
                }
            }
            return true;
        };

        for (int i = 1; i <= n ; i++) {
            boolean result = isDivisible.test(i);
            if (result) {
                System.out.print(i + " ");
            }
        }
    }
}
