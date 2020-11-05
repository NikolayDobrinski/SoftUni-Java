package softuni.fundamentals.methodsexercise;

import java.util.Scanner;

public class SmallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int a = Integer.parseInt(scan.nextLine());
        int b = Integer.parseInt(scan.nextLine());
        int c = Integer.parseInt(scan.nextLine());

        int smallerNumber = findSmallerNumber(a, b);
        int smallestNumber = findSmallerNumber(smallerNumber, c);
        System.out.println(smallestNumber);
    }

    private static int findSmallerNumber(int a, int b) {
        if (a < b) {
            return a;
        }
        return b;
    }
}
