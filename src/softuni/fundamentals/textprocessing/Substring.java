package softuni.fundamentals.textprocessing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Substring {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String forbiddenWord = scan.nextLine();
        String text = scan.nextLine();
        String result = text;

        int nextWordIndex = result.indexOf(forbiddenWord, 0);
        while (nextWordIndex != -1) {

            int currentIndex = 0;
            List<String> substrings = new ArrayList<>();

            while (nextWordIndex != -1) {
                substrings.add(result.substring(currentIndex, nextWordIndex));
                currentIndex = nextWordIndex + forbiddenWord.length();
                nextWordIndex = result.indexOf(forbiddenWord, currentIndex);
            }

            substrings.add(result.substring(currentIndex));
            result = String.join("", substrings);
            nextWordIndex = result.indexOf(forbiddenWord, 0);
        }
        System.out.println(result);

    }
}
