package softuni.fundamentals.regularexpressions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**Description:
 * You will receive several messages, which are encrypted using the legendary star enigma.
 * You should decrypt the messages, following these rules:
 * To properly decrypt a message, you should count all the letters [s, t, a, r] – case insensitive
 * and remove the count from the current ASCII value of each symbol of the encrypted message.
 * After decryption:
 * Each message should have a planet name, population, attack type ('A', as attack or 'D', as destruction)
 * and soldier count.
 * The planet name starts after '@' and contains only letters from the Latin alphabet.
 * The planet population starts after ':' and is an Integer;
 * The attack type may be "A"(attack) or "D"(destruction) and must be surrounded by "!" (exclamation mark).
 * The soldier count starts after "->" and should be an Integer.
 *  */

public class StarEnigma {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> attacked = new ArrayList<>();
        List<String> destroyed = new ArrayList<>();

        String countRegex = "(?i)[star]";
        Pattern countPattern = Pattern.compile(countRegex);

        String validMsgRegex = "@(?<name>[A-Za-z]+)[^@\\-!:>]*:(?<population>\\d+)[^@\\-!:>]*!(?<type>[A|D])![^@\\-!:>]*->(?<soldiers>\\d+)";
        Pattern validMsgPattern = Pattern.compile(validMsgRegex);

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String input = scan.nextLine();
            int counter = 0;
            Matcher countMatcher = countPattern.matcher(input);
            while (countMatcher.find()) {
                counter++;
            }

            StringBuilder decryptedMsg = new StringBuilder();

            for (int j = 0; j < input.length(); j++) {
                decryptedMsg.append((char) (input.charAt(j) - counter));
            }

            countMatcher = validMsgPattern.matcher(decryptedMsg.toString());

            if (countMatcher.find()) {
                String planet = countMatcher.group("name");
                String type = countMatcher.group("type");

                if (type.equals("A")) {
                    attacked.add(planet);
                } else {
                    destroyed.add(planet);
                }
            }
        }

        System.out.println("Attacked planets: " + attacked.size());
        attacked.stream().sorted((a, b) -> a.compareTo(b)).forEach(a -> System.out.println("-> " + a));
        System.out.println("Destroyed planets: " + destroyed.size());
        destroyed.stream().sorted((a, b) -> a.compareTo(b)).forEach(d -> System.out.println("-> " + d));
    }
}
