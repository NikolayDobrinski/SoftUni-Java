package softuni.fundamentals.finalexamprep;

import java.util.Scanner;

/**Description:
 * You will receive a concealed message. After that, until the "Reveal" command is given,
 * you will be receiving strings with instructions for different operations that need to
 * be performed upon the concealed message in order to interpret it and reveal its true content.
 */

public class SecretChat {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String concealedMessage = scan.nextLine();

        String input = scan.nextLine();

        while (!input.equals("Reveal")) {
            String[] command = input.split(":\\|:");
            String commandName = command[0];

            switch (commandName) {
                case "InsertSpace":
                    int index = Integer.parseInt(command[1]);
                    String firstPart = concealedMessage.substring(0, index);
                    String secondPart = concealedMessage.substring(index);
                    concealedMessage = firstPart + " " + secondPart;
                    System.out.println(concealedMessage);
                    break;
                case "Reverse":
                    String substring = command[1];
                    if (concealedMessage.contains(substring)) {
                        int length = substring.length();
                        String first = concealedMessage.substring(0, concealedMessage.indexOf(substring));
                        String second = concealedMessage.substring(first.length() + length, concealedMessage.length());
                        String substringReversed = "";
                        for (int i = substring.length() - 1; i >= 0 ; i--) {
                            substringReversed += substring.charAt(i);
                        }
                        concealedMessage = first + second + substringReversed;
                        System.out.println(concealedMessage);
                    }
                    else {
                        System.out.println("error");
                    }
                    break;
                case "ChangeAll":
                    String subs = command[1];
                    String replacement = command[2];
                    if (concealedMessage.contains(subs)) {
                        concealedMessage = concealedMessage.replaceAll(subs, replacement);
                        System.out.println(concealedMessage);
                    }
                    break;
            }
            input = scan.nextLine();
        }
        System.out.println("You have a new text message: " + concealedMessage);
    }
}
