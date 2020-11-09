package softuni.fundamentals.midexam;

import java.util.Scanner;

public class ListManipulator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] listNames = scan.nextLine().split(", ");
        int blacklistedNamedCounter = 0;
        int lostNamesCount = 0;

        String command = scan.nextLine();

        while (!command.equals("Report")) {
            String[] inputLine = command.split(" ");
            String currentCommand = inputLine[0];

            if (currentCommand.equals("Blacklist")) {
                String name = inputLine[1];
                int index = -1;

                for (int i = 0; i < listNames.length; i++) {
                    if (listNames[i].equals(name)) {
                        index = i;
                    }
                }
                    if (index != -1) {
                        System.out.printf("%s was blacklisted.%n", name);
                        listNames[index] = "Blacklisted";
                        blacklistedNamedCounter++;
                    } else {
                        System.out.printf("%s was not found.%n", name);
                    }
            } else if (currentCommand.equals("Error")) {
                int index = Integer.parseInt(inputLine[1]);
                String name = listNames[index];
                if (!listNames[index].equals("Blacklisted") && !listNames[index].equals("Lost")) {
                    listNames[index] = "Lost";
                    lostNamesCount++;
                    System.out.printf("%s was lost due to an error.%n", name);
                }

            } else if (currentCommand.equals("Change")) {
                int index = Integer.parseInt(inputLine[1]);
                String newName = inputLine[2];

                if (index >= 0 && index < listNames.length){
                    String currentName = listNames[index];
                    System.out.printf("%s changed his username to %s.%n", currentName, newName);
                    listNames[index] = newName;
                }

            }

            command = scan.nextLine();
        }


        System.out.printf("Blacklisted names: %d%n", blacklistedNamedCounter);
        System.out.printf("Lost names: %d%n", lostNamesCount);
        for (int i = 0; i < listNames.length; i++) {
            System.out.print(listNames[i] + " ");
        }

    }
}
