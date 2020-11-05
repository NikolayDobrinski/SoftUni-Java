package softuni.fundamentals.easy;

import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        int m = Integer.parseInt(scan.nextLine());

        for (int i = m; i <= 10; i++) {

            int result = n * i;
            System.out.printf("%d X %d = %d%n", n, i, result);

        }
        if (m > 10) {
            int totalResult = n * m;
            System.out.printf("%d X %d = %d%n", n, m, totalResult);
        }


    }
}
