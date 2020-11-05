package softuni.fundamentals.methodsexercise;

import java.util.Scanner;

public class PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String command = scan.nextLine();

        while (!command.equals("END")) {
            String current = command;
            int lenght = current.length();

            if (current.charAt(0) == current.charAt(lenght - 1)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
            command = scan.nextLine();
        }

    }
}
