package softuni.advanced.setsandmaps;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**Description:
 * We are given a sequence of people and for each person what cards he draws from the deck.
 * Data will be on separate lines in the format: {personName}: {PT, PT, PT, ... PT}
 * Where P (2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K, A) is the power of the card, and T (S, H, D, C) is the type.
 * The input ends when "JOKER" is drawn.
 * A person cannot have more than one card of the same power and type, if he draws such a card, he discards it.
 * People play with many decks. Each card has a value that is calculated by the power multiplied by the type.
 * Degrees 2 to 10 have the same value, and J to A are 11 to 14. The types are converted to multipliers as follows
 * (S -> 4, H-> 3, D -> 2, C -> 1). Finally we print the total value that each player has in his hand.
 */

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Set<String>> playersCards = new LinkedHashMap<>();

        String command = scan.nextLine();

        while (!command.equals("JOKER")) {
            String[] currentPlayer = command.split(":");
            String name = currentPlayer[0];

            String[] cards = currentPlayer[1].split(",\\s+");

            if (!playersCards.containsKey(name)) {
                playersCards.put(name, new HashSet<>());
            }

            for (String card : cards) {
                playersCards.get(name).add(card.trim());
            }

            command = scan.nextLine();
        }


        String regex = "([0-9]+|[JQKA])([CHDS]{1})";
        Pattern pattern = Pattern.compile(regex);

        for (Map.Entry<String, Set<String>> entry : playersCards.entrySet()) {
            String name = entry.getKey();
            int playerScore = 0;

            for (String card : entry.getValue()) {
                Matcher matcher = pattern.matcher(card);

                if (matcher.find()) {
                    String power = matcher.group(1);
                    String type = matcher.group(2);

                    int value = getValueByPower(power);
                    int multiplier = getMultiplierByType(type);
                    int scores = value * multiplier;
                    playerScore += scores;
                }
            }
            System.out.println(String.format("%s: %d", name, playerScore));

        }
    }

    private static int getMultiplierByType(String type) {
        int multiplier = 0;

        switch (type) {
            case "S":
                multiplier = 4;
                break;
            case "D":
                multiplier = 2;
                break;
            case "H":
                multiplier = 3;
                break;
            case "C":
                multiplier = 1;
                break;

        }
        return multiplier;
    }


    private static int getValueByPower(String power) {
        int value;
        switch (power) {
            case "J":
                value = 11;
                break;
            case "Q":
                value = 12;
                break;
            case "K":
                value = 13;
                break;
            case "A":
                value = 14;
                break;
            default:
                value = Integer.parseInt(power);
                break;
        }
        return value;
    }
}
