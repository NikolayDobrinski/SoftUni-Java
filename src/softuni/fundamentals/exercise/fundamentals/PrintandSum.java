package softuni.fundamentals.exercise.fundamentals;

import java.util.Scanner;

public class PrintandSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int startNumber = Integer.parseInt(scan.nextLine());
        int endNumber = Integer.parseInt(scan.nextLine());

        int sum = 0;

        for (int i = startNumber; i <= endNumber; i++) {
            System.out.printf("%d ", i);
            sum += i;
        }
        System.out.println();
        System.out.printf("Sum: %d", sum);


    }
}
