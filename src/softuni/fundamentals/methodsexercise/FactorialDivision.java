package softuni.fundamentals.methodsexercise;

import java.util.Scanner;

public class FactorialDivision {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int a = Integer.parseInt(scan.nextLine());
        int b = Integer.parseInt(scan.nextLine());

        long factorialA = findFactorialofNumber(a);
        long factorialB = findFactorialofNumber(b);

        double result = factorialA * 1.0 / factorialB;

        System.out.printf("%.2f", result);

    }

    private static long findFactorialofNumber(int a) {
        long result = 1;

        for (int i = 1; i <= a; i++) {
            result *= i;
        }
        return result;
    }
}
