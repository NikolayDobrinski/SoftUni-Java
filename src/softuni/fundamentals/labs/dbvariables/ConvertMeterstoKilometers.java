package softuni.fundamentals.labs.dbvariables;

import java.util.Scanner;

public class ConvertMeterstoKilometers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int meters = Integer.parseInt(scan.nextLine());

        System.out.printf("%.2f", (double) meters / 1000);

    }
}
