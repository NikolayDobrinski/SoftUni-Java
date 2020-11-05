package softuni.fundamentals.arrays;

import java.util.Scanner;

public class EqualArrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] arrayOne = scan.nextLine().split(" ");
        int[] arrayOneInt = new int[arrayOne.length];
        for (int i = 0; i < arrayOneInt.length; i++) {
            arrayOneInt[i] = Integer.parseInt(arrayOne[i]);
        }

        String[] arrayTwo = scan.nextLine().split(" ");
        int[] arrayTwoInt = new int[arrayTwo.length];
        for (int i = 0; i < arrayTwoInt.length; i++) {
            arrayTwoInt[i] = Integer.parseInt(arrayTwo[i]);
        }
        boolean notEqual = false;
        int counter = 0;

        if (arrayOneInt.length == arrayTwoInt.length) {

            for (int i = 0; i < arrayOneInt.length; i++) {

                if (arrayOneInt[i] != arrayTwoInt[i]) {
                    notEqual = true;
                    counter = i;
                    break;
                }
            }
        }
        if (notEqual) {
            System.out.printf("softuni.fundamentals.Arrays are not identical. Found difference at %d index.", counter);
        } else {
            int sum = 0;
            for (int i = 0; i < arrayOneInt.length; i++) {
                sum += arrayOneInt[i];
            }
            System.out.printf("softuni.fundamentals.Arrays are identical. Sum: %d", sum);
        }

    }
}
