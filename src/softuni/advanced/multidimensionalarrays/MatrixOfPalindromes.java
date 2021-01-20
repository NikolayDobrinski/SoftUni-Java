package softuni.advanced.multidimensionalarrays;

import java.util.Scanner;

/**
 * Write a program to generate the following matrix of palindromes of 3 letters with r rows and c columns.
 */

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int r = scan.nextInt();
        int c = scan.nextInt();

        scan.nextLine();

        String[][] matrix = new String[r][c];

        int index = 0;

        for (int i = 0; i < matrix.length; i++) {
            char start = 97;

            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = "" + ((char) (start + i)) + ((char) (start + j + index)) + ((char) (start + i));
            }
            System.out.println();
            index++;
        }
        for (int k = 0; k < matrix.length; k++) {
            for (int l = 0; l < matrix[k].length; l++) {
                System.out.print(matrix[k][l] + " ");
            }
            System.out.println();
        }
    }
}
