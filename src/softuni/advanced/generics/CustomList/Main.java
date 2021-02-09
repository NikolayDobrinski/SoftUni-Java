package softuni.advanced.generics.CustomList;

import java.util.Scanner;

/** Description:
 * We have to create a generic data structure that can store any type that can be compared. Implement functions:
 * void add(T element), T remove(int index), boolean contains(T element), void swap(int index, int index),
 * int countGreaterThan(T element), T getMax(), T getMin()
 */

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String line = scan.nextLine();
        CustomList<String> list = new CustomList<>();

        while (!line.equals("END")) {
            String[] command = line.split("\\s+");

            switch (command[0]) {
                case "Add":
                    String elementToAdd = command[1];
                    list.add(elementToAdd);
                    break;
                case "Remove":
                    int indexToRemove = Integer.parseInt(command[1]);
                    list.remove(indexToRemove);
                    break;
                case "Contains":
                    String containedElement = command[1];
                    System.out.println(list.contains(containedElement));
                    break;
                case "Swap":
                    int indexOne = Integer.parseInt(command[1]);
                    int indexTwo = Integer.parseInt(command[2]);
                    list.swap(indexOne, indexTwo);
                    break;
                case "Greater":
                    String elementToCompare = command[1];
                    System.out.println(list.countGreaterThan(elementToCompare));
                    break;
                case "Max":
                    System.out.println(list.getMax());
                    break;
                case "Min":
                    System.out.println(list.getMin());
                    break;
                case "Print":
                    System.out.println(list);
                    break;
            }
            line = scan.nextLine();
        }
    }
}
