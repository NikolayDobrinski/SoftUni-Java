package softuni.fundamentals.labs.dbvariables;

import java.util.Scanner;

public class PoundstoDollars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double pounds = Double.parseDouble(scan.nextLine());
        double poundsConverted = pounds * 1.31;

        System.out.printf("%.3f", poundsConverted);

    }
}
