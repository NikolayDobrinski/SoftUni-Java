package softuni.fundamentals.textprocessing;

import java.util.Scanner;

/**
 * Description "String Explosion": Explosions are marked with ‘>’. Immediately after the mark, there will be an integer,
 * which signifies the strength of the explosion.
 * You should remove x characters (where x is the strength of the explosion), starting after the punch character (‘>’).
 * If you find another explosion mark (‘>’) while you’re deleting characters, you should add the strength to your
 * previous explosion. When all characters are processed, print the string without the deleted characters.
 */

public class StringExplosion {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        StringBuilder input = new StringBuilder(scan.nextLine());
        int strength = 0;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '>') {
                strength += Character.getNumericValue(input.charAt(i + 1));
            } else if (strength > 0 && input.charAt(i) != '>') {
                input.deleteCharAt(i);
                strength--;
                i--;
            }
        }
        System.out.println(input);
    }
}
