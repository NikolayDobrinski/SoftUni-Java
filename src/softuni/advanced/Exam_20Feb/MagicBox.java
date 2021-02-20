package softuni.advanced.Exam_20Feb;

import java.util.*;
import java.util.stream.Collectors;

/** Description:
 * We will be given two sequences of integers, representing two magic boxes. We need to start from the first
 * item in the first box and sum it with the last item in the second box. If the sum of their values is an
 * even number, add the summed item to our collection of claimed items and remove them both from the boxes.
 * Otherwise, we have to remove the last item from the second box and add it at the last position in the first box.
 * We need to stop summing items when one of the boxes becomes empty.
 */

public class MagicBox {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Queue - first magic box
        ArrayDeque<Integer> firstMagicBox = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        //Stack - second magic box
        ArrayDeque<Integer> secondMagicBox = new ArrayDeque<>();

        Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(secondMagicBox::push);

        List<Integer> claimedItems = new ArrayList<>();

        while (!firstMagicBox.isEmpty() && !secondMagicBox.isEmpty()) {
            int currentFirst = firstMagicBox.poll();
            int currentSecond = secondMagicBox.pop();

            int sum = currentFirst + currentSecond;

            if (sum % 2 == 0) {
                claimedItems.add(sum);
            } else {
                firstMagicBox.offerFirst(currentFirst);
                firstMagicBox.offer(currentSecond);
            }

        }

        if (firstMagicBox.isEmpty()) {
            System.out.println("First magic box is empty.");
        } else {
            System.out.println("Second magic box is empty.");
        }
        int sumClaimedItems = 0;
        for (int i = 0; i < claimedItems.size(); i++) {
            sumClaimedItems += claimedItems.get(i);
        }

        if (sumClaimedItems >= 90) {
            System.out.println("Wow, your prey was epic! Value: " + sumClaimedItems);
        } else {
            System.out.println("Poor prey... Value: " + sumClaimedItems);
        }
    }
}
