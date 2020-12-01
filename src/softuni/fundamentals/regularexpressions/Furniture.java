package softuni.fundamentals.regularexpressions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Description:
 * Write a program to calculate the total cost of different types of furniture.
 * You will be given some lines of input until you receive the line "Purchase".
 * For the line to be valid it should be in the following format:
 * ">>{furniture name}<<{price}!{quantity}"
 */

public class Furniture {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        String regex = ">>(?<name>[A-Za-z]+)<<(?<price>\\d+\\.?\\d*)!(?<quantity>\\d+)";
        Pattern pattern = Pattern.compile(regex);

        List<String> furniture = new ArrayList<>();

        double cost = 0;

        while (!input.equals("Purchase")) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String name = matcher.group("name");
                double price = Double.parseDouble(matcher.group("price"));
                int quantity = Integer.parseInt(matcher.group("quantity"));
                furniture.add(name);
                cost += (price * quantity);
            }
            input = scan.nextLine();
        }

        System.out.println("Bought furniture:");
        furniture.forEach(f -> System.out.println(f));
        System.out.printf("Total money spend: %.2f", cost);
    }
}
