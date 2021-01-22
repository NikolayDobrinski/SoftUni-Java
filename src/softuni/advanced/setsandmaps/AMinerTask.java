package softuni.advanced.setsandmaps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**Description:
 * Each odd row on the console is given a resource (silver, gold, copper...),
 * and each even row is given a quantity. We need to gather the resources and print them all on a new line.
 */

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String command = scan.nextLine();

        Map<String, Integer> resources = new LinkedHashMap<>();

        while (!command.equals("stop")) {
            String resource = command;
            int quantity = Integer.parseInt(scan.nextLine());

            if (!resources.containsKey(resource)) {
                resources.put(resource, quantity);
            } else {
                resources.put(resource, resources.get(resource) + quantity);
            }
            command = scan.nextLine();
        }

        resources.entrySet().forEach(e -> System.out.printf("%s -> %d%n", e.getKey(), e.getValue()));

    }
}
