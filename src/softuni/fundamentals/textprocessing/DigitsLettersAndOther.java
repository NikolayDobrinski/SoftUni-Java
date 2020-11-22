package softuni.fundamentals.textprocessing;

import java.util.Scanner;

/**
 * Description: Program that receives a single string and on the first line prints all the digits,
 * on the second – all the letters, and on the third – all the other characters.
 */

public class DigitsLettersAndOther {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String inputString = scan.nextLine();
        StringBuilder digits = new StringBuilder();
        StringBuilder letters = new StringBuilder();
        StringBuilder characters = new StringBuilder();

        for (int i = 0; i < inputString.length(); i++) {
            if (Character.isDigit(inputString.charAt(i))) {
                digits.append(inputString.charAt(i));
            } else if (Character.isLetter(inputString.charAt(i))) {
                letters.append(inputString.charAt(i));
            } else {
                characters.append(inputString.charAt(i));
            }
        }
        System.out.println(digits);
        System.out.println(letters);
        System.out.println(characters);
    }
}
