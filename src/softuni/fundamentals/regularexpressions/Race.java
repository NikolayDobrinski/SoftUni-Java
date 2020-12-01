package softuni.fundamentals.regularexpressions;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**Description:
 * Write a program that processes information about a race. On the first line you will be given a list of
 * participants separated by ", ". On the next few lines until you receive a line "end of race" you will
 * be given some info which will be some alphanumeric characters. In between them you could have some extra
 * characters which you should ignore. For example: "G!32e%o7r#32g$235@!2e". The letters are the name of the
 * person and the sum of the digits is the distance he ran. So here we have George who ran 29 km.
 */

public class Race {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String nameRegex = "[A-Za-z]";
        Pattern namePattern = Pattern.compile(nameRegex);

        String distanceRegex = "\\d";
        Pattern distancePattern = Pattern.compile(distanceRegex);

        List<String> participants = Arrays.stream(scan.nextLine().split(", "))
                .collect(Collectors.toList());

        Map<String, Integer> racers = new LinkedHashMap<>();

        for (String participant : participants) {
            racers.put(participant, 0);
        }

        String input = scan.nextLine();

        while (!input.equals("end of race")) {
            Matcher nameMatcher = namePattern.matcher(input);
            StringBuilder name = new StringBuilder();

            while (nameMatcher.find()) {
                name.append(nameMatcher.group());
            }

            if (racers.containsKey(name.toString())) {
                int currentDistance = racers.get(name.toString());
                Matcher distanceMatcher = distancePattern.matcher(input);
                while (distanceMatcher.find()) {
                    currentDistance += Integer.parseInt(distanceMatcher.group());
                }
                racers.put(name.toString(), currentDistance);
            }

            input = scan.nextLine();
        }
        List<String> winners = racers.entrySet()
                .stream()
                .sorted((a, b) -> b.getValue() - a.getValue())
                .limit(3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        int count = 1;
        for (String winner : winners) {
            switch (count++) {
                case 1:
                    System.out.println("1st place: " + winner);
                    break;
                case 2:
                    System.out.println("2nd place: " + winner);
                    break;
                case 3:
                    System.out.println("3rd place: " + winner);
                    break;

            }
        }
    }
}
