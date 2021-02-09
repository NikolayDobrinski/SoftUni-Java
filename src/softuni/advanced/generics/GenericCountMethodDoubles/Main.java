package softuni.advanced.generics.GenericCountMethodDoubles;

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
        Box<Double> box = new Box<>();

        for (int i = 0; i < n; i++) {
            Double value = Double.parseDouble(scan.nextLine());
            box.addValue(value);
        }
        Double elementToCompare = Double.parseDouble(scan.nextLine());
        System.out.println(box.countGreaterElements(elementToCompare));
    }
}
