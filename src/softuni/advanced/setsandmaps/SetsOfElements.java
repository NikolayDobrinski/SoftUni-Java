package softuni.advanced.setsandmaps;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

/**Description:
 * We are given two sizes of sets of elements n and m. Then we are given n + m number of numbers,
 * the first n we keep in the first set, the second m we save in the second set.
 * We need to check which numbers are in both sets and print them.
 */

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int lengthSetOne = scan.nextInt();
        int lengthSetTwo = scan.nextInt();

        scan.nextLine();

        Set<Integer> setOne = new LinkedHashSet<>();
        Set<Integer> setTwo = new LinkedHashSet<>();

        for (int i = 0; i < lengthSetOne; i++) {
            setOne.add(Integer.parseInt(scan.nextLine()));
        }

        for (int i = 0; i < lengthSetTwo; i++) {
            setTwo.add(Integer.parseInt(scan.nextLine()));
        }

        setOne.forEach(e -> {
            if (setTwo.contains(e)) {
                System.out.print(e + " ");
            }
        });

    }
}
