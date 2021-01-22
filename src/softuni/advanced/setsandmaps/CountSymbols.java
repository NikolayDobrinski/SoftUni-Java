package softuni.advanced.setsandmaps;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**Description:
 * A program that reads a string from the input and counts how many times each string character occurs.
 * Finally, it prints the number of meetings in alphabetical order.
 */

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String text = scan.nextLine();

        Map<Character, Integer> characterOccurrences = new TreeMap<>();

        for (int i = 0; i < text.length(); i++) {
            char current = text.charAt(i);

            if (!characterOccurrences.containsKey(current)) {
                characterOccurrences.put(current, 1);
            } else {
                characterOccurrences.put(current, characterOccurrences.get(current) + 1);
            }
        }

        characterOccurrences.entrySet().forEach(e -> System.out.println(String.format("%c: %d time/s", e.getKey(), e.getValue())));

    }
}
