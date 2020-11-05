package softuni.fundamentals.arrays.exercise;

import java.util.Scanner;

public class MaxSequenceofEqualElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] arr = scan.nextLine().split(" ");
        int[] numbers = new int[arr.length];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(arr[i]);
        }

        int maxCount = 0;
        int digit = 0;
        int counter = 1;

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] == numbers[i - 1]) {
                counter++;

                if (counter > maxCount) {
                    maxCount = counter;
                    digit = numbers[i];
                }
            } else
                counter = 1;
        }

        for (int i = 0; i < maxCount; i++) {
            System.out.print(digit + " ");
        }
    }
}
