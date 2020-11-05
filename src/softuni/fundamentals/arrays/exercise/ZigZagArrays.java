package softuni.fundamentals.arrays.exercise;

import java.util.Scanner;

public class ZigZagArrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        int[] arrayOne = new int[n];
        int[] arrayTwo = new int[n];

        for (int i = 1; i <= n; i++) {
            String[] line = scan.nextLine().split(" ");

            if (i % 2 == 0) {
                arrayOne[i - 1] = Integer.parseInt(line[1]);
                arrayTwo[i - 1] = Integer.parseInt(line[0]);
            } else {
                arrayOne[i - 1] = Integer.parseInt(line[0]);
                arrayTwo[i - 1] = Integer.parseInt(line[1]);
            }

        }
        for (int i = 0; i < arrayOne.length; i++) {
            System.out.print(arrayOne[i] + " ");

        }
        System.out.println();
        for (int i = 0; i < arrayTwo.length; i++) {
            System.out.print(arrayTwo[i] + " ");
        }

    }
}
