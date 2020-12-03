package softuni.fundamentals.finalexamprep;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**Description:
 * You will be given a string representing some places on the map. You have to filter only the valid ones.
 * A valid location is:
 * Surrounded by "=" or "/" on both sides (the first and the last symbols must match)
 * After the first "=" or "/" there should be only letters (the first must be upper-case)
 * The letters must be at least 3.
 */

public class DestinationMapper {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String destinations = scan.nextLine();

        String regex = "([=|\\/])([A-Z][A-Za-z][A-Za-z]+)\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(destinations);

        List<String> validLocations = new ArrayList<>();

        while (matcher.find()) {
            validLocations.add(matcher.group(2));
        }

        System.out.println("Destinations: " + String.join(", ", validLocations));
        System.out.println("Travel Points: " + validLocations.stream().mapToInt(l -> l.length()).sum());
    }
}
