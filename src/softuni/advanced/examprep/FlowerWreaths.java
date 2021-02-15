package softuni.advanced.examprep;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/** Description:
 * We will be given two sequences of integers, representing roses and lilies. We need to start making
 * wreaths knowing that one wreath needs 15 flowers. Our goal is to make at least 5 flower wreaths.
 * We will start crafting from the last lilies and the first roses. If the sum of their values is
 * equal to 15 – create one wreath and remove them. If the sum is bigger than 15, just decrease the
 * value of the lilies by 2. If the sum is less than 15 we have to store them for later and remove them.
 * We need to stop combining when we have no more roses or lilies. In the end, if we have any stored
 * flowers we should make as many wreaths as we can with them.
 */

public class FlowerWreaths {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Stack - roses - pop, push

        ArrayDeque<Integer> roses = new ArrayDeque<>();

        Arrays.stream(scan.nextLine().split(",\\s+"))
                .map(Integer::parseInt)
                .forEach(roses::push);

        //Queue - lilies - offer, poll

        ArrayDeque<Integer> lilies = Arrays.stream(scan.nextLine().split(",\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        int numberWreaths = 0;
        int storedFlowers = 0;


        while (!roses.isEmpty() && !lilies.isEmpty()) {
            int currentRose = roses.pop();
            int currentLily = lilies.poll();

            int sum = currentRose + currentLily;

            if (sum == 15) {
                numberWreaths++;
            }
            else if (sum < 15) {
                storedFlowers += sum;
            }
            else if (sum > 15) {
                roses.push(currentRose);
                lilies.offerFirst(currentLily - 2);
            }
        }

        int wreathsFromStored = storedFlowers / 15;
        int totalWreaths = wreathsFromStored + numberWreaths;

        if (totalWreaths >= 5) {
            System.out.printf("You made it, you are going to the competition with %d wreaths!", totalWreaths);
        }
        else {
            int wreathsNeeded = 5 - totalWreaths;
            System.out.printf("You didn't make it, you need %d wreaths more!", wreathsNeeded);
        }
    }
}
