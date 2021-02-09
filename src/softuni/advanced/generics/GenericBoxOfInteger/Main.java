package softuni.advanced.generics.GenericBoxOfInteger;

import java.util.Scanner;

/* Description:
 * We have to create a generic class Box that can store any type.
 * Override the toString() method to print the type and the value
 * of the stored data in the format {class full name: value}.
 */

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            Integer current = Integer.parseInt(scan.nextLine());
            Box<Integer> currentBox = new Box<>(current);
            System.out.println(currentBox);
        }
    }
}
