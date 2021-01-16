package softuni.advanced.multidimensionalarrays;

import java.util.Scanner;

/**Description:
 * Program that reads a matrix of integers from the console, then a number and prints all
 * the positions at which that number appears in the matrix.
 */

public class PositionsOf {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rows = scan.nextInt();
        int cols = scan.nextInt();

        System.out.println();

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scan.nextInt();
            }
            System.out.println();
        }

        int numberToFind = scan.nextInt();

        boolean isFound = false;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == numberToFind) {
                    System.out.println(i + " " + j);
                    isFound = true;
                }
            }
        }
        if (!isFound) {
            System.out.println("not found");
        }
    }
}
