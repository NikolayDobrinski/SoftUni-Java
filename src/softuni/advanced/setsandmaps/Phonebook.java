package softuni.advanced.setsandmaps;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**Description:
 * A program that receives and stores information about people and their phone numbers.
 * Then we search for a specific person and print his phone number if there is one,
 * if not - we print a non-existent subscriber.
 */

public class Phonebook {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, String> phonebook = new HashMap<>();

        String command = scan.nextLine();

        while (!command.equals("search")) {
            String[] currentContact = command.split("-");
            String name = currentContact[0];
            String number = currentContact[1];

            phonebook.put(name, number);

            command = scan.nextLine();
        }

        command = scan.nextLine();

        while (!command.equals("stop")) {
            String searchName = command;

            if (phonebook.containsKey(searchName)) {
                System.out.printf("%s -> %s%n", searchName, phonebook.get(searchName));
            } else {
                System.out.printf("Contact %s does not exist.%n", searchName);
            }
            command = scan.nextLine();
        }
    }
}
