package softuni.fundamentals.labs.dbvariables;

import java.util.Scanner;

public class SpecialNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int digit = Integer.parseInt(scan.nextLine());

        //5, 7 or 11

        for (int i = 1; i <= digit; i++) {
            int first = i / 10;
            int second = i % 10;
            int sum = first + second;

            if (sum == 5 || sum == 7 || sum == 11) {
                System.out.printf("%d -> True%n", i);
            } else {
                System.out.printf("%d -> False%n", i);
            }

        }
    }
}
