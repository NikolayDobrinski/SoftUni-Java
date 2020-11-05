package softuni.fundamentals.midexamprep;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Inventory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> items = Arrays.stream(scan.nextLine().split(", ")).
                collect(Collectors.toList());


        String command = scan.nextLine();

        while (!command.equals("Craft!")) {
            String[] current = command.split(" - ");
            String action = current[0];

            switch (action) {
                case "Collect":
                    if (!items.contains(current[1])) {
                        items.add(current[1]);
                    }
                    break;
                case "Drop":
                    if (items.contains(current[1])) {
                        int index = items.indexOf(current[1]);
                        items.remove(index);
                    }
                    break;
                case "Combine Items":
                    String[] item = current[1].split(":");
                    String oldItem = item[0];
                    String newItem = item[1];

                    if (items.contains(oldItem)) {
                        int indexOldItem = items.indexOf(oldItem);
                        items.add(indexOldItem + 1, newItem);
                    }
                    break;
                case "Renew":
                    if (items.contains(current[1])) {
                        items.remove(current[1]);
                        items.add(current[1]);
                    }
                    break;
            }
            command = scan.nextLine();
        }
        System.out.print(String.join(", ", items));

    }
}

