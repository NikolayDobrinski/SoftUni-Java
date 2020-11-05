package softuni.fundamentals.midexamprep;

import java.util.Scanner;

public class ArcheryTournament {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\|");
        int[] field = new int[input.length];
        for (int i = 0; i < field.length; i++) {
            field[i] = Integer.parseInt(input[i]);
        }
        int finalpoints = 0;

        String command = scan.nextLine();

        while (!command.equals("Game over")) {
            String[] currentCommand = command.split("@");
            String action = currentCommand[0];

            switch (action) {
                case "Shoot Left":
                    int startIndex = Integer.parseInt(currentCommand[1]);
                    int lenght = Integer.parseInt(currentCommand[2]);
                    if (startIndex >= 0 && startIndex <= field.length) {
                        int newIndex = startIndex - lenght;
                        while (newIndex < 0) {
                            newIndex += field.length;
                        }
                        if (field[newIndex] < 5) {
                            finalpoints += field[newIndex];
                            field[newIndex] = 0;
                        } else {
                            field[newIndex] -= 5;
                            finalpoints += 5;
                        }

                    }
                    break;
                case "Shoot Right":
                    int startInd = Integer.parseInt(currentCommand[1]);
                    int len = Integer.parseInt(currentCommand[2]);
                    if (startInd <= field.length && startInd >= 0) {
                        int newIndex = startInd + len;

                        while (newIndex >= field.length) {
                            newIndex -= field.length;
                        }
                        if (field[newIndex] < 5) {
                            finalpoints += field[newIndex];
                            field[newIndex] = 0;
                        } else {
                            field[newIndex] -= 5;
                            finalpoints += 5;
                        }
                    }
                    break;
                case "Reverse":
                    for (int i = 0; i < field.length / 2; i++) {
                        int oldValue = field[i];
                        field[i] = field[field.length - 1 - i];
                        field[field.length - 1 - i] = oldValue;
                    }
                    break;

            }
            command = scan.nextLine();
        }

        for (int i = 0; i < field.length; i++) {
            System.out.print(field[i]);
            if (i < field.length - 1) {
                System.out.print(" - ");
            }
        }
        System.out.println();
        System.out.printf("Iskren finished the archery tournament with %d points!", finalpoints);


    }
}
