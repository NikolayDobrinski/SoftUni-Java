package softuni.fundamentals.arrays;

import java.util.Scanner;

public class ReverseArrayofStrings {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String string = scan.nextLine();

        String[] separatedString = string.split(" ");

        for (int i = 0; i < separatedString.length / 2; i++) {
            int last = separatedString.length - 1 - i;
            String temporary = separatedString[i];
            separatedString[i] = separatedString[last];
            separatedString[last] = temporary;
        }
        for (int i = 0; i < separatedString.length; i++) {
            System.out.print(separatedString[i] + " ");
        }

    }
}
