package softuni.fundamentals.textprocessing;

import java.util.Scanner;

public class RepeatStrings {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] words = scan.nextLine().split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            int wordLenght = word.length();
            for (int i = 0; i < wordLenght; i++) {
                result.append(word);
            }
        }
        System.out.println(result);


    }
}
