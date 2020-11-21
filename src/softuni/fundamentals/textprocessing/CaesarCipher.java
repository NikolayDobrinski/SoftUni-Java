package softuni.fundamentals.textprocessing;

import java.util.Scanner;

/**
 * Program that returns an encrypted version of text.
 * Encrypts the text by shifting each character with three positions forward.
 */

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String inputText = scan.nextLine();
        for (char c : inputText.toCharArray()) {
            System.out.print((char) (c + 3));
        }
    }
}
