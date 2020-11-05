package softuni.fundamentals.labs.dbvariables;

import java.util.Scanner;

public class EqualSides {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        String[] array = input.split(" ");
        int[] arr = new int[array.length];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(array[i]);
        }

        boolean isEquals = false;

        for (int i = 0; i < arr.length; i++) {
            int leftSum = 0;
            int rightSum = 0;

            for (int j = i - 1; j >= 0; j--) {
                leftSum += arr[j];
            }
            for (int j = i + 1; j < arr.length; j++) {
                rightSum += arr[j];
            }
            if (leftSum == rightSum) {
                isEquals = true;
                System.out.println(i);
                break;
            }
        }
        if (!isEquals) {
            System.out.print("-1");
        }

    }
}
