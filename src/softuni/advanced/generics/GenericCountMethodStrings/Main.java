package softuni.advanced.generics.GenericCountMethodStrings;

import java.util.Scanner;

/** Description:
 * We have to create a method that receives as argument a list of any type that can be compared
 * and an element of the given type. The method should return the count of elements that are
 * greater than the value of the given element.
 */

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        Box<String> box = new Box<>();

        for (int i = 0; i < n; i++) {
            String value = scan.nextLine();
            box.addValue(value);
        }
        String elementToCompare = scan.nextLine();
        System.out.println(box.countGreaterElements(elementToCompare));
    }
}
