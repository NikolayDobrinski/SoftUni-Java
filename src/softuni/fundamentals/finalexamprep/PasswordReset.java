package softuni.fundamentals.finalexamprep;

import java.util.Scanner;

/**Description:
 * Write a password reset program that performs a series of commands upon a predefined string.
 */

public class PasswordReset {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String password = scan.nextLine();

        String input = scan.nextLine();

        while (!input.equals("Done")) {
            String[] command = input.split(" ");

            switch (command[0]) {
                case "TakeOdd":
                    String newPassword = "";
                    for (int i = 1; i < password.length(); i += 2) {
                        newPassword += password.charAt(i);
                    }
                    password = newPassword;
                    System.out.println(password);
                    break;
                case "Cut":
                    int index = Integer.parseInt(command[1]);
                    int length = Integer.parseInt(command[2]);

                    String firstPart = password.substring(0, index);
                    String secondPart = password.substring(index + length);
                    password = firstPart + secondPart;

                    System.out.println(password);
                    break;
                case "Substitute":
                    String subsSubstring = command[1];
                    String substitute = command[2];

                    if (password.contains(subsSubstring)) {
                        password = password.replaceAll(subsSubstring, substitute);
                        System.out.println(password);
                    }
                    else {
                        System.out.println("Nothing to replace!");
                    }
                    break;
            }
            input = scan.nextLine();
        }
        System.out.println("Your password is: " + password);
    }
}
