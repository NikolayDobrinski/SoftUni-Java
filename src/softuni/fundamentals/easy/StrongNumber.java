package softuni.fundamentals.easy;

import java.util.Scanner;

public class StrongNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int totalSum = 0;

        String number = scan.nextLine();

        for (int i = 0; i <= number.length() - 1; i++) {
            int digit = number.charAt(i) - 48;

            int fact = 1;

            for (int j = 1; j <= digit; j++) {
                fact *= j;
            }
            totalSum += fact;
        }
        int sum = Integer.parseInt(number);

        if (totalSum == sum) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }

    }
}
