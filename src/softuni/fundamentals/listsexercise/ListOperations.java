package softuni.fundamentals.listsexercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> list = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        String command = scan.nextLine();

        while (!command.equals("End")) {
            String[] current = command.split(" ");

            if (current[0].equals("Add")) {
                list.add(Integer.parseInt(current[1]));
            } else if (current[0].equals("Insert")) {
                int index = Integer.parseInt(current[2]);
                if (index >= 0 && index < list.size()) {

                    int element = Integer.parseInt(current[1]);
                    list.add(index, element);
                } else {
                    System.out.println("Invalid index");
                }

            } else if (current[0].equals("Remove")) {
                int index = Integer.parseInt(current[1]);
                if (index >= 0 && index < list.size()) {
                    list.remove(Integer.parseInt(current[1]));
                } else {
                    System.out.println("Invalid index");
                }
            } else if (current[0].equals("Shift")) {
                if (current[1].equals("left")) {
                    int count = Integer.parseInt(current[2]);
                    for (int i = 0; i < count; i++) {
                        int first = list.get(0);
                        list.remove(0);
                        list.add(first);
                    }
                } else if (current[1].equals("right")) {
                    int counter = Integer.parseInt(current[2]);
                    for (int i = 0; i < counter; i++) {
                        int last = list.get(list.size() - 1);
                        list.add(0, last);
                        list.remove(list.size() - 1);
                    }
                }
            }


            command = scan.nextLine();
        }
        for (Integer elements : list) {
            System.out.print(elements + " ");
        }
    }
}
