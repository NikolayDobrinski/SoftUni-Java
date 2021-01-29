package softuni.advanced.functionalprogramming;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**Description:
 * On the first line we get a list with all the people that are coming to the party.
 * On the next lines, until we get the "Party!" command, we may be asked to double or remove
 * all the people that apply to given criteria. There are three different options:
 * Everyone that has a name starting with a given string;
 * Everyone that has a name ending with a given string;
 * Everyone that has a name with a given length.
 */

public class PredicateParty {

    static List<String> names = null;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        names = Arrays.stream(scan.nextLine().split("\\s+")).collect(Collectors.toList());

        String line = scan.nextLine();

        while (!line.equals("Party!")) {
            String[] tokens = line.split("\\s+");

            switch (tokens[0]) {
                case "Double":
                    addOneMore(getPredicate(tokens));
                    break;
                case "Remove":
                    removeName(getPredicate(tokens));
                    break;
                case "":
                    break;
            }

            line = scan.nextLine();
        }

        if (names.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            Collections.sort(names);
            System.out.println(names.toString().replaceAll("([\\[\\]])", "") + " are going to the party!");
        }

    }

    public static void removeName(Predicate<String> predicate) {
        names.removeIf(predicate);
    }


    public static void addOneMore(Predicate<String> predicate) {
        List<String> namesToAdd = new ArrayList<>();
        names.stream().filter(predicate).forEach(namesToAdd::add);
        names.addAll(namesToAdd);

    }


    public static Predicate<String> getPredicate(String[] tokens) {
        Predicate<String> predicate = null;

        if (tokens[1].equals("StartsWith")) {
            predicate = name -> name.startsWith(tokens[2]);
        } else if (tokens[1].equals("EndsWith")) {
            predicate = name -> name.endsWith(tokens[2]);
        } else {
            predicate = name -> name.length() == Integer.parseInt(tokens[2]);
        }
        return predicate;


    }
}

