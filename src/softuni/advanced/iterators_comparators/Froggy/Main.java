package softuni.advanced.iterators_comparators.Froggy;

import java.util.*;

/** Description:
 * We have to create a class "Lake", it should implement the interface - "Iterable".
 * Inside the Lake, we create a class - "Frog" and implement the interface "Iterator".
 * When the Frog starts jumping, print on the console each number the Frog has stepped over.
 * To calculate the jumps, use the guide lines: The jumps start from the 0th index and follows
 * the pattern - first all even indexes in ascending order(0->2->4->6 and so on) and then all
 * odd indexes in ascending order (1->3->5->7 and so on). Consider the 0th index as even.
 */

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] stones = Arrays.stream(scan.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();

        Lake lake = new Lake(stones);

        Iterator<Integer> froggy = lake.iterator();

        List<String> result = new ArrayList<>();

        while (froggy.hasNext()) {
            result.add(froggy.next() + "");
        }

        System.out.println(String.join(", ", result));
    }
}
