package softuni.fundamentals.methodsexercise;

import java.util.Scanner;

public class NxNMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        printNxNmatrix(n);
    }

    private static void printNxNmatrix(int n) {

        for (int row = 0; row < n; row++) {
            for (int column = 0; column < n; column++) {
                System.out.print(n + " ");
            }
            System.out.println();
        }

    }
}
