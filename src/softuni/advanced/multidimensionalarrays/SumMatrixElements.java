package softuni.advanced.multidimensionalarrays;

import java.util.Scanner;

/**Description:
 * Program that reads a matrix from the console and prints:
 * The count of rows
 * The count of columns
 * The sum of all matrix’s elements
 */

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] rowsAndCols = scan.nextLine().split(", ");

        int rows = Integer.parseInt(rowsAndCols[0]);
        int cols = Integer.parseInt(rowsAndCols[1]);

        int sum = 0;

        for (int i = 0; i < rows; i++) {
            String[] current = scan.nextLine().split(", ");
            for (int j = 0; j < current.length; j++) {
                sum += Integer.parseInt(current[j]);
            }
        }

        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sum);


    }
}
