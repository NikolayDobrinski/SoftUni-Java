package softuni.advanced.examprep;

import java.util.Scanner;

/** Description:
 * We will be given an integer n for the size of the territory with square shape. On the next n lines, we will
 * receive the rows of the territory. The snake will be placed on a random position, marked with the letter 'S'.
 * There will also be food on random positions, marked with '*'. The territory may have lair. The lair will have
 * two burrows marked with the letter - 'B'. All of the empty positions will be marked with '-'.
 * Each turn, we will be given command for the snake’s movement. When the snake moves it leaves a trail marked with '.'
 * Move commands will be: "up", "down", "left", "right".
 * If the snake moves to a food, it will eat the food, which will increase food quantity with one.
 * If it goes inside to a burrow, it goes out on the position of the other burrow and then both burrows disappear.
 * If the snake goes out of its territory, the game is over. The snake needs at least 10 food quantity to be fed.
 * If the snake goes outside of its territory or has eaten enough food, the game should end.
 */

public class Snake {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int size = Integer.parseInt(scan.nextLine());

        String[][] territory = new String[size][size];

        int snakeRowPosition = 0;
        int snakeColPosition = 0;

        for (int row = 0; row < size; row++) {
            String[] line = scan.nextLine().split("");

            for (int col = 0; col < size; col++) {
                territory[row][col] = line[col];

                if (line[col].equals("S")) {
                    snakeRowPosition = row;
                    snakeColPosition = col;
                }
            }
        }

            int foodEated = 0;

            boolean isSuccess = false;
            boolean isGameOver = false;

            do {
                if (isSuccess || isGameOver) {
                    break;
                }
                String command = scan.nextLine();

                switch (command) {
                    case "up":
                        territory[snakeRowPosition][snakeColPosition] = ".";
                        snakeRowPosition -= 1;
                        if (snakeRowPosition >= 0 && snakeRowPosition < size) {
                            if (territory[snakeRowPosition][snakeColPosition].equals("*")) {
                                foodEated++;
                                territory[snakeRowPosition][snakeColPosition] = ".";
                            } else if (territory[snakeRowPosition][snakeColPosition].equals("B")) {
                                territory[snakeRowPosition][snakeColPosition] = ".";
                                for (int rows = 0; rows < size; rows++) {
                                    for (int cols = 0; cols < size; cols++) {
                                        if (territory[rows][cols].equals("B")) {
                                            snakeRowPosition = rows;
                                            snakeColPosition = cols;
                                            territory[rows][cols] = "S";
                                        }
                                    }
                                }
                            }
                        } else {
                            isGameOver = true;
                        }
                        break;
                    case "down":
                        territory[snakeRowPosition][snakeColPosition] = ".";
                        snakeRowPosition += 1;
                        if (snakeRowPosition >= 0 && snakeRowPosition < size) {
                            if (territory[snakeRowPosition][snakeColPosition].equals("*")) {
                                foodEated++;
                                territory[snakeRowPosition][snakeColPosition] = ".";
                            } else if (territory[snakeRowPosition][snakeColPosition].equals("B")) {
                                territory[snakeRowPosition][snakeColPosition] = ".";
                                for (int rows = 0; rows < size; rows++) {
                                    for (int cols = 0; cols < size; cols++) {
                                        if (territory[rows][cols].equals("B")) {
                                            snakeRowPosition = rows;
                                            snakeColPosition = cols;
                                            territory[rows][cols] = "S";
                                        }
                                    }
                                }
                            }
                        } else {
                            isGameOver = true;
                        }
                        break;
                    case "left":
                        territory[snakeRowPosition][snakeColPosition] = ".";
                        snakeColPosition -= 1;
                        if (snakeRowPosition >= 0 && snakeRowPosition < size) {
                            if (territory[snakeRowPosition][snakeColPosition].equals("*")) {
                                foodEated++;
                                territory[snakeRowPosition][snakeColPosition] = ".";
                            } else if (territory[snakeRowPosition][snakeColPosition].equals("B")) {
                                territory[snakeRowPosition][snakeColPosition] = ".";
                                for (int rows = 0; rows < size; rows++) {
                                    for (int cols = 0; cols < size; cols++) {
                                        if (territory[rows][cols].equals("B")) {
                                            snakeRowPosition = rows;
                                            snakeColPosition = cols;
                                            territory[rows][cols] = "S";
                                        }
                                    }
                                }
                            }
                        } else {
                            isGameOver = true;
                        }
                        break;
                    case "right":
                        territory[snakeRowPosition][snakeColPosition] = ".";
                        snakeColPosition += 1;
                        if (snakeRowPosition >= 0 && snakeRowPosition < size) {
                            if (territory[snakeRowPosition][snakeColPosition].equals("*")) {
                                foodEated++;
                                territory[snakeRowPosition][snakeColPosition] = ".";
                            } else if (territory[snakeRowPosition][snakeColPosition].equals("B")) {
                                territory[snakeRowPosition][snakeColPosition] = ".";
                                for (int rows = 0; rows < size; rows++) {
                                    for (int cols = 0; cols < size; cols++) {
                                        if (territory[rows][cols].equals("B")) {
                                            snakeRowPosition = rows;
                                            snakeColPosition = cols;
                                            territory[rows][cols] = "S";
                                        }
                                    }
                                }
                            }
                        } else {
                            isGameOver = true;
                        }
                        break;
                }
                if (foodEated > 9) {
                    isSuccess = true;
                    territory[snakeRowPosition][snakeColPosition] = "S";
                }
            } while (!isSuccess);

            if (isSuccess) {
                System.out.println("You won! You fed the snake.");
                System.out.printf("Food eaten: %d%n", foodEated);

            } else {
                System.out.println("Game over!");
                System.out.printf("Food eaten: %d%n", foodEated);
            }

            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    System.out.print(territory[row][col]);
                }
                System.out.println();
            }

        }
    }
