package softuni.advanced.setsandmaps;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

/**Description:
 * A program that reads a series of usernames from the input and maintains a collection with only the unique ones.
 * Finally, we print the collection from the users in the order in which they entered the entrance.
 */

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numberOfNames = Integer.parseInt(scan.nextLine());

        Set<String> uniqueUsernames = new LinkedHashSet<>();

        for (int i = 0; i < numberOfNames; i++) {
            String currentName = scan.nextLine();

            uniqueUsernames.add(currentName);
        }

        uniqueUsernames.forEach(e -> System.out.println(e));

    }
}
