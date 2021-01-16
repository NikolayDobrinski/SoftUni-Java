package softuni.advanced.multidimensionalarrays;

import java.util.Scanner;

/**Description:
 * Program that reads two integer matrices from the console and compares them element by element.
 */

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rowsMatrix1 = scan.nextInt();
        int colsMatrix1 = scan.nextInt();

        System.out.println();

        int[][] firstMatrix = readMatrixFromConsole(scan, rowsMatrix1, colsMatrix1);


        System.out.println();

        int rowsMatrix2 = scan.nextInt();
        int colsMatrix2 = scan.nextInt();

        int[][] secondMatrix = readMatrixFromConsole(scan, rowsMatrix2, colsMatrix2);

        if (rowsMatrix1 == rowsMatrix2 && colsMatrix1 == colsMatrix2) {

            boolean areEqual = compareMatrices(rowsMatrix1, colsMatrix1, firstMatrix, secondMatrix);


            if (areEqual) {
                System.out.println("equal");
            }
        } else {
            System.out.println("not equal");
        }
    }

    public static int[][] readMatrixFromConsole(Scanner scan, int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scan.nextInt();
            }
            System.out.println();
        }
        return matrix;
    }

    private static boolean compareMatrices(int rows, int cols, int[][] firstMatrix, int[][] secondMatrix) {

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (firstMatrix[i][j] != secondMatrix[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
