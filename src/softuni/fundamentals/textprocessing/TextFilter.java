package softuni.fundamentals.textprocessing;

import java.util.Scanner;

/**
 * Description: Program that takes a text and a string of banned words.
 * All words included in the ban list should be replaced with asterisks "*", equal to the word's length.
 */

public class TextFilter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] bannedWords = scan.nextLine().split(", ");
        String text = scan.nextLine();

        for (String bannedWord : bannedWords) {
            text = text.replace(bannedWord, repeat("*", bannedWord.length()));
        }
        System.out.println(text);

    }

    private static String repeat(String word, int count) {
        String[] repeatArr = new String[count];
        for (int i = 0; i < count; i++) {
            repeatArr[i] = word;
        }
        return String.join("", repeatArr);
    }
}
