package softuni.fundamentals.labs.dbvariables;

import java.util.Scanner;

public class LowerorUpper {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int letter = scan.nextLine().charAt(0);

        if (letter > 96 && letter < 123) {
            System.out.println("lower-case");
        } else if (letter > 64 && letter < 91) {
            System.out.println("upper-case");
        }


    }
}
