package softuni.fundamentals.finalexamprep;

import java.util.Scanner;

/**
 * Description: The input will be your raw activation key. Until the "Generate" command is given,
 * you will be receiving strings with instructions for different operations that need to be
 * performed upon the raw activation key.
 */

public class ActivationKeys {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        StringBuilder activationKey = new StringBuilder(scan.nextLine());

        String instructions = scan.nextLine();

        while (!instructions.equals("Generate")) {
            String[] input = instructions.split(">>>");
            String command = input[0];

            switch (command) {
                case "Contains":
                    String substring = input[1];
                    if (activationKey.indexOf(substring) != -1) {
                        System.out.printf("%s contains %s%n", activationKey, substring);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    String upperLower = input[1];
                    int startIndex = Integer.parseInt(input[2]);
                    int endIndex = Integer.parseInt(input[3]);

                    if (upperLower.equals("Upper")) {
                        String substringNeeded = activationKey.substring(startIndex, endIndex);
                        String newNeeded = substringNeeded.toUpperCase();
                        activationKey.replace(startIndex, endIndex, newNeeded);
                        System.out.println(activationKey);
                    } else if (upperLower.equals("Lower")) {
                        String substringNeeded = activationKey.substring(startIndex, endIndex);
                        String newNeeded = substringNeeded.toLowerCase();
                        activationKey.replace(startIndex, endIndex, newNeeded);
                        System.out.println(activationKey);
                    }
                    break;
                case "Slice":
                    int startInd = Integer.parseInt(input[1]);
                    int endInd = Integer.parseInt(input[2]);
                    activationKey.delete(startInd, endInd);
                    System.out.println(activationKey);
                    break;
            }

            instructions = scan.nextLine();
        }

        System.out.printf("Your activation key is: %s", activationKey);
    }
}
