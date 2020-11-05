package softuni.fundamentals.listsexercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        String command = scan.nextLine();

        while (!command.equals("end")) {
            String[] current = command.split(" ");

            if (current[0].equals("Delete")) {
                int elementToRemove = Integer.parseInt(current[1]);
                while (numbers.remove(Integer.valueOf(elementToRemove))) {
                    numbers.remove(Integer.valueOf(elementToRemove));
                }
            } else if (current[0].equals("Insert")) {
                int elementToAdd = Integer.parseInt(current[1]);
                int elementToIndex = Integer.parseInt(current[2]);
                numbers.add(elementToIndex, elementToAdd);
            }
            command = scan.nextLine();
        }
        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i) + " ");
        }

    }
}
