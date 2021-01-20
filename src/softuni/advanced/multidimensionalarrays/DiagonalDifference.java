package softuni.advanced.multidimensionalarrays;

import java.util.Scanner;

/**Description:
 * Program that finds the difference between the sums of the square matrix diagonals (absolute value).
 */

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        int[][] matrix = new int[n][n];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                matrix[row][col] = scan.nextInt();
            }
            scan.nextLine();
        }

        int primaryDiagonal = 0;

        for (int i = 0; i < matrix.length; i++) {
            primaryDiagonal += matrix[i][i];
        }

        int secondaryDiagonal = 0;

        for (int i = matrix.length - 1; i >= 0; i--) {
            secondaryDiagonal += matrix[i][matrix.length - 1 - i];
        }

        System.out.println(Math.abs(primaryDiagonal - secondaryDiagonal));

    }
}
