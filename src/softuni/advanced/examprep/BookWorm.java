package softuni.advanced.examprep;

import java.util.Scanner;

/** Description:
 * We will be given a string. Then, we will be given an integer N for the size of the matrix with square shape.
 * The player /P/ and letters will be placed on a random positions on the matrix. Then, we will be given commands
 * for the player’s movement. If he moves to a letter, he consumes it, concatеnates it to the initial string and
 * the letter disappears from the field. If he tries to move outside of the field, he is punished - he loses the
 * last letter in the string, if there are any, and the player’s position is not changed. When the command "end"
 * is received, stop the program, print all letters and the field.
 */

public class BookWorm {

    static int startRow = 0;
    static int startCol = 0;
    static String concatenatedLetters = "";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        concatenatedLetters = input;

        int size = Integer.parseInt(scan.nextLine());

        char[][] matrix = new char[size][size];

        for (int row = 0; row < matrix.length; row++) {
            String line = scan.nextLine();
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row] = line.toCharArray();
                if (line.contains("P")) {
                    startRow = row;
                    startCol = line.indexOf("P");
                }
            }
        }

        String command = scan.nextLine();

        while (!command.equals("end")) {

            if (command.equals("up")) {
                move(startRow - 1, startCol, matrix);
            } else if (command.equals("down")) {
                move(startRow + 1, startCol, matrix);
            } else if (command.equals("left")) {
                move(startRow, startCol - 1, matrix);
            } else if (command.equals("right")) {
                move(startRow, startCol + 1, matrix);
            }

            command = scan.nextLine();
        }

        System.out.println(concatenatedLetters);
        printMatrix(matrix);

    }

    private static boolean move(int newRow, int newCol, char[][] matrix) {
        matrix[startRow][startCol] = '-';

        if (isWithinMatrix(newRow, newCol, matrix)) {

            startRow = newRow;
            startCol = newCol;

            int currentChar = matrix[startRow][startCol];

            if (Character.isLetter(currentChar)) {
                concatenatedLetters += (char) currentChar;
            }

            matrix[startRow][startCol] = 'P';
        } else {
            if (!concatenatedLetters.isEmpty()) {
                concatenatedLetters = concatenatedLetters.substring(0, concatenatedLetters.length() - 1);
            }
            matrix[startRow][startCol] = 'P';
            return false;
        }
        return true;
    }

    private static void printMatrix(char[][] matrix) {
        for (int rows = 0; rows < matrix.length; rows++) {
            for (int cols = 0; cols < matrix[rows].length; cols++) {
                System.out.print(matrix[rows][cols]);
            }
            if (rows < matrix.length - 1) {
                System.out.println();
            }
        }
    }

    private static boolean isWithinMatrix(int row, int col, char[][] matrix) {
        if (row < matrix.length && row >= 0 && col < matrix.length && col >= 0) {
            return true;
        } else {
            return false;
        }
    }
}
