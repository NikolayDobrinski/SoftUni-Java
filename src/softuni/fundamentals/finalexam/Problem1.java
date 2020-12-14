package softuni.fundamentals.finalexam;

import java.util.Scanner;

/**Description:
 * We get a string, which is a username that we have to change according to the 5 commands we will receive.
 * At the end of the program we have to show the username after the changes.
 */

public class Problem1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String userName = scan.nextLine();

        String input = scan.nextLine();

        while (!input.equals("Sign up")) {
            String[] command = input.split(" ");

            switch (command[0]) {
                case "Case":
                    String upperLower = command[1];
                    if (upperLower.equals("lower")) {
                        userName = userName.toLowerCase();
                        System.out.println(userName);
                    }
                    else {
                        userName = userName.toUpperCase();
                        System.out.println(userName);
                    }
                    break;
                case "Reverse":
                    int startIndex = Integer.parseInt(command[1]);
                    int endIndex = Integer.parseInt(command[2]);
                    if (startIndex >= 0 && startIndex < userName.length() && endIndex >=0 && endIndex < userName.length()) {

                        String substring = userName.substring(startIndex, endIndex + 1);
                        String reversed = "";
                        for (int i = substring.length() - 1; i >= 0; i--) {
                            reversed += substring.charAt(i);
                        }
                        System.out.println(reversed);
                    }
                    break;
                case "Cut":
                    String substringCut = command[1];
                    if (userName.contains(substringCut)) {
                        userName = userName.replace(substringCut, "");
                        System.out.println(userName);
                    }
                    else {
                        System.out.printf("The word %s doesn't contain %s.%n", userName, substringCut);
                    }
                    break;
                case "Replace":
                    String charToReplace = command[1];
                    userName = userName.replace(charToReplace, "*");
                    System.out.println(userName);
                    break;
                case "Check":
                    String charToCheck = command[1];
                    if (userName.contains(charToCheck)) {
                        System.out.println("Valid");
                    }
                    else {
                        System.out.printf("Your username must contain %s.%n", charToCheck);
                    }
                    break;
            }
            input = scan.nextLine();
        }
    }
}
