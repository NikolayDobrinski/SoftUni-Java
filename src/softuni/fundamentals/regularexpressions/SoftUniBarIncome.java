package softuni.fundamentals.regularexpressions;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**Description:
 * Until you receive a line with text "end of shift" you will be given lines of input. But before processing that line you
 * have to do some validations first. Each valid order should have a customer, product, count and a price:
 * Valid customer's name should be surrounded by '%' and must start with a capital letter, followed by lower-case letters
 * Valid product contains any word character and must be surrounded by '<' and '>'
 * Valid count is an integer, surrounded by '|'
 * Valid price is any real number followed by '$'
 * The parts of a valid order should appear in the order given: customer, product, count and a price.
 * Between each part there can be other symbols, except ('|', '$', '%' and '.')
 * For each valid line print on the console: "{customerName}: {product} - {totalPrice}"
 * When you receive "end of shift" print the total amount of money for the day rounded to 2 decimal places in the following
 * format: "Total income: {income}".
 */

public class SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String regex = "%(?<name>[A-Z][a-z]+)%[^|$%.]*<(?<product>\\w+)>[^|$%.]*" +
                "\\|(?<count>\\d+)\\|[^|$%.]*?(?<price>\\d+\\.?\\d*)\\$";

        Pattern pattern = Pattern.compile(regex);

        String command = scan.nextLine();
        double totalIncome = 0;

        while (!command.equals("end of shift")) {

            Matcher matcher = pattern.matcher(command);
            if (matcher.find()) {
                String customerName = matcher.group("name");
                String product = matcher.group("product");
                int count = Integer.parseInt(matcher.group("count"));
                double price = Double.parseDouble(matcher.group("price"));
                totalIncome += price * count;

                System.out.printf("%s: %s - %.2f%n", customerName, product, price * count);
            }

            command = scan.nextLine();
        }
        System.out.printf("Total income: %.2f", totalIncome);
    }
}
