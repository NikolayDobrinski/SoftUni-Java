package softuni.advanced.multidimensionalarrays;

import java.util.Scanner;

/**Description:
 * Write two methods that fill a matrix of size N x N in two different patterns. Both patterns are described below:
 *
 * Pattern A	Pattern B
 * 1 5 9  13    1 8 9  16
 * 2 6 10 14    2 7 10 15
 * 3 7 11 15    3 6 11 14
 * 4 8 12 16    4 5 12 13
 */

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split(", ");
        int n = Integer.parseInt(input[0]);
        String patternType = input[1];

        int[][] matrix = new int[n][n];

        if ("A".equals(patternType)) {

            matrix = fillMatrixPatternA(n);

        } else if ("B".equals(patternType)) {

            matrix = fillMatrixPatternB(n);

        }

        printMatrix(matrix);
    }

    private static int[][] fillMatrixPatternB(int n) {
        int[][] matrix = new int[n][n];
        int startingDigit = 1;
        for (int col = 0; col < n; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < n; row++) {
                    matrix[row][col] = startingDigit++;
                }
            } else {
                for (int row = matrix.length - 1; row >= 0; row--) {
                    matrix[row][col] = startingDigit++;
                }
            }
        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] fillMatrixPatternA(int n) {
        int[][] matrix = new int[n][n];
        int startingDigit = 1;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                matrix[col][row] = startingDigit++;
            }
        }


        return matrix;
    }
}