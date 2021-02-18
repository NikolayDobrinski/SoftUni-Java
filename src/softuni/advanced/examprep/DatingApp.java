package softuni.advanced.examprep;

import java.util.*;
import java.util.stream.Collectors;

/** Description:
 * We will be given two sequences of integers representing males and females. Then we have to start from the first
 * female and try to match it with the last male. If their values are equal, we have to match them and remove both of them.
 * Otherwise we should remove only the female and decrease the value of the male by 2.
 * If someone’s value is equal to or below 0, we should remove him/her from the records before trying to match him/her with anybody.
 * Special case - if someone’s value divisible by 25 without remainder, we should remove him/her and the next person of the same gender.
 * We need to stop matching people when we have no more females or males.
 */

public class DatingApp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Stack - males

        ArrayDeque<Integer> males = new ArrayDeque<>();

        Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(males::push);

        //Queue - females

        ArrayDeque<Integer> females = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        int matches = 0;

        while (!males.isEmpty() && !females.isEmpty()) {
            int currentMale = males.pop();
            int currentFemale = females.poll();

            if (currentMale == currentFemale) {
                matches++;
            } else if (currentMale != currentFemale && currentMale > 0 && currentFemale > 0
                    && currentMale % 25 != 0 && currentFemale % 25 != 0) {

                currentMale -= 2;
                males.push(currentMale);
            } else if (currentMale <= 0 || currentFemale <= 0) {
                if (currentMale <= 0) {
                    females.offerFirst(currentFemale);
                }
                if (currentFemale <= 0) {
                    males.push(currentMale);
                }
            } else if (currentMale % 25 == 0) {
                males.pop();
                females.offerFirst(currentFemale);
            } else if (currentFemale % 25 == 0) {
                females.poll();
                males.push(currentMale);
            }
        }

        System.out.printf("Matches: %d%n", matches);

        if (males.isEmpty()) {
            System.out.println("Males left: none");
        } else {
            printResult(males, "Males left: ");
        }
        if (females.isEmpty()) {
            System.out.println("Females left: none");
        } else {
            printResult(females, "Females left: ");
        }

    }

    public static void printResult (ArrayDeque arrayDeque, String text) {
        List<String> list = new ArrayList<>();
        System.out.print(text);
        arrayDeque.stream().forEach(m -> list.add(m.toString()));
        System.out.println(String.join(", ", list));
    }
}
