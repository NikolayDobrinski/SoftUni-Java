package softuni.OOP.encapsulation.ClassBoxDataValidation;

import java.util.Scanner;

/** Description:
 * We are given a class Box with fields length, width and height. Model a class Box that can be instantiated by
 * the same three parameters. Expose to the outside world only methods for its surface area, lateral surface area
 * and its volume. A box’s side should not be zero or a negative number. We have to add data validation for each
 * parameter given to the constructor. Make a private setter that performs data validation internally.
 */

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double length = Double.parseDouble(scan.nextLine());
        double width = Double.parseDouble(scan.nextLine());
        double height = Double.parseDouble(scan.nextLine());

        Box box = new Box(length, width, height);

        System.out.printf("Surface Area - %.2f%n", box.calculateSurfaceArea());
        System.out.printf("Lateral Surface Area - %.2f%n", box.calculateLateralSurfaceArea());
        System.out.printf("Volume – %.2f", box.calculateVolume());

    }
}
