package softuni.fundamentals.finalexamprep;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**Description:
 * Your task is to determine if the given sequence of characters is a valid barcode or not.
 * A barcode is valid when:
 * Is surrounded with a "@" followed by one or more "#"
 * Is at least 6  characters long (without the surrounding "@" or "#")
 * Starts with a capital letter
 * Contains only letters (lower and upper case) and digits
 * Ends with a capital letter
 */

public class FancyBarcodes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String regex = "(@#+)[A-Z][A-Za-z0-9]{4,}[A-Z](@#+)";
        Pattern pattern = Pattern.compile(regex);

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String input = scan.nextLine();
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String currentBarcode = matcher.group();
                String digit = "";
                for (int j = 0; j < currentBarcode.length(); j++) {
                    if (Character.isDigit(currentBarcode.charAt(j))) {
                        digit += currentBarcode.charAt(j);
                    }
                }
                if (digit.equals("")) {
                    System.out.println("Product group: 00");
                } else {
                    System.out.println("Product group: " + digit);
                }
            } else {
                System.out.println("Invalid barcode");
            }
        }
    }
}
