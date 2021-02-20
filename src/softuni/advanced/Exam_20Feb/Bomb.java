package softuni.advanced.Exam_20Feb;

import java.util.Scanner;

/** Description:
 * We will be given the size of the square matrix /the field/ in which our sapper moves.
 * After that we receive the commands witch represent the directions in which the sapper should move.
 * The possible characters that may appear on the field are: e – end of the route, B – bomb,
 * s – the place where the sapper starts. Each time we find a bomb, count the bomb and we have
 * to print the following message: "You found a bomb!". If sapper steps at the end of the route /e/
 * game is over (the program stops) and we have to print the output.
 * After executing all of the commands we have to print the output.
 */

public class Bomb {

    static int startRow = 0;
    static int startCol = 0;
    static int totalNumberBombs = 0;
    static int bombsFound = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int size = Integer.parseInt(scan.nextLine());

        String[] commands = scan.nextLine().split(",");

        String[][] matrix = new String[size][size];

        for (int row = 0; row < matrix.length; row++) {
            String[] line = scan.nextLine().split("\\s+");
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = line[col];
                if (line[col].equals("s")) {
                    startRow = row;
                    startCol = col;
                } else if (line[col].equals("B")) {
                    totalNumberBombs++;
                }
            }
        }
        boolean isAlive = true;

        for (int i = 0; i < commands.length; i++) {

            if (commands[i].equals("up")) {
                isAlive = move(startRow - 1, startCol, matrix);
            } else if (commands[i].equals("down")) {
                isAlive = move(startRow + 1, startCol, matrix);
            } else if (commands[i].equals("left")) {
                isAlive = move(startRow, startCol - 1, matrix);
            } else if (commands[i].equals("right")) {
                isAlive = move(startRow, startCol + 1, matrix);
            }

            if (!isAlive) {
                break;
            }
            if (totalNumberBombs - bombsFound == 0) {
                break;
            }
        }

        if (totalNumberBombs - bombsFound == 0) {
            System.out.println("Congratulations! You found all bombs!");
        }
        if (!isAlive) {
            int bombsLeft = totalNumberBombs - bombsFound;
            System.out.printf("END! %d bombs left on the field%n", bombsLeft);
        }
        if (totalNumberBombs - bombsFound > 0 && isAlive) {
            int bombsLeft = totalNumberBombs - bombsFound;
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)", bombsLeft, startRow, startCol);
        }
    }

    private static boolean move(int newRow, int newCol, String[][] matrix) {
        matrix[startRow][startCol] = "+";

        if (isWithinMatrix(newRow, newCol, matrix)) {

            startRow = newRow;
            startCol = newCol;

            String symbol = matrix[startRow][startCol];

            if (symbol.equals("e")) {
                return false;
            } else if (symbol.equals("B")) {
                bombsFound++;
                System.out.println("You found a bomb!");
            }

            matrix[startRow][startCol] = "s";
        } else {

            matrix[startRow][startCol] = "s";
        }
        return true;
    }

    private static boolean isWithinMatrix(int row, int col, String[][] matrix) {
        if (row < matrix.length && row >= 0 && col < matrix.length && col >= 0) {
            return true;
        } else {
            return false;
        }
    }
}
