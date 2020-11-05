package softuni.fundamentals.methodslab;

import java.util.Scanner;

public class SignofIntegerNumbers {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int input = Integer.parseInt(scan.nextLine());

        printSign(input);
    }

    private static Integer printSign(int input) {
        if (input > 0) {
            System.out.printf("The number %d is positive.", input);
        } else if (input < 0) {
            System.out.printf("The number %d is negative.", input);
        } else {
            System.out.println("The number 0 is zero.");
        }
        return input;
    }
}
