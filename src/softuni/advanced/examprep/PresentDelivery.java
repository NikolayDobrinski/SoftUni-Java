package softuni.advanced.examprep;

import java.util.Scanner;

/** Description:
 * We are given m - number ot presents, and n - size of square matrix representing the neighborhood.
 * Santa will be in a random cell, marked with the letter 'S'. Each cell stands for a house.
 * If the cell has 'X' on it, that means there lives a naughty kid. Otherwise, if a nice kid lives there,
 * the cell is marked by 'V'. There can aslo be cells marked with 'C' for cookies. Santa will receive commands
 * to move "up", "down", "left", "right". If he moves to a house with a nice kid, the kid receives a present.
 * If the command sends Santa to a cell marked with 'C', all the kids around him (means on his left, right,
 * upwards and downwards by one cell) receive presents (doesn’t matter if naughty or nice).
 * If Santa runs out of presents or we receive the command "Christmas morning", then we have to end the program.
 */

public class PresentDelivery {
    static int startRow = 0;
    static int startCol = 0;
    static int totalNiceKids = 0;
    static int govenToNiceKid = 0;
    static int givenToNaughtyKids = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numberPresents = Integer.parseInt(scan.nextLine());

        int size = Integer.parseInt(scan.nextLine());

        String[][] matrix = new String[size][size];

        for (int row = 0; row < matrix.length; row++) {
            String[] line = scan.nextLine().split("\\s+");
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = line[col];
                if (line[col].equals("S")) {
                    startRow = row;
                    startCol = col;
                } else if (line[col].equals("V")) {
                    totalNiceKids++;
                }
            }
        }

        String command = scan.nextLine();
        boolean isOutOfPresents = false;

        while (!command.equals("Christmas morning")) {

            if (command.equals("up")) {
                move(startRow - 1, startCol, matrix);
            }
            else if (command.equals("down")) {
                move(startRow + 1, startCol, matrix);
            }
            else if (command.equals("left")) {
                move(startRow, startCol - 1, matrix);
            }
            else if (command.equals("right")) {
                move(startRow, startCol + 1, matrix);
            }

            if (numberPresents - (givenToNaughtyKids + govenToNiceKid) <= 0) {
                isOutOfPresents = true;
                break;
            }
            command = scan.nextLine();
        }

        if (isOutOfPresents) {
            System.out.println("Santa ran out of presents!");
        }

        printMatrix(matrix);

        if (totalNiceKids - govenToNiceKid <= 0) {
            System.out.printf("Good job, Santa! %d happy nice kid/s.", totalNiceKids);
        } else {
            int vCount = 0;
            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix.length; col++) {
                    if (matrix[row][col].equals("V")) {
                        vCount++;
                    }
                }
            }
            System.out.printf("No presents for %d nice kid/s.", vCount);
        }
    }

    private static boolean move(int newRow, int newCol, String[][] matrix) {
        matrix[startRow][startCol] = "-";

        startRow = newRow;
        startCol = newCol;

        if (isWithinMatrix(startRow, startCol, matrix)) {
            if (matrix[startRow][startCol].equals("V")) {
                govenToNiceKid++;

            } else if (matrix[startRow][startCol].equals("C")) {

                if (matrix[startRow + 1][startCol].equals("V") || matrix[startRow + 1][startCol].equals("X")) {
                    if (matrix[startRow + 1][startCol].equals("V")) {
                        govenToNiceKid++;
                    } else {
                        givenToNaughtyKids++;
                    }

                    matrix[startRow + 1][startCol] = "-";
                }
                if (matrix[startRow - 1][startCol].equals("V") || matrix[startRow - 1][startCol].equals("X")) {
                    if (matrix[startRow - 1][startCol].equals("V")) {
                        govenToNiceKid++;
                    } else {
                        givenToNaughtyKids++;
                    }

                    matrix[startRow - 1][startCol] = "-";
                }
                if (matrix[startRow][startCol + 1].equals("V") || matrix[startRow][startCol + 1].equals("X")) {
                    if (matrix[startRow][startCol + 1].equals("V")) {
                        govenToNiceKid++;
                    } else {
                        givenToNaughtyKids++;
                    }

                    matrix[startRow][startCol + 1] = "-";
                }
                if (matrix[startRow][startCol - 1].equals("V") || matrix[startRow][startCol - 1].equals("X")) {
                    if (matrix[startRow][startCol - 1].equals("V")) {
                        govenToNiceKid++;
                    } else {
                        givenToNaughtyKids++;
                    }
                    matrix[startRow][startCol - 1] = "-";
                }
            }
            matrix[startRow][startCol] = "S";

        } else {
            return false;
        }
        return true;
    }

    private static void printMatrix(String[][] matrix) {
        for (int rows = 0; rows < matrix.length; rows++) {
            for (int cols = 0; cols < matrix[rows].length; cols++) {
                System.out.print(matrix[rows][cols] + " ");
            }
            System.out.println();
        }
    }

    private static boolean isWithinMatrix(int row, int col, String[][] matrix) {
        if (row < matrix.length && row >= 0 && col < matrix.length && col >= 0) {
            return true;
        } else {
            return false;
        }
    }
}
