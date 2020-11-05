package softuni.fundamentals.exercise.fundamentals;

import java.util.Scanner;

public class Division {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int number = Integer.parseInt(scan.nextLine());
        int bigestDivider = 0;

        if (number % 2 == 0) {
            bigestDivider = 2;
        }
        if (number % 3 == 0) {
            bigestDivider = 3;
        }
        if (number % 6 == 0) {
            bigestDivider = 6;
        }
        if (number % 7 == 0) {
            bigestDivider = 7;
        }
        if (number % 10 == 0) {
            bigestDivider = 10;
        }
        if (bigestDivider != 0) {
            System.out.printf("The number is divisible by %d", bigestDivider);
        } else {
            System.out.printf("Not divisible");
        }


    }
}
