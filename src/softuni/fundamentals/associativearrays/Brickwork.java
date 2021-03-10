package softuni.fundamentals.associativearrays;

import java.util.Scanner;

public class Brickwork {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //I read the dimensions for N and M from the console
        int rowsN = scan.nextInt();
        int colsM = scan.nextInt();

        //determine the number of all bricks
        int allBricks = (rowsN * colsM) / 2;

        //declaring and initializing two arrays for input and output with same sizes - rowsN x colsM
        int[][] input = new int[rowsN][colsM];
        int[][] output = new int[rowsN][colsM];

        //reading the first row of bricks that is given ready and saving the numbers in the input array
        for (int row = 0; row < rowsN; row++) {
            for (int col = 0; col < colsM; col++) {

                input[row][col] = scan.nextInt();
            }
        }

        //checking if the input data for rowsN and colsM are valid
        boolean isValid = rowsN < 100 && rowsN % 2 == 0 && colsM < 100 && colsM % 2 == 0;

        //while the bricks are more than zero we check each odd row for two adjacent identical numbers
        if (isValid) {
            while (allBricks > 0) {

                //traversing all rows and columns with two nested for loops
                for (int row = 0; row < input.length; row++) {
                    for (int col = 0; col < input[0].length; col++) {

                        //if the columns are before the last column
                        if (col < input[0].length - 1) {

                            // 1. if the row is odd I go around the row in the input array and where I meet two
                            // adjacent identical numbers I put a brick vertically, and where the numbers are
                            // different - I put a brick horizontally
                            if ((row + 1) % 2 != 0) {

                                //- if the two adjacent numbers are equal - I put a brick vertically
                                if (input[row][col] == input[row][col + 1]) {
                                    output[row][col] = allBricks;
                                    output[row + 1][col] = allBricks;
                                    allBricks--;

                                    //- if the two adjacent numbers are NOT equal - I put a brick horizontally
                                    // and skip a column
                                } else if (input[row][col] != input[row][col + 1]) {
                                    output[row][col] = allBricks;
                                    output[row][col + 1] = allBricks;
                                    allBricks--;
                                    col++;
                                }

                            } //2. if the row is even I go around this row in the output array and where
                            // there are two adjacent zeros left I replace them with bricks.
                            else if ((row + 1) % 2 == 0) {

                                for (int colOut = 0; colOut < output[0].length - 1; colOut++) {

                                    if (output[row][colOut] == output[row][colOut + 1]) {
                                        output[row][colOut] = allBricks;
                                        output[row][colOut + 1] = allBricks;
                                        allBricks--;
                                        colOut++;
                                    }
                                    if (allBricks == 0) {
                                        break;
                                    }
                                }
                                break;
                            }
                            //3. if the column is last and there is nothing to compare the last number with -
                            // I put a brick vertically
                        } else if (col < input[0].length) {
                            output[row][col] = allBricks;
                            output[row + 1][col] = allBricks;
                            allBricks--;
                        }
                        if (allBricks == 0) {
                            break;
                        }
                    }
                    if (allBricks == 0) {
                        break;
                    }
                }
            }

            //I print the output array of the console, checking two adjacent numbers to see if they
            // are the same - if they are - I put a blank space, if they are - I put a space
            // between them, if they are NOT - I put an asterisk.
            for (int row = 0; row < output.length; row++) {
                for (int col = 0; col < output[0].length; col++) {
                    System.out.printf("%d", output[row][col]);

                    if (col < output[0].length - 1) {
                        if (output[row][col] != output[row][col + 1]) {
                            System.out.print("*");
                        } else {
                            System.out.print(" ");
                        }
                    }
                }
                System.out.println();
            }
        } else {
            System.out.println("-1");
            System.out.print("No solution exists!");
        }
    }
}
