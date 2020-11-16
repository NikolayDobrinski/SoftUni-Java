package softuni.fundamentals.associativearrays;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, String> users = new LinkedHashMap<>();

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String[] currentUser = scan.nextLine().split(" ");
            String command = currentUser[0];
            String user = currentUser[1];

            switch (command) {
                case "register":
                    String licensePlateNumber = currentUser[2];
                    if (users.containsKey(user)) {
                        System.out.printf("ERROR: already registered with plate number %s%n", licensePlateNumber);
                    } else {
                        users.put(user, licensePlateNumber);
                        System.out.printf("%s registered %s successfully%n", user, licensePlateNumber);
                    }
                    break;
                case "unregister":
                    if (!users.containsKey(user)) {
                        System.out.printf("ERROR: user %s not found%n", user);
                    } else {
                        users.remove(user);
                        System.out.printf("%s unregistered successfully%n", user);
                    }
                    break;
            }
        }
        users.forEach((k, v) -> System.out.println(k + " => " + v));
    }
}
