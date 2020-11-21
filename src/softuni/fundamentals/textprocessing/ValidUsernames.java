package softuni.fundamentals.textprocessing;

import java.util.Scanner;

public class ValidUsernames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] userNames = scan.nextLine().split(", ");
        String output = "";

        for (int i = 0; i < userNames.length; i++) {
            if (userNameIsValid(userNames[i])) {
                System.out.println(userNames[i]);
            }
        }

    }

    private static Boolean userNameIsValid(String userName) {
        if (userName.length() < 3 || userName.length() > 16) {
            return false;
        }
        for (int i = 0; i < userName.length(); i++) {
            char symbol = userName.charAt(i);
            if (!Character.isLetterOrDigit(symbol) && symbol != '-' && symbol != '_') {
                return false;
            }
        }
        return true;
    }
}
