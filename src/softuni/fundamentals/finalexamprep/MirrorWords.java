package softuni.fundamentals.finalexamprep;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**Description:
 * You will be given a text string. You have to find all hidden word pairs, read them and mark the ones that are mirror
 * images of each other. First of all you have to extract the hidden word pairs. Hidden word pairs are:
 * Surrounded by "@" or "#" (only one of the two) in the following pattern #wordOne##wordTwo# or @wordOne@@wordTwo@;
 * At least 3 characters long each (without the surrounding symbols);
 * Made up of letters only;
 * If the second word, spelled backwards is the same as the first word and vice versa (casing matters!),
 * then they are a match and you have to store them somewhere. Examples of mirror words:
 * #Part##traP# @leveL@@Level@ #sAw##wAs#
 */

public class MirrorWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        List<List<String>> wordPairs = new ArrayList<>();

        String regex = "([@|#])(?<first>[A-Za-z]{3,})\\1\\1(?<second>[A-Za-z]{3,})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        int pairsCount = 0;

        while (matcher.find()) {
            pairsCount++;
            String firstPart = matcher.group("first");
            String secondPart = matcher.group("second");

            String secondPartReversed = "";

            for (int i = secondPart.length() - 1; i >= 0; i--) {
                secondPartReversed += secondPart.charAt(i);
            }
            if (firstPart.equals(secondPartReversed)) {
                wordPairs.add(List.of(firstPart, secondPart));
            }
        }
        if (pairsCount == 0) {
            System.out.println("No word pairs found!");
        } else {
            System.out.printf("%d word pairs found!%n", pairsCount);
        }

        if (wordPairs.isEmpty()) {
            System.out.println("No mirror words!");
        } else {
            System.out.println("The mirror words are:");
            System.out.println(wordPairs.stream()
                    .map(pair -> String.join(" <=> ", pair))
                    .collect(Collectors.joining(", ")));

        }
    }
}
