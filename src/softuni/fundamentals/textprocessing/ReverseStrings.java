package softuni.fundamentals.textprocessing;

import java.util.Scanner;

public class ReverseStrings {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String line = scan.nextLine();
        while (!line.equals("end")) {
            String wordToReverse = line;
            String reversed = "";

            for (int i = wordToReverse.length() - 1; i >= 0; i--) {
                reversed += wordToReverse.charAt(i);
            }
            System.out.printf("%s = %s%n", wordToReverse, reversed);
            line = scan.nextLine();
        }
    }
}
