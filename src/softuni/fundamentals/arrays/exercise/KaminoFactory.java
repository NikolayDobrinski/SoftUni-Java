package softuni.fundamentals.arrays.exercise;

import java.util.Scanner;

public class KaminoFactory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int dnaLenght = Integer.parseInt(scan.nextLine());
        String command = scan.nextLine();

        int highestSum = 0;
        int lowestIndex = Integer.MAX_VALUE;
        int whileRotation = 0;

        int[] winner = new int[dnaLenght];
        int rotation = 1;

        while (!command.equals("Clone them!")) {
            // конвертираме от стринг масив в инт масив

            String[] input = command.split("!");
            int[] arr = new int[input.length];

            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(input[i]);
            }
            //изчисляваме сумата на текущото число
            int currentSum = 0;
            for (int m = 0; m < arr.length; m++) {
                currentSum += arr[m];
            }

            // проверяваме за поредни единици и техния индекс на започване
            int counter = 1;
            int index = -1;

            for (int i = 1; i < arr.length; i++) {
                index = i - 1;

                if (arr[i] == arr[i - 1]) {
                    counter++;
                    if (counter > 1 && index < lowestIndex) {

                        lowestIndex = index;
                        highestSum = currentSum;
                        whileRotation = rotation;

                        //презаписвам първото число с две единици в winner масива
                        for (int j = 0; j < winner.length; j++) {
                            winner[j] = arr[j];
                        }
                        break;
                    }
                } else {
                    counter = 1;
                }
            }
            rotation++;
            command = scan.nextLine();
        }
        System.out.printf("Best DNA sample %d with sum: %d.%n", whileRotation, highestSum);
        for (int i = 0; i < winner.length; i++) {
            System.out.print(winner[i] + " ");
        }


    }
}