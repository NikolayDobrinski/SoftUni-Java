package softuni.fundamentals.exercise.dbvariables;

import java.util.Scanner;

public class PrintPartoftheASCIITable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        int m = Integer.parseInt(scan.nextLine());

        for (int i = n; i <= m; i++) {
            System.out.print((char) i + " ");
        }
    }
}
