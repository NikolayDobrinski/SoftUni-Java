package softuni.fundamentals.arrays;

import java.util.Scanner;

public class PrintNumbersinReverseOrder {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(scan.nextLine());
            numbers[i] = number;
        }
        for (int reversed = numbers.length - 1; reversed >= 0; reversed--) {
            System.out.printf("%d ", numbers[reversed]);
        }


    }
}
