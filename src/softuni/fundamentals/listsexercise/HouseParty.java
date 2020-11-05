package softuni.fundamentals.listsexercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        List<String> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] command = scan.nextLine().split(" ");
            if (command.length == 3) {
                String current = command[0];
                if (!list.contains(current)) {
                    list.add(current);
                } else {
                    System.out.printf("%s is already in the list!%n", current);
                }
            } else if (command.length == 4) {
                String name = command[0];
                if (list.contains(name)) {
                    list.remove(name);
                } else {
                    System.out.printf("%s is not in the list!%n", name);
                }
            }

        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }


    }
}
