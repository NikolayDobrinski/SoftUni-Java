package softuni.advanced.stackandqueue;

import java.util.Scanner;

/**Description:
 * Write a program that counts the n-th Fibonacci number counting from 0.
 *
 */

public class RecursiveFibonacci {

    private static long[] memory;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        memory = new long[n + 1];
        System.out.println(recursiveFibonacciWithMemoization(n));
    }

    private static long recursiveFibonacciWithMemoization(int n) {
        if (n <= 1) {
            return 1;
        }

        if (memory[n] != 0) {
            return memory[n];
        }

        memory[n] =
                recursiveFibonacciWithMemoization(n - 1) +
                        recursiveFibonacciWithMemoization(n - 2);
        return memory[n];
    }
}

