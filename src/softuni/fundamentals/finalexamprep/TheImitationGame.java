package softuni.fundamentals.finalexamprep;

import java.util.Scanner;

/**Description:
 * You will receive the encrypted message. After that, until the "Decode" command is given,
 * you will be receiving strings with instructions for different operations that need to be
 * performed upon the concealed message to interpret it and reveal its true content.
 * There are several types of instructions, split by '|'
 * Move {number of letters}
 * Insert {index} {value}
 * ChangeAll {substring} {replacement}
 */

public class TheImitationGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String encryptedMessage = scan.nextLine();

        String input = scan.nextLine();

        while (!input.equals("Decode")) {
            String[] command = input.split("\\|");
            String currentCommand = command[0];

            switch (currentCommand) {
                case "Move":
                    int numberLetters = Integer.parseInt(command[1]);
                    String substring = encryptedMessage.substring(0, numberLetters);
                    encryptedMessage = encryptedMessage.replace(substring, "");
                    encryptedMessage = encryptedMessage.concat(substring);

                    break;
                case "Insert":
                    int index = Integer.parseInt(command[1]);
                    String value = command[2];

                    String partOne = encryptedMessage.substring(0, index);
                    String partTwo = encryptedMessage.substring(index);

                    encryptedMessage = partOne + value + partTwo;
                    break;
                case "ChangeAll":
                    String substringToChange = command[1];
                    String replacement = command[2];

                    encryptedMessage = encryptedMessage.replace(substringToChange, replacement);
                    break;
            }
            input = scan.nextLine();
        }

        System.out.println("The decrypted message is: " + encryptedMessage);
    }
}
