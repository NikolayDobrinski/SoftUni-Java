package softuni.advanced.multidimensionalarrays;

import java.util.Scanner;

/**Description:
 * Program which reads a string matrix from the console and performs certain operations with its elements.
 */

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int m = scan.nextInt();

        System.out.println();
        scan.nextLine();

        String[][] matrix = new String[n][m];

        for (int row = 0; row < n; row++) {
            String[] currentRow = scan.nextLine().split("\\s+");
            for (int col = 0; col < currentRow.length; col++) {
                matrix[row][col] = currentRow[col];
            }
        }

        String command = scan.nextLine();

        while (!command.equals("END")) {
            String[] line = command.split("\\s+");

            if (line.length < 5 || line.length > 5) {
                System.out.println("Invalid input!");

            } else {

                String swap = line[0];
                int row1 = Integer.parseInt(line[1]);
                int col1 = Integer.parseInt(line[2]);
                int row2 = Integer.parseInt(line[3]);
                int col2 = Integer.parseInt(line[4]);

                if (!swap.equals("swap") || line.length < 5 || line.length > 5 || row1 > n || row2 > n || col1 > m || col2 > m) {
                    System.out.println("Invalid input!");

                } else {
                    String temporary = matrix[row1][col1];
                    matrix[row1][col1] = matrix[row2][col2];
                    matrix[row2][col2] = temporary;

                    for (int i = 0; i < matrix.length; i++) {
                        for (int j = 0; j < matrix[i].length; j++) {
                            System.out.print(matrix[i][j] + " ");
                        }
                        System.out.println();
                    }
                }
            }

            command = scan.nextLine();

        }

    }
}
