package softuni.fundamentals.methodsexercise;

import java.util.Scanner;

public class AddAndSubtract {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int a = Integer.parseInt(scan.nextLine());
        int b = Integer.parseInt(scan.nextLine());
        int c = Integer.parseInt(scan.nextLine());

        int resultOne = sumBetweenTwoDigits(a, b);
        int resultTwo = subtractBetweenTwoDigits(resultOne, c);

        System.out.println(resultTwo);

    }

    private static int subtractBetweenTwoDigits(int x, int z) {
        int result = x - z;
        return result;
    }

    private static int sumBetweenTwoDigits(int a, int b) {
        int result = a + b;
        return result;

    }
}
