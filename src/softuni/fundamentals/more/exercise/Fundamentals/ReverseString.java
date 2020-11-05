package softuni.fundamentals.more.exercise.Fundamentals;

import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        String reversed = "";

        for (int i = input.length() - 1; i >= 0; i--) {
            char letter = input.charAt(i);
            reversed += letter;
        }
        System.out.println(reversed);


    }
}
