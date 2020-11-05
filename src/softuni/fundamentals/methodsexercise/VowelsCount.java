package softuni.fundamentals.methodsexercise;

import java.util.Scanner;

public class VowelsCount {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        int output = counterVowels(input);

        System.out.println(output);
    }

    private static int counterVowels(String word) {
        int counterVowels = 0;
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);

            if (letter == 'a' || letter == 'A' || letter == 'e' || letter == 'E' || letter == 'i'
                    || letter == 'I' || letter == 'o' || letter == 'O' || letter == 'u'
                    || letter == 'U' || letter == 'y' || letter == 'Y') {
                counterVowels++;
            }
        }
        return counterVowels;
    }
}
