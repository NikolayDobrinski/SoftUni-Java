package softuni.fundamentals.labs.dbvariables;

import java.util.Scanner;

public class RefactorSpecialNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        int current = 0;
        boolean isSpecialNumber = false;

        for (int i = 1; i <= number; i++) {
            current = i;
            int sum = 0;

            while (i > 0) {
                sum += i % 10;
                i = i / 10;
            }
            isSpecialNumber = (sum == 5) || (sum == 7) || (sum == 11);

            if (isSpecialNumber) {
                System.out.printf("%d -> True%n", current);
                sum = 0;
                i = current;
            } else if (!isSpecialNumber) {
                System.out.printf("%d -> False%n", current);
                sum = 0;
                i = current;
            }


        }
    }


}

