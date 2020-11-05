package softuni.fundamentals.easy;

import java.util.Scanner;

public class BiggerNumber {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] numbers = {13, 11, 10, 3, 2, 1, 4, 5, 6, 9, 7, 8};

        int biggestNumber = Integer.MIN_VALUE;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > biggestNumber) {
                biggestNumber = numbers[i];
            }
        }
        int expectedSum = biggestNumber * ((biggestNumber + 1) / 2);

        int arraySum = 0;

        for (int i = 0; i < numbers.length; i++) {
            arraySum += numbers[i];
        }

        int missingNumber = expectedSum - arraySum;

        System.out.println(missingNumber);


    }
}
