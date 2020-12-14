package softuni.fundamentals.finalexam;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**Description:
 * Write a program that stores and manages information about sent and received messages.
 * In the beginning you will get the maximum number of messages that each user can have.
 * Then you will receive various commands that you need to apply to users:
 * - add a user with his sent and received messages;
 * - send a message from user to user;
 * - delete user;
 */

public class Problem3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int capacity = Integer.parseInt(scan.nextLine());

        Map<String, int[]> usernames = new HashMap<>();

        String input = scan.nextLine();

        while (!input.equals("Statistics")) {
            String[] line = input.split("=");
            String command = line[0];

            switch (command) {
                case "Add":
                    String user = line[1];
                    int sent = Integer.parseInt(line[2]);
                    int received = Integer.parseInt(line[3]);

                    if (!usernames.containsKey(user) && sent+received < capacity) {
                        int[] currentUser = new int[]{sent, received};
                        usernames.put(user, currentUser);
                    }
                    break;
                case "Message":
                    String sender = line[1];
                    String receiver = line[2];
                    if (usernames.containsKey(sender) && usernames.containsKey(receiver)) {
                        usernames.get(sender)[0] += 1;
                        usernames.get(receiver)[1] += 1;
                    }
                    if (usernames.get(sender)[0] + usernames.get(sender)[1] >= capacity) {
                        usernames.remove(sender);
                        System.out.printf("%s reached the capacity!%n", sender);
                    }
                    if (usernames.get(receiver)[0] + usernames.get(receiver)[1] >= capacity) {
                        usernames.remove(receiver);
                        System.out.printf("%s reached the capacity!%n", receiver);
                    }
                    break;
                case "Empty":
                    String userToEmpty = line[1];
                    if (userToEmpty.equals("All")) {
                        usernames.clear();
                    }
                    if (usernames.containsKey(userToEmpty)) {
                        usernames.remove(userToEmpty);
                    }
                    break;
            }

            input = scan.nextLine();
        }
        System.out.println("Users count: " + usernames.size());

        usernames.entrySet().stream().sorted((a, b) -> {
            int result = Integer.compare(b.getValue()[1], a.getValue()[1]);
            if (result == 0) {
                result = a.getKey().compareTo(b.getKey());
            }
            return result;
        }).forEach(u -> {
            System.out.printf("%s - %d%n", u.getKey(), (u.getValue()[0] + u.getValue()[1]));
        });
    }
}
