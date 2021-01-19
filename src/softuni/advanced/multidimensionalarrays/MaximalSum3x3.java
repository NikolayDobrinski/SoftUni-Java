package softuni.advanced.multidimensionalarrays;

import java.util.Scanner;

/**Description:
 * Program that reads a rectangular integer matrix of size N x M and finds
 * in it the square 3 x 3 that has maximal sum of its elements.
 */

public class MaximalSum3x3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int m = scan.nextInt();
        System.out.println();

        int[][] matrix = new int[n][m];

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                matrix[row][col] = scan.nextInt();
            }
            System.out.println();
        }

        int maxSum = Integer.MIN_VALUE;
        int[][] output = new int[3][3];

        for (int row = 0; row < matrix.length - 2; row++) {
            int[][] current = new int[3][3];

            for (int col = 0; col < matrix[row].length - 2; col++) {

                int currentSum = 0;

                current[0][0] = matrix[row][col];
                current[0][1] = matrix[row][col + 1];
                current[0][2] = matrix[row][col + 2];

                current[1][0] = matrix[row + 1][col];
                current[1][1] = matrix[row + 1][col + 1];
                current[1][2] = matrix[row + 1][col + 2];

                current[2][0] = matrix[row + 2][col];
                current[2][1] = matrix[row + 2][col + 1];
                current[2][2] = matrix[row + 2][col + 2];

                for (int currRow = 0; currRow < current.length; currRow++) {
                    for (int currCol = 0; currCol < current.length; currCol++) {
                        currentSum += current[currRow][currCol];
                    }
                }

                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    for (int i = 0; i < output.length; i++) {
                        for (int j = 0; j < output.length; j++) {
                            output[i][j] = current[i][j];
                        }
                        System.out.println();
                    }
                }
            }
        }

        System.out.println("Sum = " + maxSum);
        for (int i = 0; i < output.length; i++) {
            for (int j = 0; j < output.length; j++) {
                System.out.print(output[i][j] + " ");
            }
            System.out.println();
        }

    }
}
