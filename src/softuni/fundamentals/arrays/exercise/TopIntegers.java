package softuni.fundamentals.arrays.exercise;

import java.util.Scanner;

public class TopIntegers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split(" ");
        int[] arr = new int[input.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            boolean isGreater = true;
            int current = arr[i];
            for (int j = i + 1; j < arr.length; j++) {

                if (current <= arr[j]) {
                    isGreater = false;
                }
            }
            if (isGreater) {
                System.out.print(arr[i] + " ");
            }
        }
    }
}
