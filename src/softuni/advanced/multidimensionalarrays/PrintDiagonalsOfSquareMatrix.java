package softuni.advanced.multidimensionalarrays;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Description:
 * Program that reads a matrix from the console and prints the diagonals of it.
 * The matrix will always be square.
 */

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int size = Integer.parseInt(scan.nextLine());

        int[][] matrix = new int[size][size];

        //reading the matrix from the console

        for (int rows = 0; rows < size; rows++) {
            matrix[rows] = Arrays.stream(scan.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }

        // printing the left diagonal

        for (int index = 0; index < size; index++) {
            System.out.print(matrix[index][index] + " ");
        }
        System.out.println();

        //printing the right diagonal

        for (int index = 0; index < size; index++) {
            System.out.print(matrix[(size - 1) - index][index] + " ");
        }

    }
}
