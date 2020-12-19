package softuni.fundamentals.finalexamprep;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**Description:
 * You will be given an array of integers, which represent the house numbers you should visit.
 * The commands will lead you to them. If they lead you to non-existing places, don’t move.
 * Forward {numberOfSteps}
 * Back {numberOfSteps}
 * Gift {insert new house on index} {houseNumber}
 * Swap {first house number} {second house number}
 */

public class SantasGifts {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        List<Integer> initialArray = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        int index = 0;

        for (int i = 0; i < n; i++) {
            String[] line = scan.nextLine().split(" ");
            String command = line[0];

            switch (command) {
                case "Forward":
                    int numberOfSteps = Integer.parseInt(line[1]);

                    if ((numberOfSteps + index) >= 0 && (numberOfSteps + index) < initialArray.size()) {
                        index += numberOfSteps;
                        initialArray.remove(index);
                    }

                    break;
                case "Back":
                    int numberSteps = Integer.parseInt(line[1]);
                    if ((index - numberSteps) >= 0 && (index - numberSteps) < initialArray.size()) {
                        initialArray.remove(index - numberSteps);
                        index -= numberSteps;
                    }

                    break;
                case "Gift":
                    int indexToPut = Integer.parseInt(line[1]);
                    int houseNumber = Integer.parseInt(line[2]);

                    if (indexToPut >= 0 && indexToPut < initialArray.size()) {

                        index = indexToPut;

                        initialArray.add(indexToPut, houseNumber);
                    }

                    break;

                case "Swap":
                    int firstHouse = Integer.parseInt(line[1]);
                    int secondHouse = Integer.parseInt(line[2]);

                    int firstIndex = 0;
                    int secondIndex = 0;
                    boolean first = false;
                    boolean second = false;

                    for (int j = 0; j < initialArray.size(); j++) {
                        if (initialArray.get(j) == firstHouse) {
                            firstIndex = j;
                            first = true;
                        }
                        if (initialArray.get(j) == secondHouse) {
                            secondIndex = j;
                            second = true;
                        }
                    }
                    if (first && second) {

                        initialArray.set(firstIndex, secondHouse);
                        initialArray.set(secondIndex, firstHouse);

                    }

                    break;
            }
        }

        System.out.println("Position: " + index);
        for (int i = 0; i < initialArray.size() - 1; i++) {
            System.out.print(initialArray.get(i) + ", ");
        }
        System.out.print(initialArray.get(initialArray.size() - 1));
    }
}
