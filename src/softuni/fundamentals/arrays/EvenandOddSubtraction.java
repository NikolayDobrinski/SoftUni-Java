package softuni.fundamentals.arrays;

import java.util.Scanner;

public class EvenandOddSubtraction {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String array = scan.nextLine();
        String[] arrayNumbers = array.split(" ");

        int[] numbers = new int[arrayNumbers.length];
        int oddSum = 0;
        int evenSum = 0;

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(arrayNumbers[i]);
        }
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                evenSum += numbers[i];
            } else {
                oddSum += numbers[i];
            }
        }
        System.out.println(evenSum - oddSum);
    }
}
