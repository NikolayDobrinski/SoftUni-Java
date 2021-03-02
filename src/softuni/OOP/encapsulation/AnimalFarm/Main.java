package softuni.OOP.encapsulation.AnimalFarm;

import java.util.Scanner;

/** Description:
 * We need to create class Chicken which contain several fields, a constructor, and several methods.
 * Our task is to encapsulate or hide anything that is not intended to be viewed or modified from outside the class.
 */

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String name = scan.nextLine();
        int age = Integer.parseInt(scan.nextLine());

        try {
            Chicken chicken = new Chicken(name, age);
            System.out.println(chicken);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }
}
