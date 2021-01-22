package softuni.advanced.setsandmaps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**Description:
 * On the first and second lines we get a person's name and his email.
 * The task is to collect names and emails and remove emails whose
 * domain ends with "us", "uk" or "com" (without registration).
 */

public class FixEmails {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String command = scan.nextLine();

        String regex = ".[us|com|uk]+$";
        Pattern pattern = Pattern.compile(regex);

        Map<String, String> data = new LinkedHashMap<>();

        while (!command.equals("stop")) {
            String name = command;
            String email = scan.nextLine();

            Matcher matcher = pattern.matcher(email);

            if (!matcher.find()) {
                data.put(name, email);
            }
            command = scan.nextLine();
        }

        data.entrySet().forEach(e -> System.out.printf("%s -> %s%n", e.getKey(), e.getValue()));

    }
}
