package softuni.fundamentals.methodslab;

import java.util.Scanner;

public class Calculations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String action = scan.nextLine();
        int digitOne = Integer.parseInt(scan.nextLine());
        int digitTwo = Integer.parseInt(scan.nextLine());

        if (action.equals("add")) {
            addTwoDigits(digitOne, digitTwo);
        } else if (action.equals("multiply")) {
            multiplyTwoDigits(digitOne, digitTwo);
        } else if (action.equals("subtract")) {
            subtractTwoDigits(digitOne, digitTwo);
        } else if (action.equals("divide")) {
            divideTwoDigits(digitOne, digitTwo);
        }

    }

    private static void divideTwoDigits(int a, int b) {
        int result = a / b;
        System.out.println(result);
    }

    private static void subtractTwoDigits(int a, int b) {
        int result = a / b;
        System.out.println(result);
    }

    private static void multiplyTwoDigits(int a, int b) {
        int result = a * b;
        System.out.println(result);
    }

    private static void addTwoDigits(int a, int b) {
        int result = a + b;
        System.out.println(result);
    }
}
