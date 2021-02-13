package softuni.advanced.examprep;

import java.util.Scanner;

/** Description:
 * We will be given a matrix with square shape n x n. We will be placed on a random position, marked with
 * the letter 'S'. On random positions there will be digits and pillars. We will be given commands representing
 * our movement - "up", "down", "left", "right". If we move to a digit, we collects the money equal to the digit.
 * If we move to a pillar, we move on the position of the other pillar /they will be 0 or 2/ and then both pillars
 * disappear. If we go out of the matrix, we disappear and we are out of there. When we are out of the matrix or
 * we collect more than 50 money, the program ends.
 */

public class Selling {

    static int startRow = 0;
    static int startCol = 0;
    static int money = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int size = Integer.parseInt(scan.nextLine());

        char[][] matrix = new char[size][size];

        for (int row = 0; row < size; row++) {
            String newRow = scan.nextLine();
            for (int col = 0; col < size; col++) {
                matrix[row] = newRow.toCharArray();

                if (newRow.contains("S")) {
                    startRow = row;
                    startCol = newRow.indexOf("S");
                }
            }
        }

        boolean isWithinMatrix = true;

        while (money < 50 && isWithinMatrix) {

            String command = scan.nextLine();

            if (command.equals("up")) {
                isWithinMatrix = move(startRow - 1, startCol, matrix);
            } else if (command.equals("down")) {
                isWithinMatrix = move(startRow + 1, startCol, matrix);
            } else if (command.equals("left")) {
                isWithinMatrix = move(startRow, startCol - 1, matrix);
            } else if (command.equals("right")) {
                isWithinMatrix = move(startRow, startCol + 1, matrix);
            }
        }

        String message = !isWithinMatrix
                ? "Bad news, you are out of the bakery."
                : "Good news! You succeeded in collecting enough money!";

        System.out.println(message);
        System.out.println("Money: " + money);

        System.out.println(printMatrix(matrix));
    }

    private static String printMatrix(char[][] matrix) {
        StringBuilder out = new StringBuilder();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                out.append(matrix[row][col]);
            }
            out.append(System.lineSeparator());
        }
        return out.toString();
    }

    private static boolean move(int newRow, int newCol, char[][] matrix) {
        matrix[startRow][startCol] = '-';

        if (isOutOfBounds(newRow, newCol, matrix)) {
            return false;
        }
        char symbol = matrix[newRow][newCol];

        if (Character.isDigit(symbol)) {
            money += symbol - '0';
        } else if (symbol == 'O') {
            matrix[newRow][newCol] = '-';

            int[] secondPillarLocation = findSecondPillar(matrix);

            newRow = secondPillarLocation[0];
            newCol = secondPillarLocation[1];
        }
        matrix[newRow][newCol] = 'S';

        startRow = newRow;
        startCol = newCol;

        return true;
    }

    private static int[] findSecondPillar(char[][] matrix) {
        int[] indexes = null;

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == 'O') {
                    indexes = new int[]{r, c};
                    break;
                }
            }
            if (indexes != null) {
                break;
            }
        }
        return indexes;
    }

    private static boolean isOutOfBounds(int row, int col, char[][] matrix) {
        return row >= matrix.length || row < 0 || col >= matrix.length || col < 0;
    }
}
