package softuni.fundamentals.associativearrays;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Integer> resourceQuantity = new LinkedHashMap<>();

        String command = scan.nextLine();
        while (!command.equals("stop")) {

            String resource = command;
            int quantity = Integer.parseInt(scan.nextLine());

            if (resourceQuantity.containsKey(resource)) {
                int currentQuantity = resourceQuantity.get(resource);
                resourceQuantity.put(resource, currentQuantity + quantity);
            } else {
                resourceQuantity.put(resource, quantity);
            }
            command = scan.nextLine();
        }
        resourceQuantity.forEach((k, v) -> System.out.println(k + " -> " + v));

    }
}
