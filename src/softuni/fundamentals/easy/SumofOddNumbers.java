package softuni.fundamentals.easy;

import java.util.Scanner;

public class SumofOddNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        int sum = 0;

        for (int i = 1; i <= n; i += 2) {

            if (i % 2 != 0) {
                sum += i;
                System.out.println(i);
            }

        }
        System.out.printf("Sum: %d", sum);

    }
}
