package softuni.fundamentals.arrays.exercise;

import java.util.Scanner;

public class HighestandLowest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] numbers = scan.nextLine().split(" ");
        int[] number = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            number[i] = Integer.parseInt(numbers[i]);
        }
        int highest = Integer.MIN_VALUE;
        int lowest = Integer.MAX_VALUE;

        for (int i = 0; i < number.length; i++) {
            if (number[i] > highest) {
                highest = number[i];
            }
        }
        for (int i = 0; i < number.length; i++) {
            if (number[i] < lowest) {
                lowest = number[i];
            }
        }
        String output = "" + highest + " " + lowest;
        System.out.println(output);

    }
}
