package softuni.fundamentals.listsexercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> wagons = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        int capacity = Integer.parseInt(scan.nextLine());

        String command = scan.nextLine();

        while (!command.equals("end")) {
            String[] current = command.split(" ");

            if (current[0].equals("Add")) {
                int passengers = Integer.parseInt(current[1]);
                wagons.add(passengers);
            } else {
                int passengers = Integer.parseInt(current[0]);
                for (int i = 0; i < wagons.size(); i++) {
                    int totalPassengers = passengers + wagons.get(i);
                    if (totalPassengers <= capacity) {
                        wagons.set(i, totalPassengers);
                        break;
                    }
                }
            }

            command = scan.nextLine();
        }
        for (int i = 0; i < wagons.size(); i++) {
            System.out.print(wagons.get(i) + " ");
        }


    }
}
