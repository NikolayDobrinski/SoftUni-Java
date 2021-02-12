package softuni.advanced.iterators_comparators.Collection;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/** Description:
 * We have to create ListyIterator class that mplements the "Iterable" interface and we have to
 * implements all methods desired by the interface manually. Add a new method to the class PrintAll(),
 * the method should foreach the collection and print all elements on a single line separated by a space.
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
                    System.out.println(listyIterator.iterator().hasNext());
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
                case "PrintAll":
                    try {
                        listyIterator.printAll();
                        System.out.println();
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }
        }
    }
}
