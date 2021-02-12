package softuni.advanced.iterators_comparators.ListyIterator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/** Description:
 * We have to create a class "ListyIterator", that should receive the collection of Strings which it will iterate,
 * through its constructor. The class should have three main functions:
 * Move - should return true if it successfully moved and false if there is no next index.
 * HasNext - should return true if there is a next index and false if the index is already at the last element of the list.
 * Print - should print the element at the current internal index, calling Print on a collection without elements
 * should throw an appropriate exception with the message "Invalid Operation!".
 */

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> data = Arrays.stream(scan.nextLine().split("\\s+")).skip(1).collect(Collectors.toList());

        ListyIterator listyIterator = new ListyIterator(data);

        String line = "";

        while (!"END".equals(line = scan.nextLine())) {
            switch (line) {
                case "HasNext":
                    System.out.println(listyIterator.hasNext());
                    break;
                case "Move":
                    System.out.println(listyIterator.move());
                    break;
                case "Print":
                    try {
                        listyIterator.print();
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }

                    break;


            }


        }

    }
}
