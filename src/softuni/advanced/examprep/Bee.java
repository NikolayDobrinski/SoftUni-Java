package softuni.advanced.examprep;

import java.util.Scanner;

/** Description:
 * We will be given the size of the square matrix representing bee territory. The bee will be placed
 * on a random position, marked with the letter 'B'. On random positions there will be flowers,
 * marked with 'f' and bonus marked with 'O' on the territory.
 * Will be given commands for the bee’s movement - "up", "down", "left", "right", "End". If the bee
 * moves to a flower, it pollinates the flower and increase pollinated flowers with one. If it goes
 * to a bonus, the bee gets a bonus one move forward and then the bonus disappears. If the bee goes
 * out of the territory or we receive command End - the program ends. The bee needs at least 5
 * pollinated flowers.
 */

public class Bee {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int size = Integer.parseInt(scan.nextLine());

        char[][] matrix = new char[size][size];

        int startRow = 0;
        int startCol = 0;
        int pollinatedFlowers = 0;

        for (int row = 0; row < matrix.length; row++) {
            String line = scan.nextLine();
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row] = line.toCharArray();
                if (line.contains("B")) {
                    startRow = row;
                    startCol = line.indexOf("B");
                }
            }
        }

        boolean gotLost = false;

        String command = scan.nextLine();

        while (!command.equals("End")) {

            matrix[startRow][startCol] = '.';

            if (command.equals("up")) {

                startRow = startRow - 1;

                if (newPositionIsValid(startRow, startCol, matrix)) {

                    if (matrix[startRow][startCol] == 'f') {
                        pollinatedFlowers++;

                    } else if (matrix[startRow][startCol] == 'O') {
                        matrix[startRow][startCol] = '.';
                        startRow = startRow - 1;

                        if (newPositionIsValid(startRow, startCol, matrix)) {

                            if (matrix[startRow][startCol] == 'f') {
                                pollinatedFlowers++;
                            }
                        }
                        else {
                            gotLost = true;
                            break;
                        }
                    }
                    matrix[startRow][startCol] = 'B';
                } else {
                    gotLost = true;
                    break;
                }
            } else if (command.equals("down")) {

                startRow = startRow + 1;

                if (newPositionIsValid(startRow, startCol, matrix)) {

                    if (matrix[startRow][startCol] == 'f') {
                        pollinatedFlowers++;
                    } else if (matrix[startRow][startCol] == 'O') {
                        matrix[startRow][startCol] = '.';
                        startRow = startRow + 1;

                        if (newPositionIsValid(startRow, startCol, matrix)) {

                            if (matrix[startRow][startCol] == 'f') {
                                pollinatedFlowers++;
                            }
                        } else {
                            gotLost = true;
                            break;
                        }
                    }
                    matrix[startRow][startCol] = 'B';
                } else {
                    gotLost = true;
                    break;
                }
            } else if (command.equals("left")) {

                startCol = startCol - 1;

                if (newPositionIsValid(startRow, startCol, matrix)) {

                    if (matrix[startRow][startCol] == 'f') {
                        pollinatedFlowers++;
                    } else if (matrix[startRow][startCol] == 'O') {
                        matrix[startRow][startCol] = '.';
                        startCol = startCol - 1;

                        if (newPositionIsValid(startRow, startCol, matrix)) {

                            if (matrix[startRow][startCol] == 'f') {
                                pollinatedFlowers++;
                            }
                        } else {
                            gotLost = true;
                            break;
                        }
                    }
                    matrix[startRow][startCol] = 'B';
                } else {
                    gotLost = true;
                    break;
                }
            } else if (command.equals("right")) {

                startCol = startCol + 1;

                if (newPositionIsValid(startRow, startCol, matrix)) {

                    if (matrix[startRow][startCol] == 'f') {
                        pollinatedFlowers++;
                    } else if (matrix[startRow][startCol] == 'O') {
                        matrix[startRow][startCol] = '.';
                        startCol = startCol + 1;

                        if (newPositionIsValid(startRow, startCol, matrix)) {

                            if (matrix[startRow][startCol] == 'f') {
                                pollinatedFlowers++;
                            }
                        } else {
                            gotLost = true;
                            break;
                        }
                    }
                    matrix[startRow][startCol] = 'B';
                } else {
                    gotLost = true;
                    break;
                }
            }
            command = scan.nextLine();
        }

        if (gotLost) {
            System.out.println("The bee got lost!");
        }

        if (pollinatedFlowers < 5) {
            int flowersNeeded = 5 - pollinatedFlowers;
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", flowersNeeded);
        } else {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", pollinatedFlowers);
        }

        for (int rows = 0; rows < matrix.length; rows++) {
            for (int cols = 0; cols < matrix[rows].length; cols++) {
                System.out.print(matrix[rows][cols]);
            }
            System.out.println();
        }
    }

    private static boolean newPositionIsValid(int row, int col, char[][] matrix) {
        if (row < matrix.length && row >= 0 && col < matrix.length && col >= 0) {
            return true;
        }
        else {
            return false;
        }
    }
}
