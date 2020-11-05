package softuni.fundamentals.arrays;

import java.util.Scanner;

public class SumEvenNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        String input = scan.nextLine();
        int oddSum = 0;

        String[] splitedInput = input.split(" ");
        int[] inputNumbers = new int[splitedInput.length];

        for (int i = 0; i < inputNumbers.length; i++) {
            inputNumbers[i] = Integer.parseInt(splitedInput[i]);
        }
        for (int i = 0; i < inputNumbers.length; i++) {
            int current = inputNumbers[i];


            if (current % 2 == 0) {
                oddSum += current;
            }
        }

        System.out.println(oddSum);
    }
}
