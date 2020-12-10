package softuni.fundamentals.finalexamprep;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * You will be given a text string. You must extract the information about the food and calculate the total calories.
 * It will always follow the same pattern rules:
 * It will be surrounded by "|" or "#" (only one of the two) in the following pattern:
 * #{item name}#{expiration date}#{calories}#   or |{item name}|{expiration date}|{calories}|
 * The item name will contain only lowercase and uppercase letters and whitespace;
 * The expiration date will always follow the pattern: {day}/{month}/{year}, where the day, month and year will be
 * exactly two digits long;
 * The calories will be an integer between 0-10000
 * Calculate the total calories of all food items and then determine how many days you can last with the food you have.
 * Keep in mind that you need 2000kcal a day.
 */

public class AdAstra {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String[]> items = new ArrayList<>();

        String input = scan.nextLine();

        String regex = "([#|\\|])(?<item>[A-Za-z\\s+]+)\\1(?<expiration>\\d\\d/\\d\\d/\\d\\d)\\1(?<calories>\\d+)\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        int totalCaloties = 0;

        while (matcher.find()) {
            String name = matcher.group("item");
            String expiration = matcher.group("expiration");
            String calories = matcher.group("calories");

            totalCaloties += Integer.parseInt(calories);

            String[] currentItem = new String[]{name, expiration, calories};

            items.add(currentItem);
        }

        int daysAlive = totalCaloties / 2000;
        System.out.printf("You have food to last you for: %d days!%n", daysAlive);

        if (daysAlive != 0) {

            for (int i = 0; i < items.size(); i++) {
                System.out.println("Item: " + items.get(i)[0] + ", Best before: " + items.get(i)[1] + ", Nutrition: " + items.get(i)[2]);
            }
        }
    }
}
